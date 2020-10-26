package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import nguyenthitam.com.lanphuonghomestay.Adapter.MpagerAdapter;
import nguyenthitam.com.lanphuonghomestay.R;

public class ChiTietDatPhongActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    int [] layouts = {R.layout.layout_1,R.layout.layout_2,R.layout.layout_3,R.layout.layout_4};
    MpagerAdapter mpagerAdapter;
    Button btnVietDGCTDP, btnHuyDPCTDP;
    LinearLayout Dots_Layout;
    ImageView[]dots;
    ImageView imgXemTatCa;

    ImageView imgHinhCTDP;
    LinearLayout llll1;
    int tam = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_dat_phong);

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
                startActivity(new Intent(ChiTietDatPhongActivity.this, XemTatCaHinhActivity.class));
            }
        });

        btnVietDGCTDP = findViewById(R.id.btnVietDGCTDP);
        btnVietDGCTDP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChiTietDatPhongActivity.this, VietDanhGiaPhongActivity.class));
            }
        });

        btnHuyDPCTDP = findViewById(R.id.btnHuyDPCTDP);
        btnHuyDPCTDP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChiTietDatPhongActivity.this);
                builder.setView(R.layout.dialog_canhbao);
                final AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                TextView txtODay = dialog.findViewById(R.id.txtODay);
                txtODay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(ChiTietDatPhongActivity.this, HuyPhongActivity.class));
                    }
                });

                Button btnTiepTuc = dialog.findViewById(R.id.btnTiepTuc);
                btnTiepTuc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(ChiTietDatPhongActivity.this);
                        builder1.setView(R.layout.dialog_huydatphongthanhcong);
                        AlertDialog dialog1 = builder1.create();
                        dialog1.setCanceledOnTouchOutside(false);
                        dialog1.show();
                        Button btnOK = dialog1.findViewById(R.id.btnOK);
                        btnOK.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        });
                    }
                });


                Button btnHuyThaoTac = dialog.findViewById(R.id.btnHuyThaoTac);
                btnHuyThaoTac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });



            }
        });




        imgHinhCTDP = findViewById(R.id.imgHinhCTDP);
        llll1 = findViewById(R.id.llll1);
        imgHinhCTDP.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);

        imgHinhCTDP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tam == 1)
                {
                    imgHinhCTDP.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    llll1.setVisibility(View.INVISIBLE);
                    tam = 0;
                }else if(tam == 0) {
                    imgHinhCTDP.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    llll1.setVisibility(View.VISIBLE);
                    tam=1;
                }

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
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
