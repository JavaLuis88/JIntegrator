package esmeralda.projects.JIntegrator.business;

import esmeralda.libs.AppletAppTools.AppletAppResources;
import esmeralda.projects.JIntegrator.apps.PreLoader;
import esmeralda.projects.JIntegrator.beans.AppConfig;
import esmeralda.projects.JIntegrator.beans.DBConfig;
import esmeralda.projects.JIntegrator.beans.MainConfig;
import esmeralda.projects.JIntegrator.beans.UserAppsConfig;
import esmeralda.projects.JIntegrator.exceptions.ConfigFileNotValidException;
import esmeralda.projects.JIntegrator.exceptions.DBConnectException;
import esmeralda.projects.JIntegrator.exceptions.DBDriverLoadException;
import esmeralda.projects.JIntegrator.exceptions.LoadAppException;
import esmeralda.projects.JIntegrator.apps.IntegratorApp;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Hashtable;
import java.util.regex.Pattern;
import java.util.Iterator;


public final class ProcessConfigFile {//class


    private URL configfile;
    private AppletAppResources appletappresource;

    ////////////////
    //Constructor//
    //////////////


    public ProcessConfigFile() {//constructor

        this.configfile = null;


    }//constructor

    public ProcessConfigFile(URL configfile, AppletAppResources appletappresource) {//constructor

        this.configfile = configfile;
        this.appletappresource = appletappresource;

    }//constructor


    ////////////
    //Métodos//
    //////////

    public URL getConfigfile() {//getConfigfile

        return this.configfile;

    }//getConfigfile

    public void setConfigfile(URL configfile) {//setConfigfile

        this.configfile = configfile;

    }//setConfigfile


    public AppletAppResources getAppletappresource() {//getAppletappresource

        return this.appletappresource;

    }//getAppletappresource

    public void setAppletappresource(AppletAppResources appletappresource) {//setAppletappresource

        this.appletappresource = appletappresource;

    }//setAppletappresource


    public MainConfig loadMainConfig() throws ConfigFileNotValidException, IOException {//loadMainConfig


        DocumentBuilderFactory dbf;
        DocumentBuilder documentBuilder;
        Document document;
        NodeList nodeList;
        NodeList nodeList2;
        Node node;
        Element element;
        String preloaderstring;
        IntegratorClassLoader classloader;
        String appsfolder;
        PreLoader preloader;
        URL urls[];
        URL urlpreloader;
        URL urlappsfolder;
        File appfolderpath;
        Pattern pat;
        MainConfig retval;
        UserConfig userconfig;

        preloaderstring = null;
        classloader = null;
        appsfolder = null;
        preloader = null;
        userconfig=null;
        retval = null;

        try {//try1

            dbf = DocumentBuilderFactory.newInstance();
            documentBuilder = dbf.newDocumentBuilder();

            document = documentBuilder.parse(this.configfile.openStream());
            document.getDocumentElement().normalize();

            nodeList = document.getElementsByTagName("appsfolder");


            if (nodeList.getLength() >= 1) {//if1

                node = nodeList.item(0);
                if (node.getNodeType() == Node.ELEMENT_NODE) {//if2

                    appsfolder = node.getTextContent();

                }//if2
            }//if1


            nodeList = document.getElementsByTagName("preloader");

            if (nodeList.getLength() >= 1) {//if1

                node = nodeList.item(0);
                if (node.getNodeType() == Node.ELEMENT_NODE) {//if2

                    preloaderstring = node.getTextContent();

                }//if2
            }//if1


        }//try1


        catch (IOException e) {//catch1-1

            throw e;

        }//catch1-1


        catch (Exception e) {//catch1-2

            throw new ConfigFileNotValidException();

        }//catch1-2


        pat = Pattern.compile("[\\w]+");

        if (appsfolder != null && appsfolder.trim().equals("") == false && (pat.matcher(appsfolder.trim()).matches() == false || appsfolder.trim().equalsIgnoreCase(Constaints.RESTRINGEDSPACENAME) == true)) {//if1


            throw new ConfigFileNotValidException();


        }//if1

        urlappsfolder = this.getAppletappresource().getDocumentbase();
        if (appsfolder != null && appsfolder.trim().equals("") == false) {//if1


            urlappsfolder = new URL(urlappsfolder, appsfolder.trim() + "/");

            try {//try1
                appfolderpath = new File(urlappsfolder.toURI());
                if (appfolderpath.exists() == false && appfolderpath.mkdirs() == false) {//if2

                    throw new IOException();

                }//if2


                if ((new File(appfolderpath, File.separator + "apps")).exists() == false && (new File(appfolderpath, File.separator + "apps")).mkdirs() == false) {//elseif2-3

                    throw new IOException();

                }//elseif2-3


                if ((new File(appfolderpath, File.separator + "apps")).exists() == true && (new File(appfolderpath, File.separator + "apps")).isDirectory() == false) {//elseif2-4

                    throw new IOException();

                }//elseif2-4


                if ((new File(appfolderpath, File.separator + "userapps.xml")).exists() == false && (new File(appfolderpath, File.separator + "userapps.xml")).createNewFile() == false) {//elseif2-5

                    throw new IOException();

                }//elseif2-5

                userconfig=new UserConfig(new File(appfolderpath,"userconfig.properties"));
                userconfig.load();


            }//try1
            catch (URISyntaxException e) {//catch1-1

                throw new IOException();


            }//catch1-1

        }//if1


        if ((ClassLoader.getSystemClassLoader() instanceof IntegratorClassLoader) == true) {

            classloader = (IntegratorClassLoader) ClassLoader.getSystemClassLoader();

        } else if ((ClassLoader.getSystemClassLoader() instanceof URLClassLoader) == true) {
            urls = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
            classloader = new IntegratorClassLoader(urls, ClassLoader.getSystemClassLoader());
        } else {

            urls = new URL[0];
            classloader = new IntegratorClassLoader(urls, ClassLoader.getSystemClassLoader());

        }


        if (preloaderstring != null && preloaderstring.trim().equals("") == false) {//if1


            if (preloaderstring.trim().toLowerCase().startsWith(Constaints.RESTRINGEDSPACENAME + ".".toLowerCase()) == true) {//if2

                throw new ConfigFileNotValidException();
            }//if


            urlpreloader = this.getAppletappresource().getCodeBase();
            urlpreloader = new URL(urlpreloader, "preloader/preloader.jar");
            classloader.addURL(urlpreloader);
            preloader = this.loadpreloader(classloader, preloaderstring);


            if (preloader == null) {//if2


                throw new ConfigFileNotValidException();


            }//if2


        }//if1




        retval = new MainConfig();
        retval.setIntegratorclassloader(classloader);
        retval.setAppsfolder(appsfolder.trim());
        retval.setPreloader(preloader);
        retval.setUserConfig(userconfig);
        return retval;


    }//loadMainConfig


    public IntegratorAppsContext loadUserAppConfig(MainConfig mainConfig,Hashtable<String, Object> bang,UserConfig userconfig) throws ConfigFileNotValidException, IOException, DBDriverLoadException, DBConnectException, LoadAppException {//loadAppConfig


        IntegratorAppsContext retval;

        retval=(IntegratorAppsContext) IntegratorAppsContext.getIntegratorAppsContext();

        retval.setDatabaseconfigurations(this.loadDataBaseConfigs());
        retval.setAppconfiguration(this.loadAppConfig());
        lodaappsjarfiles(mainConfig.getAppsfolder(), mainConfig.getIntegratorclassloader());
        retval.setDatabaseconnetions(this.loaddbconnections(retval.getDatabaseconfigurations()));
        retval.setIntegratorapp(this.loadapps(retval.getAppconfiguration(),mainConfig.getIntegratorclassloader()));
        retval.setAppletappresources(this.appletappresource);
        retval.setBang(bang);
        retval.setUserConfig(userconfig);
        return retval;

    }//loadAppConfig


    /////////////////////
    //Métodos privados//
    ///////////////////


    private PreLoader loadpreloader(IntegratorClassLoader classloader, String classloaderstring) {//loadpreloader

        PreLoader preloader;
        Object objectclass;
        Class objectclass2;
        objectclass = null;
        preloader = null;

        try {//try


            objectclass2 = classloader.loadClass(classloaderstring);
            objectclass = classloader.loadClass(classloaderstring).newInstance();


            if (objectclass instanceof PreLoader) {//if1

                preloader = (PreLoader) objectclass;


            }//if1


        }//try
        catch (ClassNotFoundException e) {//catch1-1

        }//catch1-1
        catch (IllegalAccessException e) {//catch1-2


        }//catch1-2
        catch (InstantiationException e) {//catch1-3


        }//catch1-3

        return preloader;


    }//loadpreloader


    private Hashtable<String, DBConfig> loadDataBaseConfigs() throws ConfigFileNotValidException, IOException {//loadDataBaseConfigs


        DocumentBuilderFactory dbf;
        DocumentBuilder documentBuilder;
        Document document;
        NodeList nodeList;
        NodeList nodeList2;
        Element el;
        String databasename;
        String databasedriver;
        String databaseurl;
        String databaseuser;
        String databasepassword;
        Node node;
        Hashtable<String, DBConfig> retval;
        DBConfig dbconfig;
        int i;
        boolean continuar;
        Pattern pat;
        pat = Pattern.compile("[\\w]+");


        databasename = "";
        databasedriver = "";
        databaseurl = "";
        databaseuser = "";
        databasepassword = "";

        retval = new Hashtable<String, DBConfig>();


        try {//try1

            dbf = DocumentBuilderFactory.newInstance();
            documentBuilder = dbf.newDocumentBuilder();

            document = documentBuilder.parse(this.configfile.openStream());
            document.getDocumentElement().normalize();

            nodeList = document.getElementsByTagName("databases");


            if (nodeList.getLength() >= 1) {//if1

                node = nodeList.item(0);
                if (node.getNodeType() == Node.ELEMENT_NODE) {//if2

                    el = (Element) node;
                    el.normalize();
                    ;
                    nodeList = el.getElementsByTagName("database");

                    i = 0;
                    continuar = true;
                    while (i < nodeList.getLength() && continuar == true) {//while

                        node = nodeList.item(i);
                        if (node.getNodeType() != Node.ELEMENT_NODE) {//if3

                            continuar = false;

                        }//if3
                        else {//else3

                            el = (Element) node;
                            el.normalize();
                            ;
                            nodeList2 = el.getElementsByTagName("databasename");

                            if (nodeList2.getLength() >= 1 && nodeList2.item(0).getTextContent() != null && nodeList2.item(0).getTextContent().trim().equals("") == false && pat.matcher(nodeList2.item(0).getTextContent().trim()).matches() == true && nodeList2.item(0).getTextContent().trim().toLowerCase().startsWith(Constaints.RESTRINGEDSPACENAME.toLowerCase()) == false) {//if4


                                databasename = nodeList2.item(0).getTextContent().trim();

                            }//if4
                            else {//else4

                                continuar = false;


                            }//else4


                            el = (Element) node;
                            el.normalize();

                            nodeList2 = el.getElementsByTagName("databasedriver");

                            if (nodeList2.getLength() >= 1 && nodeList2.item(0).getTextContent() != null && nodeList2.item(0).getTextContent().trim().equals("") == false && nodeList2.item(0).getTextContent().trim().toLowerCase().startsWith(Constaints.RESTRINGEDSPACENAME + ".".toLowerCase()) == false) {//if4


                                databasedriver = nodeList2.item(0).getTextContent().trim();

                            }//if4
                            else {//else4

                                continuar = false;


                            }//else4

                            el = (Element) node;
                            el.normalize();

                            nodeList2 = el.getElementsByTagName("databaseurl");


                            if (nodeList2.getLength() >= 1 && nodeList2.item(0).getTextContent() != null && nodeList2.item(0).getTextContent().trim().equals("") == false) {//if4


                                databaseurl = nodeList2.item(0).getTextContent().trim();

                            }//if4
                            else {//else4

                                continuar = false;


                            }//else4


                            el = (Element) node;
                            el.normalize();

                            nodeList2 = el.getElementsByTagName("databaseuser");

                            if (nodeList2.getLength() >= 1 && nodeList2.item(0).getTextContent() != null) {//if4


                                databaseuser = nodeList2.item(0).getTextContent().trim();

                            }//if4
                            else {//else4

                                continuar = false;


                            }//else4


                            el = (Element) node;
                            el.normalize();
                            ;
                            nodeList2 = el.getElementsByTagName("databasepassword");

                            if (nodeList2.getLength() >= 1 && nodeList2.item(0).getTextContent() != null) {//if4


                                databasepassword = nodeList2.item(0).getTextContent().trim();

                            }//if4
                            else {//else4

                                continuar = false;


                            }//else4

                            if (continuar == true) {//if4

                                dbconfig = new DBConfig(databasename, databasedriver, databaseurl, databaseuser, databasepassword);
                                retval.put(databasename, dbconfig);
                                i++;

                            }//if4


                        }//else3

                    }//while1

                    if (continuar == false) {//if3

                        throw new ConfigFileNotValidException();

                    }//if3

                }//if2
            }//if1


        }//try1

        catch (IOException e) {//catch1-1

            throw e;

        }//catch1-1

        catch (Exception e) {//catch1-2

            throw new ConfigFileNotValidException();

        }//catch1-2


        return retval;

    }//loadDataBaseConfigs


    private Hashtable<String, AppConfig> loadAppConfig() throws ConfigFileNotValidException, IOException {//loadAppConfig


        DocumentBuilderFactory dbf;
        DocumentBuilder documentBuilder;
        Document document;
        NodeList nodeList;
        NodeList nodeList2;
        Element el;
        String appname;
        float appversion;
        String appclass;
        Node node;
        Hashtable<String, AppConfig> retval;
        AppConfig appconfig;
        int i;
        boolean continuar;
        Pattern pat;
        pat = Pattern.compile("[\\w]+");


        appname = "";
        appversion = 0.0f;
        appclass = "";

        retval = new Hashtable<String, AppConfig>();


        try {//try1

            dbf = DocumentBuilderFactory.newInstance();
            documentBuilder = dbf.newDocumentBuilder();

            document = documentBuilder.parse(this.configfile.openStream());
            document.getDocumentElement().normalize();

            nodeList = document.getElementsByTagName("apps");


            if (nodeList.getLength() >= 1) {//if1

                node = nodeList.item(0);
                if (node.getNodeType() == Node.ELEMENT_NODE) {//if2

                    el = (Element) node;
                    el.normalize();
                    ;
                    nodeList = el.getElementsByTagName("app");

                    i = 0;
                    continuar = true;
                    while (i < nodeList.getLength() && continuar == true) {//while

                        node = nodeList.item(i);
                        if (node.getNodeType() != Node.ELEMENT_NODE) {//if3

                            continuar = false;

                        }//if3
                        else {//else3

                            el = (Element) node;
                            el.normalize();

                            nodeList2 = el.getElementsByTagName("appname");

                            if (nodeList2.getLength() >= 1 && nodeList2.item(0).getTextContent() != null && nodeList2.item(0).getTextContent().trim().equals("") == false && pat.matcher(nodeList2.item(0).getTextContent().trim()).matches() == true && nodeList2.item(0).getTextContent().trim().toLowerCase().startsWith(Constaints.RESTRINGEDSPACENAME.toLowerCase()) == false) {//if4


                                appname = nodeList2.item(0).getTextContent().trim();

                            }//if4
                            else {//else4

                                continuar = false;


                            }//else4


                            el = (Element) node;
                            el.normalize();

                            nodeList2 = el.getElementsByTagName("appversion");

                            if (nodeList2.getLength() >= 1 && nodeList2.item(0).getTextContent() != null && nodeList2.item(0).getTextContent().trim().equals("") == false && getAppVersion(nodeList2.item(0).getTextContent().trim()) > 0) {//if4


                                appversion = getAppVersion(nodeList2.item(0).getTextContent().trim());

                            }//if4
                            else {//else4

                                continuar = false;


                            }//else4


                            el = (Element) node;
                            el.normalize();

                            nodeList2 = el.getElementsByTagName("appclass");

                            if (nodeList2.getLength() >= 1 && nodeList2.item(0).getTextContent() != null && nodeList2.item(0).getTextContent().trim().equals("") == false && nodeList2.item(0).getTextContent().trim().toLowerCase().startsWith(Constaints.RESTRINGEDSPACENAME + ".".toLowerCase()) == false) {//if4

                                appclass = nodeList2.item(0).getTextContent().trim();

                            }//if4
                            else {//else4

                                continuar = false;


                            }//else4


                            if (continuar == true) {//if4

                                appconfig = new AppConfig(appname, appversion, appclass);

                                retval.put(appname, appconfig);
                                i++;

                            }//if4


                        }//else3

                    }//while1

                    if (continuar == false) {//if3

                        throw new ConfigFileNotValidException();

                    }//if3

                }//if2
            }//if1


        }//try1

        catch (IOException e) {//catch1-1

            throw e;

        }//catch1-1

        catch (Exception e) {//catch1-2

            throw new ConfigFileNotValidException();

        }//catch1-2


        return retval;

    }//loadAppConfig


    private float getAppVersion(String version) {//getAppVersion

        float retval;
        retval = 0.0f;

        try {//try1
            retval = Float.parseFloat(version);
        }//try1
        catch (Exception e) {//catch1-1


        }//catch1-1


        return retval;


    }//getAppVersion


    private Hashtable<String, DBConnection> loaddbconnections(Hashtable<String, DBConfig> dbconfig) throws DBDriverLoadException, DBConnectException {//loaddbconnections

        Hashtable<String, DBConnection> retval;
        Iterator<String> iterator;
        DBConnection dbconnection;
        String key;

        retval = new Hashtable<String, DBConnection>();
        iterator = dbconfig.keySet().iterator();
        while (iterator.hasNext()) {//while1
            key = iterator.next();
            dbconnection = new DBConnection(dbconfig.get(key).getDatabasedriver(), dbconfig.get(key).getDatabaseurl(), dbconfig.get(key).getDatabaseuser(), dbconfig.get(key).getDatabasepassword());
            retval.put(key, dbconnection);


        }//while1
        return retval;


    }//loaddbconnections


    private void lodaappsjarfiles(String appsfolder, IntegratorClassLoader classloader) throws IOException {

        URL urlappsfolder;
        File jarfolder;
        File[] jarfiles;


        urlappsfolder = this.getAppletappresource().getDocumentbase();
        try {
            urlappsfolder = new URL(urlappsfolder, appsfolder.trim() + "/");
            jarfolder = new File(urlappsfolder.toURI());
            jarfolder = new File(jarfolder, "apps");

        } catch (MalformedURLException e) {

            throw new IOException();

        } catch (URISyntaxException e) {

            throw new IOException();

        }


        jarfiles = jarfolder.listFiles(new ExtFilterFiles(".jar"));
        try {

            for (int i = 0; i < jarfiles.length; i++) {

                classloader.addURL(new URL("file:///" + jarfiles[i].getAbsolutePath()));
            }
        } catch (MalformedURLException e) {

            throw new IOException();

        }


    }

    private Hashtable<String, IntegratorApp> loadapps(Hashtable<String, AppConfig> appconfig, ClassLoader classloader) throws LoadAppException  {

        Iterator<String> iterator;
        IntegratorApp application;
        String key;
        Hashtable<String, IntegratorApp> retval;

        application=null;
        retval = new Hashtable<String, IntegratorApp>();

        iterator = appconfig.keySet().iterator();
        while (iterator.hasNext()) {//while1
            key = iterator.next();

            try {
                application=(IntegratorApp)(classloader.loadClass(appconfig.get(key).getAppclass()).newInstance());

            }
            catch(Exception e) {
                e.printStackTrace();
                throw new LoadAppException();
            }
            retval.put(key, application);


        }//while1




        return retval;

    }

}//class





