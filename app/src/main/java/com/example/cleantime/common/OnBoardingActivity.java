package com.example.cleantime.common;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.cleantime.R;
import com.example.cleantime.auth.LoginActivity;
import com.example.cleantime.common.OnBoardingAdapter;
import com.example.cleantime.common.OnBoardingItem;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {
    private OnBoardingAdapter onBoardingAdapter;
    private ViewPager2 onBoardingViewPager;
    private LinearLayout layoutOnBoardingIndicators;
    private TextView tvNext;
    private TextView tvSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        initViews();
    }

    private void initViews() {
        setOnBoardingItems();
        layoutOnBoardingIndicators = findViewById(R.id.layoutOnBoardingIndicators);
        onBoardingViewPager = findViewById(R.id.onBoardingViewPager);
        onBoardingViewPager.setAdapter(onBoardingAdapter);
        tvSkip = findViewById(R.id.tvSkip);
        tvNext = findViewById(R.id.tvNext);
        setOnIndicators();
        setCurrentIndicator(0);

        onBoardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onBoardingViewPager.getCurrentItem() + 1 < onBoardingAdapter.getItemCount()) {
                    onBoardingViewPager.setCurrentItem(onBoardingViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    //finish();
                }
            }
        });
    }

    private void setOnBoardingItems() {
        List<OnBoardingItem> onBoardingItems = new ArrayList<>();

        OnBoardingItem item = new OnBoardingItem();
        item.setDescription("On Your DoorStep");
        item.setImage(R.drawable.onboarding_one);

        OnBoardingItem item1 = new OnBoardingItem();
        item1.setDescription("All 2&4 wheelers cleaning\n" +
                "and\n" +
                "detailing service");
        item1.setImage(R.drawable.onboarding_two);

        OnBoardingItem item2 = new OnBoardingItem();
        item2.setDescription("Any time Any where");
        item2.setImage(R.drawable.onboarding_three);

        onBoardingItems.add(item);
        onBoardingItems.add(item1);
        onBoardingItems.add(item2);

        onBoardingAdapter = new OnBoardingAdapter(onBoardingItems);
    }

    private void setOnIndicators() {
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(), R.drawable.ondicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnBoardingIndicators.addView(indicators[i]);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setCurrentIndicator(int index) {
        int childCount = layoutOnBoardingIndicators.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutOnBoardingIndicators.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.ondicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.ondicator_inactive)
                );
            }
        }
        if (index == onBoardingAdapter.getItemCount() - 1) {
            tvNext.setText("Let's Get Started");
        } else {
            tvNext.setText("Next");
        }
    }
}