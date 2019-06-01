package esmeralda.projects.JIntegrator.beans;

import java.io.Serializable;

public final class AppConfig implements Serializable, Cloneable {//class


    private String appname;
    private float appversion;
    private String appclass;
    //private IntegratorApp integratorapp;
    private boolean setterslock;

    ////////////////
    //Constructor//
    //////////////

    public AppConfig() {//constructor

        this.appname = null;
        this.appversion = 0.0f;
        this.appclass = null;
        //this.integratorapp=null;
        this.setterslock = false;

    }//constructor


    public AppConfig(String appname, float appversion, String appclass) {//constructor

        this.appname = new String(appname);
        this.appversion = appversion;
        this.appclass = new String(appclass);
        //IntegratorApp integratorapp
        //this.integratorapp=integratorapp;
        this.setterslock = false;
    }//constructor


    public AppConfig(String appname, float appversion, String appclass, boolean setterslock) {//constructor

        this.appname = new String(appname);
        this.appversion = appversion;
        this.appclass = new String(appclass);
        //IntegratorApp integratorapp
        //this.integratorapp=integratorapp;
        this.setterslock = false;
    }//constructor


    public String getAppname() {
        return new String(this.appname);
    }

    public void setAppname(String appname) {

        if (this.setterslock == false) {
            this.appname = new String(appname);
        }
    }

    public float getAppversion() {

        return this.appversion;
    }

    public void setAppversion(float appversion) {

        if (this.setterslock == false) {

            this.appversion = appversion;
        }
    }

    public String getAppclass() {

        return new String(this.appclass);
    }

    public void setAppclass(String appclass) {
        if (this.setterslock == false) {

            this.appclass = new String(appclass);
        }
    }


    //IntegratorApp getIntegratorApp() {

    //    return this.integratorapp;
    //}

    //void setIntegratorApp(IntegratorApp integratorapp) {
    //    this.integratorapp = integratorapp;
    //}

    public Object clone() {

        Object obj;
        obj = null;


        try {
            obj = super.clone();
            ((AppConfig) obj).appname = new String(this.appname);
            ((AppConfig) obj).appclass = new String(this.appclass);

        } catch (CloneNotSupportedException e) {


        }

        return obj;
    }


}//class
