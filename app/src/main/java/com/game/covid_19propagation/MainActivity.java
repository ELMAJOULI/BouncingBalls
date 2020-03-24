package com.game.covid_19propagation;

import android.os.Handler;
import android.util.ArraySet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.game.covid_19propagation.view.CircleView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private float BorderY,BorderX;

    private ArrayList<CircleView> circleViewSet;
    private ConstraintLayout frame_id;
    private static int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         circleViewSet = new ArrayList<>();
         circleViewSet.add((CircleView) findViewById(R.id.circleView1));
         circleViewSet.add((CircleView) findViewById(R.id.circleView2));
         circleViewSet.add((CircleView) findViewById(R.id.circleView3));
         circleViewSet.add((CircleView) findViewById(R.id.circleView4));
         circleViewSet.add((CircleView) findViewById(R.id.circleView5));
         circleViewSet.add((CircleView) findViewById(R.id.circleView6));
         circleViewSet.add((CircleView) findViewById(R.id.circleView7));
         circleViewSet.add((CircleView) findViewById(R.id.circleView8));
         circleViewSet.add((CircleView) findViewById(R.id.circleView9));
         circleViewSet.add((CircleView) findViewById(R.id.circleView10));
         circleViewSet.add((CircleView) findViewById(R.id.circleView11));
         circleViewSet.add((CircleView) findViewById(R.id.circleView12));
         circleViewSet.add((CircleView) findViewById(R.id.circleView13));

        init();
        frame_id = (ConstraintLayout) findViewById(R.id.frame_id);

    }


    public void onClickMove(final View view) {
        BorderY = frame_id.getHeight();
        BorderX = frame_id.getWidth();
      final Handler handler1 = new Handler();
        handler1.post(new Runnable() {
            CircleView c1 = circleViewSet.get(0);
            CircleView c2 = circleViewSet.get(1);
            CircleView c3 = circleViewSet.get(2);
            CircleView c4 = circleViewSet.get(3);
            @Override
            public void run() {
                c1.walker(c1.getX(),c1.getY(),BorderX,BorderY);
                c2.walker(c2.getX(),c2.getY(),BorderX,BorderY);
                c3.walker(c3.getX(),c3.getY(),BorderX,BorderY);
                c4.walker(c4.getX(),c4.getY(),BorderX,BorderY);
                handler1.postDelayed(this,1);
            }
        });



    }

    private void startMoving(){

    }
    private void init(){
        Random rx = new Random();
        Random ry = new Random();
        for (CircleView c : circleViewSet) {
            Log.d("MainActivity", "init: rx = "+rx.nextInt()+" ry = "+ry.nextInt());
            c.setX(rx.nextInt(701)+1);
            c.setY(ry.nextInt(1201)+1);
        }
    }
}
