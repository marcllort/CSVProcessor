package View;

import Controller.Controlador;
import Model.CSVReader;
import Model.Register;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class mainView extends JFrame {

    public static final String direccio = System.getProperty("user.dir") + "/data";
    private static String INPUT = "/input.csv";
    private static String INE = "/INE.xlsx";
    private static String OUTPUT = "/output.txt";
    private String actualPath;

    private Register tempreg;
    private CSVReader csv;
    JPanel pnPanel0;
    JLabel lbLabel0;
    JLabel lbLabel1;
    JLabel lbLabel2;
    JTextField tfText1;
    JTextField tfText2;
    JTextField tfText3;
    JButton btBut2;

    JPanel pnPanel02;
    JLabel lbLabel02;
    JLabel lbLabel32;
    JLabel lbLabel42;
    JLabel lbLabel82;
    JTextField tfText02;
    JTextField tfText12;
    JTextField tfText22;
    JTextField tfText32;
    JLabel lbLabel5;
    JLabel lbLabel9;
    JTextField tfText4;
    JTextField tfText5;
    JButton btBut02;

    public mainView() {

        ConfigInit();                                               //Funcio configuracio inicial del JFrame

        csv = new CSVReader("", "", "");

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

    public void vista2() {

        pnPanel02 = new JPanel();
        pnPanel02.setBorder(BorderFactory.createTitledBorder(""));
        GridBagLayout gbPanel02 = new GridBagLayout();
        GridBagConstraints gbcPanel02 = new GridBagConstraints();
        pnPanel02.setLayout(gbPanel02);

        lbLabel02 = new JLabel("  Fecha Contrato:");
        gbcPanel02.gridx = 1;
        gbcPanel02.gridy = 2;
        gbcPanel02.gridwidth = 5;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 1;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(lbLabel0, gbcPanel02);
        pnPanel0.add(lbLabel0);

        lbLabel32 = new JLabel("  Nombre Arrendatario:");
        gbcPanel02.gridx = 1;
        gbcPanel02.gridy = 4;
        gbcPanel02.gridwidth = 5;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 1;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(lbLabel32, gbcPanel02);
        pnPanel02.add(lbLabel32);

        lbLabel42 = new JLabel("  Municipio Origen:");
        gbcPanel02.gridx = 1;
        gbcPanel02.gridy = 6;
        gbcPanel02.gridwidth = 5;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 1;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(lbLabel42, gbcPanel02);
        pnPanel02.add(lbLabel42);

        lbLabel82 = new JLabel("  Dirección Origen:");
        gbcPanel02.gridx = 1;
        gbcPanel02.gridy = 8;
        gbcPanel02.gridwidth = 5;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 1;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(lbLabel82, gbcPanel02);
        pnPanel0.add(lbLabel82);

        tfText02 = new JTextField();
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 2;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText02, gbcPanel02);
        pnPanel0.add(tfText02);

        tfText1 = new JTextField();
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 4;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText1, gbcPanel02);
        pnPanel0.add(tfText1);

        tfText2 = new JTextField();
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 6;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText2, gbcPanel02);
        pnPanel0.add(tfText2);

        tfText3 = new JTextField();
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 8;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText3, gbcPanel02);
        pnPanel0.add(tfText3);

        lbLabel5 = new JLabel("  Municipio Destino:");
        gbcPanel02.gridx = 1;
        gbcPanel02.gridy = 10;
        gbcPanel02.gridwidth = 5;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 1;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(lbLabel5, gbcPanel02);
        pnPanel0.add(lbLabel5);

        lbLabel9 = new JLabel("  Dirección Destino:");
        gbcPanel02.gridx = 1;
        gbcPanel02.gridy = 12;
        gbcPanel02.gridwidth = 5;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 1;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(lbLabel9, gbcPanel02);
        pnPanel0.add(lbLabel9);

        tfText4 = new JTextField();
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 10;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText4, gbcPanel02);
        pnPanel0.add(tfText4);

        tfText5 = new JTextField();
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 12;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText5, gbcPanel02);
        pnPanel0.add(tfText5);


        btBut02 = new JButton("Next");
        gbcPanel02.gridx = 5;
        gbcPanel02.gridy = 16;
        gbcPanel02.gridwidth = 9;
        gbcPanel02.gridheight = 2;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(btBut02, gbcPanel02);
        pnPanel0.add(btBut02);

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

    public String getTfText02() {
        return tfText02.getText();
    }

    public String getTfText12() {
        return tfText12.getText();
    }

    public String getTfText22() {
        return tfText22.getText();
    }

    public String getTfText32() {
        return tfText32.getText();
    }

    public String getTfText4() {
        return tfText4.getText();
    }

    public String getTfText5() {
        return tfText5.getText();
    }

    public void setTfText02(String tfText02) {
        this.tfText02.setText(tfText02);
    }

    public void setTfText12(String tfText12) {
        this.tfText12.setText(tfText12);
    }

    public void setTfText22(String tfText22) {
        this.tfText22.setText(tfText22);
    }

    public void setTfText32(String tfText32) {
        this.tfText32.setText(tfText32);
    }

    public void setTfText4(String tfText4) {
        this.tfText4.setText(tfText4);
    }

    public void setTfText5(String tfText5) {
        this.tfText5.setText(tfText5);
    }

    public void setVista2(Register temp) {
        tempreg = temp;

        setTfText02(tempreg.getFechaContrato());
        setTfText12(tempreg.getNombreArrendatario());
        setTfText22("Aeroport");
        setTfText32("Aeroport");
        setTfText4("Aeroport");
        setTfText5("Aeroport");

    }

    public Register getReg() {

        tempreg.setFechaContrato(getTfText02());
        tempreg.setNombreArrendatario(getTfText12());

        //fer get de nubnicio i cridar
        String[] origen = csv.codigoINE(getTfText22());
        tempreg.setMunicipioOrigenId(origen[1]);
        tempreg.setProvinciaOrigenId(origen[0]);
        tempreg.setDireccionOrigen(getTfText32());


        String[] dest = csv.codigoINE(getTfText4());
        tempreg.setMunicipioDestinoId(dest[1]);
        tempreg.setProvinciaDestinoId(dest[0]);
        tempreg.setDireccionDestino(getTfText5());

        tempreg.setMunicipioDestinoLejanaId(dest[1]);
        tempreg.setProvinciaDestinoLejanaId(dest[0]);
        tempreg.setDireccionDestinoLejana(getTfText5());

        return tempreg;
    }


    //Getters i Setters


}
