package com.example.bookapplication.adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookapplication.R;
import com.example.bookapplication.models.Book;
import com.example.bookapplication.models.DBBooks;

public class LVAdapter extends ArrayAdapter<Book> {
    int resourceID;
    Context context;
    public LVAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.resourceID = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Book book = DBBooks.getInstance().getAllBooks().get(position);
        View view = LayoutInflater.from(context).inflate(resourceID, null, false);

        TextView tvBookName = view.findViewById(R.id.tvBookName);
        TextView tvBookAuthor = view.findViewById(R.id.tvBookAuthor);
        TextView tvBookCategory = view.findViewById(R.id.tvBookCategory);
        TextView tvPageCount = view.findViewById(R.id.tvBookPages);
        Button btnButton = view.findViewById(R.id.bookButton);

        tvBookName.setText(book.getName());
        tvBookAuthor.setText(book.getAuthor());
        tvBookCategory.setText(book.getCategory());
        tvPageCount.setText(String.valueOf(book.getPageCount()));
        btnButton.setOnClickListener(v -> {
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(context);
//            builder.setTitle("Are you sure to Add?");
//
//            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//
//                }
//            });
//
////                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        Toast.makeText(context, "Oh NOOOOO", Toast.LENGTH_SHORT).show();
////                    }
////                });
//
//            AlertDialog dialog = builder.create();
//            dialog.show();
        });

        return view;
    }

    @Override
    public int getCount() {
        return DBBooks.getInstance().getAllBooks().size();
    }
}
