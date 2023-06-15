package edu.curso.android.integradorlibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import edu.curso.android.integradorlibros.bo.Book;

public class VerLibroActivity extends AppCompatActivity {

    private TextView textViewBookViewName;
    private TextView textViewBookViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_libro);

        Intent intent = this.getIntent();
        Book book = (Book) intent.getExtras().getSerializable("book");

        Log.i("VerLibroActivity", "Recuperando datos del libro " + book);

        textViewBookViewName = findViewById(R.id.textViewBookViewName);
        textViewBookViewDescription = findViewById(R.id.textViewBookViewDescription);
        textViewBookViewName.setText(book.getName());
        textViewBookViewDescription.setText(book.getDescription());
    }
}