package com.example.tenx.test272.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tenx.test272.ListItems.EventItem;
import com.example.tenx.test272.ListItems.HeaderItem;
import com.example.tenx.test272.ListItems.ListItem;
import com.example.tenx.test272.R;
import com.example.tenx.test272.Utils.EventsUtils;

import java.util.List;

public class CustomGroupingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mCtx;
    private List<ListItem> mList;

    public CustomGroupingAdapter(Context mCtx) {
        this.mCtx = mCtx;
        mList = EventsUtils.getData();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        if(i == ListItem.TYPE_EVENT){
            view = inflater.inflate(R.layout.viewholder_container_event_item, viewGroup, false);
            return new EventViewHolder(view);
        }
        if(i== ListItem.TYPE_HEADER){
            view = inflater.inflate(R.layout.viewholder_container_header_item, viewGroup, false);
            return new HeaderViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder customViewHolder, int i) {
        int type = getItemViewType(i);
        if(type == ListItem.TYPE_HEADER){
            ((HeaderViewHolder) customViewHolder).tvHeader.setText(((HeaderItem) mList.get(i)).getName());
        }else{
            ImageView img = ((EventViewHolder) customViewHolder).ivImage;
            String url = ((EventItem) mList.get(i)).getUrl();
            img.setBackgroundResource(((EventItem) mList.get(i)).getImgRes());
            img.setOnClickListener(getListener(((EventItem) mList.get(i)).getImgRes()));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class EventViewHolder extends RecyclerView.ViewHolder{
        ImageView ivImage;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_event_image);
        }
    }
    class HeaderViewHolder extends RecyclerView.ViewHolder{
        TextView tvHeader;
        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.tv_header_title);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType();
    }


        public View.OnClickListener getListener(final int imgRes){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                //main view
                final View mainView = LayoutInflater.from(mCtx).inflate(R.layout.dialog_layout, null);
                Rect displayRectangle = new Rect();
                Activity activity = (Activity) mCtx;
                Window window = activity.getWindow();
                window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);
                mainView.setMinimumWidth((int)(displayRectangle.width() * 0.9f));
                mainView.setMinimumHeight((int)(displayRectangle.height() * 0.9f));
                //building the dialog
                builder.setView(mainView);
                builder.setCancelable(true);
                final AlertDialog dialog = builder.create();

                ImageView img = mainView.findViewById(R.id.dialog_event_image);
                img.setBackgroundResource(imgRes);
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
                        String eventUrl = "http://tecnoesis.in";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(eventUrl));
                        mCtx.startActivity(i);
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

