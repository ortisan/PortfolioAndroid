package br.com.ortiz.portfolio.model;

import java.io.Serializable;

/**
 * Created by marcelo on 11/06/15.
 */
public class App implements Serializable {

    private String nome;

    private int imagem;


    public App() {
    }

    public App(String nome, int imagem) {
        this.nome = nome;

        this.imagem = imagem;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }


}
