package edu.curso.android.integradorlibros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import edu.curso.android.integradorlibros.bo.Book;

public class ListadoLibrosActivity extends AppCompatActivity {

    private List<Book> books = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_libros);

        books = new ArrayList<>();
        books.add(new Book(1L,"Libro 1", "Ejemplo detalle 1"));
        books.add(new Book(2L,"Libro 2", "Ejemplo detalle 2"));
        books.add(new Book(3L,"Libro 3", "Ejemplo detalle 3"));


        RecyclerView recyclerViewBooks = findViewById(R.id.recyclerViewBooks);
        recyclerViewBooks.setLayoutManager(new LinearLayoutManager(this));
        //recyclerViewBooks.setHasFixedSize(true);

        BookAdapter bookAdapter = new BookAdapter(books, this);
        recyclerViewBooks.setAdapter(bookAdapter);

    }
}