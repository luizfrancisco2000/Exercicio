package com.example.chico.exercicioemmerson.Repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.chico.exercicioemmerson.Database.AppDatabase;
import com.example.chico.exercicioemmerson.Models.Nota;

import java.util.List;

public class NotaRepository {

    private final Context context;

    public NotaRepository(Context context) {
        this.context = context;
    }

    public boolean salvar(Nota aluno) {
        try {
            return new Salvar().execute(aluno).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(Nota aluno) {
        try {
            return new Deletar().execute(aluno).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizar(Nota aluno) {
        try {
            return new Atualizar().execute(aluno).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Nota> listar() {
        try {
            return new ListarTodos().execute().get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private class Salvar extends AsyncTask<Nota, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Nota... alunos) {
            try {
                AppDatabase.getAppDatabase(context).notaDAO().insertAll(alunos[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class Deletar extends AsyncTask<Nota, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Nota... alunos) {
            try {
                AppDatabase.getAppDatabase(context).notaDAO().delete(alunos[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }


    private class Atualizar extends AsyncTask<Nota, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Nota... alunos) {
            try {
                AppDatabase.getAppDatabase(context).notaDAO().updateAll(alunos[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }


    private class ListarTodos extends AsyncTask<Void, Void, List<Nota>> {

        @Override
        protected List<Nota> doInBackground(Void... voids) {
            try {
                return AppDatabase.getAppDatabase(context).notaDAO().listNotas();
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }
}
