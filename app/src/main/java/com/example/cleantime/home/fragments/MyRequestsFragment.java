package com.example.cleantime.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cleantime.R;
import com.example.cleantime.adapter.MyRequestAdapter;
import com.example.cleantime.model.MyRequestModel;

import java.util.ArrayList;
import java.util.List;


public class MyRequestsFragment extends Fragment {

    private View view;
    private RecyclerView requestRecyclerView;
    private MyRequestAdapter myRequestAdapter;
    private List<MyRequestModel> myRequestModelList;

    public MyRequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_requests, container, false);
        initView();
        return view;
    }

    private void initView() {
        requestRecyclerView = view.findViewById(R.id.requestRecyclerView);

        myRequestModelList = new ArrayList<>();
        myRequestModelList.add(new MyRequestModel(R.drawable.acw_unselected,
                "Automatic car wash",
                "Audi Q6",
                "25 July", "1824/-"));

        myRequestModelList.add(new MyRequestModel(R.drawable.acw_unselected,
                "Interior services &Cleaning",
                "Audi Q6",
                "25 July", "1824/-"));

        myRequestModelList.add(new MyRequestModel(R.drawable.acw_unselected,
                "Wheel & Dashboard",
                "Audi Q6",
                "25 July", "1824/-"));

        myRequestModelList.add(new MyRequestModel(R.drawable.acw_unselected,
                "Regular car wash",
                "Audi Q6",
                "25 July", "1824/-"));

        myRequestModelList.add(new MyRequestModel(R.drawable.acw_unselected,
                "Automated Tunnel wash",
                "Audi Q6",
                "25 July", "1824/-"));

        myRequestModelList.add(new MyRequestModel(R.drawable.acw_unselected,
                "Interior & Cleaning",
                "Audi Q6",
                "25 July", "1824/-"));

        setRequestRecyclerView(myRequestModelList);

    }

    private void setRequestRecyclerView(List<MyRequestModel> myRequestModels) {

        requestRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        myRequestAdapter = new MyRequestAdapter(getContext(), myRequestModels);
        requestRecyclerView.setAdapter(myRequestAdapter);
        myRequestAdapter.notifyDataSetChanged();
    }
}