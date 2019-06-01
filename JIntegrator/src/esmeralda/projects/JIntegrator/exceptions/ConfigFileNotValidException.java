package esmeralda.projects.JIntegrator.exceptions;

public final class ConfigFileNotValidException extends Exception  {//class


    ////////////////
    //Constructor//
    //////////////


    public ConfigFileNotValidException() {//constructor

        super("Config file is not valid");

    }//constructor



    public ConfigFileNotValidException(String msg) {//constructor

        super(msg);

    }//constructor


}//class
