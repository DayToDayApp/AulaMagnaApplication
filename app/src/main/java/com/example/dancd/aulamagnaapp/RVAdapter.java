package com.example.dancd.aulamagnaapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dancd.aulamagnaapp.manager.Noticia;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {


        CardView cv;
        TextView cardTitle;
        TextView cardDate;
        TextView cardCategory;
        TextView cardText;
        ImageView cardPhoto;

        ViewHolder(View itemView) {
            super(itemView);


            cv = (CardView)itemView.findViewById(R.id.cv);
            cardPhoto= (ImageView) itemView.findViewById(R.id.card_image_view);
            cardTitle= (TextView) itemView.findViewById(R.id.card_text_title);
            cardDate= (TextView) itemView.findViewById(R.id.card_text_date);
            cardCategory= (TextView) itemView.findViewById(R.id.card_text_category);
            cardText= (TextView) itemView.findViewById(R.id.card_text_text);
        }
    }

    private List<Noticia> noticias;

    RVAdapter(List<Noticia> persons){
        this.noticias = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;


    }

    @Override
    public void onBindViewHolder(final ViewHolder personViewHolder, int i) {

        personViewHolder.cardPhoto.setImageResource(noticias.get(i).getPhotoId());
        personViewHolder.cardCategory.setText(noticias.get(i).getCategory());
        personViewHolder.cardDate.setText(noticias.get(i).getDate());
        personViewHolder.cardTitle.setText(noticias.get(i).getTitle());
        personViewHolder.cardText.setText(noticias.get(i).getText());



    }



    @Override
    public int getItemCount() {
        return noticias.size();
    }
}
