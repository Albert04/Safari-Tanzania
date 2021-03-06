package com.example.safari;


import android.content.Context;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public LoginAdapter(FragmentManager fm,Context context, int totalTabs)
    {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;

    }

    @Override
    public int getCount() {

        return totalTabs;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
                LoginRragment loginRragment = new LoginRragment();
                return loginRragment;
            case 1:
                RegisterFragment registerFragment = new RegisterFragment();
                return registerFragment;

            default:
                return null;

        }
   }
}
