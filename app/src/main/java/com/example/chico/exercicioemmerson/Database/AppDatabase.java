package com.example.chico.exercicioemmerson.Database;

import android.content.Context;

import com.example.chico.exercicioemmerson.DAO.AlunoDAO;
import com.example.chico.exercicioemmerson.DAO.DisciplinaDAO;
import com.example.chico.exercicioemmerson.DAO.NotaDAO;
import com.example.chico.exercicioemmerson.DAO.ProfessorDAO;
import com.example.chico.exercicioemmerson.Models.Aluno;
import com.example.chico.exercicioemmerson.Models.Disciplina;
import com.example.chico.exercicioemmerson.Models.Nota;
import com.example.chico.exercicioemmerson.Models.Professor;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Professor.class, Aluno.class, Disciplina.class, Nota.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AlunoDAO alunoDAO();
    public abstract DisciplinaDAO disciplinaDAO();
    public abstract NotaDAO notaDAO();
    public abstract ProfessorDAO professorDAO();
    private static AppDatabase INSTANCE;

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "sistemaAcademico")
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
