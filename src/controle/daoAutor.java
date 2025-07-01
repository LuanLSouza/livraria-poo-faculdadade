package controle;

import abstratas.dao;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import model.Autor;

public class daoAutor extends dao {
    public int create(Autor autor) throws SQLException{
        return super.executeUpdate("insert into autor (nome, cpf, email) values (?, ?, ?)", autor.getNome(), autor.getCpf(), autor.getEmail());
    }
    
    public int update(Autor autor) throws SQLException{
        String SQL = "update autor set nome = ?, cpf = ?, email = ? where id_autor = ?";
        return super.executeUpdate(SQL, autor.getNome(), autor.getCpf(), autor.getEmail(), autor.getId()); 
    }
    
    public int delete(Autor autor) throws SQLException{
        return super.executeUpdate("delete from autor where id_autor = " +autor.getId());
    }
    
    public Autor read(int id) throws SQLException{
        String SQL = "select * from autor where id_autor = ?";
        ResultSet rs = super.executeQuery(SQL, id);
        return (!rs.next() ? null : montaObjeto(rs));
    }
    
    public List<Autor> read() throws SQLException{
        String SQL="select * from autor order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Autor> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(montaObjeto(rs));
            
        }
        return retorno;
    }
    
    public Autor montaObjeto(ResultSet rs) throws SQLException {
        Autor autor = new Autor();
        autor.setId(rs.getInt("id_autor"));
        autor.setNome(rs.getString("nome"));
        autor.setCpf(rs.getString("cpf"));
        autor.setEmail(rs.getString("email"));
        
        return autor;
    }
}
