package com.example.appnhac.Service;

import com.example.appnhac.Model.Quangcao;
import com.example.appnhac.Model.Playlist;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
    @GET("getBanner.php")
    Call<List<Quangcao>> GetDataBanner();
    @GET("random_playlist.php")
    Call<List<Playlist>> GetPlaylist();
}
