package com.funcgames.app;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class MainActivity extends Activity{
	
	LinearLayout layOut1, layOut2, layOut3, layOut4;
	LinearLayout layOut5, layOut6, layOut7;
	
	HorizontalScrollView sView1;
	HorizontalScrollView sView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        sView1 = (HorizontalScrollView)findViewById(R.id.scroll1);
        sView2 = (HorizontalScrollView)findViewById(R.id.scroll2);
        
        

        
        layOut1 = (LinearLayout)findViewById(R.id.layout1);
        layOut2 = (LinearLayout)findViewById(R.id.layout2);
        layOut3 = (LinearLayout)findViewById(R.id.layout3);
        layOut4 = (LinearLayout)findViewById(R.id.layout4);
        layOut5 = (LinearLayout)findViewById(R.id.layout5);
        layOut6 = (LinearLayout)findViewById(R.id.layout6);
        layOut7 = (LinearLayout)findViewById(R.id.layout7);
        
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y; 
        int width1 = (width * 17)/20;
        
        LinearLayout.LayoutParams gameParams = 
                new LinearLayout.LayoutParams(
                    width1, 
                    LinearLayout.LayoutParams.MATCH_PARENT);
        
        
        layOut1.setLayoutParams(gameParams);
        layOut2.setLayoutParams(gameParams);
        layOut3.setLayoutParams(gameParams);
        layOut4.setLayoutParams(gameParams);
        layOut5.setLayoutParams(gameParams);
        layOut6.setLayoutParams(gameParams);
        layOut7.setLayoutParams(gameParams);
    }

	
}
