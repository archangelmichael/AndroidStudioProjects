package com.example.radi.raytraining.grids;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.radi.raytraining.R;
import com.squareup.picasso.Picasso;

public class BooksAdapter extends BaseAdapter {

    private final Context mContext;
    private final Book[] mBooks;

    public BooksAdapter(Context context, Book[] books) {
        mBooks = books;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mBooks.length;
    }

    @Override
    public Object getItem(int position) {
        return mBooks[position];
    }

    @Override
    public long getItemId(int position) {
        return mBooks[position].getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Book book = mBooks[position];

        // view holder pattern
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.book_item, null);

            final ImageView imageViewCoverArt = (ImageView)convertView.findViewById(R.id.ivBookCover);
            final TextView nameTextView = (TextView)convertView.findViewById(R.id.tvBookName);
            final TextView authorTextView = (TextView)convertView.findViewById(R.id.tvBookAuthor);
            final ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.ivBookFavorite);

            final ViewHolder viewHolder = new ViewHolder(
                    nameTextView,
                    authorTextView,
                    imageViewCoverArt,
                    imageViewFavorite
            );

            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder)convertView.getTag();
        Picasso.with(mContext).load(book.getImageUrl()).into(viewHolder.imageViewCoverArt);
        viewHolder.nameTextView.setText(book.getName());
        viewHolder.authorTextView.setText(book.getAuthor());
        viewHolder.imageViewFavorite.setImageResource(
                book.getIsFavorite() ?
                        R.drawable.star_enabled :
                        R.drawable.star_disabled);

        return convertView;
    }

    // Your "view holder" that holds references to each subview
    private class ViewHolder {
        private final TextView nameTextView;
        private final TextView authorTextView;
        private final ImageView imageViewCoverArt;
        private final ImageView imageViewFavorite;

        public ViewHolder(TextView nameTextView,
                          TextView authorTextView,
                          ImageView imageViewCoverArt,
                          ImageView imageViewFavorite) {
            this.nameTextView = nameTextView;
            this.authorTextView = authorTextView;
            this.imageViewCoverArt = imageViewCoverArt;
            this.imageViewFavorite = imageViewFavorite;
        }
    }
}
