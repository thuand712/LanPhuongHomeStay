package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import nguyenthitam.com.lanphuonghomestay.Adapter.HinhAdapter;
import nguyenthitam.com.lanphuonghomestay.Model.Hinh;
import nguyenthitam.com.lanphuonghomestay.R;

public class VietDanhGiaActivity extends AppCompatActivity {

    ListView lvThang12, lvThang11;

    ArrayList<Hinh> dsHinh12,dsHinh11;

    HinhAdapter hinh12Adapter,hinh11Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viet_danh_gia);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        AnhXa();
    }

    private void AnhXa() {

        lvThang12 = findViewById(R.id.lvThang12);
        dsHinh12 = new ArrayList<>();
        dsHinh12.add(new Hinh(R.drawable.hinhqldp1));
        dsHinh12.add(new Hinh(R.drawable.hinhqldp3));
        dsHinh12.add(new Hinh(R.drawable.hinhqldp4));
        hinh12Adapter = new HinhAdapter(VietDanhGiaActivity.this, R.layout.custom_quanlydatphong, dsHinh12);
        lvThang12.setAdapter(hinh12Adapter);


        lvThang11 = findViewById(R.id.lvThang11);
        dsHinh11 = new ArrayList<>();
        dsHinh11.add(new Hinh(R.drawable.hinhqldp2));
        dsHinh11.add(new Hinh(R.drawable.hinhqldp2));
        dsHinh11.add(new Hinh(R.drawable.hinhqldp5));
        dsHinh11.add(new Hinh(R.drawable.hinhqldp5));
        dsHinh11.add(new Hinh(R.drawable.hinhqldp2));
        dsHinh11.add(new Hinh(R.drawable.hinhqldp2));
        hinh11Adapter = new HinhAdapter(VietDanhGiaActivity.this, R.layout.custom_quanlydatphong, dsHinh11);
        lvThang11.setAdapter(hinh11Adapter);

        lvThang12.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getApplicationContext(), VietDanhGiaPhongActivity.class));
            }
        });

        lvThang11.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getApplicationContext(), VietDanhGiaPhongActivity.class));
            }
        });
    }

    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
