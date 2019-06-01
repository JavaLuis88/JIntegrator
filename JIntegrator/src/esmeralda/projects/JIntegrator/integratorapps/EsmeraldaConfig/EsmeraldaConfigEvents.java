package esmeralda.projects.JIntegrator.integratorapps.EsmeraldaConfig;

import esmeralda.projects.JIntegrator.exceptions.OperationNotWorkException;
import esmeralda.projects.JIntegrator.integratorapps.EsmeraldaLanguage.EsmeraldaLanguage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EsmeraldaConfigEvents implements ActionListener {


    private EsmeraldaConfig configwindow;

    EsmeraldaConfigEvents(EsmeraldaConfig configwindow) {

        this.configwindow = configwindow;


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==this.configwindow.cmbprogram) {



            if (this.configwindow.currentpanel!=null) {
                this.configwindow.getContentPane().remove(this.configwindow.currentpanel);
            }

            this.configwindow.currentpanel=this.configwindow.getAppsContext().getAppByName((String)this.configwindow.cmbprogram.getSelectedItem()).getConfigPanel();
            //this.configwindow.currentpanel.setBorder(BorderFactory.createLineBorder(Color.black));
            this.configwindow.getContentPane().add(this.configwindow.currentpanel,java.awt.BorderLayout.CENTER);
            this.configwindow.pack();
        }
        else if (e.getSource()==this.configwindow.btnaccept) {

            try {
                this.configwindow.currentpanel.save();

            } catch (OperationNotWorkException e2) {

                JOptionPane.showMessageDialog(this.configwindow,e2.getMessage(),this.configwindow.getTitle(),JOptionPane.ERROR_MESSAGE);

            }


        }

        else if (e.getSource()==this.configwindow.btnclose) {


            this.configwindow.dispose();

        }

        else if (e.getSource()==this.configwindow.btncancel) {




            try {
                this.configwindow.currentpanel.cancel();

            } catch (OperationNotWorkException e2) {

                JOptionPane.showMessageDialog(this.configwindow,e2.getMessage(),this.configwindow.getTitle(),JOptionPane.ERROR_MESSAGE);

            }



        }


    }
}
