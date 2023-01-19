package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn;
    TextView tv;
    boolean cross = true;
    int[][] pos = {
            {R.id.button1, R.id.button2, R.id.button3}, {R.id.button4, R.id.button5, R.id.button6}, {R.id.button7, R.id.button8, R.id.button9},
            {R.id.button1, R.id.button4, R.id.button7},{R.id.button2, R.id.button5, R.id.button8},{R.id.button3, R.id.button6, R.id.button9},
            {R.id.button1, R.id.button5, R.id.button9},{R.id.button3,R.id.button5, R.id.button7}
    };
    int apos[] = new int[5];
    int aid = 0;
    int acount = 0;
    int bpos[] = new int[5];
    int bid = 0;
    int bcount = 0;
    int allcount = 0;
    boolean won = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (ImageButton) findViewById(R.id.button1);
        btn2 = (ImageButton) findViewById(R.id.button2);
        btn3 = (ImageButton) findViewById(R.id.button3);
        btn4 = (ImageButton) findViewById(R.id.button4);
        btn5 = (ImageButton) findViewById(R.id.button5);
        btn6 = (ImageButton) findViewById(R.id.button6);
        btn7 = (ImageButton) findViewById(R.id.button7);
        btn8 = (ImageButton) findViewById(R.id.button8);
        btn9 = (ImageButton) findViewById(R.id.button9);
        tv = (TextView) findViewById(R.id.textView);
    }

    public void button(View view) {
        int id = view.getId();
        btn = (ImageButton) findViewById(id);
        btn.setEnabled(false);
        if(cross) {
            apos[aid] = id;
            aid++;
            btn.setImageResource(R.drawable.cross);
            cross = false;
            for(int i=0; i<8; i++){
                for(int j=0; j<3; j++){
                    for(int k=0; k <5; k++){
                        if(pos[i][j] == apos[k]){
                            acount ++;
                        }
                        if(acount == 3){
                            btn1.setEnabled(false);
                            btn2.setEnabled(false);
                            btn3.setEnabled(false);
                            btn4.setEnabled(false);
                            btn5.setEnabled(false);
                            btn6.setEnabled(false);
                            btn7.setEnabled(false);
                            btn8.setEnabled(false);
                            btn9.setEnabled(false);
                            tv.setText("Cross Won");
                            won = true;
                        }
                    }
                }
                acount = 0;
            }
        }
        else{
            bpos[bid] = id;
            bid++;
            btn.setImageResource(R.drawable.circle);
            cross = true;
            for(int i=0; i<8; i++){
                for(int j=0; j<3; j++){
                    for(int k=0; k <5; k++){
                        if(pos[i][j] == bpos[k]){
                            bcount ++;
                        }
                        if(bcount == 3){
                            btn1.setEnabled(false);
                            btn2.setEnabled(false);
                            btn3.setEnabled(false);
                            btn4.setEnabled(false);
                            btn5.setEnabled(false);
                            btn6.setEnabled(false);
                            btn7.setEnabled(false);
                            btn8.setEnabled(false);
                            btn9.setEnabled(false);
                            tv.setText("Circle Won");
                            won = true;
                        }
                    }
                }
                bcount = 0;
            }
        }
        allcount ++;
        if(allcount == 9 && won == false){
            tv.setText("Draw");
        }
    }

    public void restart(View view) {
        cross = true;
        Arrays.fill(apos, 0);
        Arrays.fill(bpos, 0);
        aid = 0;
        acount = 0;
        bid = 0;
        bcount = 0;
        btn1.setImageResource(0);
        btn2.setImageResource(0);
        btn3.setImageResource(0);
        btn4.setImageResource(0);
        btn5.setImageResource(0);
        btn6.setImageResource(0);
        btn7.setImageResource(0);
        btn8.setImageResource(0);
        btn9.setImageResource(0);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        allcount = 0;
        won = false;
        tv.setText("");
    }
}