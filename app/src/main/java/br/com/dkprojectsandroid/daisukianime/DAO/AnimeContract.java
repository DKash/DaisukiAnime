package br.com.dkprojectsandroid.daisukianime.DAO;

import android.provider.BaseColumns;

/**
 * Created by Audry Martins on 04/05/2016.
 */
public interface AnimeContract extends BaseColumns
{
    //Nome da tabela do Banco de Dados

    String TABLE_NAME = "animes";

    //Atributos da tabela "Animes"

    String TITULOORIGINAL = "tituloOriginal";
    String TITULO = "titulo";
    String CRIADOR = "criador";
    String PRODUTORA = "produtora";
    String CAPA = "capa";
    String FOTO1 = "foto1";
    String FOTO2 = "foto2";
    String FOTO3 = "foto3";
    String FOTO4 = "foto4";
    String FOTO5 = "foto5";
    String FOTO6 = "foto6";
    String EPISODIOS = "episodios";
    String OVAS = "ovas";
    String CLASSIFICACAO = "classificacao";
    String FANSUB = "fansub";
    String GENERO = "genero";
    String ANO = "ano";
    String NOTA = "nota";
    String STATUS = "status";
    String SINOPSE = "sinopse";
    String TEMPORADA = "temporada";
    String ANIME = "anime";
    String AUDIO = "audio";
    String LEGENDA = "legenda";
}