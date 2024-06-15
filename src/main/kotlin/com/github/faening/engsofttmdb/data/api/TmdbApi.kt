package com.github.faening.engsofttmdb.data.api

import com.github.faening.engsofttmdb.data.model.api.*
import com.github.faening.engsofttmdb.data.model.api.authentication.AuthenticationApiData
import com.github.faening.engsofttmdb.data.model.api.credits.CreditsApiData
import com.github.faening.engsofttmdb.data.model.api.genres.GenresPageApiData
import com.github.faening.engsofttmdb.data.model.api.movie.MovieApiData
import com.github.faening.engsofttmdb.data.model.api.reviews.ReviewApiData
import org.springframework.stereotype.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

@Service
interface TmdbApi {

    @GET("authentication")
    fun authentication(): Call<AuthenticationApiData>

    @GET("discover/movie")
    fun getAllMovies(@Query("language") language: String = "pt-BR"): Call<ResponsePageApiData<MovieApiData>>

    @GET("genre/movie/list")
    fun getAllGenres(@Query("language") language: String = "pt-BR"): Call<GenresPageApiData>

    @GET("movie/{movie_id}/credits")
    fun getMovieCredits(@Path("movie_id") movieId: Long): Call<CreditsApiData>

    @GET("movie/{movie_id}/reviews")
    fun getMovieReviews(@Path("movie_id") movieId: Long): Call<ResponsePageApiData<ReviewApiData>>

}