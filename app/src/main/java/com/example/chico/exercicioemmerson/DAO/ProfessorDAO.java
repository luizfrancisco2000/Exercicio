package com.example.chico.exercicioemmerson.DAO;

import com.example.chico.exercicioemmerson.Models.Aluno;
import com.example.chico.exercicioemmerson.Models.Professor;

import java.util.List;

import androidx.room.*;

public interface ProfessorDAO {
    @Query("SELECT * FROM professor")
    List<Professor> listProfessoress();

    @Query("SELECT * FROM professor where login like :login and senha =:senha")
    List<Aluno> loginProfessor(String login, String senha);


    @Insert
    void insertAll(Professor... notas);

    @Update
    void updateAll(Professor... notas);

    @Delete
    void delete(Professor... notas);
}
