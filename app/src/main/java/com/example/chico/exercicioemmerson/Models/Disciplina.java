package com.example.chico.exercicioemmerson.Models;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "disciplina")
public class Disciplina {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private List<Nota> notas;
    private Professor professor;
    private String nome;
    private List<Aluno> alunos;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
