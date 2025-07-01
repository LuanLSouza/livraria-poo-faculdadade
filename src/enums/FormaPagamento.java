
package enums;

public enum FormaPagamento {
    D("Dinheiro"),
    C("Cartão de credito"),
    P("PIX");
    
    private String descricao;
    
    private FormaPagamento(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
