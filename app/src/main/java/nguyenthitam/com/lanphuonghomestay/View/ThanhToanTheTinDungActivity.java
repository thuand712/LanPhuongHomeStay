package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import nguyenthitam.com.lanphuonghomestay.R;

public class ThanhToanTheTinDungActivity extends AppCompatActivity {

    Toolbar toolbarThanhToanTheTinDung;
    Button btnThanhToanTheTinDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan_the_tin_dung);
        toolbarThanhToanTheTinDung = findViewById(R.id.toolBarThanhToanThetindung);
        setSupportActionBar(toolbarThanhToanTheTinDung);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnThanhToanTheTinDung = findViewById(R.id.btnThanhToanTheTinDung);
        btnThanhToanTheTinDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ThanhToanThanhCongActivity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
