package br.com.caelum.aluraapplication.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import br.com.caelum.aluraapplication.R;
import br.com.caelum.aluraapplication.delegate.ResultadoDelegate;
import br.com.caelum.aluraapplication.fragment.FormularioNotasFragment;
import br.com.caelum.aluraapplication.fragment.ListaNotasFragment;
import br.com.caelum.aluraapplication.fragment.MelhoresAlunosFragment;

/**
 * Created by matheusbrandino on 2/15/18.
 */

public class ResultadosActivity extends AppCompatActivity implements ResultadoDelegate {

    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        ativaBotaoRetornar();

        bottomNavigation = findViewById(R.id.resultados_bottom_navigation);

        defineListenerPara();


    }

    private void ativaBotaoRetornar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void defineListenerPara() {
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menu_lancar_notas:

                        exibe(new FormularioNotasFragment());

                        break;


                    case R.id.menu_visualizar_notas:

                        exibe(new ListaNotasFragment());

                        break;

                    case R.id.menu_melhores_alunos:


                        exibe(new MelhoresAlunosFragment());

                        break;
                }

                return true;
            }
        });
        vaiParaLista();

    }

    private void exibe(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.resultados_frame_layout, fragment);

        transaction.commit();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();

        }

        return true;
    }

    @Override
    public void vaiParaLista() {
        bottomNavigation.setSelectedItemId(R.id.menu_visualizar_notas);

    }
}
