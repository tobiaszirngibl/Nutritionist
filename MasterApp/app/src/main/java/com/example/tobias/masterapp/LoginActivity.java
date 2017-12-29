package com.example.tobias.masterapp;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tobias.masterapp.Wizard.Wizard_Step1;

public class LoginActivity extends AppCompatActivity {

    private ImageButton signIn;
    private TextView signUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signIn = (ImageButton) findViewById(R.id.signIn);
        signUpText = (TextView) findViewById(R.id.signUpText);

        setupWindowAnimations();
    }


    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setReenterTransition(fade);
        getWindow().setExitTransition(fade);
    }


    public void goToSignUp(View view) {
        Intent signUpIntent = new Intent(LoginActivity.this, SignUpActivity.class);
        transitionTo(signUpIntent);
    }

    public void buttonLogin(View view) {
        Intent wizardIntent = new Intent(LoginActivity.this, Wizard_Step1.class);
        transitionTo(wizardIntent);
    }

    @SuppressWarnings("unchecked") void transitionTo(Intent i) {
        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(i, transitionActivityOptions.toBundle());
    }
}
