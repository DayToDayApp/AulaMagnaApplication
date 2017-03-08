package com.daytoday.app.AulaMagnaApp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daytoday.app.AulaMagnaApp.NewsViewHolder;
import com.daytoday.app.AulaMagnaApp.R;
import com.daytoday.app.AulaMagnaApp.activities.NewsActivity;
import com.daytoday.app.AulaMagnaApp.manager.News;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;


public class RVAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private List<News> noticias;
    private LayoutInflater inflater;

    public RVAdapter(Context context, List<News> persons){
        this.noticias = persons;
        this.inflater=LayoutInflater.from(context);
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
        View view = inflater.inflate(R.layout.item, viewGroup, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NewsViewHolder personViewHolder, final int i) {

        final News news = noticias.get(i);
        personViewHolder.setNews(news);

        personViewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),NewsActivity.class);
                News news = noticias.get(i);
                Realm realm = Realm.getDefaultInstance();
                RealmResults<News> realmResults = realm.where(News.class).findAll();

                for (News loadnews:realmResults) {
                    noticias.add(loadnews);
                }
                intent.putExtra("news_id", news.getId());
                v.getContext().startActivity(intent);


            }
            
        });

      }


    @Override
    public int getItemCount() {
        return noticias.size();
    }


}
