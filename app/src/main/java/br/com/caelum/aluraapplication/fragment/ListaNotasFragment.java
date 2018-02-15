package br.com.caelum.aluraapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.aluraapplication.R;
import br.com.caelum.aluraapplication.application.AluraApplication;
import br.com.caelum.aluraapplication.database.dao.ResultadoDao;
import br.com.caelum.aluraapplication.model.ResultadoComDados;

/**
 * Created by matheusbrandino on 2/15/18.
 */

public class ListaNotasFragment extends Fragment {

    @Inject
    public ResultadoDao resultadoDao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AluraApplication.getInstance().getComponent().inject(this);

        ListView view = (ListView) inflater.inflate(R.layout.fragment_lista_notas, container, false);


        List<ResultadoComDados> resultadoComDados = resultadoDao.listar();


        view.setAdapter(new ArrayAdapter<ResultadoComDados>(getContext(), android.R.layout.simple_list_item_1, resultadoComDados));

        return view;

    }
}
