package com.example.onthetableapp.ui.home;

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
import com.example.onthetableapp.data.remote.entity.HomeMeals;

import java.util.ArrayList;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.MealsViewHolder> {

    ArrayList<HomeMeals> homeMealsArrayList;
    Context context;

    public MealsAdapter(ArrayList<HomeMeals> homeMealsArrayList, Context context) {
        this.homeMealsArrayList = homeMealsArrayList;
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
        Glide.with(context).load(homeMealsArrayList.get(position).getStrMealThumb()).into(holder.mealImageView);
        holder.mealTextView.setText(homeMealsArrayList.get(position).getStrMeal());
    }

    @Override
    public int getItemCount() {
        return homeMealsArrayList.size();
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
