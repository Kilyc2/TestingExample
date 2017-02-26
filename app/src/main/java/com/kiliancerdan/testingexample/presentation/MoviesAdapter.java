package com.kiliancerdan.testingexample.presentation;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiliancerdan.testingexample.R;
import com.kiliancerdan.testingexample.presentation.entity.movie.MovieView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ItemViewHolder> {

    private final List<MovieView> movies;

    public MoviesAdapter() {
        this.movies = new ArrayList<>();
    }

    public void setMovies(List<MovieView> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        MovieView movieView = movies.get(position);
        holder.setImage(movieView.getPosterUrl());
        holder.setTitle(movieView.getTitle());
        holder.setDescription(movieView.getOverview());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView title;
        private final TextView description;

        ItemViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image_item);
            title = (TextView) itemView.findViewById(R.id.title_item);
            description = (TextView) itemView.findViewById(R.id.description_item);
        }

        void setImage(String url) {
            Picasso.with(image.getContext()).load(url).into(image);
        }

        void setTitle(String title) {
            this.title.setText(title);
        }

        void setDescription(String description) {
            this.description.setText(description);
        }
    }
}
