package com.hybridsakura.project.app.luminabot.helper;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProfileHelper {

    //  获取表格格式化的Workbook
    public XSSFWorkbook getWorkbookByFilepath(String filepath) {
        XSSFWorkbook workbook = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filepath);
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            System.out.println("文件读取错误（文件可能不存在或路径错误）或表格的格式（必须为.xlsx格式）不正确");
            e.printStackTrace();
        }
        return workbook;
    }

}
