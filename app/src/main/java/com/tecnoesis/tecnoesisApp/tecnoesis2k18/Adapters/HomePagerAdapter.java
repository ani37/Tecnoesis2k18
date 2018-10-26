package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Utils.EventsUtils;

public class HomePagerAdapter extends PagerAdapter{
    private Context context;
    private ImageView imgView;

    public HomePagerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.slide, container, false);
        imgView = view.findViewById(R.id.home_slide_img);
        Glide.with(context).load(EventsUtils.home_imageUrl[position]).apply(new RequestOptions().centerCrop()).into(imgView);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return EventsUtils.home_imageUrl.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }


}
