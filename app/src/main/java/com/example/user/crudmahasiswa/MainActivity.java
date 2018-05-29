package com.example.user.crudmahasiswa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.crudmahasiswa.adapter.MahasiswaAdapter;
import com.example.user.crudmahasiswa.model.Mahasiswa;
import com.example.user.crudmahasiswa.model.MahasiswaResult;
import com.example.user.crudmahasiswa.network.ApiClient;
import com.example.user.crudmahasiswa.network.MahasiswaService;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivCobaGambar = (ImageView) findViewById(R.id.iv_coba_gambar);

//        int SDK_INT = android.os.Build.VERSION.SDK_INT;
//        if (SDK_INT > 8) {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
//                    .permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//            try {
//                URL url = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBm9jB-_4cEeaFHH8QZck3mzuPd2FygiQuM1hC4uFAu5QsBxXr");
//                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//                ivCobaGambar.setImageBitmap(bmp);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBm9jB-_4cEeaFHH8QZck3mzuPd2FygiQuM1hC4uFAu5QsBxXr")
                .into(ivCobaGambar);


        //1. data
        //1.a. data 1 dimensi array
//        String[] nama = new String[] {"kemala", "yuliana", "puspawaty"}; //menampilkan data statis
//
        //1.b. data lebih dari 1
//        Mahasiswa mahasiswa1 = new Mahasiswa();
//        mahasiswa1.setNama("Kemala Yuliana");
//        mahasiswa1.setNim("3.34.15.1.14");
//        mahasiswa1.setEmail("kemala@gmail.com");
//        mahasiswa1.setFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMdm9TwaOE33jkpfTmFZYIgO4GQELztH_ZXZYCU2lOTLQ12PkwJA");
//
//        Mahasiswa mahasiswa2 = new Mahasiswa(
//                "Masha",
//                "3.34.15.1.15",
//                "masha@gmail.com",
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRJsacl3ijlE9GrDaYu2IbEpqGXQJBszI1U4bY2cKZjn2I1HBl"
//        );
//
//        ArrayList<Mahasiswa> mahasiswas = new ArrayList<>();
//        mahasiswas.add(mahasiswa1);
//        mahasiswas.add(mahasiswa2);

        //1.c. load data API JSON (Retrofit Library)
        MahasiswaService service = ApiClient.getRetrofit().create(MahasiswaService.class);
        retrofit2.Call<MahasiswaResult> mahasiswas = service.getMahasiswas();
        mahasiswas.enqueue(new Callback<MahasiswaResult>() {
            @Override
            public void onResponse(retrofit2.Call<MahasiswaResult> call, Response<MahasiswaResult> response) {
                Toast.makeText(
                        getApplicationContext(),
                        "Jumlah mahasiswa : " + response.body().getMahasiswas().size(),
                        Toast.LENGTH_LONG
                ).show();
            }

            @Override
            public void onFailure(retrofit2.Call<MahasiswaResult> call, Throwable t) {

            }
        });

        //2. adapter
        //2.a. adapter 1 dimensi
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,
//                nama); //membuat array adapter

//        MahasiswaAdapter mahasiswaAdapter = new MahasiswaAdapter( this,
//                R.layout.item_mahasiswa,
//                mahasiswas);

        //3. activity (menampilkan data)
//        ListView lvDaftarNama = (ListView) findViewById(R.id.lv_daftar_nama);
//        lvDaftarNama.setAdapter(mahasiswaAdapter);
    }
}
