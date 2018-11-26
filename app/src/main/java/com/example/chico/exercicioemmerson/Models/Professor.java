package com.example.chico.exercicioemmerson.Models;

import androidx.room.Entity;

@Entity(tableName = "professor")
public class Professor extends Usuario {
    private String login;
    private Disciplina disciplina;
    private String turma;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
