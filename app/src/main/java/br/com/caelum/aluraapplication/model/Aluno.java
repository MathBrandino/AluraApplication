package br.com.caelum.aluraapplication.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by matheusbrandino on 2/14/18.
 */

@Entity
public class Aluno implements Serializable {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "aluno_id")
    private Long id;

    private String nome;
    private String email;
    private Calendar nascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id  + " - " + nome;
    }
}
