package esmeralda.projects.JIntegrator.GUI;
import esmeralda.libs.AppletAppTools.AppletAppResources;
import esmeralda.projects.JIntegrator.apps.IntegratorApp;
import esmeralda.projects.JIntegrator.beans.AppConfig;
import esmeralda.projects.JIntegrator.beans.MainConfig;
import esmeralda.projects.JIntegrator.business.*;
import esmeralda.projects.JIntegrator.exceptions.*;
import esmeralda.projects.JIntegrator.integratorapps.EsmeraldaConfig.EsmeraldaConfig;
import esmeralda.projects.JIntegrator.integratorapps.EsmeraldaLanguage.EsmeraldaLanguage;


import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.ArrayList;


public final class IntegratorWindow extends JFrame {//class

    IntegratorApp[] integratorapps;
    JButton appbuttons[];
    private UserConfig userconfig;
    private Language currentlanguage;

    ////////////////
    //Constructor//
    //////////////

    public IntegratorWindow() {//constructor

        super("JIntegrator");

        String apppath;
        String userhome;



        URL codebase;
        URL documentbase;


        File paramfile;
        AppletAppResources appletappresource;
        String mainconfigfilepath;
        String language;
        Hashtable<String, Object> bang;
        //Language currentlanguage2;



        String windowtitle;
        String errormsg;
        Properties integratorlanguage;
        Properties integratorlanguage2;
        Properties apsslanguage;
        URL urlresource;
        ProcessConfigFile processconfig;
        MainConfig mainconfig;

        Image startimage;
        Image stopimage;
        IntegratorAppsContext integratorapsscontext;
        AppConfig[] appconfig;
        ArrayList<Properties> appslanguages;
        int i;

        windowtitle = "";
        errormsg = "";
        integratorlanguage = null;
        integratorlanguage2 = null;
        processconfig = null;
        mainconfig = null;
        mainconfigfilepath = "";
        appletappresource=null;
        bang=null;
        startimage=null;
        stopimage=null;
        integratorapps=null;
        integratorapsscontext=null;
        this.currentlanguage=null;
        //currentlanguage2=null;
        windowtitle = "JIntegrator";
        appslanguages=null;
        i=0;


        apppath = this.getClass().getResource("IntegratorWindow.class").toString();
        apppath = apppath.substring(9);
        apppath = apppath.substring(0, apppath.indexOf(Constaints.JARFILENAME));





        try {//try


            userhome = System.getProperty("user.home");


        }//try
        catch (Exception e) {//catch

            userhome = apppath;


        }//catch


        if (userhome.charAt(userhome.length() - 1) != File.separatorChar) {//if


            userhome = userhome + File.separator;

        }//if


        codebase = null;


        paramfile = new File(apppath + "config" + File.separator + "params.properties");


        try {//try

            codebase = new URL("file:///" + apppath);


        }//try
        catch (MalformedURLException e) {//catch

            errormsg="Exception loading application";


        }//catch

        documentbase = null;

        if (errormsg == null || errormsg.trim().equals("") == true) {//if1
            try {//try

                documentbase = new URL("file:///" + userhome);


            }//try
            catch (MalformedURLException e) {//catch
                errormsg = "Exception loading application";



            }//catch

        }//if1

        if (errormsg == null || errormsg.trim().equals("") == true) {//if1

            appletappresource = new AppletAppResources(paramfile, codebase, documentbase);
            startimage = appletappresource.getImage(this.getClass().getResource("/resources/images/start.jpg"));
            stopimage=appletappresource.getImage(this.getClass().getResource("/resources/images/stop.jpg"));


            bang = new Hashtable<String, Object>();

            try {//try1
                currentlanguage = new Language(appletappresource.getCodeBase(), appletappresource.getDocumentbase());
                integratorlanguage = currentlanguage.loadItegratorLanguage();


                mainconfigfilepath = appletappresource.getParameters("mainconfigfile");
                language = appletappresource.getParameters("language");

                windowtitle = integratorlanguage.getProperty("mainwindowtitle");


                if (mainconfigfilepath == null || mainconfigfilepath.trim().equals("") == true) {//if2

                    errormsg = integratorlanguage.getProperty("mainconfigfilenospecified");


                }//if2

                if (language != null && language.trim().equals("") == false) {//if2


                    currentlanguage.setCurrentlanguage(new Locale(language));
                    try {//try2


                        integratorlanguage = currentlanguage.loadItegratorLanguage();
                        windowtitle = integratorlanguage.getProperty("mainwindowtitle");


                    }//try2

                    catch (LoadingLanguageException e2) {//catch2-1

                        errormsg = integratorlanguage.getProperty("defaultlaguagenotload");


                    }//catch2-1

                }//if2


            }//try1
            catch (ValueNoValidException e) {//catch1-1


                errormsg = "No se ha podido cargar el lenguaje por defecto";

            }//catch1-1


            catch (LoadingLanguageException e) {//catch1-2


                errormsg = "No se ha podido cargar el lenguaje por defecto";

            }//catch1-2

        }//if1

        if (errormsg == null || errormsg.trim().equals("") == true) {//if1

            try {//try1

                urlresource = new URL(appletappresource.getCodeBase(), mainconfigfilepath);
                processconfig = new ProcessConfigFile(urlresource, appletappresource);
                mainconfig = processconfig.loadMainConfig();
                //currentlanguage2 = new Language(appletappresource.getCodeBase(), new URL(appletappresource.getDocumentbase(),mainconfig.getAppsfolder() + "/"));
                //currentlanguage=currentlanguage2;
                //currentlanguage2=null;


                currentlanguage = new Language(appletappresource.getCodeBase(), new URL(appletappresource.getDocumentbase(),mainconfig.getAppsfolder() + "/"));
                this.userconfig=mainconfig.getUserConfig();
                if (this.userconfig.getProperty("language")!=null && this.userconfig.getProperty("language").trim().equals("")==false) {


                    currentlanguage.setCurrentlanguage(new Locale(this.userconfig.getProperty("language").trim()));
                    integratorlanguage2=currentlanguage.loadItegratorLanguage();
                    integratorlanguage=integratorlanguage2;
                    integratorlanguage2=null;

                }

                if (mainconfig.getPreloader() != null) {//if2

                    mainconfig.getPreloader().initintegrator(bang);


                }//if2


            }//try1
            catch (MalformedURLException e) {//catch1-1

                errormsg = integratorlanguage.getProperty("mainconfigfilenovalid");


            }//catch1-1
            catch (ConfigFileNotValidException e) {//catch1-2

                errormsg = integratorlanguage.getProperty("mainconfigfilenovalid");


            }//catch1-2

            catch (PreLoadException e) {//catch1-3

                errormsg = integratorlanguage.getProperty("loadappserror");


            }//catch1-3

            catch (IOException e) {//catch1-4

                errormsg = integratorlanguage.getProperty("ioerror");


            }//catch1-4

            catch (ValueNoValidException e) {//catch1-5


                errormsg = integratorlanguage.getProperty("loaddefaultlanguageerror");

            }//catch1-5


            catch (LoadingLanguageException e) {//catch1-6


                errormsg = integratorlanguage.getProperty("loaddefaultlanguageerror");

            }//catch1-6



        }//if1





        if (errormsg == null || errormsg.trim().equals("") == true) {//if1

            try {//try1

                urlresource = new URL(appletappresource.getDocumentbase(), mainconfig.getAppsfolder() + "/userapps.xml");
                processconfig.setConfigfile(urlresource);
                integratorapsscontext=processconfig.loadUserAppConfig(mainconfig,bang,this.userconfig);


            }//try1
            catch (MalformedURLException e) {//catch1-1

                errormsg = integratorlanguage.getProperty("userappsconfigfilenovalid");


            }//catch1-1
            catch (ConfigFileNotValidException e) {//catch1-2

                errormsg = integratorlanguage.getProperty("userappsconfigfilenovalid");


            }//catch1-2

            catch (DBDriverLoadException e) {//catch1-3

                errormsg = integratorlanguage.getProperty("loaddbdrivererror");


            }//catch1-3


            catch (DBConnectException e) {//catch1-4

                errormsg = integratorlanguage.getProperty("databaseconnectionserror");


            }//catch1-4


            catch (IOException e) {//catch1-4

                errormsg = integratorlanguage.getProperty("ioerror");


            }//catch1-4

            catch (LoadAppException e) {//catch1-5

                errormsg = integratorlanguage.getProperty("loadapperror");


            }//catch1-5

        }//if1


        if (errormsg == null || errormsg.trim().equals("") == true) {//if1


            this.integratorapps = new IntegratorApp[2];
            this.integratorapps[0] = new EsmeraldaConfig();
            this.integratorapps[0].init();
            this.integratorapps[0].translate(integratorlanguage);

            this.integratorapps[1] = new EsmeraldaLanguage();
            ((EsmeraldaLanguage) this.integratorapps[1]).setSystemApps(this.integratorapps);
            ((EsmeraldaLanguage) this.integratorapps[1]).setCurrentLanguage(this.currentlanguage);
            ((EsmeraldaLanguage) this.integratorapps[1]).setIntegratorWindow(this);
            this.integratorapps[1].init();
            this.integratorapps[1].translate(integratorlanguage);


        }



        if (errormsg == null || errormsg.trim().equals("") == true) {//if1


            integratorapsscontext = (IntegratorAppsContext) IntegratorAppsContext.getIntegratorAppsContext();
            appconfig = integratorapsscontext.getAppsConfigs();
            i = 0;
            appslanguages = new ArrayList<Properties>();
            while (i < integratorapsscontext.getApps().length && errormsg.trim().equals("") == true) {

                integratorapsscontext.getApps()[i].init();
                try {
                    appslanguages.add(i, currentlanguage.loadAppLanguage(appconfig[i].getAppname()));
                    integratorapsscontext.getApps()[i].translate(appslanguages.get(i));
                } catch (Exception e) {
                    errormsg = integratorlanguage.getProperty("loadlanguageerror");
                }
                i++;
            }



        }






        if (errormsg == null || errormsg.trim().equals("") == true) {//if1




            this.drawGUI(this, startimage, stopimage, integratorlanguage, appslanguages);
            ((EsmeraldaLanguage) this.integratorapps[1]).setAppbutton(this.appbuttons);
            this.setTitle(windowtitle);
            this.addWindowListener(new IntegratorWindowEvent(this));
            //setSize(800, 600);

            try {//try1

                this.setIconImage(appletappresource.getImage(new URL(appletappresource.getCodeBase(),"icon.jpg")));


            }//try
            catch(Exception e) {//catch1-1



            }//catch1-11


            pack();
            setVisible(true);


        }//if1
        else {//else1


            JOptionPane.showMessageDialog(this,  errormsg, windowtitle, JOptionPane.ERROR_MESSAGE);
            System.exit(1);



        }//else1










    }//constructor


    ////////////
    //Métodos//
    //////////




    public final void translateGUI() {

        Properties languageintegrator;
        try {
            languageintegrator = this.currentlanguage.loadItegratorLanguage();
            this.setTitle(languageintegrator.getProperty("mainwindowtitle"));
        }
        catch (Exception e) {

            JOptionPane.showMessageDialog(this,  "", this.getTitle(), JOptionPane.ERROR_MESSAGE);
            System.exit(1);

        }
    }


    private final void drawGUI(JFrame mainwindow,Image startimage,Image stopimage, Properties integratorlanguage ,ArrayList<Properties> appslanguages) {

        IntegratorAppsContext integratorcontext;
        IntegratorApp[] userapps;
        Image appstartimage;
        Image appstopimage;
        IntegratorAppsEvents appsevents;
        int rows;
        int count;



        integratorcontext=(IntegratorAppsContext) IntegratorAppsContext.getIntegratorAppsContext();
        userapps=integratorcontext.getApps();
        rows=((this.integratorapps.length + userapps.length)/2) + ((integratorapps.length + userapps.length)%2);
        this.appbuttons=new JButton[integratorapps.length + userapps.length];
        count=0;


        this.appbuttons[0]=new JButton(new ImageIcon(integratorapps[0].getStopImage()));
        this.appbuttons[0].setToolTipText(integratorlanguage.getProperty("integratorconfigapp", ""));
        appsevents=new IntegratorAppsEvents(integratorapps[0],this.appbuttons[0],integratorapps[0].getStartImage(),integratorapps[0].getStopImage());
        integratorapps[0].addWindowListener(appsevents);
        this.appbuttons[0].addActionListener(appsevents);
        this.appbuttons[1]=new JButton(new ImageIcon(integratorapps[1].getStopImage()));
        this.appbuttons[1].setToolTipText(integratorlanguage.getProperty("integratorlanguageselecteapp", ""));
        appsevents=new IntegratorAppsEvents(integratorapps[1],this.appbuttons[1],integratorapps[1].getStartImage(),integratorapps[1].getStopImage());
        integratorapps[1].addWindowListener(appsevents);
        this.appbuttons[1].addActionListener(appsevents);


        count=2;

        for (int i=0;i<userapps.length;i++) {//for



            if (userapps[i].getStartImage()!=null) {

                appstartimage=userapps[i].getStartImage();
            }
            else {

                appstartimage=startimage;

            }
            if (userapps[i].getStopImage()!=null) {

                appstopimage=userapps[i].getStopImage();


            }
            else {

                appstopimage=stopimage;

            }

            this.appbuttons[count]=new JButton(new ImageIcon(appstopimage));
            this.appbuttons[count].setToolTipText(appslanguages.get(i).getProperty("appname", ""));
            appsevents=new IntegratorAppsEvents(userapps[i],this.appbuttons[count],appstartimage,appstopimage);
            userapps[i].addWindowListener(appsevents);
            this.appbuttons[count].addActionListener(appsevents);



            count++;


        }//for





        mainwindow.getContentPane().setLayout(new GridLayout(rows,2,2,2));

        for (int i=0;i<appbuttons.length;i++) {

            mainwindow.getContentPane().add(this.appbuttons[i]);

        }









    }

    ////////////////////
    //Métodos Paquete//
    //////////////////

    final void destroy() {//destroy

        IntegratorAppsContext integratorappscontext;
        integratorappscontext=(IntegratorAppsContext)IntegratorAppsContext.getIntegratorAppsContext();

        for (int i=0;i<integratorappscontext.getApps().length;i++) {

            integratorappscontext.getApps()[i].stop();
            integratorappscontext.getApps()[i].destroy();


        }




        for (int i=0;i<this.integratorapps.length;i++) {

            this.integratorapps[i].stop();
            this.integratorapps[i].destroy();


        }



        for (int i=0;i<integratorappscontext.getDBConnections().length;i++) {

            integratorappscontext.getDBConnections()[i].close();

        }

        try {
            this.userconfig.store();
        }
        catch(IOException e) {


        }
        System.exit(0);



    }//destroy


}//class
