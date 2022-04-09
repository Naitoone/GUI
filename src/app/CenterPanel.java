/*package app;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CenterPanel extends JPanel implements ActionListener {

    private TitledBorder titledBorder;
    private JLabel jLabel,infoLabel,statusLabel;
    private JTextField jTextField,statusTextField;
    private JPanel northPanel, southPanel,northNorthPanel,createPanel,btnPanel,calPanel,infoPanel;
    private JTextArea jTextArea, jTextArea1, jTextArea2, resultTextArea,calTextArea;
    private JSlider jSliderw, jSliderk;
    private JComboBox jComboBox;
    private JButton calBtn,btnDodaj,btnSave,btnReset;
    private static JTextField infoTextField;

    Font resultFont = new Font("", Font.BOLD, 15);

    JTable jTable;

    Object[] columns ={1,2,3,4,5};
    Object[][] data ={
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}

    };

    String[] choseoperation = {"Suma","Średnia","Max","Min"}; ;


    public CenterPanel() {
        this.setLayout(new GridLayout(2, 1, 10, 10));

        northPanel = createNorthPanel();
        southPanel = createSouthPanel();

        this.add(northPanel);
        this.add(southPanel);
    }

    public JPanel createNorthPanel() {

        northNorthPanel = createNorthNorthPanel();
        createPanel = createCenterNorthPanel();

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        jPanel.add(northNorthPanel,BorderLayout.NORTH);
        jPanel.add(createPanel,BorderLayout.CENTER);


        return jPanel;
    }

    public JPanel createSouthPanel() {

        calPanel = createCalPanel();
        infoPanel = createInfoPanel();

        resultTextArea = new JTextArea();

        JPanel jPanel = new JPanel();
        JPanel jPanelResult = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanelResult.setLayout(new BorderLayout(1,5));

        titledBorder = BorderFactory.createTitledBorder("Uzyskany rezultat");
        titledBorder.setTitleJustification(TitledBorder.CENTER);

        jPanelResult.setBorder(titledBorder);

        resultTextArea.setEnabled(false);
        resultTextArea.setDisabledTextColor(Color.black);
        resultTextArea.setFont(resultFont);
        resultTextArea.setLineWrap(true);

        resultTextArea.append("");

        jPanel.add(calPanel,BorderLayout.NORTH);
        jPanelResult.add(new JScrollPane(resultTextArea));
        jPanel.add(jPanelResult, BorderLayout.CENTER);
        jPanel.add(infoPanel, BorderLayout.SOUTH);

        return jPanel;
    }

    public JPanel createNorthNorthPanel() {

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        jSliderk = new JSlider(1, 5, 1);
        jSliderw = new JSlider(1, 5, 1);

        jSliderw.setMajorTickSpacing(0);
        jSliderk.setMajorTickSpacing(0);
        jSliderw.setMajorTickSpacing(1);
        jSliderk.setMajorTickSpacing(1);

        jSliderw.setPaintTicks(true);
        jSliderk.setPaintTicks(true);
        jSliderk.setPaintLabels(true);
        jSliderw.setPaintLabels(true);

        jLabel = new JLabel();
        jTextField = new JTextField(10);
        jTextArea = new JTextArea("Wprowadź liczbę");
        jTextArea1 = new JTextArea("Numer Wiersza");
        jTextArea2 = new JTextArea("Numer kolumny");

        jTextArea.setLayout(null);
        jTextArea1.setLayout(null);

        jTextArea.setOpaque(false);
        jTextArea1.setOpaque(false);
        jTextArea2.setOpaque(false);

        jTextArea.setFont(jTextArea.getFont().deriveFont(14f));
        jTextArea1.setFont(jTextArea.getFont().deriveFont(14f));
        jTextArea2.setFont(jTextArea.getFont().deriveFont(14f));

        jPanel.add(jLabel);
        jPanel.add(jTextArea);

        jPanel.add(jTextField);
        jPanel.add(jTextArea1);
        jPanel.add(jSliderw);
        jPanel.add(jTextArea2);
        jPanel.add(jSliderk);

        return jPanel;
    }

    public JPanel createCenterNorthPanel() {

        btnPanel = createBtnPanel();

        JPanel jPanel = new JPanel();
        JPanel tablePanel = new JPanel();
        JPanel panelIntBtnPanel = new JPanel();

        tablePanel.setLayout(new CardLayout(8,8));
        jPanel.setLayout(new BorderLayout(20,10));
        panelIntBtnPanel.setLayout(new CardLayout(40,40));

        jTable = new JTable(data, columns);
        jTable.setEnabled(false);
        jTable.setRowHeight(31);

        JScrollPane jScrollPane = new JScrollPane(jTable);

        panelIntBtnPanel.add(btnPanel);
        tablePanel.add(jScrollPane);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());

        jPanel.add(tablePanel,BorderLayout.CENTER);
        jPanel.add(panelIntBtnPanel,BorderLayout.EAST);

        return jPanel;
    }

    public JPanel createBtnPanel() {

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));

        btnDodaj = new JButton("Dodaj");
        btnReset = new JButton("Zerowanie");
        btnSave = new JButton("Zapisz");

        btnDodaj.add(Box.createRigidArea(new Dimension(100, 20)));
        btnReset.add(Box.createRigidArea(new Dimension(100, 20)));
        btnSave.add(Box.createRigidArea(new Dimension(100, 20)));


        jPanel.add(btnDodaj);
        jPanel.add(Box.createVerticalStrut(10));

        jPanel.add(btnReset);
        jPanel.add(Box.createVerticalStrut(10));

        jPanel.add(btnSave);
        jPanel.add(Box.createVerticalStrut(10));

        btnDodaj.addActionListener(this::sumActionListner);
        btnReset.addActionListener(this::resetActionListner);
        btnSave.addActionListener(this::saveActionListner);

        return jPanel;
    }

    public JPanel createCalPanel(){

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        calBtn = new JButton("Oblicz");

        calTextArea = new JTextArea("Obliczenia");

        calTextArea.setOpaque(false);

        jComboBox = new JComboBox(choseoperation);

        jComboBox.setPreferredSize(new Dimension(200,25));
        calBtn.setPreferredSize(new Dimension(100,25));

        jPanel.add(calTextArea);
        jPanel.add(jComboBox);
        jPanel.add(calBtn);

        calBtn.addActionListener(this::calActioListner);

        return jPanel;
    }

    public JPanel createInfoPanel() {

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        infoLabel = new JLabel("Info");
        infoTextField = new JTextField();
        statusLabel = new JLabel("Status");
        statusTextField = new JTextField("ON");

        infoTextField.setEnabled(false);
        statusTextField.setEnabled(false);
        infoTextField.setDisabledTextColor(Color.black);
        statusTextField.setDisabledTextColor(Color.black);

        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(infoLabel);
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(infoTextField);
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(statusLabel);
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(statusTextField);
        jPanel.add(Box.createHorizontalStrut(10));

        jPanel.setPreferredSize(new Dimension(1,25));

        return jPanel;
    }

    public static int objectToInt(Object object) {
        int x = (Integer) object;
        return x;
    }

    public int sumTable() {

        int suma=0;

        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[i].length; j++) {
                suma = suma+objectToInt(jTable.getValueAt(i,j));
            }

        return suma;
    }

    public void zeroSetTable() {

        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[i].length; j++) {
                jTable.setValueAt(0,i,j);
            }
    }

    public int minTableValue() {
        int wynik=0;

        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[i].length; j++) {
                if(objectToInt(jTable.getValueAt(i,j))<=wynik);
                wynik = objectToInt(jTable.getValueAt(i, j));
            }

        return wynik;
    }

    public int maxTableValue() {

        int wynik = 0;

        try
        {
            wynik = objectToInt(jTable.getValueAt(0, 0));

            for(int i=0; i<5; i++) {
                for(int j=0; j<5;j++) {
                    if( objectToInt(jTable.getValueAt(i, j)) >= wynik ) {
                        wynik = objectToInt(jTable.getValueAt(i, j));
                    }
                }
            }
        }
        catch(Exception e)
        {
            return wynik;
        }

        return wynik;
    }

    private int getSliderk() {return jSliderk.getValue()-1;}

    private int getSliderw() {return jSliderw.getValue()-1;}

    public void actionPerformed(ActionEvent e) { }

    public void sumActionListner(ActionEvent e) {



        try {
            int i = Integer.parseInt(jTextField.getText());

            int k = getSliderk();
            int w = getSliderw();

            jTable.setValueAt(i,w,k);

        } catch (Exception txtError) {
            infoTextField.setText("ERROR...Wprowadź liczbę");
            Timer t = new Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    infoTextField.setText(null);
                }
            });
            t.setRepeats(false);
            t.start();
        }

    }

    public void resetActionListner(ActionEvent e) {zeroSetTable();}

    public void saveActionListner(ActionEvent e) {}

    public void calActioListner(ActionEvent event) {

        switch (jComboBox.getSelectedIndex()) {
            case 0:

                resultTextArea.setText("Suma wynosi: "+Integer.toString(sumTable()));
                break;

            case 1:

                double db = (sumTable()/25.0);
                String str = db+"" ;
                resultTextArea.setText("Średnia wynosi: "+str);
                break;

            case 2:

                resultTextArea.setText("Wartość maksymalna wynosi: "+Integer.toString(maxTableValue()));
                break;

            case 3:

                resultTextArea.setText("Wartość minimalna wynosi: "+Integer.toString(minTableValue()));
                break;
        }
    }

}
*/