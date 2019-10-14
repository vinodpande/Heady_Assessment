package com.assessment.heady_assessment.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.assessment.heady_assessment.R;
import com.assessment.heady_assessment.adapter.ProductAdapter;
import com.assessment.heady_assessment.adapter.ProductVariantsAdapter;
import com.assessment.heady_assessment.data_model.Product;
import com.google.gson.Gson;

public class ProductVariantsActivity extends AppCompatActivity {

    RecyclerView recyclerViewProductsVariants;
    Product product;
    Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_variants);
        initRecycleView();
        gson=new Gson();
        product=gson.fromJson(getIntent().getStringExtra("products"),Product.class);
    }

    void initRecycleView(){
        recyclerViewProductsVariants = findViewById(R.id.recycler_products_variants);
        recyclerViewProductsVariants.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewProductsVariants.setLayoutManager(layoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerViewProductsVariants.setAdapter(new ProductVariantsAdapter(product,this));
    }
}
