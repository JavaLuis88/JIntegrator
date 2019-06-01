package esmeralda.projects.JIntegrator.apps;
import esmeralda.projects.JIntegrator.business.IntegratorAppsContext;
import esmeralda.projects.JIntegrator.business.IntegratorClassLoader;
import esmeralda.projects.JIntegrator.exceptions.ValueNoValidException;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.Image;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

public abstract class IntegratorApp extends JDialog {//class

    public final static int ISENABLE=0;
    public final static int ISDISBLE=1;
    //public final static int ISRUNNING=2;
    //public final static int ISSTOP=3;
    private int status=0;

    ////////////////
    //Constructor//
    //////////////


    public IntegratorApp() {//IntegratorApp

        super();
        this.status=0;

    }//IntegratorApp

    ////////////
    //Métodos//
    //////////

    public void init() {//init


    }//init


    public void start() {//start


    }//start



    public void stop() {//stop

    }//stop


    public void destroy() {//destroy


    }//destroy


    public void translate(Properties language) {//transtale



    }//transtale



    public final int getStatus() {//getstatus



        return this.status;

    }//getstatus




    protected void setStatus(int status) throws ValueNoValidException {//setstatus

        if (status>=IntegratorApp.ISENABLE && status<=IntegratorApp.ISDISBLE) {//if1

            this.status=status;

        }//if1
        else {//else1

            throw new ValueNoValidException();
        }//else1

    }//setstatus



    public IntegratorConfigPanel getConfigPanel() {//IntegratorConfigPanel


        return null;

    }//IntegratorConfigPanel


    public Image getStartImage() {//getDisableImage


        return null;

    }//getDisableImage


    public Image getStopImage() {//getStopImage


        return null;

    }//getStopImage


    public Image getImage(URL url) {//getImage

        return this.getAppsContext().getImage(url);

    }//getImage


    public Image getImage(URL url,String name) {//getImage

        return this.getAppsContext().getImage(url,name);

    }//getImage


    public AudioClip getAudioClip(URL url) {//getAudioClip

        return this.getAppsContext().getAudioClip(url);

    }//getAudioClip


    public AudioClip getAudioClip(URL url,String name) {//getAudioClip

        return this.getAppsContext().getAudioClip(url,name);

    }//getAudioClip



    public void play (URL url) {//play

        this.getAppsContext().play(url);

    }//play


    public void play(URL url,String name) {//play

        this.getAppsContext().play(url,name);

    }//play

    public final AppsContext getAppsContext() {

        return IntegratorAppsContext.getIntegratorAppsContext();

    }




}//class
