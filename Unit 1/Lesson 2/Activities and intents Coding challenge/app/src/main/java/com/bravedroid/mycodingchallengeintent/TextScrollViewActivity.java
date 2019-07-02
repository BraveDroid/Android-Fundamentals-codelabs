package com.bravedroid.mycodingchallengeintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TextScrollViewActivity extends AppCompatActivity {
    public static final String EXTRA_FIRST_TEXT = "com.bravedroid.android.mycodingchallengeintent.extra.FIRST_TEXT";
    public static final String EXTRA_SECOND_TEXT = "com.bravedroid.android.mycodingchallengeintent.extra.SECOND_TEXT";
    public static final String EXTRA_THIRD_TEXT = "com.bravedroid.android.mycodingchallengeintent.extra.THIRD_TEXT";
    private static final int NOT_FOUND = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_scroll_view);
        TextView mText = findViewById(R.id.textView);
        Intent intent = getIntent();
        int idText1 = intent.getIntExtra(EXTRA_FIRST_TEXT, NOT_FOUND);
        int idText2 = intent.getIntExtra(EXTRA_SECOND_TEXT, NOT_FOUND);
        int idText3 = intent.getIntExtra(EXTRA_THIRD_TEXT, NOT_FOUND);

        if (idText1 != NOT_FOUND) {
            mText.setText(R.string.article_text_1);
        } else if ((idText2 != NOT_FOUND)) {
            mText.setText(R.string.article_text_2);
        } else if (idText3 != NOT_FOUND) {
            mText.setText(R.string.article_text_3);
        }
    }
}
