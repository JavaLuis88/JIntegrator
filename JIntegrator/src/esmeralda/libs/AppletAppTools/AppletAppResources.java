package esmeralda.libs.AppletAppTools;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Toolkit;
import java.awt.Image;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Properties;


public final class AppletAppResources {//class

    private Applet applet;
    private Properties params;
    private Toolkit toolkit;
    private URL codebase;
    private URL documentbase;
    private boolean runningapplet;

    ////////////////
    //Constructor//
    //////////////

    public AppletAppResources(Applet applet) {//constructor

        this.applet = applet;
        this.runningapplet = true;

    }//constructor


    public AppletAppResources(File paramsfile, URL codebase, URL documentbase) {//constructor

        toolkit = Toolkit.getDefaultToolkit();
        params = new Properties();
        if (paramsfile != null && paramsfile.exists() == true && paramsfile.isFile() == true) {//if

            try {//try

                this.params.load(new FileInputStream(paramsfile));

            }//try
            catch (IOException e) {//catch


            }///catch

        }//if


        this.runningapplet = false;
        this.codebase = codebase;
        this.documentbase = documentbase;

    }//constructor

    ////////////
    //Métodos//
    //////////

    public Image getImage(URL url) {//getImage

        Image image;

        image = null;

        if (this.runningapplet == true) {//if
            image = this.applet.getImage(url);

        }//if
        else {//else

            image = this.toolkit.getImage(url);

        }//else


        return image;

    }//getImage


    public Image getImage(URL url, String name) {//getImage

        Image image;

        image = null;


        try {//try

            image = this.getImage(new URL(url, name));

        }//try
        catch (MalformedURLException e) {//catch


        }//catch
        return image;

    }//getImage


    public AudioClip getAudioClip(URL url) {//getAudioClip


        AudioClip audioclip;

        audioclip = null;


        if (this.runningapplet == true) {//if


            audioclip = this.applet.getAudioClip(url);

        }//if
        else {//else

            audioclip = Applet.newAudioClip(url);


        }//else

        return audioclip;


    }//getAudioClip


    public AudioClip getAudioClip(URL url, String name) {//getAudioClip


        AudioClip audioclip;

        audioclip = null;


        try {//try

            audioclip = this.getAudioClip(new URL(url, name));

        }//try
        catch (MalformedURLException e) {//catch


        }//catch


        return audioclip;


    }//getAudioClip


    public void play(URL url) {//play

        AudioClip audioclip;

        audioclip = null;

        if (this.runningapplet == true) {//if


            this.applet.play(url);

        }//if
        else {//else

            audioclip = this.getAudioClip(url);
            if (audioclip != null) {//if2

                audioclip.play();

            }//if2

        }//else


    }//play


    public void play(URL url, String name) {//play


        try {//try

            this.play(new URL(url, name));

        }//try
        catch (MalformedURLException e) {//catch


        }//catch


    }//play


    public String getParameters(String name) {//getParameters(

        String data;

        data = null;


        if (this.runningapplet == true) {//if

            data = this.applet.getParameter(name);

        }//if
        else {//else

            data = this.params.getProperty(name);

        }//else


        return data;


    }//getParameters


    public URL getCodeBase() {//getCodeBase


        URL codebase;
        codebase = null;

        if (this.runningapplet == true) {//if

            codebase = this.applet.getCodeBase();


        }//if
        else {//else

            codebase = this.codebase;

        }//else


        return codebase;


    }//getCodeBase


    public URL getDocumentbase() {//getDocumentbase


        URL documentbase;
        documentbase = null;

        if (this.runningapplet == true) {//if

            documentbase = this.applet.getDocumentBase();


        }//if
        else {//else

            documentbase = this.documentbase;

        }//else


        return documentbase;


    }//getDocumentbase


    public boolean isRunningapplet() {//isRunningapplet


        return this.runningapplet;


    }//isRunningapplet


    public String getUserHomeDirectory() {//getUserHomeDirectory

        String directorio;
        directorio = null;

        try {//try
            directorio = System.getProperty("user.home");

        }//try
        catch (Exception e) {//catch


        }//catch

        return directorio;


    }//getUserHomeDirectory


}//class
