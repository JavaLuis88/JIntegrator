package TCL;

import esmeralda.projects.JIntegrator.apps.IntegratorConfigPanel;
import esmeralda.projects.JIntegrator.exceptions.OperationNotWorkException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ConfigPanel2 extends IntegratorConfigPanel {
    private JButton jButton1;
    private JTextField jTextField1;
    private JTextField jTextField2;

    public ConfigPanel2() {
        this.initComponents();
    }

    public void save() throws OperationNotWorkException {
    }

    public void cancel() throws OperationNotWorkException {
    }

    private void initComponents() {
        this.jTextField1 = new JTextField();
        this.jTextField2 = new JTextField();
        this.jButton1 = new JButton();
        this.jTextField1.setText("jTextField1");
        this.jTextField2.setText("jTextField2");
        this.jButton1.setText("jButton1");
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(193, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jTextField2, -2, -1, -2).addComponent(this.jTextField1, -2, -1, -2)).addGap(148, 148, 148)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton1).addGap(41, 41, 41)))));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(34, 34, 34).addComponent(this.jButton1).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jTextField1, -2, -1, -2).addGap(46, 46, 46).addComponent(this.jTextField2, -2, -1, -2).addContainerGap(151, 32767)));
    }
}