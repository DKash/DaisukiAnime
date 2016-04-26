package br.com.dkprojectsandroid.daisukianime.fragments;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import br.com.dkprojectsandroid.daisukianime.R;
import br.com.dkprojectsandroid.daisukianime.classesBasicas.Anime;
import butterknife.ButterKnife;


public class DetalheAnimeFragment extends Fragment
{
    private static final String EXTRA_ANIME = "param1";

    private String mAnime;

    public DetalheAnimeFragment()
    {
    }
    public static DetalheAnimeFragment newInstance(Anime anime)
    {
        DetalheAnimeFragment fragment = new DetalheAnimeFragment();
        Bundle args = new Bundle();
        Parcelable p = Parcels.wrap(anime);
        args.putParcelable(EXTRA_ANIME, p);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            Parcelable p = getArguments().getParcelable(EXTRA_ANIME);
            mAnime = Parcels.unwrap(p);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_detalhe_anime, container, false);

        //Exibe com o ButterF=Knife os atributos do anime no Fragment

        return view;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}