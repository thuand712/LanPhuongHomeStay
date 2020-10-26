package nguyenthitam.com.lanphuonghomestay.View;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;

import nguyenthitam.com.lanphuonghomestay.Adapter.MpagerAdapter;
import nguyenthitam.com.lanphuonghomestay.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    ViewPager viewPager;
    int [] layouts = {R.layout.layout_1,R.layout.layout_2,R.layout.layout_3,R.layout.layout_4};
    MpagerAdapter mpagerAdapter;
    Button btnChonPhongTrangChu, btnChonPhongTrangChu1;
    LinearLayout Dots_Layout;
    ImageView[]dots;

    LinearLayout linearHienThiChiTiet, linearDanhGiaD,linearDanhGiaE;
    ImageView imgHienThiChiTiet;

    ImageView imgXemTatCa;
    TextView txtThongTinChiTiet, txtXemTatCaDanhGia;
    ImageView imgQuayVeTrangChu;

    NavigationView nav_view;

    ImageView imgDGA1,imgDGA2,imgDGA3,imgDGA4;
    ImageView imgDGB1,imgDGB2,imgDGB3,imgDGB4;
    ImageView imgDGC1,imgDGC2,imgDGC3,imgDGC4;
    ImageView imgDGD1,imgDGD2,imgDGD3,imgDGD4;
    ImageView imgDGE1,imgDGE2,imgDGE3,imgDGE4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        toolbar.setNavigationIcon(R.drawable.icon_menu);

        nav_view = findViewById(R.id.nav_view);
        View view = nav_view.getHeaderView(0);

        imgQuayVeTrangChu = view.findViewById(R.id.imgQuayVeTrangChu);
        imgQuayVeTrangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TrangChuActivity.class));
            }
        });


        btnChonPhongTrangChu = findViewById(R.id.btnChonPhongTrangChu);
        btnChonPhongTrangChu1 = findViewById(R.id.btnChonPhongTrangChu1);
        btnChonPhongTrangChu.setOnClickListener(this);
        btnChonPhongTrangChu1.setOnClickListener(this);
        viewPager = findViewById(R.id.viewPager);
        mpagerAdapter = new MpagerAdapter(layouts, this);
        viewPager.setAdapter(mpagerAdapter);

        Dots_Layout = findViewById(R.id.dotslayout);
        createDots(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        imgXemTatCa = findViewById(R.id.imgXemTatCa);
        imgXemTatCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, XemTatCaHinhActivity.class));
            }
        });


        linearHienThiChiTiet = findViewById(R.id.linearHienThiChiTiet);
        linearDanhGiaD = findViewById(R.id.linearDanhGiaD);
        linearDanhGiaE = findViewById(R.id.linearDanhGiaE);
        linearHienThiChiTiet.setVisibility(View.GONE);
        imgHienThiChiTiet = findViewById(R.id.imgHienThiChiTiet);
        txtXemTatCaDanhGia = findViewById(R.id.txtXemTatCaDanhGia);
        txtThongTinChiTiet = findViewById(R.id.txtThongTinChiTiet);

        imgHienThiChiTiet.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);


        imgHienThiChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtThongTinChiTiet.getText().length() == 0)
                {
                    txtThongTinChiTiet.setText("Tọa lạc tại vị trí thuận tiện ở khu Hồ Xuân Hương thuộc thành phố Đà Lạt, Lan Phương Homestay nằm trong bán kính 1,4 km từ Quảng trường Lâm Viên, 1,6 km từ Hồ Xuân Hương và 1,7 km từ Công viên Yersin. Trong số các tiện nghi của chỗ nghỉ này còn có nhà hàng, lễ tân 24 giờ, dịch vụ phòng và WiFi miễn phí. Khách sạn cung cấp bàn đặt tour, dịch vụ đặt vé và dịch vụ thu đổi ngoại tệ cho khách.\n" +
                            "\n" +
                            "Tất cả phòng nghỉ của homestay đều được trang bị tủ quần áo, TV màn hình phẳng và phòng tắm riêng.\n" +
                            "\n" +
                            "Lan Phương Homestay nằm cách Vườn Hoa Đà Lạt 3 km và Thiền viện Trúc Lâm 5 km. Sân bay gần nhất là sân bay Liên Khương, cách khách sạn 29 km. Khách sạn cung cấp dịch vụ đưa đón sân bay với một khoản phụ phí.");
                    imgHienThiChiTiet.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    linearHienThiChiTiet.setVisibility(View.VISIBLE);
                }else {
                    txtThongTinChiTiet.setText("");
                    imgHienThiChiTiet.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    linearHienThiChiTiet.setVisibility(View.GONE);
                }


            }
        });

        linearDanhGiaD.setVisibility(View.GONE);
        linearDanhGiaE.setVisibility(View.GONE);

        txtXemTatCaDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtXemTatCaDanhGia.getText().equals("Xem tất cả đánh giá"))
                {
                    txtXemTatCaDanhGia.setText("Ẩn bớt");
                    linearDanhGiaD.setVisibility(View.VISIBLE);
                    linearDanhGiaE.setVisibility(View.VISIBLE);
                }else {
                    txtXemTatCaDanhGia.setText("Xem tất cả đánh giá");
                    linearDanhGiaD.setVisibility(View.GONE);
                    linearDanhGiaE.setVisibility(View.GONE);
                }

            }
        });
        hienThiHinh();

    }

    private void hienThiHinh() {
        //Hinh1
        imgDGA1 = findViewById(R.id.imgDGA1);
        imgDGA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow2);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh2
        imgDGA2 = findViewById(R.id.imgDGA2);
        imgDGA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow3);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh3
        imgDGA3 = findViewById(R.id.imgDGA3);
        imgDGA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow2);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh4
        imgDGA4 = findViewById(R.id.imgDGA4);
        imgDGA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow4);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

        //
        //Hinh1
        imgDGB1 = findViewById(R.id.imgDGB1);
        imgDGB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow2);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh2
        imgDGB2 = findViewById(R.id.imgDGB2);
        imgDGB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow3);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh3
        imgDGB3 = findViewById(R.id.imgDGB3);
        imgDGB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow2);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh4
        imgDGB4 = findViewById(R.id.imgDGB4);
        imgDGB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow4);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //C
        //Hinh1
        imgDGC1 = findViewById(R.id.imgDGC1);
        imgDGC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow2);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh2
        imgDGC2 = findViewById(R.id.imgDGC2);
        imgDGC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow3);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh3
        imgDGC3 = findViewById(R.id.imgDGC3);
        imgDGC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow2);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh4
        imgDGC4 = findViewById(R.id.imgDGC4);
        imgDGC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow4);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //
        //Hinh1
        imgDGD1 = findViewById(R.id.imgDGD1);
        imgDGD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow2);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh2
        imgDGD2 = findViewById(R.id.imgDGD2);
        imgDGD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow3);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh3
        imgDGD3 = findViewById(R.id.imgDGD3);
        imgDGD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow2);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh4
        imgDGD4 = findViewById(R.id.imgDGD4);
        imgDGD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow4);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //
        //Hinh1
        imgDGE1 = findViewById(R.id.imgDGE1);
        imgDGE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow2);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh2
        imgDGE2 = findViewById(R.id.imgDGE2);
        imgDGE2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow3);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh3
        imgDGE3 = findViewById(R.id.imgDGE3);
        imgDGE3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow2);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //Hinh4
        imgDGE4 = findViewById(R.id.imgDGE4);
        imgDGE4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(R.layout.dialog_hienthihinh);
                AlertDialog dialog = builder.create();
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinh1);*/
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_hienthihinh);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                ImageView imgHienThiHinhDanhGia = dialog.findViewById(R.id.imgHienThiHinhDanhGia);
                imgHienThiHinhDanhGia.setImageResource(R.drawable.hinhshow4);

                Button btnDong = dialog.findViewById(R.id.btnDong);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    private void createDots(int current_position)
    {
        if(Dots_Layout!=null)
        {
            Dots_Layout.removeAllViews();
        }
        dots = new ImageView[layouts.length];

        for (int i = 0; i < layouts.length; i++)
        {
            dots[i] = new ImageView(this);
            if(i==current_position)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
            }else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            Dots_Layout.addView(dots[i],params);

        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnChonPhongTrangChu)
        {
            startActivity(new Intent(MainActivity.this, ChonPhongActivity.class));
        }

        if(view.getId() == R.id.btnChonPhongTrangChu1)
        {
            startActivity(new Intent(MainActivity.this, ChonPhongActivity.class));
        }
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
