package com.nair.bharath.instaclone.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nair.bharath.instaclone.R;
import com.nair.bharath.instaclone.Utils.BottomNavigationViewHelper;

public class ProfileActivity extends AppCompatActivity
{
    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM=4;

    private Context mContext = ProfileActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started.");

        setupBottomNavigationView();
        setupToolbar();
    }

    private void setupToolbar()
    {
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Log.d(TAG, "onMenuItemClick: clicked menu item: "+ menuItem);

                switch(menuItem.getItemId())
                {
                    R.id.profileMenu:
                    Log.d(TAG, "onMenuItemClick: Navigating to Profile Preferences.");
                }
                return  false;
            }
        });
    }


    /**
     * BottomNavigationView setup
     */
    private void setupBottomNavigationView()
    {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigation");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
