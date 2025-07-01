package controle;

import abstratas.dao;
import java.util.LinkedList;
import java.util.List;
import model.Cliente;
import java.sql.*;

public class daoCliente extends dao {
    public int create(Cliente cliente) throws SQLException{
        return super.executeUpdate("insert into cliente ( nome, cpf, telefone) values (?, ?, ?)", cliente.getNome(), cliente.getCpf(), cliente.getTelefone());
    }
    
    public int update(Cliente cliente) throws SQLException{
        String SQL= "update cliente set nome = ?, cpf = ?, telefone = ? where id_cliente =?";
        return super.executeUpdate(SQL, cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getId());
    }
    
    public int delete(Cliente cliente) throws SQLException{
        return super.executeUpdate("delete from cliente where id_cliente = "+cliente.getId());
    }
    
    public Cliente read(int id) throws SQLException{
        String SQL = "select * from cliente where id_cliente = ?";
        ResultSet rs = super.executeQuery(SQL, id);
        return (!rs.next() ? null : montaObjeto(rs));
    }
    
    public List<Cliente> read() throws SQLException{
        String SQL="select * from cliente order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Cliente> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;
    }    
    
    public Cliente montaObjeto(ResultSet rs) throws SQLException{
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id_cliente"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setTelefone(rs.getString("telefone"));
        return cliente;
    }
}
