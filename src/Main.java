import Controller.Controlador;
import Model.Register;
import View.mainView;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        mainView vista = new mainView();               //Inicialitzo vista, passantli les continues que ha de carregar a la store
        vista.setVisible(true);

        //CSVReader csv = new CSVReader();
        //ArrayList<Register> registros = csv.readCSV();



        //Controlador controlador = new Controlador(registros, vista);
        //vista.registraControlador(controlador);

    }
}
