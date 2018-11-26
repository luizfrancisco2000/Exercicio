package com.example.chico.exercicioemmerson.Repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.chico.exercicioemmerson.Database.AppDatabase;
import com.example.chico.exercicioemmerson.Models.Aluno;

import java.util.List;

public class AlunoRepository {

    private final Context context;

    public AlunoRepository(Context context) {
        this.context = context;
    }

    public boolean salvar(Aluno aluno) {
        try {
            return new Salvar().execute(aluno).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(Aluno aluno) {
        try {
            return new Deletar().execute(aluno).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizar(Aluno aluno) {
        try {
            return new Atualizar().execute(aluno).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Aluno> pesquisar(String nome) {
        try {
            String nome_pesquisa = "%" + nome + "%";
            return new Pesquisar().execute(nome_pesquisa).get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Aluno> listar() {
        try {
            return new ListarTodos().execute().get();
        } catch (Exception e) {
            Log.e("ERRO REPO EDITORA", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private class Salvar extends AsyncTask<Aluno, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Aluno... alunos) {
            try {
                AppDatabase.getAppDatabase(context).alunoDAO().insertAll(alunos[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class Deletar extends AsyncTask<Aluno, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Aluno... alunos) {
            try {
                AppDatabase.getAppDatabase(context).alunoDAO().delete(alunos[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }


    private class Atualizar extends AsyncTask<Aluno, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Aluno... alunos) {
            try {
                AppDatabase.getAppDatabase(context).alunoDAO().updateAll(alunos[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class Pesquisar extends AsyncTask<String, Void, List<Aluno>> {

        @Override
        protected List<Aluno> doInBackground(String... strings) {
            try {
                return AppDatabase.getAppDatabase(context).alunoDAO().findAlunos(strings[0]);
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }

    private class ListarTodos extends AsyncTask<Void, Void, List<Aluno>> {

        @Override
        protected List<Aluno> doInBackground(Void... voids) {
            try {
                return AppDatabase.getAppDatabase(context).alunoDAO().listAlunos();
            } catch (Exception e) {
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }
}
