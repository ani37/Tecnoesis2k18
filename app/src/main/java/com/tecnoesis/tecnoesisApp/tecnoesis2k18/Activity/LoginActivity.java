package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    private static int WELCOME_TIMEOUT = 4000;
    private static final int RC_SIGN_IN = 1100;
    public static final int NO_LOGIN = 1;
    public static final String LOGIN_KEY = "key";
    CallbackManager mCallbackManager;
    private static final String TAG = "GOOGLELOG";
    FirebaseAuth mAuth;
    ImageView imgView, smallLogo;
    Button btnLogin, btnNoLogin;
    LottieAnimationView lottieAnim;
    private GoogleSignInClient mGoogleSignInClient;


    GoogleSignInOptions gso;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult called");
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                assert account != null;
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                showAnimation("stop");
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //check if user is signed on and update Ui accordingly
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        imgView = findViewById(R.id.iv_loader_image);
        btnLogin = findViewById(R.id.btn_login);
        smallLogo = findViewById(R.id.iv_logo_small);
        imgView.setVisibility(View.VISIBLE);
        btnLogin.setVisibility(View.GONE);
        btnNoLogin = findViewById(R.id.btn_no_login);
        btnNoLogin.setVisibility(View.GONE);

        btnNoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.putExtra(LOGIN_KEY, NO_LOGIN);
                startActivity(intent);
            }
        });


        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //lottie animation view
        lottieAnim = findViewById(R.id.lottie_loading);

        //auth
        mAuth = FirebaseAuth.getInstance();
        mCallbackManager = CallbackManager.Factory.create();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sign in with google
                showAnimation("start");
                signInGoogle();

     /*           showAnimation("start");
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile"));
                LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d(TAG, "facebook:onSuccess:" + loginResult);
                        handleFacebookAccessToken(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {
                        showAnimation("stop");
                        Log.d(TAG, "facebook:onCancel");
                        // ...
                    }

                    @Override
                    public void onError(FacebookException error) {
                        showAnimation("stop");
                        Log.d(TAG, "facebook:onError", error);
                        // ...
                    }
                });*/
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgView.setVisibility(View.GONE);
                btnLogin.setVisibility(View.VISIBLE);
                btnNoLogin.setVisibility(View.VISIBLE);
                smallLogo.setVisibility(View.VISIBLE);
            }
        },WELCOME_TIMEOUT);

    }
    /*private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            showAnimation("stop");
                        }

                        // ...
                    }
                });
    }*/

    public void updateUI(FirebaseUser user){
        Log.d(TAG, "updateUI called");
        if(user != null){
            Intent accountIntent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(accountIntent);
            finish();
            showAnimation("stop");
        }
    }

    public void showAnimation(String s) {
        if (s.equals("start")) {
            btnLogin.setVisibility(View.GONE);
            lottieAnim.setVisibility(View.VISIBLE);
            lottieAnim.playAnimation();
            btnNoLogin.setVisibility(View.GONE);
        }
        if (s.equals("stop")) {
            btnLogin.setVisibility(View.VISIBLE);
            btnNoLogin.setVisibility(View.VISIBLE);
            lottieAnim.setVisibility(View.GONE);
            lottieAnim.pauseAnimation();
        }
    }

    private void signInGoogle() {
        Log.d(TAG, "signInGoogle called");
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }



    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(LoginActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Login Failure", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

}






