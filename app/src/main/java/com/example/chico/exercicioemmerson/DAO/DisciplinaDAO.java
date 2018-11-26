package com.example.chico.exercicioemmerson.DAO;

import com.example.chico.exercicioemmerson.Models.Aluno;
import com.example.chico.exercicioemmerson.Models.Disciplina;

import java.util.List;

import androidx.room.*;

public interface DisciplinaDAO {
    @Query("SELECT * FROM disciplina")
    List<Disciplina> listDisciplinas();

    @Query("SELECT * FROM disciplina where nome like :nome")
    List<Disciplina> findDisciplinas(String nome);


    @Insert
    void insertAll(Disciplina... disciplinas);

    @Update
    void updateAll(Disciplina... disciplinas);

    @Delete
    void delete(Disciplina... disciplinas);
}
