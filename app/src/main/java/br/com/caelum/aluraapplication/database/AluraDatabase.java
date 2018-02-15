package br.com.caelum.aluraapplication.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import br.com.caelum.aluraapplication.database.converter.Converters;
import br.com.caelum.aluraapplication.database.dao.AlunoDao;
import br.com.caelum.aluraapplication.database.dao.ProvaDao;
import br.com.caelum.aluraapplication.database.dao.ResultadoDao;
import br.com.caelum.aluraapplication.model.Aluno;
import br.com.caelum.aluraapplication.model.Prova;
import br.com.caelum.aluraapplication.model.Resultado;

/**
 * Created by matheusbrandino on 2/14/18.
 */

@Database(entities = {Aluno.class, Prova.class, Resultado.class}, version = 2)
@TypeConverters({Converters.class})
public abstract class AluraDatabase extends RoomDatabase{

    public abstract AlunoDao getAlunoDao();

    public abstract ProvaDao getProvaDao();

    public abstract ResultadoDao getResultadoDao();
}
