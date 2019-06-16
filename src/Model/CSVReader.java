package Model;

import Model.Register;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVReader {

    private static String inputCSV = "C:/Users/mac12/Desktop/input.csv";
    private static String ineXLSX = "C:/Users/mac12/Desktop/INE.xlsx";
    private static String outputTXT = "C:/Users/mac12/Desktop/output.txt";

    private static String matricula = "5729-JTV";
    private static String nifTitular = "46333876P";
    private static String codigoArrendatario = "F08200537";

    private ArrayList<Register> registros;

    public ArrayList<Register> readCSV(String input, String ine, String output) {

        String line = "";
        String cvsSplitBy = ",";
        registros = new ArrayList<>();
        int id = 0;

        inputCSV = input;
        ineXLSX = ine;
        outputTXT = output;

        try (BufferedReader br = new BufferedReader(new FileReader(inputCSV))) {
            String[] bcn = codigoINE("Barcelona");
            String[] aeroport = codigoINE("Aeroport");

            while (line != null) {
                Register tempReg = new Register();
                String[] csvlinia = line.split(cvsSplitBy);

                tempReg.setId(id);
                tempReg.setMatricula(matricula);

                tempReg.setNifTitular(nifTitular);
                tempReg.setNifArrendador(nifTitular);

                tempReg.setCodigoArrendatario(codigoArrendatario);
                tempReg.setNombreArrendatario(csvlinia[4]);

                tempReg.setFechaContrato(csvlinia[2]);
                tempReg.setProvinciaContratoId(bcn[0]);
                tempReg.setMunicipioContratoId(bcn[1]);

                tempReg.setProvinciaOrigenId();
                tempReg.setMunicipioOrigenId();
                tempReg.setDireccionOrigen();

                tempReg.setFechaInicio(csvlinia[2]);

                tempReg.setProvinciaDestinoId();
                tempReg.setMunicipioDestinoId();
                tempReg.setDireccionDestino();

                tempReg.setFechaFin(csvlinia[2]);

                tempReg.setProvinciaDestinoLejanaId();
                tempReg.setMunicipioDestinoLejanaId();
                tempReg.setDireccionDestinoLejana();


                System.out.println("Registro ID:" + id + " [ matrícula= " + tempReg.getMatricula() + " nifTitular= " + tempReg.getNifTitular() + " nifArrendador= " + tempReg.getNifArrendador() +
                        " codigoArrendatario= " + tempReg.getCodigoArrendatario() + " nombreArrendatario= " + tempReg.getNombreArrendatario() + " fechaContrato= " + tempReg.getFechaContrato() +
                        " provinciaContratoId= " + tempReg.getProvinciaContratoId() + " municipioContratoId= " + tempReg.getMunicipioContratoId() + " provinciaOrigenId= " + tempReg.getProvinciaOrigenId() +
                        " municipioOrigenId= " + tempReg.getMunicipioOrigenId() + " direccionOrigen= " + tempReg.getDireccionOrigen() + " fechaInicio= " + tempReg.getFechaInicio() +
                        " provinciaDestinoId= " + tempReg.getProvinciaDestinoId() + " municipioDestinoId= " + tempReg.getMunicipioDestinoId() + " direccionDestino= " + tempReg.getDireccionDestino() +
                        " fechaFin= " + tempReg.getFechaFin() + " provinciaDestinoLejanaId= " + tempReg.getProvinciaDestinoLejanaId() + " municipioDestinoLejanaId= " + tempReg.getMunicipioDestinoLejanaId() +
                        " direccionDestinoLejana= " + tempReg.getDireccionDestinoLejana() + "]");

                registros.add(tempReg);
                id++;

                line = br.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //codigoINE("Barcelona");
        return registros;
    }

    private String[] codigoINE(String ciudad) {
        boolean done = false;
        int i = 0;
        String[] codigos = {"0", "0"};
        File excelFile = new File(ineXLSX);
        FileInputStream fis = null;

        if (ciudad.equals("Aeroport")) {
            String[] reg = {"08", "169"};
        }

        try {
            fis = new FileInputStream(excelFile);

            // we create an XSSF Workbook object for our XLSX Excel File
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            // we get first sheet
            XSSFSheet sheet = workbook.getSheetAt(0);

            // we iterate on rows
            Iterator<Row> rowIt = sheet.iterator();

            while (rowIt.hasNext() && !done) {
                Row row = rowIt.next();

                // iterate on cells for the current row
                Iterator<Cell> cellIterator = row.cellIterator();
                i = 0;
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    //System.out.print(cell.toString() + ";");
                    if (i == 1) { //Provincia
                        codigos[0] = cell.toString();
                    } else if (i == 2) { //Municipio
                        codigos[1] = cell.toString();
                    } else if (i == 4 && cell.toString().equals(ciudad)) {
                        done = true;
                        System.out.println("Ciudad: " + ciudad + " INE Provincia: " + codigos[0] + " INE Municipio: " + codigos[1]);
                        return codigos;
                    }
                    i++;
                }

                //System.out.println();
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void txtCreator(ArrayList<Register> registros) {
        File file = new File(outputTXT);

        //Create the file
        try {
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

            int reg = 0;

            //Write Content
            FileWriter writer = new FileWriter(file);

            for (Register r : registros) {
                writer.write(r.toString());
                reg++;
                if (reg < registros.size()) {
                    writer.write(";");
                }
            }


            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}