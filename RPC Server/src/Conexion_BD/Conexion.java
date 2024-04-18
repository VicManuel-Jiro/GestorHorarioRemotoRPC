/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion_BD;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.text.BadLocationException;
import GUI.Server;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jiro
 */
public class Conexion {
       Connection con = null;  
       String bd="escuela";
       String url="jdbc:mysql://localhost:3306/";
       String user="root";
       String password="";
       String driver="com.mysql.cj.jdbc.Driver";
       
    public Connection conex () throws BadLocationException{
        try{
        Class.forName(driver);
        con= DriverManager.getConnection(url+bd,user,password);
            //System.out.println("conecto");
            Server.Write("\n[Servidor BD] Conexion establecida\n");
        }catch(Exception e){
            Server.Write("\n[Servidor BD] NO se pudo iniciar la Base de Datos\n");
            //System.out.println("no conecto");
        }
        return con;
    }
    public void desconectar(){
           try {
               con.close();
           } catch (SQLException ex) {
               Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
    public static void main(String[] args){
    Conexion conexion= new Conexion();
           try {
               conexion.conex();
           } catch (BadLocationException ex) {
               Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
           }
    
    }
}
