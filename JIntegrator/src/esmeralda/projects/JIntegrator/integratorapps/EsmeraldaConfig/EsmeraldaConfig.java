package esmeralda.projects.JIntegrator.integratorapps.EsmeraldaConfig;

import esmeralda.projects.JIntegrator.apps.IntegratorApp;
import esmeralda.projects.JIntegrator.apps.IntegratorConfigPanel;
import esmeralda.projects.JIntegrator.beans.AppConfig;
import esmeralda.projects.JIntegrator.business.IntegratorAppsContext;
import esmeralda.projects.JIntegrator.exceptions.ValueNoValidException;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.net.URL;
import java.util.Properties;

public final class EsmeraldaConfig extends IntegratorApp {
    private Image startimage;
    private Image stopimage;
    private DefaultComboBoxModel<String> comboxmodel;
    JButton btnaccept;
    JButton btncancel;
    JButton btnclose;
    JComboBox<String> cmbprogram;
    private JLabel lblprogram;
    private JPanel pnlbottombar;
    private JPanel pnlconfig;
    private JPanel pnltopbar;
    IntegratorConfigPanel currentpanel;
    public EsmeraldaConfig() {


        System.out.println("Contructor EsmeraldaConfig");

    }


    public void init() {

        System.out.println("Método init EsmeraldaConfig");
        this.startimage=this.getImage(this.getClass().getResource("/resources/images/configstart.jpg"));
        this.stopimage=this.getImage(this.getClass().getResource("/resources/images/configstop.jpg"));
        this.comboxmodel=new DefaultComboBoxModel<String>();
        initComponents();



        this.comboxmodel.removeAllElements();


        for (int i=0;i<this.getAppsContext().getAppsConfigs().length;i++) {



            if(this.getAppsContext().getAppByName(this.getAppsContext().getAppsConfigs()[i].getAppname()).getConfigPanel()!=null) {

                this.comboxmodel.addElement(this.getAppsContext().getAppsConfigs()[i].getAppname());


            }


        }

        if (this.comboxmodel.getSelectedItem()==null || ((String)this.comboxmodel.getSelectedItem()).trim().equals("")==true) {

            try {
                this.setStatus(IntegratorApp.ISDISBLE);
            }
            catch(ValueNoValidException e) {


            }

        }
        pack();
        this.setModal(true);


    }


    public void start() {

        System.out.println("Método start EsmeraldaConfig");

        this.setVisible(true);

    }


    public void stop() {

        System.out.println("Método stop EsmeraldaConfig");


    }
    public void destroy() {

        System.out.println("Método destroy EsmeraldaConfig");


    }


    public void translate(Properties language) {


        System.out.println("Método translate EsmeraldaConfig");
        this.setTitle(language.getProperty("integratorconfigapp"));
        this.lblprogram.setText(language.getProperty("programtoconfigure"));
        this.btnaccept.setText(language.getProperty("accept"));
        this.btnclose.setText(language.getProperty("close"));
        this.btncancel.setText(language.getProperty("cancel"));

    }



    public Image getStartImage() {//getStartImage


        return this.startimage;

    }//getStartImage


    public Image getStopImage() {//getStopImage

        return this.stopimage;


    }//getStopImage




    private void initComponents() {

        EsmeraldaConfigEvents configevents;


        try {//try1

            this.setIconImage(this.getImage(new URL(((IntegratorAppsContext)this.getAppsContext()).getAppletappresources().getCodeBase(),"icon.jpg")));


        }//try
        catch(Exception e) {//catch1-1



        }//catch1-11


        configevents=new EsmeraldaConfigEvents(this);
        pnltopbar = new javax.swing.JPanel();
        pnltopbar.setOpaque(true);
        pnltopbar.setBackground(Color.GREEN);
        lblprogram = new javax.swing.JLabel();
        cmbprogram = new javax.swing.JComboBox<>();
        cmbprogram.addActionListener(configevents);
        cmbprogram.setModel(this.comboxmodel);
        pnlbottombar = new javax.swing.JPanel();
        pnlbottombar.setOpaque(true);
        pnlbottombar.setBackground(Color.GREEN);
        btnaccept = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        pnlconfig = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblprogram.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblprogram.setText("Programa  a configurar:");

        javax.swing.GroupLayout pnltopbarLayout = new javax.swing.GroupLayout(pnltopbar);
        pnltopbar.setLayout(pnltopbarLayout);
        pnltopbarLayout.setHorizontalGroup(
                pnltopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnltopbarLayout.createSequentialGroup()
                                .addComponent(lblprogram, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbprogram, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(59, Short.MAX_VALUE))
        );
        pnltopbarLayout.setVerticalGroup(
                pnltopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnltopbarLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(pnltopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblprogram)
                                        .addComponent(cmbprogram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(pnltopbar, java.awt.BorderLayout.PAGE_START);

        btnaccept.setText("Aceptar");
        btnaccept.addActionListener(configevents);
        btncancel.setText("Cancelar");
        btncancel.addActionListener(configevents);
        btnclose.setText("Cerrar");
        btnclose.addActionListener(configevents);
        javax.swing.GroupLayout pnlbottombarLayout = new javax.swing.GroupLayout(pnlbottombar);
        pnlbottombar.setLayout(pnlbottombarLayout);
        pnlbottombarLayout.setHorizontalGroup(
                pnlbottombarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlbottombarLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(btnaccept)
                                .addGap(18, 18, 18)
                                .addComponent(btncancel)
                                .addGap(18, 18, 18)
                                .addComponent(btnclose)
                                .addContainerGap(75, Short.MAX_VALUE))
        );
        pnlbottombarLayout.setVerticalGroup(
                pnlbottombarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlbottombarLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(pnlbottombarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnaccept)
                                        .addComponent(btncancel)
                                        .addComponent(btnclose))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(pnlbottombar, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout pnlconfigLayout = new javax.swing.GroupLayout(pnlconfig);
        pnlconfig.setLayout(pnlconfigLayout);
        pnlconfigLayout.setHorizontalGroup(
                pnlconfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        pnlconfigLayout.setVerticalGroup(
                pnlconfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        //getContentPane().add(pnlconfig, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>


}
