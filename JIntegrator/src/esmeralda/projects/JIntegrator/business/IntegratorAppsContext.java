package esmeralda.projects.JIntegrator.business;

import esmeralda.libs.AppletAppTools.AppletAppResources;
import esmeralda.projects.JIntegrator.apps.IntegratorApp;
import esmeralda.projects.JIntegrator.apps.AppsContext;
import esmeralda.projects.JIntegrator.beans.AppConfig;
import esmeralda.projects.JIntegrator.beans.DBConfig;
import esmeralda.projects.JIntegrator.exceptions.LoadingLanguageException;

import java.applet.AudioClip;
import java.awt.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.List;
import java.util.Hashtable;
import java.util.Arrays;
import java.util.Iterator;
public final class IntegratorAppsContext implements AppsContext,Serializable {//class

    private Hashtable<String,DBConfig> dbconfigurations;
    private Hashtable<String, DBConnection> dbconnetions;
    private Hashtable<String,AppConfig> appconfiguration;
    private Hashtable<String, IntegratorApp> integratorapp;
    private AppletAppResources appletappresources;
    private UserConfig userconfig;
    private Hashtable<String, Object>bang;
    private Language language;

    private static IntegratorAppsContext integratorcontext;





    ////////////////
    //Constructor//
    //////////////


    private IntegratorAppsContext() {//constructor


        this.dbconfigurations=null;
        this.dbconnetions=null;
        this.appconfiguration=null;
        this.integratorapp=null;
        this.language=null;

    }//constructor



   private IntegratorAppsContext(Hashtable<String,DBConfig> dbconfigurations, Hashtable<String, DBConnection> dbconnetions, Hashtable<String,AppConfig> appconfiguration, Hashtable<String,IntegratorApp> integratorapp,Language language) {//constructor


        this.dbconfigurations=dbconfigurations;
        this.dbconnetions=dbconnetions;
        this.appconfiguration=appconfiguration;
        this.integratorapp=integratorapp;
        this.language=language;

    }//constructor


    ////////////
    //Métodos//
    //////////


    public static AppsContext getIntegratorAppsContext() {


        if (integratorcontext==null) {

            integratorcontext=new IntegratorAppsContext();



        }


        return integratorcontext;

    }



    public Hashtable<String, DBConfig> getDatabaseconfigurations() {
        return dbconfigurations;
    }

    public void setDatabaseconfigurations(Hashtable<String, DBConfig> dbconfigurations) {
        this.dbconfigurations = dbconfigurations;
    }

    public Hashtable<String, DBConnection> getDatabaseconnetions() {
        return dbconnetions;
    }

    public void setDatabaseconnetions(Hashtable<String, DBConnection> dbconnetions) {
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



    public void setAppletappresources(AppletAppResources appletappresources) {

        this.appletappresources=appletappresources;

    }



    public AppletAppResources getAppletappresources() {

        return this.appletappresources;

    }



    @Override
    public Image getImage(URL url) {
        return this.appletappresources.getImage(url);
    }

    @Override
    public Image getImage(URL url, String name) {
        return this.appletappresources.getImage(url,name);
    }

    @Override
    public AudioClip getAudioClip(URL url) {
        return this.appletappresources.getAudioClip(url);
    }

    @Override
    public AudioClip getAudioClip(URL url, String name) {
        return this.appletappresources.getAudioClip(url);
    }

    @Override
    public void play(URL url) {

        this.appletappresources.play(url);
    }

    @Override
    public void play(URL url, String name) {

        this.appletappresources.play(url,name);


    }

    @Override
    public IntegratorApp[] getApps() {


        IntegratorApp[] retval;
        retval=this.integratorapp.values().toArray(new IntegratorApp[0]);
        return retval;

    }




    @Override
    public IntegratorApp getAppByName(String appname) {

        return this.getIntegratorapp().get(appname);

    }




    @Override
    public AppConfig[] getAppsConfigs() {

        AppConfig[] retval;
        retval=this.appconfiguration.values().toArray(new AppConfig[0]);
        return retval;
    }

    @Override
    public AppConfig getAppConfigByName(String appname) {


        return this.appconfiguration.get(appname);

    }



    @Override
    public DBConnection[] getDBConnections() {

        DBConnection[] retval;
        retval=this.dbconnetions.values().toArray(new DBConnection[0]);
        return retval;

    }

    @Override
    public DBConnection getDBConnectionByName(String dbconecctionname) {


        return this.dbconnetions.get(dbconecctionname);

    }

    @Override
    public Hashtable<String, Object> getBang() {
        return this.bang;
    }


    public void setUserConfig(UserConfig userconfig) {
        this.userconfig=userconfig;
    }


    @Override
    public UserConfig getUserConfig() {
        return this.userconfig;
    }


    public void setBang(Hashtable<String, Object> bang) {

        this.bang=bang;

    }


    public void setLanguage(Language language) {

        this.language=language;

    }


    public Language getLanguage() {

        return this.language;

    }








}//class
