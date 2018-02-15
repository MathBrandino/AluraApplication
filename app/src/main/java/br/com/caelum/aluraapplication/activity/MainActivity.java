package br.com.caelum.aluraapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import br.com.caelum.aluraapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView alunos = findViewById(R.id.main_card_alunos);
        CardView provas = findViewById(R.id.main_card_provas);
        CardView resultados = findViewById(R.id.main_card_resultados);

        alunos.setOnClickListener(vaiPara(AlunosActivity.class));
        provas.setOnClickListener(vaiPara(ProvasActivity.class));
        resultados.setOnClickListener(vaiPara(ResultadosActivity.class));


    }

    @NonNull
    private View.OnClickListener vaiPara(final Class clazz) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencao = new Intent(MainActivity.this, clazz);
                startActivity(intencao);
            }
        };
    }
}
