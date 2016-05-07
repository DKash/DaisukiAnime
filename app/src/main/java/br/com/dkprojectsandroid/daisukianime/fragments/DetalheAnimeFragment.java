package br.com.dkprojectsandroid.daisukianime.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import br.com.dkprojectsandroid.daisukianime.R;
import br.com.dkprojectsandroid.daisukianime.classesBasicas.Anime;
import butterknife.Bind;
import butterknife.ButterKnife;

public class DetalheAnimeFragment extends Fragment
{
    //Constantes

    private static final String EXTRA_ANIME = "param1";

    //Atributos

    @Bind(R.id.txvResultadoTituloOriginal)
    TextView mTxvTituloOriginal;
    @Bind(R.id.txvTitulo)
    TextView mTxvTitulo;
    @Bind(R.id.txvResultadoCriador)
    TextView mTxvCriador;
    @Bind(R.id.txvResultadoProdutora)
    TextView mTxvProdutora;
    @Bind(R.id.imgCapa)
    ImageView mImgCapa;
    @Bind(R.id.imgFoto01)
    ImageView mFoto1;
    @Bind(R.id.imgFoto02)
    ImageView mFoto2;
    @Bind(R.id.imgFoto03)
    ImageView mFoto3;
    @Bind(R.id.imgFoto04)
    ImageView mFoto4;
    @Bind(R.id.imgFoto05)
    ImageView mFoto5;
    @Bind(R.id.imgFoto06)
    ImageView mFoto6;
    @Bind(R.id.txvResultadoEpisodios)
    TextView mTxvEpisodios;
    @Bind(R.id.txvResultadoOvas)
    TextView mTxvOvas;
    @Bind(R.id.imgClassificacao)
    TextView mTxvClassificacao;
    @Bind(R.id.txvResultadoFansub)
    TextView mTxvFansub;
    @Bind(R.id.txvResultadoGenero)
    TextView mTxvGenero;
    @Bind(R.id.txvResultadoAno)
    TextView mTxvAno;
    @Bind(R.id.txvNota)
    TextView mTxvNota;
    @Bind(R.id.txvResultadoStatus)
    TextView mTxvStatus;
    @Bind(R.id.txvResultadoSinopse)
    TextView mTxvSinopse;
    @Bind(R.id.txvResultadoTemporada)
    TextView mTxvTemporada;
    @Bind(R.id.txvResultadoAudio)
    TextView mTxvAudio;
    @Bind(R.id.txvResultadoLegenda)
    TextView mTxvLegenda;

    private Anime mAnime;

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

        ButterKnife.bind(getActivity(), view);

        mTxvTituloOriginal.append(mAnime.getTituloOriginal().toString());

        //mTxvTituloOriginal.setText(mAnime.getTituloOriginal());
        mTxvTitulo.setText(mAnime.getTitulo());
        mTxvCriador.setText(mAnime.getCriador());
        mTxvProdutora.setText(mAnime.getProdutora());

        Glide.with(getActivity()).load(mAnime.getCapa()).into(mImgCapa);
        Glide.with(getActivity()).load(mAnime.getFotos().get(0)).into(mFoto1);
        Glide.with(getActivity()).load(mAnime.getFotos().get(1)).into(mFoto2);
        Glide.with(getActivity()).load(mAnime.getFotos().get(2)).into(mFoto3);
        Glide.with(getActivity()).load(mAnime.getFotos().get(3)).into(mFoto4);
        Glide.with(getActivity()).load(mAnime.getFotos().get(4)).into(mFoto5);
        Glide.with(getActivity()).load(mAnime.getFotos().get(5)).into(mFoto6);

        mTxvEpisodios.setText(mAnime.getEpisodios());
        mTxvOvas.setText(mAnime.getOvas());
        mTxvClassificacao.setText(mAnime.getClassificacao());
        mTxvFansub.setText(mAnime.getFansub());
        mTxvGenero.setText(mAnime.getGenero());
        mTxvAno.setText(mAnime.getAno());
        mTxvNota.setText(String.valueOf(mAnime.getNota()));
        mTxvStatus.setText(mAnime.getStatus());
        mTxvSinopse.setText(mAnime.getSinopse());
        mTxvTemporada.setText(mAnime.getTemporada().getTemporada());
        mTxvAudio.setText(mAnime.getAudio());
        mTxvLegenda.setText(mAnime.getLegenda());

        return view;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}