package TCL;
import esmeralda.projects.JIntegrator.apps.IntegratorApp;
import esmeralda.projects.JIntegrator.apps.IntegratorConfigPanel;

import java.awt.*;
import java.util.Properties;

public class TK  extends IntegratorApp {

    private Image startimage;
    private Image stopimage;


    public TK() {


        System.out.println("Constructor TK");

    }


    public void  init() {

        System.out.println("Metodo init de  TK");
        this.startimage=this.getImage(this.getClass().getResource("/resources/images/starttk.jpg"));
        this.stopimage=this.getImage(this.getClass().getResource("/resources/images/stoptk.jpg"));


    }


    public void  start() {


        System.out.println("Metodo start de  TK");


    }
    public void  stop() {


        System.out.println("Metodo stop de  TK");


    }
    public void  destroy() {

        System.out.println("Metodo destroy de  TK");


    }


    public void translate(Properties language) {


        System.out.println("Método translate de TK");


    }


    public Image getStartImage() {//getStartImage


        return this.startimage;

    }//getStartImage


    public Image getStopImage() {//getStopImage

        return this.stopimage;


    }//getStopImage



    public IntegratorConfigPanel getConfigPanel() {
        return new ConfigPanel2();
    }



}
