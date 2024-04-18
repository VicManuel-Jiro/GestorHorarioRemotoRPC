/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Control.ControlApp;
import Control.ControlInter;
import GUI.lobby;
import javax.swing.JOptionPane;

/**
 *
 * @author Jiro
 */
public class Main {

    public static void main(String[] args) {
        lobby vLobby = new lobby();
        vLobby.pack();
        ControlInter ctrlPrincipal = new ControlApp();
        ctrlPrincipal.setVentanaLobby(vLobby);
        String ip = "";
        ip = JOptionPane.showInputDialog("Ingrese la IP del servidor");
        if (ip.matches("^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$")) {
            //System.out.println(ip);
            String c="http://";
            String d=":81/";
            String ruta=c+ip.trim()+d;
            vLobby.setRuta_RPC(ruta);
            ctrlPrincipal.muestraVentanaLobby(true);
        } else {
            JOptionPane.showMessageDialog(null, "La IP no es válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
