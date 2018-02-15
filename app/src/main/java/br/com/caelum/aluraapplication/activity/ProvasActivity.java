package br.com.caelum.aluraapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import br.com.caelum.aluraapplication.R;
import br.com.caelum.aluraapplication.delegate.ProvasDelegate;
import br.com.caelum.aluraapplication.fragment.FormularioProvasFragment;
import br.com.caelum.aluraapplication.fragment.ListaProvasFragment;
import br.com.caelum.aluraapplication.model.Prova;

/**
 * Created by matheusbrandino on 2/14/18.
 */

public class ProvasActivity extends AppCompatActivity implements ProvasDelegate {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provas);
        ativaBotaoVoltar();

        exibe(new ListaProvasFragment(), false);
    }

    private void ativaBotaoVoltar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void exibe(Fragment fragment, boolean empilhado) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.provas_frame_layout, fragment);
        if (empilhado)
            transaction.addToBackStack(null);

        transaction.commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return true;
    }

    @Override
    public void vaiParaFormulario() {
        exibe(new FormularioProvasFragment(),true);
    }

    @Override
    public void vaiParaFormulario(Prova prova) {
        exibe(formularioCom(prova), true);
    }

    private FormularioProvasFragment formularioCom(Prova prova) {
        FormularioProvasFragment fragment = new FormularioProvasFragment();

        Bundle arguments = new Bundle();
        arguments.putSerializable("prova", prova);
        fragment.setArguments(arguments);

        return fragment;
    }
}
