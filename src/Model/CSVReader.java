package Model;

import Model.Register;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class CSVReader {

    private static String inputCSV = "C:/Users/mac12/Desktop/input.csv";
    private static String ineXLSX = "C:/Users/mac12/Desktop/INE.xlsx";
    private static String outputTXT = "C:/Users/mac12/Desktop/output.txt";

    private static String matricula = "5729-JTV";
    private static String nifTitular = "46333876P";
    private static String codigoArrendatario = "F08200537";
    private BufferedReader br;
    private int id = 0;
    private String datecontrato = "";
    private String date = "";

    private ArrayList<Register> registros;

    public CSVReader(String tfText1, String tfText2, String tfText3) {
        inputCSV = tfText1;
        ineXLSX = tfText2;
        outputTXT = tfText3;

        try {
            br = new BufferedReader(new FileReader(inputCSV));
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
    }

    public ArrayList<Register> readCSV() {

        String line = "";
        String cvsSplitBy = ",";
        registros = new ArrayList<>();
        int id = 0;


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

                tempReg.setProvinciaOrigenId(aeroport[0]);
                tempReg.setMunicipioOrigenId(aeroport[1]);
                tempReg.setDireccionOrigen("Aeroport");

                tempReg.setFechaInicio(csvlinia[2]);

                tempReg.setProvinciaDestinoId(aeroport[0]);
                tempReg.setMunicipioDestinoId(aeroport[1]);
                tempReg.setDireccionDestino("Aeroport");

                tempReg.setFechaFin(csvlinia[2]);

                tempReg.setProvinciaDestinoLejanaId(aeroport[0]);
                tempReg.setMunicipioDestinoLejanaId(aeroport[1]);
                tempReg.setDireccionDestinoLejana("Aeroport");


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

    public Register readCSVregister() {

        String line = "";
        String cvsSplitBy = ",";


        Register tempReg = new Register();


        String[] bcn = codigoINE("Barcelona");
        String[] aeroport = codigoINE("Aeroport");

        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line == null) {
            return null;
        } else {

            String[] csvlinia = line.split(cvsSplitBy);

            if (csvlinia[0].replace("\"", "").equals("Passat")) {
                while (csvlinia[0].replace("\"", "").equals("Passat")) {
                    try {

                        if (!csvlinia[1].replace("\"", "").equals("")) {
                            date = csvlinia[1].replace("\"", "");

                            try {
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate date2 = LocalDate.parse(date, dtf);
                                date2 = date2.minusDays(1);
                                datecontrato = formatDate(date2);


                            } catch (DateTimeParseException e) {
                                try {
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/yyyy");
                                    LocalDate date2 = LocalDate.parse(date, dtf);
                                    date2 = date2.minusDays(1);
                                    datecontrato = formatDate(date2);

                                } catch (DateTimeParseException e2) {
                                    try {
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/M/yyyy");
                                        LocalDate date2 = LocalDate.parse(date, dtf);
                                        date2 = date2.minusDays(1);
                                        datecontrato = formatDate(date2);

                                    } catch (DateTimeParseException e3) {
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
                                        LocalDate date2 = LocalDate.parse(date, dtf);
                                        date2 = date2.minusDays(1);
                                        datecontrato = formatDate(date2);
                                    }
                                }
                            }

                        }

                        line = br.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (line == null) {
                        return null;
                    } else {
                        csvlinia = line.split(cvsSplitBy);
                    }
                }
            }

            tempReg.setId(id);
            tempReg.setMatricula(matricula);

            tempReg.setNifTitular(nifTitular);
            tempReg.setNifArrendador(nifTitular);

            tempReg.setCodigoArrendatario(codigoArrendatario);
            tempReg.setNombreArrendatario(csvlinia[2].replace("\"", ""));


            if (!csvlinia[1].replace("\"", "").equals("")) {
                date = csvlinia[1].replace("\"", "");

                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date2 = LocalDate.parse(date, dtf);
                    date2 = date2.minusDays(1);
                    datecontrato = formatDate(date2);


                } catch (DateTimeParseException e) {
                    try {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/yyyy");
                        LocalDate date2 = LocalDate.parse(date, dtf);
                        date2 = date2.minusDays(1);
                        datecontrato = formatDate(date2);

                    } catch (DateTimeParseException e2) {
                        try {
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/M/yyyy");
                            LocalDate date2 = LocalDate.parse(date, dtf);
                            date2 = date2.minusDays(1);
                            datecontrato = formatDate(date2);

                        } catch (DateTimeParseException e3) {
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
                            LocalDate date2 = LocalDate.parse(date, dtf);
                            date2 = date2.minusDays(1);
                            datecontrato = formatDate(date2);
                        }
                    }
                }

            }


            tempReg.setFechaContrato(datecontrato);
            tempReg.setProvinciaContratoId(bcn[0]);
            tempReg.setMunicipioContratoId(bcn[1]);

            tempReg.setProvinciaOrigenId(aeroport[0]);
            tempReg.setMunicipioOrigenId(aeroport[1]);
            tempReg.setDireccionOrigen("Aeroport");

            String hora = "";
            String min = "";
            try {
                hora = csvlinia[4].replace("\"", "");

            } catch (Exception e) {

            }
            try {
                min = csvlinia[5].replace("\"", "");

            } catch (Exception e) {
                min = "00";
            }
            tempReg.setFechaInicio(date + " " + hora + ":" + min);

            tempReg.setProvinciaDestinoId(aeroport[0]);
            tempReg.setMunicipioDestinoId(aeroport[1]);
            tempReg.setDireccionDestino("Aeroport");

            tempReg.setFechaFin(date);

            tempReg.setProvinciaDestinoLejanaId(aeroport[0]);
            tempReg.setMunicipioDestinoLejanaId(aeroport[1]);
            tempReg.setDireccionDestinoLejana("Aeroport");

            tempReg.setDescripcio(csvlinia[3].replace("\"", ""));


            System.out.println("Registro ID:" + id + " [ matrícula= " + tempReg.getMatricula() + " nifTitular= " + tempReg.getNifTitular() + " nifArrendador= " + tempReg.getNifArrendador() +
                    " codigoArrendatario= " + tempReg.getCodigoArrendatario() + " nombreArrendatario= " + tempReg.getNombreArrendatario() + " fechaContrato= " + tempReg.getFechaContrato() +
                    " provinciaContratoId= " + tempReg.getProvinciaContratoId() + " municipioContratoId= " + tempReg.getMunicipioContratoId() + " provinciaOrigenId= " + tempReg.getProvinciaOrigenId() +
                    " municipioOrigenId= " + tempReg.getMunicipioOrigenId() + " direccionOrigen= " + tempReg.getDireccionOrigen() + " fechaInicio= " + tempReg.getFechaInicio() +
                    " provinciaDestinoId= " + tempReg.getProvinciaDestinoId() + " municipioDestinoId= " + tempReg.getMunicipioDestinoId() + " direccionDestino= " + tempReg.getDireccionDestino() +
                    " fechaFin= " + tempReg.getFechaFin() + " provinciaDestinoLejanaId= " + tempReg.getProvinciaDestinoLejanaId() + " municipioDestinoLejanaId= " + tempReg.getMunicipioDestinoLejanaId() +
                    " direccionDestinoLejana= " + tempReg.getDireccionDestinoLejana() + "]");


            id++;

        }


        //codigoINE("Barcelona");
        return tempReg;
    }

    private String formatDate(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedString = localDate.format(formatter);
        return formattedString;
    }


    public String[] codigoINE(String ciudad) {
        boolean done = false;
        int i = 0;
        String[] codigos = {"0", "0"};
        File excelFile = new File(ineXLSX);
        FileInputStream fis = null;

        if (ciudad.equals("Aeroport")) {
            String[] reg = {"08", "169"};
            return reg;
        } else if (ciudad.equals("Barcelona")) {
            String[] reg = {"08", "019"};
            return reg;
        } else if (ciudad.equals("Port")) {
            String[] reg = {"08", "019"};
            return reg;
        }else if (ciudad.equals("Penedes")) {
            String[] reg = {"08", "241"};
            return reg;
        }else if (ciudad.equals("Martorelles")) {
            String[] reg = {"08", "256"};
            return reg;
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

        public ArrayList<String> csvCiudades () {
            boolean done = false;
            int i = 0;
            String[] codigos = {"0", "0"};
            File excelFile = new File(ineXLSX);
            FileInputStream fis = null;
            ArrayList<String> ciutats = new ArrayList<>();

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
                        if (i == 4) { //Municipio
                            ciutats.add(cell.toString());
                        }
                        i++;
                    }

                }

                workbook.close();
                fis.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return ciutats;
        }

        public void txtCreator (ArrayList < Register > registros) {
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
                        writer.write(System.getProperty("line.separator"));
                    }
                }


                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }