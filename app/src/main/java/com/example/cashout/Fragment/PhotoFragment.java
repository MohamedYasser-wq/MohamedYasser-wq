package com.example.cashout.Fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cashout.Data.SharedPrefrence;
import com.example.cashout.R;
import com.example.cashout.Api.UploadImageTask;
import com.example.cashout.databinding.FragmentPhotoBinding;

public class PhotoFragment extends Fragment implements UploadImageTask.OnUploadCompleteListener {

    private FragmentPhotoBinding binding;
    private NavController navController;
    private String imagePath;

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int CAMERA_REQUEST = 100;
    private static final String TAG = "PhotoFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPhotoBinding.inflate(inflater, container, false);
        navController = Navigation.findNavController(container);

        binding.loadingPhotoText.setText(" ");
        binding.BtnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.loadingPhotoText.setVisibility(View.GONE);
                openImagePicker();
            }
        });

        binding.BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_photoFragment_to_registerFragment);
            }
        });

        return binding.getRoot();
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == PICK_IMAGE_REQUEST && data.getData() != null) {
                Uri imageUri = data.getData();
                SharedPrefrence.setImageUri(String.valueOf(imageUri));
                imagePath = getPathFromUri(imageUri);
                binding.CapturedImage.setImageURI(imageUri);
                binding.photoLoading.setVisibility(View.VISIBLE);
                binding.loadingPhotoText.setVisibility(View.VISIBLE);
                Log.d(TAG, "Image path: " + imagePath);
                SharedPrefrence.setImageUri(imagePath);
                new UploadImageTask(imagePath, this).execute();

            } else if (requestCode == CAMERA_REQUEST && data.getExtras() != null) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                binding.CapturedImage.setImageBitmap(photo);
                // Save the captured image to a file and get the file path
                imagePath = saveBitmapToFile(photo);
                Log.d(TAG, "Image path: " + imagePath);
                binding.photoLoading.setVisibility(View.VISIBLE);
                binding.loadingPhotoText.setVisibility(View.VISIBLE);
                new UploadImageTask(imagePath, this).execute();
            }
        }
    }

    private String getPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            String path = cursor.getString(columnIndex);
            cursor.close();
            return path;
        }
        return null;
    }

    private String saveBitmapToFile(Bitmap bitmap) {

        return null;
    }

    @Override
    public void onUploadComplete(String firstName, String secondName, String nationalId, String address, String birthdate, String gender) {
        // Handle the data received from the server

        SharedPrefrence.setNational_Id(nationalId);
        SharedPrefrence.setAddress(address);
        SharedPrefrence.setBirthDay(birthdate);
        SharedPrefrence.setGender(gender);
        SharedPrefrence.setFirstName(firstName);
        SharedPrefrence.setSecondName(secondName);

        Log.d(TAG, "First Name: " + firstName);
        Log.d(TAG, "Second Name: " + secondName);
        Log.d(TAG, "National ID: " + nationalId);
        Log.d(TAG, "Address: " + address);
        Log.d(TAG, "Birthdate: " + birthdate);
        Log.d(TAG, "Gender: " + gender);
        navController.navigate(R.id.action_photoFragment_to_loadingFragment);
        // Display the data in your UI or take any other necessary actions
    }

    @Override
    public void onUploadFailed(String errorMessage) {
        String messageShowed = "";
        if(errorMessage.equals("WrongImage")){
            messageShowed = "Image is bad, please try again.";
        }else if(errorMessage.equals("NetError")){
            messageShowed = "Network Error! upload it again";
        }
        else{
            messageShowed = "Unexpected Error";
        }
        binding.photoLoading.setVisibility(View.GONE);
        binding.loadingPhotoText.setText(messageShowed);
        Log.e(TAG, "Image upload failed");
    }
}
