package com.example.chico.exercicioemmerson.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "professor")
public class Professor extends Usuario {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private Disciplina disciplina;
    private String turma;

}
