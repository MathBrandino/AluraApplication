package br.com.caelum.aluraapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.aluraapplication.R;
import br.com.caelum.aluraapplication.application.AluraApplication;
import br.com.caelum.aluraapplication.database.dao.AlunoDao;
import br.com.caelum.aluraapplication.delegate.AlunosDelegate;
import br.com.caelum.aluraapplication.model.Aluno;

/**
 * Created by matheusbrandino on 2/14/18.
 */

public class ListaAlunosFragment extends Fragment {

    private ListView listView;


    @Inject
    public AlunoDao dao;
    private AlunosDelegate delegate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_alunos, container, false);
        AluraApplication.getInstance().getComponent().inject(this);
        delegate = (AlunosDelegate) getActivity();

        listView = view.findViewById(R.id.fragment_alunos_lista);
        FloatingActionButton fab = view.findViewById(R.id.fragment_alunos_fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delegate.vaiParaFormulario();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

                Aluno aluno = (Aluno) listView.getItemAtPosition(pos);

                delegate.vaiParaFormulario(aluno);

            }
        });



        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        List<Aluno> lista = dao.listar();

        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(getContext(), android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);

    }
}

