package br.com.caelum.aluraapplication.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.caelum.aluraapplication.model.Prova;

/**
 * Created by matheusbrandino on 2/14/18.
 */
@Dao
public interface ProvaDao {


    @Query("select * from prova")
    List<Prova> listar();

    @Insert
    void salvar(Prova prova);

    @Update
    void alterar(Prova prova);

    @Delete
    void deletar(Prova... provas);
}
