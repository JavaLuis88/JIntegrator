package esmeralda.projects.JIntegrator.business;

import esmeralda.projects.JIntegrator.exceptions.DBConnectException;
import esmeralda.projects.JIntegrator.exceptions.DBDriverLoadException;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public final class DBConnection implements AutoCloseable {//class

    private Connection connection;
    private String dbdriver;
    private String dburl;
    private String user;
    private String password;



    ////////////////
    //Constructor//
    //////////////


    public DBConnection(String dbdriver, String dburl) throws DBDriverLoadException, DBConnectException {//constructor

        this.dbdriver = new String(dbdriver);
        this.dburl = new String(dburl);
        this.user = "";
        this.password = "";

        this.openDBConnection();


    }//constructor


    public DBConnection(String dbdriver, String dburl, String user, String password) throws DBDriverLoadException, DBConnectException {//constructor


        this.dbdriver = new String(dbdriver);
        this.dburl = new String(dburl);
        this.user = new String(user);
        this.password = new String(password);

        this.openDBConnection();

    }//constructor





    ////////////
    //Métodos//
    //////////

    public Connection getConnection() throws DBDriverLoadException, DBConnectException, SQLException {//getConnection


        if (this.connection == null || this.connection.isClosed() == true) {//if1

            this.openDBConnection();


        }//if1

        return this.connection;
    }//getConnection


    public void startTransaction() throws SQLException {//startTransaction

        this.connection.setAutoCommit(true);

    }//startTransaction


    public void endTransaction() throws SQLException {//endTransaction

        this.connection.setAutoCommit(false);

    }//endTransaction


    public void commit() throws SQLException {//commit

        this.connection.commit();

    }//commit


    public void rollback() throws SQLException {//rollback

        this.connection.rollback();

    }//rollback


    /////////////////////
    //Métodos privados//
    ///////////////////


    private void openDBConnection() throws DBDriverLoadException, DBConnectException {//openDBConnection




        try {//try1

        Class.forName(dbdriver);


        }//try1
        catch (Exception e) {//catch1-1

            throw new DBDriverLoadException();
        }//catch1-1


        if (this.user != null && this.user.trim().equals("") == false && this.password != null && this.password.trim().equals("") == false) {//if1


            try {//try1
               this.connection = DriverManager.getConnection(dburl, user, password);
            }//try1
            catch (Exception e) {//catch1-1

                throw new DBConnectException();
            }//catch1-1
        }//if1
        else {//else1

            try {//try1
                //DriverManager.registerDriver(loaddbdriver);

                this.connection = DriverManager.getConnection(dburl);
            }//try1
            catch (Exception e) {//catch1-1

                throw new DBConnectException();
            }//catch1-1

        }//else1

    }//openDBConnection


    ///////////////
    //Interfaces//
    /////////////


    @Override
    public void close() {//close


        try {//try1


            this.connection.close();

        }//try1
        catch (Exception e) {//catch1-1


        }//catch1-1
        finally {//finally1-1
            this.connection = null;
        }//finally1-1

    }//close
}//class
