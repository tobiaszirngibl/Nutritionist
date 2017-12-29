package com.example.tobias.masterapp.Wizard;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import com.example.tobias.masterapp.LoginActivity;
import com.example.tobias.masterapp.R;
import com.example.tobias.masterapp.SignUpActivity;
import com.example.tobias.masterapp.TransitionHelper;

public class Wizard_Step1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard__step1);
        setupWindowAnimations();
    }


    public void goToStep2(View view) {
        Intent step2 = new Intent(Wizard_Step1.this, Wizard_Step3.class);
        transitionTo(step2);

    }

    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.LEFT);
        slide.setDuration(1000);

        Fade fade = new Fade();
        fade.setDuration(1000);

        getWindow().setReenterTransition(fade);
        getWindow().setEnterTransition(fade);

        getWindow().setExitTransition(slide);
    }


    @SuppressWarnings("unchecked") void transitionTo(Intent i) {
        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(i, transitionActivityOptions.toBundle());
    }
}
