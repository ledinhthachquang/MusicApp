package com.example.appnhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Activity.PlayNhacAcitvity;
import com.example.appnhac.Model.Baihat;
import com.example.appnhac.R;
import com.example.appnhac.Service.APIService;
import com.example.appnhac.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchBaiHatAdapter extends RecyclerView.Adapter<SearchBaiHatAdapter.SearchBaiHatViewHolder> implements Filterable {
    Context context;
    ArrayList<Baihat> mangbaihat;
    ArrayList<Baihat> mangbaihatold;

    public SearchBaiHatAdapter(Context context, ArrayList<Baihat> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
        this.mangbaihatold = mangbaihat;
    }

    @NonNull
    @Override
    public SearchBaiHatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_search_bai_hat,parent,false);
        return new SearchBaiHatViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull SearchBaiHatViewHolder holder, int position) {
        Baihat baihat = mangbaihat.get(position);
        holder.txtTenbaihat.setText(baihat.getTenbaihat());
        holder.txtcasi.setText(baihat.getCasi());
        Picasso.with(context).load(baihat.getHinhbaihat()).into(holder.imgbaihat);
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();
                if(strSearch.isEmpty()){
                    mangbaihat = mangbaihatold;
                }else{
                    ArrayList<Baihat> listbaihat = new ArrayList<>();
                    for (Baihat baihat : mangbaihatold){
                        if(baihat.getTenbaihat().toLowerCase().contains(strSearch.toLowerCase())){
                            listbaihat.add(baihat);
                        }
                    }
                    mangbaihat = listbaihat;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mangbaihat;
                return null;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mangbaihat = (ArrayList<Baihat>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class SearchBaiHatViewHolder extends RecyclerView.ViewHolder{
        TextView txtTenbaihat, txtcasi;
        ImageView imgbaihat,imgluotthich;

        public SearchBaiHatViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtTenbaihat = itemView.findViewById(R.id.textviewsearchtenbaihat);
            this.txtcasi = itemView.findViewById(R.id.textviewsearchcasi);
            this.imgbaihat = itemView.findViewById(R.id.imageviewSearchbaihat);
            this.imgluotthich = itemView.findViewById(R.id.imageviewSearchluotthich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayNhacAcitvity.class);
                    intent.putExtra("cakhuc",mangbaihat.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgluotthich.setImageResource(R.drawable.iconlove);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.UpdateLuotThich("1",mangbaihat.get(getPosition()).getIdbaihat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if(ketqua.equals("success")){
                                Toast.makeText(context,"Đã thích",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(context,"Lỗi",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imgluotthich.setEnabled(false);
                }
            });
        }
    }
}
