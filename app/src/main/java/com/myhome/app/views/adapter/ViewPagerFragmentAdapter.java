package com.myhome.app.views.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by hank on 2015/10/8/16:16:07
 */
public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {
   private List<Fragment> fragments;

   public ViewPagerFragmentAdapter(FragmentManager mFragmentManager, List<Fragment> fragments) {
      super(mFragmentManager);
      this.fragments = fragments;
   }

   @Override
   public int getCount() {
      return fragments.size();
   }

   @Override
   public Fragment getItem(int position) {
      return fragments.get(position);
   }
}