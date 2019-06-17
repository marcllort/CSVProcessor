package Controller;

import Model.CSVReader;
import Model.Register;
import View.mainView;
import View.secondView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador implements ActionListener {

    private Register model;
    private mainView vista;
    private secondView vista2;
    private CSVReader csv;

    private ArrayList<Register> registros;
    private Register temp;

    public Controlador(mainView vista, secondView vista2) {
        this.model = model;
        this.vista = vista;
        this.vista2 = vista2;
        registros= new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("START")) {                                      //amb els actioncommand identifico
            csv = new CSVReader(vista.getTfText1(), vista.getTfText2(), vista.getTfText3());
            temp = csv.readCSVregister();
            vista2.setVista2(temp);
        } else if (e.getActionCommand().equals("NEXT")) {                                      //amb els actioncommand identifico
            registros.add(vista2.getReg());
            temp = csv.readCSVregister();

            if (temp == null) {
                csv.txtCreator(registros);
                vista2.avisComplet();
            }
            vista2.setVista2(temp);
        } else if (e.getActionCommand().equals("SKIP")){
            temp = csv.readCSVregister();

            if (temp == null) {
                csv.txtCreator(registros);
                vista2.avisComplet();
            }
            vista2.setVista2(temp);
        }
    }
}
