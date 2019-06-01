package esmeralda.projects.JIntegrator.integratorapps.EsmeraldaLanguage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Properties;

final class EsmeraladaLanguageEvents implements ActionListener {


    private EsmeraldaLanguage languagewindow;

    EsmeraladaLanguageEvents(EsmeraldaLanguage languagewindow) {

        this.languagewindow = languagewindow;


    }


    @Override
    public final void actionPerformed(ActionEvent e) {

        Properties languageintegrator;
        Properties languageapps[];
        boolean execute;
        int i;



        if (e.getSource() == this.languagewindow.btnaccept) {

            System.out.println( this.languagewindow.hashlanguage.get((String) this.languagewindow.lstlanguage.getSelectedItem()));


            if (this.languagewindow.lstlanguage.getSelectedItem() != null && this.languagewindow.hashlanguage.get((String) this.languagewindow.lstlanguage.getSelectedItem()) != null) {


                try {
                    this.languagewindow.getCurrentLanguage().setCurrentlanguage(new Locale(this.languagewindow.hashlanguage.get((String) this.languagewindow.lstlanguage.getSelectedItem())));
                    languageintegrator = this.languagewindow.getCurrentLanguage().loadItegratorLanguage();

                    languageapps = new Properties[this.languagewindow.getAppsContext().getApps().length];
                    for (i = 0; i < this.languagewindow.getAppsContext().getApps().length; i++) {

                        languageapps[i] = this.languagewindow.getCurrentLanguage().loadAppLanguage(this.languagewindow.getAppsContext().getAppsConfigs()[i].getAppname());


                    }


                    this.languagewindow.getAppbuttons()[0].setToolTipText(languageintegrator.getProperty("integratorconfigapp", ""));
                    this.languagewindow.getAppbuttons()[1].setToolTipText(languageintegrator.getProperty("integratorconfigapp", ""));
                    for (i = 0; i < this.languagewindow.getSystemApps().length; i++) {

                        this.languagewindow.getSystemApps()[i].translate(languageintegrator);


                    }

                    for (i = 0; i < this.languagewindow.getAppsContext().getApps().length; i++) {

                        this.languagewindow.getAppbuttons()[2+i].setToolTipText(languageapps[i].getProperty("appname",""));
                        this.languagewindow.getAppsContext().getApps()[i].translate(languageapps[i]);

                    }


                    this.languagewindow.getAppsContext().getUserConfig().setProperty("language",this.languagewindow.getCurrentLanguage().getCurrentlanguage().getLanguage());
                    execute=true;
                    i=0;
                    while(i<this.languagewindow.lstlanguage.getItemCount() && execute==true) {




                        //this.lstlanguage.getItemAt(i)


                        if (this.languagewindow.hashlanguage.get(this.languagewindow.lstlanguage.getItemAt(i)).equalsIgnoreCase( this.languagewindow.getCurrentLanguage().getCurrentlanguage().getLanguage())) {


                            this.languagewindow.lstlanguage.setSelectedIndex(i);
                            execute=false;


                        }

                        i++;
                    }



                }
                catch(Exception e2) {
                    JOptionPane.showMessageDialog(this.languagewindow, this.languagewindow.loadedlanguge.getProperty("loadlanguageerror"), this.languagewindow.loadedlanguge.getProperty("integratorlanguageselecteapp"), JOptionPane.ERROR_MESSAGE);


                }

            }
            else {


                JOptionPane.showMessageDialog(this.languagewindow, this.languagewindow.loadedlanguge.getProperty("loadlanguageerror"), this.languagewindow.loadedlanguge.getProperty("integratorlanguageselecteapp"), JOptionPane.ERROR_MESSAGE);
            }

        } else {

            this.languagewindow.dispose();

        }

    }

}