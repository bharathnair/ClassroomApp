package com.nair.bharath.instaclone.Home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nair.bharath.instaclone.R;
import com.nair.bharath.instaclone.Utils.BottomNavigationViewHelper;

public class HomeActivity extends AppCompatActivity 
{
    private static final String TAG = "HomeActivity";
    private static final int ACTIVITY_NUM=0;

    private Context mContext = HomeActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: starting.");

        setupBottomNavigationView();
        setupViewPager();
    }

    /**
     * Responsible for adding 3 tabs: Camera, Home, Messages
     */

    private void setupViewPager()
    {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment());      //index 0
        adapter.addFragment(new HomeFragment());        //index 1
        adapter.addFragment(new MessagesFragment());    //index 2
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_university);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_chat);

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
}
