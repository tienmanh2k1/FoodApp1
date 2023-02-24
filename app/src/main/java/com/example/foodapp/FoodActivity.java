package com.example.foodapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.foodapp.Adapter.FoodAdapter;
import com.example.foodapp.Entity.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    ListView foodListView;
    List<Food> foodList = new ArrayList<>();
    Button addBtn;
    int location;
    FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        foodListView = findViewById(R.id.foodListView);
        for (int i = 0; i < 5 ; i++){
            Food food = new Food("Food" +i,"abcbcbcbcbc" + i,100 +1,R.drawable.img_pib);
            foodList.add(food);
        }

        foodAdapter = new FoodAdapter(this,foodList);
        foodListView.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();

        foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food food = foodList.get(position);
                Toast.makeText(FoodActivity.this,food.getTitle(),Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(FoodActivity.this,ItemActivity.class);
                intent.putExtra("title",food.getTitle());
                intent.putExtra("des",food.getDescription());
                intent.putExtra("price",String.valueOf(food.getPrice()));
                location = position;
                startActivityForResult(intent,100);

            }
        });

        addBtn = findViewById(R.id.btn_addFood);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this,ItemActivity.class);
                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String title = data.getStringExtra("title");
        String description = data.getStringExtra("des");
        String priceString = data.getStringExtra("price");
        float price = Float.parseFloat(priceString);


        int thumbnail = R.drawable.img_pib;

        Food food = new Food(title, description, price, thumbnail);

        if (location > location -1){
            foodList.add(food);
        }else{
            foodList.set(location,food);
        }
        foodAdapter.notifyDataSetChanged();
    }
}