package br.com.dkprojectsandroid.daisukianime.DAO;

import android.provider.BaseColumns;

/**
 * Created by Audry Martins on 04/05/2016.
 */
public interface AnimeContract extends BaseColumns
{
    //Nome da tabela do Banco de Dados

    String TABLE_NAME = "animes";
    String TABLE_TEMPORADA = "temporada";

    //Atributos da tabela "Animes"

    String TITULOORIGINAL = "tituloOriginal";
    String TITULO = "titulo";
    String CRIADOR = "criador";
    String PRODUTORA = "produtora";
    String CAPA = "capa";
    String FOTOS = "fotos";
    String EPISODIOS = "episodios";
    String OVAS = "ovas";
    String CLASSIFICACAO = "classificacao";
    String FANSUB = "fansub";
    String GENERO = "genero";
    String ANO = "ano";
    String NOTA = "nota";
    String STATUS = "status";
    String SINOPSE = "sinopse";
    String IDTEMPORADA = "_id";
    String IDTEMPORADAANIME = "idtemporada";
    String TEMPORADA = "temptemporada";
    String TEMP_ANIME = "anime";
    String AUDIO = "audio";
    String LEGENDA = "legenda";
}