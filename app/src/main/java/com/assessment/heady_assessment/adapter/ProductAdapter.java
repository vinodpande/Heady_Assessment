package com.assessment.heady_assessment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assessment.heady_assessment.R;
import com.assessment.heady_assessment.data_model.Product;
import com.assessment.heady_assessment.presenter.IProduct;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    List<Product> products;
    IProduct iProduct;

    public ProductAdapter(List<Product> products, IProduct iProduct) {
        this.products = products;
        this.iProduct = iProduct;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row_products, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product product = products.get(position);
        holder.textViewProductTitle.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewProductTitle;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            textViewProductTitle = itemView.findViewById(R.id.text_product_title);
            textViewProductTitle.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            iProduct.onProductClicked(products.get(getAdapterPosition()));
        }
    }
}
