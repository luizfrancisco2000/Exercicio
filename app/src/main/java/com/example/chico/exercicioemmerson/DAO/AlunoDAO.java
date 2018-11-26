package com.example.chico.exercicioemmerson.DAO;

import com.example.chico.exercicioemmerson.Models.Aluno;

import java.util.List;

import androidx.room.*;

public interface AlunoDAO {
    @Query("SELECT * FROM aluno")
    List<Aluno> listAlunos();

    @Query("SELECT * FROM aluno where nome like :nome")
    List<Aluno> findAlunos(String nome);

    @Query("SELECT * FROM aluno where matricula like :matricula and senha =:senha")
    List<Aluno> loginAluno(long matricula, String senha);


    @Query("SELECT * FROM aluno WHERE turma= :turma")
    List<Aluno> getAlunoByTurma(String turma);

    @Insert
    void insertAll(Aluno... alunos);

    @Update
    void updateAll(Aluno... alunos);

    @Delete
    void delete(Aluno... alunos);

}
