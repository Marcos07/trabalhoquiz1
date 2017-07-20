/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.List;
import model.Resposta;

/**
 *
 * @author wlysses & polliana
 */
public class RespostaDao {
    
        PreparedStatement pst;
        String sql;
    
    public int salvar(Resposta resposta)throws SQLException {
        
        int idResposta = 0;
        sql = "insert into resposta values(?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, resposta.getDescricao());
        pst.setString(3, resposta.getComentario());
        pst.setInt(4, NULL);
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        while (rs.next()){
                
           
            idResposta = rs.getInt(1);
       }  
        pst.close();
        return idResposta;
    
}
    public List<Resposta> ListaResposta(int idPergunta) throws SQLException {
        List<Resposta> listaResposta;
        listaResposta = new ArrayList<>();
        sql = "select * from resposta where id_pergunta = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, idPergunta);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            listaResposta.add(new Resposta(rs.getInt("id"), rs.getString("descricao"), rs.getInt("id_pergunta"), rs.getString("comentário")));
        }
        pst.close();
        return listaResposta;
    }
}