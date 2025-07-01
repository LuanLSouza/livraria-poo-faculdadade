package model;

public class Cliente implements java.io.Serializable{
    private int id;
    private String nome;
    private String cpf;
    private String telefone;

    public Cliente() {
        this.setId(id);
        this.setNome("SEM NOME");
        this.setCpf("000.000.000-00");
        this.setTelefone("(00)00000-0000)");
    }

    public Cliente(int id, String nome, String cpf, String telefone) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setTelefone(telefone);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"SEM NOME":nome.toUpperCase();
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.trim().isEmpty()?"000.000.000-00":cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.trim().isEmpty()?"(00)00000-0000":telefone;
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

    public String getTelefone() {
        return this.telefone;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
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
        final Cliente other = (Cliente) obj;
        return this.id == other.id;
    }
    
    
}
