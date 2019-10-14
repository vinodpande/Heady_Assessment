package com.assessment.heady_assessment.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.assessment.heady_assessment.R;
import com.assessment.heady_assessment.adapter.ProductAdapter;
import com.assessment.heady_assessment.data_model.Category;
import com.assessment.heady_assessment.data_model.Product;
import com.assessment.heady_assessment.data_model.Ranking;
import com.assessment.heady_assessment.presenter.IProduct;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductActivity extends AppCompatActivity implements IProduct {
    Gson gson;
    Category category;
    List<Ranking> ranking;

    RecyclerView recyclerViewProducts;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initRecycleView();
        gson = new Gson();
        category = gson.fromJson(getIntent().getStringExtra("category"), Category.class);

        ranking = Arrays.asList(gson.fromJson(getIntent().getStringExtra("ranking"), Ranking[].class));
        Log.i("ranking", String.valueOf(ranking.get(0).getRanking()));
        Log.i("ranking", String.valueOf(ranking.get(1).getRanking()));
        Log.i("ranking", String.valueOf(ranking.get(2).getRanking()));
    }

    void initRecycleView() {
        recyclerViewProducts = findViewById(R.id.recycler_products);
        recyclerViewProducts.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewProducts.setLayoutManager(layoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerViewProducts.setAdapter(new ProductAdapter(category.getProducts(), this,getApplicationContext()));
    }

    @Override
    public void onProductClicked(Product product) {
        String product_ = gson.toJson(product);
        Intent intent = new Intent(ProductActivity.this, ProductVariantsActivity.class);
        intent.putExtra("products", product_);
        startActivity(intent);
    }

    void shortMostViewedProducts() {
        ArrayList<Product> products = new ArrayList<>();
        for (int c = 0; c < category.getProducts().size(); c++) {
            for (int i = 0; i < ranking.size(); i++) {
                if (ranking.get(i).getRanking().equals("Most Viewed Products")) {
                    for (int j = 0; j < ranking.get(i).getProducts().size(); j++) {
                        if (category.getProducts().get(c).getId().equals(ranking.get(i).getProducts().get(j).getId())) {
                            products.add(category.getProducts().get(c));
                        }
                    }
                }
            }
        }

        recyclerViewProducts.setAdapter(new ProductAdapter(products, this,getApplicationContext()));
    }

    void shortMostOrdeRedProducts() {
        ArrayList<Product> products = new ArrayList<>();
        for (int c = 0; c < category.getProducts().size(); c++) {
            for (int i = 0; i < ranking.size(); i++) {
                if (ranking.get(i).getRanking().equals("Most OrdeRed Products")) {
                    for (int j = 0; j < ranking.get(i).getProducts().size(); j++) {
                        if (category.getProducts().get(c).getId().equals(ranking.get(i).getProducts().get(j).getId())) {
                            products.add(category.getProducts().get(c));
                        }
                    }
                }
            }
        }

        recyclerViewProducts.setAdapter(new ProductAdapter(products, this,getApplicationContext()));
    }

    void shortMostShaRedProducts() {
        ArrayList<Product> products = new ArrayList<>();
        for (int c = 0; c < category.getProducts().size(); c++) {
            for (int i = 0; i < ranking.size(); i++) {
                if (ranking.get(i).getRanking().equals("Most ShaRed Products")) {
                    for (int j = 0; j < ranking.get(i).getProducts().size(); j++) {
                        if (category.getProducts().get(c).getId().equals(ranking.get(i).getProducts().get(j).getId())) {
                            products.add(category.getProducts().get(c));
                        }
                    }
                }
            }
        }

        recyclerViewProducts.setAdapter(new ProductAdapter(products, this,getApplicationContext()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.most_viewed_products: {
                shortMostViewedProducts();
                return true;
            }
            case R.id.most_shared_products: {
                shortMostShaRedProducts();
                return true;
            }
            case R.id.most_ordered_products: {
                shortMostOrdeRedProducts();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
