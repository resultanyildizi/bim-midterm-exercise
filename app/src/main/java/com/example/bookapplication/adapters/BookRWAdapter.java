package com.example.bookapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookapplication.R;
import com.example.bookapplication.activities.DummyActivity;
import com.example.bookapplication.models.Book;
import com.example.bookapplication.models.DBBooks;

import org.w3c.dom.Text;

import java.util.zip.Inflater;


public class BookRWAdapter extends RecyclerView.Adapter<BookRWAdapter.BookViewHolder> {
    Context context;

    class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView tvBookName, tvAuthorName, tvCategory, tvPageCount;
        public Button btnButton;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setBackgroundColor(Color.CYAN);
            tvBookName = itemView.findViewById(R.id.tvBookName);
            tvAuthorName = itemView.findViewById(R.id.tvBookAuthor);
            tvCategory = itemView.findViewById(R.id.tvBookCategory);
            tvPageCount = itemView.findViewById(R.id.tvBookPages);
            btnButton = itemView.findViewById(R.id.bookButton);

            btnButton.setOnClickListener(view -> {
                /// TODO: do anything
                Intent intent = new Intent(context, DummyActivity.class);
                intent.putExtra("name", tvBookName.getText().toString());
                intent.putExtra("author", tvAuthorName.getText().toString());
                context.startActivity(intent);
            });
        }
    }

    public BookRWAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.book_layout, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        final Book book = DBBooks.getInstance().getAllBooks().get(position);

        holder.tvBookName.setText(book.getName());
        holder.tvAuthorName.setText(book.getAuthor());
        holder.tvCategory.setText(book.getCategory());
        holder.tvPageCount.setText(String.valueOf(book.getPageCount()));
//        holder.itemView.setTag(position);
//        index = position;
    }


    @Override
    public int getItemCount() {
        return DBBooks.getInstance().getAllBooks().size();
    }
}
