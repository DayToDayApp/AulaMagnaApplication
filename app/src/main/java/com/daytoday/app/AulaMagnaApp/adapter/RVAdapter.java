package com.daytoday.app.AulaMagnaApp.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.daytoday.app.AulaMagnaApp.NewsViewHolder;
import com.daytoday.app.AulaMagnaApp.R;
import com.daytoday.app.AulaMagnaApp.activities.NewsActivity;
import com.daytoday.app.AulaMagnaApp.manager.News;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.realm.RealmResults;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


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
                intent.putExtra("news", news);
                v.getContext().startActivity(intent);


            }
            
        });

      }


    @Override
    public int getItemCount() {
        return noticias.size();
    }


}
