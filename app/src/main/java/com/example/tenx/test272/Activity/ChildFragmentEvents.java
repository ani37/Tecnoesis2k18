package com.example.tenx.test272.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tenx.test272.Adapters.CustomEventsAdapter;
import com.example.tenx.test272.R;

public class ChildFragmentEvents extends Fragment{

    RecyclerView mRecycler;
    CustomEventsAdapter adapter;
    TextView tvRegHack, tvRegCcomp,tvNitsHack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_home, container, false);

        tvRegCcomp = view.findViewById(R.id.tv_ccomp_register);
        tvRegHack = view.findViewById(R.id.tv_hack_register);
        tvNitsHack = view.findViewById(R.id.tv_reg_nits_hack);
        tvRegHack.setOnClickListener(getListener("https://www.hackerearth.com/sprints/nits-hacks-20-4/"));
        tvRegCcomp.setOnClickListener(getListener("http://hck.re/nh201"));
        tvNitsHack.setOnClickListener(getListener("https://goo.gl/forms/ce62ITqn4hGiVOqq1"));
        return view;
    }

    public View.OnClickListener getListener(final String url){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        };
        return listener;
    }
}