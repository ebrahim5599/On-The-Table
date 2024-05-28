package com.example.onthetableapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.onthetableapp.R;
import com.example.onthetableapp.data.remote.entity.Meals;
import com.example.onthetableapp.data.remote.entity.MealsArrayListModel;
import com.example.onthetableapp.model.MealModel;

import java.util.ArrayList;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.MealsViewHolder> {

    ArrayList<Meals> mealsArrayList;
    Context context;

    public MealsAdapter(ArrayList<Meals> mealsArrayList, Context context) {
        this.mealsArrayList = mealsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MealsAdapter.MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_meal_item_container, parent, false);
        return new MealsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealsAdapter.MealsViewHolder holder, int position) {
        Glide.with(context).load(mealsArrayList.get(position).getStrMealThumb()).into(holder.mealImageView);
        holder.mealTextView.setText(mealsArrayList.get(position).getStrMeal());
    }

    @Override
    public int getItemCount() {
        return mealsArrayList.size();
    }

    public static class MealsViewHolder extends RecyclerView.ViewHolder {

        ImageView mealImageView;
        TextView mealTextView;
        public MealsViewHolder(@NonNull View itemView) {
            super(itemView);
            mealImageView = itemView.findViewById(R.id.mainMealItemContainerImageView);
            mealTextView = itemView.findViewById(R.id.mainMealItemContainerTextView);
        }
    }
}
