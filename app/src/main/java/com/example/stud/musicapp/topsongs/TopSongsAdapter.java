package com.example.stud.musicapp.topsongs;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stud.musicapp.API.TrendingSingle;
import com.example.stud.musicapp.R;

import java.util.List;


/**
 * Created by W57066 on 2018-04-26.
 */

public class TopSongsAdapter extends RecyclerView.Adapter<TopSongsAdapter.TopSongsViewHolders>{


    private List<TrendingSingle>trending;
    public TopSongsAdapter(List<TrendingSingle> trending){
        this.trending=trending;
    }

    @Override
    public TopSongsViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater. from (parent.getContext());
        View view = layoutInflater.inflate(R.layout. item_top_songs, parent, false );
        return new TopSongsViewHolders(view);
    }

    @Override
    public void onBindViewHolder(TopSongsViewHolders holder, int position) {

        final TrendingSingle trendingSingle = trending.get(position);

        holder.tvPlace.setText(String.valueOf(trendingSingle.intChartPlace));
        holder.tvTrack.setText(trendingSingle.strTrack);
        holder.tvArtist.setText(trendingSingle.strArtist);
        holder.tvAlbume.setText(trendingSingle.strAlbum);
        holder.llContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),SongDetailsActivity.class);
                intent.putExtra(SongDetailsActivity.TRACK, trendingSingle.strTrack);
                intent.putExtra(SongDetailsActivity.ARTIST,trendingSingle.strArtist);
                intent.putExtra(SongDetailsActivity.TRACK_ID,trendingSingle.idTrack);
                        view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.trending != null ? this.trending.size() :0;
    }

    public class TopSongsViewHolders extends RecyclerView.ViewHolder{

        LinearLayout llContainer;
        TextView tvPlace;
        TextView tvTrack;
        TextView tvArtist;
        TextView tvAlbume;

        public TopSongsViewHolders(View itemView) {
            super(itemView);
            llContainer =itemView.findViewById(R.id.llContainers);
            tvPlace=itemView.findViewById(R.id.tvPlace);
            tvTrack=itemView.findViewById(R.id.tvTrack);
            tvArtist=itemView.findViewById(R.id.tvArtist);
            tvAlbume=itemView.findViewById(R.id.tvAlbum);
        }
    }
}
