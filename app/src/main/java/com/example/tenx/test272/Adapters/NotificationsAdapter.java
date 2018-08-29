package com.example.tenx.test272.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tenx.test272.DatabaseElements.Models.Notification;
import com.example.tenx.test272.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.CustomViewholder>{

    private Context context;
    private List<Notification> mList;

    public NotificationsAdapter(Context context) {
        this.context = context;
        /*this.mList = mList;*/
    }

    @NonNull
    @Override
    public CustomViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_notification_item, parent, false);
        return new CustomViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewholder holder, int position) {
        holder.tvMessage.setText(mList.get(position).getmText());
        long issueTimeMillis = mList.get(position).getmIssueTime();
        Date date = new Date(issueTimeMillis);
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat dfDay = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat dfDisplayHrMin = new SimpleDateFormat("h:mm:aa", Locale.getDefault());
        SimpleDateFormat displayFullTime = new SimpleDateFormat("EEE MMM d,  h:mm:aa", Locale.getDefault());
        int dayDiff = Integer.parseInt(dfDay.format(currentTime)) -  Integer.parseInt(dfDay.format(date));


        long diff = currentTime - issueTimeMillis;
        long min = diff/(60*1000);
        long hrs = diff/(60*60*1000);
        String timeOutput = "";
       if(dayDiff == 0){
           if(min==0){
               timeOutput = "just now";
           }else if(min<60 && min>0){
               if(min==1){
                   timeOutput = min+" minute ago";
               }else{
                   timeOutput = min+" minutes ago";
               }
           }else if(hrs>0){
               if(hrs == 1){
                   timeOutput = hrs+" hour ago";
               }else{
                   timeOutput = hrs+" hours ago";
               }
           }
       }
       else{
           if(dayDiff == 1){
               timeOutput = "yesterday , "+dfDisplayHrMin.format(date);
           }else {
           timeOutput = ""+displayFullTime.format(date);
           }
       }

        holder.tvTime.setText(timeOutput);

    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    class CustomViewholder extends RecyclerView.ViewHolder{

        private TextView tvMessage, tvTime;
        private CustomViewholder(View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.notification_textview);
            tvTime = itemView.findViewById(R.id.tv_notif_time);
        }
    }

    public  void insertAndRefresh(final List<Notification> list){
        if(mList==null){
            this.mList = list;
        }else{
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mList.size();
                }

                @Override
                public int getNewListSize() {
                    return list.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return mList.get(oldItemPosition).equals(list.get(newItemPosition));
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    return mList.get(oldItemPosition).getmText().equals(list.get(newItemPosition).getmText());
                }
            });
            mList.clear();
            mList.addAll(list);
            result.dispatchUpdatesTo(this);
        }
    }
}
