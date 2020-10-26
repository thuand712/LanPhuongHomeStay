package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import nguyenthitam.com.lanphuonghomestay.R;

public class XemTatCaHinhActivity extends AppCompatActivity {
    Toolbar toolbarXemTatCaAnh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_tat_ca_hinh);

        toolbarXemTatCaAnh = findViewById(R.id.toolbarXemTatCaHinh);
        setSupportActionBar(toolbarXemTatCaAnh);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
