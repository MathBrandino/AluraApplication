package br.com.caelum.aluraapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import br.com.caelum.aluraapplication.R;
import br.com.caelum.aluraapplication.application.AluraApplication;
import br.com.caelum.aluraapplication.database.converter.Converters;
import br.com.caelum.aluraapplication.database.dao.AlunoDao;
import br.com.caelum.aluraapplication.model.Aluno;

/**
 * Created by matheusbrandino on 2/14/18.
 */

public class FormularioAlunoFragment extends Fragment {

    private Aluno aluno = new Aluno();
    private EditText nome;
    private EditText email;
    private EditText nascimento;

    @Inject
    public AlunoDao dao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario_alunos, container, false);
        AluraApplication.getInstance().getComponent().inject(this);
        buscaCampos(view);
        populaCamposSeNecessario();

        Button salvar = view.findViewById(R.id.fragment_formulario_alunos_salvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                populaAluno();

                if (aluno.getId() == null){
                    dao.salvar(aluno);
                } else {
                    dao.alterar(aluno);
                }

                voltar();
            }
        });


        return view;
    }

    private void voltar() {
        getActivity().onBackPressed();
    }

    private void populaCamposSeNecessario() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.aluno = (Aluno) arguments.getSerializable("aluno");

            nome.setText(aluno.getNome());
            email.setText(aluno.getEmail());
            nascimento.setText(Converters.convertToString(aluno.getNascimento()));
        }
    }

    private void buscaCampos(View view) {
        nome = view.findViewById(R.id.fragment_formulario_alunos_nome);
        email = view.findViewById(R.id.fragment_formulario_alunos_email);
        nascimento = view.findViewById(R.id.fragment_formulario_alunos_nascimento);
    }

    private void populaAluno() {

        aluno.setNome(nome.getText().toString());
        aluno.setEmail(email.getText().toString());
        aluno.setNascimento(Converters.convertToCalendar(nascimento.getText().toString()));

    }
}
