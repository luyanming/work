package com.main;

import com.main.bean.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.Region;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class createExcel {
	private static final String[] excelHeader = {"����", "��Ԫ", "ŷԪ", "�۱�"};

    public static boolean createExcelFile(String path, List<data> data){
        //����workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //����sheet
        HSSFSheet sheet = wb.createSheet("����һ���");

        //������row:��ӱ�ͷ0��
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        //��������
        sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 3));
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("����һ���");
        cell.setCellStyle(style);

        //���ñ�ͷheader
        row = sheet.createRow(1);
        for (int i=0; i<excelHeader.length; ++i){
            HSSFCell headerCell = row.createCell(i);
            headerCell.setCellValue(excelHeader[i]);                          //�趨����
            headerCell.setCellStyle(style);                     //���ݾ���
        }

        //��������
        for (int j=0; j<data.size(); ++j){
            data rowData = data.get(j);
            row = sheet.createRow(j+2);
            row.createCell(0).setCellValue(rowData.getDate());
            row.createCell(1).setCellValue(rowData.getDollar());
            row.createCell(2).setCellValue(rowData.getEuro());
            row.createCell(3).setCellValue(rowData.getHkDollar());
        }

        //�����ļ�
        try {
            FileOutputStream fout = new FileOutputStream(path);
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
