package esmeralda.projects.JIntegrator.apps;

import esmeralda.projects.JIntegrator.business.DBConnection;
import esmeralda.projects.JIntegrator.beans.AppConfig;
import esmeralda.projects.JIntegrator.business.UserConfig;
import esmeralda.projects.JIntegrator.exceptions.LoadingLanguageException;

import java.applet.AudioClip;
import java.awt.*;
import java.net.URL;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Locale;

public interface AppsContext {

    public abstract Image getImage(URL url);
    public abstract Image getImage(URL url,String name);
    public abstract AudioClip getAudioClip(URL url);
    public abstract AudioClip getAudioClip(URL url,String name);
    public abstract void play (URL url);
    public abstract void play(URL url,String name);
    public abstract IntegratorApp[] getApps();
    public abstract IntegratorApp getAppByName(String appname);
    public abstract AppConfig[] getAppsConfigs();
    public abstract AppConfig getAppConfigByName(String appname);
    public abstract DBConnection[] getDBConnections();
    public abstract DBConnection getDBConnectionByName(String dbconecctionname);
    public abstract Hashtable<String, Object> getBang();
    public abstract UserConfig getUserConfig();

}
