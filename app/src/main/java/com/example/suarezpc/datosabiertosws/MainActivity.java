package com.example.suarezpc.datosabiertosws;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.view.MenuItem;
import android.view.Menu;

import com.example.suarezpc.datosabiertosws.datosApi.DatosOpenApiService;
import com.example.suarezpc.datosabiertosws.models.Desmovilizados;
import com.example.suarezpc.datosabiertosws.models.Lengua;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private static final String TAG = "POKEDEX";
    private RecyclerView recyclerView;

    private boolean aptoParaCargar;
    private LenguaAdapter lenguaAdapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.acercade) {
            //Toast.makeText(this,"Se seleccionó la primer opción",Toast.LENGTH_LONG).show();

            Intent i = new Intent(this, acercadei.class );
            startActivity(i);


        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        lenguaAdapter = new LenguaAdapter(this);
        recyclerView.setAdapter(lenguaAdapter);

        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;

                            obtenerDatosLenguas();
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aptoParaCargar = true;

        obtenerDatosLenguas();
    }

    public void acercadei(View view) {
        Intent i = new Intent(this, acercadei.class );
        startActivity(i);
    }


    private void obtenerDatosLenguas()
    {
        DatosOpenApiService service = retrofit.create(DatosOpenApiService.class);
        Call<ArrayList<Lengua>> pokemonLenguaCall = service.obtenerLengua();

        pokemonLenguaCall.enqueue(new Callback<ArrayList<Lengua>>() {
            @Override
            public void onResponse(Call<ArrayList<Lengua>> call, Response<ArrayList<Lengua>> response) {
                if(response.isSuccessful()){
                    ArrayList lista = response.body();
                    lenguaAdapter.adicionarListaLengua(lista);




                }else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Lengua>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }
}
