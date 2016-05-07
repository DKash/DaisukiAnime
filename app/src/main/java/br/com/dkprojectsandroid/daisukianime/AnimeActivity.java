package br.com.dkprojectsandroid.daisukianime;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.parceler.Parcels;

import br.com.dkprojectsandroid.daisukianime.classesBasicas.Anime;
import br.com.dkprojectsandroid.daisukianime.fragments.DetalheAnimeFragment;
import br.com.dkprojectsandroid.daisukianime.fragments.ListaAnimeFragment;
import br.com.dkprojectsandroid.daisukianime.fragments.ListaFavoritoFragment;
import butterknife.Bind;
import butterknife.ButterKnife;

public class AnimeActivity extends AppCompatActivity
        implements AnimeClickListener
{
    //Atributos

    @Bind(R.id.viewPager)
    ViewPager mViewPager;
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    //Construtores

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mViewPager.setAdapter(new AnimePageAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
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
            startActivity(it);
        }
    }

    class AnimePageAdapter extends FragmentPagerAdapter
    {
        public AnimePageAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override public Fragment getItem(int position)
        {
            if(position == 0)
            {
                return new ListaAnimeFragment();
            }
            else
            {
                return new ListaFavoritoFragment();
            }
        }

        @Override public CharSequence getPageTitle(int position)
        {
            if(position == 0)
            {
                return getString(R.string.abaWeb);
            }
            else
            {
                return getString(R.string.abaFavoritos);
            }
        }

        @Override public int getCount()
        {
            return 2;
        }
    }
}