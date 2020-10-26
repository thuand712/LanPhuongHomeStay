package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import nguyenthitam.com.lanphuonghomestay.R;

public class HuyPhongActivity extends AppCompatActivity {

    Button btnTiepTucDPCSHP, btnVeTTCSHP;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huy_phong);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnTiepTucDPCSHP = findViewById(R.id.btnTiepTucDPCSHP);
        btnTiepTucDPCSHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChiTietDatPhongActivity.class));
            }
        });
        btnVeTTCSHP = findViewById(R.id.btnVeTTCSHP);
        btnVeTTCSHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TrangChuActivity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
