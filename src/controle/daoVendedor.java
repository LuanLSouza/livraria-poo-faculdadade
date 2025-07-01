
package controle;

import abstratas.dao;
import enums.Cargo;
import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import model.Vendedor;

public class daoVendedor extends dao {
        public int create(Vendedor vendedor) throws SQLException{
        return super.executeUpdate("insert into vendedor ( nome, cpf, funcao, admissao ) values (?, ?, ?, ?)", vendedor.getNome(), vendedor.getCpf(), vendedor.getCargo().name(), vendedor.getData());
    }
    
    public int update(Vendedor vendedor) throws SQLException{
        String SQL= "update vendedor set nome = ?, cpf = ?, funcao = ?, admissao = ? where id_vendedor =?";
        return super.executeUpdate(SQL, vendedor.getNome(), vendedor.getCpf(), vendedor.getCargo().name(), vendedor.getData(), vendedor.getId());
    }
    
    public int delete(Vendedor vendedor) throws SQLException{
        return super.executeUpdate("delete from vendedor where id_vendedor= "+vendedor.getId());
    }
    
    public Vendedor read(int id) throws SQLException{
        String SQL = "select * from vendedor where id_vendedor = ?";
        ResultSet rs = super.executeQuery(SQL, id);
        return (!rs.next() ? null : montaObjeto(rs));
    }
    
    public List<Vendedor> read() throws SQLException{
        String SQL="select * from vendedor order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Vendedor> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;
    }    
    
    public Vendedor montaObjeto(ResultSet rs) throws SQLException{
        Vendedor vendedor = new Vendedor();
        vendedor.setId(rs.getInt("id_vendedor"));
        vendedor.setNome(rs.getString("nome"));
        vendedor.setCpf(rs.getString("cpf"));
        vendedor.setData(rs.getDate("admissao").toLocalDate());
        
        Cargo c = Cargo.valueOf(rs.getString("funcao"));
        vendedor.setCargo(c);
        
        return vendedor;
    }
}
