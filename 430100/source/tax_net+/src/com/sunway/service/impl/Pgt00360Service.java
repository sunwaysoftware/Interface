/**
 * 
 */
package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.sunway.dao.IPgt00360DAO;
import com.sunway.service.IPgt00360Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.vo.Pgt00360;

/**
 * @author Andy
 *
 */
public class Pgt00360Service implements IPgt00360Service {
	static Logger logger = LogManager.getLogger(Pgt00360Service.class);
	private IPgt00360DAO t00360Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00360Service#GetDeleteCommand(com.sunway.vo.Pgt00360)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00360 bean) throws Exception {
		return t00360Dao.GetDeleteCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00360Service#GetInsertCommand(com.sunway.vo.Pgt00360)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00360 bean) throws Exception {
		return t00360Dao.GetInsertCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00360Service#GetUpdateCommand(com.sunway.vo.Pgt00360)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00360 bean) throws Exception {
		return t00360Dao.GetUpdateCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00360Service#LoadAll(com.sunway.vo.Pgt00360)
	 */
	@Override
	public ArrayList<Pgt00360> LoadAll(Pgt00360 bean) throws Exception {
		return t00360Dao.LoadAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00360Service#LoadByPrimaryKey(com.sunway.vo.Pgt00360)
	 */
	@Override
	public Pgt00360 LoadByPrimaryKey(Pgt00360 bean) throws Exception {
		return t00360Dao.LoadByPrimaryKey(bean);
	}

	/**
	 * @param t00360Dao the t00360Dao to set
	 */
	public void setT00360Dao(IPgt00360DAO t00360Dao) {
		this.t00360Dao = t00360Dao;
	}

	/**
	 * @return the t00360Dao
	 */
	public IPgt00360DAO getT00360Dao() {
		return t00360Dao;
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00360Service#ExecuteParamCopy(com.sunway.vo.Pgt00360)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt00360 bean) throws Exception {
		
		return t00360Dao.ExecuteParamCopy(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00360Service#SelDeleteCommand(com.sunway.vo.Pgt00360)
	 */
	@Override
	public boolean SelDeleteCommand(Pgt00360 bean) throws Exception {
		return t00360Dao.SelDeleteCommand(bean);
	}

	@Override
	public OutputStream ExportT00360(Pgt00360 bean) throws Exception {
		Label label = null;
		DateTime cellDT = null;
		Number cellNumber = null;
		WritableWorkbook workbook = null;
		ByteArrayOutputStream strBufResult = null;
		ArrayList<Pgt00360> resultList = t00360Dao.LoadAll(bean);
		
		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("建筑面积修正", 0);
			WritableCellFormat wcf = Excel.getExcelTitleStyle();
			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "建筑面积下限", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "建筑面积上限", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "更新时间", wcf);
			sheet.addCell(label);
			label = new Label(6, 0, "操作人", wcf);
			sheet.addCell(label);
			label = new Label(7, 0, "备注", wcf);
			sheet.addCell(label);
			
			Integer rowIndex = 1;
			for (Pgt00360 b : resultList) {				
				label = new Label(0, rowIndex, b.getSzqy());
				sheet.addCell(label);
				label = new Label(1, rowIndex, b.getFwlx());
				sheet.addCell(label);
				cellNumber = new Number(2, rowIndex, b.getJzmjMin().doubleValue());
				sheet.addCell(cellNumber);
				cellNumber = new Number(3, rowIndex, b.getJzmjMax().doubleValue());
				sheet.addCell(cellNumber);
				cellNumber = new Number(4, rowIndex, b.getXzxs().doubleValue());
				sheet.addCell(cellNumber);
				cellDT = new DateTime(5, rowIndex, b.getUpddate());
				sheet.addCell(cellDT);
				label = new Label(6, rowIndex, b.getCzr());
				sheet.addCell(label);
				label = new Label(7, rowIndex, b.getNote());
				sheet.addCell(label);
				rowIndex = rowIndex + 1;
			}
			workbook.write();	
		} catch (Exception e) {
			strBufResult.close();
		} finally {
			workbook.close();
			label = null;
			cellDT = null;
			cellNumber = null;
			workbook = null;
		}
		return strBufResult;
	}

	@Override
	public ArrayList<Pgt00360> ImportData(String file, String userId, String ssgx) throws Exception {
		ArrayList<Pgt00360> resultList = new ArrayList<Pgt00360>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try{
			is = new FileInputStream(file);
			wb = Workbook.getWorkbook(is);
			if(wb.getNumberOfSheets() > 0){
				sht = wb.getSheet(0);
				int rowSheet = Excel.getValidRowNumbers(sht.getRows(), sht);
				for(int i = 1;i < rowSheet;i++){
					Pgt00360 bean = new Pgt00360();
					try{
						//A.所在区域
						bean.setSzqy(sht.getCell(0,i).getContents());
						//B.房屋类型
						bean.setFwlx(sht.getCell(1,i).getContents());
						//C.使用年限下限
						try{
							String value = sht.getCell(2,i).getContents();
							bean.setJzmjMin(BigDecimal.valueOf(ConvertUtil.toDouble(value)));
						}catch(Exception e){
							throw new Exception("建筑面积下限格式不正确,请核实第"+i+"条数据");
						}
						//D.使用年限上限
						try{
							String value = sht.getCell(3,i).getContents();
							bean.setJzmjMax(BigDecimal.valueOf(ConvertUtil.toDouble(value)));
						}catch(Exception e){
							throw new Exception("建筑面积上限格式不正确,请核实第"+i+"条数据");
						}
						//E.修正系数
						try{
							String value = CheckUtil.chkTrim(sht.getCell(4,i).getContents());
							bean.setXzxs(BigDecimal.valueOf(ConvertUtil.toDouble(value)));
						}catch(Exception e){
							throw new Exception("修正系数格式不正确,请核实第"+i+"条数据");
						}
						bean.setCd00002Czr(userId);
						bean.setSsgx(ssgx);
						resultList.add(bean);
					}catch(Exception e){
						logger.error(e.getMessage());
						throw e;
					}finally{
						bean = null;
					}
				}
			}
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}finally{
			if(null != is){
				try{
					is.close();
				}catch(Exception e){}
			}
			if(null != wb){
				try{
					wb.close();
				}catch(Exception e){}
			}
		}
		return resultList;
	}

	@Override
	public Pgt00360 GetImportCommand(ArrayList<Pgt00360> list) throws Exception {
		return t00360Dao.GetImportCommand(list);
	}

	@Override
	public OutputStream ExportT00360Error(ArrayList<Pgt00360> list) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;
		
		try{
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的建筑面积修正数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);
			
			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "建筑面积下限", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "建筑面积上限", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "错误信息", wcf);
            sheet.addCell(label);
			
			WritableFont wf1 = new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);
			for(int i = 0;i < list.size();i++){
				label = Excel.myLable(0, i+1, list.get(i).getSzqy(), list.get(i).getCd00001Szqy(), wcf1);
				sheet.addCell(label);
				label = Excel.myLable(1, i+1, list.get(i).getFwlx(), list.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = new Label(2, i+1, list.get(i).getJzmjMin().toString());
				sheet.addCell(label);
				label = new Label(3, i+1, list.get(i).getJzmjMax().toString());
				sheet.addCell(label);
				label = new Label(4, i+1, list.get(i).getXzxs().toString());
				sheet.addCell(label);
				label = new Label(5, i+1, list.get(i).getImpErrorMsg());
    			sheet.addCell(label);
			}
			workbook.write();
		}catch(Exception e){
			if(null != strBufResult){
				try{
					strBufResult.close();
				}catch(Exception e1){}
			}
			throw e;
		}finally{
			if(null != workbook){
				try{
					workbook.close();
				}catch(Exception e){}
			}
		}
		return strBufResult;
	}
}
