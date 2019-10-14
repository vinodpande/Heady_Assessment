package com.assessment.heady_assessment.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.assessment.heady_assessment.R;
import com.assessment.heady_assessment.adapter.CategoryAdapter;
import com.assessment.heady_assessment.data_model.CategoriesResponse;
import com.assessment.heady_assessment.data_model.Category;
import com.assessment.heady_assessment.data_model.Ranking;
import com.assessment.heady_assessment.presenter.ICategroyItem;
import com.assessment.heady_assessment.repository.CategoriesRepo;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements ICategroyItem {

    private CompositeDisposable mCompositeDisposable;

    private RecyclerView recyclerCategoryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        mCompositeDisposable = new CompositeDisposable();

        mCompositeDisposable.add(CategoriesRepo.getcategoriesResponse()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));
    }

    private void initRecyclerView() {

        recyclerCategoryView = findViewById(R.id.recycler_categories);
        recyclerCategoryView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerCategoryView.setLayoutManager(layoutManager);
    }


    private void handleError(Throwable throwable) {
        Log.i("categories Response", throwable.getMessage());
    }

    private void handleResponse(CategoriesResponse categoriesResponse) {

        recyclerCategoryView.setAdapter(new CategoryAdapter(categoriesResponse.getCategories(),categoriesResponse.getRankings(),this,this));
        Log.i("categories Response", categoriesResponse.getCategories().get(0).getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }

    @Override
    public void OnClickedCategoryItem(Category category, List<Ranking> ranking) {
        Gson gson=new Gson();
        String cateory=gson.toJson(category);
        String rankings=gson.toJson(ranking);
        Intent intent=new Intent(MainActivity.this,ProductActivity.class);
        intent.putExtra("category",cateory);
        intent.putExtra("ranking",rankings);
        startActivity(intent);
    }
}
