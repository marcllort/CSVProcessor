import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class CSVReader {

    public void readCSV() {

        String csvFile = "C:/Users/mac12/Desktop/provapapa.csv";
        String line = "";
        String cvsSplitBy = ",";

        /*try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        codigoINE("Barcelona");

    }

    private String[] codigoINE(String ciudad) {
        boolean done = false;
        int i = 0;
        String[] codigos = {"0", "0"};
        File excelFile = new File("C:/Users/mac12/Desktop/INE.xlsx");
        FileInputStream fis = null;
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

}