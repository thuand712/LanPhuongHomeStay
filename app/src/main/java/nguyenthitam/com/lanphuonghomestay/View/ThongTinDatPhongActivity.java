package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import nguyenthitam.com.lanphuonghomestay.Adapter.ThongTinDatPhongAdapter;
import nguyenthitam.com.lanphuonghomestay.Model.ThongTinDatPhong;
import nguyenthitam.com.lanphuonghomestay.R;

public class ThongTinDatPhongActivity extends AppCompatActivity {

    Toolbar toolbarThongTinPhong;
    Button btnDatPhongNgay, btnDatPhongThuong, btnXungHo;


    ListView lvThongTinDatPhong;
    ThongTinDatPhongAdapter thongTinDatPhongAdapter;
    ArrayList<ThongTinDatPhong> dsPhong;

    TextView txtChonGio, txtChonNgay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_dat_phong);

        toolbarThongTinPhong = findViewById(R.id.toolBarThongTinPhong);
        setSupportActionBar(toolbarThongTinPhong);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnDatPhongNgay = findViewById(R.id.btnDatPhongNgay);
        btnDatPhongThuong = findViewById(R.id.btnDatPhongThuong);
        btnXungHo = findViewById(R.id.btnXungHo);
        txtChonGio = findViewById(R.id.txtChonGio);
        txtChonNgay = findViewById(R.id.txtChonNgay);
        btnDatPhongNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ThanhToanActivity.class));
            }
        });

        btnDatPhongThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), XacNhanThanhToanActivity.class));
            }
        });



        lvThongTinDatPhong = findViewById(R.id.lvThongTinDatPhong);
        dsPhong = new ArrayList<>();
        dsPhong.add(new ThongTinDatPhong("Super Deluxe L1"));
        dsPhong.add(new ThongTinDatPhong("Super Deluxe L2"));
        dsPhong.add(new ThongTinDatPhong("Super Deluxe L3"));
        thongTinDatPhongAdapter = new ThongTinDatPhongAdapter(ThongTinDatPhongActivity.this, R.layout.custom_thongtindatphong, dsPhong);
        lvThongTinDatPhong.setAdapter(thongTinDatPhongAdapter);

        btnXungHo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu1 = new PopupMenu(ThongTinDatPhongActivity.this, btnXungHo);
                //Lấy layout
                popupMenu1.getMenuInflater().inflate(R.menu.menu_xungho, popupMenu1.getMenu());
                //Bắt sự kiện popupMenu
                popupMenu1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_anh:
                                btnXungHo.setText("Anh");
                                break;
                            case R.id.item_chi:
                                btnXungHo.setText("Chị");
                                break;
                        }
                        return false;
                    }
                });
                //Nhớ .show mới hiển thị
                popupMenu1.show();

            }
        });

        txtChonGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu2 = new PopupMenu(ThongTinDatPhongActivity.this, txtChonGio);
                //Lấy layout
                popupMenu2.getMenuInflater().inflate(R.menu.menu_gionhanphong, popupMenu2.getMenu());
                //Bắt sự kiện popupMenu
                popupMenu2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_anh:
                                txtChonGio.setText("14:00 - 15:00");
                                break;
                            case R.id.item_chi:
                                txtChonGio.setText("8:00 - 9:00");
                                break;
                        }
                        return false;
                    }
                });
                //Nhớ .show mới hiển thị
                popupMenu2.show();

            }
        });

        txtChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu3 = new PopupMenu(ThongTinDatPhongActivity.this, txtChonNgay);
                //Lấy layout
                popupMenu3.getMenuInflater().inflate(R.menu.menu_ngaynhanphong, popupMenu3.getMenu());
                //Bắt sự kiện popupMenu
                popupMenu3.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_anh:
                                txtChonNgay.setText("Thứ 6 - 22/11/2019");
                                break;
                            case R.id.item_chi:
                                txtChonNgay.setText("Thứ 7 - 23/11/2019");
                                break;
                        }
                        return false;
                    }
                });
                //Nhớ .show mới hiển thị
                popupMenu3.show();

            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
