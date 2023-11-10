package com.example.yesornojoaofernandes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String URL = "https://yesno.wtf/api/";
    private Retrofit retrofit;
    private Button button;
    private TextView txt;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.bt);
        txt = findViewById(R.id.txt);
        progressBar = findViewById(R.id.pb);

        progressBar.setVisibility(View.GONE);

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        consultaResposta();
    }

    private void consultaResposta(){
        RestService restService = retrofit.create(RestService.class);

        Call<Resposta> call = restService.consultar();

        progressBar.setVisibility(View.VISIBLE);

        call.enqueue(new Callback<Resposta>() {
            @Override
            public void onResponse(Call<Resposta> call, Response<Resposta> response) {
                if (response.isSuccessful()) {
                    Resposta resposta = response.body();

                    txt.setText(resposta.getAnswer());

                    Toast.makeText(getApplicationContext(), "Sua resposta foi conferida", Toast.LENGTH_LONG).show();

                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<Resposta> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}