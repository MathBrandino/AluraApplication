package br.com.caelum.aluraapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.aluraapplication.R;
import br.com.caelum.aluraapplication.application.AluraApplication;
import br.com.caelum.aluraapplication.database.dao.AlunoDao;
import br.com.caelum.aluraapplication.database.dao.ProvaDao;
import br.com.caelum.aluraapplication.database.dao.ResultadoDao;
import br.com.caelum.aluraapplication.delegate.ResultadoDelegate;
import br.com.caelum.aluraapplication.model.Aluno;
import br.com.caelum.aluraapplication.model.Prova;
import br.com.caelum.aluraapplication.model.Resultado;

/**
 * Created by matheusbrandino on 2/15/18.
 */

public class FormularioNotasFragment extends Fragment {

    @Inject
    public AlunoDao alunoDao;

    @Inject
    public ProvaDao provaDao;

    @Inject
    public ResultadoDao resultadoDao;

    private Resultado resultado = new Resultado();
    private Spinner spinnerAlunos;
    private Spinner spinnerProvas;
    private EditText nota;
    private ResultadoDelegate delegate;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario_notas, container, false);
        AluraApplication.getInstance().getComponent().inject(this);

        delegate = (ResultadoDelegate) getActivity();
        preencheCampos(view);

        nota = view.findViewById(R.id.fragment_formulario_notas_nota);
        Button salvar = view.findViewById(R.id.fragment_formulario_notas_salvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                populaResultado();

                resultadoDao.salvar(resultado);

                delegate.vaiParaLista();

            }
        });


        return view;

    }

    private void populaResultado() {
        resultado.setNota(Double.parseDouble(nota.getText().toString()));

        int alunoSelecionado = spinnerAlunos.getSelectedItemPosition();
        Aluno aluno = (Aluno) spinnerAlunos.getItemAtPosition(alunoSelecionado);

        resultado.setAlunoId(aluno.getId().intValue());

        int provaSelecionada = spinnerProvas.getSelectedItemPosition();
        Prova prova = (Prova) spinnerProvas.getItemAtPosition(provaSelecionada);

        resultado.setProvaId(prova.getId().intValue());
    }

    private void preencheCampos(View view) {
        spinnerAlunos = view.findViewById(R.id.fragment_formulario_notas_alunos);
        spinnerProvas = view.findViewById(R.id.fragment_formulario_notas_provas);

        List<Aluno> alunos = alunoDao.listar();
        ArrayAdapter<Aluno> adapterAlunos = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, alunos);
        spinnerAlunos.setAdapter(adapterAlunos);


        List<Prova> provas = provaDao.listar();
        ArrayAdapter<Prova> adapterProvas = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, provas);
        spinnerProvas.setAdapter(adapterProvas);
    }
}
