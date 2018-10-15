package com.example.tenx.test272.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tenx.test272.Activity.FragmentModules;
import com.example.tenx.test272.Activity.ModulesActivity;
import com.example.tenx.test272.R;

import com.example.tenx.test272.Utils.EventsUtils;
import com.example.tenx.test272.Utils.Models.ModuleEvent;

import java.util.List;

public class CustomModulesTagsAdapter extends RecyclerView.Adapter<CustomModulesTagsAdapter.CustomViewHolder>{

    private Context context;
    private List<ModuleEvent> mList;
    int pos;


    public CustomModulesTagsAdapter(Context context, List<ModuleEvent> list, int pos) {
        this.context = context;
        this.mList = list;
        this.pos = pos;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgModule;
        private TextView tvModule;
        private LinearLayout container;

        public CustomViewHolder(View itemView) {
            super(itemView);
            /*imgModule = itemView.findViewById(R.id.moduleImage);*/
            tvModule = itemView.findViewById(R.id.moduleDesc);
            container = itemView.findViewById(R.id.container_mod);
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
        String currentEvent = mList.get(position).getName();
        holder.tvModule.setText(currentEvent);
        final int key = position;

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ModulesActivity.class);
                intent.putExtra("key", key);
                intent.putExtra("pos", pos);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
