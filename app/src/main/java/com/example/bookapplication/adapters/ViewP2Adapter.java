package com.example.bookapplication.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bookapplication.fragments.AddBookFragment;
import com.example.bookapplication.fragments.BasketFragment;
import com.example.bookapplication.fragments.ShowBooksFragment;

public class ViewP2Adapter extends FragmentStateAdapter {
    int tabCount;

    public ViewP2Adapter(@NonNull FragmentActivity fragmentActivity, int tabCount) {
        super(fragmentActivity);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new AddBookFragment();
            case 1: return new ShowBooksFragment();
            case 2: return new BasketFragment();
            default: return null;
        }
    }

    @Override
    public int getItemCount() {
        return tabCount;
    }
}
