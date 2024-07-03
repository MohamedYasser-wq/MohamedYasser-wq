package com.example.cashout.Api;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UploadImageTask extends AsyncTask<String, Void, String> {

    private static final String TAG = "UploadImageTask";
    private static final String SERVER_URL = "https://6f44-196-154-206-148.ngrok-free.app/cashout";  // Update this with your actual URL
    private static final MediaType MEDIA_TYPE_JPG = MediaType.parse("image/jpeg");

    private String imagePath;
    private OnUploadCompleteListener listener;

    public UploadImageTask(String imagePath, OnUploadCompleteListener listener) {
        this.imagePath = imagePath;
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {
        File imageFile = new File(imagePath);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", imageFile.getName(),
                        RequestBody.create(MEDIA_TYPE_JPG, imageFile))
                .build();

        Request request = new Request.Builder()
                .url(SERVER_URL)
                .post(requestBody)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        } catch (IOException e) {
            Log.e(TAG, "Upload failed", e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // Handle the response here
        if (result != null) {
            Log.d(TAG, "Response: " + result);

            try {
                JSONObject jsonResponse = new JSONObject(result);

                JSONArray dataArray = jsonResponse.getJSONArray("ocr_data");

                String firstName = dataArray.getString(0);
                String secondName = dataArray.getString(1);
                String nationalId = dataArray.getString(2);
                String address = dataArray.getString(3);
                String birthdate = dataArray.getString(4);
                String gender = dataArray.getString(5);

                // Notify listener
                listener.onUploadComplete(firstName, secondName, nationalId, address, birthdate, gender);
            } catch (JSONException e) {
                Log.e(TAG, "JSON parsing error", e);
            }
        } else {
            Log.e(TAG, "Failed to upload image");
            listener.onUploadFailed();
        }
    }

    public interface OnUploadCompleteListener {
        void onUploadComplete(String firstName, String secondName, String nationalId, String address, String birthdate, String gender);
        void onUploadFailed();
    }
}
