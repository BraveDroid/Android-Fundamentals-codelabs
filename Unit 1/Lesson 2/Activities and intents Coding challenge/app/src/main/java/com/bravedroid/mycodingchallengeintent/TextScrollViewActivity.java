package com.bravedroid.mycodingchallengeintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TextScrollViewActivity extends AppCompatActivity {
    public static final String EXTRA_FIRST_TEXT = "com.bravedroid.android.mycodingchallengeintent.extra.FIRST_TEXT";
    public static final String EXTRA_SECOND_TEXT = "com.bravedroid.android.mycodingchallengeintent.extra.SECOND_TEXT";
    public static final String EXTRA_THIRD_TEXT = "com.bravedroid.android.mycodingchallengeintent.extra.THIRD_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_scroll_view);
        TextView mText = findViewById(R.id.textView);
        Intent intent = getIntent();
        String text1 = intent.getStringExtra(EXTRA_FIRST_TEXT);
        String text2 = intent.getStringExtra(EXTRA_SECOND_TEXT);
        String text3 = intent.getStringExtra(EXTRA_THIRD_TEXT);

        if (text1 != (null)) {
            mText.setText(R.string.article_text_1);
        } else if ((text2 != (null))) {
            mText.setText(R.string.article_text_2);
        } else if (text3 != (null)) {
            mText.setText(R.string.article_text_3);
        }
    }
}
