package edu.curso.android.integradorlibros;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookItemViewHolder extends RecyclerView.ViewHolder {

    TextView textViewBookInfo;
    View view;
    View itemContainer;
    ImageView imageViewAvatar;
    public BookItemViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewBookInfo = itemView.findViewById(R.id.textViewBookInfo);
        imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);
        itemContainer = itemView.findViewById(R.id.itemContainer);
        view = itemView;
    }
}
