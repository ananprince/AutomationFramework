package homeWork10;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: base_maven
 * @Author: 54540
 * @Create: 2021-05-13 15:06
 * @Desc：
 **/
public class WriteDataObect02 {
    public static void main(String[] args) throws IOException {
        WriteBackData w1 = new WriteBackData(1,2,"渣渣辉");
        WriteBackData w2 = new WriteBackData(2,2,"渣渣辉");
        WriteBackData w3 = new WriteBackData(3,2,"渣渣辉");
        List<WriteBackData> list = new ArrayList<>();
        list.add(w1);
        list.add(w2);
        list.add(w3);

        FileInputStream fis = new FileInputStream("src/test/resources/exam.xls");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheetAt = workbook.getSheetAt(0);
        Row row;
        Cell cell;
        for (int i = 0; i < list.size(); i++) {
            row = sheetAt.getRow(list.get(i).getRowNum());
            //Row.MissingCellPolicy.CREATE_NULL_AS_BLANK（返回null时，默认返回空）
            cell = row.getCell(list.get(i).getCellNum(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(list.get(i).getContent());
        }
        FileOutputStream fos = new FileOutputStream("src/test/resources/exam.xls");
        workbook.write(fos);




        //循环输出excel内容
        for (Row row1 :
                sheetAt) {
            for (Cell cell1 :
                    row1) {
                cell1.setCellType(CellType.STRING);
                System.out.print(cell1.getStringCellValue()+" ");
            }
            System.out.println();
        }
    }
}
