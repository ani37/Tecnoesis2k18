package com.example.tenx.test272.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tenx.test272.R;

import com.example.tenx.test272.Utils.EventsUtils;

public class CustomSparkAdapter extends RecyclerView.Adapter<CustomSparkAdapter.CustomViewHolder>{

    private Context context;


    public CustomSparkAdapter(Context context) {
        this.context = context;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgModule;


         CustomViewHolder(View itemView) {
            super(itemView);
            imgModule = itemView.findViewById(R.id.iv_spark_image);

        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_spark_gallery, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.imgModule.setImageResource(EventsUtils.getSparkEventList().get(position).getmImgRes());


    }

    @Override
    public int getItemCount() {
        return EventsUtils.getSparkEventList().size();
    }
}
