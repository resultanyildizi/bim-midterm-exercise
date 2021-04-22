package com.example.bookapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookapplication.R;
import com.example.bookapplication.adapters.BookRWAdapter;

public class ShowBooksFragment extends Fragment {
    RecyclerView recyclerView;
    BookRWAdapter bookRWAdapter;
    public ShowBooksFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_books, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvBooks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        bookRWAdapter = new BookRWAdapter(getContext());

        recyclerView.setAdapter(bookRWAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}