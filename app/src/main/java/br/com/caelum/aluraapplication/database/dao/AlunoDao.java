package br.com.caelum.aluraapplication.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.caelum.aluraapplication.model.Aluno;

/**
 * Created by matheusbrandino on 2/14/18.
 */

@Dao
public interface AlunoDao {

    @Query("select * from aluno")
    List<Aluno> listar();

    @Insert
    void salvar(Aluno aluno);

    @Update
    void alterar(Aluno aluno);

    @Delete
    void deletar(Aluno... alunos);
}
