package com.example.chico.exercicioemmerson.Repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.chico.exercicioemmerson.Database.AppDatabase;
import com.example.chico.exercicioemmerson.Models.Professor;

import java.util.List;

public class ProfessorRepository {

    private final Context context;

    public ProfessorRepository(Context context) {
        this.context = context;
    }

    public boolean salvar(Professor aluno) {
        try {
            return new Salvar().execute(aluno).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(Professor aluno) {
        try {
            return new Deletar().execute(aluno).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizar(Professor aluno) {
        try {
            return new Atualizar().execute(aluno).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Professor> listar() {
        try {
            return new ListarTodos().execute().get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private class Salvar extends AsyncTask<Professor, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Professor... alunos) {
            try {
                AppDatabase.getAppDatabase(context).professorDAO().insertAll(alunos[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class Deletar extends AsyncTask<Professor, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Professor... alunos) {
            try {
                AppDatabase.getAppDatabase(context).professorDAO().delete(alunos[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }


    private class Atualizar extends AsyncTask<Professor, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Professor... alunos) {
            try {
                AppDatabase.getAppDatabase(context).professorDAO().updateAll(alunos[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }


    private class ListarTodos extends AsyncTask<Void, Void, List<Professor>> {

        @Override
        protected List<Professor> doInBackground(Void... voids) {
            try {
                return AppDatabase.getAppDatabase(context).professorDAO().listProfessoress();
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }
}
