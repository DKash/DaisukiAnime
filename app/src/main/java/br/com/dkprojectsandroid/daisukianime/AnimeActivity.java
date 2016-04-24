package br.com.dkprojectsandroid.daisukianime;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.parceler.Parcels;

public class AnimeActivity extends AppCompatActivity
        implements ListaAnimeFragment.AnimeClickListener
{
    //Atributos

    //Construtores

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
    }

    //Métodos

    @Override
    public void animeClicado(Anime anime)
    {
        if(getResources().getBoolean(R.bool.tablet))
        {
            DetalheAnimeFragment daf = DetalheAnimeFragment.newInstance(anime);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detalhe, daf, "detalhe")
                    .commit();
        }
        else
        {
            Intent it = new Intent(this, DetalheAnimeActivity.class);
            Parcelable p = Parcels.wrap(anime);
            it.putExtra(DetalheAnimeActivity.EXTRA_ANIME, p);
        }
    }
}