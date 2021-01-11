package com.example.cleantime.adapter;

import com.example.cleantime.activities.package_fragments.HatchbackFragment;
import com.example.cleantime.activities.package_fragments.LuxuryFragment;
import com.example.cleantime.activities.package_fragments.SedanFragment;
import com.example.cleantime.activities.package_fragments.SuvFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

//public class ChoosePackagePagerAdapter extends FragmentPagerAdapter {

//    int tabCount;
//
////    public ChoosePackagePagerAdapter(@NonNull FragmentManager fm) {
////        super(fm);
////    }
//    //int tabCount;
//
//    public ChoosePackagePagerAdapter(@NonNull FragmentManager fm, int behavior) {
//        super(fm, behavior);
//        tabCount = behavior;
//    }
//
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//
//        switch (position){
//            case 0 : return new SedanFragment();
//            case 1 : return new HatchbackFragment();
//            case 2 : return new SuvFragment();
//            case 3 : return new LuxuryFragment();
//            default: return new SedanFragment();
//        }
//
//    }
//
//    @Override
//    public int getCount() {
//        return tabCount;
//    }
//}
