package com.bravedroid.shopping_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CommonShoppingList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_shopping_list);
    }

    public void buildList(View view) {
        Intent myListShoppingIntent = new Intent(this, MainActivity.class);
        startActivity(myListShoppingIntent);
    }
}
