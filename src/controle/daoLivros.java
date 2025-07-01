
package controle;

import abstratas.dao;
import enums.FaixaEtaria;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import model.Autor;
import model.Livros;

public class daoLivros extends dao {
    public int create (Livros livros) throws SQLException{
        String SQL = "insert into livros (id_autor, titulo, preco, resumo, faixa_etaria) values (?, ?, ?, ?, ?)";
        return super.executeUpdate(SQL, livros.getAutor().getId(), livros.getTitulo(), livros.getPreco(), livros.getResumo(), livros.getFaixaEtaria().name());
    }
    
    public int update (Livros livros) throws SQLException{
        String SQL = "update livros set id_autor = ?, titulo = ?, preco = ?, resumo = ?, faixa_etaria = ? where id_livro = ?";
        return super.executeUpdate(SQL, livros.getAutor().getId(), livros.getTitulo(), livros.getPreco(), livros.getResumo(), livros.getFaixaEtaria().name(), livros.getId());
    }
    
    public int delete (Livros livros) throws SQLException{
        return super.executeUpdate("delete from livros where id_livro = "+ livros.getId());
    }
    
    public Livros read(int id) throws SQLException{
        String SQL="select * from livros where id_livro = ?";
        ResultSet rs = super.executeQuery(SQL, id);
        return (!rs.next() ? null : montaObjeto(rs));
        
    }    
    
    public List<Livros> read() throws SQLException{
        String SQL ="select * from livros order by titulo";
        ResultSet rs = super.executeQuery(SQL);
        List<Livros> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;
    }
    
    private Livros montaObjeto(ResultSet rs) throws SQLException{
        Livros livros = new Livros();
        livros.setId(rs.getInt("id_livro"));
        
        Autor a = new daoAutor().read(rs.getInt("id_autor"));
        livros.setAutor(a);
        
        livros.setTitulo(rs.getString("titulo"));
        livros.setPreco(rs.getDouble("preco"));
        livros.setResumo(rs.getString("resumo"));
        FaixaEtaria fe = FaixaEtaria.valueOf(rs.getString("faixa_etaria"));
        livros.setFaixaEtaria(fe);
        
        return livros;
    }
}
