package com.daytoday.app.AulaMagnaApp;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daytoday.app.AulaMagnaApp.manager.News;

import java.text.SimpleDateFormat;
import java.util.List;

import static android.R.attr.y;
import static android.R.id.text1;
import static com.daytoday.app.AulaMagnaApp.R.id.cv;
import static com.daytoday.app.AulaMagnaApp.R.id.text_view;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.NewsViewHolder> {

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView cardTitle;
        TextView cardDate;
        TextView cardCategory;
        TextView cardText;
        ImageView cardPhoto;

        NewsViewHolder(View itemView) {
            super(itemView);

            cv = (CardView)itemView.findViewById(R.id.cv);
            cardPhoto= (ImageView) itemView.findViewById(R.id.card_image_view);
            cardTitle= (TextView) itemView.findViewById(R.id.card_text_title);
            cardDate= (TextView) itemView.findViewById(R.id.card_text_date);
            cardCategory= (TextView) itemView.findViewById(R.id.card_text_category);
            //cardText= (TextView) itemView.findViewById(R.id.card_text_text);


        }
    }

    private List<News> noticias;

    RVAdapter(List<News> persons){
        this.noticias = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        NewsViewHolder pvh = new NewsViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final NewsViewHolder personViewHolder, int i) {

        personViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),NewsActivity.class);
                for (int j = 0; j < noticias.size(); j++) {
                    News newe= noticias.get(j);
                    String title=newe.getTitle();
                    String text= newe.getText();
                    intent.putExtra("Title",title);
                    intent.putExtra("Text",text);
                }

                v.getContext().startActivity(intent);

            }
        });
        //personViewHolder.cardPhoto.setImageURI(noticias.get(i).getPhotoId());
        personViewHolder.cardCategory.setText(noticias.get(i).getCategory());
        personViewHolder.cardDate.setText(noticias.get(i).getDate());
        personViewHolder.cardTitle.setText(noticias.get(i).getTitle());
        //personViewHolder.cardText.setText(noticias.get(i).getText());
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }
}
