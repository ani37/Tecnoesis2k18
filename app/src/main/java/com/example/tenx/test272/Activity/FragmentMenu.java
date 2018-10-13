package com.example.tenx.test272.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tenx.test272.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentMenu extends Fragment {

    Button btnLogout;
    FirebaseAuth mAuth;
    private static final String TAG = "MenuActivity";
    //imageViews
    CircleImageView civ_profile;
    TextView tvName, tvSponsors, tvTeam;
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInOptions gso;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        //auth
        mAuth = FirebaseAuth.getInstance();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(Objects.requireNonNull(getActivity()), gso);
        //civ
        civ_profile = view.findViewById(R.id.civ_profile_image);

        GoogleSignInAccount user = GoogleSignIn.getLastSignedInAccount(Objects.requireNonNull(getActivity()));

        assert user != null;
        Glide.with(Objects.requireNonNull(getActivity())).load(user.getPhotoUrl()).into(civ_profile);


        tvName = view.findViewById(R.id.tv_profile_name);
        String print = user.getDisplayName();
        tvName.setText(print);


        btnLogout = view.findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                mGoogleSignInClient.signOut().addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        updateUI();
                    }
                });
            }
        });


        tvSponsors = view.findViewById(R.id.tv_sponsors);
        tvSponsors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Updating soon!", Toast.LENGTH_SHORT).show();
            }
        });
        tvTeam = view.findViewById(R.id.tv_team);
        tvTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Updating soon!", Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }


    public void updateUI(){
        Intent accountIntent = new Intent(getActivity(), LoginActivity.class);
        startActivity(accountIntent);
    }
}
