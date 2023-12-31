package edu.curso.android.integradorlibros;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.List;

import edu.curso.android.integradorlibros.bo.Book;

public class BookAdapter extends RecyclerView.Adapter<BookItemViewHolder> {

    private List<Book> books = Collections.emptyList();
    private Context context;

    public BookAdapter(List<Book> books, Context context) {
        this.books = books;
        this.context = context;
    }

    @NonNull
    @Override
    public BookItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("BookAdapter", "onCreateViewHolder");

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_book_layout, parent, false);
        BookItemViewHolder bookItemViewHolder = new BookItemViewHolder(listItem);
        return bookItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookItemViewHolder holder, int position) {
        Book book = books.get(position);
        Log.d("BookAdapter", "Recuperando datos libro: " + book);
        Glide.with(context).load("https://i.pravatar.cc/150?img=" + book.getId()).into(holder.imageViewAvatar);
        holder.textViewBookInfo.setText(book.getName());
        holder.itemContainer.setOnClickListener(view -> {
            Toast.makeText(context, "Click: " + book, Toast.LENGTH_SHORT).show();
            Intent intentVerLibro = new Intent(context, VerLibroActivity.class);
            intentVerLibro.putExtra("book", book);
            context.startActivity(intentVerLibro);
        });

    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
