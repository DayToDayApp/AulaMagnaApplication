package com.daytoday.app.AulaMagnaApp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daytoday.app.AulaMagnaApp.R;
import com.daytoday.app.AulaMagnaApp.activities.MainActivity;
import com.daytoday.app.AulaMagnaApp.activities.NewsActivity;
import com.daytoday.app.AulaMagnaApp.manager.News;

import java.util.List;

import io.realm.RealmResults;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.NewsViewHolder> {



    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView cardTitle;
        TextView cardDate;
        TextView cardText;
        ImageView cardPhoto;

        NewsViewHolder(View itemView) {
            super(itemView);

            cv = (CardView)itemView.findViewById(R.id.cv);
            cardPhoto= (ImageView) itemView.findViewById(R.id.card_image_view);
            cardTitle= (TextView) itemView.findViewById(R.id.card_text_title);
            cardDate= (TextView) itemView.findViewById(R.id.card_text_date);
            cardText= (TextView) itemView.findViewById(R.id.card_text_description);


        }
    }

    private List<News> noticias;
    private LayoutInflater inflater;

    public RVAdapter(List<News> persons){
        this.noticias = persons;
    }
    public RVAdapter(Context context, RealmResults<News> newsRealmResults) {
        this.noticias=newsRealmResults;
        this.inflater=LayoutInflater.from(context);
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
    public void onBindViewHolder(final NewsViewHolder personViewHolder, final int i) {

        personViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent intent = new Intent(v.getContext(),NewsActivity.class);

                News news = noticias.get(i);
                intent.putExtra("news", news);
                v.getContext().startActivity(intent);

            }
        });
        personViewHolder.cardDate.setText((CharSequence) noticias.get(i).getDate());
        personViewHolder.cardTitle.setText(noticias.get(i).getTitle());
        personViewHolder.cardText.setText(noticias.get(i).getText());
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }
}
