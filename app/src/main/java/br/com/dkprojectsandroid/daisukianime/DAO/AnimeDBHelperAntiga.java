package br.com.dkprojectsandroid.daisukianime.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Audry Martins on 04/05/2016.
 */
public class AnimeDBHelperAntiga extends SQLiteOpenHelper
{
    public static final int VERSAO_BANCODADOS = 1;
    public static final String NOME_BANCODADOS = "animesDB";

    public AnimeDBHelperAntiga(Context context)
    {
        super(context,NOME_BANCODADOS , null, VERSAO_BANCODADOS);
    }

    @Override public void onCreate(SQLiteDatabase db)
    {
        //Verificar não está criando a tabela Temporada

        db.execSQL("CREATE TABLE " + AnimeContract.TABLE_TEMPORADA + " (" +
                AnimeContract.IDTEMPORADA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AnimeContract.TEMPORADA + " TEXT NULL, " +
                AnimeContract.TEMP_ANIME + " TEXT NULL");

        db.execSQL("CREATE TABLE " + AnimeContract.TABLE_NAME + " (" +
                AnimeContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AnimeContract.TITULOORIGINAL + " TEXT NOT NULL, " +
                AnimeContract.TITULO + " TEXT NOT NULL UNIQUE, " +
                AnimeContract.CRIADOR + " TEXT NOT NULL, " +
                AnimeContract.PRODUTORA + " TEXT NOT NULL, " +
                AnimeContract.CAPA + " TEXT NOT NULL, " +
                AnimeContract.FOTOS + " TEXT NOT NULL, " +
                AnimeContract.EPISODIOS + " INTEGER NOT NULL, " +
                AnimeContract.OVAS + " INTEGER NOT NULL, " +
                AnimeContract.CLASSIFICACAO + " INTEGER NOT NULL, " +
                AnimeContract.FANSUB + " TEXT NOT NULL, " +
                AnimeContract.GENERO+ " TEXT NOT NULL, " +
                AnimeContract.ANO + " TEXT NOT NULL, " +
                AnimeContract.NOTA + " REAL NOT NULL, " +
                AnimeContract.STATUS + " TEXT NOT NULL, " +
                AnimeContract.SINOPSE + " TEXT NOT NULL, " +
                AnimeContract.IDTEMPORADAANIME + "INTEGER NOT NULL, " +
                " FOREIGN KEY (" + AnimeContract.IDTEMPORADAANIME +
                ") REFERENCES " + AnimeContract.TABLE_TEMPORADA + " ( " +
                AnimeContract.IDTEMPORADA +
                ")ON DELETE RESTRICT ON UPDATE CASCADE)," +
                AnimeContract.AUDIO + " TEXT NOT NULL, " +
                AnimeContract.LEGENDA + " TEXT NOT NULL)");
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if(oldVersion == 1)
        {
            db.execSQL("DROP TABLE IF EXISTS " + AnimeContract.TABLE_NAME);
            onCreate(db);
        }
    }
}