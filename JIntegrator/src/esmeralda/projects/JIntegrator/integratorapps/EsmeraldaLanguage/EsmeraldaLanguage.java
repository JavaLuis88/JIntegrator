package esmeralda.projects.JIntegrator.integratorapps.EsmeraldaLanguage;

import esmeralda.projects.JIntegrator.GUI.IntegratorWindow;
import esmeralda.projects.JIntegrator.apps.IntegratorApp;
import esmeralda.projects.JIntegrator.business.IntegratorAppsContext;
import esmeralda.projects.JIntegrator.business.Language;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.*;

public final class EsmeraldaLanguage extends IntegratorApp {


    private IntegratorApp[] integrartorapps;
    private IntegratorWindow integratorwindow;
    private Language language;
    private Image startimage;
    private Image stopimage;
    private JLabel lbllanguage;
    private DefaultComboBoxModel<String> comboxmodel;
    private JButton appbuttons[];
    Properties loadedlanguge;
    JButton btnaccept;
    JButton btnclose;
    JComboBox<String> lstlanguage;
    Hashtable<String,String> hashlanguage;

    public EsmeraldaLanguage() {



        System.out.println("Contructor EsmeraldaLanguage");

    }


    public void init() {


        System.out.println("Método init EsmeraldaLanguage");
        this.startimage=this.getImage(this.getClass().getResource("/resources/images/lenguajeiniciar.jpg"));
        this.stopimage=this.getImage(this.getClass().getResource("/resources/images/lenguajeparar.jpg"));
        this.comboxmodel=new DefaultComboBoxModel<String>();
        this.hashlanguage=new Hashtable<String,String>();
        initComponents();
        this.setModal(true);

    }


    public void start() {

        System.out.println("Método start EsmeraldaLanguage");

        boolean execute;
        int i;

        execute=true;
        i=0;

        while(i<this.lstlanguage.getItemCount() && execute==true) {




            //this.lstlanguage.getItemAt(i)


            if (this.hashlanguage.get(this.lstlanguage.getItemAt(i)).equalsIgnoreCase(this.language.getCurrentlanguage().getLanguage())) {


                this.lstlanguage.setSelectedIndex(i);
                execute=false;


            }

            i++;
        }


        this.setVisible(true);

    }


    public void stop() {

        System.out.println("Método stop EsmeraldaLanguage");

    }
    public void destroy() {

        System.out.println("Método destroy EsmeraldaLanguage");


    }


    public final void translate(Properties language) {


        System.out.println("Método translate EsmeraldaLanguage");
        this.getContentPane().setBackground(Color.GREEN);
        this.loadedlanguge=language;
        this.hashlanguage.clear();
        this.hashlanguage.put(language.getProperty("espanol"),"es");
        this.hashlanguage.put(language.getProperty("english"),"en");
        this.comboxmodel.removeAllElements();
        this.comboxmodel.addElement(language.getProperty("espanol"));
        this.comboxmodel.addElement(language.getProperty("english"));
        this.setTitle(language.getProperty("integratorlanguageselecteapp"));
        this.lbllanguage.setText(language.getProperty("language") + ":");
        this.btnaccept.setText(language.getProperty("accept"));
        this.btnclose.setText(language.getProperty("close"));

    }



    public final void setSystemApps(IntegratorApp[] integrartorapps) {

        this.integrartorapps=integrartorapps;

    }



    public final IntegratorApp[] getSystemApps() {

        return this.integrartorapps;

    }



    public final void setCurrentLanguage(Language language) {

        this.language=language;

    }



    public final Language getCurrentLanguage() {

        return this.language;

    }


    public final void setIntegratorWindow(IntegratorWindow integratorwindow) {

        this.integratorwindow=integratorwindow;

    }



    public final IntegratorWindow getIntegratorWindow() {

        return this.integratorwindow;

    }



    public final Image getStartImage() {//getStartImage


        return this.startimage;

    }//getStartImage


    public final Image getStopImage() {//getStopImage

        return this.stopimage;


    }//getStopImage




    public final JButton[] getAppbuttons() {//getAppbuttons


        return this.appbuttons;

    }//getAppbuttons


    public final void setAppbutton(JButton[] appbuttons) {//setAppbutton

        this.appbuttons=appbuttons;


    }//setAppbutton




    private final void initComponents() {




        try {//try1

            this.setIconImage(this.getImage(new URL(((IntegratorAppsContext)this.getAppsContext()).getAppletappresources().getCodeBase(),"icon.jpg")));


        }//try
        catch(Exception e) {//catch1-1



        }//catch1-11


        lbllanguage = new javax.swing.JLabel();
        lstlanguage = new javax.swing.JComboBox<>();
        btnaccept = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbllanguage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbllanguage.setText("Lenguaje:");

        btnaccept.setText("Aceptar");
        btnaccept.addActionListener(new EsmeraladaLanguageEvents(this));

        btnclose.setText("Cerrar");
        btnclose.addActionListener(new EsmeraladaLanguageEvents(this));
        lstlanguage.setModel(this.comboxmodel);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnaccept)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnclose)
                                                .addGap(12, 12, 12))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbllanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lstlanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbllanguage)
                                        .addComponent(lstlanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnaccept)
                                        .addComponent(btnclose))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();

    }
}
