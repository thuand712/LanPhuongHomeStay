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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import nguyenthitam.com.lanphuonghomestay.Adapter.MpagerAdapter;
import nguyenthitam.com.lanphuonghomestay.R;

public class VietDanhGiaPhongActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    int [] layouts = {R.layout.layout_1,R.layout.layout_2,R.layout.layout_3,R.layout.layout_4};
    MpagerAdapter mpagerAdapter;
    LinearLayout Dots_Layout;
    ImageView[]dots;

    ImageView imgXemTatCa;

    Button btnHoanTatDG;

    RadioButton rdCoSQL,rdKhongSQL,rdCoSGT,rdKhongSGT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viet_danh_gia_phong);
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
                startActivity(new Intent(VietDanhGiaPhongActivity.this, XemTatCaHinhActivity.class));
            }
        });

        btnHoanTatDG = findViewById(R.id.btnHoanTatDG);
        btnHoanTatDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VietDanhGiaPhongActivity.this);
                builder.setView(R.layout.custom_dialog_hoantatdg);
                final AlertDialog dialog = builder.create();
                dialog.show();
                Button btnOKHT = dialog.findViewById(R.id.btnOKHT);
                btnOKHT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        finish();
                        /*startActivity(new Intent(getApplicationContext(), VietDanhGiaActivity.class));*/
                    }
                });
            }
        });


        xuLyCheckRD();

    }

    private void xuLyCheckRD() {
        rdCoSQL = findViewById(R.id.rdCoSQL);
        rdKhongSQL = findViewById(R.id.rdKhongSQL);
        rdCoSGT = findViewById(R.id.rdCoSGT);
        rdKhongSGT = findViewById(R.id.rdKhongSGT);

        rdCoSQL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    rdKhongSQL.setChecked(false);
                }
            }
        });
        rdKhongSQL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    rdCoSQL.setChecked(false);
                }
            }
        });
        rdCoSGT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    rdKhongSGT.setChecked(false);
                }
            }
        });
        rdKhongSGT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    rdCoSGT.setChecked(false);
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
