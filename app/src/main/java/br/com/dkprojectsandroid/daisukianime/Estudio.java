package br.com.dkprojectsandroid.daisukianime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Audry Martins on 20/04/2016.
 */
public class Estudio
{
    //Atributos

    private List<Anime> animes;

    //Construtores

    public Estudio()
    {
        this.animes = new ArrayList<Anime>();
    }

    public Estudio(List<Anime> animes)
    {
        this.animes = animes;
    }


    //Métodos

    //Gets e Sets

    public List<Anime> getAnimes()
    {
        return animes;
    }

    public void setAnimes(List<Anime> animes)
    {
        this.animes = animes;
    }
}