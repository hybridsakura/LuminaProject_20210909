package com.hybridsakura.project.app.luminabot.repo;

import com.hybridsakura.project.app.luminabot.helper.LuminaHelper_Profile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProfileHandle {

    //  负责将配置文件读取，并回写到文件中
    LuminaHelper_Profile luminaHelperProfile = new LuminaHelper_Profile();

    public void basicTest() {
        //  将文件读取到workbook
        XSSFWorkbook workbook = luminaHelperProfile.getWorkbookByFilepath("src/main/resources/profile/test.xlsx");
        XSSFSheet sheet = workbook.getSheetAt(0);
        System.out.println("[预计数据行数：共"+(sheet.getLastRowNum()+1)+"条数据]");
    }

    //  负责将程序内部的配置文件读取，写入到外部xlsx文件中
    public void outputProfile2File(String targetFilepath) {

        ProfileData profileData = new ProfileData();



    }

    //  负责读取外部的xlsx文件，并依次封装成配置对象
    public void inputFileToProfile(String targetFilepath) {



    }



}
