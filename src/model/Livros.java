
package model;

import enums.FaixaEtaria;

public class Livros implements java.io.Serializable{
    private int id;
    private Autor autor;
    private String titulo;
    private Double preco;
    private String resumo;
    private FaixaEtaria faixaEtaria;

    public Livros() {
        this.setId(id);
        this.setFaixaEtaria(FaixaEtaria.A);
        this.setAutor(null);
        this.setPreco(0.00);
        this.setResumo("SEM RESUMO");
        this.setTitulo("SEM TITULO");
        
    }

    public Livros(int id, Autor autor, String titulo, Double preco, String resumo, FaixaEtaria faixaEtaria) {
        this.setId(id);
        this.setAutor(autor);
        this.setTitulo(titulo);
        this.setPreco(preco);
        this.setResumo(resumo);
        this.setFaixaEtaria(faixaEtaria.A);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAutor(Autor autor) {
        this.autor = autor == null? new Autor() : autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo.trim().isEmpty()?"SEM TITULO":titulo.toUpperCase();
    }

    public void setPreco(Double preco) {
        this.preco = (preco<0)?0.00:preco;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo.trim().isEmpty()?"SEM RESUMO":resumo.toUpperCase();
    }

    public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public int getId() {
        return this.id;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Double getPreco() {
        return this.preco;
    }

    public String getResumo() {
        return this.resumo;
    }

    public FaixaEtaria getFaixaEtaria() {
        return this.faixaEtaria;
    }

    @Override
    public String toString() {
        return getTitulo();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livros other = (Livros) obj;
        return this.id == other.id;
    }
    
    
 
}
