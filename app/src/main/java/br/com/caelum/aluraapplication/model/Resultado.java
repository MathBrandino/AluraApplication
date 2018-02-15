package br.com.caelum.aluraapplication.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by matheusbrandino on 2/15/18.
 */

@Entity(foreignKeys = {@ForeignKey(entity = Aluno.class, parentColumns = "aluno_id", childColumns = "alunoId", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Prova.class, parentColumns = "prova_id", childColumns = "provaId", onDelete = ForeignKey.CASCADE)})
public class Resultado {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "resultadoId")
    private Long id;

    private int provaId;

    private int alunoId;

    private Double nota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProvaId() {
        return provaId;
    }

    public void setProvaId(int provaId) {
        this.provaId = provaId;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
