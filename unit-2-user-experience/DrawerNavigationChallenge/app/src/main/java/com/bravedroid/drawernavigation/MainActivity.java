package com.bravedroid.drawernavigation;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (mDrawer != null) {
            mDrawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawer != null) {
            if (mDrawer.isDrawerOpen(GravityCompat.START)) {
                mDrawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_item1:
                mDrawer.closeDrawer(GravityCompat.START);
                displayToast("You chose item1");
                return true;
            case R.id.nav_item2:
                mDrawer.closeDrawer(GravityCompat.START);
                displayToast("You chose item2");
                return true;
            case R.id.nav_item3:
                mDrawer.closeDrawer(GravityCompat.START);
                displayToast("You chose item3");
                return true;
            case R.id.nav_item_4:
                mDrawer.closeDrawer(GravityCompat.START);
                displayToast("You chose item4");
                return true;
            case R.id.nav_item5:
                mDrawer.closeDrawer(GravityCompat.START);
                displayToast("You chose item5");
                return true;
            case R.id.nav_item6:
                mDrawer.closeDrawer(GravityCompat.START);
                displayToast("You chose item6");
                return true;
            default:
                return false;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
