package br.com.caelum.aluraapplication.dagger;

import br.com.caelum.aluraapplication.fragment.FormularioAlunoFragment;
import br.com.caelum.aluraapplication.fragment.FormularioNotasFragment;
import br.com.caelum.aluraapplication.fragment.FormularioProvasFragment;
import br.com.caelum.aluraapplication.fragment.ListaAlunosFragment;
import br.com.caelum.aluraapplication.fragment.ListaNotasFragment;
import br.com.caelum.aluraapplication.fragment.ListaProvasFragment;
import br.com.caelum.aluraapplication.fragment.MelhoresAlunosFragment;
import dagger.Component;

/**
 * Created by matheusbrandino on 2/14/18.
 */

@Component(modules = AluraModule.class)
public interface AluraComponent {
    void inject(ListaAlunosFragment listaAlunosFragment);

    void inject(FormularioAlunoFragment formularioAlunoFragment);

    void inject(FormularioProvasFragment formularioProvasFragment);

    void inject(ListaProvasFragment listaProvasFragment);

    void inject(FormularioNotasFragment formularioNotasFragment);

    void inject(ListaNotasFragment listaNotasFragment);

    void inject(MelhoresAlunosFragment melhoresAlunosFragment);
}
