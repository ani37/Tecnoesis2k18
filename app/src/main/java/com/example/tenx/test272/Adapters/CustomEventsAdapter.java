package com.example.tenx.test272.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tenx.test272.R;

import com.example.tenx.test272.Utils.EventsUtils;

public class CustomEventsAdapter extends RecyclerView.Adapter<CustomEventsAdapter.CustomViewHolder>{

    private Context context;


    public CustomEventsAdapter(Context context) {
        this.context = context;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageEvent;


         CustomViewHolder(View itemView) {
            super(itemView);
            mImageEvent = itemView.findViewById(R.id.vh_events_image);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_events_listitem, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.mImageEvent.setImageResource(EventsUtils.getEventsList().get(position).getmImgRes());

    }

    @Override
    public int getItemCount() {
        return EventsUtils.getEventsList().size();
    }
}
