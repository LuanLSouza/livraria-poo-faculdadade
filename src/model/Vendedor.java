package model;

import enums.Cargo;
import java.time.LocalDate;

public class Vendedor implements java.io.Serializable{
    private int id;
    private String nome;
    private String cpf;
    private Cargo cargo;
    private LocalDate data;

    public Vendedor() {
        this.setId(id);
        this.setNome("VAZIO");
        this.setCpf("000.000.000-00");
        this.setCargo(Cargo.V);
        this.setData(null);
        
    }

    public Vendedor(int id, String nome, String cpf, Cargo cargo, LocalDate data) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setCargo(Cargo.G);
        this.setData(data);
    }
            
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"VAZIO":nome.toUpperCase();
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.trim().isEmpty()?"000.000.000-00":cpf;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setData(LocalDate data) {
        this.data = data==null?LocalDate.now():data;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public LocalDate getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return getNome();
    }   
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
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
        final Vendedor other = (Vendedor) obj;
        return this.id == other.id;
    }
    
    
    
}
