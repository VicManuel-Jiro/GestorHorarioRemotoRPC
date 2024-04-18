/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import Conexion_BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Vector;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Jiro
 */
public class ServerObject_RPC {

    Conexion C = new Conexion();
    Connection CC;
    PreparedStatement us;
    Statement st;
    ResultSet rs;
    int auxiliar;
    Vector<Vector<String>> materias=new Vector<Vector<String>>();
    Vector<String> id =new Vector<String>();
    Vector<String> semestre =new Vector<String>();
    Vector<String> clave =new Vector<String>();
    Vector<String> materia =new Vector<String>();
    Vector<String> dia =new Vector<String>();
    Vector<String> inicioH =new Vector<String>();
    Vector<String> inicioM =new Vector<String>();
    Vector<String> finH =new Vector<String>();
    Vector<String> finM =new Vector<String>();


    public ServerObject_RPC() throws BadLocationException {
        this.CC = C.conex();
    }

    public void crear(String semestre, String clave,String materia, String dia, String inicioH, String inicioM, String finH, String finM) {
        try{
            us=CC.prepareStatement("INSERT INTO horario (semestre,clave,materia,dia,inicioh,iniciom,finh,finm)VALUES(?,?,?,?,?,?,?,?)");
            //VALUES(?,?,?,?,?,?,?,?)
            us.setString(1, semestre);
            us.setString(2, clave);
            us.setString(3, materia);
            us.setString(4, dia);
            us.setInt(5, Integer.parseInt(inicioH));
            us.setInt(6, Integer.parseInt(inicioM));
            us.setInt(7, Integer.parseInt(finH));
            us.setInt(8, Integer.parseInt(finM));
            System.out.println(us.executeUpdate());
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void borrar(int id) {
                try {
                    String sql = "DELETE FROM horario WHERE id=?";
                    this.us = CC.prepareStatement(sql);
                    this.us.setInt(1, id);
                    this.us.executeUpdate();
                }
                catch (SQLException ex) {
                    System.out.println("error");
                }
    }

    public void modificar(String id, String semestre, String clave,String materia, String dia, String inicioH, String inicioM, String finH, String finM) {
        try{
            us=CC.prepareStatement("UPDATE horario SET semestre=?,clave=?,materia=?,dia=?,inicioh=?,iniciom=?,finh=?,finm=? WHERE id=? ");
            us.setString(1, semestre);
            us.setString(2, clave);
            us.setString(3, materia);
            us.setString(4, dia);
            us.setInt(5, Integer.parseInt(inicioH));
            us.setInt(6, Integer.parseInt(inicioM));
            us.setInt(7, Integer.parseInt(finH));
            us.setInt(8, Integer.parseInt(finM));
            us.setInt(9, Integer.parseInt(id));
            System.out.println(us.executeUpdate());
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Vector<Vector<String>> ConsultaMateria(String clave) {
        //consultar todos los horarios de una materia
        Materia[] materia = null;
        try {
            this.materias.clear();
            this.id.clear();
            this.semestre.clear();
            this.clave.clear();
            this.materia.clear();
            this.dia.clear();
            this.inicioH.clear();
            this.inicioM.clear();
            this.finH.clear();
            this.finM.clear();
            String consulta = "SELECT COUNT(*) as total FROM horario WHERE clave='" + clave+"'";
            st = CC.createStatement();
            rs = st.executeQuery(consulta);
            rs.next();
            auxiliar = rs.getInt("total");
            materia = new Materia[auxiliar];
            consulta = "SELECT * FROM horario WHERE clave='" + clave+"' ORDER BY dia DESC";//
            //sql = "SELECT id_paciente,nombre_completo(id_paciente) as nombre from paciente where upper(nombre) LIKE upper(?) or upper(apellidos) LIKE upper(?) order by id_paciente DESC";
            st = CC.createStatement();
            rs = st.executeQuery(consulta);
            
            while(rs.next()){
                id.addElement(rs.getInt("id")+"");
                semestre.addElement(rs.getString("semestre"));
                this.clave.addElement(rs.getString("clave"));
                this.materia.addElement(rs.getString("materia"));
                dia.addElement(rs.getString("dia"));
                inicioH.addElement(rs.getInt("inicioh")+"");
                inicioM.addElement(rs.getInt("iniciom")+"");
                finH.addElement(rs.getInt("finh")+"");
                finM.addElement(rs.getInt("finm")+"");
            }
            this.materias.addElement(id);
            this.materias.addElement(semestre);
            this.materias.addElement(this.clave);
            this.materias.addElement(this.materia);
            this.materias.addElement(dia);
            this.materias.addElement(inicioH);
            this.materias.addElement(inicioM);
            this.materias.addElement(finH);
            this.materias.addElement(finM);
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.materias;
    }
public Vector<Vector<String>> ConsultaMateriaid(int id) {
        //consultar todos los horarios de una materia
        Materia[] materia = null;
        try {
            this.materias.clear();
            this.id.clear();
            this.semestre.clear();
            this.clave.clear();
            this.materia.clear();
            this.dia.clear();
            this.inicioH.clear();
            this.inicioM.clear();
            this.finH.clear();
            this.finM.clear();
            String consulta = "SELECT COUNT(*) as total FROM horario WHERE id='" + id+"'";
            st = CC.createStatement();
            rs = st.executeQuery(consulta);
            rs.next();
            auxiliar = rs.getInt("total");
            materia = new Materia[auxiliar];
            consulta = "SELECT * FROM horario WHERE id='" + id+"' ORDER BY dia DESC";//
            //sql = "SELECT id_paciente,nombre_completo(id_paciente) as nombre from paciente where upper(nombre) LIKE upper(?) or upper(apellidos) LIKE upper(?) order by id_paciente DESC";
            st = CC.createStatement();
            rs = st.executeQuery(consulta);
            
            while(rs.next()){
                this.id.addElement(rs.getInt("id")+"");
                semestre.addElement(rs.getString("semestre"));
                this.clave.addElement(rs.getString("clave"));
                this.materia.addElement(rs.getString("materia"));
                dia.addElement(rs.getString("dia"));
                inicioH.addElement(rs.getInt("inicioh")+"");
                inicioM.addElement(rs.getInt("iniciom")+"");
                finH.addElement(rs.getInt("finh")+"");
                finM.addElement(rs.getInt("finm")+"");
            }
           
            this.materias.addElement(this.id);
            this.materias.addElement(semestre);
            this.materias.addElement(this.clave);
            this.materias.addElement(this.materia);
            this.materias.addElement(dia);
            this.materias.addElement(inicioH);
            this.materias.addElement(inicioM);
            this.materias.addElement(finH);
            this.materias.addElement(finM);
            System.out.println("entro en el de int "+this.id);
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.materias;
    }
    public Vector<Vector<String>> consultaHorario() {
        //consultar todas las materias
         //consultar todos los horarios de una materia
        Materia[] materia = null;
        try {
            this.materias.clear();
            this.id.clear();
            this.semestre.clear();
            this.clave.clear();
            this.materia.clear();
            this.dia.clear();
            this.inicioH.clear();
            this.inicioM.clear();
            this.finH.clear();
            this.finM.clear();
            String consulta = "SELECT COUNT(*) as total FROM horario";
            st = CC.createStatement();
            rs = st.executeQuery(consulta);
            rs.next();
            auxiliar = rs.getInt("total");
            materia = new Materia[auxiliar];
            consulta = "SELECT * FROM horario ORDER BY clave DESC";
            st = CC.createStatement();
            rs = st.executeQuery(consulta);
            
            while(rs.next()){
                id.addElement(rs.getInt("id")+"");
                semestre.addElement(rs.getString("semestre"));
                this.clave.addElement(rs.getString("clave"));
                this.materia.addElement(rs.getString("materia"));
                dia.addElement(rs.getString("dia"));
                inicioH.addElement(rs.getInt("inicioh")+"");
                inicioM.addElement(rs.getInt("iniciom")+"");
                finH.addElement(rs.getInt("finh")+"");
                finM.addElement(rs.getInt("finm")+"");
            }
           
            this.materias.addElement(id);
            this.materias.addElement(semestre);
            this.materias.addElement(this.clave);
            this.materias.addElement(this.materia);
            this.materias.addElement(dia);
            this.materias.addElement(inicioH);
            this.materias.addElement(inicioM);
            this.materias.addElement(finH);
            this.materias.addElement(finM);
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.materias;
    }

    public int insertar_nSaldo(String saldo, String fecha, String usuario) {
        int acceso = 0;
        int s = Integer.parseInt(saldo);
        int u = Integer.parseInt(usuario);
        try {
            us = CC.prepareStatement("INSERT INTO saldo(saldo"
                    + ",fecha,usuario_idUsuario) VALUES("
                    + s + ",'" + fecha + "'," + u + ")");
            us.executeUpdate();
            acceso = 1;
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return acceso;
    }

}
