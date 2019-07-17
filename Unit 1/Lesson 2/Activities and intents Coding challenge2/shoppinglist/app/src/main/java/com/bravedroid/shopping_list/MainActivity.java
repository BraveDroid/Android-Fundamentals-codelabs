package com.bravedroid.shopping_list;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String RESULT = "result";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int COMMON_SHOPPING_LIST_ACTIVITY_REQUEST_CODE = 1;
    private static final String MY_SHOPPING_LIST_KEY = "savedElementsList";
    private ArrayList<String> savedElementsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.myListShopping);
        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        if (savedInstanceState != null) {
            ArrayList<String> myShoppingList = savedInstanceState.getStringArrayList(MY_SHOPPING_LIST_KEY);
            if (myShoppingList != null) {
                for (String item : myShoppingList) {
                    Log.d(LOG_TAG, "*************" + item + "************");
                    if (savedElementsList.size() < 10) {
                        if (!savedElementsList.contains(item)) {
                            TextView tv = new TextView(this);
                            tv.setLayoutParams(lparams);
                            createTextView(linearLayout, tv, item);
                            savedElementsList.add(item);
                        }
                    } else {
                        Toast toast = Toast.makeText(this, "YOU HAVE TO SAVE ONLY 10 ITEMS", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        }
    }

    public void onAddItemButtonClick(View view) {
        Intent allListShoppingIntent = new Intent(this, CommonShoppingList.class);
        startActivityForResult(allListShoppingIntent, COMMON_SHOPPING_LIST_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LinearLayout linearLayout = findViewById(R.id.myListShopping);
        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    String result = data.getStringExtra(RESULT);
                    if (savedElementsList.size() < 10) {
                        if (!savedElementsList.contains(result)) {
                            TextView tv = new TextView(this);
                            tv.setLayoutParams(lparams);
                            createTextView(linearLayout, tv, result);
                            savedElementsList.add(result);
                        }
                    } else {
                        Toast toast = Toast.makeText(this, "YOU HAVE TO SAVE ONLY 10 ITEMS", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        }

    }

    private void createTextView(LinearLayout linearLayout, TextView tv, String text) {
        tv.setTextSize(20.0f);
        tv.setTextColor(Color.RED);
        tv.setAllCaps(true);
        tv.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        tv.setText(text);
        linearLayout.addView(tv);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (savedElementsList.size() > 0) {
            outState.putStringArrayList(MY_SHOPPING_LIST_KEY, savedElementsList);
        }
    }
}
