package esmeralda.projects.JIntegrator.business;

import esmeralda.projects.JIntegrator.exceptions.LoadingLanguageException;
import esmeralda.projects.JIntegrator.exceptions.ValueNoValidException;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;


public final class Language {//class

    private URL apppath;
    private URL userappsfolder;
    private Locale currentlanguage;


    ////////////////
    //Constructor//
    //////////////


    public Language(URL apppath, URL userappsfolder, Locale currentlanguage) throws ValueNoValidException {//constructor


        Properties integrator;
        Properties language;

        integrator = null;
        language = null;

        if (apppath == null) {//if1

            throw new ValueNoValidException();

        }//if1
        else if (userappsfolder == null) {//elseif1-1
            throw new ValueNoValidException();


        }//elseif1-1
        else if (currentlanguage == null) {//elseif1-2

            throw new ValueNoValidException();


        }//elseif1-2


        else {//else1

            this.apppath = apppath;
            this.userappsfolder = userappsfolder;
            this.currentlanguage = currentlanguage;

        }//else1

    }//constructor


    public Language(URL apppath, URL userappsfolder) throws ValueNoValidException, LoadingLanguageException {//constructor


        this(apppath, userappsfolder, Locale.getDefault());

    }//constructor


    ////////////
    //Métodos//
    //////////


    public void setCurrentlanguage(Locale currentlanguage) throws ValueNoValidException {//setCurrentlanguage


        if (currentlanguage != null) {//if1

            this.currentlanguage = currentlanguage;

        }//if1
        else {//else1

            throw new ValueNoValidException();

        }//else1


    }//setCurrentlanguage


    public Locale getCurrentlanguage() {//getCurrentlanguage
        return this.currentlanguage;
    }//getCurrentlanguage


    public Properties loadItegratorLanguage() throws LoadingLanguageException {//loadItegratorLanguage


        Properties retval;
        retval = new Properties();


        try {//try1

            retval.load(new InputStreamReader((new URL(this.apppath, "language/language.properties").openStream()),"UTF-8"));

        }//try1
        catch (MalformedURLException e) {//catch1-1
            new LoadingLanguageException();

        }//catch1-1
        catch (IOException e) {//catch1-2
            new LoadingLanguageException();


        }//catch1-2


        try {//try1

            retval.load(new InputStreamReader((new URL(this.apppath, "language/language." + currentlanguage.getLanguage() + ".properties").openStream()),"UTF-8"));

        }//try1
        catch (MalformedURLException e) {//catch1-1


        }//catch1-1
        catch (IOException e) {//catch1-2


        }//catch1-2


        return retval;


    }//loadItegratorLanguage


    public Properties loadAppLanguage(String appname) throws ValueNoValidException, LoadingLanguageException {//loadAppLanguage


        Pattern pat;
        Properties retval;

        retval = new Properties();


        pat = Pattern.compile("[\\w]+");
        if (appname != null && appname.trim().equals("") != true && pat.matcher(appname).matches() == true) {//if


            try {//try1

                retval.load(new InputStreamReader((new URL(this.userappsfolder, "apps/" + appname + "/language/language.properties").openStream()),"UTF-8"));

            }//try1
            catch (MalformedURLException e) {//catch1-1
                new LoadingLanguageException();

            }//catch1-1
            catch (IOException e) {//catch1-2
                new LoadingLanguageException();


            }//catch1-2


            try {//try1

                retval.load(new InputStreamReader(new URL(this.userappsfolder, "apps/" + appname + "/language/language." + currentlanguage.getLanguage() + ".properties").openStream(),"UTF-8"));

            }//try1
            catch (MalformedURLException e) {//catch1-1


            }//catch1-1
            catch (IOException e) {//catch1-2


            }//catch1-2

        }//if1
        else {//else1

            throw new ValueNoValidException();

        }//else1
        return retval;


    }//loadAppLanguage

}//class