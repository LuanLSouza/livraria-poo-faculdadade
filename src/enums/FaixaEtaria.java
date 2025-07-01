package enums;


public enum FaixaEtaria {
    L("Livre"),
    J("Jovens"),
    A("Adulto");
    
    private String descricao;
    
    private FaixaEtaria(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
