package com.nair.bharath.instaclone.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that stores fragments for tabs
 */
public class SectionPagerAdapter extends FragmentPagerAdapter
{
    private static final String TAG = "SectionPagerAdapter";

    private final List<Fragment> mFragmentList = new ArrayList<>();                                     /*mFragmentList is a list which holds the fragments to swap through them with tabs*/

    public SectionPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)                                                               /*get an item from the list*/
    {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount()
    {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment)                                                            //adding fragments to the list
    {
        mFragmentList.add(fragment);
    }
}
