package com.chamber_of_secrets.chamber.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.chamber_of_secrets.chamber.Adapter.SecretsDashboardViewpageAdapter;
import com.chamber_of_secrets.chamber.R;

public class SecretsDashboardActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secrets_dashboard);

        init();
        setActivity();

    }

    private void init() {
        tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void setActivity() {
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.camera_24)));
        tabLayout.addTab(tabLayout.newTab().setText("Chat"));
        tabLayout.addTab(tabLayout.newTab().setText("Groups"));
        tabLayout.addTab(tabLayout.newTab().setText("Status"));
        tabLayout.addTab(tabLayout.newTab().setText("Call"));


        SecretsDashboardViewpageAdapter adapter = new SecretsDashboardViewpageAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(1);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        Toast.makeText(SecretsDashboardActivity.this, "click camera", Toast.LENGTH_SHORT).show();
                    default:
                        viewpager.setCurrentItem(tab.getPosition());
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}