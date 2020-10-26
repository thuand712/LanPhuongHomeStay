package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nguyenthitam.com.lanphuonghomestay.R;

public class ThanhToanThanhCongActivity extends AppCompatActivity {

    Toolbar toolbarThanhToanThanhCong;
    TextView txtChiDuongTTTC;
    Button btnThanhToanThanhCong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan_thanh_cong);
        toolbarThanhToanThanhCong = findViewById(R.id.toolbarThanhToanThanhCong);
        setSupportActionBar(toolbarThanhToanThanhCong);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarThanhToanThanhCong.setNavigationIcon(R.drawable.icon_menu);
        txtChiDuongTTTC = findViewById(R.id.txtChiDuongTTTC);
        txtChiDuongTTTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChiDuongActivity.class));
            }
        });

        btnThanhToanThanhCong = findViewById(R.id.btnThanhToanThanhCong);
        btnThanhToanThanhCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TrangChuActivity.class));

            }
        });

    }
}
