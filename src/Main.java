import Controller.Controlador;
import Model.Register;
import View.mainView;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        mainView vista = new mainView();               //Inicialitzo vista, passantli les continues que ha de carregar a la store
        vista.setVisible(true);

        //Model.CSVReader csv = new Model.CSVReader();
        //ArrayList<Register> registros = csv.readCSV();



        Controlador controlador = new Controlador( vista);
        vista.registraControlador(controlador);

    }
}
