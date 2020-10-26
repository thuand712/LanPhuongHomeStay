package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import nguyenthitam.com.lanphuonghomestay.R;

public class ThanhToanChuyenKhoanActivity extends AppCompatActivity {

    Toolbar toolbarThanhToanChuyenKhoan;
    Button btnThanhToanChuyenKhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan_chuyen_khoan);

        toolbarThanhToanChuyenKhoan = findViewById(R.id.toolBarThanhToanChuyenKhoan);
        setSupportActionBar(toolbarThanhToanChuyenKhoan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnThanhToanChuyenKhoan = findViewById(R.id.btnThanhToanChuyenKhoan);
        btnThanhToanChuyenKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
