package esmeralda.projects.JIntegrator.GUI;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


final class IntegratorWindowEvent implements WindowListener{//class



    private IntegratorWindow mainwindow;


    ////////////////
    //Constructor//
    //////////////

    IntegratorWindowEvent(IntegratorWindow mainwindow) {//constructor




        this.mainwindow=mainwindow;




    }//constructor



    ///////////////
    //Interfaces//
    /////////////


    @Override
    public final void windowOpened(WindowEvent e) {//windowOpened



    }//windowOpened

    @Override
    public final void windowClosing(WindowEvent e) {//windowClosing


        this.mainwindow.destroy();


    }//windowClosing

    @Override
    public final void windowClosed(WindowEvent e) {//windowClosed



    }//windowClosed

    @Override
    public final void windowIconified(WindowEvent e) {//windowIconified

    }//windowIconified

    @Override
    public final void windowDeiconified(WindowEvent e) {//windowDeiconified

    }//windowDeiconified

    @Override
    public final void windowActivated(WindowEvent e) {//windowActivated




    }//windowActivated

    @Override
    public final void windowDeactivated(WindowEvent e) {//windowDeactivated


    }//windowDeactivated





}//class
