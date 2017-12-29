package com.example.tobias.masterapp;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {


    private TextView signInText;
    private ImageButton backButton;
    private ImageButton signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signInText = (TextView) findViewById(R.id.signInText);
        backButton = (ImageButton) findViewById(R.id.back);
        signUpButton = (ImageButton) findViewById(R.id.signUpButton);

        setupWindowAnimations();
    }


    public void goToSignIn(View view) {
        Intent signInIntent = new Intent(SignUpActivity.this, LoginActivity.class);
        transitionTo(signInIntent);
    }

    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.RIGHT);
        slide.setDuration(1000);
        getWindow().setReenterTransition(slide);
        getWindow().setExitTransition(slide);
    }


    @SuppressWarnings("unchecked") void transitionTo(Intent i) {
        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(i, transitionActivityOptions.toBundle());
    }
}
