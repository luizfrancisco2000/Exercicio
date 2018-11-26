package com.example.chico.exercicioemmerson.Repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.chico.exercicioemmerson.Database.AppDatabase;
import com.example.chico.exercicioemmerson.Models.Disciplina;

import java.util.List;

public class DisciplinaRepository {

    private final Context context;

    public DisciplinaRepository(Context context) {
        this.context = context;
    }

    public boolean salvar(Disciplina aluno) {
        try {
            return new Salvar().execute(aluno).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(Disciplina aluno) {
        try {
            return new Deletar().execute(aluno).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizar(Disciplina aluno) {
        try {
            return new Atualizar().execute(aluno).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Disciplina> pesquisar(String nome) {
        try {
            String nome_pesquisa = "%" + nome + "%";
            return new Pesquisar().execute(nome_pesquisa).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Disciplina> listar() {
        try {
            return new ListarTodos().execute().get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private class Salvar extends AsyncTask<Disciplina, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Disciplina... alunos) {
            try {
                AppDatabase.getAppDatabase(context).disciplinaDAO().insertAll(alunos[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class Deletar extends AsyncTask<Disciplina, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Disciplina... alunos) {
            try {
                AppDatabase.getAppDatabase(context).disciplinaDAO().delete(alunos[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }


    private class Atualizar extends AsyncTask<Disciplina, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Disciplina... alunos) {
            try {
                AppDatabase.getAppDatabase(context).disciplinaDAO().updateAll(alunos[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class Pesquisar extends AsyncTask<String, Void, List<Disciplina>> {

        @Override
        protected List<Disciplina> doInBackground(String... strings) {
            try {
                return AppDatabase.getAppDatabase(context).disciplinaDAO().findDisciplinas(strings[0]);
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }

    private class ListarTodos extends AsyncTask<Void, Void, List<Disciplina>> {

        @Override
        protected List<Disciplina> doInBackground(Void... voids) {
            try {
                return AppDatabase.getAppDatabase(context).disciplinaDAO().listDisciplinas();
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }
}
