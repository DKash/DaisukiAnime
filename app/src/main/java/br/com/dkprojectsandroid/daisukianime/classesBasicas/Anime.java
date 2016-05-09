package br.com.dkprojectsandroid.daisukianime.classesBasicas;

import org.parceler.Parcel;

/**
 * Created by Audry Martins on 20/04/2016.
 */
@Parcel
public class Anime
{
    //Atributos

    private long codigo;
    private String tituloOriginal;
    private String titulo;
    private String criador;
    private String produtora;
    private String capa;
    private String foto1;
    private String foto2;
    private String foto3;
    private String foto4;
    private String foto5;
    private String foto6;
    private int episodios;
    private int ovas;
    private int classificacao;
    private String fansub;
    private String genero;
    private String ano;
    private double nota;
    private String status;
    private String sinopse;
    private String temporada;
    private String anime;
    private String audio;
    private String legenda;

    //Construtores

    public Anime()
    {
        this.tituloOriginal = "";
        this.titulo = "";
        this.criador = "";
        this.produtora = "";
        this.capa = "";
        this.foto1 = "";
        this.foto2 = "";
        this.foto3 = "";
        this.foto4 = "";
        this.foto5 = "";
        this.foto6 = "";
        this.fansub = "";
        this.genero = "";
        this.ano = "";
        this.status = "";
        this.sinopse = "";
        this.temporada ="";
        this.anime = "";
        this.audio = "";
        this.legenda = "";
    }

    public Anime(long codigo, String tituloOriginal, String titulo, String criador,
                 String produtora, String capa, String foto1, String foto2, String foto3,
                 String foto4, String foto5, String foto6, int episodios, int ovas,
                 int classificacao,
                 String fansub, String genero, String ano, double nota, String status,
                 String sinopse, String temporada, String anime, String audio, String legenda)
    {
        this.codigo = codigo;
        this.tituloOriginal = tituloOriginal;
        this.titulo = titulo;
        this.criador = criador;
        this.produtora = produtora;
        this.capa = capa;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.foto4 = foto4;
        this.foto5 = foto5;
        this.foto6 = foto6;
        this.episodios = episodios;
        this.ovas = ovas;
        this.classificacao = classificacao;
        this.fansub = fansub;
        this.genero = genero;
        this.ano = ano;
        this.nota = nota;
        this.status = status;
        this.sinopse = sinopse;
        this.temporada = temporada;
        this.anime = anime;
        this.audio = audio;
        this.legenda = legenda;
    }

    //Gets e Sets

    public long getCodigo()
    {
        return codigo;
    }

    public void setCodigo(long codigo)
    {
        this.codigo = codigo;
    }

    public String getTituloOriginal()
    {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal)
    {
        this.tituloOriginal = tituloOriginal;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getCriador()
    {
        return criador;
    }

    public void setCriador(String criador)
    {
        this.criador = criador;
    }

    public String getProdutora()
    {
        return produtora;
    }

    public void setProdutora(String produtora)
    {
        this.produtora = produtora;
    }

    public String getCapa()
    {
        return capa;
    }

    public void setCapa(String capa)
    {
        this.capa = capa;
    }

    public String getFoto1()
    {
        return foto1;
    }

    public void setFoto1(String foto1)
    {
        this.foto1 = foto1;
    }

    public String getFoto2()
    {
        return foto2;
    }

    public void setFoto2(String foto2)
    {
        this.foto2 = foto2;
    }

    public String getFoto3()
    {
        return foto3;
    }

    public void setFoto3(String foto3)
    {
        this.foto3 = foto3;
    }

    public String getFoto4()
    {
        return foto4;
    }

    public void setFoto4(String foto4)
    {
        this.foto4 = foto4;
    }

    public String getFoto5()
    {
        return foto5;
    }

    public void setFoto5(String foto5)
    {
        this.foto5 = foto5;
    }

    public String getFoto6()
    {
        return foto6;
    }

    public void setFoto6(String foto6)
    {
        this.foto6 = foto6;
    }

    public int getEpisodios()
    {
        return episodios;
    }

    public void setEpisodios(int episodios)
    {
        this.episodios = episodios;
    }

    public int getOvas()
    {
        return ovas;
    }

    public void setOvas(int ovas)
    {
        this.ovas = ovas;
    }

    public int getClassificacao()
    {
        return classificacao;
    }

    public void setClassificacao(int classificacao)
    {
        this.classificacao = classificacao;
    }

    public String getFansub()
    {
        return fansub;
    }

    public void setFansub(String fansub)
    {
        this.fansub = fansub;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public String getAno()
    {
        return ano;
    }

    public void setAno(String ano)
    {
        this.ano = ano;
    }

    public double getNota()
    {
        return nota;
    }

    public void setNota(double nota)
    {
        this.nota = nota;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getSinopse()
    {
        return sinopse;
    }

    public void setSinopse(String sinopse)
    {
        this.sinopse = sinopse;
    }

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

    public String getAudio()
    {
        return audio;
    }

    public void setAudio(String audio)
    {
        this.audio = audio;
    }

    public String getLegenda()
    {
        return legenda;
    }

    public void setLegenda(String legenda)
    {
        this.legenda = legenda;
    }
}