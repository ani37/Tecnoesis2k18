package com.example.tenx.test272.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tenx.test272.Adapters.CustomEventResultsAdapter;
import com.example.tenx.test272.ListItems.ResultListitem;
import com.example.tenx.test272.ListItems.ResultsHeader;
import com.example.tenx.test272.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChildFragmentOthersResults extends Fragment{
    ImageView mBack;
    TextView mHeader;
    RecyclerView recycler;
    CustomEventResultsAdapter adapter;
    FirebaseFirestore mDb = FirebaseFirestore.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_child_event_results, container, false);
        mBack = view.findViewById(R.id.iv_back);

        mHeader = view.findViewById(R.id.header_title_results);
        mHeader.setText("Results!");
        //initialize the adapter
        recycler = view.findViewById(R.id.recycler_robotron_events);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setting up the custom back btn
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
        //setting up the adapter
        adapter = new CustomEventResultsAdapter(getActivity());
        adapter.setTextGravityAndSize(15, Gravity.CENTER_VERTICAL);
        //setting custom grid
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
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);


        CollectionReference mRef = mDb.collection("EventResults").document("others").collection("events");

        mRef.addSnapshotListener(MetadataChanges.INCLUDE, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if(queryDocumentSnapshots != null){
                    if(!adapter.getList().isEmpty()){
                        adapter.clearList();
                        adapter.notifyDataSetChanged();
                    }
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for(DocumentSnapshot snap : list){
                            String eventname = snap.getId();
                            fetchData(snap, eventname);
                    }
                }
            }
        });
    }

    public void fetchData(DocumentSnapshot documentSnapshot, String eventName){
        assert documentSnapshot != null;
        Map<String,Object> map = documentSnapshot.getData();
        assert map != null;
        for(Map.Entry<String, Object> entry : map.entrySet()){
            Log.d("testrobotron", entry.getKey());
            adapter.insertItemAndRefresh(new ResultsHeader(entry.getKey().toUpperCase(), eventName));
            ArrayList<String> data = (ArrayList<String>) entry.getValue();
            for(String s : data){
                Log.d("testrobotron", s);
                adapter.insertItemAndRefresh(new ResultListitem(s));
            }
        }
    }

    public void goBack(){
        android.support.v4.app.FragmentManager manager = getFragmentManager();
        assert manager != null;
        android.support.v4.app.FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in, R.anim.slide_out);
        ft.replace(R.id.container_notif_frame, new FragmentNotificationFrame()).addToBackStack(null);
        ft.commit();
    }


}
