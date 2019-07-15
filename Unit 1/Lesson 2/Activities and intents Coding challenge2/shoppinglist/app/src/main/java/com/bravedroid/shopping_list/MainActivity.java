package com.bravedroid.shopping_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addItem(View view) {
        Intent allListShoppingIntent = new Intent(this, CommonShoppingList.class);
        startActivity(allListShoppingIntent);
    }
}
