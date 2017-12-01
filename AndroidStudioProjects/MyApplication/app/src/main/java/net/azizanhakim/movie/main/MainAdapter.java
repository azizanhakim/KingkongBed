package net.azizanhakim.movie.main;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.azizanhakim.movie.R;

import java.util.List;

/**
 * Created by J I J A N on 12/1/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private List<MainDao> mData;

    public MainAdapter(List<MainDao> mData){
        this.mData = mData;
    }

    @Override
        public MainAdapter.MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_main, parent, false);
        MainHolder holder = new MainHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MainAdapter.MainHolder holder, final int position) {
        holder.textTitleRow.setText(mData.get(position).getTitle());
        Picasso.with(holder.imageRow.getContext())
                .load(mData.get(position).getImageUrl())
                .into(holder.imageRow);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent = new intent
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MainHolder extends RecyclerView.ViewHolder {
        private ImageView imageRow;
        private TextView textTitleRow;

        public MainHolder(View itemView) {
            super(itemView);

            imageRow = (ImageView) itemView.findViewById(R.id.imageRow);
            textTitleRow = (TextView) itemView.findViewById(R.id.textTitleRow);
        }
    }
}
