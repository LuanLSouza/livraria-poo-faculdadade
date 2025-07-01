
package model;


public class Autor implements java.io.Serializable{
    private int id;
    private String nome;
    private String cpf;
    private String email;

    public Autor() {
        this.setId(id);
        this.setNome("VAZIO");
        this.setCpf("000.000.000-00");
        this.setEmail("vazio");
    }

    public Autor(int id, String nome, String cnpj, String email) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setEmail(email);
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

    public void setEmail(String email) {
        this.email = email.toLowerCase();
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

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Autor other = (Autor) obj;
        return this.id == other.id;
    }
    
    
}
