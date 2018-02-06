package com.example.matek3022.sanya.adapter;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matek3022.sanya.InfoActivity;
import com.example.matek3022.sanya.R;
import com.example.matek3022.sanya.transform.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by matek3022 on 06.02.18.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    private List<String> data;

    private FragmentActivity activity;

    public RVAdapter(FragmentActivity activity, List<String> data) {
        this.data = data;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.title.setText(data.get(position));
        Picasso.with(holder.image.getContext())
                .load("https://pp.userapi.com/c419521/v419521627/31a/XKJyLkCzMHk.jpg")
                .transform(new CircleTransform())
                .into(holder.image);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.title.setTransitionName("title" + data.get(position) + position);
            holder.image.setTransitionName("image" + data.get(position) + position);
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, InfoActivity.class);
                intent.putExtra(InfoActivity.EXTRA_TRANSITION_NAME, data.get(position) + position);
                intent.putExtra(InfoActivity.EXTRA_TITLE, data.get(position));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                            Pair.create((View) holder.image, "image" + data.get(position) + position),
                            Pair.create((View) holder.title, "title" + data.get(position) + position)).toBundle());
                } else {
                    activity.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.card_view)
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
