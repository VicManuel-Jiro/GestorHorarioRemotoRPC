/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Main.Main;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jiro
 */
public class tiempo {

    public String convierte(int h, int m) {
        DateFormat formatoOrigen = new SimpleDateFormat("HHmm");
        DateFormat formatoDestino = new SimpleDateFormat("HH:mm");
        Date fecha = null;
        String hora = "";
        if (h < 10 || m < 10) {
            if (h < 10) {
                hora = "0" + Integer.toString(h);
            } else {
                hora = "" + Integer.toString(h);
            }
            if (m < 10) {
                hora += "0" + Integer.toString(m);
            } else {
                hora += "" + Integer.toString(m);
            }
        }
        try {
            fecha = formatoOrigen.parse(hora);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        String fechaFormato = formatoDestino.format(fecha);
        //System.out.println(fechaFormato);
        return fechaFormato;

    }
}
