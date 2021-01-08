package com.example.cleantime.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.cleantime.R;
import com.example.cleantime.adapter.ChoosePackagePagerAdapter;

public class ChoosePackageActivity extends AppCompatActivity {
    private TableLayout tabLayout1;
    private ViewPager viewPager1;

    private ImageView ivGoBack;

    ChoosePackagePagerAdapter choosePackagePagerAdapter;

    //String [] tabTitle = new String[]{ "Sedan", "Luxury", "Hatchback", "Suv" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_package);
        initViews();


    }

    private void initViews() {
        tabLayout1 = findViewById(R.id.tabLayout1);
        viewPager1 = findViewById(R.id.viewPager1);

        //choosePackagePagerAdapter = new ChoosePackagePagerAdapter(getSupportFragmentManager(), tabLayout1.getTabCount());
        viewPager1.setAdapter(choosePackagePagerAdapter);
        //tabLayout1.setupWithViewPager(viewPager1);
        //createCustomTab();


    }

//    private void createCustomTab() {
//
//        int tabCount = tabLayout1.getTabCount();
//        for(int i = 0; i< tabCount; i++){
//            TableLayout.Tab tab = tabLayout1.getTabAt(i);
//            tab.setCustom(R.layout.custom_tab);
//            View view = tab.getCustomView();
//            TextView title = view.findViewById(R.id.title);
//            title.set(tabTitle[i]);
//
//        }

}