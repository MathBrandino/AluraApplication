package br.com.caelum.aluraapplication.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.caelum.aluraapplication.model.Resultado;
import br.com.caelum.aluraapplication.model.ResultadoComDados;

/**
 * Created by matheusbrandino on 2/15/18.
 */
@Dao
public interface ResultadoDao {


    @Query("select * from resultado join prova on prova_id = provaId join aluno on aluno_id = alunoId order by provaId asc ")
    List<ResultadoComDados> listar();

    @Insert
    void salvar(Resultado resultado);

    @Query("select * from resultado join prova on prova_id = provaId join aluno on aluno_id = alunoId where provaId = :provaId  order by nota desc limit 5" )
    List<ResultadoComDados> listaMelhoresAlunosNa(Long provaId);
}