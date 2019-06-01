package esmeralda.projects.JIntegrator.GUI;

import esmeralda.projects.JIntegrator.apps.IntegratorApp;

import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;




final class IntegratorAppsEvents extends Thread implements WindowListener, ActionListener {

    private boolean runthread;
    private IntegratorApp integratorapp;
    private JButton buttonapp;
    private Image startimage;
    private Image stopimage;
    private boolean istart;

    IntegratorAppsEvents(IntegratorApp integratorapp, JButton buttonapp,Image startimage,Image stopimage) {

        this.runthread=true;
        this.integratorapp=integratorapp;
        this.buttonapp=buttonapp;
        this.startimage=startimage;
        this.stopimage=stopimage;
        this.istart=false;
        this.start();
    }


    @Override
    public final void run() {


        while(runthread==true) {



            this.buttonapp.setEnabled((this.integratorapp.getStatus()==IntegratorApp.ISENABLE));


        }



    }


    @Override
    public final void actionPerformed(ActionEvent e) {


        if (this.istart==true) {


            this.stopapp();

        }
        else {

            this.startapp();

        }

    }

    @Override
    public final void windowOpened(WindowEvent e) {

    }

    @Override
    public final void windowClosing(WindowEvent e) {





    }

    @Override
    public final void windowClosed(WindowEvent e) {
        this.stopapp();
    }

    @Override
    public final void windowIconified(WindowEvent e) {

    }

    @Override
    public final void windowDeiconified(WindowEvent e) {

    }

    @Override
    public final void windowActivated(WindowEvent e) {

    }

    @Override
    public final void windowDeactivated(WindowEvent e) {

    }


    private final void startapp() {

        this.istart=true;
        this.buttonapp.setIcon(new ImageIcon(this.startimage));
        this.integratorapp.start();

    }

    private final void stopapp() {

        this.istart=false;
        this.integratorapp.stop();
        this.buttonapp.setIcon(new ImageIcon(this.stopimage));




    }

}
