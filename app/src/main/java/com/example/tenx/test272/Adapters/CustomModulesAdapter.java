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

public class CustomModulesAdapter extends RecyclerView.Adapter<CustomModulesAdapter.CustomViewHolder>{

    private Context context;


    public CustomModulesAdapter(Context context) {
        this.context = context;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgModule;
        private TextView tvModule;

        public CustomViewHolder(View itemView) {
            super(itemView);
            imgModule = itemView.findViewById(R.id.moduleImage);
            tvModule = itemView.findViewById(R.id.moduleDesc);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_modules_item, parent, false);


        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.imgModule.setImageResource(EventsUtils.modules_list[position]);
        holder.tvModule.setText("This is a test summary");

    }

    @Override
    public int getItemCount() {
        return EventsUtils.modules_list.length;
    }
}
