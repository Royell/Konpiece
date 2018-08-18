package com.example.kimsy.konpiece;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    Button[] buttons=new Button[12];
    Drawable[] drawables=new Drawable[12];
    int[] touched={5, 5};
    int num=0;
    ImageView[] hearts=new ImageView[3];
    int life=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        drawables[0]=ContextCompat.getDrawable(this, R.drawable.bed1);
        drawables[1]=ContextCompat.getDrawable(this, R.drawable.bed2);
        drawables[2]=ContextCompat.getDrawable(this, R.drawable.cutlery1);
        drawables[3]=ContextCompat.getDrawable(this, R.drawable.cutlery2);
        drawables[4]=ContextCompat.getDrawable(this, R.drawable.makeup1);
        drawables[5]=ContextCompat.getDrawable(this, R.drawable.makeup2);
        drawables[6]=ContextCompat.getDrawable(this, R.drawable.slipper1);
        drawables[7]=ContextCompat.getDrawable(this, R.drawable.slipper2);
        drawables[8]=ContextCompat.getDrawable(this, R.drawable.study1);
        drawables[9]=ContextCompat.getDrawable(this, R.drawable.study2);
        drawables[10]=ContextCompat.getDrawable(this, R.drawable.tooth1);
        drawables[11]=ContextCompat.getDrawable(this, R.drawable.tooth2);


        buttons[0]=(Button)findViewById(R.id.button0);
        buttons[1]=(Button)findViewById(R.id.button1);
        buttons[2]=(Button)findViewById(R.id.button2);
        buttons[3]=(Button)findViewById(R.id.button3);
        buttons[4]=(Button)findViewById(R.id.button4);
        buttons[5]=(Button)findViewById(R.id.button5);
        buttons[6]=(Button)findViewById(R.id.button6);
        buttons[7]=(Button)findViewById(R.id.button7);
        buttons[8]=(Button)findViewById(R.id.button8);
        buttons[9]=(Button)findViewById(R.id.button9);
        buttons[10]=(Button)findViewById(R.id.button10);
        buttons[11]=(Button)findViewById(R.id.button11);

        hearts[0]=(ImageView)findViewById(R.id.heart1);
        hearts[1]=(ImageView)findViewById(R.id.heart2);
        hearts[2]=(ImageView)findViewById(R.id.heart3);

        for(int i=0; i<12; i++){
           final int whichTouched=i;
            buttons[i].setBackground(drawables[i]);
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(num==0){
                        touched[0]=whichTouched;
                        num++;
                    }
                    else {
                        touched[1] =whichTouched;
                        checkRight();
                        num=0;
                    }
                }
            });
        }



    }

    public int checkRight(){
        Log.i("checkRight", "test");
        int m_return=0x2345;

        if(touched[0]-touched[1]==1){
            if(touched[0]%2==1)
            m_return=1;
            Log.i("checkRight", "t00est");

        }
        else if(touched[0]-touched[1]==-1){
            if(touched[1]%2==1)
            m_return=1;
        }
        else {
            m_return = 0;

            life--;
            hearts[life].setVisibility(View.INVISIBLE);

            if(life==0)
                gameover();
        }

        if(m_return==1){
            buttons[touched[0]].setVisibility(View.INVISIBLE);
            buttons[touched[0]].setClickable(false);
            buttons[touched[1]].setVisibility(View.INVISIBLE);
            buttons[touched[1]].setClickable(false);

        }

        touched[0]=5;
        touched[1]=5;

        return m_return;
    }

    public void gameover(){

        TextView txt_gameover=findViewById(R.id.txt_gameover);
        txt_gameover.bringToFront();
        txt_gameover.setVisibility(View.VISIBLE);
    }

}
