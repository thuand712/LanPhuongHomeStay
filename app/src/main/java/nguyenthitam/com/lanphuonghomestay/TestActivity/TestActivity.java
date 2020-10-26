package nguyenthitam.com.lanphuonghomestay.TestActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import nguyenthitam.com.lanphuonghomestay.Adapter.ChonPhongAdapter;
import nguyenthitam.com.lanphuonghomestay.Model.ChonPhong;
import nguyenthitam.com.lanphuonghomestay.R;
import nguyenthitam.com.lanphuonghomestay.View.ChonPhongActivity;

public class TestActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayList<String>dsXungHo;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        spinner = findViewById(R.id.spinerXungHo);
        dsXungHo = new ArrayList<>();
        dsXungHo.add("Anh");
        dsXungHo.add("Chị");

        adapter = new ArrayAdapter(TestActivity.this, android.R.layout.simple_list_item_1, dsXungHo);
        spinner.setAdapter(adapter);
    }
}
