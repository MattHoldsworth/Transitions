package com.example.matt.transitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;

public class MainActivity extends AppCompatActivity {

    ViewGroup mattysLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mattysLayout = findViewById(R.id.mattysLayout);

        mattysLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        moveButton();
                        return true;
                    }
                }
        );
    }

    public void moveButton(){

        View mattysButton = findViewById(R.id.mattysButton);

        TransitionManager.beginDelayedTransition(mattysLayout);

        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        mattysButton.setLayoutParams(positionRules);

        ViewGroup.LayoutParams sizeRules = mattysButton.getLayoutParams();
        sizeRules.width = 400;
        sizeRules.height = 300;
        mattysButton.setLayoutParams(sizeRules);
    }
}
