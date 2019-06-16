package View;

import Controller.Controlador;
import Model.Register;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class mainView extends JFrame {

    public static final String direccio = System.getProperty("user.dir") + "/data";
    private static String INPUT = "/input.csv";
    private static String INE = "/INE.xlsx";
    private static String OUTPUT = "/output.txt";
    private String actualPath;

    JPanel pnPanel0;
    JLabel lbLabel0;
    JLabel lbLabel1;
    JLabel lbLabel2;
    JTextField tfText1;
    JTextField tfText2;
    JTextField tfText3;
    JButton btBut2;


    public mainView() {

        ConfigInit();                                               //Funcio configuracio inicial del JFrame

        System.out.println(direccio);
        vista(direccio);

        getContentPane().add(pnPanel0);                             //Afegim tot al jframe
    }


    //Funcions

    private void ConfigInit() {

        setTitle("Registros Fomento VTC");                                     //Pose titol, tamany, posicio...
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

    }

    /*private void Superior() {

        jlMoney = new JLabel("0 continues");                    //Poso 0 continues al moment inicial
        jlMoney.setHorizontalAlignment(JLabel.CENTER);               //centro el label

        JLabel jlStore = new JLabel("Store", SwingConstants.CENTER);        //El mateix amb la store
        jlStore.setHorizontalAlignment(JLabel.CENTER);


        GridBagConstraints gbcSup = new GridBagConstraints();         //Amb les contraints escollim la posicio i tamany de les celes que tindra al afegir al panel

        JPanel jpTop = new JPanel(new GridBagLayout());

        gbcSup.fill = GridBagConstraints.HORIZONTAL;
        gbcSup.gridwidth = 2;
        gbcSup.gridx = 0;
        gbcSup.weightx = 1;

        jpTop.add(jlMoney, gbcSup);

        gbcSup = new GridBagConstraints();
        gbcSup.fill = GridBagConstraints.HORIZONTAL;
        gbcSup.gridwidth = 1;
        gbcSup.gridx = 3;
        gbcSup.weightx = 1;

        jpTop.add(jlStore, gbcSup);                                     //afegim tot a un panel abans dafegirlo a la part superior del jframe

        getContentPane().add(jpTop, BorderLayout.PAGE_START);

    }

    private void CentreLeft() {

        JPanel jpCentreLeft = new JPanel(new BorderLayout());

        ImageIcon foto = new ImageIcon(direccio + "/button.png");       //Converteixo la foto en label per poderla inserir al boto
        jbFoto = new JButton(foto);
        jbFoto.setActionCommand("foto");
        jpCentreLeft.add(jbFoto);

        GridBagConstraints gbcCentreL = new GridBagConstraints();                //Escullo el tamany que ocupara amb gridbag contraints i afegeixo al jpanel del centre

        gbcCentreL.fill = GridBagConstraints.BOTH;
        gbcCentreL.gridwidth = 2;
        gbcCentreL.gridx = 0;
        gbcCentreL.gridy = 0;
        gbcCentreL.weightx = 2;
        gbcCentreL.weighty = 1;

        jpClicker.add(jpCentreLeft, gbcCentreL);

    }

    private void CentreRight(ArrayList<Continua> continues) {

        jpCentreRight = new JPanel();

        jpCentreRight.setLayout(new BoxLayout(jpCentreRight, BoxLayout.Y_AXIS));
        JScrollPane Scroll = new JScrollPane(jpCentreRight, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        for (int i = 0; i < continues.size(); i++) {                                        //Introdueixo totes les continues que he carregat al principi dins del panel preparat
            Continua(continues, i);
        }


        GridBagConstraints gbcCentreR = new GridBagConstraints();                           //Escullo el tamany amb les contraints

        gbcCentreR.fill = GridBagConstraints.BOTH;
        gbcCentreR.gridwidth = 1;
        gbcCentreR.gridx = 3;
        gbcCentreR.gridy = 0;
        gbcCentreR.weightx = 1;
        gbcCentreR.insets = new Insets(5, 0, 0, 10);

        jpClicker.add(Scroll, gbcCentreR);

    }

    private void Continua(ArrayList<Continua> continues, int i) {

        jpContinua = new JPanel();
        jpContinua.setLayout(new BoxLayout(jpContinua, BoxLayout.Y_AXIS));
        jpContinua.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(continues.get(i).getName() + "        (Price: " + continues.get(i).getPrice() + ")"),      //Poso el nom i preu agafats de cada continua
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        JPanel jpInsideCont = new JPanel(new GridLayout());

        for (int j = 0; j < continues.size(); j++) {
            units.add(new JLabel("0 units"));
        }

        jpInsideCont.add(units.get(i));                                                                     //Afegeixo el label de les unitats que tinc

        jpInsideCont.add(new JLabel("x", SwingConstants.CENTER));
        jpInsideCont.add(new JLabel((float) 1000 / (continues.get(i).getPeriod()) + "ACs/seg", SwingConstants.RIGHT));

        jpContinua.add(jpInsideCont);
        Comprador();                                                                                        //Afegeix els botons de les opcions d compra

        jpCentreRight.add(jpContinua);

    }

    private void Comprador() {

        JPanel jpComprador = new JPanel(new GridLayout(1, 3, 4, 10));


        JButton jbBuy1 = new JButton("Buy 1");                              //Creo els botons, desactivats per defecte
        jbBuy1.setEnabled(false);
        aButton1.add(jbBuy1);                                                    //Afegeixo el boto al array de 1, 5 i 10 respectivament
        JButton jbBuy5 = new JButton("Buy 5");
        jbBuy5.setEnabled(false);
        aButton5.add(jbBuy5);
        JButton jbBuy10 = new JButton("Buy 10");
        jbBuy10.setEnabled(false);
        aButton10.add(jbBuy10);


        jpComprador.add(jbBuy1);
        jpComprador.add(jbBuy5);
        jpComprador.add(jbBuy10);

        jpContinua.add(jpComprador);

    }

    public void actDesBotons(int money, ArrayList<Continua> continues) {

        for (int i = 0; i < aButton1.size(); i++) {                             //Miro tots els botons si cal canviar el seu estat
            if (continues.get(i).getPrice() > money) {
                aButton1.get(i).setEnabled(false);
            } else {
                aButton1.get(i).setEnabled(true);
            }
            if (continues.get(i).getPrice() * 5 > money) {                      //Si no puc comprar descativo el bot
                aButton5.get(i).setEnabled(false);
            } else {
                aButton5.get(i).setEnabled(true);                               //si puc el activo
            }
            if (continues.get(i).getPrice() * 10 > money) {
                aButton10.get(i).setEnabled(false);
            } else {
                aButton10.get(i).setEnabled(true);
            }

        }

    }*/

    public void vista(String path) {

        pnPanel0 = new JPanel();
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        pnPanel0.setLayout(gbPanel0);

        lbLabel0 = new JLabel("  Input:");
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(lbLabel0, gbcPanel0);
        pnPanel0.add(lbLabel0);

        lbLabel1 = new JLabel("  INE:");
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 1;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(lbLabel1, gbcPanel0);
        pnPanel0.add(lbLabel1);

        lbLabel2 = new JLabel("  Output:");
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 2;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(lbLabel2, gbcPanel0);
        pnPanel0.add(lbLabel2);

        tfText1 = new JTextField();
        tfText1.setText(path + INPUT);
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(tfText1, gbcPanel0);
        pnPanel0.add(tfText1);

        tfText2 = new JTextField();
        tfText2.setText(path + INE);
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 1;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(tfText2, gbcPanel0);
        pnPanel0.add(tfText2);

        tfText3 = new JTextField();
        tfText3.setText(path + OUTPUT);
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 2;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(tfText3, gbcPanel0);
        pnPanel0.add(tfText3);

        btBut2 = new JButton("START");
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(btBut2, gbcPanel0);
        pnPanel0.add(btBut2);


    }

    public void registraControlador(Controlador controlador) {

        btBut2.addActionListener(controlador);                                  //Afegeixo el listener al boto gros
        btBut2.setActionCommand("START");

    }

    public String getTfText1() {
        return tfText1.getText();
    }

    public String getTfText2() {
        return tfText2.getText();
    }

    public String getTfText3() {
        return tfText3.getText();
    }

    //Getters i Setters


}
