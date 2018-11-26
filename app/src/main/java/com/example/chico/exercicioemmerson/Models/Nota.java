package com.example.chico.exercicioemmerson.Models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nota")
public class Nota {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private int bimestre;
    private int prova;
    private float nota;
    private Disciplina disciplina;
    public Nota() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBimestre() {
        return bimestre;
    }

    public void setBimestre(int bimestre) {
        this.bimestre = bimestre;
    }

    public int getProva() {
        return prova;
    }

    public void setProva(int prova) {
        this.prova = prova;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
