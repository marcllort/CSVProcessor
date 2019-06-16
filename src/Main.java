import Controller.Controlador;
import Model.Register;
import View.mainView;
import View.secondView;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        secondView vista2 = new secondView();               //Inicialitzo vista, passantli les continues que ha de carregar a la store
        vista2.setVisible(true);

        mainView vista = new mainView();               //Inicialitzo vista, passantli les continues que ha de carregar a la store
        vista.setVisible(true);



        //Model.CSVReader csv = new Model.CSVReader();
        //ArrayList<Register> registros = csv.readCSV();



        Controlador controlador = new Controlador( vista, vista2);
        vista.registraControlador(controlador);
        vista2.registraControlador(controlador);

    }
}
