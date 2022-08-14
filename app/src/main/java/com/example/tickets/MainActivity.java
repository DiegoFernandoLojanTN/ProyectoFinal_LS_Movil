package com.example.tickets;

import android.os.Bundle;

import com.example.tickets.model.Eventos;
import com.example.tickets.model.EventosAPi;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.tickets.databinding.ActivityMainBinding;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private ImageView imgEvento;
    private TextView nombre;
    private TextView precio;
    ListView lista, lista2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);
        lista2 = (ListView) findViewById(R.id.Orden);
        getAllEventos();
        getAllOrden();
    }
    private void getAllEventos(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.173.60:8000/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        EventosAPi eventosAPi = retrofit.create(EventosAPi.class);
        System.out.println("---------------------------------");
        Call<List<Eventos>> call=eventosAPi.find();
        call.enqueue(new Callback<List<Eventos>>() {
            @Override
            public void onResponse(Call<List<Eventos>> call, Response<List<Eventos>> response) {
                try {
                    System.out.println(response.isSuccessful());
                    if (response.isSuccessful()){
                        lista.setAdapter(new Adapter(MainActivity.this, response.body()));
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                    System.out.println("---------------------------------");
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Eventos>> call, Throwable t) {
                Toast.makeText(MainActivity.this,call+"", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getAllOrden(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.173.60:8000/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        EventosAPi eventosAPi = retrofit.create(EventosAPi.class);
        Call<List<Eventos>> call=eventosAPi.orden();
        call.enqueue(new Callback<List<Eventos>>() {
            @Override
            public void onResponse(Call<List<Eventos>> call, Response<List<Eventos>> response) {
                try {
                    System.out.println(response.isSuccessful());
                    if (response.isSuccessful()){
                        lista2.setAdapter(new Adapter(MainActivity.this, response.body()));
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                    System.out.println("---------------------------------");
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<List<Eventos>> call, Throwable t) {
                Toast.makeText(MainActivity.this,call+"", Toast.LENGTH_LONG).show();
            }
        });
    }

}