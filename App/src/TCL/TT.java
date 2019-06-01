package TCL;
import esmeralda.projects.JIntegrator.apps.IntegratorApp;
import esmeralda.projects.JIntegrator.apps.IntegratorConfigPanel;

import java.awt.*;
import javax.swing.JLabel;
import java.util.Properties;

public class TT extends IntegratorApp {

    private Image startimage;
    private Image stopimage;
    private JLabel label;


    public TT() {


        System.out.println("Constructor TT");

    }


    public void  init() {

        System.out.println("Metodo init de  TT");

        this.startimage=this.getImage(this.getClass().getResource("/resources/images/starttcl.jpg"));
        this.stopimage=this.getImage(this.getClass().getResource("/resources/images/stoptcl.jpg"));
        this.createGUI();



    }


    public void  start() {


        System.out.println("Metodo start de  TT");
        this.setVisible(true);

    }
    public void  stop() {


        System.out.println("Metodo stop de  TT");


    }
    public void  destroy() {

        System.out.println("Metodo destroy de  TT");


    }

    public void translate(Properties language) {


        System.out.println("Método translate de TT");


    }


    public Image getStartImage() {//getStartImage


        return this.startimage;

    }//getStartImage

    public Image getStopImage() {//getStopImage

        return this.stopimage;


    }//getStopImage

    private void createGUI() {

        this.getContentPane().setLayout(new GridLayout(1,1));
        this.label=new JLabel("propiedad a=aa22\npropiedad b=hhh2");
        this.getContentPane().add(this.label);

    }


    public IntegratorConfigPanel getConfigPanel() {

        return new ConfigPanel();

    }

}
