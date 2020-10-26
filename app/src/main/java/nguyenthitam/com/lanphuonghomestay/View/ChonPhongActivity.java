package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import nguyenthitam.com.lanphuonghomestay.Adapter.ChonPhongAdapter;
import nguyenthitam.com.lanphuonghomestay.Model.ChonPhong;
import nguyenthitam.com.lanphuonghomestay.R;

public class ChonPhongActivity extends AppCompatActivity {

    ListView lvChonPhong;
    ChonPhongAdapter chonPhongAdapter;
    ArrayList<ChonPhong> dsPhong;

    Toolbar toolbarChonPhong;
    Button btnDatPhongNgayChonPhong;
    ImageView imgHuongDan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_phong);
        toolbarChonPhong = findViewById(R.id.toolBarChonPhong);
        imgHuongDan = findViewById(R.id.imgHuongDan);
        setSupportActionBar(toolbarChonPhong);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgHuongDan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonPhongActivity.this);
                builder.setMessage("Mỗi 2 người lớn được dẫn theo 1 trẻ em dưới 7 tuổi. Trẻ em trên 7 tuổi được tính như một người lớn.");
                builder.show();
            }
        });

        btnDatPhongNgayChonPhong = findViewById(R.id.btnDatPhongNgayChonPhong);

        lvChonPhong = findViewById(R.id.lvChonPhong);
        dsPhong = new ArrayList<>();
        dsPhong.add(new ChonPhong("Super Deluxe L1"));
        dsPhong.add(new ChonPhong("Super Deluxe L2"));
        dsPhong.add(new ChonPhong("Super Deluxe L3"));
        dsPhong.add(new ChonPhong("Super Deluxe L4"));
        dsPhong.add(new ChonPhong("Super Deluxe L5"));
        dsPhong.add(new ChonPhong("Super Deluxe L6"));
        dsPhong.add(new ChonPhong("Super Deluxe L7"));
        dsPhong.add(new ChonPhong("Super Deluxe L8"));
        dsPhong.add(new ChonPhong("Super Deluxe L9"));
        dsPhong.add(new ChonPhong("Super Deluxe L10"));
        dsPhong.add(new ChonPhong("Super Deluxe L11"));
        dsPhong.add(new ChonPhong("Super Deluxe L12"));
        dsPhong.add(new ChonPhong("Super Deluxe L14"));
        dsPhong.add(new ChonPhong("Super Deluxe L15"));
        dsPhong.add(new ChonPhong("Super Deluxe L16"));
        dsPhong.add(new ChonPhong("Super Deluxe L17"));
        dsPhong.add(new ChonPhong("Super Deluxe L18"));
        dsPhong.add(new ChonPhong("Super Deluxe L19"));
        dsPhong.add(new ChonPhong("Super Deluxe L20"));
        dsPhong.add(new ChonPhong("Super Deluxe L21"));
        dsPhong.add(new ChonPhong("Super Deluxe L22"));
        dsPhong.add(new ChonPhong("Super Deluxe L23"));
        dsPhong.add(new ChonPhong("Super Deluxe L24"));
        dsPhong.add(new ChonPhong("Super Deluxe L25"));


        chonPhongAdapter = new ChonPhongAdapter(ChonPhongActivity.this, R.layout.custom_chonphong, dsPhong);
        lvChonPhong.setAdapter(chonPhongAdapter);

        btnDatPhongNgayChonPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChonPhongActivity.this, ThongTinDatPhongActivity.class));
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
