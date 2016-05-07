package br.com.dkprojectsandroid.daisukianime.classesBasicas;

import org.parceler.Parcel;

/**
 * Created by Audry Martins on 21/04/2016.
 */
@Parcel
public class Temporada
{
    //Atributos

    private long codigo;
    private String temporada;
    private String anime;

    //Construtores

    public Temporada()
    {
        this.temporada = "";
        this.anime = "";
    }

    public Temporada(String temporada, String anime)
    {

        this.temporada = temporada;
        this.anime = anime;
    }

    //Métodos

    //Gets e Sets

    public String getTemporada()
    {
        return temporada;
    }

    public void setTemporada(String temporada)
    {
        this.temporada = temporada;
    }

    public String getAnime()
    {
        return anime;
    }

    public void setAnime(String anime)
    {
        this.anime = anime;
    }
}