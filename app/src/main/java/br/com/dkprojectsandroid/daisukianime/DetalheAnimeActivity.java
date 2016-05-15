package br.com.dkprojectsandroid.daisukianime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.parceler.Parcels;

import br.com.dkprojectsandroid.daisukianime.classesBasicas.Anime;
import br.com.dkprojectsandroid.daisukianime.fragments.DetalheAnimeFragment;

public class DetalheAnimeActivity extends AppCompatActivity
{
    //Constants

    public static final String EXTRA_ANIME = "anime";

    //Atributos

    //Construtores

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_anime);

        Anime anime = Parcels.
                unwrap(getIntent().getParcelableExtra(EXTRA_ANIME));

        DetalheAnimeFragment daf = DetalheAnimeFragment.newInstance(anime);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.detalhe, daf, "detalhe")
                .commit();
    }

    //Métodos
}