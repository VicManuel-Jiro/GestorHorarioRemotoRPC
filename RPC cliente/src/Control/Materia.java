/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author Jiro
 */
public class Materia {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String semestre;
    private String clave;
    private String materia;
    private String dia;
    private int inicioH,inicioM,finH,finM;

    public Materia(String semestre, String clave, String materia, String dia, int inicioH, int inicioM, int finH, int finM,int id) {
        this.id=id;
        this.semestre = semestre;
        this.clave = clave;
        this.materia = materia;
        this.dia = dia;
        this.inicioH = inicioH;
        this.inicioM = inicioM;
        this.finH = finH;
        this.finM = finM;
        
    }

    public Materia() {
        this.id=0;
        this.semestre = "";
        this.clave = "";
        this.materia = "";
        this.dia = "";
        this.inicioH = 0;
        this.inicioM = 0;
        this.finH = 0;
        this.finM = 0;
    }
    
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setInicioH(int inicioH) {
        this.inicioH = inicioH;
    }

    public void setInicioM(int inicioM) {
        this.inicioM = inicioM;
    }

    public void setFinH(int finH) {
        this.finH = finH;
    }

    public void setFinM(int finM) {
        this.finM = finM;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getClave() {
        return clave;
    }

    public String getDia() {
        return dia;
    }

    public int getInicioH() {
        return inicioH;
    }

    public int getInicioM() {
        return inicioM;
    }

    public int getFinH() {
        return finH;
    }

    public int getFinM() {
        return finM;
    }
    
}
