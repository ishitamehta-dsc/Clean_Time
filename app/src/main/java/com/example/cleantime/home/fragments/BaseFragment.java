package com.example.cleantime.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cleantime.home.OnBackPressed;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment implements OnBackPressed {
   /**
    * Could handle back press.
    * @return true if back press was handled
    */
//   public boolean onBackPressed() {
//       return false;
//   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onBackPressed() {

    }
}

