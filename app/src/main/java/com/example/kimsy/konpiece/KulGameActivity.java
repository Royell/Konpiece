package com.example.kimsy.konpiece;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class KulGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kul_game);

        setContentView(new GameView(this));
    }

    class GameView extends View {
        int width, height;
        int x, y;
        int dx, dy;
        int cw, ch;
        int counter;
        Bitmap character, resize;

        public GameView(Context context){
            super(context);

            Display display=((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

            width=display.getWidth();
            height=display.getHeight();
            x=100;
            y=100;
            dx=width/6;
            dy=height/6;

            character= BitmapFactory.decodeResource(getResources(), R.drawable.walking1);
            resize = Bitmap.createScaledBitmap(character, 100, 150, true);

            cw=resize.getWidth()/6;
            ch=resize.getHeight()/6;

            mHandler.sendEmptyMessageDelayed(0, 10);
        }

       public void onDraw(Canvas canvas){
            x+=dx;
            y+=dy;

            if (x < cw || x > width - cw) dx = 0;
            if (x < ch || x > height - ch) dy = 0;

            //counter++;
            //int n=counter%20/10;
            canvas.drawBitmap(resize, x-cw, y-ch, null);
        }

        Handler mHandler=new Handler(){
          public void handleMessage(Message msg){
              invalidate();
              mHandler.sendEmptyMessageDelayed(0, 1000);
          }
        };


    }
}
