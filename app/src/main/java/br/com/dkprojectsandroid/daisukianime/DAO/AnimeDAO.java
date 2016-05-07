package br.com.dkprojectsandroid.daisukianime.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.dkprojectsandroid.daisukianime.classesBasicas.Anime;

/**
 * Created by Audry Martins on 04/05/2016.
 */
public class AnimeDAO
{
    //Atributos

    private Context mContext;

    public AnimeDAO(Context context)
    {
        this.mContext = context;
    }

    public long inserir(Anime anime)
    {
        AnimeDBHelper helper = new AnimeDBHelper(mContext);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = animeValues(anime);

        long id = db.insert(AnimeContract.TABLE_NAME, null, values);

        anime.setCodigo(id);

        db.close();

        return id;
    }

    public int atualizar(Anime anime)
    {
        AnimeDBHelper helper = new AnimeDBHelper(mContext);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = animeValues(anime);

        int linhasAfetadas;

        linhasAfetadas = db.update(AnimeContract.TABLE_NAME, values,
                AnimeContract._ID + " = ?",
                new String[]{String.valueOf(anime.getCodigo())});

        db.close();

        return linhasAfetadas;
    }

    public int excluir(Anime anime)
    {
        AnimeDBHelper helper = new AnimeDBHelper(mContext);
        SQLiteDatabase db = helper.getWritableDatabase();

        int linhasAfetadas;

        linhasAfetadas = db.delete(AnimeContract.TABLE_NAME,
                AnimeContract.TITULO + " = ?",
                new String[]{String.valueOf(anime.getTitulo())});

        db.close();

        return linhasAfetadas;
    }

    public List<Anime> listarTodos()
    {
        AnimeDBHelper helper = new AnimeDBHelper(mContext);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " +
                AnimeContract.TABLE_NAME, null);

        List<Anime> animes = new ArrayList<>();

        if(cursor.getCount() > 0)
        {
            int idxCodigo = cursor.getColumnIndex(AnimeContract._ID);
            int idxTituloOriginal = cursor.getColumnIndex(AnimeContract.TITULOORIGINAL);
            int idxTitulo = cursor.getColumnIndex(AnimeContract.TITULO);
            int idxCriador = cursor.getColumnIndex(AnimeContract.CRIADOR);
            int idxProdutora = cursor.getColumnIndex(AnimeContract.PRODUTORA);
            int idxCapa = cursor.getColumnIndex(AnimeContract.CAPA);
            int idxFotos = cursor.getColumnIndex(AnimeContract.FOTOS);
            int idxEpisodios = cursor.getColumnIndex(AnimeContract.EPISODIOS);
            int idxOvas = cursor.getColumnIndex(AnimeContract.OVAS);
            int idxClassificacao = cursor.getColumnIndex(AnimeContract.CLASSIFICACAO);
            int idxFansub = cursor.getColumnIndex(AnimeContract.FANSUB);
            int idxGenero = cursor.getColumnIndex(AnimeContract.GENERO);
            int idxAno = cursor.getColumnIndex(AnimeContract.ANO);
            int idxNota = cursor.getColumnIndex(AnimeContract.NOTA);
            int idxStatus = cursor.getColumnIndex(AnimeContract.STATUS);
            int idxSinopse = cursor.getColumnIndex(AnimeContract.SINOPSE);
            int idxTemporada = cursor.getColumnIndex(AnimeContract.IDTEMPORADAANIME);
            int idxAudio = cursor.getColumnIndex(AnimeContract.AUDIO);
            int idxLegenda = cursor.getColumnIndex(AnimeContract.LEGENDA);

            while (cursor.moveToNext())
            {
                Anime anime = new Anime();

                anime.setCodigo(cursor.getLong(idxCodigo));
                anime.setTituloOriginal(cursor.getString(idxTituloOriginal));
                anime.setTitulo(cursor.getString(idxTitulo));
                anime.setCriador(cursor.getString(idxCriador));
                anime.setProdutora(cursor.getString(idxProdutora));
                anime.setCapa(cursor.getString(idxCapa));
                anime.getFotos().add(cursor.getString(idxFotos));
                anime.setEpisodios(cursor.getInt(idxEpisodios));
                anime.setOvas(cursor.getInt(idxOvas));
                anime.setClassificacao(cursor.getInt(idxClassificacao));
                anime.setFansub(cursor.getString(idxFansub));
                anime.setGenero(cursor.getString(idxGenero));
                anime.setAno(cursor.getString(idxAno));
                anime.setNota(cursor.getDouble(idxNota));
                anime.setStatus(cursor.getString(idxStatus));
                anime.setSinopse(cursor.getString(idxSinopse));
                anime.getTemporada().setCodigo(cursor.getInt(idxTemporada));
                anime.setAudio(cursor.getString(idxAudio));
                anime.setLegenda(cursor.getString(idxLegenda));

                animes.add(anime);
            }
        }
        cursor.close();
        db.close();

        return animes;
    }

    private ContentValues animeValues(Anime anime)
    {
        ContentValues values = new ContentValues();

        values.put(AnimeContract.TITULOORIGINAL, anime.getTituloOriginal());
        values.put(AnimeContract.TITULO, anime.getTitulo());
        values.put(AnimeContract.CRIADOR, anime.getCriador());
        values.put(AnimeContract.PRODUTORA, anime.getProdutora());
        values.put(AnimeContract.CAPA, anime.getCapa());
        values.put(AnimeContract.FOTOS, anime.getFotos().toString());
        values.put(AnimeContract.EPISODIOS, anime.getEpisodios());
        values.put(AnimeContract.OVAS, anime.getOvas());
        values.put(AnimeContract.CLASSIFICACAO, anime.getClassificacao());
        values.put(AnimeContract.FANSUB, anime.getFansub());
        values.put(AnimeContract.GENERO, anime.getGenero());
        values.put(AnimeContract.ANO, anime.getAno());
        values.put(AnimeContract.NOTA, anime.getNota());
        values.put(AnimeContract.STATUS, anime.getStatus());
        values.put(AnimeContract.SINOPSE, anime.getSinopse());
        values.put(AnimeContract.TEMPORADA, anime.getTemporada().getCodigo());
        values.put(AnimeContract.AUDIO, anime.getAudio());
        values.put(AnimeContract.LEGENDA, anime.getLegenda());

        return values;
    }
}