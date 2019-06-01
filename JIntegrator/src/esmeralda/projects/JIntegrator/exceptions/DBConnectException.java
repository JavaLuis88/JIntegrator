package esmeralda.projects.JIntegrator.exceptions;

public final class DBConnectException extends Exception  {//class


    ////////////////
    //Constructor//
    //////////////


    public DBConnectException() {//constructor

        super("Database connection can not be establish");

    }//constructor



    public DBConnectException(String msg) {//constructor

        super(msg);

    }//constructor


}//class
