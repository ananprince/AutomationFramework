package homeWork10;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: base_maven
 * @Author: 54540
 * @Create: 2021-04-15 14:39
 * @Desc：
 **/
public class WriteDataObject {
    public static void main(String[] args) throws Exception {
        WriteBackData w1 = new WriteBackData(1,2,"Pass");
        WriteBackData w2 = new WriteBackData(2,2,"Fail");
        WriteBackData w3 = new WriteBackData(3,2,"Pass");
        List<WriteBackData> list= new ArrayList<>();
        list.add(w1);
        list.add(w2);
        list.add(w3);
        //System.out.println(list);
        //poi写入excel文件中
        FileInputStream fis = new FileInputStream("src/test/resources/exam.xls");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(0);
        Row row;
        Cell cell;
        for (int i = 0; i < list.size(); i++) {
            row = sheet.getRow(list.get(i).getRowNum());
            cell = row.getCell(list.get(i).getCellNum(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellValue(list.get(i).getContent());
        }
        

        //写入文件
        FileOutputStream fos = new FileOutputStream("src/test/resources/exam.xls");
        wb.write(fos);
        fos.close();

        for (Row row1 :
                sheet) {
            for (Cell cell1 :
                    row1) {
                cell1.setCellType(CellType.STRING);
                System.out.print(cell1.getStringCellValue()+" ");

            }
            System.out.println();
        }
    }

}
