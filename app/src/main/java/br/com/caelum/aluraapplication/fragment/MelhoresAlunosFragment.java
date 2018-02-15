package br.com.caelum.aluraapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.aluraapplication.R;
import br.com.caelum.aluraapplication.application.AluraApplication;
import br.com.caelum.aluraapplication.database.dao.ProvaDao;
import br.com.caelum.aluraapplication.database.dao.ResultadoDao;
import br.com.caelum.aluraapplication.model.Prova;
import br.com.caelum.aluraapplication.model.ResultadoComDados;

/**
 * Created by matheusbrandino on 2/15/18.
 */

public class MelhoresAlunosFragment extends Fragment {

    @Inject
    public ProvaDao provaDao;

    @Inject
    public ResultadoDao resultadoDao;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_melhores_alunos, container, false);
        AluraApplication.getInstance().getComponent().inject(this);

        final Spinner provas = view.findViewById(R.id.fragment_melhores_alunos_provas);
        final ListView lista = view.findViewById(R.id.fragment_melhores_alunos_lista);

        provas.setAdapter(new ArrayAdapter<Prova>(getContext(), android.R.layout.simple_list_item_1, provaDao.listar()));

        FloatingActionButton buscar = view.findViewById(R.id.fragment_melhores_alunos_buscar);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = provas.getSelectedItemPosition();
                Prova prova = (Prova) provas.getItemAtPosition(position);


                List<ResultadoComDados> resultados = resultadoDao.listaMelhoresAlunosNa(prova.getId());
                lista.setAdapter(new ArrayAdapter<ResultadoComDados>(getContext(), android.R.layout.simple_list_item_1, resultados));
            }
        });

        return view;
    }

}
