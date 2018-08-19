package com.example.tenx.test272.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tenx.test272.R;

public class FragmentEvents extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_home, container, false);

        ImageView testImg = view.findViewById(R.id.events_image1);
        Glide.with(getActivity()).load("https://qph.fs.quoracdn.net/main-qimg-6ea86a6833b541d713f8a15b49877083-c").into(testImg);

        return view;
    }
}