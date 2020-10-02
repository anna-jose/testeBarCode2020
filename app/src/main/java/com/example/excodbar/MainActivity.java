package com.example.excodbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.BitSet;

public class MainActivity extends AppCompatActivity {

    Button btTiraFoto, btLeitura;
    ImageView imFoto;
    EditText edLeitura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tiraFoto();
        lerCodigos();
    }
    private void tiraFoto(){
        btTiraFoto = (Button)findViewById(R.id.btnTiraFoto);
        imFoto = (ImageView)findViewById(R.id.imgFoto);

//        btTiraFoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent abreCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(abreCamera,0);
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Bundle bundle = data.getExtras();
//        if (data != null){
//            Bitmap bitmap = (Bitmap)bundle.get("data");
//            imFoto.setImageBitmap(bitmap);
//        }

        if (requestCode == 0){
            edLeitura.setText(data.getStringExtra("SCAN_RESULT"));
        }
    }

    private void lerCodigos(){
        btLeitura = (Button)findViewById(R.id.btnLeitura);
        edLeitura = (EditText)findViewById(R.id.edtLeitura);

        btLeitura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                startActivityForResult(intent,0);
            }
        });
    }
}