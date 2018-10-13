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

public class CustomModulesAdapter extends RecyclerView.Adapter<CustomModulesAdapter.CustomViewHolder>{

    private Context context;


    public CustomModulesAdapter(Context context) {
        this.context = context;
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
        String currentEvent = EventsUtils.getModulesNames().get(position);
        holder.tvModule.setText(currentEvent);
        final int key;
        if(position == 0){
            key = FragmentModules.KEY_ROBOTRON;
        }else if(position == 1){
            key = FragmentModules.KEY_SHOWCASE;
        }else if(position == 2){
            key = FragmentModules.KEY_AMAZERS;
        }
        else if(position == 3){
            key = FragmentModules.KEY_CONFERENZA;
        }
        else if(position == 4){
            key = FragmentModules.KEY_CYBERWARP;
        }
        else if(position == 5){
            key = FragmentModules.KEY_VWARZ;
        }
        else if(position == 6){
            key = FragmentModules.KEY_SMARKCITY;
        }
        else if(position == 7){
            key = FragmentModules.KEY_MYNDSNARE;
        }
        else if(position == 8){
            key = FragmentModules.KEY_EMPRESSARIO;
        }
        else if(position == 9){
            key = FragmentModules.KEY_SCHOOLGENIUS;
        }
        else if(position == 10){
            key = FragmentModules.KEY_ASME;
        }
        else{
            key = -1;
        }

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ModulesActivity.class);
                intent.putExtra("key", key);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return EventsUtils.getModulesNames().size();
    }
}
