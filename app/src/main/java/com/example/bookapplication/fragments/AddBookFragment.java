package com.example.bookapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookapplication.R;
import com.example.bookapplication.models.Book;
import com.example.bookapplication.models.DBBooks;

public class AddBookFragment extends Fragment {
    EditText etName, etAuthor, etPageCount;
    Spinner spCategory;
    Button btnAddBook, btnNextPage;
    TextView tvMessage;

    String name, author, category;
    int pageCount;

    public AddBookFragment() {
        // Required empty public constructor
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
        return inflater.inflate(R.layout.fragment_add_book, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvMessage = (TextView) getView().findViewById(R.id.tvMessage);
        etName = (EditText) getView().findViewById(R.id.etName);
        etAuthor = (EditText) getView().findViewById(R.id.etAuthor);
        etPageCount = (EditText) getView().findViewById(R.id.etPageCount);
        btnAddBook = (Button) getView().findViewById(R.id.btnAddBook);
        btnNextPage = (Button) view.findViewById(R.id.btnNextPage);
        spCategory = (Spinner) getView().findViewById(R.id.spCategory);

        btnAddBook.setOnClickListener(v -> addBook());
        btnNextPage.setOnClickListener(v -> goNextPage());
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(), R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(adapter);

        spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    category = null;
                }else {
                    category = parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void goNextPage() {

    }

    private void addBook() {
        name     = etName.getText().toString();
        author  = etAuthor.getText().toString();

        try {
            pageCount = Integer.parseInt(etPageCount.getText().toString());
        } catch (NumberFormatException ex) {
            pageCount = Integer.MIN_VALUE;
        }

        if(!validate(name, author, pageCount, category)) {
            return;
        }

        Book book = new Book(name, author, pageCount, category);
        DBBooks dbBooks = DBBooks.getInstance();
        dbBooks.addBook(book);

        final Toast toast= Toast.makeText(getContext(), "Add book is successful", Toast.LENGTH_SHORT);
        toast.show();
    }

    private boolean validate(String name, String author, int pageCount, String category) {
        tvMessage.setVisibility(View.GONE);
        tvMessage.setText("");

        if(name.equals("")) {
            tvMessage.setText("*Name can't be empty.");
            tvMessage.setVisibility(View.VISIBLE);
            return false;
        }

        if(author.equals("")) {
            tvMessage.setText("*Author can't be empty.");
            tvMessage.setVisibility(View.VISIBLE);
            return false;
        }

        if(pageCount <= 0) {
            tvMessage.setText("*Page can't be smaller or equal to 0.");
            tvMessage.setVisibility(View.VISIBLE);
            return false;
        }

        if(category == null) {
            tvMessage.setText("*Select a category.");
            tvMessage.setVisibility(View.VISIBLE);
            return false;
        }

        return true;
    }
}
