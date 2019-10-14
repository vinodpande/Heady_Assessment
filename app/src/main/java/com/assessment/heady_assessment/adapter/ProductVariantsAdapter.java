package com.assessment.heady_assessment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assessment.heady_assessment.R;
import com.assessment.heady_assessment.data_model.Product;
import com.assessment.heady_assessment.data_model.Variant;

public class ProductVariantsAdapter extends RecyclerView.Adapter<ProductVariantsAdapter.ProductVariantsHolder> {
    Product products;
    Context context;

    public ProductVariantsAdapter(Product products, Context context) {
        this.products = products;
        this.context = context;

    }

    @NonNull
    @Override
    public ProductVariantsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row_product_variants, parent, false);
        return new ProductVariantsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductVariantsHolder holder, int position) {
        Variant variant = products.getVariants().get(position);
        holder.textViewName.setText("Name   " + products.getName());
        if (variant.getSize()==null) {
            holder.textViewSize.setText("Size" );
        } else {
            holder.textViewSize.setText("Size   " + variant.getSize());
        }
        holder.textViewColor.setText("Color " + variant.getColor());
        holder.textViewPrice.setText("Price " + variant.getPrice());
        holder.textViewTax.setText("Tax " + products.getTax().getValue() + " " + products.getTax().getName());

        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorGrey));
        }
    }

    @Override
    public int getItemCount() {

        return products.getVariants().size();

    }

    public class ProductVariantsHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewSize;
        TextView textViewColor;
        TextView textViewPrice;
        TextView textViewTax;

        public ProductVariantsHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_name);
            textViewSize = itemView.findViewById(R.id.text_size);
            textViewColor = itemView.findViewById(R.id.text_color);
            textViewPrice = itemView.findViewById(R.id.text_price);
            textViewTax = itemView.findViewById(R.id.text_tax);

        }


    }
}
