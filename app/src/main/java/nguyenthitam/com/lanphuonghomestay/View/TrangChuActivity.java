package nguyenthitam.com.lanphuonghomestay.View;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import nguyenthitam.com.lanphuonghomestay.Adapter.ChoNghiAdapter;
import nguyenthitam.com.lanphuonghomestay.Adapter.UuDaiAdapter;
import nguyenthitam.com.lanphuonghomestay.Model.ChoNghi;
import nguyenthitam.com.lanphuonghomestay.Model.UuDai;
import nguyenthitam.com.lanphuonghomestay.R;

public class TrangChuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView rvDiemDen, rvUuDai, rvChoNghi, rvXuHuong,rvChoNghiXem;
    UuDaiAdapter uuDaiAdapter, diemDenAdapter;
    ChoNghiAdapter choNghiAdapter, xuHuongAdapter,choNghiXemAdapter;
    ArrayList<UuDai>dsUuDai,dsDiemDen;
    ArrayList<ChoNghi>dsChoNghi,dsXuHuong,dsChoNghiXem;

    Button btnTimChoPhuHop;

    ImageView imgQuayVeTrangChu;

    NavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
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

        rvUuDai = findViewById(R.id.rvUuDai);
        rvUuDai.setHasFixedSize(true);
        dsUuDai = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvUuDai.setLayoutManager(layoutManager);
        dsUuDai.add(new UuDai(R.drawable.hinh_dalat, "Đà lạt sang đông", "Sale off 20% ngày 24/12"));
        dsUuDai.add(new UuDai(R.drawable.hinh_dalat, "Vi vu phố biển", "Sale off 20% homestay tại Vũng Tàu"));
        uuDaiAdapter = new UuDaiAdapter(dsUuDai, TrangChuActivity.this);
        rvUuDai.setAdapter(uuDaiAdapter);

        rvDiemDen = findViewById(R.id.rvDiemDen);
        rvDiemDen.setHasFixedSize(true);
        dsDiemDen = new ArrayList<>();
        LinearLayoutManager layoutManagerDiemDen = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvDiemDen.setLayoutManager(layoutManagerDiemDen);
        dsDiemDen.add(new UuDai(R.drawable.hinh_dalat, "Đà Lạt", "2003 chỗ nghỉ"));
        dsDiemDen.add(new UuDai(R.drawable.hinh_dalat, "Vũng Tàu", "1794 chỗ nghỉ"));
        diemDenAdapter = new UuDaiAdapter(dsDiemDen, TrangChuActivity.this);
        rvDiemDen.setAdapter(diemDenAdapter);

        rvChoNghi = findViewById(R.id.rvChoNghi);
        rvChoNghi.setHasFixedSize(true);
        dsChoNghi = new ArrayList<>();
        LinearLayoutManager layoutManagerChoNghi = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvChoNghi.setLayoutManager(layoutManagerChoNghi);
        dsChoNghi.add(new ChoNghi(R.drawable.hinh_chonghi1));
        dsChoNghi.add(new ChoNghi(R.drawable.hinh_chonghi));
        dsChoNghi.add(new ChoNghi(R.drawable.hinh_chonghi));
        dsChoNghi.add(new ChoNghi(R.drawable.hinh_chonghi));
        choNghiAdapter = new ChoNghiAdapter(dsChoNghi, TrangChuActivity.this);
        rvChoNghi.setAdapter(choNghiAdapter);

        rvXuHuong = findViewById(R.id.rvXuHuong);
        rvXuHuong.setHasFixedSize(true);
        dsXuHuong = new ArrayList<>();
        LinearLayoutManager layoutManagerXuHuong = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvXuHuong.setLayoutManager(layoutManagerXuHuong);
        dsXuHuong.add(new ChoNghi(R.drawable.hinh_chonghi1));
        dsXuHuong.add(new ChoNghi(R.drawable.hinh_chonghi));
        dsXuHuong.add(new ChoNghi(R.drawable.hinh_chonghi));
        dsXuHuong.add(new ChoNghi(R.drawable.hinh_chonghi));
        xuHuongAdapter = new ChoNghiAdapter(dsXuHuong, TrangChuActivity.this);
        rvXuHuong.setAdapter(xuHuongAdapter);


        rvChoNghiXem = findViewById(R.id.rvChoNghiXem);
        rvChoNghiXem.setHasFixedSize(true);
        dsChoNghiXem = new ArrayList<>();
        LinearLayoutManager layoutManagerChoNghiXem = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvChoNghiXem.setLayoutManager(layoutManagerChoNghiXem);
        dsChoNghiXem.add(new ChoNghi(R.drawable.hinh_chonghi1));
        dsChoNghiXem.add(new ChoNghi(R.drawable.hinh_chonghi));
        dsChoNghiXem.add(new ChoNghi(R.drawable.hinh_chonghi));
        dsChoNghiXem.add(new ChoNghi(R.drawable.hinh_chonghi));
        choNghiXemAdapter = new ChoNghiAdapter(dsChoNghiXem, TrangChuActivity.this);
        rvChoNghiXem.setAdapter(choNghiXemAdapter);


        btnTimChoPhuHop = findViewById(R.id.btnTimChoPhuHop);
        btnTimChoPhuHop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrangChuActivity.this, ThongTinChuyenDiActivity.class));
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
