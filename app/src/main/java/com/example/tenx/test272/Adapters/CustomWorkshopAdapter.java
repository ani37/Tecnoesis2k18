package com.example.tenx.test272.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tenx.test272.R;

import com.example.tenx.test272.Utils.EventsUtils;
import com.example.tenx.test272.Utils.Models.Workshop;

import java.util.List;

public class CustomWorkshopAdapter extends RecyclerView.Adapter<CustomWorkshopAdapter.CustomViewHolder>{

    private Context context;
    private List<Workshop> mList;


    public CustomWorkshopAdapter(Context context) {
        this.context = context;
        mList = EventsUtils.getWorkshopList();
    }

     class CustomViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivPoster;
        private TextView tvSummary;
        private Button btnRegister;

         CustomViewHolder(View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.iv_workshop_poster);
            tvSummary = itemView.findViewById(R.id.tv_workshop_summary);
            btnRegister = itemView.findViewById(R.id.btn_workshop_register);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_workshop_item, parent, false);


        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.ivPoster.setImageDrawable(context.getDrawable(mList.get(position).getImgRes()));
        holder.tvSummary.setText(mList.get(position).getmSummary());
        holder.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "This should take you to reg form!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
