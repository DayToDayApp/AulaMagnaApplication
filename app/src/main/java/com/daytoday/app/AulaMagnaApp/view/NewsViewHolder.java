package com.daytoday.app.AulaMagnaApp.view;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daytoday.app.AulaMagnaApp.R;
import com.daytoday.app.AulaMagnaApp.manager.News;
import com.squareup.picasso.Picasso;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    private News news;
    private CardView cv;
    private TextView cardTitle;
    private TextView cardDate;
    private TextView cardCategory;
    private TextView cardText;
    private ImageView cardPhoto;

    public NewsViewHolder(View itemView) {
        super(itemView);

        cv = (CardView)itemView.findViewById(R.id.cv);
        cardPhoto= (ImageView) itemView.findViewById(R.id.card_image_view);
        cardTitle= (TextView) itemView.findViewById(R.id.card_text_title);
        cardDate= (TextView) itemView.findViewById(R.id.card_text_date);
        cardCategory = (TextView) itemView.findViewById(R.id.card_text_category);
        cardText= (TextView) itemView.findViewById(R.id.card_text_description);
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
        cardTitle.setText(news.getTitle());
        cardText.setText(news.getText());
        cardDate.setText("" + news.getDate());
        cardCategory.setText(news.getCategory());
        try {
            Picasso.with(itemView.getContext()).load(news.getImagen()).resize(400,300).centerInside().into(cardPhoto);
        }catch (Exception e){
            Log.d("LIST ERROR", "Row " + news.getId() + " doesnt have image resource");
        }
    }
}

