
package controle;

import java.sql.*;
import abstratas.dao;
import java.util.LinkedList;
import java.util.List;
import model.Livraria;

public class daoLivraria extends dao {
    public int create(Livraria livraria) throws SQLException{
        return super.executeUpdate("insert into livraria ( nome, endereco, cnpj) values (?, ?, ?)", livraria.getNome(), livraria.getEndereco(), livraria.getCpnj());
    }
    
    public int update(Livraria livraria) throws SQLException{
        String SQL= "update livraria set nome = ?, endereco = ?, cnpj = ? where id_livraria =?";
        return super.executeUpdate(SQL, livraria.getNome(), livraria.getEndereco(), livraria.getCpnj(), livraria.getId());
    }
    
    public int delete(Livraria livraria) throws SQLException{
        return super.executeUpdate("delete from livraria where id_livraria = "+livraria.getId());
    }
    
    public Livraria read(int id) throws SQLException{
        String SQL = "select * from livraria where id_livraria = ?";
        ResultSet rs = super.executeQuery(SQL, id);
        return (!rs.next() ? null : montaObjeto(rs));
    }
    
    public List<Livraria> read() throws SQLException{
        String SQL="select * from livraria order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Livraria> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;
    }    
    
    public Livraria montaObjeto(ResultSet rs) throws SQLException{
        Livraria livraria = new Livraria();
        livraria.setId(rs.getInt("id_livraria"));
        livraria.setNome(rs.getString("nome"));
        livraria.setEndereco(rs.getString("endereco"));
        livraria.setCpnj(rs.getString("cnpj"));
        return livraria;
    }
}
