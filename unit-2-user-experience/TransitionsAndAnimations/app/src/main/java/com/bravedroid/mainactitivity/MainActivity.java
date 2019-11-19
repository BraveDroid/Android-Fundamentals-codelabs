package com.bravedroid.mainactitivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends BaseClass {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView redBlock= findViewById(R.id.red_Block);
        ImageView blueBlock= findViewById(R.id.blue_block);
        ImageView yellowBlock= findViewById(R.id.yellow_block);
        ImageView androidBlock= findViewById(R.id.android_block);

        explodeTransition(this,redBlock);
        fadeTransition(this,blueBlock);
        rotateView(yellowBlock);
        switchAnimation(androidBlock,blueBlock,new Intent(
                this, SecondActivity.class),this);
    }
}
