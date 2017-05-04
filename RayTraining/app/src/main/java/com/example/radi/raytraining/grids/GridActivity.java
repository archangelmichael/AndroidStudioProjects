package com.example.radi.raytraining.grids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.radi.raytraining.R;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    private Book[] books;

    private static final String FAVOURITE_BOOKS_KEY = "favorite_books_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        if (savedInstanceState == null || books == null) {
            books = Book.getBooks();
        }

        GridView gridView = (GridView)findViewById(R.id.gridView);
        final BooksAdapter booksAdapter = new BooksAdapter(this, books);
        gridView.setAdapter(booksAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Book book = books[position];
                book.toggleFavorite();

                // This tells the GridView to redraw itself
                // in turn calling your BooksAdapter's getView method again for each cell
                booksAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        final ArrayList<Integer> favoriteBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsFavorite()) {
                favoriteBooks.add(book.getId());
            }
        }

        outState.putIntegerArrayList(FAVOURITE_BOOKS_KEY, favoriteBooks);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        final ArrayList<Integer> favoriteBooks = savedInstanceState.getIntegerArrayList(FAVOURITE_BOOKS_KEY);

        for (Integer bookId : favoriteBooks) {
            for (Book book : books) {
                if (book.getId() == bookId) {
                    book.setIsFavorite(true);
                    break;
                }
            }
        }
    }
}
