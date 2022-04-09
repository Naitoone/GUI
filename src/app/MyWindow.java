/* package app;

import javax.swing.*;
import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends JFrame implements ActionListener{
    
    private JPanel cPane;

    CenterPanel centerPanel ;
    AboutWindow aboutWindow =null;

    JToolBar toolBar;
    JButton jtbLogin, jtbLogout, jtbPrint, jtbExit, jtbHelp, jtbAbout,jtbMin,jtbMax,jtbSum;

    JMenu fileMenu, editMenu, viewMenu, calMenu, helpMenu;
    JMenuItem loginMI, logoutMI, printMI,exitMI,helpMI,aboutMI;

    Icon iconLogin, iconLogout, iconAbout, iconMin,iconMax,iconSum,iconExit, angry,lol;


    public MyWindow() {

        this.setTitle("Moje Okno");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        //zamkniecie okna
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                String ObjBtn[]={"Tak","Nie"};
                int response = JOptionPane.showOptionDialog(null,"Czy jesteś tego pewien?","",
                        JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE, angry,ObjBtn,ObjBtn[1]);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        //rozmieszczenie okna na srodku ekranu oraz nadanie wielkosci okna
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//pobranie rozdzielczosci pulpitu
        setSize(900,600);
        setLocation((screenSize.width-900)/2,(screenSize.height-600)/2);

        cPane = (JPanel) this.getContentPane();
        cPane.setLayout(new BorderLayout());

        createIcons();
        createMenu();
        createGUI();

    }

    public void createMenu() {

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        fileMenu = new JMenu("Plik");
        editMenu = new JMenu("Edycja");
        viewMenu = new JMenu("Widok");
        calMenu = new JMenu("Obliczenia");
        helpMenu = new JMenu("Pomoc");

        loginMI = new JMenuItem("Login");
        logoutMI = new JMenuItem("Logout");
        printMI = new JMenuItem("Print");
        exitMI = new JMenuItem("Wyjście");
        helpMI = new JMenuItem("Pomoc");
        aboutMI = new JMenuItem("Info");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(calMenu);
        menuBar.add(helpMenu);

        fileMenu.add(loginMI).addActionListener(this);
        fileMenu.add(logoutMI).addActionListener(this);
        fileMenu.addSeparator();
        fileMenu.add(exitMI).addActionListener(this);

        helpMenu.add(helpMI).addActionListener(this);
        helpMenu.add(aboutMI).addActionListener(this);


    }

    public void createToolBar (JToolBar cjtb) {

        cPane.add(cjtb);
        cjtb.setFloatable(false);

        jtbLogin = createJButton("", iconLogin);
        jtbLogout = createJButton("",iconLogout);
        jtbAbout = createJButton("",iconAbout);
        jtbMax = createJButton("", iconMax);
        jtbMin = createJButton("", iconMin);
        jtbSum = createJButton("",iconSum);
        jtbExit = createJButton("", iconExit);

        cjtb.add(jtbLogin);
        cjtb.add(jtbLogout);
        cjtb.add(jtbExit);
        cjtb.add(jtbMax);
        cjtb.add(jtbMin);
        cjtb.add(jtbSum);
        cjtb.add(jtbAbout);


    }

    public JButton createJButton(String nazwa, Icon icon) {

        JButton jb = new JButton(nazwa, icon);
        jb.addActionListener(this);

        return jb;
    }

    public void createIcons() {

        try {
            iconLogin = createIcon("login.png");
            iconLogout = createIcon("logout.png");
            iconAbout = createIcon("info.png");
            iconMax = createIcon("max.jpg");
            iconMin = createIcon("min.jpg");
            iconSum = createIcon("sum.png");
            iconExit = createIcon("exit.png");
            angry = createIcon("angry.png");
            lol = createIcon("lol.png");

        } catch (Exception e) {



        }
    }

    public Icon createIcon(String file) {
        String name = "/Graphics/" + file;
        Icon icon = new ImageIcon(getClass().getResource(name));
        return icon;
    }

    private void createGUI() {

        // Utworzenie paska narzedziowego
        toolBar = new JToolBar();
        createToolBar(toolBar);

        centerPanel = new CenterPanel();

        cPane.add(toolBar, BorderLayout.NORTH);
        cPane.add(centerPanel, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {

        if((e.getSource() == jtbAbout)||(e.getSource()==aboutMI)){
            if(aboutWindow!=null) aboutWindow.setVisible(true);
            else {
                aboutWindow = new AboutWindow();
                aboutWindow.setVisible(true);
            }

        }

        if((e.getSource() == exitMI)||(e.getSource()==jtbExit)) {

            String ObjBtn[]={"Tak","Nie"};
            int response = JOptionPane.showOptionDialog(null,"Czy jesteś tego pewien?","",
                    JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE, null,ObjBtn,ObjBtn[1]);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

    }

    public static void main(String[] args) {
        MyWindow myWindow = new MyWindow();
        myWindow.setVisible(true);


    }

    public void sumaActionListner(ActionListener al) {
        this.jtbSum.addActionListener(al);
        this.centerPanel.sumActionListner((ActionEvent) al);
    }
}
*/