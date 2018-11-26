package com.example.chico.exercicioemmerson.DAO;

import com.example.chico.exercicioemmerson.Models.Nota;

import java.util.List;

import androidx.room.*;

public interface NotaDAO {
    @Query("SELECT * FROM nota")
    List<Nota> listNotas();


    @Query("SELECT nota FROM nota n, disciplina d, aluno a WHERE n.id=d.notas and d.alunos=a.id and a.nome like :nome")
    List<Nota> findByAluno(String nome);

    @Query("SELECT nota FROM nota n, disciplina d WHERE n.id=d.notas and d.nome like :nome")
    List<Nota> findByDisciplina(String nome);


    @Query("SELECT nota FROM nota n WHERE n.bimestre = :bimestre")
    List<Nota> findByBimestre(int bimestre);

    @Query("SELECT nota FROM nota n, disciplina d WHERE n.id=d.notas and d.nome like :nome and n.bimestre= :bimestre")
    List<Nota> findByDisciplinaAndBimestre(String nome, int bimestre);

    @Query("SELECT nota FROM nota n WHERE n.prova = :prova")
    List<Nota> findByProva(int prova);

    @Query("SELECT nota FROM nota n WHERE n.bimestre = :bimestre and n.prova=:prova")
    List<Nota> findByProvaAndBimestre(int prova, int bimestre);

    @Insert
    void insertAll(Nota... notas);

    @Update
    void updateAll(Nota... notas);

    @Delete
    void delete(Nota... notas);
}
