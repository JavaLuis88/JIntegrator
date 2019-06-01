package esmeralda.projects.JIntegrator.beans;
import esmeralda.projects.JIntegrator.apps.AppsContext;
import esmeralda.projects.JIntegrator.business.DBConnection;
import esmeralda.projects.JIntegrator.apps.IntegratorApp;

import java.io.Serializable;
import java.util.Hashtable;

public final class UserAppsConfig implements Serializable {//class

    private Hashtable<String,DBConfig> dbconfigurations;
    private Hashtable<String, DBConnection> dbconnetions;
    private Hashtable<String,AppConfig> appconfiguration;
    private Hashtable<String, IntegratorApp> integratorapp;



    ////////////////
    //Constructor//
    //////////////


    public UserAppsConfig () {//constructor


        this.dbconfigurations=null;
        this.dbconnetions=null;
        this.appconfiguration=null;
        this.integratorapp=null;


    }//constructor



    public UserAppsConfig(Hashtable<String,DBConfig> dbconfigurations,Hashtable<String, DBConnection> dbconnetions,Hashtable<String,AppConfig> appconfiguration,Hashtable<String,IntegratorApp> integratorapp) {//constructor


        this.dbconfigurations=dbconfigurations;
        this.dbconnetions=dbconnetions;
        this.appconfiguration=appconfiguration;
        this.integratorapp=integratorapp;


    }//constructor


    ////////////
    //Métodos//
    //////////


    public Hashtable<String, DBConfig> getDbconfigurations() {
        return dbconfigurations;
    }

    public void setDbconfigurations(Hashtable<String, DBConfig> dbconfigurations) {
        this.dbconfigurations = dbconfigurations;
    }

    public Hashtable<String, DBConnection> getDbconnetions() {
        return dbconnetions;
    }

    public void setDbconnetions(Hashtable<String, DBConnection> dbconnetions) {
        this.dbconnetions = dbconnetions;
    }

    public Hashtable<String, AppConfig> getAppconfiguration() {
        return appconfiguration;
    }

    public void setAppconfiguration(Hashtable<String, AppConfig> appconfiguration) {
        this.appconfiguration = appconfiguration;
    }

    public Hashtable<String,  IntegratorApp> getIntegratorapp() {
        return integratorapp;
    }

    public void setIntegratorapp(Hashtable<String, IntegratorApp> integratorapp) {
        this.integratorapp = integratorapp;
    }



}//class
