package com.testapplication.makhnnar.wifiviewerinit.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.testapplication.makhnnar.wifiviewerinit.home.wifigraphics.WifiGraphicsFragment;
import com.testapplication.makhnnar.wifiviewerinit.home.wifilist.WifiListFragment;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private WifiListFragment wifiListFragment;
    private WifiGraphicsFragment wifiGraphicsFragment;

    public HomePagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (wifiListFragment == null) {
                    wifiListFragment = WifiListFragment.newInstance();
                }
                return wifiListFragment;

            case 1:
                if (wifiGraphicsFragment == null) {
                    wifiGraphicsFragment = WifiGraphicsFragment.newInstance();
                }
                return wifiGraphicsFragment;


            default:
                return wifiListFragment.newInstance();

        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Wifi List";

            case 1:
                return "Wifi Graphics";

            default:
                return "Wifi List";

        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
