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
 * Created by Audry Martins on 25/04/2016.
 */
public class AnimesAdapter extends ArrayAdapter<Anime>
{
    //Construtores

    public AnimesAdapter(Context context, List<Anime> animes)
    {
        super(context, 0, animes);
    }

    @Override public View getView(int position, View convertView, ViewGroup parent)
    {
        Anime anime = getItem(position);

        ViewHolder viewHolder;

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_anime, parent, false);
            viewHolder = new ViewHolder(convertView);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Glide.with(getContext()).load(anime.getCapa()).into(viewHolder.mImgCapa);
        viewHolder.mTxvTitulo.setText(anime.getTitulo());
        viewHolder.mTxvTemporada.setText(anime.getTemporada().getTemporada());

        return convertView;
    }

    static class ViewHolder
    {
        @Bind(R.id.imgCapa)
        ImageView mImgCapa;
        @Bind(R.id.txvTitulo)
        TextView mTxvTitulo;
        @Bind(R.id.txvTemporada)
        TextView mTxvTemporada;

        public ViewHolder(View parent)
        {
            ButterKnife.bind(this, parent);
            parent.setTag(this);
        }
    }
}