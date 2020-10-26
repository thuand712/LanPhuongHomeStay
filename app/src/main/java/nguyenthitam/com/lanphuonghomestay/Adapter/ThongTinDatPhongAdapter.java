package nguyenthitam.com.lanphuonghomestay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import nguyenthitam.com.lanphuonghomestay.Model.ThongTinDatPhong;
import nguyenthitam.com.lanphuonghomestay.R;
import nguyenthitam.com.lanphuonghomestay.View.ThongTinDatPhongActivity;

public class ThongTinDatPhongAdapter extends ArrayAdapter<ThongTinDatPhong> {

    ThongTinDatPhongActivity context;
    int resource;
    List<ThongTinDatPhong> objects;
    int tam = 1;
    View view12 = null;
    public ThongTinDatPhongAdapter(ThongTinDatPhongActivity context, int resource, List<ThongTinDatPhong> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final LayoutInflater inflater = this.context.getLayoutInflater();
        view = inflater.inflate(R.layout.custom_thongtindatphong, null);

        final TextView txtTenPhongChiTietDatPhong = view.findViewById(R.id.txtTenPhongChiTietDatPhong);
        final ImageView imgChiTietL1 = view.findViewById(R.id.imgChiTietL1);
        final LinearLayout linearL1 = view.findViewById(R.id.linearL1);

        final ThongTinDatPhong thongTinDatPhong = this.objects.get(position);
        txtTenPhongChiTietDatPhong.setText(thongTinDatPhong.getTenPhong().toString());


        imgChiTietL1.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);

        imgChiTietL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tam == 1)
                {
                    imgChiTietL1.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    linearL1.setVisibility(View.VISIBLE);
                    tam = 0;
                }else if(tam == 0)
                {
                    imgChiTietL1.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    linearL1.setVisibility(View.INVISIBLE);
                    tam = 1;
                }

            }
        });


        return view;
    }
}
