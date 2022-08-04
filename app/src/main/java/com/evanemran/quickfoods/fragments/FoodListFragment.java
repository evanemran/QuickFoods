package com.evanemran.quickfoods.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.quickfoods.FoodDetailActivity;
import com.evanemran.quickfoods.R;
import com.evanemran.quickfoods.adapters.FoodListAdapter;
import com.evanemran.quickfoods.listeners.ClickListener;
import com.evanemran.quickfoods.models.Foods;

import java.util.ArrayList;
import java.util.List;

public class FoodListFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_food, container, false);

        RecyclerView recycler_foods = view.findViewById(R.id.recycler_foods);

        recycler_foods.setHasFixedSize(true);
//        recycler_foods.setNestedScrollingEnabled(false);
        recycler_foods.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        FoodListAdapter foodListAdapter = new FoodListAdapter(getContext(), getFoodList(), foodClickListener);
        recycler_foods.setAdapter(foodListAdapter);

        return view;
    }

    private List<Foods> getFoodList() {
        List<Foods> foodsList = new ArrayList<>();
        foodsList.add(new Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal));
        foodsList.add(new Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal));
        foodsList.add(new Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal));
        foodsList.add(new Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal));
        foodsList.add(new Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal));
        foodsList.add(new Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal));
        foodsList.add(new Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal));
        foodsList.add(new Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal));
        foodsList.add(new Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal));
        foodsList.add(new Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal));

        return foodsList;
    }

    private final ClickListener<Foods> foodClickListener = new ClickListener<Foods>() {
        @Override
        public void onClicked(Foods data) {
            startActivity(new Intent(getContext(), FoodDetailActivity.class)
                    .putExtra("food", data));
        }
    };
}
