package nguyenthitam.com.lanphuonghomestay.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nguyenthitam.com.lanphuonghomestay.Model.UuDai;
import nguyenthitam.com.lanphuonghomestay.R;
import nguyenthitam.com.lanphuonghomestay.View.TrangChuActivity;

public class UuDaiAdapter extends RecyclerView.Adapter<UuDaiAdapter.ViewHolder> {

    ArrayList<UuDai>dsUuDai;
    Activity context;


    public UuDaiAdapter(ArrayList<UuDai> dsUuDai, Activity context) {
        this.dsUuDai = dsUuDai;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view  = (View) inflater.inflate(R.layout.custom_uudai,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgHinhUuDai.setImageResource(dsUuDai.get(position).getHinh());
        holder.txtSaleUuDai.setText(dsUuDai.get(position).getSale());
        holder.txtTieuDeUuDai.setText(dsUuDai.get(position).getTieude());
    }

    @Override
    public int getItemCount() {
        return dsUuDai.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTieuDeUuDai, txtSaleUuDai;
        ImageView imgHinhUuDai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSaleUuDai = itemView.findViewById(R.id.txtSaleUuDai);
            txtTieuDeUuDai = itemView.findViewById(R.id.txtTieuDeUuDai);
            imgHinhUuDai = itemView.findViewById(R.id.imgHinhUuDai);
        }
    }
}
