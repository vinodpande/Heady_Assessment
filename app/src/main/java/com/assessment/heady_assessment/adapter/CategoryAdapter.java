package com.assessment.heady_assessment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assessment.heady_assessment.R;
import com.assessment.heady_assessment.data_model.Category;
import com.assessment.heady_assessment.data_model.Ranking;
import com.assessment.heady_assessment.presenter.ICategroyItem;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    List<Category> categories;
    List<Ranking> rankings;
    ICategroyItem iCategroyItem;

    public CategoryAdapter(List<Category> categories,List<Ranking> rankings, ICategroyItem iCategroyItem) {
        this.categories = categories;
        this.rankings=rankings;
        this.iCategroyItem = iCategroyItem;
    }



    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row_categories, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category category = categories.get(position);
        holder.textViewCategoryTitle.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewCategoryTitle;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            textViewCategoryTitle = itemView.findViewById(R.id.text_categories_title);
            textViewCategoryTitle.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            iCategroyItem.OnClickedCategoryItem(categories.get(getAdapterPosition()),rankings);
        }

    }
}
