/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import login.ConexionDB;
import model.Pastel;

/**
 *
 * @author gabhs
 */
public class ConsultaPasteles {
    private ConexionDB con;
    private ResultSet rs;
    private PreparedStatement sentencia;
    Long res;
    Pastel pastel;
        Long fin;
    
    public void listar(JComboBox cbox_pastel){
    String insert = "SELECT nombre FROM pastel";
        try {
            sentencia=con.getInstance().getConnection().prepareStatement(insert);
            rs = sentencia.executeQuery();
            while(rs.next()){
                cbox_pastel.addItem(rs.getString("nombre"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaPasteles.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public Pastel Costo(String nombre) {
        String insert = "SELECT * FROM pastel WHERE nombre =?";
        try {
            sentencia=con.getInstance().getConnection().prepareStatement(insert);
            sentencia.setString(1, nombre); //OJO AQUI QUE PUEDE QUE EL 1 SEA OTRO
            rs = sentencia.executeQuery();
            if (rs.next()) {
                Pastel p = new Pastel();
                p.setId(rs.getLong(1));
                p.setCosto(rs.getLong(2));
                p.setNombre(rs.getString(3));
                pastel = p;
            } else {

                pastel = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaPasteles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pastel;
    }
}