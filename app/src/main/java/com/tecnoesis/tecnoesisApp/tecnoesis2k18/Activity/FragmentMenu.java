package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentMenu extends Fragment {

    Button btnLogout;
    FirebaseAuth mAuth;
    //database
    FirebaseFirestore db;
    boolean clicked = false;
    PackageManager packageManager;
    String currentuser;
    FloatingActionButton fab;
    TextView point,nitish_t,ani_t,mairing_t,khusboo_t,sponsers, tvPolicy;
    final ScaleAnimation growAnim = new ScaleAnimation(1.0f, 1.15f, 1.0f, 1.15f);
    final ScaleAnimation shrinkAnim = new ScaleAnimation(1.15f, 0, 1.15f, 0);
    //tag
    private static final String TAG = "MenuActivity";
    //imageViews
    CircleImageView civ_profile,nitish,ani,khusboo,mairing;

    TextView tvName, tvpoint, tvTeam,team;
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInOptions gso;
    public void addUser(){

        Map<String,Object> user = new HashMap<>();
        user.put("scanDone", "0");
        user.put("Time", "0:0");
        db.collection("users").document(currentuser)
                .collection("Events").document("Roboart").set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                });
        db.collection("users").document(currentuser).collection("Events")
                .document("Robosoccer").set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                });

        db.collection("users").document(currentuser)
                .collection("Events").document("Robowar").set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                });
        db.collection("users").document(currentuser).collection("Events")
                .document("Sumowar").set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                });

        db.collection("users").document(currentuser)
                .collection("Events").document("Terrain Treader").set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                });
        db.collection("users").document(currentuser)
                .collection("Events").document("Robobuild").set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                });
        //v-warz
        db.collection("users").document(currentuser).collection("Events")
                .document("CSGO").set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                });
        db.collection("users").document(currentuser).collection("Events")
                .document("Cod4").set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                });

        db.collection("users").document(currentuser)
                .collection("Events").document("Fifa18").set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                });
        db.collection("users").document(currentuser).collection("Events")
                .document("PUBG").set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                });
        //ARCHINOVA
        db.collection("users").document(currentuser)
                .collection("Events").document("Archinova").set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                });

        Map<String,Integer> score = new HashMap<>();
        score.put("points", 0);
        db.collection("users").document(currentuser).collection("Scorecard")
                .document("score").set(score)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                });
    }
    private void checkIfUserAlreadyExitsOrCreateOne(){
        DocumentReference docRef = db.collection("users").document(currentuser).collection("Events").document("Roboart");
            try {
                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot documentSnapshot = task.getResult();
                        assert documentSnapshot != null;
                        Log.e(TAG, String.valueOf(documentSnapshot));
                        if (!documentSnapshot.exists()){
                            addUser();
                            Log.e(TAG, "not Exits.........");
                        }else{

                            Log.e(TAG,"Exits.........");
                        }
                    }
                });
            } catch (Exception e){
                e.printStackTrace();
            }

    }
    public void updateData( String scanContent){
        final String s=scanContent;

        db.collection("users").document(currentuser).collection("Events")
                .document(scanContent).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    assert document != null;
                    if (document.exists()) {
                        Map<String,Object> map = document.getData();
                        assert map != null;
                        if(map.get("scanDone").equals("0")){
                            String currentDateTime = DateFormat.getDateTimeInstance().format(new Date());
                            db.collection("users").document(currentuser).collection("Events")
                                    .document(s)
                                    .update("scanDone", "1",
                                            "Time",currentDateTime
                                    )
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(getActivity(),"Great you have earn a point!" ,Toast.LENGTH_SHORT).show();
                                            Toast.makeText(getActivity(),"Welcome to "+s+ "!",Toast.LENGTH_SHORT).show();

                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getActivity(),"Error updating ur score!" ,Toast.LENGTH_SHORT).show();
                                            Toast.makeText(getActivity(),"scan again!",Toast.LENGTH_SHORT).show();

                                        }
                                    });
                            updatePoints();
                            Toast.makeText(getActivity()," score updated!" ,Toast.LENGTH_SHORT).show();

                        }   else Toast.makeText(getActivity(),"You have Already earned a point for this Event" ,Toast.LENGTH_SHORT).show();

                    }  else {
                        Toast.makeText(getActivity(),"Please scan a valid entry!" ,Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(getActivity(),"Try Again!" ,Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    public void updatePoints(){


        try {
            db.collection("users").document(currentuser).collection("Events")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                int c=0;
                                for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                    Map<String,Object> map = document.getData();
                                    if(map.get("scanDone").equals("1")){
                                        c++;
                                    }
                                }
                                String s="QR SCORE : "+c;
                                point.setText(s);
                                db.collection("users").document(currentuser).collection("Scorecard")
                                        .document("score")
                                        .update("points", c)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {

                                                Log.d(TAG, "onSuccess: scoreUpdated");
                                            }
                                        });

                            } else {
                                Log.w(TAG, "Error getting documents.", task.getException());
                            }
                        }
                    });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        fab = view.findViewById(R.id.scanner_bar);

        //scanner +database
        db = FirebaseFirestore.getInstance();
        point= view.findViewById(R.id.point);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Attend more events to earn goodies!", Toast.LENGTH_SHORT).show();
            }
        });

        if(HomeActivity.loginResult != 1){
            point.setVisibility(View.VISIBLE);
            fab.setVisibility(View.VISIBLE);

            //auth
            mAuth = FirebaseAuth.getInstance();
            gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
            mGoogleSignInClient = GoogleSignIn.getClient(Objects.requireNonNull(getActivity()), gso);


            packageManager = Objects.requireNonNull(getActivity()).getPackageManager();
            currentuser = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
            checkIfUserAlreadyExitsOrCreateOne();
            updatePoints();
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startQRScanner();

                }
            });

            //civ
            civ_profile = view.findViewById(R.id.civ_profile_image);

            GoogleSignInAccount user = GoogleSignIn.getLastSignedInAccount(Objects.requireNonNull(getActivity()));
            if (user != null){
                Glide.with(Objects.requireNonNull(getActivity())).load(user.getPhotoUrl()).into(civ_profile);
                tvName = view.findViewById(R.id.tv_profile_name);
                String print = user.getDisplayName();
                String h="Hello,\n"+print;
                tvName.setText(h);
            }

        }else {
            point.setVisibility(View.GONE);
            fab.setVisibility(View.GONE);
        }
        btnLogout = view.findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(HomeActivity.loginResult != 1){
                   mAuth.signOut();
                   mGoogleSignInClient.signOut().addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           updateUI();
                       }
                   });
               }else {
                   updateUI();
               }
            }
        });

        //policy
        tvPolicy = view.findViewById(R.id.tv_policy);
        tvPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PolicyActivity.class);
                startActivity(intent);
            }
        });



        //point tv


        //developers
        team = view.findViewById(R.id.tog_team);
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent = new Intent(getActivity(), ActivityTeam.class);
             startActivity(intent);


            }
        });
        sponsers = view.findViewById(R.id.tv_sponsors);
        sponsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"To be updated soon!",Toast.LENGTH_SHORT).show();
            }
        });








        return view;
    }


    public void updateUI(){
        Intent accountIntent = new Intent(getActivity(), LoginActivity.class);
        startActivity(accountIntent);
    }
    private void startQRScanner() {
        new IntentIntegrator(this.getActivity());
        IntentIntegrator.forSupportFragment(this).initiateScan();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanningResult != null) {
            if (scanningResult.getContents() != null) {
                String scanContent = scanningResult.getContents();
                Log.d(TAG, scanContent);
                updateData(scanContent);

            }
        }
        else{
            Toast.makeText(getActivity(),"Nothing scanned",Toast.LENGTH_SHORT).show();
        }
    }



}
