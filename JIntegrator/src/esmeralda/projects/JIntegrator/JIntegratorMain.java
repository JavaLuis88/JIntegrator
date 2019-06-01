package esmeralda.projects.JIntegrator;

import esmeralda.projects.JIntegrator.GUI.IntegratorWindow;

public class JIntegratorMain {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IntegratorWindow integratorwindow;
                integratorwindow = new IntegratorWindow();

            }

    });
    }
}
