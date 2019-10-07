package com.bravedroid.shopping_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CommonShoppingList extends AppCompatActivity {
    private static final String LOG_TAG = CommonShoppingList.class.getSimpleName();
    private static final int[] BUTTONS = {
            R.id.beans, R.id.milk, R.id.bread, R.id.cheese,
            R.id.fish, R.id.cucumber, R.id.chocolate,
            R.id.garlic, R.id.meat, R.id.nuts, R.id.pea,
            R.id.salad, R.id.toilet_paper, R.id.vegetables, R.id.chicken
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_shopping_list);
    }

    public void onItemButtonClick(View view) {
        Intent myListShoppingIntent = new Intent(this, MainActivity.class);
        for (int button1 : BUTTONS) {
            Button button = findViewById(button1);
            if (view == button) {
                String stringToPassBack = button.getText().toString();
                Log.d(LOG_TAG, "****************" + stringToPassBack + "****************");
                myListShoppingIntent.putExtra("result", stringToPassBack);
                setResult(RESULT_OK, myListShoppingIntent);
                finish();
                break;
            }
        }
    }
}
