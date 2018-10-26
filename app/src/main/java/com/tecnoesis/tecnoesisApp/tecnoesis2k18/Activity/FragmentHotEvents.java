package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters.CustomGroupingAdapter;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class FragmentHotEvents extends Fragment{

    RecyclerView recyclerView;
    CustomGroupingAdapter adapter;
    FloatingActionButton fab;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot_events, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_whatshot);

        adapter = new CustomGroupingAdapter(getActivity());
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = adapter.getItemViewType(position);
                switch (type){
                    case 0://header
                        return 2;
                    case 1:
                        return 1;
                        default:
                            return 1;
                }
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }




}
