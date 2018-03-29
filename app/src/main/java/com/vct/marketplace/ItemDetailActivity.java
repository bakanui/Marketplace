package com.vct.marketplace;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Intent intent = getIntent();
        String name  = intent.getStringExtra("itemName");
        String img = intent.getStringExtra("itemImg");
        String sizes = intent.getStringExtra("itemSizes");
        String desc = intent.getStringExtra("itemDesc");
        String colors = intent.getStringExtra("itemColors");
        String profile = intent.getStringExtra("sellerProfile");
        String seller = intent.getStringExtra("sellerName");
        String price = intent.getStringExtra("itemPrice");
        String stock = intent.getStringExtra("itemStock");
        getSupportActionBar().setTitle(name);



        ImageView prodImg = findViewById(R.id.prod_img);
        TextView prodPrice = findViewById(R.id.prod_price);
        TextView prodStock = findViewById(R.id.prod_stock);
        TextView prodDesc = findViewById(R.id.prod_desc);
        TextView prodSizes = findViewById(R.id.prod_sizes);
        TextView prodColors = findViewById(R.id.prod_colors);
        ImageView profileImage = findViewById(R.id.profile_image);
        TextView sellerName = findViewById(R.id.seller_name);

        Context imgContext = prodImg.getContext();
        int imgId = imgContext.getResources().getIdentifier(img, "drawable", imgContext.getPackageName());
        Context profContext = profileImage.getContext();
        int profId = profContext.getResources().getIdentifier(profile, "drawable", profContext.getPackageName());

        prodImg.setImageResource(imgId);
        prodPrice.setText(price);
        prodStock.setText(stock + " remaining.");
        prodDesc.setText(desc);
        prodSizes.setText(sizes);
        prodColors.setText(colors);
        profileImage.setImageResource(profId);
        sellerName.setText(seller);
    }
}
