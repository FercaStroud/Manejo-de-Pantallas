/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.*;

/**
 * @author jose.delgado
 */
public class CicloVida extends MIDlet implements CommandListener {

    private Display myDisplay;
    Form principal;
    Form nivel1;
    Form nivel2;
    private static final Command CMD_EXIT = new Command("Exit", Command.EXIT, 1);
    private static final Command CMD_BACK = new Command("Back", Command.BACK, 2);
    private static final Command CMD_NEXT = new Command("Next", Command.SCREEN, 2);

    public void startApp() {
        myDisplay = Display.getDisplay(this);
        myDisplay.setCurrent(Principal());
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == CMD_EXIT) {
            try {
                // Signals the MIDlet to terminate and enter the Destroyed state.
                destroyApp(true);
                System.gc();
                notifyDestroyed();
            } catch (Exception ex) {
            }
        }
        if (c == CMD_NEXT) {
            if (d == principal) {
                myDisplay.setCurrent(SubMenuNivel1());
            }
            if (d == nivel1) {
                myDisplay.setCurrent(SubMenuNivel2());
            }
        }
        if (c == CMD_BACK) {
            if (d == nivel1) {
                myDisplay.setCurrent(principal);
            }
            if (d == nivel2) {
                myDisplay.setCurrent(nivel1);
            }
        }
    }

    public Displayable Principal() {
        principal = new Form("Menu Principal");
        principal.addCommand(CMD_NEXT);
        principal.addCommand(CMD_EXIT);
        principal.setCommandListener(this);
        return principal;
    }

    public Displayable SubMenuNivel1() {
        nivel1 = new Form("Sub Menu Nivel 1");
        nivel1.addCommand(CMD_NEXT);
        nivel1.addCommand(CMD_BACK);

        nivel1.setCommandListener(this);
        return nivel1;
    }

    public Displayable SubMenuNivel2() {
        nivel2 = new Form("Sub Menu Nivel 2");
        nivel2.addCommand(CMD_NEXT);
        nivel2.addCommand(CMD_BACK);
        nivel2.setCommandListener(this);
        return nivel2;
    }
}
