package com.sunway.util;

import com.sunway.entity.tax.TaxWsxx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

public class MSFileUtil {
    private static Logger logger = LogManager.getLogger(MSFileUtil.class);
    private final static String excel2003L =".xls";    //2003- 版本的excel
    private final static String excel2007U =".xlsx";   //2007+ 版本的excel
    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     * @param inStr,fileName
     * @return
     * @throws Exception
     */
    public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception{
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if(excel2003L.equals(fileType)){
            wb = new HSSFWorkbook(inStr);  //2003-
        }else if(excel2007U.equals(fileType)){
            wb = new XSSFWorkbook(inStr);  //2007+
        }else{
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    @Test
    public void importXLS() {
        ArrayList<TaxWsxx> list = new ArrayList<>();
        InputStream inputStream = null;
        Workbook workbook = null;
        Sheet sheetAt = null;
        try {
            String fileName = "工作表.xlsx";
            //1、获取文件输入流
            inputStream = new FileInputStream("e:/工作表.xlsx");
            //2、获取Excel工作簿对象
            workbook = getWorkbook(inputStream, fileName);
            //3、得到Excel工作表对象
            sheetAt = workbook.getSheetAt(0);
            //4、循环读取表格数据
            for (Row row : sheetAt) {
                //首行（即表头）不读取
                if (row.getRowNum() == 0) {
                    continue;
                }
                //读取当前行中单元格数据，索引从0开始
                String areaNum = row.getCell(0).getStringCellValue();
                String province = row.getCell(1).getStringCellValue();
                Date city = row.getCell(2).getDateCellValue();
                double district = row.getCell(3).getNumericCellValue();

                TaxWsxx area = new TaxWsxx();
//                area.setCity(city);
//                area.setDistrict(district);
//                area.setProvince(province);
//　　　　　　　area.setPostCode(postcode);
                list.add(area);
            }
            //5、关闭流
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            workbook = null;
            inputStream = null;
        }
//        return list;
    }

}
