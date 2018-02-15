package br.com.caelum.aluraapplication.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import br.com.caelum.aluraapplication.R;
import br.com.caelum.aluraapplication.delegate.AlunosDelegate;
import br.com.caelum.aluraapplication.fragment.FormularioAlunoFragment;
import br.com.caelum.aluraapplication.fragment.ListaAlunosFragment;
import br.com.caelum.aluraapplication.model.Aluno;

/**
 * Created by matheusbrandino on 2/14/18.
 */

public class AlunosActivity extends AppCompatActivity implements AlunosDelegate {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos);
        ativaBotaoVoltar();

        exibe(new ListaAlunosFragment(), false);
    }

    private void exibe(Fragment fragment, boolean empilhado) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.alunos_frame_layout, fragment);
        if (empilhado)
            transaction.addToBackStack(null);

        transaction.commit();
    }

    private void ativaBotaoVoltar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void vaiParaFormulario() {
        exibe(new FormularioAlunoFragment(), true);
    }

    @Override
    public void vaiParaFormulario(Aluno aluno) {

        exibe(formularioCom(aluno), true);

    }

    @NonNull
    private FormularioAlunoFragment formularioCom(Aluno aluno) {
        FormularioAlunoFragment formulario = new FormularioAlunoFragment();

        Bundle arguments = new Bundle();
        arguments.putSerializable("aluno", aluno);

        formulario.setArguments(arguments);
        return formulario;
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
}
