package nguyenthitam.com.lanphuonghomestay.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import nguyenthitam.com.lanphuonghomestay.Adapter.HinhAdapter;
import nguyenthitam.com.lanphuonghomestay.Model.Hinh;
import nguyenthitam.com.lanphuonghomestay.R;

public class DanhGiaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    ListView lvThang12, lvThang11;

    ArrayList<Hinh>dsHinh12,dsHinh11;

    HinhAdapter hinh12Adapter,hinh11Adapter;

    Button btnVietDG;
    ImageView imgQuayVeTrangChu;

    NavigationView nav_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhgia);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        toolbar.setNavigationIcon(R.drawable.icon_menu);

        AnhXa();

    }

    private void AnhXa() {
        nav_view = findViewById(R.id.nav_view);
        View view = nav_view.getHeaderView(0);

        imgQuayVeTrangChu = view.findViewById(R.id.imgQuayVeTrangChu);
        imgQuayVeTrangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TrangChuActivity.class));
            }
        });
        lvThang12 = findViewById(R.id.lvThang12);
        dsHinh12 = new ArrayList<>();
        dsHinh12.add(new Hinh(R.drawable.hinhdg1));
        dsHinh12.add(new Hinh(R.drawable.hinhdg2));
        dsHinh12.add(new Hinh(R.drawable.hinhdg1));
        hinh12Adapter = new HinhAdapter(DanhGiaActivity.this, R.layout.custom_quanlydatphong, dsHinh12);
        lvThang12.setAdapter(hinh12Adapter);


        lvThang11 = findViewById(R.id.lvThang11);
        dsHinh11 = new ArrayList<>();
        dsHinh11.add(new Hinh(R.drawable.hinhdg3));
        dsHinh11.add(new Hinh(R.drawable.hinhdg3));
        hinh11Adapter = new HinhAdapter(DanhGiaActivity.this, R.layout.custom_quanlydatphong, dsHinh11);
        lvThang11.setAdapter(hinh11Adapter);

        lvThang12.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getApplicationContext(), ChiTietDanhGiaActivity.class));
            }
        });

        lvThang11.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getApplicationContext(), ChiTietDanhGiaActivity.class));
            }
        });

        btnVietDG = findViewById(R.id.btnVietDG);
        btnVietDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), VietDanhGiaActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_qldp) {
            startActivity(new Intent(getApplicationContext(), QuanLyDatPhongActivity.class));
        } else if (id == R.id.nav_dg) {
            startActivity(new Intent(getApplicationContext(), DanhGiaActivity.class));
        } else if (id == R.id.nav_qlcn) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        } else if (id == R.id.nav_cd) {

        } else if (id == R.id.nav_dx) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
