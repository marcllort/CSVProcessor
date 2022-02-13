package csv.View;

import csv.Controller.Controlador;
import csv.Model.CSVReader;
import csv.Model.Register;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class secondView extends JFrame implements DocumentListener {

    public static final String direccio = System.getProperty("user.dir") + "/data";
    private static String INPUT = "/input.csv";
    private static String INE = "/INE.xlsx";
    private static String OUTPUT = "/output.txt";
    private String actualPath;

    private Register tempreg;
    private CSVReader csv;

    private static final String COMMIT_ACTION = "commit";

    private static enum Mode {INSERT, COMPLETION}

    ;
    private Mode mode = Mode.INSERT;
    private List<String> municipis;

    private String camp;


    JPanel pnPanel02;
    JLabel lbLabel02;
    JLabel lbLabel32;
    JLabel lbLabel42;
    JLabel lbLabel82;
    JTextField tfText02;
    JTextField tfText12;
    JTextArea tfText22;
    JTextField tfText32;
    JLabel lbLabel5;
    JLabel lbLabel9;
    JLabel lbLabel91;
    JTextArea tfText4;
    JComboBox<String> jcDirOr;
    JTextField tfText5;
    JComboBox<String> jcDirDest;
    JTextField tfText6;
    JButton btBut02;
    JButton btBut03;


    public secondView() {

        ConfigInit();
        vista2();
        tfText22.getDocument().addDocumentListener(this);
        tfText4.getDocument().addDocumentListener(this);

        InputMap im = tfText22.getInputMap();
        ActionMap am = tfText22.getActionMap();
        im.put(KeyStroke.getKeyStroke("ENTER"), COMMIT_ACTION);
        am.put(COMMIT_ACTION, new CommitAction());

        InputMap im2 = tfText4.getInputMap();
        ActionMap am2 = tfText4.getActionMap();
        im2.put(KeyStroke.getKeyStroke("ENTER"), COMMIT_ACTION);
        am2.put(COMMIT_ACTION, new CommitAction());

        municipis = new ArrayList<String>(11);
        municipis.add("Barcelona");
        municipis.add("Aeroport");
        municipis.add("Girona");
        municipis.add("Tarragona");
        municipis.add("Sitges");
        municipis.add("Port");
        municipis.add("Martorelles");
        municipis.add("Sant Cugat del Vallès");
        municipis.add("Penedes");
        municipis.add("Figueres");
        municipis.add("Tossa de Mar");


        jcDirDest.addItem("Aeroport");
        jcDirDest.addItem("Port");
        jcDirDest.addItem("Centre");
        jcDirDest.addItem("Domicili");
        jcDirDest.addItem("Hotel ");

        jcDirOr.addItem("Aeroport");
        jcDirOr.addItem("Port");
        jcDirOr.addItem("Centre");
        jcDirOr.addItem("Domicili");
        jcDirOr.addItem("Hotel ");

        jcDirOr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfText32.setText(jcDirOr.getItemAt(jcDirOr.getSelectedIndex()));
            }
        });

        jcDirDest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfText5.setText(jcDirDest.getItemAt(jcDirDest.getSelectedIndex()));
            }
        });


        csv = new CSVReader("", "", "");


        getContentPane().add(pnPanel02);                             //Afegim tot al jframe
        updatecamp();
    }


    private void ConfigInit() {

        setTitle("Registros Fomento VTC");                                     //Pose titol, tamany, posicio...
        setSize(650, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

    }

    public void registraControlador(Controlador controlador) {

        btBut02.addActionListener(controlador);                                  //Afegeixo el listener al boto gros
        btBut02.setActionCommand("NEXT");

        btBut03.addActionListener(controlador);                                  //Afegeixo el listener al boto gros
        btBut03.setActionCommand("SKIP");
    }


    public void vista2() {

        pnPanel02 = new JPanel();
        pnPanel02.setBorder(BorderFactory.createTitledBorder(""));
        GridBagLayout gbPanel02 = new GridBagLayout();
        GridBagConstraints gbcPanel02 = new GridBagConstraints();
        pnPanel02.setLayout(gbPanel02);

        lbLabel02 = new JLabel("  Fecha Contrato:");
        lbLabel02.setFont(new Font("Arial", Font.PLAIN, 18));
        gbcPanel02.gridx = 1;
        gbcPanel02.gridy = 2;
        gbcPanel02.gridwidth = 5;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 1;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(lbLabel02, gbcPanel02);
        pnPanel02.add(lbLabel02);

        lbLabel32 = new JLabel("  Nombre Arrendatario:");
        lbLabel32.setFont(new Font("Arial", Font.PLAIN, 18));
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
        lbLabel42.setFont(new Font("Arial", Font.PLAIN, 18));
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
        lbLabel82.setFont(new Font("Arial", Font.PLAIN, 18));
        gbcPanel02.gridx = 1;
        gbcPanel02.gridy = 8;
        gbcPanel02.gridwidth = 5;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 1;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(lbLabel82, gbcPanel02);
        pnPanel02.add(lbLabel82);

        tfText02 = new JTextField();
        tfText02.setFont(new Font("Arial", Font.PLAIN, 18));
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 2;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText02, gbcPanel02);
        pnPanel02.add(tfText02);

        tfText12 = new JTextField();
        tfText12.setFont(new Font("Arial", Font.PLAIN, 18));
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 4;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText12, gbcPanel02);
        pnPanel02.add(tfText12);

        tfText22 = new JTextArea();
        tfText22.setFont(new Font("Arial", Font.PLAIN, 18));
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 6;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText22, gbcPanel02);
        pnPanel02.add(tfText22);

        tfText32 = new JTextField();
        tfText32.setFont(new Font("Arial", Font.PLAIN, 18));
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 8;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText32, gbcPanel02);
        pnPanel02.add(tfText32);

        jcDirOr = new JComboBox<>();
        gbcPanel02.gridx = 20;
        gbcPanel02.gridy = 8;
        gbcPanel02.gridwidth = 1;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(jcDirOr, gbcPanel02);
        pnPanel02.add(jcDirOr);

        lbLabel5 = new JLabel("  Municipio Destino:");
        lbLabel5.setFont(new Font("Arial", Font.PLAIN, 18));
        gbcPanel02.gridx = 1;
        gbcPanel02.gridy = 10;
        gbcPanel02.gridwidth = 5;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 1;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(lbLabel5, gbcPanel02);
        pnPanel02.add(lbLabel5);

        lbLabel9 = new JLabel("  Dirección Destino:");
        lbLabel9.setFont(new Font("Arial", Font.PLAIN, 18));
        gbcPanel02.gridx = 1;
        gbcPanel02.gridy = 12;
        gbcPanel02.gridwidth = 5;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 1;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(lbLabel9, gbcPanel02);
        pnPanel02.add(lbLabel9);

        tfText4 = new JTextArea();
        tfText4.setFont(new Font("Arial", Font.PLAIN, 18));
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 10;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText4, gbcPanel02);
        pnPanel02.add(tfText4);


        tfText5 = new JTextField();
        tfText5.setFont(new Font("Arial", Font.PLAIN, 18));
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 12;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText5, gbcPanel02);
        pnPanel02.add(tfText5);

        jcDirDest = new JComboBox<>();
        gbcPanel02.gridx = 20;
        gbcPanel02.gridy = 12;
        gbcPanel02.gridwidth = 1;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(jcDirDest, gbcPanel02);
        pnPanel02.add(jcDirDest);


        lbLabel91 = new JLabel("  Descripción Servicio:");
        lbLabel91.setFont(new Font("Arial", Font.PLAIN, 18));
        gbcPanel02.gridx = 1;
        gbcPanel02.gridy = 13;
        gbcPanel02.gridwidth = 5;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 1;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(lbLabel91, gbcPanel02);
        pnPanel02.add(lbLabel91);

        tfText6 = new JTextField();
        tfText6.setFont(new Font("Arial", Font.PLAIN, 18));
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 13;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 1;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(tfText6, gbcPanel02);
        pnPanel02.add(tfText6);

        btBut03 = new JButton("Skip");
        gbcPanel02.gridx = 7;
        gbcPanel02.gridy = 16;
        gbcPanel02.gridwidth = 11;
        gbcPanel02.gridheight = 2;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(btBut03, gbcPanel02);
        pnPanel02.add(btBut03);

        btBut02 = new JButton("Add");
        gbcPanel02.gridx = 5;
        gbcPanel02.gridy = 16;
        gbcPanel02.gridwidth = 9;
        gbcPanel02.gridheight = 2;
        gbcPanel02.fill = GridBagConstraints.BOTH;
        gbcPanel02.weightx = 1;
        gbcPanel02.weighty = 0;
        gbcPanel02.anchor = GridBagConstraints.NORTH;
        gbPanel02.setConstraints(btBut02, gbcPanel02);
        pnPanel02.add(btBut02);


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

    public String getTfText6() {
        return tfText6.getText();
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

    public void setTfText6(String tfText5) {
        this.tfText6.setText(tfText5);
    }


    public void insertUpdate(DocumentEvent ev) {
        if (ev.getLength() != 1) {
            return;
        }

        int pos = ev.getOffset();
        String content = null;
        try {
            updatecamp();
            switch (camp) {
                case "munOr":
                    content = tfText22.getText(0, pos + 1);
                    break;
                case "munDest":
                    content = tfText4.getText(0, pos + 1);
                    break;
            }

        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Find where the word starts
        int w;
        for (w = pos; w >= 0; w--) {
            if (!Character.isLetter(content.charAt(w))) {
                break;
            }
        }
        if (pos - w < 2) {
            // Too few chars
            return;
        }

        String prefix = content.substring(w + 1);

        int n = 1;

        if (municipis.size() != 0) {
            boolean notfound = true;
            while (notfound && n <= municipis.size()) {
                String match = municipis.get(municipis.size() - n);

                if (match.toLowerCase().startsWith(prefix.toLowerCase())) {
                    // A completion is found
                    String completion = match.substring(pos - w);



                    // We cannot modify Document from within notification,
                    // so we submit a task that does the change later
                    notfound = false;
                    SwingUtilities.invokeLater(
                            new CompletionTask(completion, pos + 1));
                }
                n++;
            }
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }


    private class CompletionTask implements Runnable {
        String completion;
        int position;

        CompletionTask(String completion, int position) {
            this.completion = completion;
            this.position = position;
        }

        public void run() {
            updatecamp();

            switch (camp) {
                case "munOr":
                    tfText22.insert(completion, position);
                    tfText22.setCaretPosition(position + completion.length());
                    tfText22.moveCaretPosition(position);

                    break;
                case "munDest":
                    tfText4.insert(completion, position);
                    tfText4.setCaretPosition(position + completion.length());
                    tfText4.moveCaretPosition(position);


                    break;
            }

            mode = Mode.COMPLETION;
        }
    }

    private class CommitAction extends AbstractAction {
        public void actionPerformed(ActionEvent ev) {
            if (mode == Mode.COMPLETION) {
                int pos;
                String text;
                updatecamp();
                switch (camp) {
                    case "munOr":
                        pos = tfText22.getSelectionEnd();
                        tfText22.insert(" ", pos);
                        tfText22.setCaretPosition(pos + 1);
                        mode = Mode.INSERT;
                        text = tfText22.getText();
                        tfText22.setText(text.substring(0, text.length() - 1));
                        String textt = tfText22.getText().substring(0, 1).toUpperCase() + tfText22.getText().substring(1);
                        tfText22.setText(textt);
                        break;
                    case "munDest":
                        pos = tfText4.getSelectionEnd();
                        tfText4.insert(" ", pos);
                        tfText4.setCaretPosition(pos + 1);
                        mode = Mode.INSERT;
                        text = tfText4.getText();
                        tfText4.setText(text.substring(0, text.length() - 1));
                        String text2 = tfText4.getText().substring(0, 1).toUpperCase() + tfText4.getText().substring(1);
                        tfText4.setText(text2);
                        break;
                }


            } else {
                updatecamp();
                switch (camp) {
                    case "munOr":
                        tfText22.replaceSelection("\n");
                        break;
                    case "munDest":
                        tfText4.replaceSelection("\n");
                        break;
                }

            }
        }
    }


    public void setVista2(Register temp) {
        tempreg = temp;

        setTfText02(tempreg.getFechaContrato());
        setTfText12(tempreg.getNombreArrendatario());
        setTfText22("Aeroport");
        setTfText32("Aeroport");
        setTfText4("Aeroport");
        setTfText5("Aeroport");

        setTfText6(tempreg.getDescripcio());

    }

    private void updatecamp() {

        if (!tfText22.hasFocus()) {
            camp = "munDest";
        } else {
            camp = "munOr";
        }
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

    public void setCSV(CSVReader newcsv) {
        csv = newcsv;
    }

    public void setCiudades() {
        municipis = csv.csvCiudades();
        System.out.println(municipis.size());
        System.out.println(municipis.get(10));
    }

    public void avisComplet() {
        JOptionPane.showMessageDialog(this,
                "Importació completa! Fitxer guardat");

        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
