package Controller;

import Model.CSVReader;
import Model.Register;
import View.mainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador implements ActionListener {

    private Register model;
    private mainView vista;
    private CSVReader csv;

    private ArrayList<Register> registros;
    private Register temp;

    public Controlador(mainView vista) {
        this.model = model;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("START")) {                                      //amb els actioncommand identifico
            csv = new CSVReader(vista.getTfText1(), vista.getTfText2(), vista.getTfText3());
            temp = csv.readCSVregister();
        } else if (e.getActionCommand().equals("NEXT")) {                                      //amb els actioncommand identifico
            registros.add(vista.getReg());
            temp = csv.readCSVregister();
            vista.setVista2(temp);
            if (temp == null) {
                csv.txtCreator(registros);
            }

        }
    }
}
