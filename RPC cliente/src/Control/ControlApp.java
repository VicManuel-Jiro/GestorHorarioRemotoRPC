/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import GUI.lobby;

/**
 *
 * @author Jiro
 */
public class ControlApp implements ControlInter {
    private lobby vlobby;
    private String clave;
    public void setVentanaLobby(lobby c)
  {
    this.vlobby = c;
    this.vlobby.setSuperCtrl(this);
  }
  
  public void muestraVentanaLobby(boolean b)
  {
    //this.vcitas.setVisible(!b);
    //this.cita.setVisible(!b);
    //this.vpaciente.setVisible(!b);
    //this.vReportes.setVisible(!b);
    //this.vpass.setVisible(!b);
    this.vlobby.setVisible(b);
    //this.vlobby.consulta();
    //this.usuarios.setVisible(!b);
  }
   public void setClave(String clave)
  {
    this.clave = clave;
  }
  
  public String getClave()
  {
    return this.clave;
  }

}
