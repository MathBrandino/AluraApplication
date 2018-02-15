package br.com.caelum.aluraapplication.dagger;

import android.arch.persistence.room.Room;
import android.content.Context;

import br.com.caelum.aluraapplication.application.AluraApplication;
import br.com.caelum.aluraapplication.database.AluraDatabase;
import br.com.caelum.aluraapplication.database.dao.AlunoDao;
import br.com.caelum.aluraapplication.database.dao.ProvaDao;
import br.com.caelum.aluraapplication.database.dao.ResultadoDao;
import dagger.Module;
import dagger.Provides;

/**
 * Created by matheusbrandino on 2/14/18.
 */

@Module
public class AluraModule {

    @Provides
    public Context getContext() {
        return AluraApplication.getInstance();
    }

    @Provides
    public AluraDatabase get(Context context) {

        AluraDatabase database = Room.databaseBuilder(context, AluraDatabase.class, "alura")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        return database;
    }

    @Provides
    public AlunoDao getAlunoDao(AluraDatabase database) {

        return database.getAlunoDao();
    }


    @Provides
    public ProvaDao getProvaDao(AluraDatabase database) {

        return database.getProvaDao();
    }

    @Provides
    public ResultadoDao getResultadoDao(AluraDatabase database){
        return database.getResultadoDao();
    }
}
