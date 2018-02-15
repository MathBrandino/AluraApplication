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
import br.com.caelum.aluraapplication.database.dao.ProvaDao;
import br.com.caelum.aluraapplication.delegate.ProvasDelegate;
import br.com.caelum.aluraapplication.model.Prova;

/**
 * Created by matheusbrandino on 2/14/18.
 */

public class ListaProvasFragment extends Fragment {


    private ListView listview;
    private ProvasDelegate delegate;

    @Inject
    public ProvaDao dao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_provas, container, false);

        AluraApplication.getInstance().getComponent().inject(this);


        delegate = (ProvasDelegate) getActivity();
        listview = view.findViewById(R.id.fragment_provas_lista);

        FloatingActionButton novo = view.findViewById(R.id.fragment_provas_fab);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Prova prova = (Prova) listview.getItemAtPosition(pos);

                delegate.vaiParaFormulario(prova);
            }
        });

        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delegate.vaiParaFormulario();
            }
        });

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        List<Prova> provas = dao.listar();
        ArrayAdapter<Prova> adapter = new ArrayAdapter<Prova>(getContext(), android.R.layout.simple_list_item_1, provas);
        listview.setAdapter(adapter);
    }
}
