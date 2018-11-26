package com.example.chico.exercicioemmerson.DAO;

import com.example.chico.exercicioemmerson.Models.Nota;

import java.util.List;

import androidx.room.*;

public interface NotaDAO {
    @Query("SELECT * FROM nota")
    List<Nota> listNotas();


    @Query("SELECT * FROM nota n, disciplina d, aluno a WHERE n.id=d.notas and d.alunos=a.id and a.nome like :nome")
    List<Nota> findByAluno(String nome);

    @Insert
    void insertAll(Nota... notas);

    @Update
    void updateAll(Nota... notas);

    @Delete
    void delete(Nota... notas);
}
