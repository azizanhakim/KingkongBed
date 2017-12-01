package net.azizanhakim.movie.main;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import net.azizanhakim.movie.R;
import net.azizanhakim.movie.data.ApiClient;
import net.azizanhakim.movie.data.dao.MovieResponseDao;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerMain;
    private MainAdapter mAdapter;
    private List<MainDao> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mAdapter = new MainAdapter(mData);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        mRecyclerMain = (RecyclerView) findViewById(R.id.recyclerMain);
        mRecyclerMain.setAdapter(mAdapter);
        mRecyclerMain.setLayoutManager(gridLayoutManager);

        ApiClient.service().getMovieList("6a43e18d4f47d2a99175dc02d7dbf3cf")
                .enqueue(new Callback<MovieResponseDao>() {
                    @Override
                    public void onResponse(Call<MovieResponseDao> call, Response<MovieResponseDao> response) {
                        if (response.isSuccessful()) {
                            for (MovieResponseDao.MovieData data : response.body().getResults()) {
                                mData.add(new MainDao(data.getTitle(), "https://image.tmdb.org/t/p/w185/" + data.getPoster_path()));
                            }

                            mAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponseDao> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

//        new Handler().postDelayed(new Runnable(){
//
//            @Override
//            public void run() {
//                mData.add(new MainDao("Satu", "https://lh3.googleusercontent.com/B4Rmc8NPG7fHIGmN65214ppzNGHNa_wuLSSJ6Dz85KJoZ0zlBFnpH16pOJBHpwA0fCs=w300"));
//                mData.add(new MainDao("Dua", "https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg"));
//                mData.add(new MainDao("Tiga", "https://lh3.googleusercontent.com/avnrtBWqSPeggEqNsIB2rLVjlDOW1pCl2yWZby4NHhO_jSXbVApLxMKloVO98AImL9Q=w300"));
//                mData.add(new MainDao("Empat", "http://profile.actionsprout.com/default.jpeg"));
//                mData.add(new MainDao("Ciek", "https://lh3.googleusercontent.com/B4Rmc8NPG7fHIGmN65214ppzNGHNa_wuLSSJ6Dz85KJoZ0zlBFnpH16pOJBHpwA0fCs=w300"));
//                mData.add(new MainDao("Duo", "https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg"));
//                mData.add(new MainDao("Tigo", "https://lh3.googleusercontent.com/avnrtBWqSPeggEqNsIB2rLVjlDOW1pCl2yWZby4NHhO_jSXbVApLxMKloVO98AImL9Q=w300"));
//                mData.add(new MainDao("Ampek", "http://profile.actionsprout.com/default.jpeg"));
//
//                mAdapter.notifyDataSetChanged();
//            }
//        }, 2000);

        Toast.makeText(this, "Loading data 3 detik. . .", Toast.LENGTH_SHORT).show();

    }
}
