package com.example.appnhac.Service;


import com.example.appnhac.Model.ChuDeVaTheLoai;

import com.example.appnhac.Model.Album;

import com.example.appnhac.Model.Quangcao;
import com.example.appnhac.Model.Playlist;
import com.example.appnhac.Model.Baihat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("getBanner.php")
    Call<List<Quangcao>> GetDataBanner();
    @GET("random_playlist.php")
    Call<List<Playlist>> GetPlaylist();


    @GET("chudevatheloai.php")
    Call<ChuDeVaTheLoai> GetDataChuDeVaTheLoai();


    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("baihatduocthich.php")
    Call<List<Baihat>> GetBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);

}
