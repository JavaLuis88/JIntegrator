package esmeralda.projects.JIntegrator.beans;


import esmeralda.projects.JIntegrator.apps.PreLoader;
import esmeralda.projects.JIntegrator.business.IntegratorClassLoader;
import esmeralda.projects.JIntegrator.business.UserConfig;

import java.io.Serializable;


public final class MainConfig implements Serializable {//class


    private IntegratorClassLoader integratorclassloader;
    private String appsfolder;
    private PreLoader preloader;
    private UserConfig userconfig;



    ////////////////
    //Constructor//
    //////////////


    public MainConfig() {//constructor

        this.integratorclassloader=null;
        this.appsfolder=null;
        this.preloader=null;
        this.userconfig=null;

    }//constructor



    public MainConfig(IntegratorClassLoader classloader,String appsfolder, PreLoader preloader,UserConfig userconfig) {//constructor

        this.integratorclassloader=integratorclassloader;
        this.appsfolder=appsfolder;
        this.preloader=preloader;
        this.userconfig=userconfig;

    }//constructor

    ////////////
    //Métodos//
    //////////



    public IntegratorClassLoader getIntegratorclassloader() {//getIntegratorclassloader
        return this.integratorclassloader;

    }//getIntegratorclassloader

    public void setIntegratorclassloader(IntegratorClassLoader integratorclassloader) {//setIntegratorclassloader
        this.integratorclassloader =integratorclassloader;
    }//setIntegratorclassloader



    public String getAppsfolder() {//getAppsfolder
        return this.appsfolder;
    }//getAppsfolder

    public void setAppsfolder(String appsfolder) {//setAppsfolder
        this.appsfolder = appsfolder;
    }//setAppsfolder

    public PreLoader getPreloader() {//getPreloader
        return this.preloader;
    }//getPreloader

    public void setPreloader(PreLoader preloader) {//setPreloader
        this.preloader = preloader;
    }//setPreloader


    public UserConfig getUserConfig() {//getUserConfig
        return this.userconfig;
    }//getUserConfig

    public void setUserConfig(UserConfig userconfig) {//setUserConfig
        this.userconfig = userconfig;
    }//setUserConfig



}//class
