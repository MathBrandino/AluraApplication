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
import br.com.caelum.aluraapplication.database.dao.ProvaDao;
import br.com.caelum.aluraapplication.model.Prova;

/**
 * Created by matheusbrandino on 2/14/18.
 */

public class FormularioProvasFragment extends Fragment {

    private Prova prova = new Prova();
    private EditText materia;
    private EditText data;

    @Inject
    public ProvaDao dao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario_provas, container, false);
        AluraApplication.getInstance().getComponent().inject(this);

        buscaCampos(view);

        populaCamposSeNecessario();

        Button salvar = view.findViewById(R.id.fragment_formulario_provas_salvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                populaProva();

                if (prova.getId() != null) {
                    dao.alterar(prova);
                } else {
                    dao.salvar(prova);
                }

                getActivity().onBackPressed();
            }
        });

        return view;

    }

    private void populaProva() {
        prova.setMateria(materia.getText().toString());
        prova.setData(Converters.convertToCalendar(data.getText().toString()));

    }

    private void populaCamposSeNecessario() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.prova = (Prova) arguments.getSerializable("prova");

            materia.setText(prova.getMateria());
            data.setText(Converters.convertToString(prova.getData()));

        }
    }

    private void buscaCampos(View view) {
        materia = view.findViewById(R.id.fragment_formulario_provas_materia);
        data = view.findViewById(R.id.fragment_formulario_provas_data);
    }
}
