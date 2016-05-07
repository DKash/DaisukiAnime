package br.com.dkprojectsandroid.daisukianime.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import br.com.dkprojectsandroid.daisukianime.AnimeClickListener;
import br.com.dkprojectsandroid.daisukianime.AnimesAdapter;
import br.com.dkprojectsandroid.daisukianime.R;
import br.com.dkprojectsandroid.daisukianime.classesBasicas.Anime;
import br.com.dkprojectsandroid.daisukianime.classesBasicas.Estudio;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListaAnimeFragment extends Fragment
{
    //Atributos

    @Bind(R.id.list_anime)
    ListView mLvAnimes;

    List<Anime> mAnimes;
    ArrayAdapter<Anime> mAdapter;
    AnimesTask mAnimeTask;

    @Bind(R.id.swipe)
    SwipeRefreshLayout mSwipe;

    //Métodos

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        mAnimes = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View layout = inflater.inflate(R.layout.fragment_lista_anime, container, false);
        ButterKnife.bind(this, layout);

        mAdapter = new AnimesAdapter(getContext(), mAnimes);
        mLvAnimes.setAdapter(mAdapter);

        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override public void onRefresh()
            {
                mAnimeTask = new AnimesTask();
                mAnimeTask.execute();
            }
        });
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        if(mAnimes.size() == 0 && mAnimeTask == null)
        {
            mAnimeTask = new AnimesTask();
            mAnimeTask.execute();
        }
        else if(mAnimeTask != null && mAnimeTask.getStatus() == AsyncTask.Status.RUNNING)
        {
            showProgress();
        }
    }

    private void showProgress()
    {
        mSwipe.post(new Runnable()
        {
            @Override public void run()
            {
                mSwipe.setRefreshing(true);
            }
        });
    }

    @OnItemClick(R.id.list_anime)
    void onItemClick(int position)
    {
        Anime anime = mAnimes.get(position);
        if(getActivity() instanceof AnimeClickListener)
        {
            AnimeClickListener listener = (AnimeClickListener) getActivity();
            listener.animeClicado(anime);
        }
    }

    /*Classe AnimeTask Responsável por fazer o Download do arquivo Json do DropBox
    e transformá-los em objeto Estúdio.*/

    class AnimesTask extends AsyncTask<Void, Void, Estudio>
    {
        //Métodos

        @Override protected void onPreExecute()
        {
            super.onPreExecute();

            showProgress();
        }

        @Override
        protected Estudio doInBackground(Void... params)
        {
            OkHttpClient client = new OkHttpClient();

            Request request =  new Request.Builder()
                    .url("https://dl.dropbox.com/s/0umxxajscxg2v2q/DaisukiAnime%20Projeto%20Json.txt?dl=0")
                    .build();

            try
            {
                Response response = client.newCall(request).execute();
                String jsonString = response.body().string();

                Gson gson = new Gson();
                Estudio estudio = gson.fromJson(jsonString, Estudio.class);

                return estudio;
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Estudio estudio)
        {
            super.onPostExecute(estudio);

            if(estudio != null)
            {
                mAnimes.clear();

                mAnimes.addAll(estudio.getAnimes());
                mAdapter.notifyDataSetChanged();
            }
            mSwipe.setRefreshing(false);
        }
    }
}