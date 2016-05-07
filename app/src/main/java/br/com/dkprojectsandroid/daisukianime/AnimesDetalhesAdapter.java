package br.com.dkprojectsandroid.daisukianime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.dkprojectsandroid.daisukianime.classesBasicas.Anime;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Audry Martins on 28/04/2016.
 */
public class AnimesDetalhesAdapter extends ArrayAdapter<Anime>
{
    //Construtores

    public AnimesDetalhesAdapter(Context context, List<Anime> animes)
    {
        super(context, 0, animes);
    }

    //Métodos

    @Override public View getView(int position, View convertView, ViewGroup parent)
    {
        Anime anime = getItem(position);

        ViewHolder viewHolder;

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_detalhe_anime, parent, false);
            viewHolder = new ViewHolder(convertView);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Glide.with(getContext()).load(anime.getCapa()).into(viewHolder.mImgCapa);
        Glide.with(getContext()).load(anime.getClassificacao()).into(viewHolder.mImgClassifcacao);
        Glide.with(getContext()).load(anime.getFotos().get(0)).into(viewHolder.mImgFoto01);
        Glide.with(getContext()).load(anime.getFotos().get(1)).into(viewHolder.mImgFoto02);
        Glide.with(getContext()).load(anime.getFotos().get(2)).into(viewHolder.mImgFoto03);
        Glide.with(getContext()).load(anime.getFotos().get(3)).into(viewHolder.mImgFoto04);
        Glide.with(getContext()).load(anime.getFotos().get(4)).into(viewHolder.mImgFoto05);
        Glide.with(getContext()).load(anime.getFotos().get(5)).into(viewHolder.mImgFoto06);

        viewHolder.mTxvTitulo.setText(anime.getTitulo());
        viewHolder.mTxvResultadoTituloOriginal.setText(anime.getTituloOriginal());
        viewHolder.mTxvResultadoCriador.setText(anime.getCriador());
        viewHolder.mTxvResultadoProdutora.setText(anime.getProdutora());
        viewHolder.mTxvResultadoEpisodios.setText(anime.getEpisodios());
        viewHolder.mTxvResultadoOvas.setText(anime.getOvas());
        viewHolder.mTxvResultadoSinopse.setText(anime.getSinopse());
        viewHolder.mTxvResultadoFansub.setText(anime.getFansub());
        viewHolder.mTxvResultadoGenero.setText(anime.getGenero());
        viewHolder.mTxvResultadoAno.setText(anime.getAno());
        viewHolder.mTxvResultadoStatus.setText(anime.getStatus());
        viewHolder.mTxvResultadoTemporada.setText(anime.getTemporada().getTemporada());
        viewHolder.getmTxvResultadoAudio.setText(anime.getAudio());
        viewHolder.mTxvResultadoLegenda.setText(anime.getLegenda());

        return convertView;
    }

    static class ViewHolder
    {
        @Bind(R.id.imgCapa)
        ImageView mImgCapa;
        @Bind(R.id.imgClassificacao)
        ImageView mImgClassifcacao;
        @Bind(R.id.imgFoto01)
        ImageView mImgFoto01;
        @Bind(R.id.imgFoto02)
        ImageView mImgFoto02;
        @Bind(R.id.imgFoto03)
        ImageView mImgFoto03;
        @Bind(R.id.imgFoto04)
        ImageView mImgFoto04;
        @Bind(R.id.imgFoto05)
        ImageView mImgFoto05;
        @Bind(R.id.imgFoto06)
        ImageView mImgFoto06;

        @Bind(R.id.txvTitulo)
        TextView mTxvTitulo;
        @Bind(R.id.txvResultadoTituloOriginal)
        TextView mTxvResultadoTituloOriginal;
        @Bind(R.id.txvResultadoCriador)
        TextView mTxvResultadoCriador;
        @Bind(R.id.txvResultadoProdutora)
        TextView mTxvResultadoProdutora;
        @Bind(R.id.txvResultadoEpisodios)
        TextView mTxvResultadoEpisodios;
        @Bind(R.id.txvResultadoOvas)
        TextView mTxvResultadoOvas;
        @Bind(R.id.txvResultadoSinopse)
        TextView mTxvResultadoSinopse;
        @Bind(R.id.txvResultadoFansub)
        TextView mTxvResultadoFansub;
        @Bind(R.id.txvResultadoGenero)
        TextView mTxvResultadoGenero;
        @Bind(R.id.txvResultadoAno)
        TextView mTxvResultadoAno;
        @Bind(R.id.txvResultadoStatus)
        TextView mTxvResultadoStatus;
        @Bind(R.id.txvNota)
        TextView mTxvNota;
        @Bind(R.id.txvResultadoTemporada)
        TextView mTxvResultadoTemporada;
        @Bind(R.id.txvResultadoAudio)
        TextView getmTxvResultadoAudio;
        @Bind(R.id.txvResultadoLegenda)
        TextView mTxvResultadoLegenda;

        public ViewHolder(View parent)
        {
            ButterKnife.bind(this, parent);
            parent.setTag(this);
        }
    }
}