package com.nair.bharath.Pillaigram.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nair.bharath.Pillaigram.R;
import com.nair.bharath.Pillaigram.Utils.BottomNavigationViewHelper;
import com.nair.bharath.Pillaigram.Utils.GridImageAdapter;
import com.nair.bharath.Pillaigram.Utils.UniversalImageLoader;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity
{
    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM=4;
    private static final int NUM_GRID_COLUMNS = 3;

    private Context mContext = ProfileActivity.this;

    private ProgressBar mProgressBar;
    private ImageView profilePhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started.");

        setupBottomNavigationView();
        setupToolbar();
        setupActivityWidgets();
        setProfileImage();

        tempGridSetUp();
    }

    private void tempGridSetUp(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://www.lifewire.com/thmb/2_eNqJX9F8k4qsON0Ica6jMremw=/854x0/filters:no_upscale():max_bytes(150000):strip_icc()/okay_guy-56a9fe093df78cf772abf2ea.jpg");
        imgURLs.add("https://www.lifewire.com/rage-comics-3486364");
        imgURLs.add("https://www.lifewire.com/rage-comics-3486364");
        imgURLs.add("https://www.lifewire.com/rage-comics-3486364");
        imgURLs.add("https://www.lifewire.com/rage-comics-3486364");
        imgURLs.add("https://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwin4-rkl4veAhWQdH0KHXnaBxcQjRx6BAgBEAU&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DpzUzSypE010&psig=AOvVaw0PfpQpnZEfGIxLHGyXhucf&ust=1539786822349291");
        imgURLs.add("https://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwiqlu3sl4veAhUJSX0KHbm2DLQQjRx6BAgBEAU&url=http%3A%2F%2Fchinese.fansshare.com%2Fgallery%2Fphotos%2F12417012%2Ffamous-characters-troll-face-watching-you-meme%2F&psig=AOvVaw0PfpQpnZEfGIxLHGyXhucf&ust=1539786822349291");
        imgURLs.add("https://www.lifewire.com/thmb/REY6t2KV4dZdVI19aLmaB1dU83w=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/NoMeGusta-5a314fde96f7d00037ef5d65.jpg");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEFWZpMPTNPSSVymGEeYPR9JYvHZD2lhLguJaJELQnP2AenSZr-Q");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxjN4RDbq_TfytQMWTZT3bpZPpATNOQn8uMoEfZg8MzouAKufvTg");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRC78SiVS6bQZAYzLztDoj6a7kHeLa2BOTKpAzCkHq0-fMl_UZM");
        imgURLs.add("https://mbtskoudsalg.com/images/rage-faces-png-8.png");
        imgURLs.add("https://www.lifewire.com/thmb/2_eNqJX9F8k4qsON0Ica6jMremw=/854x0/filters:no_upscale():max_bytes(150000):strip_icc()/okay_guy-56a9fe093df78cf772abf2ea.jpg");
        imgURLs.add("https://www.lifewire.com/rage-comics-3486364");
        imgURLs.add("https://www.lifewire.com/rage-comics-3486364");
        imgURLs.add("https://www.lifewire.com/rage-comics-3486364");
        imgURLs.add("https://www.lifewire.com/rage-comics-3486364");
        imgURLs.add("https://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwin4-rkl4veAhWQdH0KHXnaBxcQjRx6BAgBEAU&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DpzUzSypE010&psig=AOvVaw0PfpQpnZEfGIxLHGyXhucf&ust=1539786822349291");
        imgURLs.add("https://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwiqlu3sl4veAhUJSX0KHbm2DLQQjRx6BAgBEAU&url=http%3A%2F%2Fchinese.fansshare.com%2Fgallery%2Fphotos%2F12417012%2Ffamous-characters-troll-face-watching-you-meme%2F&psig=AOvVaw0PfpQpnZEfGIxLHGyXhucf&ust=1539786822349291");
        imgURLs.add("https://www.lifewire.com/thmb/REY6t2KV4dZdVI19aLmaB1dU83w=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/NoMeGusta-5a314fde96f7d00037ef5d65.jpg");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEFWZpMPTNPSSVymGEeYPR9JYvHZD2lhLguJaJELQnP2AenSZr-Q");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxjN4RDbq_TfytQMWTZT3bpZPpATNOQn8uMoEfZg8MzouAKufvTg");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRC78SiVS6bQZAYzLztDoj6a7kHeLa2BOTKpAzCkHq0-fMl_UZM");
        imgURLs.add("https://mbtskoudsalg.com/images/rage-faces-png-8.png");

        setupImageGrid(imgURLs);

    }

    private void setupImageGrid(ArrayList<String> imgURLs){
        GridView gridView = (GridView) findViewById(R.id.gridView);

        int gridWidth = getResources().getDisplayMetrics().widthPixels;                             //dividing the grid into 3 for each image to load correctly
        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
        gridView.setColumnWidth(imageWidth);                                                        //sets column width as the imagewidth(divided by 3)

        GridImageAdapter adapter = new GridImageAdapter(mContext,R.layout.layout_grid_imageview, "",imgURLs);
        gridView.setAdapter(adapter);
    }


    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting profile photo.");
        String imgURL = "http://www.pngmart.com/files/4/Android-PNG-Image.png";
        UniversalImageLoader.setImage(imgURL, profilePhoto, mProgressBar, "");

    }

    private void setupActivityWidgets(){
        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        profilePhoto = (ImageView) findViewById(R.id.profile_photo);

    }


    /**
     * Responsible for setting up the profile toolbar
     */
    private void setupToolbar()
    {
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        /*toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Log.d(TAG, "onMenuItemClick: clicked menu item: "+ menuItem);

                switch(menuItem.getItemId())
                {
                    case R.id.profileMenu:
                        Log.d(TAG, "onMenuItemClick: Navigating to Profile Preferences.");
                }
                return false;
            }
        });*/


        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigating to account settings");
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
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

}
