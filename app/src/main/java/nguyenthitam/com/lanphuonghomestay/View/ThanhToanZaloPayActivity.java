package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import nguyenthitam.com.lanphuonghomestay.R;

public class ThanhToanZaloPayActivity extends AppCompatActivity {

    Toolbar toolbarThanhToanZaloPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan_zalo_pay);
        toolbarThanhToanZaloPay = findViewById(R.id.toolBarThanhToanZaloPay);
        setSupportActionBar(toolbarThanhToanZaloPay);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
