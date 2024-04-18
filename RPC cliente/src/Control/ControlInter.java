/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control;

import GUI.lobby;

/**
 *
 * @author Jiro
 */
public abstract interface ControlInter {

    public abstract void setVentanaLobby(lobby paramlobby);

    public abstract void muestraVentanaLobby(boolean paramBoolean);

    public abstract String getClave();

    public abstract void setClave(String paramString);
}
