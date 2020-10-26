package nguyenthitam.com.lanphuonghomestay.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nguyenthitam.com.lanphuonghomestay.Model.ChonPhong;
import nguyenthitam.com.lanphuonghomestay.R;
import nguyenthitam.com.lanphuonghomestay.TestActivity.TestActivity;
import nguyenthitam.com.lanphuonghomestay.View.ChonPhongActivity;
import nguyenthitam.com.lanphuonghomestay.View.ThongTinDatPhongActivity;

public class ChonPhongAdapter extends ArrayAdapter<ChonPhong> {
    ChonPhongActivity context;
    int resource;
    List<ChonPhong> objects;
    public ChonPhongAdapter(ChonPhongActivity context, int resource, List<ChonPhong> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = this.context.getLayoutInflater();
        view = inflater.inflate(R.layout.custom_chonphong, null);

        ChonPhong chonPhong = this.objects.get(position);
        TextView txtTenPhongChonPhong = view.findViewById(R.id.txtTenPhongChonPhong);
        TextView btnDatPhongNayChonPhong = view.findViewById(R.id.btnDatPhongNayChonPhong);

        txtTenPhongChonPhong.setText(chonPhong.getTenphong().toString());
        Spinner spinner = view.findViewById(R.id.spinnerSoPhong);
        ArrayList<Integer> dsPhong = new ArrayList<>();
        dsPhong.add(1);
        dsPhong.add(2);
        dsPhong.add(3);
        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1,dsPhong);
        spinner.setAdapter(adapter);

        btnDatPhongNayChonPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ThongTinDatPhongActivity.class));
            }
        });

        return view;
    }
}
