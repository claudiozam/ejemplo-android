package edu.curso.android.integradorlibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.curso.android.integradorlibros.bo.Book;

public class FormLibroActivity extends AppCompatActivity {

    private Button buttonSaveBook;
    private EditText editTextBookName;
    private EditText editTextTextMultiLineBookDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_libro);

        buttonSaveBook = findViewById(R.id.buttonSaveBook);
        buttonSaveBook.setOnClickListener(view -> {
            saveBook();
        });

        editTextBookName = findViewById(R.id.editTextBookName);
        editTextTextMultiLineBookDescription = findViewById(R.id.editTextTextMultiLineBookDescription);
    }

    private void saveBook() {
        Book book = new Book();
        book.setName(editTextBookName.getText().toString());
        book.setDescription(editTextTextMultiLineBookDescription.getText().toString());

        //TODO: Guardar en alguna base de datos... o mandar por API REST
        Toast.makeText(this, "El libro fue guardado", Toast.LENGTH_SHORT).show();

        Intent intentViewBook = new Intent(this, VerLibroActivity.class);
        intentViewBook.putExtra("book", book);
        startActivity(intentViewBook);
    }
}