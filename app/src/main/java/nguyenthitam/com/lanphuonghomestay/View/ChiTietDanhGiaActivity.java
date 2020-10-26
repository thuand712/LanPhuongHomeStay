package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import nguyenthitam.com.lanphuonghomestay.Adapter.MpagerAdapter;
import nguyenthitam.com.lanphuonghomestay.R;

public class ChiTietDanhGiaActivity extends AppCompatActivity {

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
    ImageView imgDGA1,imgDGA2,imgDGA3,imgDGA4;
    RadioButton rdCoSQL,rdKhongSQL,rdCoSGT,rdKhongSGT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_danh_gia);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                startActivity(new Intent(ChiTietDanhGiaActivity.this, XemTatCaHinhActivity.class));
            }
        });


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
                final Dialog dialog = new Dialog(ChiTietDanhGiaActivity.this);
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
                final Dialog dialog = new Dialog(ChiTietDanhGiaActivity.this);
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
                final Dialog dialog = new Dialog(ChiTietDanhGiaActivity.this);
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
                final Dialog dialog = new Dialog(ChiTietDanhGiaActivity.this);
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

    private void xuLyCheckRD() {

        rdCoSQL = findViewById(R.id.rdCoSQL);
        rdKhongSQL = findViewById(R.id.rdKhongSQL);
        rdCoSGT = findViewById(R.id.rdCoSGT);
        rdKhongSGT = findViewById(R.id.rdKhongSGT);

        rdCoSGT.setChecked(true);
        rdKhongSQL.setChecked(false);
        rdCoSQL.setChecked(true);
        rdKhongSGT.setChecked(false);
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
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
