package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ItemActivity extends AppCompatActivity {

    EditText editTitle,editDescription,editPrice;
    Button btnSaveUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        String getTitle = getIntent().getStringExtra("title");
        String getDes = getIntent().getStringExtra("des");
        String getPrice = getIntent().getStringExtra("price");


        editTitle = findViewById(R.id.title_item);
        editDescription = findViewById(R.id.description_item);
        editPrice = findViewById(R.id.price_item);

        editTitle.setText(getTitle);
        editDescription.setText(getDes);
        editPrice.setText(getPrice);

        btnSaveUpdate = findViewById(R.id.item_add_btn);

        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString();
                String description = editDescription.getText().toString();
                String price = editPrice.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("title",title);
                intent.putExtra("des",description);
                intent.putExtra("price",price);

                setResult(100,intent);
                finish();
            }
        });
    }
}