package model;

public class Livraria implements java.io.Serializable {
    private int id;
    private String nome;
    private String endereco;
    private String cpnj;

    public Livraria() {
        this.setNome("SEM NOME");
        this.setEndereco("SEM ENDERECO");
        this.setCpnj("00.000.000/0000-00");
    }

    public Livraria(int id, String nome, String endereco, String cpnj) {
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setCpnj(cpnj);
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"SEM NOME":nome.toUpperCase();
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty()?"SEM ENDERECO":endereco.toUpperCase();
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj.trim().isEmpty()?"00.000.000/0000-00":cpnj;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getCpnj() {
        return this.cpnj;
    }

    public int getId() {
        return this.id;
    }
            
    @Override
    public String toString() {
        return this.getNome();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final Livraria other = (Livraria) obj;
        return this.id == other.id;
    }
    
    
}
