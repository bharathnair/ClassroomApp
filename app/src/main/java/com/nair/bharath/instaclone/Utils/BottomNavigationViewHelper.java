package com.nair.bharath.instaclone.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nair.bharath.instaclone.Home.HomeActivity;
import com.nair.bharath.instaclone.Likes.LikesActivity;
import com.nair.bharath.instaclone.Profile.ProfileActivity;
import com.nair.bharath.instaclone.R;
import com.nair.bharath.instaclone.Search.SearchActivity;
import com.nair.bharath.instaclone.Share.ShareActivity;

public class BottomNavigationViewHelper
{
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx)
    {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);


    }

    //how to navigate between activities
    public static void enableNavigation(final Context context, BottomNavigationViewEx view)     //without 'final' cannot reference 'context' inside the override method
    {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()    //instance class
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch(menuItem.getItemId())
                {
                    case R.id.ic_house:
                        Intent intent1 = new Intent(context, HomeActivity.class);     //ACTIVITY_NUM=0   //'context' is required in object of class to be the reference
                        context.startActivity(intent1);                                                 //if directly done in homeactivity.java we need
                        break;                                                                          //new Intent(HomeActivity.this, HomeActivity.class)

                    case R.id.ic_search:
                        Intent intent2 = new Intent(context, SearchActivity.class);     //ACTIVITY_NUM=1
                        context.startActivity(intent2);
                        break;

                    case R.id.ic_circle:
                        Intent intent3 = new Intent(context, ShareActivity.class);      //ACTIVITY_NUM=2
                        context.startActivity(intent3);
                        break;

                    case R.id.ic_alert:
                        Intent intent4 = new Intent(context, LikesActivity.class);      //ACTIVITY_NUM=3
                        context.startActivity(intent4);
                        break;

                    case R.id.ic_android:
                        Intent intent5 = new Intent(context, ProfileActivity.class);        //ACTIVITY_NUM=4
                        context.startActivity(intent5);
                        break;
                }
                return false;

            }
        });
    }
}
