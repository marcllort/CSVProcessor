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

    public Controlador(mainView vista) {
        this.model = model;
        this.vista = vista;
        csv = new CSVReader();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("START")) {                                      //amb els actioncommand identifico
            ArrayList<Register> registros = csv.readCSV(vista.getTfText1(),vista.getTfText2(),vista.getTfText3());
            csv.txtCreator(registros);
        }
    }
}
