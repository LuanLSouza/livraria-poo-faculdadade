package model;

import enums.FormaPagamento;
import java.time.LocalDate;

public class Venda implements java.io.Serializable{
    private int id;
    private Livraria livraria;
    private Livros livro;
    private Vendedor vendedor;
    private Cliente cliente;
    private int quantidade;
    private LocalDate data;
    private FormaPagamento formaPagamento;

    public Venda() {
        this.setId(id);
        this.setLivraria(null);
        this.setLivro(null);
        this.setVendedor(null);
        this.setCliente(null);
        this.setQuantidade(0);
        this.setData(null);
        this.setFormaPagamento(FormaPagamento.C);
    }

    public Venda(int id, Livraria livraria, Livros livro, Vendedor vendedor, Cliente cliente, int quantidade, LocalDate data, FormaPagamento formaPagamento) {
        this.setId(id);
        this.setLivraria(livraria);
        this.setLivro(livro);
        this.setVendedor(vendedor);
        this.setCliente(cliente);
        this.setQuantidade(quantidade);
        this.setData(data);
        this.setFormaPagamento(formaPagamento);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLivraria(Livraria livraria) {
        this.livraria = livraria == null ? new Livraria(): livraria;
    }

    public void setLivro(Livros livro) {
        this.livro = livro == null ? new Livros(): livro;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor == null ? new Vendedor(): vendedor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente == null ? new Cliente() : cliente;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = (quantidade < 0) ? 0 : quantidade;
    }

    public void setData(LocalDate data) {
        this.data = data==null?LocalDate.now():data;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getId() {
        return this.id;
    }

    public Livraria getLivraria() {
        return this.livraria;
    }

    public Livros getLivro() {
        return this.livro;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public LocalDate getData() {
        return this.data;
    }

    public FormaPagamento getFormaPagamento() {
        return this.formaPagamento;
    }

    @Override
    public String toString() {
        return "Livraria: " + this.getLivraria().getNome() + " Livro: " + this.getLivro().getTitulo()  + " Quantidade: "+this.getQuantidade();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
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
        final Venda other = (Venda) obj;
        return this.id == other.id;
    }
    
    
}
