package com.bravedroid.tabexperiment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private static final String CURRENT_TAB_POSITION_key = "mCurrentTabPosition";
    private int mCurrentTabPosition = 0;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mCurrentTabPosition = savedInstanceState.getInt(CURRENT_TAB_POSITION_key);
        }
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        Toast.makeText(this, "mCurrentTabPosition of the VM is : " + mMainViewModel.getCurrentTabPosition(), Toast.LENGTH_LONG).show();

        View toolbar = findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar) toolbar);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1), mCurrentTabPosition == 0);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2), mCurrentTabPosition == 1);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3), mCurrentTabPosition == 2);

        final ViewPager viewPager = findViewById(R.id.pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position, true);
                mCurrentTabPosition = position;
                mMainViewModel.setCurrentTabPosition(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CURRENT_TAB_POSITION_key, mCurrentTabPosition);
        super.onSaveInstanceState(outState);
    }
}
