package nguyenthitam.com.lanphuonghomestay.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import nguyenthitam.com.lanphuonghomestay.R;

public class ChiDuongActivity extends AppCompatActivity {

    Toolbar toolBarTimDuongDi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_duong);
        toolBarTimDuongDi = findViewById(R.id.toolBarTimDuongDi);
        setSupportActionBar(toolBarTimDuongDi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
