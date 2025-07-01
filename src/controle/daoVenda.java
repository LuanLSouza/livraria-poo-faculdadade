package controle;

import abstratas.dao;
import enums.FormaPagamento;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import model.Cliente;
import model.Livraria;
import model.Livros;
import model.Venda;
import model.Vendedor;

public class daoVenda extends dao {
    public int create (Venda venda) throws SQLException{
        String SQL = "insert into venda (id_livraria, id_livro, id_vendedor, id_cliente, quantidade, data, forma_de_pagamento) values (?, ?, ?, ?, ?, ?, ?)";
        return super.executeUpdate(SQL,venda.getLivraria().getId(), venda.getLivro().getId(), venda.getVendedor().getId(), venda.getCliente().getId(), venda.getQuantidade(), venda.getData(), venda.getFormaPagamento().name());
    }
    
    public int update (Venda venda) throws SQLException{
        String SQL = "update venda set id_livraria = ?, id_livro = ?, id_vendedor = ?, id_cliente = ?, quantidade = ?, data = ?, forma_de_pagamento = ? where id_venda  = ?";
        return super.executeUpdate(SQL, venda.getLivraria().getId(), venda.getLivro().getId(), venda.getVendedor().getId(), venda.getCliente().getId(), venda.getQuantidade(), venda.getData(), venda.getFormaPagamento().name(), venda.getId());
    }
    
    public int delete (Venda venda) throws SQLException{
        return super.executeUpdate("delete from venda where id_venda = " + venda.getId());
    }
    
    public Venda read(int id) throws SQLException{
        String SQL="select * from venda where id_venda = ?";
        ResultSet rs = super.executeQuery(SQL, id);
        return (!rs.next() ? null : montaObjeto(rs));
        
    }
    public List<Venda> read() throws SQLException{
        String SQL="select * from venda order by data";
        ResultSet rs = super.executeQuery(SQL);
        List<Venda> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;
    }

    private Venda montaObjeto(ResultSet rs) throws SQLException{
        Venda venda = new Venda();
        venda.setId(rs.getInt("id_venda"));
        venda.setData(rs.getDate("data").toLocalDate());
        venda.setQuantidade(rs.getInt("quantidade"));
        
        Livraria l = new daoLivraria().read(rs.getInt("id_livraria"));
        venda.setLivraria(l);
        Livros livro = new daoLivros().read(rs.getInt("id_livro"));
        venda.setLivro(livro);
        Vendedor v = new daoVendedor().read(rs.getInt("id_vendedor"));
        venda.setVendedor(v);
        Cliente c = new daoCliente().read(rs.getInt("id_cliente"));
        venda.setCliente(c);
        FormaPagamento fp = FormaPagamento.valueOf(rs.getString("forma_de_pagamento"));
        venda.setFormaPagamento(fp);
        
        return venda;
    }
}
