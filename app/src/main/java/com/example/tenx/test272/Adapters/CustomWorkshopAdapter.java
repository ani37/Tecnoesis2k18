package com.example.tenx.test272.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tenx.test272.R;

import com.example.tenx.test272.Utils.EventsUtils;
import com.example.tenx.test272.Utils.Models.Workshop;

import java.util.List;

public class CustomWorkshopAdapter extends RecyclerView.Adapter<CustomWorkshopAdapter.CustomViewHolder>{

    private Context mCtx;
    private List<Workshop> mList;


    public CustomWorkshopAdapter(Context context) {
        this.mCtx = context;
        mList = EventsUtils.getWorkshopList();
    }

     class CustomViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivPoster;
        private TextView tvSummary;
        private CardView cvContainer;

         CustomViewHolder(View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.iv_workshop_poster);
            tvSummary = itemView.findViewById(R.id.tv_workshop_summary);
            cvContainer = itemView.findViewById(R.id.container_workshop_item);

        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mCtx).inflate(R.layout.viewholder_workshop_item, parent, false);


        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.ivPoster.setImageDrawable(mCtx.getDrawable(mList.get(position).getImgRes()));
        holder.tvSummary.setText(mList.get(position).getmSummary());
        holder.cvContainer.setOnClickListener(getListener(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public View.OnClickListener getListener(final int position){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                //main view
                final View mainView = LayoutInflater.from(mCtx).inflate(R.layout.dialog_layout, null);
                //building the dialog
                builder.setView(mainView);
                builder.setCancelable(true);
                final AlertDialog dialog = builder.create();

                ImageView img = mainView.findViewById(R.id.dialog_event_image);

                //setting the image
                img.setImageDrawable(mCtx.getDrawable(mList.get(position).getImgRes()));

                dialog.show();
                ImageView share = mainView.findViewById(R.id.dialog_icon_share);
                share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        String shareBody = "http://tecnoesis.in/";
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Tecnoesis");
                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                        mCtx.startActivity(Intent.createChooser(shareIntent, "share via"));
                    }
                });

                //implement web_icon clicks and reminder taps
                ImageView web = mainView.findViewById(R.id.dialog_icon_web);
                ImageView closeBtn = mainView.findViewById(R.id.dialog_icon_close);
                web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /*String eventUrl = "http://tecnoesis.in";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(mList.get(position).getmRegUrl()));
                        mCtx.startActivity(i);*/
                        Toast.makeText(mCtx, "You clicked on position " + position, Toast.LENGTH_SHORT).show();
                    }
                });

                //close button
                closeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

            }
        };
        return listener;
    }
}
