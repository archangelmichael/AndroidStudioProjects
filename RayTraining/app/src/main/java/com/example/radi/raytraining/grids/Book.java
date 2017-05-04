package com.example.radi.raytraining.grids;

public class Book {
    private final int bookId;
    private final String name;
    private final String author;
    private boolean isFavorite = false;
    private final String imageUrl;

    public Book(int id, String name, String author, String imageUrl) {
        this.bookId = id;
        this.name = name;
        this.author = author;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }
    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public void toggleFavorite() {
        isFavorite = !isFavorite;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public  static Book[] getBooks() {
        Book[] books = {
                new Book(0, "High Heat", "Richard Castle", "https://images-na.ssl-images-amazon.com/images/I/51fH4UcNDHL.jpg"),
                new Book(1, "The Lioness of Morocco", "Julia Drosten", "https://images-na.ssl-images-amazon.com/images/I/51tgke%2BoUQL.jpg"),
                new Book(2, "The Hundredth Queen", "Emily R. King", "https://images-na.ssl-images-amazon.com/images/I/51QsKafXVZL.jpg"),
                new Book(3, "The Fix", "David Baldacci", "https://images-na.ssl-images-amazon.com/images/I/512aBUTDDKL.jpg"),
                new Book(4, "Beneath a Scarlet Sky", "Mark Sullivan", "https://images-na.ssl-images-amazon.com/images/I/519GUR39-cL.jpg"),
                new Book(5, "High Heat", "Richard Castle", "https://images-na.ssl-images-amazon.com/images/I/51fH4UcNDHL.jpg"),
                new Book(6, "The Lioness of Morocco", "Julia Drosten", "https://images-na.ssl-images-amazon.com/images/I/51tgke%2BoUQL.jpg"),
                new Book(7, "The Hundredth Queen", "Emily R. King", "https://images-na.ssl-images-amazon.com/images/I/51QsKafXVZL.jpg"),
                new Book(8, "The Fix", "David Baldacci", "https://images-na.ssl-images-amazon.com/images/I/512aBUTDDKL.jpg"),
                new Book(9, "Mindfulness The Hundredth QueenThe Hundredth QueenThe Hundredth Queen", "Austin Ortiz", "https://images-na.ssl-images-amazon.com/images/I/51ggt9t6ZDL.jpg"),
                new Book(10, "Beneath a Scarlet Sky", "Mark Sullivan", "https://images-na.ssl-images-amazon.com/images/I/519GUR39-cL.jpg"),
                new Book(11, "High Heat", "Richard Castle", "https://images-na.ssl-images-amazon.com/images/I/51fH4UcNDHL.jpg"),
                new Book(12, "The Lioness of Morocco", "Julia Drosten", "https://images-na.ssl-images-amazon.com/images/I/51tgke%2BoUQL.jpg"),
                new Book(13, "The Hundredth Queen", "Emily R. King", "https://images-na.ssl-images-amazon.com/images/I/51QsKafXVZL.jpg"),
                new Book(14, "The Fix", "David Baldacci", "https://images-na.ssl-images-amazon.com/images/I/512aBUTDDKL.jpg"),
                new Book(15, "Beneath a Scarlet Sky", "Mark Sullivan", "https://images-na.ssl-images-amazon.com/images/I/519GUR39-cL.jpg")
        };

        return books;
    }
}
