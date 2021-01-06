package com.example.cleantime.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cleantime.R;
import com.example.cleantime.model.MyRequestModel;

import java.util.List;

public class MyRequestAdapter extends RecyclerView.Adapter<MyRequestAdapter.MyRequestViewHolder> {

    private Context context;
    private List<MyRequestModel> requestModelList;

    public MyRequestAdapter(Context context, List<MyRequestModel> requestModelList) {
        this.context = context;
        this.requestModelList = requestModelList;
    }

    @NonNull
    @Override
    public MyRequestAdapter.MyRequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.request_item, parent, false);
        return new MyRequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRequestAdapter.MyRequestViewHolder holder, int position) {
        MyRequestModel myRequestModel = requestModelList.get(position);
        holder.ivCarService.setImageResource(myRequestModel.getImageUrl());
        holder.tvCarWashName.setText(myRequestModel.getCarWashName());
        holder.tvCarName.setText(myRequestModel.getCarName());
        holder.tvDate.setText(myRequestModel.getDate());
        holder.tvPrice.setText(myRequestModel.getPrice());
    }

    @Override
    public int getItemCount() {
        return requestModelList.size();
    }

    public static class MyRequestViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivCarService;
        private TextView tvCarWashName;
        private TextView tvCarName;
        private TextView tvDate;
        private TextView tvPrice;

        public MyRequestViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCarService = itemView.findViewById(R.id.ivCarService);
            tvCarWashName = itemView.findViewById(R.id.tvCarWashName);
            tvCarName = itemView.findViewById(R.id.tvCarName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
