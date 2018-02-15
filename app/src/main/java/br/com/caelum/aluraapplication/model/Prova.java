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
public class Prova implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "prova_id")
    private Long id;

    private String materia;
    private Calendar data;

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return materia;
    }
}
