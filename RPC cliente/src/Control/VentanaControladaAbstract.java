package Control;

import Control.ControlInter;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public abstract class VentanaControladaAbstract
  extends JFrame
  implements ActionListener
{
  protected ControlInter superCtrl;
  
  public VentanaControladaAbstract() {}
  
  public VentanaControladaAbstract(String t) { super(t); }

  public void setSuperCtrl(ControlInter ctrl) { this.superCtrl = ctrl; }
  
}