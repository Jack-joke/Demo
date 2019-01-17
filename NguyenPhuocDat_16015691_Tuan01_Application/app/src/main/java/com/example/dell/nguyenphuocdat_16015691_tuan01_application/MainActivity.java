package com.example.dell.nguyenphuocdat_16015691_tuan01_application;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText edtsoa, edtsob;
    private TextView tvkq;
    private Button btntong, btnhieu, btntich, btnthuong, btnuochungmax, btnthoat;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtsoa=(EditText)findViewById(R.id.edt_soa);
        edtsob=(EditText)findViewById(R.id.edt_sob);
        tvkq=(TextView) findViewById(R.id.tv_kq);

        btntong=(Button)findViewById(R.id.btn_tong);
        btnhieu=(Button)findViewById(R.id.btn_hieu);
        btntich=(Button)findViewById(R.id.btn_tich);
        btnthuong=(Button)findViewById(R.id.btn_thuong);
        btnuochungmax=(Button)findViewById(R.id.btn_uocchung);
        btnthoat=(Button)findViewById(R.id.btn_thoat);

        btntong.setOnClickListener(this);
        btnhieu.setOnClickListener(this);
        btntich.setOnClickListener(this);
        btnthuong.setOnClickListener(this);
        btnuochungmax.setOnClickListener(this);
        btnthoat.setOnClickListener(this);
    }
    public int tinhUocChung(int a, int b){
        while (a>b){
            if (a>b){
                a=a-b;
            }
            else {
                b=b-a;
            }
        }
        return a;
    }
    public  void xulyThoat(){
        builder=new AlertDialog.Builder(this);
        builder.setTitle("Thong bao thoat");
        builder.setMessage("Thoat OK?");
        builder.setIcon(R.drawable.ic_launcher_background);
        builder.setPositiveButton("Do it", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Nah man", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dlg, int i) {
                dlg.dismiss();//khong lam gi ca
            }
        });
        Dialog dlg=builder.create();
        dlg.show();
    }

    @Override
    public void onClick(View view) {
        int a=0, b=0;
        double kq;
        if (edtsoa.getText().length()>0&&edtsob.getText().length()>0){
            a=Integer.parseInt(edtsoa.getText().toString());
            b=Integer.parseInt(edtsob.getText().toString());
            switch (view.getId()){
                case R.id.btn_tong:
                    kq=a+b;
                    tvkq.setText(kq+"");
                    break;
                case R.id.btn_hieu:
                    kq=a-b;
                    tvkq.setText(kq+"");
                    break;
                case R.id.btn_tich:
                    kq=a*b;
                    tvkq.setText(kq+"");
                    break;
                case R.id.btn_thuong:
                    if (b!=0){
                        kq=a*1.0/b;
                        tvkq.setText(kq+"");
                        break;
                    }
                    else {
                        tvkq.setText("Phep chia khong hop le");
                        break;
                    }


                case R.id.btn_uocchung:
                    kq=tinhUocChung(a,b);
                    tvkq.setText(kq+"");
                    break;
                case R.id.btn_thoat:
                    xulyThoat();
                    break;
            }
        }
    }
}
