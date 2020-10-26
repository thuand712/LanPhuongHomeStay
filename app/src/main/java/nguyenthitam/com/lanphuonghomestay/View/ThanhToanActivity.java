package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import nguyenthitam.com.lanphuonghomestay.R;

public class ThanhToanActivity extends AppCompatActivity {
    Toolbar toolbarThanhToan;
    Button btnThanhToanNgay;
    CheckBox chkTheTinDung, chkChuyenKhoan,chkZaloPay,chkMomo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);

        toolbarThanhToan = findViewById(R.id.toolBarThanhToan);
        chkTheTinDung = findViewById(R.id.chkTheTinDung);
        chkChuyenKhoan = findViewById(R.id.chkChuyenKhoan);
        chkZaloPay = findViewById(R.id.chkZaloPay);
        chkMomo = findViewById(R.id.chkMomo);
        setSupportActionBar(toolbarThanhToan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        chkTheTinDung.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    chkChuyenKhoan.setChecked(false);
                    chkMomo.setChecked(false);
                    chkZaloPay.setChecked(false);
                }
            }
        });
        chkChuyenKhoan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    chkTheTinDung.setChecked(false);
                    chkMomo.setChecked(false);
                    chkZaloPay.setChecked(false);
                }
            }
        });
        chkMomo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    chkChuyenKhoan.setChecked(false);
                    chkTheTinDung.setChecked(false);
                    chkZaloPay.setChecked(false);
                }
            }
        });
        chkZaloPay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    chkChuyenKhoan.setChecked(false);
                    chkMomo.setChecked(false);
                    chkTheTinDung.setChecked(false);
                }
            }
        });



        btnThanhToanNgay = findViewById(R.id.btnThanhToanNgay);
        btnThanhToanNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkTheTinDung.isChecked())
                {
                    startActivity(new Intent(getApplicationContext(), ThanhToanTheTinDungActivity.class));
                }
                else if(chkChuyenKhoan.isChecked())
                {
                    startActivity(new Intent(getApplicationContext(), ThanhToanChuyenKhoanActivity.class));
                }
                else if(chkZaloPay.isChecked())
                {
                    startActivity(new Intent(getApplicationContext(), ThanhToanZaloPayActivity.class));
                }
                else if(chkMomo.isChecked())
                {
                    startActivity(new Intent(getApplicationContext(), ThanhToanMomoActivity.class));
                }
                else Toast.makeText(ThanhToanActivity.this, "Vui lòng chọn hình thức thanh toán!", Toast.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
