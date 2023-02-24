package com.example.foodapp.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodapp.Entity.Food;
import com.example.foodapp.R;

import java.util.List;

public class FoodAdapter extends BaseAdapter {

    Activity activity;
    List<Food> dataList;

    public FoodAdapter(Activity activity, List<Food> dataList){
        this.activity = activity;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // View view = LayoutInflater.from(context).inflate(R.layout.food_item,parent,false);

        View view = activity.getLayoutInflater().inflate(R.layout.food_item,parent,false);

        ImageView title_img = view.findViewById(R.id.title_img);
        TextView titleView = view.findViewById(R.id.tv_title);
        TextView descriptionView = view.findViewById(R.id.tv_description);
        TextView priceView = view.findViewById(R.id.tv_price);

        Food food =  dataList.get(position);
        title_img.setImageResource(food.getImgResId());
        titleView.setText(food.getTitle());
        descriptionView.setText(food.getDescription());
        priceView.setText(String.valueOf(food.getPrice()));

        return view;
    }
}
