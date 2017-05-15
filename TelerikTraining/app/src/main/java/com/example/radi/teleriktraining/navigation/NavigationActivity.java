package com.example.radi.teleriktraining.navigation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.radi.teleriktraining.R;

import java.util.List;

public class NavigationActivity extends AppCompatActivity {

    private ListView lvBooks;
    private BookKeeper booksData;

    public NavigationActivity() {
        this(new BookKeeper());
    }

    public NavigationActivity(BookKeeper booksData) {
        super();
        this.booksData = booksData;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        lvBooks = (ListView) findViewById(R.id.lv_books);
        final List<Book> books = this.booksData.getBooks();

        ArrayAdapter<Book> bookAdapter = new ArrayAdapter<Book>(this, R.layout.item_book, books) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = convertView;
                if (view == null) {
                    LayoutInflater inflater = LayoutInflater.from(this.getContext());
                    view = inflater.inflate(R.layout.item_book, parent, false);

                }

                Book book = getItem(position);
                if (book != null) {
                    TextView tvBookTitle = (TextView) view.findViewById(R.id.tv_book_title);
                    String bookTitle = book.getTitle();
                    tvBookTitle.setText(bookTitle);
                }

                return view;
            }
        };

        lvBooks.setAdapter(bookAdapter);
        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book selectedBook = books.get(position);
                Intent bookSelectedIntent = new Intent(getApplicationContext(), BookDetailsActivity.class);
                bookSelectedIntent.putExtra(BookDetailsActivity.BOOK_KEY, selectedBook);
                startActivity(bookSelectedIntent);
            }
        });
    }
}
