package enums;

public enum Cargo {
    G("Gerente"),
    V("Vendedor"),
    S("Supervisor");
    
    private String descricao;
    
    private Cargo(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
