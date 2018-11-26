package com.example.chico.exercicioemmerson.DAO;

import com.example.chico.exercicioemmerson.Models.Professor;

import java.util.List;

import androidx.room.*;

public interface ProfessorDAO {
    @Query("SELECT * FROM professor")
    List<Professor> listProfessoress();

    @Insert
    void insertAll(Professor... notas);

    @Update
    void updateAll(Professor... notas);

    @Delete
    void delete(Professor... notas);
}
