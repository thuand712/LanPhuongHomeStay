package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import nguyenthitam.com.lanphuonghomestay.R;

public class ThanhToanMomoActivity extends AppCompatActivity {

    Toolbar toolbarThanhToanMomo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan_momo);
        toolbarThanhToanMomo = findViewById(R.id.toolBarThanhToanMomo);
        setSupportActionBar(toolbarThanhToanMomo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
