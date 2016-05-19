package br.com.dkprojectsandroid.daisukianime.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import br.com.dkprojectsandroid.daisukianime.AnimeAPP;
import br.com.dkprojectsandroid.daisukianime.AnimeClickListener;
import br.com.dkprojectsandroid.daisukianime.AnimesAdapter;
import br.com.dkprojectsandroid.daisukianime.DAO.AnimeDAO;
import br.com.dkprojectsandroid.daisukianime.R;
import br.com.dkprojectsandroid.daisukianime.classesBasicas.Anime;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ListaFavoritoFragment extends Fragment
{
    //Atributos

    @Bind(R.id.list_anime)
    ListView mLvAnimes;
    @Bind(R.id.empty)
    View mEmpty;

    List<Anime> mAnimes;
    ArrayAdapter<Anime> mAdapter;
    AnimeDAO mDAO;

    //Métodos

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        mDAO = new AnimeDAO(getActivity());
        mAnimes = mDAO.listarTodos();
        ((AnimeAPP)getActivity().getApplication()).getmEventBus().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View layout = inflater.inflate(R.layout.fragment_lista_favorito, container, false);
        ButterKnife.bind(this, layout);


        mLvAnimes.setEmptyView(mEmpty);

        mAdapter = new AnimesAdapter(getContext(), mAnimes);
        mLvAnimes.setAdapter(mAdapter);

        return layout;
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

    @Subscribe
    public void atualiarListaFavoritos(Anime anime)
    {
        mAnimes.clear();
        mAnimes.addAll(mDAO.listarTodos());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        ((AnimeAPP)getActivity().getApplication()).getmEventBus().unregister(this);
    }
}