package com.game.covid_19propagation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;


public class CircleView extends View {
    private Paint paint;
    private boolean Yflag = true ,Xflag = true;
    public CircleView(Context context) {
        super(context);
    init(null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);

    }

    private void init(@Nullable AttributeSet set){

        paint  = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        paint.setColor(Color.RED);
       canvas.drawCircle(20,20,20,paint);
        // canvas.drawColor(Color.RED);
    }


    public void walker(float posiX, float posiY, float BorderX, float BorderY){
        float x = posiX,y = posiY;



        if(Xflag){
            x++;
            if(BorderX < x) Xflag = false;
        }
        if(!Xflag){
            x--;
            if(x < 0) Xflag = true;
        }
        if(Yflag){
            y++;
            if(BorderY < y) Yflag = false;
        }
        if (!Yflag) {
            y--;
            if (y < 0) Yflag = true;
        }
        Log.d("MainActivity","x : "+x+"Xmax = "+BorderX+" Xflag :"+Xflag+" y : "+y+" Ymax : "+BorderY);
        this.setX(x);
        this.setY(y);
    }
}
