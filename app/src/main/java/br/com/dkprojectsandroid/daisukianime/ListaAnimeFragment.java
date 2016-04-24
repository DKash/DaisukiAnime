package br.com.dkprojectsandroid.daisukianime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ListaAnimeFragment extends Fragment
{
    //Atributos

    @Bind(R.id.fragment_lista)
    List<Anime> mAnimes;

    ListView mLvAnimes;

    //Construtores

    public ListaAnimeFragment()
    {

    }

    //Métodos


    @Override public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mAnimes = new ArrayList<>();
        Anime anime = new Anime();

        anime.setTitulo("Death Note");
        anime.setCriador("Audry Martins");
        anime.setClassificacao(16);
        anime.setNota(9.7);

        Anime anime2 = new Anime();

        anime2.setTitulo("Tenchi Muyo");
        anime2.setCriador("Kirigaya Kabuto");
        anime2.setClassificacao(16);
        anime2.setNota(9.7);

        mAnimes.add(anime);
        mAnimes.add(anime2);
    }

    //Métodos

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View layout = inflater.inflate(R.layout.fragment_lista_anime, container, false);
        ButterKnife.bind(this, layout);
        mLvAnimes.setAdapter(new ArrayAdapter<Anime>(getActivity(),
                android.R.layout.simple_list_item_1, mAnimes));

        return layout;
    }

    @OnItemClick(R.id.fragment_lista)
    void onItemClick(int position)
    {
        Anime anime = mAnimes.get(position);
        if(getActivity() instanceof AnimeClickListener)
        {
            AnimeClickListener listener = (AnimeClickListener) getActivity();
            listener.animeClicado(anime);
        }
    }

    public interface AnimeClickListener
    {
        void animeClicado(Anime anime);
    }
}