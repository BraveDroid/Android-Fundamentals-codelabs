package com.bravedroid.mycodingchallengeintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.bravedroid.mycodingchallengeintent.TextScrollViewActivity.EXTRA_FIRST_TEXT;
import static com.bravedroid.mycodingchallengeintent.TextScrollViewActivity.EXTRA_SECOND_TEXT;
import static com.bravedroid.mycodingchallengeintent.TextScrollViewActivity.EXTRA_THIRD_TEXT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showFirstText(View view) {
        Intent intent1 = new Intent(this, TextScrollViewActivity.class);
        intent1.putExtra(EXTRA_FIRST_TEXT, getResources().getString(R.string.article_text_1));
        startActivity(intent1);
    }

    public void showSecondTxt(View view) {
        Intent intent2 = new Intent(this, TextScrollViewActivity.class);
        intent2.putExtra(EXTRA_SECOND_TEXT,getResources().getString( R.string.article_text_2));
        startActivity(intent2);
    }

    public void showThirdText(View view) {
        Intent intent3 = new Intent(this, TextScrollViewActivity.class);
        intent3.putExtra(EXTRA_THIRD_TEXT, getResources().getString(R.string.article_text_3));
        startActivity(intent3);
    }
}
