package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity;

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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters.CustomWorkshopAdapter;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;

public class FragmentWorkshops extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workshops, container, false);


        //setting up the recycler
        RecyclerView recycler = view.findViewById(R.id.recycler_workshops_list);
        CustomWorkshopAdapter adapter = new CustomWorkshopAdapter(getActivity());
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(adapter);

        return view;
    }
}
