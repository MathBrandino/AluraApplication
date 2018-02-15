package br.com.caelum.aluraapplication.model;

import android.arch.persistence.room.Embedded;

/**
 * Created by matheusbrandino on 2/15/18.
 */

public class ResultadoComDados {

    @Embedded
    public Prova prova;

    @Embedded
    public Aluno aluno;

    @Embedded
    public Resultado resultado;


    @Override
    public String toString() {
        return aluno.getNome() + "\nNa prova : " + prova.getMateria() + " tirou : " + resultado.getNota();
    }
}
