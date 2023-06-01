package com.example.appnhac.Service;

import com.example.appnhac.Model.Quangcao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
    @GET("getBanner.php?fbclid=IwAR0NyKDtX76wyE642r8wTNtKPbP6NwDBwm02NiCCe6fhd5Fp0KA1sYuDdQ0")
    Call<List<Quangcao>> GetDataBanner();
}
