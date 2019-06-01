package esmeralda.projects.JIntegrator.exceptions;

public final class DBDriverLoadException extends Exception  {//class


    ////////////////
    //Constructor//
    //////////////


    public DBDriverLoadException() {//constructor

        super("Database driver can not be load");

    }//constructor



    public DBDriverLoadException(String msg) {//constructor

        super(msg);

    }//constructor


}//class
