package com.example.vanphuc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtTen,edtChieuCao,edtCanNang;
    Button btnTinhBMI;
    TextView txtBMI,txtChuanDoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTinhBMI.setOnClickListener(this);
    }

    private void addControls() {
        edtTen = (EditText) findViewById(R.id.edtTen);
        edtChieuCao = (EditText) findViewById(R.id.edtChieuCao);
        edtCanNang = (EditText) findViewById(R.id.edtCanNang);
        btnTinhBMI = (Button) findViewById(R.id.btnTinhBMI);
        txtBMI = (TextView) findViewById(R.id.txtBMI);
        txtChuanDoan = (TextView) findViewById(R.id.txtChuanDoan);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btnTinhBMI))
            xuLyTinhBMI();
    }

    private void xuLyTinhBMI() {
        double H = Double.parseDouble(edtChieuCao.getText().toString());
        double W = Double.parseDouble(edtCanNang.getText().toString());
        Double BMI = W/Math.pow(H,2);

        txtBMI.setText(BMI+"");
        if (BMI<18)
            txtChuanDoan.setText(edtTen.getText().toString()+ "Nha nguoi qua gay :)");
        else if (BMI<=24.9)
            txtChuanDoan.setText(edtTen.getText().toString()+ " Binh Thuong :)");
        else if (BMI<=29.9)
            txtChuanDoan.setText(edtTen.getText().toString()+ " Loai 1 beo phi :)");
        else if (BMI<=34.9)
            txtChuanDoan.setText(edtTen.getText().toString()+ " Loai 2 beo phi :)");
        else
            txtChuanDoan.setText(edtTen.getText().toString()+ " Loai 3 beo phi :)");
    }
}
