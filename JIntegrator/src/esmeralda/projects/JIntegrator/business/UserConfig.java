package esmeralda.projects.JIntegrator.business;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public final class UserConfig extends Properties {

    private File configfile;


    public UserConfig() {

        super();


    }



    public UserConfig(Properties defaults) {

        super(defaults);
        this.configfile=configfile;


    }



    public UserConfig(File configfile) {

        super();
        this.configfile=configfile;


    }


    public UserConfig(File configfile,Properties defaults) {

        super(defaults);
        this.configfile=configfile;


    }

    public void load() throws IOException {

        if (this.configfile!=null && this.configfile.exists()==true && this.configfile.isFile()==true) {

            this.load(new FileReader(this.configfile));


        }




    }


    public void store() throws IOException {



        if (this.configfile!=null) {

            this.store(new FileWriter(this.configfile),"");


        }




    }



}
