package br.com.dkprojectsandroid.daisukianime.fragments;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import br.com.dkprojectsandroid.daisukianime.AnimeAPP;
import br.com.dkprojectsandroid.daisukianime.DAO.AnimeDAO;
import br.com.dkprojectsandroid.daisukianime.R;
import br.com.dkprojectsandroid.daisukianime.classesBasicas.Anime;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    ImageView mImgClassificacao;
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
    @Bind(R.id.txvResultadoAnime)
    TextView mTxvAnime;
    @Bind(R.id.txvResultadoAudio)
    TextView mTxvAudio;
    @Bind(R.id.txvResultadoLegenda)
    TextView mTxvLegenda;
    @Bind(R.id.fabFavorito)
    FloatingActionButton mFabFavorito;

    AnimeDAO mDAO;

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

        mDAO = new AnimeDAO(getActivity());

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
        View view = inflater.inflate(R.layout.alternativo2_fragment_detalhe_anime, container, false);

        //Exibe com o ButterF=Knife os atributos do anime no Fragment

        ButterKnife.bind(this, view);

        mTxvTituloOriginal.setText(mAnime.getTituloOriginal());
        mTxvTitulo.setText(mAnime.getTitulo());
        mTxvTitulo.setTextColor(ColorStateList.valueOf(Color.WHITE));
        mTxvCriador.setText(mAnime.getCriador());
        mTxvProdutora.setText(mAnime.getProdutora());

        Glide.with(getActivity()).load(mAnime.getCapa()).into(mImgCapa);
        Glide.with(getActivity()).load(mAnime.getFoto1()).into(mFoto1);
        Glide.with(getActivity()).load(mAnime.getFoto2()).into(mFoto2);
        Glide.with(getActivity()).load(mAnime.getFoto3()).into(mFoto3);
        Glide.with(getActivity()).load(mAnime.getFoto4()).into(mFoto4);
        Glide.with(getActivity()).load(mAnime.getFoto5()).into(mFoto5);
        Glide.with(getActivity()).load(mAnime.getFoto6()).into(mFoto6);

        mTxvEpisodios.setText(String.valueOf(mAnime.getEpisodios()));
        mTxvOvas.setText(String.valueOf(mAnime.getOvas()));

        carregarImgClassificacao();

        mTxvFansub.setText(mAnime.getFansub());
        mTxvGenero.setText(mAnime.getGenero());
        mTxvAno.setText(mAnime.getAno());
        mTxvNota.setText(String.valueOf(mAnime.getNota()));
        mTxvStatus.setText(mAnime.getStatus());
        mTxvSinopse.setText(mAnime.getSinopse());
        mTxvTemporada.setText(mAnime.getTemporada());
        mTxvAnime.setText(mAnime.getAnime());
        mTxvAudio.setText(mAnime.getAudio());
        mTxvLegenda.setText(mAnime.getLegenda());

        toogleFavorito();

        return view;
    }

    @OnClick(R.id.fabFavorito)
    public void favoritoClick()
    {
        boolean favorito = mDAO.isFavorito(mAnime);

        if(favorito)
        {
            mDAO.excluir(mAnime);
        }
        else
        {
            mDAO.inserir(mAnime);
        }
        toogleFavorito();
        ((AnimeAPP)getActivity().getApplication()).getmEventBus().post(mAnime);
    }

    private void toogleFavorito()
    {
        boolean favorito = mDAO.isFavorito(mAnime);

        int resultado;
        int color;
        int colorTint;

        if(favorito)
        {
            color = Color.RED;
            resultado = R.drawable.ic_remove;
        }
        else
        {
            color = Color.BLUE;
            resultado = R.drawable.ic_add;
        }
        mFabFavorito.setImageResource(resultado);
        mFabFavorito.setBackgroundTintList(ColorStateList.valueOf(color));
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void carregarImgClassificacao()
    {
        int classificacao = mAnime.getClassificacao();

        switch (classificacao)
        {
            case 10:
                Glide.with(getActivity()).load(R.drawable.classificacao_10anos).into(mImgClassificacao);
                break;
            case 12:
                Glide.with(getActivity()).load(R.drawable.classificacao_12anos).into(mImgClassificacao);
                break;
            case 14:
                Glide.with(getActivity()).load(R.drawable.classificacao_14anos).into(mImgClassificacao);
                break;
            case 16:
                Glide.with(getActivity()).load(R.drawable.classificacao_16anos).into(mImgClassificacao);
                break;
            case 18:
                Glide.with(getActivity()).load(R.drawable.classificacao_18anos).into(mImgClassificacao);
                break;
        }
    }
}