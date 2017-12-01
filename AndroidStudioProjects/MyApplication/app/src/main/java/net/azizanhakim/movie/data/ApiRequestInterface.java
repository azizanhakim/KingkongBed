package net.azizanhakim.movie.data;

import net.azizanhakim.movie.data.dao.MovieResponseDao;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by J I J A N on 12/1/2017.
 */

public interface ApiRequestInterface {

    @GET("movie/popular")
    Call<MovieResponseDao> getMovieList(@Query("api_key") String api_key);

}
