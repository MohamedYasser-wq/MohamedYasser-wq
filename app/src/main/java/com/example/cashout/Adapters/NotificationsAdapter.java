package com.example.cashout.Adapters;

import static com.example.cashout.helpers.DateUtils.formatDate;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cashout.Data.Models.Notification;
import com.example.cashout.databinding.NotificationBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NotificationsAdapter extends ListAdapter<Notification, NotificationsAdapter.NotificationVH> {

    private final NotificationClick notificationClick;

    public NotificationsAdapter(NotificationClick notificationClick) {
        super(DIFF_CALLBACK);
        this.notificationClick = notificationClick;
    }

    public static class NotificationVH extends RecyclerView.ViewHolder {
        private final NotificationBinding bind;

        public NotificationVH(NotificationBinding bind) {
            super(bind.getRoot());
            this.bind = bind;
        }

        public void bind(Notification notification, NotificationClick notificationClick) {
            bind.notificationTitle.setText(notification.getTitle());
            bind.notificationDate.setText(formatDate(notification.getDate()));
            bind.getRoot().setOnClickListener(n -> notificationClick.onClick(notification));
        }

        public static NotificationVH from(ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            NotificationBinding binding = NotificationBinding.inflate(layoutInflater, parent, false);
            return new NotificationVH(binding);
        }
    }

    private static final DiffUtil.ItemCallback<Notification> DIFF_CALLBACK = new DiffUtil.ItemCallback<Notification>() {
        @Override
        public boolean areItemsTheSame(@NonNull Notification oldItem, @NonNull Notification newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Notification oldItem, @NonNull Notification newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public NotificationVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NotificationVH.from(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationVH holder, int position) {
        holder.bind(getItem(position), notificationClick);
    }

}

