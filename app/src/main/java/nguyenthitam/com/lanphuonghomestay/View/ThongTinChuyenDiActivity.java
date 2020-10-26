package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import nguyenthitam.com.lanphuonghomestay.Adapter.ChoNghiAdapter;
import nguyenthitam.com.lanphuonghomestay.Adapter.UuDaiAdapter;
import nguyenthitam.com.lanphuonghomestay.Model.ChoNghi;
import nguyenthitam.com.lanphuonghomestay.Model.UuDai;
import nguyenthitam.com.lanphuonghomestay.R;

public class ThongTinChuyenDiActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    RecyclerView rvUuDai, rvXuHuong, rvChoNghiXem;
    UuDaiAdapter uuDaiAdapter;
    ChoNghiAdapter xuHuongAdapter,choNghiXemAdapter;
    ArrayList<UuDai> dsUuDai;
    ArrayList<ChoNghi>dsXuHuong,dsChoNghiXem;

    Button btnLoc, btnSx;

    ImageView imgTTCD1, imgTTCD2,imgTTCD3, imgTTCD4;

    ImageView imgQuayVeTrangChu;

    NavigationView nav_view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_chuyen_di);

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

        btnLoc = findViewById(R.id.btnLoc);
        btnSx = findViewById(R.id.btnSx);
        imgTTCD1 = findViewById(R.id.imgTTCD1);
        imgTTCD2 = findViewById(R.id.imgTTCD2);
        imgTTCD3 = findViewById(R.id.imgTTCD3);
        imgTTCD4 = findViewById(R.id.imgTTCD4);
        imgTTCD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThongTinChuyenDiActivity.this, MainActivity.class));
            }
        });
        imgTTCD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThongTinChuyenDiActivity.this, MainActivity.class));
            }
        });
        imgTTCD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThongTinChuyenDiActivity.this, MainActivity.class));
            }
        });
        imgTTCD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThongTinChuyenDiActivity.this, MainActivity.class));
            }
        });

        btnSx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builderSx = new AlertDialog.Builder(ThongTinChuyenDiActivity.this);
                builderSx.setView(R.layout.manhinh_sapxep);
                builderSx.setTitle("Sắp xếp");
                builderSx.setIcon(R.drawable.icon_sxx);
                final AlertDialog dialogSx = builderSx.create();
                dialogSx.show();

                Button btnApDungSX = dialogSx.findViewById(R.id.btnApDungSX);
                btnApDungSX.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogSx.dismiss();
                    }
                });

                Button btnHuySX = dialogSx.findViewById(R.id.btnHuySX);
                btnHuySX.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogSx.dismiss();
                    }
                });
            }
        });

        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ThongTinChuyenDiActivity.this);
                builder.setView(R.layout.manhinh_loc);
                builder.setTitle("Lọc");
                builder.setIcon(R.drawable.icon_locc);
                final AlertDialog dialog = builder.create();
                dialog.show();

                Button btnBoLoc = dialog.findViewById(R.id.btnBoLoc);
                btnBoLoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                Button btnApDung = dialog.findViewById(R.id.btnApDung);
                btnApDung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

        rvUuDai = findViewById(R.id.rvUuDaiTT);
        rvUuDai.setHasFixedSize(true);
        dsUuDai = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvUuDai.setLayoutManager(layoutManager);
        dsUuDai.add(new UuDai(R.drawable.hinh_dalat, "Đà lạt sang đông", "Sale off 20% ngày 24/12"));
        dsUuDai.add(new UuDai(R.drawable.hinh_dalat, "Vi vu phố biển", "Sale off 20% homestay tại Vũng Tàu"));
        uuDaiAdapter = new UuDaiAdapter(dsUuDai, ThongTinChuyenDiActivity.this);
        rvUuDai.setAdapter(uuDaiAdapter);

        rvXuHuong = findViewById(R.id.rvXuHuongTT);
        rvXuHuong.setHasFixedSize(true);
        dsXuHuong = new ArrayList<>();
        LinearLayoutManager layoutManagerXuHuong = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvXuHuong.setLayoutManager(layoutManagerXuHuong);
        dsXuHuong.add(new ChoNghi(R.drawable.hinh_chonghi1));
        dsXuHuong.add(new ChoNghi(R.drawable.hinh_chonghi));
        dsXuHuong.add(new ChoNghi(R.drawable.hinh_chonghi));
        dsXuHuong.add(new ChoNghi(R.drawable.hinh_chonghi));
        xuHuongAdapter = new ChoNghiAdapter(dsXuHuong, ThongTinChuyenDiActivity.this);
        rvXuHuong.setAdapter(xuHuongAdapter);

        rvChoNghiXem = findViewById(R.id.rvChoNghiXemTT);
        rvChoNghiXem.setHasFixedSize(true);
        dsChoNghiXem = new ArrayList<>();
        LinearLayoutManager layoutManagerChoNghiXem = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvChoNghiXem.setLayoutManager(layoutManagerChoNghiXem);
        dsChoNghiXem.add(new ChoNghi(R.drawable.hinh_chonghi1));
        dsChoNghiXem.add(new ChoNghi(R.drawable.hinh_chonghi));
        dsChoNghiXem.add(new ChoNghi(R.drawable.hinh_chonghi));
        dsChoNghiXem.add(new ChoNghi(R.drawable.hinh_chonghi));
        choNghiXemAdapter = new ChoNghiAdapter(dsChoNghiXem, ThongTinChuyenDiActivity.this);
        rvChoNghiXem.setAdapter(choNghiXemAdapter);
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
