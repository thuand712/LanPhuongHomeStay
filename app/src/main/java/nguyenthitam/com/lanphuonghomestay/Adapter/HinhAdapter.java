package nguyenthitam.com.lanphuonghomestay.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import nguyenthitam.com.lanphuonghomestay.Model.Hinh;
import nguyenthitam.com.lanphuonghomestay.R;
import nguyenthitam.com.lanphuonghomestay.View.ChiTietDatPhongActivity;

public class HinhAdapter extends ArrayAdapter<Hinh> {
    Activity context;
    int resource;
    List<Hinh> objects;
    public HinhAdapter(Activity context, int resource, List<Hinh> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    public class ViewHolder{
        ImageView imgHinhQldp;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if(view == null)
        {
            LayoutInflater inflater = this.context.getLayoutInflater();
            view = inflater.inflate(this.resource, null);
            viewHolder = new ViewHolder();
            viewHolder.imgHinhQldp = view.findViewById(R.id.imgHinhQldp);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Hinh hinh = this.objects.get(position);
        viewHolder.imgHinhQldp.setImageResource(hinh.getHinh());


        return view;
    }
}
