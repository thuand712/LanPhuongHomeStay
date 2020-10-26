package nguyenthitam.com.lanphuonghomestay.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nguyenthitam.com.lanphuonghomestay.Model.ChoNghi;
import nguyenthitam.com.lanphuonghomestay.Model.UuDai;
import nguyenthitam.com.lanphuonghomestay.R;
import nguyenthitam.com.lanphuonghomestay.View.MainActivity;
import nguyenthitam.com.lanphuonghomestay.View.TrangChuActivity;

public class ChoNghiAdapter extends RecyclerView.Adapter<ChoNghiAdapter.ViewHolder> {

    ArrayList<ChoNghi>dsUuDai;
    Activity context;


    public ChoNghiAdapter(ArrayList<ChoNghi> dsUuDai, Activity context) {
        this.dsUuDai = dsUuDai;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view  = (View) inflater.inflate(R.layout.custom_chonghi,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgHinhUuDai.setImageResource(dsUuDai.get(position).getHinh());
        holder.imgHinhUuDai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context.getApplicationContext(), MainActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dsUuDai.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgHinhUuDai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhUuDai = itemView.findViewById(R.id.imgHinhChoNghi);
        }
    }
}
