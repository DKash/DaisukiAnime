package br.com.dkprojectsandroid.daisukianime.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.Toast;

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

    @Bind(R.id.empty)
    View mEmpty;

    Request request;

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

        mLvAnimes.setEmptyView(mEmpty);

        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override public void onRefresh()
            {
                iniciarTask();
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
            iniciarTask();
        }
        else if(mAnimeTask != null && mAnimeTask.getStatus() == AsyncTask.Status.RUNNING)
        {
            showProgress();
        }
    }

    private void iniciarTask()
    {
        ConnectivityManager cm = (ConnectivityManager)getActivity()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if(info != null && info.isConnected())
        {
            mAnimeTask = new AnimesTask();
            mAnimeTask.execute();
        }
        else
        {
            mSwipe.setRefreshing(false);
            Toast.makeText(getActivity(),
                    getString(R.string.no_conection),
                    Toast.LENGTH_LONG).show();
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

            String url_EN = "https://dl.dropbox.com/s/fe8ixyytephw7rs/DaisukiAnime%20Projeto%20Json%20English.txt?dl=0";
            String url_DE = "https://dl.dropbox.com/s/snkrhupl12h0kkx/DaisukiAnime%20Projeto%20Json%20Deutch.txt?dl=0";
            String url_ES = "https://dl.dropbox.com/s/zf048pnnorvz7aq/DaisukiAnime%20Projeto%20Json%20Spanish.txt?dl=0";
            String url_FR = "https://dl.dropbox.com/s/8h4e5e73380xu71/DaisukiAnime%20Projeto%20Json%20French.txt?dl=0";
            String url_JA = "https://dl.dropbox.com/s/8geglrcz12n3mq4/DaisukiAnime%20Projeto%20Json%20Japanese.txt?dl=0";
            String url_PT = "https://dl.dropbox.com/s/0umxxajscxg2v2q/DaisukiAnime%20Projeto%20Json.txt?dl=0";

            String language = getResources().getConfiguration().locale.getLanguage();

            if(language.equals("pt"))
            {
                baixarJson(url_PT);
            }
            else if(language.equals("es"))
            {
                baixarJson(url_ES);
            }
            else if(language.equals("fr"))
            {
                baixarJson(url_FR);
            }
            else if(language.equals("de"))
            {
                baixarJson(url_DE);
            }
            else if(language.equals("ja"))
            {
                baixarJson(url_JA);
            }
            else
            {
                baixarJson(url_EN);
            }

            /*Request request =  new Request.Builder()
                    .url("https://dl.dropbox.com/s/0umxxajscxg2v2q/DaisukiAnime%20Projeto%20Json.txt?dl=0")
                    .build();*/

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

            if(getResources().getBoolean(R.bool.tablet)
            && mAnimes.size() > 0)
            {
                onItemClick(0);
            }
        }

        public void baixarJson(String url)
        {
            request =  new Request.Builder()
                    .url(url)
                    .build();
        }
    }
}