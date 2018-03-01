/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.io.File;
import mailer.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author wishwa
 */
public class DataReadi {

    String urlfile;
    String filename;
    String shettname;
    String newUrl;

    public void setUrlfile(String urlfile) {
        this.urlfile = urlfile;
    }

    public CopyOnWriteArrayList<String> getEmails(String paths) throws IOException {
        int count = 0;
        this.urlfile = paths;
        File source = new File(urlfile);

        CopyOnWriteArrayList<String> emails = new CopyOnWriteArrayList<>();
        FileInputStream fis = new FileInputStream(urlfile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        this.shettname = sheet.getSheetName();
        FormulaEvaluator formulaev = workbook.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet) {

            for (Cell cell : row) {
                switch (formulaev.evaluateInCell(cell).getCellType()) {
                    case Cell.CELL_TYPE_STRING:

                        String txt = cell.getRichStringCellValue().getString();
                        //boolean bl =txt.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
                        boolean bl = txt.matches("^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$");

                        if (bl) {
                            emails.add(txt);
                            count += 1;
                            //System.out.println(txt);
                        }

                        break;

                }
            }
        }
        workbook.close();

        int rownum = sheet.getLastRowNum();
        if (rownum > count) {
            FileOutputStream fio = new FileOutputStream(paths);
            XSSFWorkbook workbook1 = new XSSFWorkbook();
            XSSFSheet sheetnew = workbook1.createSheet(shettname);
            int i = 0;
            for (String emailid : emails) {
                XSSFRow rownew = sheetnew.createRow(i);
                XSSFCell cellnew = rownew.createCell(0);
                cellnew.setCellValue(emailid);

                i++;
            }

            workbook1.write(fio);
            workbook1.close();
            fio.close();

        }
        return emails;
    }

    public void dateWritie(CopyOnWriteArrayList<String> datas, CopyOnWriteArrayList<String> emails, String url) throws FileNotFoundException, IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheetnew = workbook.createSheet("edited mails");

        int rowNum = 0;
        System.out.println("Creating excel");
        for (Iterator<String> iterator = datas.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(next);
        }
        for (Iterator<String> iterator = emails.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(next);
        }

        for (String emailid : datas) {
            XSSFRow rownew = sheetnew.createRow(rowNum);
            XSSFCell cellnew = rownew.createCell(0);
            XSSFCell cellnew1 = rownew.createCell(1);

            cellnew.setCellValue(emailid);
            cellnew1.setCellValue(emails.get(rowNum));

            rowNum++;

        }

        try {
            FileOutputStream outputStream = new FileOutputStream(urlfile);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }

}
