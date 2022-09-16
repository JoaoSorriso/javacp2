package br.com.fiap.model;

public class Usuario {
    private String titulo;
    private String genero;
    private String descricao;
    private double nota;
    private String zerado;

    @Override
    public String toString() {
        return "Nota:  " + nota + "     Genero:  " + genero + "     Descrição:  " + descricao + "     Título:  " + titulo
                + "     Status:  " + zerado;
    }

    /**
     * @param titulo
     * @param genero
     * @param descricao
     * @param nota
     * @param zerado
     */
    public Usuario(String titulo, String genero, String descricao, double nota, String zerado) {
        this.titulo = titulo;
        this.genero = genero;
        this.descricao = descricao;
        this.nota = nota;
        this.zerado = zerado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getZerado() {
        return zerado;
    }

    public void setZerado(String zerado) {
        this.zerado = zerado;
    }

    public Usuario() {
    }
    
    public class Jogo {

        public Jogo(String titulo, String genero, String descricao, double nota) {
        }
    
    }
    
}