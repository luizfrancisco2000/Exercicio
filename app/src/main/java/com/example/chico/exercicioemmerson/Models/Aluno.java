package com.example.chico.exercicioemmerson.Models;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "aluno")
public class Aluno extends Usuario {
    private Long matricula;
    private String turma;
    private List<Disciplina> disciplinasList;

    public Aluno() {
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public List<Disciplina> getDisciplinasList() {
        return disciplinasList;
    }

    public void setDisciplinasList(List<Disciplina> disciplinasList) {
        this.disciplinasList = disciplinasList;
    }
}
