package com.example.Saerok.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Saerok.R;
import com.example.Saerok.source.CategoryItem;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryItem> categories=new ArrayList<>();
    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        holder.setCategory(categories.get(position));
    }

    public void setCategories(ArrayList<CategoryItem> categories) {
        this.categories=categories;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView titleImageView;
        private CardView colorCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleImageView=itemView.findViewById(R.id.titleImageView);
            colorCardView=itemView.findViewById(R.id.colorCardView);
        }

        public void setCategory(CategoryItem category) {
            titleImageView.setImageResource(category.getResId());
            colorCardView.setCardBackgroundColor(Color.parseColor(category.getColor()));
        }
    }
}
