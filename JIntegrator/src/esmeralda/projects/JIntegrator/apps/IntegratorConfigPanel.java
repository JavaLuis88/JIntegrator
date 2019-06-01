package esmeralda.projects.JIntegrator.apps;
import esmeralda.projects.JIntegrator.exceptions.OperationNotWorkException;
import java.awt.LayoutManager;
import javax.swing.*;


public abstract class IntegratorConfigPanel  extends JPanel {

    public IntegratorConfigPanel() {

        super();

    }



    public IntegratorConfigPanel(boolean isDoubleBuffered) {

        super(isDoubleBuffered);
    }

    public IntegratorConfigPanel(LayoutManager layout) {

        super(layout);

    }

    public IntegratorConfigPanel(LayoutManager layout, boolean isDoubleBuffered) {

        super(layout,isDoubleBuffered);

    }



    public  abstract void save() throws OperationNotWorkException;
    public  abstract void cancel() throws OperationNotWorkException;


}
