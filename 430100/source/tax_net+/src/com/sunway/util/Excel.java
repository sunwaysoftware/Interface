/**
 * 
 */
package com.sunway.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import com.opensymphony.xwork2.ActionContext;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgv00304;
import com.sunway.vo.Pgv00321;
import com.sunway.vo.Pgv00322;
import com.sunway.vo.Pgv00323;
import com.sunway.vo.Pgv00306;
import com.sunway.vo.Pgv00320;
import com.sunway.vo.Pgv00353;
import com.sunway.vo.Pgv00355;
import com.sunway.vo.Pgv00356;
import com.sunway.vo.Pgv00357;
import com.sunway.vo.Pgv00361;
import com.sunway.vo.Pgv00362;
import com.sunway.vo.Pgv02020;
import com.sunway.vo.Pgv02050;
import com.sunway.vo.Pgv02052;
import com.sunway.vo.Pgv02053;
import com.sunway.vo.Pgv02054;
import com.sunway.vo.Pgv02055;
import com.sunway.vo.Pgv02056;
import com.sunway.vo.Pgv02057;
import com.sunway.vo.Pgv02058;
import com.sunway.vo.Pgv02060;
import com.sunway.vo.Pgv02063;
import com.sunway.office.ExcelUtil;
import com.sunway.util.SessionCtrl;

/**
 * 
 * Excel操作
 * 
 * @author Andy.Gao
 *
 */
public class Excel implements Serializable {
	static Logger logger = LogManager.getLogger(Excel.class);
	private static final long serialVersionUID = 1466017959093917212L;
	private static SessionCtrl sessionCtrl;
	
	private static void chkRowNum(int rowSheet) throws Exception{
		if (rowSheet>2001){
			Exception e1 = new Exception("你导入的模板已经超过最大导入条数2000条，请分多个模板导入！");
			throw e1;
		}		
	}
	
	//得到模板的文件路径
	public static String excelPath(String fileName)	{
		String root_path = ServletActionContext.getServletContext().getRealPath("/");
		root_path = root_path.replace('\\', '/');
		return root_path + "/reports/" + fileName;
	}	
	
	/**
	 * 得到标题的样式
	 * @param value
	 * @return
	 * @throws WriteException 
	 */
	public static WritableCellFormat getExcelTitleStyle() throws WriteException {
	WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
	        WritableCellFormat wcf = new WritableCellFormat(wf); 
	        wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
	        wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
	        wcf.setBackground(Colour.GREEN);
	        return wcf;
	}

	/**
	 * 导入“挂牌数据”
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<Pgv00304> importDataGpsj(String sourceFile, String userId) {
		ArrayList<Pgv00304> resultList = new ArrayList<Pgv00304>();
		Sheet sht = null;
		String tmpStr = Constant.STRING_EMPTY;
		String qtxzs = Constant.STRING_EMPTY;
		String qtxz = Constant.STRING_EMPTY;
		try {
			InputStream is = new FileInputStream(sourceFile);
			Workbook wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0)
				sht = wb.getSheet(0);
			else
				return resultList;
			int colSheet = sht.getColumns();
			int rowSheet = sht.getRows();
			for (int i = 10; i < rowSheet; i++) {
				Pgv00304 bean = new Pgv00304();
				try {
					// 税务编码/证件号码
					bean.setSwid(sht.getCell(0, i).getContents());
					// 纳税人名称
					bean.setNsrmc(sht.getCell(1, i).getContents());
					// //联系电话
					sht.getCell(2, i).getContents();
					// 交易类型
					if (!CheckUtil.chkEmpty(sht.getCell(3, i).getContents()))
						bean.setCd00001Jylx(sht.getCell(3, i).getContents().substring(0, 5));
					// 建筑结构
					if (!CheckUtil.chkEmpty(sht.getCell(4, i).getContents()))
						bean.setCd00001Jzjg(sht.getCell(4, i).getContents().substring(0, 5));
					// 有无电梯
					if (!CheckUtil.chkEmpty(sht.getCell(5, i).getContents()))
						bean.setYwdt(ConvertUtil.toBoolean(sht.getCell(5, i).getContents().substring(0, 1)));
					else
						bean.setYwdt(false);
					// 总楼层
					if (!CheckUtil.chkEmpty(sht.getCell(6, i).getContents()))
						bean.setZlc(ConvertUtil.toShort(sht.getCell(6, i).getContents()));
					else
						bean.setZlc(Short.valueOf("0"));
					// 建筑面积
					if (!CheckUtil.chkEmpty(sht.getCell(7, i).getContents()))
						bean.setJzmj(ConvertUtil.toDouble(sht.getCell(7, i).getContents()));
					else
						bean.setJzmj(0.0);
					// 房屋朝向
					if (!CheckUtil.chkEmpty(sht.getCell(8, i).getContents()))
						bean.setCd00001Fwcx(sht.getCell(8, i).getContents().substring(0, 5));
					// 采光状况
					if (!CheckUtil.chkEmpty(sht.getCell(9, i).getContents()))
						bean.setCd00001Cgzk(sht.getCell(9, i).getContents().substring(0, 5));
					// 所在楼层
					if (!CheckUtil.chkEmpty(sht.getCell(10, i).getContents()))
						bean.setSzlc(ConvertUtil.toShort(sht.getCell(10, i).getContents()));
					else
						bean.setSzlc(Short.valueOf("0"));
					// 座落地址
					bean.setFwtdzl(sht.getCell(11, i).getContents());
					// 评税价格
					// if(!CheckUtil.chkEmpty(sht.getCell(12,i).getContents()))
					// bean.setPgjg(ConvertUtil.toDouble(sht.getCell(12,i).getContents()));
					// else
					// bean.setPgjg(0.0);
					// 交易时间
					if (!CheckUtil.chkEmpty(sht.getCell(13, i).getContents()))
						bean.setGpsj(
								new java.sql.Date(ConvertUtil.toUtilDate(sht.getCell(13, i).getContents()).getTime()));
					// 小区编码
					if (!CheckUtil.chkEmpty(sht.getCell(14, i).getContents()))
						bean.setCd00352Xqdm(sht.getCell(14, i).getContents());
					else
						bean.setCd00352Xqdm("xqid");
					// 小区名称
					bean.setXqmc(sht.getCell(15, i).getContents());
					// 户型
					bean.setHx(sht.getCell(16, i).getContents());
					// 自报价
					if (!CheckUtil.chkEmpty(sht.getCell(17, i).getContents()))
						bean.setZbjg(ConvertUtil.toDouble(sht.getCell(17, i).getContents()));
					else
						bean.setZbjg(0.0);
					// 是否中介
					if (!CheckUtil.chkEmpty(sht.getCell(18, i).getContents())) {
						tmpStr = sht.getCell(18, i).getContents().substring(0, 1);
						if ("0".equals(tmpStr))
							bean.setSfzj(false);
						else
							bean.setSfzj(true);
					}
					// 挂牌时间
					if (!CheckUtil.chkEmpty(sht.getCell(19, i).getContents()))
						bean.setGpsj(
								new java.sql.Date(ConvertUtil.toUtilDate(sht.getCell(19, i).getContents()).getTime()));
					// 房屋类型
					if (!CheckUtil.chkEmpty(sht.getCell(20, i).getContents()))
						bean.setCd00001Fwlx(sht.getCell(20, i).getContents().substring(0, 5));
					if (colSheet > 21) {
						for (int j = 21; j < colSheet; j++) {
							// 其他修正
							if (!CheckUtil.chkEmpty(sht.getCell(j, i).getContents())) {
								qtxz = sht.getCell(j, i).getContents().substring(0, 5) + Constant.STRING_COMMA;
								qtxzs += qtxz;
							}

						}
						bean.setQtids(qtxzs);
					}
					bean.setCd00002Czr(userId);
					resultList.add(bean);
				} catch (Exception e) {
					logger.error(e.getMessage());
				} finally {
					bean = null;
				}
			}
			wb.close();
			is.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			//
		}
		return resultList;
	}

	/**
	 * 全面评估导入 by Light
	 */
	public static ArrayList<Pgv00320> importDataQMPGLR(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv00320> resultList = new ArrayList<Pgv00320>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv00320 bean = new Pgv00320();
					try {
						// A.行政区域
						bean.setSzqy(CheckUtil.chkTrim(sht.getCell(0, i).getContents()));
						// B.小区名称
						bean.setXqnm(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// C.国土证号
						bean.setFczh(CheckUtil.chkTrim(sht.getCell(2, i).getContents()));
						// D.纳税人名称
						bean.setNsrmc(CheckUtil.chkTrim(sht.getCell(3, i).getContents()));
						// E.证件类型
						bean.setZjlx(CheckUtil.chkTrim(sht.getCell(4, i).getContents()));
						// F.证件号码
						bean.setZjhm(CheckUtil.chkTrim(sht.getCell(5, i).getContents()));
						// G.联系电话
						bean.setLxdh(CheckUtil.chkTrim(sht.getCell(6, i).getContents()));
						// H.测量号
						bean.setClh(CheckUtil.chkTrim(sht.getCell(7, i).getContents()));
						// I.房屋坐落
						bean.setZcdzl(CheckUtil.chkTrim(sht.getCell(8, i).getContents()));
						// J.幢号
						bean.setZh(CheckUtil.chkTrim(sht.getCell(9, i).getContents()));
						// K.单元号
						bean.setDyh(CheckUtil.chkTrim(sht.getCell(10, i).getContents()));
						// L.房号
						bean.setFh(CheckUtil.chkTrim(sht.getCell(11, i).getContents()));
						// M.建筑面积
						bean.setJzmj(ConvertUtil.toDouble(CheckUtil.chkTrim(sht.getCell(12, i).getContents())));
						// N.总楼层
						bean.setZlc(ConvertUtil.toInteger(CheckUtil.chkTrim(sht.getCell(13, i).getContents())));
						// O.所在楼层
						bean.setSzlc(ConvertUtil.toInteger(CheckUtil.chkTrim(sht.getCell(14, i).getContents())));
						// P.房屋类型
						bean.setFwlx(CheckUtil.chkTrim(sht.getCell(15, i).getContents()));
						// Q.建成年份
						bean.setJcnf(CheckUtil.chkTrim(sht.getCell(16, i).getContents()));
						// R.建筑结构
						bean.setJzjg(CheckUtil.chkTrim(sht.getCell(17, i).getContents()));
						// S.规划用途
						bean.setGhyt(CheckUtil.chkTrim(sht.getCell(18, i).getContents()));
						// T.交易类型
						bean.setJylx(CheckUtil.chkTrim(sht.getCell(19, i).getContents()));
						// U.核定价格
						bean.setHdjg(ConvertUtil.toDouble(CheckUtil.chkTrim(sht.getCell(20, i).getContents())));
						// V.综合修正
						bean.setZhxz(CheckUtil.chkTrim(sht.getCell(21, i).getContents()));
						// W.备注
						bean.setNote(CheckUtil.chkTrim(sht.getCell(22, i).getContents()));

						bean.setCd00002Czr(userId);
						bean.setCd00001Ssgx(ssgx);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}
	
	/**
	 * 全面评估导入 by Light
	 */
	public static ArrayList<Pgv02060> importDataKBSLKSY(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv02060> resultList = new ArrayList<Pgv02060>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				int columnSheet = sht.getColumns();
				int n = 0;
				for (int i = 1; i < rowSheet; i++) {
					Pgv02060 bean = new Pgv02060();
					n = 0;
					try {
						// A.行政区域ExcelUtil.excelIsEmpty(dyh, "单元号", i)
						bean.setSzqy(ExcelUtil.excelIsEmpty(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()), "行政区域", i));
						// B.小区代码
						bean.setXqdmh(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()));
						// C.小区名称
						bean.setXqnm(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()));	
						// D.测量号
						bean.setClh(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()));
						// D.房屋坐落
						bean.setZcdzl(ExcelUtil.excelIsEmpty(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()), "房屋坐落", i));
						// E.幢号
						bean.setZh(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()));
						// F.单元号
						bean.setDyh(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()));
						// G.房号
						bean.setBwjfh(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()));
						// H.房屋类型
						bean.setFwlx(ExcelUtil.excelIsEmpty(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()), "房屋类型", i));
						// I.建成年份
						bean.setJcnf(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()));
						// J.建筑结构
						bean.setJzjg(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()));
						// K.总楼层
						bean.setCs(ExcelUtil.excelIntIsEmpty(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()), "总楼层", i));
						// L.所在楼层
						bean.setSzcs(ExcelUtil.excelIsEmpty(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()), "所在楼层", i));
						// M.面宽
						bean.setMk(ConvertUtil.toDouble(CheckUtil.chkTrim(sht.getCell(n++, i).getContents())));
						// N.进深
						bean.setJs(ConvertUtil.toDouble(CheckUtil.chkTrim(sht.getCell(n++, i).getContents())));
						// O.交易时间
						bean.setJysj(ExcelUtil.excelDateIsEmpty(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()), "交易时间", i));
						// P 交易价格
						bean.setJyjg(ConvertUtil.toBigDecimal(CheckUtil.chkTrim(sht.getCell(n++, i).getContents())));
						// O.备注
						bean.setNote(CheckUtil.chkTrim(sht.getCell(n++, i).getContents()));
						// V.综合修正
						StringBuffer tempZhxz = new StringBuffer();
						for (int j = n; j < columnSheet; j++) {
							String tempNm = sht.getCell(j, 0).getContents();
							String tempVal = sht.getCell(j, i).getContents();
							if (!CheckUtil.chkEmpty(tempNm) && !CheckUtil.chkEmpty(tempVal)) {
								tempZhxz.append(tempNm + "," + tempVal + ";");
							}
						}
						
						bean.setZhxz(tempZhxz.toString());
						bean.setCd00002Czr(userId);
						bean.setCd00001Ssgx(ssgx);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}
	
	/**
	 * 全面评估导入 by Light
	 */
	public static ArrayList<Pgv02020> importDataQMPGLRSY(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv02020> resultList = new ArrayList<Pgv02020>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				int columnSheet = sht.getColumns();
				for (int i = 1; i < rowSheet; i++) {
					Pgv02020 bean = new Pgv02020();
					try {
						// A.行政区域ExcelUtil.excelIsEmpty(dyh, "单元号", i)
						bean.setSzqy(ExcelUtil.excelIsEmpty(CheckUtil.chkTrim(sht.getCell(0, i).getContents()), "行政区域", i));
						// B.小区代码
						bean.setXqdmh(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// C.小区名称
						bean.setXqnm(CheckUtil.chkTrim(sht.getCell(2, i).getContents()));
						// D.测量号
						bean.setClh(CheckUtil.chkTrim(sht.getCell(3, i).getContents()));
						// E.房屋坐落
						bean.setZcdzl(ExcelUtil.excelIsEmpty(CheckUtil.chkTrim(sht.getCell(4, i).getContents()), "房屋坐落", i));
						// F.幢号
						bean.setZh(CheckUtil.chkTrim(sht.getCell(5, i).getContents()));
						// G.单元号
						bean.setDyh(CheckUtil.chkTrim(sht.getCell(6, i).getContents()));
						// H.房号
						bean.setBwjfh(CheckUtil.chkTrim(sht.getCell(7, i).getContents()));
						// I.房屋类型
						bean.setFwlx(ExcelUtil.excelIsEmpty(CheckUtil.chkTrim(sht.getCell(8, i).getContents()), "房屋类型", i));
						// J.建成年份
						bean.setJcnf(CheckUtil.chkTrim(sht.getCell(9, i).getContents()));
						// K.建筑结构
						bean.setJzjg(CheckUtil.chkTrim(sht.getCell(10, i).getContents()));
						// L.总楼层
						bean.setCs(ExcelUtil.excelIntIsEmpty(CheckUtil.chkTrim(sht.getCell(11, i).getContents()), "总楼层", i));
						// M.所在楼层
						bean.setSzcs(ExcelUtil.excelIsEmpty(CheckUtil.chkTrim(sht.getCell(12, i).getContents()), "所在楼层", i));
						// N.面宽
						bean.setMk(ConvertUtil.toDouble(CheckUtil.chkTrim(sht.getCell(13, i).getContents())));
						// O.进深
						bean.setJs(ConvertUtil.toDouble(CheckUtil.chkTrim(sht.getCell(14, i).getContents())));
						// P.备注
						bean.setNote(CheckUtil.chkTrim(sht.getCell(15, i).getContents()));
						// V.综合修正
						StringBuffer tempZhxz = new StringBuffer();
						for (int j = 16; j < columnSheet; j++) {
							String tempNm = sht.getCell(j, 0).getContents();
							String tempVal = sht.getCell(j, i).getContents();
							if (!CheckUtil.chkEmpty(tempNm) && !CheckUtil.chkEmpty(tempVal)) {
								tempZhxz.append(tempNm + "," + tempVal + ";");
							}
						}
						
						bean.setZhxz(tempZhxz.toString());
						bean.setCd00002Czr(userId);
						bean.setCd00001Ssgx(ssgx);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}

	/**
	 * 导出格式错误的全面评估录入 by Light
	 */
	public static OutputStream exportDataQMPGLR(ArrayList<Pgv00320> v00320List) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "行政区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "小区名称", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "国土证号", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "纳税人名称", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "证件类型", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "证件号码", wcf);
			sheet.addCell(label);
			label = new Label(6, 0, "联系电话", wcf);
			sheet.addCell(label);
			label = new Label(7, 0, "测量号", wcf);
			sheet.addCell(label);
			label = new Label(8, 0, "房屋坐落", wcf);
			sheet.addCell(label);
			label = new Label(9, 0, "幢号", wcf);
			sheet.addCell(label);
			label = new Label(10, 0, "单元号", wcf);
			sheet.addCell(label);
			label = new Label(11, 0, "房号", wcf);
			sheet.addCell(label);
			label = new Label(12, 0, "建筑面积", wcf);
			sheet.addCell(label);
			label = new Label(13, 0, "总楼层", wcf);
			sheet.addCell(label);
			label = new Label(14, 0, "所在楼层", wcf);
			sheet.addCell(label);
			label = new Label(15, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(16, 0, "建成年份", wcf);
			sheet.addCell(label);
			label = new Label(17, 0, "建筑结构", wcf);
			sheet.addCell(label);
			label = new Label(18, 0, "规划用途", wcf);
			sheet.addCell(label);
			label = new Label(19, 0, "交易类型", wcf);
			sheet.addCell(label);
			label = new Label(20, 0, "核定价格", wcf);
			sheet.addCell(label);
			label = new Label(21, 0, "综合修正", wcf);
			sheet.addCell(label);
			label = new Label(22, 0, "备注", wcf);
			sheet.addCell(label);
			label = new Label(23, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v00320List.size(); i++) {
				label = myDZLable(0, i + 1, v00320List.get(i).getSzqy(), v00320List.get(i).getCd00001Szqy(), wcf1,
						"(不存在)");
				sheet.addCell(label);
				label = myDZLable(1, i + 1, v00320List.get(i).getXqnm(), v00320List.get(i).getCd00352Xqdm(), wcf1,
						"(不存在)");
				sheet.addCell(label);
				label = new Label(2, i + 1, v00320List.get(i).getFczh());
				sheet.addCell(label);
				label = new Label(3, i + 1, v00320List.get(i).getNsrmc());
				sheet.addCell(label);
				label = myLable(4, i + 1, v00320List.get(i).getZjlx(), v00320List.get(i).getCd00001Zjlx(), wcf1);
				sheet.addCell(label);
				label = new Label(5, i + 1, v00320List.get(i).getZjhm());
				sheet.addCell(label);
				label = new Label(6, i + 1, v00320List.get(i).getLxdh());
				sheet.addCell(label);
				label = new Label(7, i + 1, v00320List.get(i).getClh());
				sheet.addCell(label);
				label = new Label(8, i + 1, v00320List.get(i).getZcdzl());
				sheet.addCell(label);
				label = new Label(9, i + 1, v00320List.get(i).getZh());
				sheet.addCell(label);
				label = new Label(10, i + 1, v00320List.get(i).getDyh());
				sheet.addCell(label);
				label = new Label(11, i + 1, v00320List.get(i).getFh());
				sheet.addCell(label);
				label = new Label(12, i + 1, v00320List.get(i).getJzmj().toString());
				sheet.addCell(label);
				label = new Label(13, i + 1, v00320List.get(i).getZlc().toString());
				sheet.addCell(label);
				label = new Label(14, i + 1, v00320List.get(i).getSzlc().toString());
				sheet.addCell(label);
				label = myLable(15, i + 1, v00320List.get(i).getFwlx(), v00320List.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = new Label(16, i + 1, v00320List.get(i).getJcnf());
				sheet.addCell(label);
				label = myLable(17, i + 1, v00320List.get(i).getJzjg(), v00320List.get(i).getCd00001Jzjg(), wcf1);
				sheet.addCell(label);
				label = myLable(18, i + 1, v00320List.get(i).getGhyt(), v00320List.get(i).getCd00001Ghyt(), wcf1);
				sheet.addCell(label);
				label = myLable(19, i + 1, v00320List.get(i).getJylx(), v00320List.get(i).getCd00001jylx(), wcf1);
				sheet.addCell(label);
				label = new Label(20, i + 1, v00320List.get(i).getHdjg().toString());
				sheet.addCell(label);
				label = myLable(21, i + 1, v00320List.get(i).getZhxz(), v00320List.get(i).getZhxzId(), wcf1);
				sheet.addCell(label);
				label = new Label(22, i + 1, v00320List.get(i).getNote());
				sheet.addCell(label);
				label = new Label(23, i + 1, v00320List.get(i).getImpErrorMsg());
				sheet.addCell(label);

			}
			workbook.write();
		} catch (Exception e) {
			logger.error(e.getMessage());
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}
	
	/**
	 * 导出格式错误的全面评估录入 by Light
	 */
	public static OutputStream exportDataQMPGLRSY(ArrayList<Pgv02020> v02020List) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);
			int j = 0;
			label = new Label(j++, 0, "行政区域", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "小区编码", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "小区名称", wcf);
			sheet.addCell(label);		
			label = new Label(j++, 0, "测量号", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "坐落地址", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "幢号", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "单元号", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "房号", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "建成年份", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "建筑结构", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "总楼层", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "所在楼层", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "面宽", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "进深", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "备注", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "综合修正", wcf);
			sheet.addCell(label);			
			label = new Label(j++, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v02020List.size(); i++) {
				j = 0;
				label = myDZLable(j++, i + 1, v02020List.get(i).getSzqy(), v02020List.get(i).getCd00001Szqy(), wcf1,
						"(不存在)");
				sheet.addCell(label);
				label = myDZLable(j++, i + 1, v02020List.get(i).getXqdmh(), v02020List.get(i).getCd02050Xqdm(), wcf1,
						"(不存在)");
				sheet.addCell(label);
				label = myDZLable(j++, i + 1, v02020List.get(i).getXqnm(), v02020List.get(i).getCd02050Xqdm(), wcf1,
						"(不存在)");
				sheet.addCell(label);	
				label = new Label(j++, i + 1, v02020List.get(i).getClh());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02020List.get(i).getZcdzl());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02020List.get(i).getZh());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02020List.get(i).getDyh());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02020List.get(i).getBwjfh());
				sheet.addCell(label);
				label = myLable(j++, i + 1, v02020List.get(i).getFwlx(), v02020List.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02020List.get(i).getJcnf());
				sheet.addCell(label);
				label = myLable(j++, i + 1, v02020List.get(i).getJzjg(), v02020List.get(i).getCd00001Jzjg(), wcf1);
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02020List.get(i).getCs().toString());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02020List.get(i).getSzcs().toString());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02020List.get(i).getMk().toString());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02020List.get(i).getJs().toString());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02020List.get(i).getNote());
				sheet.addCell(label);
				label = myLable(j++, i + 1, v02020List.get(i).getZhxz(), v02020List.get(i).getZhxzId(), wcf1);
				sheet.addCell(label);				
				label = new Label(j++, i + 1, v02020List.get(i).getImpErrorMsg());
				sheet.addCell(label);

			}
			workbook.write();
		} catch (Exception e) {
			logger.error(e.getMessage());
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}
	
	/**
	 * 导出格式错误的全面评估录入 by Light
	 */
	public static OutputStream exportDataKBSLKSY(ArrayList<Pgv02060> v02060List) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);
            int j = 0;
			label = new Label(j++, 0, "行政区域", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "小区编码", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "小区名称", wcf);
			sheet.addCell(label);	
			label = new Label(j++, 0, "测量号", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "坐落地址", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "幢号", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "单元号", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "房号", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "建成年份", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "建筑结构", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "总楼层", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "所在楼层", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "面宽", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "进深", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "交易时间", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "交易价格", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "备注", wcf);
			sheet.addCell(label);
			label = new Label(j++, 0, "综合修正", wcf);
			sheet.addCell(label);			
			label = new Label(j++, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v02060List.size(); i++) {
				j = 0;
				label = myDZLable(j++, i + 1, v02060List.get(i).getSzqy(), v02060List.get(i).getCd00001Szqy(), wcf1,
						"(不存在)");
				sheet.addCell(label);
				label = myDZLable(j++, i + 1, v02060List.get(i).getXqdmh(), v02060List.get(i).getCd02050Xqdm(), wcf1,
						"(不存在)");
				sheet.addCell(label);
				label = myDZLable(j++, i + 1, v02060List.get(i).getXqnm(), v02060List.get(i).getCd02050Xqdm(), wcf1,
						"(不存在)");
				sheet.addCell(label);	
				label = new Label(j++, i + 1, v02060List.get(i).getClh());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02060List.get(i).getZcdzl());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02060List.get(i).getZh());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02060List.get(i).getDyh());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02060List.get(i).getBwjfh());
				sheet.addCell(label);
				label = myLable(j++, i + 1, v02060List.get(i).getFwlx(), v02060List.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02060List.get(i).getJcnf());
				sheet.addCell(label);
				label = myLable(j++, i + 1, v02060List.get(i).getJzjg(), v02060List.get(i).getCd00001Jzjg(), wcf1);
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02060List.get(i).getCs().toString());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02060List.get(i).getSzcs().toString());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02060List.get(i).getMk().toString());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02060List.get(i).getJs().toString());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02060List.get(i).getJysj().toString());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02060List.get(i).getJyjg().toString());
				sheet.addCell(label);
				label = new Label(j++, i + 1, v02060List.get(i).getNote());
				sheet.addCell(label);
				label = myLable(j++, i + 1, v02060List.get(i).getZhxz(), v02060List.get(i).getZhxzId(), wcf1);
				sheet.addCell(label);				
				label = new Label(j++, i + 1, v02060List.get(i).getImpErrorMsg());
				sheet.addCell(label);

			}
			workbook.write();
		} catch (Exception e) {
			logger.error(e.getMessage());
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}

	/**
	 * 导入“采集数据”
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<Pgv00357> importDataSjcj(String sourceFile, String userId, String ssgx) {
		ArrayList<Pgv00357> resultList = new ArrayList<Pgv00357>();
		Sheet sht = null;

		try {
			InputStream is = new FileInputStream(sourceFile);
			Workbook wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = sht.getRows();
				for (int i = 1; i < rowSheet; i++) {
					Pgv00357 bean = new Pgv00357();

					try {
						// A.所在区域
						bean.setSzqy(sht.getCell(0, i).getContents());
						// B.产权人或联系人
						bean.setNsrmc(sht.getCell(1, i).getContents());
						// C.证件类型
						bean.setZjlx(sht.getCell(2, i).getContents());
						// D.证件号码
						bean.setCd00301Swid(sht.getCell(3, i).getContents());
						// E.座落地址
						bean.setZcdzl(sht.getCell(4, i).getContents());
						// F.门牌号码
						bean.setBwjfh(sht.getCell(5, i).getContents());
						// G.测量号
						bean.setClh(sht.getCell(6, i).getContents());
						// H.小区名称
						bean.setXqnm(sht.getCell(7, i).getContents());
						// I.所在楼层
						bean.setSzlc(ConvertUtil.toShort(sht.getCell(8, i).getContents()));
						// J.总楼层
						bean.setZlc(sht.getCell(9, i).getContents());
						// K.国土证号
						bean.setFczh(sht.getCell(10, i).getContents());
						// L.交易类型
						bean.setJylx(sht.getCell(11, i).getContents());
						// M.房屋类别
						bean.setFwlx(sht.getCell(12, i).getContents());
						// N.建筑结构
						bean.setJzjg(sht.getCell(13, i).getContents());
						// O.建筑面积(平方米)
						bean.setJzmj(ConvertUtil.toDouble(sht.getCell(14, i).getContents()));
						// P.交易时间
						String t = sht.getCell(15, i).getContents();
						if (!CheckUtil.chkEmpty(t))
							bean.setJysj(new java.sql.Date(ConvertUtil.toUtilDate(t).getTime()));
						else
							bean.setJysj(new java.sql.Date(new Date().getTime()));// 如果为空，取系统当前时间
						// Q.成交价格(元)
						bean.setPgjg(ConvertUtil.toDouble(sht.getCell(16, i).getContents()));
						// R.综合修正
						bean.setZhxz(sht.getCell(17, i).getContents());
						// S.发证日期
						t = sht.getCell(18, i).getContents();
						if (!CheckUtil.chkEmpty(t))
							bean.setDjrq(new java.sql.Date(new Date().getTime()));
						else
							bean.setDjrq(new java.sql.Date(new Date().getTime()));// 如果为空，去系统当前时间
						// T.联系电话
						bean.setLxdh(sht.getCell(19, i).getContents());
						// U.备注
						bean.setNote(sht.getCell(20, i).getContents());
						// 税收管辖
						bean.setCd00001Ssgx(ssgx);
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
					} finally {
						bean = null;
					}
				}
			}
			wb.close();
			is.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {

		}
		return resultList;
	}

	/**
	 * 导出“采集数据”
	 * 
	 * @param gpsjList
	 * @return
	 */
	public static OutputStream exportDataSjcj(ArrayList<Pgv00357> kbslkList) {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream();
		// 创建excel对象
		Label label;
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf.setBackground(Colour.GREEN);
			int j = 0;
			// 写入表头
			// D.门牌号码
			label = new Label(j++, 0, "所在区域", wcf);
			sheet.addCell(label);
			// D.所在区域
			label = new Label(j++, 0, "产权人或联系人", wcf);
			sheet.addCell(label);
			// A.产权人或联系人
			label = new Label(j++, 0, "证件类型", wcf);
			sheet.addCell(label);
			// A.产权人或联系人
			label = new Label(j++, 0, "证件号码", wcf);
			sheet.addCell(label);
			// B.证件号码
			label = new Label(j++, 0, "楼房地址", wcf);
			sheet.addCell(label);
			// C.座落地址
			label = new Label(j++, 0, "单元及房号", wcf);
			sheet.addCell(label);
			// D.测量号
			label = new Label(j++, 0, "测量号", wcf);
			sheet.addCell(label);
			// D.有无架空层
			// label = new Label(j++, 0, "有无架空层" ,wcf);
			// sheet.addCell(label);
			// E.小区名称
			label = new Label(j++, 0, "小区名称", wcf);
			sheet.addCell(label);
			// K.建筑结构
			label = new Label(j++, 0, "所在楼层", wcf);
			sheet.addCell(label);
			// L.所在楼层
			label = new Label(j++, 0, "总楼层", wcf);
			sheet.addCell(label);
			// F.总楼层
			label = new Label(j++, 0, "国土证号", wcf);
			sheet.addCell(label);
			// //G.有无电梯
			// label = new Label(j++, 0, "有无电梯" ,wcf);
			// sheet.addCell(label);
			// H.国土证号
			label = new Label(j++, 0, "交易类型", wcf);
			sheet.addCell(label);
			// I.交易类型
			label = new Label(j++, 0, "房屋类别", wcf);
			sheet.addCell(label);
			// J.房屋类别
			label = new Label(j++, 0, "建筑结构", wcf);
			sheet.addCell(label);

			// M.建筑面积(平方米)
			label = new Label(j++, 0, "建筑面积(平方米)", wcf);
			sheet.addCell(label);
			// N.交易时间
			label = new Label(j++, 0, "交易时间", wcf);
			sheet.addCell(label);
			// O.成交价格(元)
			label = new Label(j++, 0, "成交价格(元)", wcf);
			sheet.addCell(label);
			// P.房屋朝向
			label = new Label(j++, 0, "综合修正", wcf);
			sheet.addCell(label);
			// P.房屋朝向
			label = new Label(j++, 0, "发证日期", wcf);
			sheet.addCell(label);
			// 备注
			label = new Label(j++, 0, "错误信息", wcf);
			sheet.addCell(label);
			// 定义错误数据样式
			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);
			// 写入数据
			for (int i = 0; i < kbslkList.size(); i++) {
				j = 0;
				// D.所在区域
				label = new Label(j++, i + 1, kbslkList.get(i).getSzqy());
				sheet.addCell(label);
				// A.产权人或联系人
				label = new Label(j++, i + 1, kbslkList.get(i).getNsrmc());
				sheet.addCell(label);
				// B.证件类型
				label = new Label(j++, i + 1, kbslkList.get(i).getZjlx());
				sheet.addCell(label);
				// B.证件号码
				label = new Label(j++, i + 1, kbslkList.get(i).getCd00301Swid());
				sheet.addCell(label);
				// C.座落地址
				label = new Label(j++, i + 1, kbslkList.get(i).getZcdzl());
				sheet.addCell(label);
				// D.门牌号码
				label = new Label(j++, i + 1, kbslkList.get(i).getBwjfh());
				sheet.addCell(label);
				// D.测量号
				label = new Label(j++, i + 1, kbslkList.get(i).getClh());
				sheet.addCell(label);
				// D.有无架空层
				// label = new Label(j++, i+1,
				// writeYwdt(kbslkList.get(i).getYwjkc()));
				// sheet.addCell(label);
				// E.小区名称
				label = myDZLable(j++, i + 1, kbslkList.get(i).getXqnm(), kbslkList.get(i).getCd00352Xqdm(), wcf1,
						"(不存在)");
				sheet.addCell(label);
				// L.所在楼层
				label = new Label(j++, i + 1, kbslkList.get(i).getSzlc().toString());
				sheet.addCell(label);
				// F.总楼层
				label = new Label(j++, i + 1, kbslkList.get(i).getZlc().toString());
				sheet.addCell(label);
				// G.有无电梯
				// label = new Label(j++, i+1,
				// writeYwdt(kbslkList.get(i).getYwdt()));
				// sheet.addCell(label);
				// H.国土证号
				label = new Label(j++, i + 1, kbslkList.get(i).getFczh());
				sheet.addCell(label);
				// I.交易类型
				label = myLable(j++, i + 1, kbslkList.get(i).getJylx(), kbslkList.get(i).getCd00001Jylx(), wcf1);
				sheet.addCell(label);
				// J.房屋类别
				label = myLable(j++, i + 1, kbslkList.get(i).getFwlx(), kbslkList.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				// K.建筑结构
				label = myLable(j++, i + 1, kbslkList.get(i).getJzjg(), kbslkList.get(i).getCd00001Jzjg(), wcf1);
				sheet.addCell(label);
				// M.建筑面积(平方米)
				label = new Label(j++, i + 1, kbslkList.get(i).getJzmj().toString());
				sheet.addCell(label);
				// N.交易时间
				label = new Label(j++, i + 1, kbslkList.get(i).getJysj().toString());
				sheet.addCell(label);
				// O.成交价格(元)
				label = new Label(j++, i + 1, kbslkList.get(i).getPgjg().toString());
				sheet.addCell(label);
				// P.综合修正
				label = myLable(j++, i + 1, kbslkList.get(i).getZhxz(), kbslkList.get(i).getZhxzId(), wcf1);
				sheet.addCell(label);
				// N.登记日期
				label = new Label(j++, i + 1, kbslkList.get(i).getDjrq().toString());
				sheet.addCell(label);
				// 错误信息
				label = new Label(j++, i + 1, kbslkList.get(i).getNote().toString());
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			// logger.error(e.getMessage());
		}
		return strBufResult;
	}

	/**
	 * 从excel中读取有无电梯
	 * 
	 * @param ywdt
	 * @return
	 */
	// private static Boolean readYwdt(String ywdt){
	// Boolean bool = false;
	// try {
	// if (!CheckUtil.chkEmpty(ywdt) && ywdt.equals("有")) {
	// bool = true;
	// }
	// } catch (Exception e) {
	// //logger.error(e.getMessage());
	// }
	// return bool;
	// }
	/**
	 * 向ecxel写入有无电梯
	 * 
	 * @param ywdt
	 * @return
	 */
	private static String writeYwdt(Boolean ywdt) {
		String bool = "无";
		try {
			bool = ywdt ? "有" : "无";
		} catch (Exception e) {
			// logger.error(e.getMessage());
		}
		return bool;
	}

	/**
	 * 自定义生产Label
	 * 
	 * @param c
	 * @param r
	 * @param cont
	 * @param flag
	 *            标识
	 * @param cf
	 * @return
	 */
	public static Label myLable(int c, int r, String cont, String flag, CellFormat cf) {
		Label label = null;
		try {
			label = (CheckUtil.chkNull(flag).equals("N")) ? new Label(c, r, CheckUtil.chkNull(cont) + "(类型错误)", cf)
					: new Label(c, r, cont);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return label;
	}

	/**
	 * 自定义生产Label，带错误信息
	 * 
	 * @param c
	 * @param r
	 * @param cont
	 * @param flag
	 *            标识
	 * @param cf
	 * @param errorMsg
	 * @return
	 */
	private static Label myDZLable(int c, int r, String cont, String flag, CellFormat cf, String errorMsg) {
		Label label = null;
		try {
			label = (CheckUtil.chkNull(flag).equals("N")) ? new Label(c, r, cont + errorMsg, cf) : new Label(c, r, cont);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return label;
	}

	/**
	 * 解析通用Excel文件
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<ExcelBean> resolveExcel(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<ExcelBean> resultList = new ArrayList<ExcelBean>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				// 有效行数
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);

				for (int i = 1; i < rowSheet; i++) {
					ExcelBean bean = new ExcelBean();
					try {
						// A. 所在区域
						bean.setSzqyNm(CheckUtil.chkTrim(sht.getCell(0, i).getContents()));
						// B. 大区名称
						bean.setParentXQNm(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// C. 小区代码号
						bean.setXqdmh(CheckUtil.chkTrim(sht.getCell(2, i).getContents()));
						// D. 小区名称
						bean.setXqNm(CheckUtil.chkTrim(sht.getCell(3, i).getContents()));
						// E. 房屋类别
						bean.setFwlxNm(CheckUtil.chkTrim(sht.getCell(4, i).getContents()));
						// F. 建筑结构
						bean.setJzjgNm(CheckUtil.chkTrim(sht.getCell(5, i).getContents()));
						// G. 建成年份
						bean.setJcnf(CheckUtil.chkTrim(sht.getCell(6, i).getContents()));
						// H. 交易时间
						bean.setJysj(ConvertUtil.toSqlDate(CheckUtil.chkTrim(sht.getCell(7, i).getContents())));
						// I. 基准价值(元/平方米)
						bean.setPfmjg(ExcelUtil.excelDoubleIsEmpty(sht.getCell(8, i).getContents(), "基准价值", i));						

						// E. 备注
						bean.setNote(CheckUtil.chkTrim(sht.getCell(9, i).getContents()));
						bean.setSsgx(ssgx);
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}

	/**
	 * 解析估价分区Excel文件
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<ExcelBean> resolveExcelGJFQ(String sourceFile, String userId, String ssgx)
			throws Exception {
		ArrayList<ExcelBean> resultList = new ArrayList<ExcelBean>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				// int rowSheet = sht.getRows();
				// 有效行数
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);

				for (int i = 1; i < rowSheet; i++) {
					ExcelBean bean = new ExcelBean();
					try {

						// A. 所在区域
						bean.setSzqyNm(CheckUtil.chkTrim(sht.getCell(0, i).getContents()));
						// B. 片区代码号
						bean.setPqdmh(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// C. 大区名称
						bean.setParentXQNm(CheckUtil.chkTrim(sht.getCell(2, i).getContents()));
						// D.小区代码号
						bean.setXqdmh(CheckUtil.chkTrim(sht.getCell(3, i).getContents()));
						// E. 小区名称
						bean.setXqNm(CheckUtil.chkTrim(sht.getCell(4, i).getContents()));
						// F.坐落地址
						String zcdzl = CheckUtil.chkTrim(sht.getCell(5, i).getContents());
						if (null != zcdzl && !"".equals(zcdzl)) {
							bean.setZcdzl(zcdzl);
						} else {
							throw new Exception("请检查第" + i + "数据，坐落地址不可为空");
						}
						// G. 小区地址别名
						bean.setXqdzbm(CheckUtil.chkTrim(sht.getCell(6, i).getContents()));
						bean.setSsgx(ssgx);
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}

		}
		return resultList;
	}

	/**
	 * 解析楼房普查Excel文件
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<ExcelBean> resolveExcelLFPC(String sourceFile, String userId, String ssgx)
			throws Exception {
		ArrayList<ExcelBean> resultList = new ArrayList<ExcelBean>();
		InputStream is = null;
		Workbook wb = null;
		Sheet sht = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				// 有效行数
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);

				for (int i = 1; i < rowSheet; i++) {
					ExcelBean bean = new ExcelBean();
					try {

						// A. 所在区域
						bean.setSzqyNm(CheckUtil.chkTrim(sht.getCell(0, i).getContents()));
						// C. 小区名称
						bean.setXqNm(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// D.楼房地址
						bean.setZcdzl(CheckUtil.chkTrim(sht.getCell(2, i).getContents()));
						// E. 地址别名
						bean.setXqdzbm(CheckUtil.chkTrim(sht.getCell(3, i).getContents()));
						// B. 总楼层
						try {
							String value = CheckUtil.chkTrim(sht.getCell(4, i).getContents());
							bean.setZlc(Short.parseShort(value));
						} catch (Exception e) {
							Exception e1 = new Exception("总楼层格式不正确,请核实第" + i + "条数据");
							throw e1;
						}
						// bean.setZlc(ConvertUtil.toShort(CheckUtil.chkTrim(sht.getCell(4,i).getContents())));
						// //.有无架空层
						// bean.setYwjkc(CheckUtil.chkTrim(sht.getCell(5,i).getContents()).equals("无")?0:1);
						// .测量号
						/*
						 * try{ String value =
						 * CheckUtil.chkTrim(sht.getCell(5,1).getContents());
						 * bean.setClh(String.valueOf(Integer.parseInt(value)).
						 * toString()); }catch(Exception e){ Exception e1 = new
						 * Exception("测量号格式不正确，请核实第"+i+"条数据"); throw e1; }
						 */
						bean.setClh(CheckUtil.chkTrim(sht.getCell(5, i).getContents()));
						// .备注
						bean.setNote(CheckUtil.chkTrim(sht.getCell(6, i).getContents()));
						bean.setSsgx(ssgx);
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw e;
					} finally {
						bean = null;
					}
				}
			}
			wb.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {

				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}

			}
		}
		return resultList;
	}

	/**
	 * 计算实际excel有效行数
	 * 
	 * @param rowSheet
	 * @param sht
	 * @return
	 */
	public static int getValidRowNumbers(int rowSheet, Sheet sht) {
		int validRows = rowSheet;

		for (int i = 0; i < rowSheet; i++) {
			// 自定义三列，非空判断是否存在该条数据
			String firstColumn = sht.getCell(0, i).getContents();
			String secondColumn = sht.getCell(1, i).getContents();
			String thirdColumn = sht.getCell(3, i).getContents();

			if (CheckUtil.chkEmpty(firstColumn) && CheckUtil.chkEmpty(secondColumn)
					&& CheckUtil.chkEmpty(thirdColumn)) {
				validRows--;
			}
		}

		return validRows;
	}

	/**
	 * 导出通用Excel文件
	 * 
	 * @param gpsjList
	 * @return
	 */
	public static OutputStream exportCommonData(ArrayList<ExcelBean> ebList, Integer exportType) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		// 创建excel对象
		Label label;
		WritableWorkbook workbook = null;
		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			// 导出列格式1
			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);
			wcf1.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf1.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf1.setBackground(Colour.GREEN);

			// 导出列格式2
			WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf2 = new WritableCellFormat(wf2);
			wcf2.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf2.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf2.setBackground(Colour.ORANGE);

			// 写入表头

			// A. 所在区域
			label = new Label(0, 0, "所在区域", wcf1);
			sheet.addCell(label);
			// A. 大区名称
			label = new Label(1, 0, "大区名称", wcf1);
			sheet.addCell(label);
			// A. 小区代码号
			label = new Label(2, 0, "小区代码号", wcf1);
			sheet.addCell(label);
			// B. 小区名称
			label = new Label(3, 0, "小区名称", wcf1);
			sheet.addCell(label);
			// F. 房屋类别
			label = new Label(4, 0, "房屋类别", wcf1);
			sheet.addCell(label);
			// H. 建筑结构
			label = new Label(5, 0, "建筑结构", wcf1);
			sheet.addCell(label);
			// H. 建成年份
			label = new Label(6, 0, "建成年份", wcf1);
			sheet.addCell(label);
			// J. 交易时间
			label = new Label(7, 0, "交易时间", wcf1);
			sheet.addCell(label);
			// K.基准价格(元/平方米)
			label = new Label(8, 0, "基准价格(元/平方米)", wcf1);
			sheet.addCell(label);
			// M. 备注
			label = new Label(9, 0, "备注", wcf1);
			sheet.addCell(label);
			// U.错误信息
			label = new Label(10, 0, "错误信息", wcf1);
			sheet.addCell(label);

			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);

			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				// A. 所在区域
				label = SzqyLable(0, i + 1, ebList.get(i).getSzqyNm(), ebList.get(i).getSzqyId(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// C. 大区名称
				label = new Label(1, i + 1, ebList.get(i).getParentXQNm());
				sheet.addCell(label);
				// C. 小区代码号
				label = SzqyLable(2, i + 1, ebList.get(i).getXqdmh(), ebList.get(i).getXqdmhid(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// B. 小区名称
				label = CommonXQLable(3, i + 1, ebList.get(i).getXqNm(), ebList.get(i).getXqId(), ewcf1, exportType,
						"(不存在)");
				sheet.addCell(label);
				// F. 房屋类别
				label = myLable(4, i + 1, ebList.get(i).getFwlxNm(), ebList.get(i).getFwlxId(), ewcf1);
				sheet.addCell(label);
				// H. 建筑结构
				label = myLable(5, i + 1, ebList.get(i).getJzjgNm(), ebList.get(i).getJzjgId(), ewcf1);
				sheet.addCell(label);
				// C. 建成年份
				label = new Label(6, i + 1, ebList.get(i).getJcnf());
				sheet.addCell(label);
				// J. 交易时间
				label = new Label(7, i + 1,
						(ebList.get(i).getJysj() == null) ? "" : ebList.get(i).getJysj().toString());
				sheet.addCell(label);
				// K.基准价格(元/平方米)
				label = new Label(8, i + 1, String.valueOf(ebList.get(i).getPfmjg()).toString());
				sheet.addCell(label);
				// M.备注
				label = new Label(9, i + 1, ebList.get(i).getNote());
				sheet.addCell(label);
				// U.错误信息
				label = new Label(10, i + 1, ebList.get(i).getCwxx());
				sheet.addCell(label);

			}

			workbook.write();
		} catch (Exception e) {
			logger.error(e.getMessage());
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}

	/**
	 * 估价分区导出错误文件
	 * 
	 * @param gpsjList
	 * @return
	 */
	public static OutputStream exportCommonDataGJFQ(ArrayList<ExcelBean> ebList, Integer exportType) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		// 创建excel对象
		Label label;
		WritableWorkbook workbook = null;
		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			// 导出列格式1
			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);
			wcf1.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf1.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf1.setBackground(Colour.GREEN);

			// 导出列格式2
			WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf2 = new WritableCellFormat(wf2);
			wcf2.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf2.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf2.setBackground(Colour.ORANGE);

			// 写入表头

			// A. 所在区域
			label = new Label(0, 0, "所在区域", wcf1);
			sheet.addCell(label);
			// B. 片区代码号
			label = new Label(1, 0, "片区代码号", wcf1);
			sheet.addCell(label);
			// C. 大区名称
			label = new Label(2, 0, "大区名称", wcf1);
			sheet.addCell(label);
			// D. 小区代码号
			label = new Label(3, 0, "小区代码号", wcf1);
			sheet.addCell(label);
			// E. 小区名称
			label = new Label(4, 0, "小区名称", wcf1);
			sheet.addCell(label);
			// F. 小区地址
			label = new Label(5, 0, "座落地址", wcf1);
			sheet.addCell(label);
			// G. 小区地址别名
			label = new Label(6, 0, "地址别名", wcf1);
			sheet.addCell(label);

			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);

			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				// A. 所在区域
				label = SzqyLable(0, i + 1, ebList.get(i).getSzqyNm(), ebList.get(i).getSzqyId(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// B. 片区代码号
				label = new Label(1, i + 1, ebList.get(i).getPqdmh());
				sheet.addCell(label);
				// C. 大区名称
				label = ParentXQLable(2, i + 1, ebList.get(i).getParentXQNm(), ebList.get(i).getParentXQId(), ewcf1,
						"(不存在)");
				sheet.addCell(label);
				// D. 小区代码号
				label = new Label(3, i + 1, ebList.get(i).getXqdmh());
				sheet.addCell(label);
				// E. 小区名称
				label = CommonXQLable(4, i + 1, ebList.get(i).getXqNm(), ebList.get(i).getXqId(), ewcf1, exportType,
						"(不存在)");
				sheet.addCell(label);
				// F. 小区地址
				label = new Label(5, i + 1, ebList.get(i).getZcdzl());
				sheet.addCell(label);
				// G. 小区地址别名
				label = new Label(6, i + 1, ebList.get(i).getXqdzbm());
				sheet.addCell(label);
			}

			workbook.write();
		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
				;
			}
		}
		return strBufResult;
	}

	/**
	 * 楼房普查导出错误文件
	 * 
	 * @param gpsjList
	 * @return
	 */
	public static OutputStream exportCommonDataLFPC(ArrayList<ExcelBean> ebList, Integer exportType) {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream();
		// 创建excel对象
		Label label;
		Number number;
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			// 导出列格式1
			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);
			wcf1.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf1.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf1.setBackground(Colour.GREEN);

			// 导出列格式2
			WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf2 = new WritableCellFormat(wf2);
			wcf2.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf2.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf2.setBackground(Colour.ORANGE);

			// 写入表头
			// A. 所在区域
			label = new Label(0, 0, "所在区域", wcf1);
			sheet.addCell(label);
			// B. 小区名称
			label = new Label(1, 0, "小区名称", wcf1);
			sheet.addCell(label);
			// C. 楼房地址
			label = new Label(2, 0, "楼房地址", wcf1);
			sheet.addCell(label);
			// D. 地址别名
			label = new Label(3, 0, "地址别名", wcf1);
			sheet.addCell(label);
			// E. 总楼层
			label = new Label(4, 0, "总楼层", wcf1);
			sheet.addCell(label);
			// //F. 有无架空层
			// label = new Label(5, 0, "有无架空层" ,wcf1);
			// sheet.addCell(label);
			// G. 测量号
			label = new Label(5, 0, "测量号", wcf1);
			sheet.addCell(label);
			// H. 备注
			label = new Label(6, 0, "备注", wcf1);
			sheet.addCell(label);
			// I. 错误信息
			label = new Label(7, 0, "错误信息", wcf1);
			sheet.addCell(label);
			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);

			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				// A. 所在区域
				label = SzqyLable(0, i + 1, ebList.get(i).getSzqyNm(), ebList.get(i).getSzqyId(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// B. 小区名称
				label = CommonXQLable(1, i + 1, ebList.get(i).getXqNm(), ebList.get(i).getXqId(), ewcf1, exportType,
						"(不存在)");
				sheet.addCell(label);
				// C. 楼房地址
				label = CommonLfLable(2, i + 1, ebList.get(i).getZcdzl(), ebList.get(i).getZcdzlId(), ewcf1, exportType,
						"(已存在)");
				sheet.addCell(label);
				// D. 地址别名
				label = new Label(3, i + 1, ebList.get(i).getZcdzl());
				sheet.addCell(label);
				// E. 总楼层
				number = new Number(4, i + 1, ebList.get(i).getZlc());
				sheet.addCell(number);
				// //F. 有无架空层
				// label = new Label(5, i+1,
				// ebList.get(i).getYwjkc()==0?"无":"有");
				// sheet.addCell(label);
				// G. 测量号
				label = new Label(5, i + 1, ebList.get(i).getClh());
				sheet.addCell(label);
				// H. 备注
				label = new Label(6, i + 1, ebList.get(i).getNote());
				sheet.addCell(label);
				// I. 错误信息
				label = new Label(7, i + 1, ebList.get(i).getCwxx());
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			// logger.error(e.getMessage());
		}
		return strBufResult;
	}

	/**
	 * 自定义生产所在区域Label，带错误信息
	 * 
	 * @param c
	 * @param r
	 * @param cont
	 * @param flag
	 *            标识
	 * @param cf
	 * @param errorMsg
	 * @return
	 */
	private static Label SzqyLable(int c, int r, String cont, String flag, CellFormat cf, String errorMsg) {
		Label label = null;
		try {
			label = (CheckUtil.chkNull(flag).equals("N")) ? new Label(c, r, cont + errorMsg, cf) : new Label(c, r, cont);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return label;
	}

	/**
	 * 自定义生产 大区Label，带错误信息
	 * 
	 * @param c
	 * @param r
	 * @param cont
	 * @param flag
	 *            标识
	 * @param cf
	 * @param errorMsg
	 * @return
	 */
	private static Label ParentXQLable(int c, int r, String cont, String flag, CellFormat cf, String errorMsg) {
		Label label = null;
		try {
			label = (CheckUtil.chkNull(flag).equals("N")) ? new Label(c, r, cont + errorMsg, cf) : new Label(c, r, cont);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return label;
	}

	/**
	 * 自定义生产小区Lable
	 * 
	 * @param c
	 * @param r
	 * @param cont
	 * @param boolStr
	 *            标识
	 * @param cf
	 * @param exportType
	 *            导出类型
	 * @param errorMsg
	 *            错误提示
	 * @return
	 */
	private static Label CommonXQLable(int c, int r, String cont, String boolStr, CellFormat cf, Integer exportType,
			String errorMsg) {
		Label label = null;
		try {

			switch (exportType) {
			case 1:
				label = myXQLable(c, r, cont, boolStr, cf, "(已存在)");
				break;
			case 2:
				label = myDZLable(c, r, cont, boolStr, cf, errorMsg);
				break;
			case 3:
				label = myDZLable(c, r, cont, boolStr, cf, errorMsg);
				break;
			default:
				label = new Label(c, r, cont);
				break;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return label;
	}

	/**
	 * 自定义生产楼房Lable
	 * 
	 * @param c
	 * @param r
	 * @param cont
	 * @param boolStr
	 *            标识
	 * @param cf
	 * @param exportType
	 *            导出类型
	 * @param errorMsg
	 *            错误提示
	 * @return
	 */
	private static Label CommonLfLable(int c, int r, String cont, String boolStr, CellFormat cf, Integer exportType,
			String errorMsg) {
		Label label = null;
		try {

			switch (exportType) {
			case 1:
				label = new Label(c, r, cont);
				break;
			case 2:
				label = myDZLable(c, r, cont, boolStr, cf, errorMsg);
				break;
			case 3:
				label = new Label(c, r, cont);
				break;
			default:
				label = new Label(c, r, cont);
				break;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return label;
	}

	/**
	 * 自定义生产Label，带错误信息
	 * 
	 * @param c
	 * @param r
	 * @param cont
	 * @param flag
	 *            标识
	 * @param cf
	 * @param errorMsg
	 * @return
	 */
	private static Label myXQLable(int c, int r, String cont, String flag, CellFormat cf, String errorMsg) {
		Label label = null;
		try {
			label = (!CheckUtil.chkNull(flag).equals("N")) ? new Label(c, r, cont + errorMsg, cf)
					: new Label(c, r, cont);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return label;
	}

	/**
	 * 导出“挂牌数据”
	 * 
	 * @param gpsjList
	 * @return
	 */
	public static OutputStream exportDataGpsj(ArrayList<Pgv00304> gpsjList) {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream();
		// 创建excel对象
		Label label;
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf.setBackground(Colour.GREEN);

			// 列宽
			sheet.setColumnView(0, 25);

			// 写入标头
			// A. 座落地址
			label = new Label(0, 0, "楼房地址", wcf);
			sheet.addCell(label);
			// B. 所在区域
			label = new Label(1, 0, "所在区域", wcf);
			sheet.addCell(label);
			// C. 总楼层
			label = new Label(2, 0, "总楼层", wcf);
			sheet.addCell(label);
			// D. 小区名称
			label = new Label(3, 0, "小区名称", wcf);
			sheet.addCell(label);
			// E. 有无电梯
			label = new Label(4, 0, "有无电梯", wcf);
			sheet.addCell(label);
			// F. 交易类型
			label = new Label(5, 0, "交易类型", wcf);
			sheet.addCell(label);
			// G. 房屋类别
			label = new Label(6, 0, "房屋类别", wcf);
			sheet.addCell(label);
			// H. 建筑结构
			label = new Label(7, 0, "建筑结构", wcf);
			sheet.addCell(label);
			// I. 所在楼层
			label = new Label(8, 0, "所在楼层", wcf);
			sheet.addCell(label);
			// J. 建筑面积(平方米)
			label = new Label(9, 0, "建筑面积(平方米)", wcf);
			sheet.addCell(label);
			// K. 挂牌时间
			label = new Label(10, 0, "挂牌时间", wcf);
			sheet.addCell(label);
			// L. 房屋朝)向
			label = new Label(11, 0, "房屋朝向", wcf);
			sheet.addCell(label);
			// M. 采光状况
			label = new Label(12, 0, "采光状况", wcf);
			sheet.addCell(label);
			// N. 户型
			label = new Label(13, 0, "户型", wcf);
			sheet.addCell(label);
			// O. 是否中介
			label = new Label(14, 0, "是否中介", wcf);
			sheet.addCell(label);
			// p. 自报价格
			label = new Label(15, 0, "自报价格", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			// 写入数据
			for (int i = 0; i < gpsjList.size(); i++) {

				// A. 座落地址
				label = new Label(0, i + 1, gpsjList.get(i).getFwtdzl());
				sheet.addCell(label);
				// B. 所在区域
				label = myLable(1, i + 1, gpsjList.get(i).getSzqy(), gpsjList.get(i).getCd00001Szqy(), wcf1);
				sheet.addCell(label);
				// C. 总楼层
				label = new Label(2, i + 1, gpsjList.get(i).getZlc().toString());
				sheet.addCell(label);
				// D. 小区名称
				label = myDZLable(3, i + 1, gpsjList.get(i).getXqmc(), gpsjList.get(i).getCd00352Xqdm(), wcf1, "(不存在)");
				sheet.addCell(label);
				// E. 有无电梯
				label = new Label(4, i + 1, writeYwdt(gpsjList.get(i).getYwdt()));
				sheet.addCell(label);
				// F. 交易类型
				label = myLable(5, i + 1, gpsjList.get(i).getJylx(), gpsjList.get(i).getCd00001Jylx(), wcf1);
				sheet.addCell(label);
				// G. 房屋类别
				label = myLable(6, i + 1, gpsjList.get(i).getFwlx(), gpsjList.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				// H. 建筑结构
				label = myLable(7, i + 1, gpsjList.get(i).getJzjg(), gpsjList.get(i).getCd00001Jzjg(), wcf1);
				sheet.addCell(label);
				// I. 所在楼层
				label = new Label(8, i + 1, gpsjList.get(i).getSzlc().toString());
				sheet.addCell(label);
				// J. 建筑面积(平方米)
				label = new Label(9, i + 1, gpsjList.get(i).getJzmj().toString());
				sheet.addCell(label);
				// K. 挂牌时间
				label = new Label(10, i + 1, gpsjList.get(i).getGpsj().toString());
				sheet.addCell(label);
				// L. 房屋朝向
				label = myLable(11, i + 1, gpsjList.get(i).getFwcx(), gpsjList.get(i).getCd00001Fwcx(), wcf1);
				sheet.addCell(label);
				// M. 采光状况
				label = myLable(12, i + 1, gpsjList.get(i).getCgzk(), gpsjList.get(i).getCd00001Cgzk(), wcf1);
				sheet.addCell(label);
				// N. 户型
				label = new Label(13, i + 1, gpsjList.get(i).getHx());
				sheet.addCell(label);
				// O. 是否中介
				label = new Label(14, i + 1, writeSfzj(gpsjList.get(i).getSfzj()));
				sheet.addCell(label);
				// P. 自报价格
				label = new Label(15, i + 1, gpsjList.get(i).getZbjg().toString());
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			// logger.error(e.getMessage());
		}
		return strBufResult;
	}

	/**
	 * 导入“可比实例库数据”
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<Pgv00357> importDataKbslk(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv00357> resultList = new ArrayList<Pgv00357>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = sht.getRows();
				int columnSheet = sht.getColumns();
				for (int i = 1; i < rowSheet; i++) {
					Pgv00357 bean = new Pgv00357();
					try {
						// A.所在区域
						bean.setSzqy(CheckUtil.chkTrim(sht.getCell(0, i).getContents()));
						// B.小区代码号
						bean.setXqdmh(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// C.小区名称
						bean.setXqnm(CheckUtil.chkTrim(sht.getCell(2, i).getContents()));
						// D.纳税人名称
						bean.setNsrmc(CheckUtil.chkTrim(sht.getCell(3, i).getContents()));
						// E.税务编码/证件号码
						bean.setCd00301Swid(CheckUtil.chkTrim(sht.getCell(4, i).getContents()));
						// F.房屋类型
						bean.setFwlx(CheckUtil.chkTrim(sht.getCell(5, i).getContents()));
						// G.测量号
						bean.setClh(CheckUtil.chkTrim(sht.getCell(6, i).getContents()));
						// H.楼房地址
						bean.setZcdzl(CheckUtil.chkTrim(sht.getCell(7, i).getContents()));
						// I.楼名
						bean.setLm(CheckUtil.chkTrim(sht.getCell(8, i).getContents()));
						// J.单元
						bean.setDy(CheckUtil.chkTrim(sht.getCell(9, i).getContents()));
						// K.房号
						bean.setBwjfh(CheckUtil.chkTrim(sht.getCell(10, i).getContents()));
						// L.所在楼层
						try {
							bean.setSzlc(Short.parseShort(CheckUtil.chkTrim(sht.getCell(11, i).getContents())));
						} catch (Exception e) {
							throw new Exception("所在楼层格式不正确， 请核实第" + i + "条数据 ");
						}
						// M.总楼层
						try {
							String zlc = CheckUtil.chkTrim(sht.getCell(12, i).getContents());
							Short.parseShort(zlc);
							bean.setZlc(zlc);
						} catch (Exception e) {
							throw new Exception("总楼层格式不正确，请核实第" + i + "条数据");
						}
						// N.建筑结构
						bean.setJzjg(CheckUtil.chkTrim(sht.getCell(13, i).getContents()));
						// O.建成年份
						bean.setJcnf(CheckUtil.chkTrim(sht.getCell(14, i).getContents()));
						// P.建筑面积
						try {
							bean.setJzmj(Double.parseDouble(CheckUtil.chkTrim(sht.getCell(15, i).getContents())));
						} catch (Exception e) {
							throw new Exception("建筑面积格式不正确，请核实第" + i + "条数据");
						}
						// Q.交易时间
						try {
							String t = sht.getCell(16, i).getContents();
							if (!CheckUtil.chkEmpty(t))
								bean.setJysj(new java.sql.Date(ConvertUtil.toUtilDate(t).getTime()));
							else
								bean.setJysj(new java.sql.Date(new Date().getTime()));// 如果为空，取系统当前时间
						} catch (Exception e) {
							throw new Exception("交易时间格式不正确， 请核实第" + i + "条数据");
						}
						// R.成交价格（元）
						try {
							bean.setPgjg(Double.parseDouble(CheckUtil.chkTrim(sht.getCell(17, i).getContents())));
						} catch (Exception e) {
							throw new Exception("成交价格格式不正确， 请核实第" + i + "条数据");
						}
						// S.备注
						bean.setNote(CheckUtil.chkTrim(sht.getCell(18, i).getContents()));
						// Q-.综合修正
						StringBuffer tempZhxz = new StringBuffer();
						for (int j = 19; j < columnSheet; j++) {
							String tempNm = sht.getCell(j, 0).getContents();
							String tempVal = sht.getCell(j, i).getContents();
							if (null != tempVal && !"".equals(tempVal)) {
								tempZhxz.append(tempNm + "," + tempVal + ";");
							}
						}
						bean.setZhxzs(tempZhxz.toString());
						// 税收管辖
						bean.setCd00001Ssgx(ssgx);
						// 数据维护操作人
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}

	/**
	 * 导出“可比实例库数据”
	 * 
	 * @param gpsjList
	 * @return
	 */
	public static OutputStream exportDataKbslk(ArrayList<Pgv00357> kbslkList) {
		ByteArrayOutputStream strBufResult = null;
		// 创建excel对象
		Label label;
		Number number;
		WritableWorkbook workbook = null;
		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf.setBackground(Colour.GREEN);
			int j = 0;
			// 写入表头
			// A.所在区域
			label = new Label(j++, 0, "所在区域", wcf);
			sheet.addCell(label);
			// B.小区代码号
			label = new Label(j++, 0, "小区代码号", wcf);
			sheet.addCell(label);
			// C.小区名称
			label = new Label(j++, 0, "小区名称", wcf);
			sheet.addCell(label);
			// D.纳税人名称（产权人）
			label = new Label(j++, 0, "纳税人名称", wcf);
			sheet.addCell(label);
			// E.税务编码/证件号码
			label = new Label(j++, 0, "税务编码/证件号码", wcf);
			sheet.addCell(label);
			// F.房屋类型
			label = new Label(j++, 0, "房屋类型", wcf);
			sheet.addCell(label);
			// G.测量号
			label = new Label(j++, 0, "测量号", wcf);
			sheet.addCell(label);
			// H.坐落地址
			label = new Label(j++, 0, "坐落地址", wcf);
			sheet.addCell(label);
			// I.楼名
			label = new Label(j++, 0, "楼名", wcf);
			sheet.addCell(label);
			// J.单元
			label = new Label(j++, 0, "单元", wcf);
			sheet.addCell(label);
			// K.房号（部位及房号）
			label = new Label(j++, 0, "房号", wcf);
			sheet.addCell(label);
			// L.所在楼层
			label = new Label(j++, 0, "所在楼层", wcf);
			sheet.addCell(label);
			// M.总楼层
			label = new Label(j++, 0, "总楼层", wcf);
			sheet.addCell(label);
			// N.建筑结构
			label = new Label(j++, 0, "建筑结构", wcf);
			sheet.addCell(label);
			// O.建成年份
			label = new Label(j++, 0, "建成年份", wcf);
			sheet.addCell(label);
			// P.建筑面积
			label = new Label(j++, 0, "建筑面积 ", wcf);
			sheet.addCell(label);
			// Q.交易时间
			label = new Label(j++, 0, "交易时间", wcf);
			sheet.addCell(label);
			// R.成交价格(元)
			label = new Label(j++, 0, "成交价格(元)", wcf);
			sheet.addCell(label);
			// S.综合修正
			label = new Label(j++, 0, "综合修正", wcf);
			sheet.addCell(label);
			// T.备注
			label = new Label(j++, 0, "备注", wcf);
			sheet.addCell(label);
			// U.错误信息
			label = new Label(j++, 0, "错误信息", wcf);
			sheet.addCell(label);
			// 定义错误数据样式
			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);
			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);
			// 写入数据
			for (int i = 0; i < kbslkList.size(); i++) {
				j = 0;

				// A.所在区域
				label = SzqyLable(j++, i + 1, kbslkList.get(i).getSzqy(), kbslkList.get(i).getCd00001Szqy(), ewcf1,
						"(不存在)");
				sheet.addCell(label);
				// B.小区代码
				label = SzqyLable(j++, i + 1, kbslkList.get(i).getXqdmh(), kbslkList.get(i).getXqdmhid(), ewcf1,
						"(不存在)");
				sheet.addCell(label);
				// C.小区名称
				label = CommonXQLable(j++, i + 1, kbslkList.get(i).getXqnm(), kbslkList.get(i).getCd00352Xqdm(), ewcf1,
						2, "(不存在)");
				sheet.addCell(label);
				// D.纳税人名称
				label = new Label(j++, i + 1, kbslkList.get(i).getNsrmc());
				sheet.addCell(label);
				// E.税务编码/证件号码
				label = new Label(j++, i + 1, kbslkList.get(i).getCd00301Swid());
				sheet.addCell(label);
				// F.房屋类型
				label = myLable(j++, i + 1, kbslkList.get(i).getFwlx(), kbslkList.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				// G.测量号
				label = new Label(j++, i + 1, kbslkList.get(i).getClh());
				sheet.addCell(label);
				// H.楼房地址
				label = new Label(j++, i + 1, kbslkList.get(i).getZcdzl());
				sheet.addCell(label);
				// I.楼名
				label = new Label(j++, i + 1, kbslkList.get(i).getLm());
				sheet.addCell(label);
				// J.单元
				label = new Label(j++, i + 1, kbslkList.get(i).getDy());
				sheet.addCell(label);
				// K.房号
				label = new Label(j++, i + 1, kbslkList.get(i).getBwjfh());
				sheet.addCell(label);
				// L.所在楼层
				number = new Number(j++, i + 1, kbslkList.get(i).getSzlc());
				sheet.addCell(number);
				// M.总楼层
				number = new Number(j++, i + 1, kbslkList.get(i).getSzlc());
				sheet.addCell(number);
				// N.建筑结构
				label = myLable(j++, i + 1, kbslkList.get(i).getJzjg(), kbslkList.get(i).getCd00001Jzjg(), wcf1);
				sheet.addCell(label);
				// O.建成年份
				label = new Label(j++, i + 1, kbslkList.get(i).getJcnf());
				sheet.addCell(label);
				// P.建筑面积
				number = new Number(j++, i + 1, kbslkList.get(i).getJzmj());
				sheet.addCell(number);
				// Q.交易时间
				label = new Label(j++, i + 1, kbslkList.get(i).getJysj().toString());
				sheet.addCell(label);
				// R.成交价格(元)
				number = new Number(j++, i + 1, kbslkList.get(i).getPgjg());
				sheet.addCell(number);
				// S.综合修正
				label = myLable(j++, i + 1, kbslkList.get(i).getZhxzs(), kbslkList.get(i).getZhxzId(), wcf1);
				sheet.addCell(label);
				// T.备注
				label = new Label(j++, i + 1, kbslkList.get(i).getNote());
				sheet.addCell(label);
				// U.错误信息
				label = new Label(j++, i + 1, kbslkList.get(i).getCwxx());
				sheet.addCell(label);

			}

			workbook.write();
		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			logger.error(e.getMessage());
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}

	/**
	 * 解析通用Excel文件
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<Pgv00355> LCXSExcel(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv00355> resultList = new ArrayList<Pgv00355>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				// int rowSheet = sht.getRows();
				// 有效行数
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);

				for (int i = 1; i < rowSheet; i++) {
					Pgv00355 bean = new Pgv00355();
					try {
						// A. 所在区域
						bean.setSzqy(CheckUtil.chkTrim(sht.getCell(0, i).getContents()));
						// F. 房屋类型
						bean.setFwlx(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// B. 楼层
						try {
							String lc = CheckUtil.chkTrim(sht.getCell(2, i).getContents());
							bean.setLc(Short.parseShort(lc));
						} catch (Exception e) {
							Exception e1 = new Exception("所在楼层格式不正确，请核实第" + i + "条数据");
							throw e1;
						}
						// C. 总楼层
						try {
							String zlc = CheckUtil.chkTrim(sht.getCell(3, i).getContents());
							bean.setZcs(Short.parseShort(zlc));
						} catch (Exception e) {
							Exception e1 = new Exception("总楼层格式不正确,请核实第" + i + "条数据");
							throw e1;
						}
						// D.修正值
						try {
							String xzxs = CheckUtil.chkTrim(sht.getCell(4, i).getContents());
							bean.setXzxs(Double.parseDouble(xzxs));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确，请核实" + i + "条数据");
							throw e1;
						}
						// E. 运算类型
						bean.setCzlx(CheckUtil.chkTrim(sht.getCell(5, i).getContents()).equals("乘") ? 0 : 1);
						// H. 备注
						bean.setNote(sht.getCell(6, i).getContents());
						bean.setCd00001Ssgx(ssgx);
						bean.setCd00002Czr(userId);
						bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}

	/**
	 * 解析通用Excel文件
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<Pgv00321> YSFExcel(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv00321> resultList = new ArrayList<Pgv00321>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				// int rowSheet = sht.getRows();
				// 有效行数
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				int columnSheet = sht.getColumns();
				for (int i = 1; i < rowSheet; i++) {
					Pgv00321 bean = new Pgv00321();
					try {
						// A. 所在区域
						bean.setSzqy(CheckUtil.chkTrim(sht.getCell(0, i).getContents()));
						// B. 小区代码号
						bean.setXqdmh(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// C.小区名称
						bean.setXqdm(CheckUtil.chkTrim(sht.getCell(2, i).getContents()));
						// I. 房屋类型
						bean.setFwlx(CheckUtil.chkTrim(sht.getCell(3, i).getContents()));
						// H.测量号
						bean.setClh(CheckUtil.chkTrim(sht.getCell(4, i).getContents()));

						// D.房屋座落
						bean.setZcdzl(CheckUtil.chkTrim(sht.getCell(5, i).getContents()));
						// E.幢号
						bean.setZh(CheckUtil.chkTrim(sht.getCell(6, i).getContents()));
						// F.单元号
						bean.setDyh(CheckUtil.chkTrim(sht.getCell(7, i).getContents()));
						// G.房号
						bean.setFh(CheckUtil.chkTrim(sht.getCell(8, i).getContents()));

						// J. 楼层
						try {
							String lc = CheckUtil.chkTrim(sht.getCell(9, i).getContents());
							bean.setLc(Short.parseShort(lc));
						} catch (Exception e) {
							Exception e1 = new Exception("所在楼层格式不正确，请核实第" + i + "条数据");
							throw e1;
						}

						// K. 总楼层
						try {
							String zlc = CheckUtil.chkTrim(sht.getCell(10, i).getContents());
							bean.setZcs(Short.parseShort(zlc));
						} catch (Exception e) {
							Exception e1 = new Exception("总楼层格式不正确,请核实第" + i + "条数据");
							throw e1;
						}
						// M.建筑结构
						bean.setJzjg(CheckUtil.chkTrim(sht.getCell(11, i).getContents()));
						// L.建成年份
						String jcnf = CheckUtil.chkTrim(sht.getCell(12, i).getContents());
						if (jcnf.length() == 4) {
							bean.setJcnf(jcnf);
						} else {
							Exception e = new Exception("建成年份数据格式不正确或者有空行，请核实第" + i + "条");
							throw e;
						}

						// N.建筑面积
						String jzmj = CheckUtil.chkTrim(sht.getCell(13, i).getContents());
						try {
							bean.setJzmj(Double.parseDouble(jzmj));
						} catch (Exception e) {
							Exception e1 = new Exception("建筑面积格式不正确或者有空行，请核实第" + i + "条");
							throw e1;
						}

						// O.评估价格
						String pgjg = CheckUtil.chkTrim(sht.getCell(14, i).getContents());
						try {
							bean.setPgjg(Double.parseDouble(pgjg));
						} catch (Exception e) {
							Exception e1 = new Exception("单价格式不正确或者有空行，请核实第" + i + "条");
							throw e1;
						}
						// P.交易日期
						bean.setJysj(ConvertUtil.toUtilDate(CheckUtil.chkTrim(sht.getCell(15, i).getContents())));
						// Q. 备注
						bean.setNote(sht.getCell(16, i).getContents());

						// R-.综合修正
						StringBuffer tempZhxz = new StringBuffer();
						for (int j = 17; j < columnSheet; j++) {
							String tempNm = sht.getCell(j, 0).getContents();
							String tempVal = sht.getCell(j, i).getContents();
							if (null != tempVal && !"".equals(tempVal)) {
								tempZhxz.append(tempNm + "," + tempVal + ";");
							}
						}
						bean.setZhxzs(tempZhxz.toString());
						bean.setCd00001Ssgx(ssgx);
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}

	/**
	 * 解析通用Excel文件
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<Pgv00322> GPExcel(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv00322> resultList = new ArrayList<Pgv00322>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				// int rowSheet = sht.getRows();
				// 有效行数
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv00322 bean = new Pgv00322();
					try {
						// A. 所在区域
						bean.setSzqy(CheckUtil.chkTrim(sht.getCell(0, i).getContents()));
						// B.小区名称
						bean.setXqdm(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// C. 房屋类型
						bean.setFwlx(CheckUtil.chkTrim(sht.getCell(2, i).getContents()));
						// D. 楼层
						try {
							String lc = CheckUtil.chkTrim(sht.getCell(3, i).getContents());
							bean.setLc(Short.parseShort(lc));
						} catch (Exception e) {
							Exception e1 = new Exception("所在楼层格式不正确，请核实第" + i + "条数据");
							throw e1;
						}
						// E. 总楼层
						try {
							String zlc = CheckUtil.chkTrim(sht.getCell(4, i).getContents());
							bean.setZcs(Short.parseShort(zlc));
						} catch (Exception e) {
							Exception e1 = new Exception("总楼层格式不正确,请核实第" + i + "条数据");
							throw e1;
						}

						// F.建成年份
						String jcnf = CheckUtil.chkTrim(sht.getCell(5, i).getContents());
						if (jcnf.length() == 4) {
							bean.setJcnf(jcnf);
						} else {
							Exception e = new Exception("建成年份数据格式不正确或者有空行，请核实第" + i + "条");
							throw e;
						}

						// G.建筑面积
						String jzmj = CheckUtil.chkTrim(sht.getCell(6, i).getContents());
						try {
							bean.setJzmj(Double.parseDouble(jzmj));
						} catch (Exception e) {
							Exception e1 = new Exception("建筑面积格式不正确或者有空行，请核实第" + i + "条");
							throw e1;
						}
						// H.房屋朝向
						bean.setFwcx(CheckUtil.chkTrim(sht.getCell(7, i).getContents()));
						// I.房屋装修
						bean.setFwzx(CheckUtil.chkTrim(sht.getCell(8, i).getContents()));
						// J.评估价格
						String pgjg = CheckUtil.chkTrim(sht.getCell(9, i).getContents());
						try {
							bean.setPgjg(Double.parseDouble(pgjg));
						} catch (Exception e) {
							Exception e1 = new Exception("单价格式不正确或者有空行，请核实第" + i + "条");
							throw e1;
						}
						// K.交易日期
						bean.setJysj(ConvertUtil.toUtilDate(CheckUtil.chkTrim(sht.getCell(10, i).getContents())));
						// L. 备注
						bean.setNote(sht.getCell(11, i).getContents());
						bean.setCd00001Ssgx(ssgx);
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}

	/**
	 * 解析通用Excel文件
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<Pgv00323> ZJExcel(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv00323> resultList = new ArrayList<Pgv00323>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				// int rowSheet = sht.getRows();
				// 有效行数
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv00323 bean = new Pgv00323();
					try {
						// A. 所在区域
						bean.setSzqy(CheckUtil.chkTrim(sht.getCell(0, i).getContents()));
						// B.小区名称
						bean.setXqdm(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// C. 房屋类型
						bean.setFwlx(CheckUtil.chkTrim(sht.getCell(2, i).getContents()));
						// D. 楼层
						try {
							String lc = CheckUtil.chkTrim(sht.getCell(3, i).getContents());
							bean.setLc(Short.parseShort(lc));
						} catch (Exception e) {
							Exception e1 = new Exception("所在楼层格式不正确，请核实第" + i + "条数据");
							throw e1;
						}
						// E. 总楼层
						try {
							String zlc = CheckUtil.chkTrim(sht.getCell(4, i).getContents());
							bean.setZcs(Short.parseShort(zlc));
						} catch (Exception e) {
							Exception e1 = new Exception("总楼层格式不正确,请核实第" + i + "条数据");
							throw e1;
						}

						// F.建成年份
						String jcnf = CheckUtil.chkTrim(sht.getCell(5, i).getContents());
						if (jcnf.length() == 4) {
							bean.setJcnf(jcnf);
						} else {
							Exception e = new Exception("建成年份数据格式不正确或者有空行，请核实第" + i + "条");
							throw e;
						}

						// G.建筑面积
						String jzmj = CheckUtil.chkTrim(sht.getCell(6, i).getContents());
						try {
							bean.setJzmj(Double.parseDouble(jzmj));
						} catch (Exception e) {
							Exception e1 = new Exception("建筑面积格式不正确或者有空行，请核实第" + i + "条");
							throw e1;
						}
						// H.房屋朝向
						bean.setFwcx(CheckUtil.chkTrim(sht.getCell(7, i).getContents()));
						// I.房屋装修
						bean.setFwzx(CheckUtil.chkTrim(sht.getCell(8, i).getContents()));
						// J.评估价格
						String pgjg = CheckUtil.chkTrim(sht.getCell(9, i).getContents());
						try {
							bean.setPgjg(Double.parseDouble(pgjg));
						} catch (Exception e) {
							Exception e1 = new Exception("单价格式不正确或者有空行，请核实第" + i + "条");
							throw e1;
						}
						// K.交易日期
						bean.setJysj(ConvertUtil.toUtilDate(CheckUtil.chkTrim(sht.getCell(10, i).getContents())));
						// L. 备注
						bean.setNote(sht.getCell(11, i).getContents());
						bean.setCd00001Ssgx(ssgx);
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}

	/**
	 * 解析通用Excel文件
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<Pgv00353> ZHXZExcel(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv00353> resultList = new ArrayList<Pgv00353>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				// int rowSheet = sht.getRows();
				// 有效行数
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);

				for (int i = 1; i < rowSheet; i++) {
					Pgv00353 bean = new Pgv00353();
					try {
						// A. 所在区域
						bean.setSzqy(CheckUtil.chkTrim(sht.getCell(0, i).getContents()));
						// C. 房屋类型
						bean.setFwlx(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// B.类型名称
						bean.setLxmc(CheckUtil.chkTrim(sht.getCell(2, i).getContents()));
						// D.修正值
						try {
							String xzxs = CheckUtil.chkTrim(sht.getCell(3, i).getContents());
							bean.setXzxs(Double.parseDouble(xzxs));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确，请核实" + i + "条数据");
							throw e1;
						}
						// E. 运算类型
						bean.setCzlx(CheckUtil.chkTrim(sht.getCell(4, i).getContents()).equals("乘") ? 0 : 1);
						// F. 备注
						// bean.setNote(sht.getCell(6,i).getContents());
						bean.setCd00001Ssgx(ssgx);
						bean.setCd00002Czr(userId);
						bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}

	/**
	 * 导出“楼层修正数据”
	 * 
	 * @param ebList
	 * @return
	 */
	public static OutputStream exportDataLCXS(ArrayList<Pgv00355> ebList, Integer exportType) {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream();
		// 创建excel对象
		Label label;
		Number number;
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf.setBackground(Colour.GREEN);
			int j = 0;
			// 写入表头

			// A.所在区域
			label = new Label(j++, 0, "所在区域", wcf);
			sheet.addCell(label);
			// B.房屋类型
			label = new Label(j++, 0, "房屋类型", wcf);
			sheet.addCell(label);
			// C.楼层
			label = new Label(j++, 0, "楼层", wcf);
			sheet.addCell(label);
			// D.总楼层
			label = new Label(j++, 0, "总楼层", wcf);
			sheet.addCell(label);
			// E.修正值(元)
			label = new Label(j++, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			// F.运算类型
			label = new Label(j++, 0, "运算类型", wcf);
			sheet.addCell(label);
			// G.备注
			label = new Label(j++, 0, "备注", wcf);
			sheet.addCell(label);
			// H.错误信息
			label = new Label(j++, 0, "错误信息", wcf);
			sheet.addCell(label);
			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);
			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				j = 0;
				// A. 所在区域
				label = SzqyLable(j++, i + 1, ebList.get(i).getSzqy(), ebList.get(i).getSzqyId(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// K. 房屋类别
				label = myLable(j++, i + 1, ebList.get(i).getFwlx(), ebList.get(i).getFwlxId(), ewcf1);
				sheet.addCell(label);
				// C.楼层
				number = new Number(j++, i + 1, ebList.get(i).getLc());
				sheet.addCell(number);
				// D.总楼层
				number = new Number(j++, i + 1, ebList.get(i).getZcs());
				sheet.addCell(number);
				// E.修正值(元)
				number = new Number(j++, i + 1, ebList.get(i).getXzxs());
				sheet.addCell(number);
				// F.运算类型
				label = new Label(j++, i + 1, ebList.get(i).getCzlx() == 0 ? "乘" : "加");
				sheet.addCell(label);
				// G.备注
				label = new Label(j++, i + 1, ebList.get(i).getNote().toString());
				sheet.addCell(label);
				// H.错误信息
				label = new Label(j++, i + 1, ebList.get(i).getCwxx().toString());
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return strBufResult;
	}

	/**
	 * 导出“一手房数据”
	 * 
	 * @param ebList
	 * @return
	 */
	public static OutputStream exportDataYSF(ArrayList<Pgv00321> ebList, Integer exportType) {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream();
		// 创建excel对象
		Label label;
		Number number;
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf.setBackground(Colour.GREEN);
			int j = 0;
			// 写入表头

			// A.所在区域
			label = new Label(j++, 0, "所在区域", wcf);
			sheet.addCell(label);
			// B.小区代码号
			label = new Label(j++, 0, "小区代码号", wcf);
			sheet.addCell(label);
			// C.小区名称
			label = new Label(j++, 0, "小区名称", wcf);
			sheet.addCell(label);
			// I. 房屋类别
			label = new Label(j++, 0, "房屋类别", wcf);
			sheet.addCell(label);
			// H.测量号
			label = new Label(j++, 0, "测量号", wcf);
			sheet.addCell(label);
			// D.坐落地址
			label = new Label(j++, 0, "坐落地址", wcf);
			sheet.addCell(label);
			// E.幢号
			label = new Label(j++, 0, "幢号", wcf);
			sheet.addCell(label);
			// F.单元号
			label = new Label(j++, 0, "单元号", wcf);
			sheet.addCell(label);
			// G.房号
			label = new Label(j++, 0, "房号", wcf);
			sheet.addCell(label);

			// G.楼层
			label = new Label(j++, 0, "单元号", wcf);
			sheet.addCell(label);
			// K.总楼层
			label = new Label(j++, 0, "总楼层", wcf);
			sheet.addCell(label);
			// M.建筑结构
			label = new Label(j++, 0, "建筑结构", wcf);
			sheet.addCell(label);
			// L.建设年份
			label = new Label(j++, 0, "建设年份", wcf);
			sheet.addCell(label);

			// N.建筑面积（㎡）
			label = new Label(j++, 0, "建筑面积（㎡）", wcf);
			sheet.addCell(label);
			// O.评估价格（元/㎡）
			label = new Label(j++, 0, "评估价格（元/㎡）", wcf);
			sheet.addCell(label);
			// P.交易日期
			label = new Label(j++, 0, "交易日期", wcf);
			sheet.addCell(label);
			// Q.综合修正
			label = new Label(j++, 0, "综合修正", wcf);
			sheet.addCell(label);
			// R.备注
			label = new Label(j++, 0, "备注", wcf);
			sheet.addCell(label);
			// S.错误信息
			label = new Label(j++, 0, "错误信息", wcf);
			sheet.addCell(label);
			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);
			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				j = 0;
				// A. 所在区域
				label = SzqyLable(j++, i + 1, ebList.get(i).getSzqy(), ebList.get(i).getCd00001Szqy(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// B. 小区代码号
				label = SzqyLable(j++, i + 1, ebList.get(i).getXqdmh(), ebList.get(i).getXqdmhid(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// C.小区名称
				label = myDZLable(j++, i + 1, ebList.get(i).getXqdm(), ebList.get(i).getCd00352Xqdm(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// I. 房屋类别
				label = myLable(j++, i + 1, ebList.get(i).getFwlx(), ebList.get(i).getCd00001Fwlx(), ewcf1);
				sheet.addCell(label);
				// H.测量号
				label = new Label(j++, i + 1, ebList.get(i).getClh().toString());
				sheet.addCell(label);
				// D.坐落地址
				label = new Label(j++, i + 1, ebList.get(i).getZcdzl().toString());
				sheet.addCell(label);
				// E.幢号
				label = new Label(j++, i + 1, ebList.get(i).getZh().toString());
				sheet.addCell(label);
				// F.单元号
				label = new Label(j++, i + 1, ebList.get(i).getDyh().toString());
				sheet.addCell(label);
				// G.房号
				label = new Label(j++, i + 1, ebList.get(i).getFh().toString());
				sheet.addCell(label);

				// G.楼层
				number = new Number(j++, i + 1, ebList.get(i).getLc());
				sheet.addCell(number);
				// K.总楼层
				number = new Number(j++, i + 1, ebList.get(i).getZcs());
				sheet.addCell(number);

				// M.建筑结构
				label = myLable(j++, i + 1, ebList.get(i).getJzjg(), ebList.get(i).getCd00001Jzjg(), ewcf1);
				sheet.addCell(label);
				// L.建设年份
				label = new Label(j++, i + 1, ebList.get(i).getJcnf());
				sheet.addCell(label);
				// N.建筑面积（㎡）
				label = new Label(j++, i + 1, ebList.get(i).getJzmj().toString());
				sheet.addCell(label);
				// O.评估价格（元/㎡）
				label = new Label(j++, i + 1, ebList.get(i).getPgjg().toString());
				sheet.addCell(label);
				// P.交易日期
				label = new Label(j++, i + 1, FormatUtil.toYYYYMMDD(ebList.get(i).getJysj()));
				sheet.addCell(label);
				// Q.综合修正
				label = myLable(j++, i + 1, ebList.get(i).getZhxzs(), ebList.get(i).getZhxzid(), ewcf1);
				sheet.addCell(label);
				// R.备注
				label = new Label(j++, i + 1, ebList.get(i).getNote().toString());
				sheet.addCell(label);
				// S.错误信息
				label = new Label(j++, i + 1, ebList.get(i).getCwxx().toString());
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return strBufResult;
	}

	/**
	 * 导出“挂牌数据”
	 * 
	 * @param ebList
	 * @return
	 */
	public static OutputStream exportDataGP(ArrayList<Pgv00322> ebList, Integer exportType) {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream();
		// 创建excel对象
		Label label;
		Number number;
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf.setBackground(Colour.GREEN);
			int j = 0;
			// 写入表头

			// A.所在区域
			label = new Label(j++, 0, "所在区域", wcf);
			sheet.addCell(label);
			// B.小区名称
			label = new Label(j++, 0, "小区名称", wcf);
			sheet.addCell(label);
			// C. 房屋类别
			label = new Label(j++, 0, "房屋类别", wcf);
			sheet.addCell(label);
			// D.楼层
			label = new Label(j++, 0, "所在楼层", wcf);
			sheet.addCell(label);
			// E.总楼层
			label = new Label(j++, 0, "总楼层", wcf);
			sheet.addCell(label);
			// F.建设年份
			label = new Label(j++, 0, "建设年份", wcf);
			sheet.addCell(label);
			// G.建筑面积（㎡）
			label = new Label(j++, 0, "建筑面积（㎡）", wcf);
			sheet.addCell(label);
			// H.房屋朝向
			label = new Label(j++, 0, "房屋朝向", wcf);
			sheet.addCell(label);
			// I.房屋装修
			label = new Label(j++, 0, "房屋装修", wcf);
			sheet.addCell(label);
			// G.评估价格（元/㎡）
			label = new Label(j++, 0, "评估价格（元/㎡）", wcf);
			sheet.addCell(label);
			// K.交易日期
			label = new Label(j++, 0, "交易日期", wcf);
			sheet.addCell(label);
			// L.备注
			label = new Label(j++, 0, "备注", wcf);
			sheet.addCell(label);
			// M.错误信息
			label = new Label(j++, 0, "错误信息", wcf);
			sheet.addCell(label);
			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);
			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				j = 0;
				// A. 所在区域
				label = SzqyLable(j++, i + 1, ebList.get(i).getSzqy(), ebList.get(i).getCd00001Szqy(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// B.小区名称
				label = myDZLable(j++, i + 1, ebList.get(i).getXqdm(), ebList.get(i).getCd00352Xqdm(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// C. 房屋类别
				label = myLable(j++, i + 1, ebList.get(i).getFwlx(), ebList.get(i).getCd00001Fwlx(), ewcf1);
				sheet.addCell(label);
				// D.楼层
				number = new Number(j++, i + 1, ebList.get(i).getLc());
				sheet.addCell(number);
				// E.总楼层
				number = new Number(j++, i + 1, ebList.get(i).getZcs());
				sheet.addCell(number);
				// F.建设年份
				label = new Label(j++, i + 1, ebList.get(i).getJcnf());
				sheet.addCell(label);
				// G.建筑面积（㎡）
				label = new Label(j++, i + 1, ebList.get(i).getJzmj().toString());
				sheet.addCell(label);
				// H. 房屋朝向
				label = new Label(j++, i + 1, ebList.get(i).getFwcx().toString());
				sheet.addCell(label);
				// I. 房屋装修
				label = new Label(j++, i + 1, ebList.get(i).getFwzx().toString());
				sheet.addCell(label);
				// J.评估价格（元/㎡）
				label = new Label(j++, i + 1, ebList.get(i).getPgjg().toString());
				sheet.addCell(label);
				// K.交易日期
				label = new Label(j++, i + 1, FormatUtil.toYYYYMMDD(ebList.get(i).getJysj()));
				sheet.addCell(label);
				// L.备注
				label = new Label(j++, i + 1, ebList.get(i).getNote().toString());
				sheet.addCell(label);
				// M.错误信息
				label = new Label(j++, i + 1, ebList.get(i).getCwxx().toString());
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return strBufResult;
	}

	/**
	 * 导出“中介数据”
	 * 
	 * @param ebList
	 * @return
	 */
	public static OutputStream exportDataZJ(ArrayList<Pgv00323> ebList, Integer exportType) {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream();
		// 创建excel对象
		Label label;
		Number number;
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf.setBackground(Colour.GREEN);
			int j = 0;
			// 写入表头

			// A.所在区域
			label = new Label(j++, 0, "所在区域", wcf);
			sheet.addCell(label);
			// B.小区名称
			label = new Label(j++, 0, "小区名称", wcf);
			sheet.addCell(label);
			// C. 房屋类别
			label = new Label(j++, 0, "房屋类别", wcf);
			sheet.addCell(label);
			// D.楼层
			label = new Label(j++, 0, "所在楼层", wcf);
			sheet.addCell(label);
			// E.总楼层
			label = new Label(j++, 0, "总楼层", wcf);
			sheet.addCell(label);
			// F.建设年份
			label = new Label(j++, 0, "建设年份", wcf);
			sheet.addCell(label);
			// G.建筑面积（㎡）
			label = new Label(j++, 0, "建筑面积（㎡）", wcf);
			sheet.addCell(label);
			// H.房屋朝向
			label = new Label(j++, 0, "房屋朝向", wcf);
			sheet.addCell(label);
			// I.房屋装修
			label = new Label(j++, 0, "房屋装修", wcf);
			sheet.addCell(label);
			// G.评估价格（元/㎡）
			label = new Label(j++, 0, "评估价格（元/㎡）", wcf);
			sheet.addCell(label);
			// K.交易日期
			label = new Label(j++, 0, "交易日期", wcf);
			sheet.addCell(label);
			// L.备注
			label = new Label(j++, 0, "备注", wcf);
			sheet.addCell(label);
			// M.错误信息
			label = new Label(j++, 0, "错误信息", wcf);
			sheet.addCell(label);
			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);
			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				j = 0;
				// A. 所在区域
				label = SzqyLable(j++, i + 1, ebList.get(i).getSzqy(), ebList.get(i).getCd00001Szqy(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// B.小区名称
				label = myDZLable(j++, i + 1, ebList.get(i).getXqdm(), ebList.get(i).getCd00352Xqdm(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// C. 房屋类别
				label = myLable(j++, i + 1, ebList.get(i).getFwlx(), ebList.get(i).getCd00001Fwlx(), ewcf1);
				sheet.addCell(label);
				// D.楼层
				number = new Number(j++, i + 1, ebList.get(i).getLc());
				sheet.addCell(number);
				// E.总楼层
				number = new Number(j++, i + 1, ebList.get(i).getZcs());
				sheet.addCell(number);
				// F.建设年份
				label = new Label(j++, i + 1, ebList.get(i).getJcnf());
				sheet.addCell(label);
				// G.建筑面积（㎡）
				label = new Label(j++, i + 1, ebList.get(i).getJzmj().toString());
				sheet.addCell(label);
				// H. 房屋朝向
				label = new Label(j++, i + 1, ebList.get(i).getFwcx().toString());
				sheet.addCell(label);
				// I. 房屋装修
				label = new Label(j++, i + 1, ebList.get(i).getFwzx().toString());
				sheet.addCell(label);
				// J.评估价格（元/㎡）
				label = new Label(j++, i + 1, ebList.get(i).getPgjg().toString());
				sheet.addCell(label);
				// K.交易日期
				label = new Label(j++, i + 1, FormatUtil.toYYYYMMDD(ebList.get(i).getJysj()));
				sheet.addCell(label);
				// L.备注
				label = new Label(j++, i + 1, ebList.get(i).getNote().toString());
				sheet.addCell(label);
				// M.错误信息
				label = new Label(j++, i + 1, ebList.get(i).getCwxx().toString());
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return strBufResult;
	}

	/**
	 * 导出“楼层修正数据”
	 * 
	 * @param ebList
	 * @return
	 */
	public static OutputStream exportDataZHXZ(ArrayList<Pgv00353> ebList, Integer exportType) {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream();
		// 创建excel对象
		Label label;
		Number number;
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf.setBackground(Colour.GREEN);
			int j = 0;
			// 写入表头

			// A.所在区域
			label = new Label(j++, 0, "所在区域", wcf);
			sheet.addCell(label);
			// B.房屋类型
			label = new Label(j++, 0, "房屋类型", wcf);
			sheet.addCell(label);
			// A.所在区域
			label = new Label(j++, 0, "类型名称", wcf);
			sheet.addCell(label);
			// E.修正值(元)
			label = new Label(j++, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			// F.运算类型
			label = new Label(j++, 0, "运算类型", wcf);
			sheet.addCell(label);
			// //G.备注
			// label = new Label(j++, 0, "备注" ,wcf);
			// sheet.addCell(label);
			// H.错误信息
			label = new Label(j++, 0, "错误信息", wcf);
			sheet.addCell(label);
			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);
			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				j = 0;
				// A. 所在区域
				label = SzqyLable(j++, i + 1, ebList.get(i).getSzqy(), ebList.get(i).getCd00001Szqy(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// K. 房屋类别
				label = myLable(j++, i + 1, ebList.get(i).getFwlx(), ebList.get(i).getCd00001Fwlx(), ewcf1);
				sheet.addCell(label);
				// A. 类别名称
				label = myLable(j++, i + 1, ebList.get(i).getLxmc(), ebList.get(i).getCd00001Infoid(), ewcf1);
				sheet.addCell(label);
				// E.修正值(元)
				number = new Number(j++, i + 1, ebList.get(i).getXzxs());
				sheet.addCell(number);
				// F.运算类型
				label = new Label(j++, i + 1, ebList.get(i).getCzlx() == 0 ? "乘" : "加");
				sheet.addCell(label);
				// //G.备注
				// label = new Label(j++, i+1,
				// ebList.get(i).getNote().toString());
				// sheet.addCell(label);
				// H.错误信息
				label = new Label(j++, i + 1, ebList.get(i).getCwxx().toString());
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return strBufResult;
	}

	/**
	 * 向ecxel写入是否中介
	 * 
	 * @param sfzj
	 * @return
	 */
	private static String writeSfzj(Boolean sfzj) {
		String bool = "否";
		try {
			bool = sfzj ? "是" : "否";
		} catch (Exception e) {
			// logger.error(e.getMessage());
		}
		return bool;
	}

	/**
	 * 交易价格指数导入
	 * 
	 * @param txtFilePath
	 * @param userId
	 * @param get
	 * @return
	 */

	public static ArrayList<Pgv00356> importDataJyjgzs(String txtFilePath, String userId, String sourceFile)
			throws Exception {
		ArrayList<Pgv00356> resultList = new ArrayList<Pgv00356>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		try {
			is = new FileInputStream(txtFilePath);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = sht.getRows();
				for (int i = 1; i < rowSheet; i++) {
					Pgv00356 bean = new Pgv00356();
					try {
						// A.所在区域
						bean.setSzqy(sht.getCell(0, i).getContents());
						// B.评税时点
						try {
							String value = CheckUtil.chkTrim(sht.getCell(1, i).getContents());
							bean.setCd00002Pssd(String.valueOf(Integer.parseInt(value)).toString());
						} catch (Exception e) {
							Exception e1 = new Exception("估价时点格式不正确,请核实第" + i + "条数据");
							throw e1;
						}
						// C.修正系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(2, i).getContents());
							bean.setXzxs(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第" + i + "条数据");
							throw e1;
						}
						// 税收管辖
						bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}

	/**
	 * 导出“楼层修正数据”
	 * 
	 * @param ebList
	 * @return
	 */
	public static OutputStream exportDataJyjgzs(ArrayList<Pgv00356> ebList) {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream();
		// 创建excel对象
		Label label;
		Number number;
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf.setBackground(Colour.GREEN);
			int j = 0;
			// 写入表头

			// A.所在区域
			label = new Label(j++, 0, "所在区域", wcf);
			sheet.addCell(label);
			// B.评税时点
			label = new Label(j++, 0, "评税时点", wcf);
			sheet.addCell(label);
			// C.修正值
			label = new Label(j++, 0, "修正值", wcf);
			sheet.addCell(label);
			// D.错误信息
			label = new Label(j++, 0, "错误信息", wcf);
			sheet.addCell(label);
			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);
			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				j = 0;
				// A. 所在区域
				label = SzqyLable(j++, i + 1, ebList.get(i).getSzqy(), ebList.get(i).getSzqyId(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// B.评税时点
				label = new Label(j++, i + 1, ebList.get(i).getCd00002Pssd());
				sheet.addCell(label);
				// C.修正值
				number = new Number(j++, i + 1, ebList.get(i).getXzxs());
				sheet.addCell(number);
				// D.错误信息
				label = new Label(j++, i + 1, ebList.get(i).getCwxx());
				sheet.addCell(label);

			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return strBufResult;
	}

	/**
	 * 导入楼层信息
	 */
	public static ArrayList<Pgv00306> importDataLFXX(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv00306> resultList = new ArrayList<Pgv00306>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv00306 bean = new Pgv00306();
					try {
						// A.所在区域
						bean.setSzqy(sht.getCell(0, i).getContents());
						// B.代码号
						bean.setDmh(sht.getCell(1, i).getContents());
						// C.小区名称
						bean.setXqnm(sht.getCell(2, i).getContents());
						// D.楼号
						bean.setLh(sht.getCell(3, i).getContents());
						// E.总楼层
						// try{
						// String value =
						// CheckUtil.chkTrim(sht.getCell(4,i).getContents());
						// bean.setZlc(Integer.parseInt(value));
						// }catch(Exception e){
						// Exception e1 = new
						// Exception("面积上限格式不正确,请核实第"+i+"条数据");
						// throw e1;
						// }
						// //F.单元格数
						// try{
						// String value =
						// CheckUtil.chkTrim(sht.getCell(5,i).getContents());
						// bean.setDygs(Integer.parseInt(value));
						// }catch(Exception e){
						// Exception e1 = new
						// Exception("修正系数格式不正确,请核实第"+i+"条数据");
						// throw e1;
						// }
						// E.坐落地址
						bean.setNote(sht.getCell(4, i).getContents());
						// F。测量号
						bean.setClh(sht.getCell(5, i).getContents());
						bean.setSsgx(ssgx);
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}

	/**
	 * 导出错误格式楼房信息修正
	 */
	public static OutputStream exportDataMLFXX(ArrayList<Pgv00306> v00306List) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "代码号", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "小区名称", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "楼号", wcf);
			sheet.addCell(label);
			// label = new Label(4,0,"总楼层",wcf);
			// sheet.addCell(label);
			// label = new Label(5,0,"单元个数",wcf);
			// sheet.addCell(label);
			label = new Label(4, 0, "坐落地址", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "测量号", wcf);
			sheet.addCell(label);
			label = new Label(6, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v00306List.size(); i++) {
				label = myDZLable(0, i + 1, v00306List.get(i).getSzqy(), v00306List.get(i).getCd00001Szqy(), wcf1,
						"(不存在)");
				sheet.addCell(label);
				label = myDZLable(1, i + 1, v00306List.get(i).getDmh(), v00306List.get(i).getDmhId(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myDZLable(2, i + 1, v00306List.get(i).getXqnm(), v00306List.get(i).getCd00352Xqdm(), wcf1,
						"(不存在)");
				sheet.addCell(label);
				label = new Label(3, i + 1, v00306List.get(i).getLh().toString());
				sheet.addCell(label);
				// label = new
				// Label(4,i+1,v00306List.get(i).getZlc().toString());
				// sheet.addCell(label);
				// label = new
				// Label(5,i+1,v00306List.get(i).getDygs().toString());
				// sheet.addCell(label);
				label = new Label(4, i + 1, v00306List.get(i).getNote().toString());
				sheet.addCell(label);
				label = new Label(5, i + 1, v00306List.get(i).getClh());
				sheet.addCell(label);
				label = new Label(6, i + 1, v00306List.get(i).getImpErrorMsg());
				sheet.addCell(label);
			}
			workbook.write();
		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}

	/**
	 * 导入建筑成新修正
	 */
	public static ArrayList<Pgv00361> importDataJCSJ(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv00361> resultList = new ArrayList<Pgv00361>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv00361 bean = new Pgv00361();
					try {
						// A.所在区域
						bean.setSzqy(sht.getCell(0, i).getContents());
						// B.房屋类型
						bean.setFwlx(sht.getCell(1, i).getContents());
						// C.使用年限下限
						try {
							String value = sht.getCell(2, i).getContents();
							bean.setSynx_min(Integer.parseInt(value));
						} catch (Exception e) {
							Exception e1 = new Exception("使用年限下限格式不正确,请核实第" + i + "条数据");
							throw e1;
						}
						// D.使用年限上限
						try {
							String value = sht.getCell(3, i).getContents();
							bean.setSynx_max(Integer.parseInt(value));
						} catch (Exception e) {
							Exception e1 = new Exception("使用年限上限格式不正确,请核实第" + i + "条数据");
							throw e1;
						}
						// E.修正系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(4, i).getContents());
							bean.setXzxs(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第" + i + "条数据");
							throw e1;
						}

						bean.setCd_00002_czr(userId);
						bean.setSsgx(ssgx);
						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}

	/**
	 * 导出错误格式建筑成新修正
	 */
	public static OutputStream exportDataJCSJXZ(ArrayList<Pgv00361> v00361List) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "使用年限下限", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "使用年限上限", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v00361List.size(); i++) {
				label = myLable(0, i + 1, v00361List.get(i).getSzqy(), v00361List.get(i).getCd_00001_szqy(), wcf1);
				sheet.addCell(label);
				label = myLable(1, i + 1, v00361List.get(i).getFwlx(), v00361List.get(i).getCd_00001_fwlx(), wcf1);
				sheet.addCell(label);
				label = new Label(2, i + 1, v00361List.get(i).getSynx_min().toString());
				sheet.addCell(label);
				label = new Label(3, i + 1, v00361List.get(i).getSynx_max().toString());
				sheet.addCell(label);
				label = new Label(4, i + 1, v00361List.get(i).getXzxs().toString());
				sheet.addCell(label);
				label = new Label(5, i + 1, v00361List.get(i).getImpErrorMsg());
				sheet.addCell(label);
			}
			workbook.write();
		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;

	}

	/**
	 * 导入建筑结构修正
	 * 
	 * @throws Exception
	 */
	public static ArrayList<Pgv00362> importDataJZJG(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv00362> resultList = new ArrayList<Pgv00362>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv00362 bean = new Pgv00362();
					try {
						// A.所在区域
						bean.setSzqy(sht.getCell(0, i).getContents());
						// B.房屋类别
						bean.setFwlx(sht.getCell(1, i).getContents());
						// C.建筑结构
						bean.setJzjg(sht.getCell(2, i).getContents());
						// D.修正系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(3, i).getContents());
							bean.setXzxs(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第" + i + "条数据");
							throw e1;
						}

						bean.setCd_00002_czr(userId);
						bean.setSsgx(ssgx);
						bean.setCd_00002_pssd("2011");

						resultList.add(bean);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}

	/**
	 * 导出错误格式建筑结构修正
	 */
	public static OutputStream exportDataJzjg(ArrayList<Pgv00362> v00362List) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "建筑结构", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v00362List.size(); i++) {
				label = myLable(0, i + 1, v00362List.get(i).getSzqy(), v00362List.get(i).getCd_00001_szqy(), wcf1);
				sheet.addCell(label);
				label = myLable(1, i + 1, v00362List.get(i).getFwlx(), v00362List.get(i).getCd_00001_fwlx(), wcf1);
				sheet.addCell(label);
				label = myLable(2, i + 1, v00362List.get(i).getJzjg(), v00362List.get(i).getCd_00001_jzjg(), wcf1);
				sheet.addCell(label);
				label = new Label(3, i + 1, v00362List.get(i).getXzxs().toString());
				sheet.addCell(label);
				label = new Label(4, i + 1, v00362List.get(i).getImpErrorMsg());
				sheet.addCell(label);
			}
			workbook.write();

		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;

	}	


	/**
	 * 解析通用Excel文件
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<ExcelBean> resolveExcelFQ(String sourceFile,
			String userId, String ssgx) throws Exception {
		ArrayList<ExcelBean> resultList = new ArrayList<ExcelBean>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0)
				sht = wb.getSheet(0);
			else
				return resultList;
			// int rowSheet = sht.getRows();
			// 有效行数
			int rowSheet = getValidRowNumbers(sht.getRows(), sht);

			for (int i = 1; i < rowSheet; i++) {
				ExcelBean bean = new ExcelBean();
				try {
					// A.行政区域
					/*
					 * String szqy =
					 * CheckUtil.chkTrim(sht.getCell(0,i).getContents());
					 * if(CheckUtil.chkEmpty(szqy)){ bean.setSzqyNm(szqy); }else{
					 * throw new Exception("所在区域为空请检查,第"+ (i+1) +"条"); }
					 */
					bean.setSzqyNm(ExcelUtil.excelIsEmpty(sht.getCell(0, i)
							.getContents(), "所在区域", i));
					// B.房屋类型
					bean.setFwlxNm(ExcelUtil.excelIsEmpty(sht.getCell(1, i)
							.getContents(), "房屋类型", i));
					// String fwlxNm =
					// CheckUtil.chkTrim(sht.getCell(1,i).getContents());
					// if(CheckUtil.chkEmpty(fwlxNm)){
					// bean.setFwlxNm(fwlxNm);
					// }else{
					// throw new Exception("房屋类型为空请检查,第"+ (i+1) +"条");
					// }
					// C.片区代码号
					String parDmh = CheckUtil.chkTrim(sht.getCell(2, i).getContents());
					bean.setParentDmh(parDmh);
					// D.片区
					String parentXqnm = CheckUtil.chkTrim(sht.getCell(3, i)
							.getContents());
					bean.setParentXQNm(parentXqnm);
					// E.分区代码号
					String xqDmh = CheckUtil.chkTrim(sht.getCell(4, i).getContents());
					bean.setDmh(xqDmh);
					// E.分区
					String xqnm = CheckUtil.chkTrim(sht.getCell(5, i).getContents());
					bean.setXqNm(xqnm);
					// F.别名
					bean.setXqbm(CheckUtil.chkTrim(sht.getCell(6, i).getContents()));
					/*// G.地丘号
					bean.setQdh(CheckUtil.chkTrim(sht.getCell(7, i).getContents()));

					// I.建成年份
					String jcnf = CheckUtil.chkTrim(sht.getCell(8, i).getContents());
					if (null == jcnf || "".equals(jcnf) || jcnf.length() == 4) {
						bean.setJcnf(CheckUtil.chkTrim(sht.getCell(8, i)
								.getContents()));
					} else {
						Exception e = new Exception("建成年份数据格式不符，请核实第" + (i + 1)
								+ "条");
						throw e;
					}*/

					bean.setSsgx(ssgx);
					bean.setCd00002Czr(userId);
					resultList.add(bean);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					bean = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}
	
	
	/**
	 * 导出通用Excel文件
	 * 
	 * @param gpsjList
	 * @return
	 */
	public static OutputStream exportCommonDataSy(ArrayList<ExcelBean> ebList,
			Integer exportType) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		// 创建excel对象
		Label label;
		WritableWorkbook workbook = null;
		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的数据", 0);
			// 导出列格式1
			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);
			wcf1.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf1.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf1.setBackground(Colour.GREEN);

			// 导出列格式2
			WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf2 = new WritableCellFormat(wf2);
			wcf2.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf2.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf2.setBackground(Colour.ORANGE);

			// 写入表头

			// A.行政区域
			label = new Label(0, 0, "所在区域", wcf1);
			sheet.addCell(label);
			// B.房屋类型
			label = new Label(1, 0, "房屋类型", wcf1);
			sheet.addCell(label);
			// C.片区代码号
			label = new Label(2, 0, "片区代码号", wcf1);
			sheet.addCell(label);
			// D.片区
			label = new Label(3, 0, "片区名称", wcf1);
			sheet.addCell(label);
			// E.小区代码号
			label = new Label(4, 0, "分区代码号", wcf1);
			sheet.addCell(label);
			// F.分区
			label = new Label(5, 0, "分区名称", wcf1);
			sheet.addCell(label);
			// G.别名
			label = new Label(6, 0, "别名", wcf1);
			sheet.addCell(label);
			// H.地丘号
			label = new Label(7, 0, "丘(地)号", wcf1);
			sheet.addCell(label);
			// J.建成年份
			label = new Label(8, 0, "建成年份", wcf1);
			sheet.addCell(label);
			// J.错误信息
			label = new Label(9, 0, "错误信息", wcf1);
			sheet.addCell(label);

			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);

			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				// A.行郑区域
				label = SzqyLable(0, i + 1, ebList.get(i).getSzqyNm(), ebList
						.get(i).getSzqyId(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// B.房屋类别
				label = myLable(1, i + 1, ebList.get(i).getFwlxNm(), ebList
						.get(i).getFwlxId(), ewcf1);
				sheet.addCell(label);
				// C.片区代码号
				label = ParentXQLable(2, i + 1, ebList.get(i).getParentDmh(),
						ebList.get(i).getParengDmhId(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// D.片区
				label = ParentXQLable(3, i + 1, ebList.get(i).getParentXQNm(),
						ebList.get(i).getParentXQId(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// E.分区代码号
				label = myXQLable(4, i + 1, ebList.get(i).getDmh(),
						ebList.get(i).getDmhId(), ewcf1, "(存在)");
				sheet.addCell(label);
				// F.分区
				label = myXQLable(5, i + 1, ebList.get(i).getXqNm(), ebList
						.get(i).getXqId(), ewcf1, "(存在)");
				sheet.addCell(label);
				// G.别名
				label = new Label(6, i + 1, ebList.get(i).getXqbm());
				sheet.addCell(label);
				// H.地丘号
				label = new Label(7, i + 1, ebList.get(i).getQdh());
				sheet.addCell(label);

				// I.建成年份
				label = new Label(8, i + 1, ebList.get(i).getJcnf());
				sheet.addCell(label);

				// Date jysj = ebList.get(i).getJysj();
				// if(null != jysj){
				// label = new Label(10, i+1, jysj.toString());
				// }else{
				// label = new Label(10, i+1, "");
				// }

				// sheet.addCell(label);
				// K.错误信息
				label = new Label(9, i + 1, ebList.get(i).getImpErrorMsg());
				sheet.addCell(label);

			}

			workbook.write();
		} catch (Exception e) {
			// e.printStackTrace();
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}
	

	/**
	 * 解析通用Excel文件
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<Pgv02050> resolveExcelSZMSS(String sourceFile,
			String userId, String ssgx) throws Exception {
		ArrayList<Pgv02050> resultList = new ArrayList<Pgv02050>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0)
				sht = wb.getSheet(0);
			else
				return resultList;
			// int rowSheet = sht.getRows();
			// 有效行数
			int rowSheet = getValidRowNumbers(sht.getRows(), sht);

			for (int i = 1; i < rowSheet; i++) {
				Pgv02050 bean = new Pgv02050();
				try {
					// A.行政区域
					bean.setSzqy(CheckUtil.chkTrim(sht.getCell(0, i).getContents()));
					// B.分区
					bean.setXqnm(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
					// C.街道门牌号
					bean.setJdmph(CheckUtil.chkTrim(sht.getCell(2, i).getContents()));
					// D.东面描述
					bean.setDmms(CheckUtil.chkTrim(sht.getCell(3, i).getContents()));
					// E.西面描述
					bean.setXmms(CheckUtil.chkTrim(sht.getCell(4, i).getContents()));
					// F.南面描述
					bean.setNmms(CheckUtil.chkTrim(sht.getCell(5, i).getContents()));
					// G.北面描述
					bean.setBmms(CheckUtil.chkTrim(sht.getCell(6, i).getContents()));
					// H.分区代码号
					String xqDmh = CheckUtil.chkTrim(sht.getCell(7, i).getContents());
					bean.setXqdmhm(xqDmh);
					// I.小区类型
					bean.setXqlx(CheckUtil.chkTrim(sht.getCell(8, i).getContents()));
					// J.房屋类型
					bean.setFwlx(CheckUtil.chkTrim(sht.getCell(9, i).getContents()));
					// K.住宅总幢数（不含别墅）
					bean.setZzzzggs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(10, i).getContents()),
							"住宅总幢数(不含别墅)填写不正确或有空行,请检查" + (i + 1) + "行"));
					// L.独门院落
					bean.setDmylgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(11, i).getContents()),
							"独院填写不正确或有空行,请检查" + (i + 1) + "行"));
					// M.低层住宅
					bean.setDczzgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(12, i).getContents()),
							"低层填写不正确或有空行,请检查" + (i + 1) + "行"));
					// N.多层住宅
					bean.setDuczzgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(13, i).getContents()),
							"多层填写不正确或有空行,请检查" + (i + 1) + "行"));
					// O.中高层住宅
					bean.setZgczzgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(14, i).getContents()),
							"中高层填写不正确或有空行,请检查" + (i + 1) + "行"));
					// P.高层
					bean.setGczzgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(15, i).getContents()),
							"高层填写不正确或有空行,请检查" + (i + 1) + "行"));
					// Q.超高层
					bean.setCgczzgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(16, i).getContents()),
							"超高层填写不正确或有空行,请检查" + (i + 1) + "行"));
					// R.别墅总幢数
					bean.setBszzsgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(17, i).getContents()),
							"别墅总幢数填写不正确或有空行,请检查" + (i + 1) + "行"));
					// S.独栋别墅
					bean.setDdbsgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(18, i).getContents()),
							"独栋别墅填写不正确或有空行,请检查" + (i + 1) + "行"));
					// T.双拼别墅
					bean.setSpbsgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(19, i).getContents()),
							"双拼别墅填写不正确或有空行,请检查" + (i + 1) + "行"));
					// U.联排别墅
					bean.setLpbsgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(20, i).getContents()),
							"联排别墅填写不正确或有空行,请检查" + (i + 1) + "行"));
					// V.土地面积
					bean.setTdmj(dealDoubleContent(
							CheckUtil.chkTrim(sht.getCell(21, i).getContents()),
							"土地面积填写不正确或有空行,请检查" + (i + 1) + "行"));
					// W.建筑面积
					bean.setJzmj(dealDoubleContent(
							CheckUtil.chkTrim(sht.getCell(22, i).getContents()),
							"建筑面积填写不正确或有空行,请检查" + (i + 1) + "行"));
					// X.开发时间
					bean.setKfsj(CheckUtil.chkTrim(sht.getCell(23, i).getContents()));
					// Y.容积率
					bean.setRjl(dealDoubleContent(
							CheckUtil.chkTrim(sht.getCell(24, i).getContents()),
							"容积率填写不正确或有空行,请检查" + (i + 1) + "行"));
					// Z.公交条数
					bean.setGjtgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(25, i).getContents()),
							"公交条数填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AA.菜市场数
					bean.setCscgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(26, i).getContents()),
							"菜市场数填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AB.物业管理
					bean.setWyglgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(27, i).getContents()),
							"物业管理填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AC.停车位
					bean.setTcwgs(dealIntegerContent(
							CheckUtil.chkTrim(sht.getCell(28, i).getContents()),
							"停车位填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AD.绿化率
					bean.setLhl(dealDoubleContent(
							CheckUtil.chkTrim(sht.getCell(29, i).getContents()),
							"绿化率填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AE.暖气
					bean.setNq(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(30, i).getContents()),
							"暖气填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AF.天然气
					bean.setTrq(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(31, i).getContents()),
							"天然气填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AG.自备深水井
					bean.setZbssj(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(32, i).getContents()),
							"自备深水井填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AH.幼儿园
					bean.setYey(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(33, i).getContents()),
							"幼儿园填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AI.小学
					bean.setXx(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(34, i).getContents()),
							"小学填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AJ.中学
					bean.setZx(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(35, i).getContents()),
							"中学填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AK.商场
					bean.setSc(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(36, i).getContents()),
							"商场填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AL.体育场馆
					bean.setTycg(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(37, i).getContents()),
							"体育场馆填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AM.市级医院
					bean.setSjyy(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(38, i).getContents()),
							"市级医院填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AN.声、气污染
					bean.setSqwr(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(39, i).getContents()),
							"声、气污染填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AO.河流湖水面
					bean.setHlhsm(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(40, i).getContents()),
							"河流湖水面填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AP.公园
					bean.setGy(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(41, i).getContents()),
							"公园填写不正确或有空行,请检查" + (i + 1) + "行"));
					// AQ.娱乐场所
					bean.setYlcs(dealBooleanContent(
							CheckUtil.chkTrim(sht.getCell(42, i).getContents()),
							"娱乐场所填写不正确或有空行,请检查" + (i + 1) + "行"));
					bean.setCd00001Ssgx(ssgx);
					bean.setCd00002Czr(userId);
					resultList.add(bean);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					bean = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}
	
	/**
	 * 处理单元格整形情况
	 * 
	 * @param str
	 * @param errorMsg
	 * @return
	 * @throws Exception
	 */
	private static Integer dealIntegerContent(String str, String errorMsg)
			throws Exception {
		Integer result = null;
		try {
			result = Integer.parseInt(str);
		} catch (Exception e) {
			throw new Exception(errorMsg);
		}
		return result;
	}	
	
	/**
	 * 处理单元格布尔值情况
	 * 
	 * @param str
	 * @param errorMsg
	 * @return
	 * @throws Exception
	 */
	private static Integer dealBooleanContent(String str, String errorMsg)
			throws Exception {
		Integer result = null;
		if ("有".equals(str)) {
			result = 1;
		} else if ("无".equals(str)) {
			result = 0;
		} else {
			throw new Exception(errorMsg);
		}
		return result;
	}	

	/**
	 * 处理单元格双精度情况
	 * 
	 * @param str
	 * @param errorMsg
	 * @return
	 * @throws Exception
	 */
	private static Double dealDoubleContent(String str, String errorMsg)
			throws Exception {
		Double result = null;
		try {
			result = Double.parseDouble(str);
		} catch (Exception e) {
			throw new Exception(errorMsg);
		}
		return result;
	}

	
	/**
	 * 导出通用Excel文件
	 * 
	 * @param gpsjList
	 * @return
	 */
	public static OutputStream exportCommonDataSZMSSY(
			ArrayList<Pgv02050> ebList, Integer exportType) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		// 创建excel对象
		Label label;
		WritableWorkbook workbook = null;
		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的数据", 0);
			// 导出列格式1
			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);
			wcf1.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf1.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf1.setBackground(Colour.GREEN);

			// 导出列格式2
			WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf2 = new WritableCellFormat(wf2);
			wcf2.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf2.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf2.setBackground(Colour.ORANGE);

			// 写入表头

			// A.行政区域
			label = new Label(0, 0, "所在区域", wcf1);
			sheet.addCell(label);
			// B.分区
			label = new Label(1, 0, "小区名称", wcf1);
			sheet.addCell(label);
			// C.街道门牌号
			label = new Label(2, 0, "街道门牌号", wcf1);
			sheet.addCell(label);
			// D.东面描述
			label = new Label(3, 0, "东面描述", wcf1);
			sheet.addCell(label);
			// E.西面描述
			label = new Label(4, 0, "西面描述", wcf1);
			sheet.addCell(label);
			// F.南面描述
			label = new Label(5, 0, "南面描述", wcf1);
			sheet.addCell(label);
			// G.北面描述
			label = new Label(6, 0, "北面描述", wcf1);
			sheet.addCell(label);
			// H.小区代码号
			label = new Label(7, 0, "分区代码号", wcf1);
			sheet.addCell(label);
			// I.小区类型
			label = new Label(8, 0, "小区类型", wcf1);
			sheet.addCell(label);
			// J.房屋类型
			label = new Label(9, 0, "房屋类型", wcf1);
			sheet.addCell(label);
			// K.住宅总幢数
			label = new Label(10, 0, "住宅总幢数(不含别墅)", wcf1);
			sheet.addCell(label);
			// L.独院
			label = new Label(11, 0, "独院", wcf1);
			sheet.addCell(label);
			// M.低层
			label = new Label(12, 0, "低层", wcf1);
			sheet.addCell(label);
			// N.多层
			label = new Label(13, 0, "多层", wcf1);
			sheet.addCell(label);
			// O.中高层
			label = new Label(14, 0, "中高层", wcf1);
			sheet.addCell(label);
			// P.高层
			label = new Label(15, 0, "高层", wcf1);
			sheet.addCell(label);
			// Q.超高层
			label = new Label(16, 0, "超高层", wcf1);
			sheet.addCell(label);
			// R.别墅总幢数
			label = new Label(17, 0, "别墅总幢数", wcf1);
			sheet.addCell(label);
			// S.独栋别墅
			label = new Label(18, 0, "独栋别墅", wcf1);
			sheet.addCell(label);
			// T.双拼别墅
			label = new Label(19, 0, "双拼别墅", wcf1);
			sheet.addCell(label);
			// U.联排别墅
			label = new Label(20, 0, "联排别墅", wcf1);
			sheet.addCell(label);
			// V.土地面积
			label = new Label(21, 0, "土地面积(㎡)", wcf1);
			sheet.addCell(label);
			// W.建筑面积
			label = new Label(22, 0, "建筑面积(㎡)", wcf1);
			sheet.addCell(label);
			// X.开发时间
			label = new Label(23, 0, "开发时间", wcf1);
			sheet.addCell(label);
			// Y.容积率
			label = new Label(24, 0, "容积率", wcf1);
			sheet.addCell(label);
			// Z.公交条数
			label = new Label(25, 0, "公交条数", wcf1);
			sheet.addCell(label);
			// AA.菜市场数
			label = new Label(26, 0, "菜市场数", wcf1);
			sheet.addCell(label);
			// AB.物业管理
			label = new Label(27, 0, "物业管理", wcf1);
			sheet.addCell(label);
			// AC.停车位
			label = new Label(28, 0, "停车位", wcf1);
			sheet.addCell(label);
			// AD.绿化率
			label = new Label(29, 0, "绿化率", wcf1);
			sheet.addCell(label);
			// AE.暖气
			label = new Label(30, 0, "暖气", wcf1);
			sheet.addCell(label);
			// AF.天然气
			label = new Label(31, 0, "天然气", wcf1);
			sheet.addCell(label);
			// AG.自备深水井
			label = new Label(32, 0, "自备深水井", wcf1);
			sheet.addCell(label);
			// AH.幼儿园
			label = new Label(33, 0, "幼儿园", wcf1);
			sheet.addCell(label);
			// AI. 小学
			label = new Label(34, 0, "小学", wcf1);
			sheet.addCell(label);
			// AJ. 中学
			label = new Label(35, 0, "中学", wcf1);
			sheet.addCell(label);
			// AK. 商场
			label = new Label(36, 0, "商场", wcf1);
			sheet.addCell(label);
			// AL. 体育场馆
			label = new Label(37, 0, "体育常馆", wcf1);
			sheet.addCell(label);
			// AM. 市级医院
			label = new Label(38, 0, "市级医院", wcf1);
			sheet.addCell(label);
			// AN. 声、气污染
			label = new Label(39, 0, "声、气污染", wcf1);
			sheet.addCell(label);
			// AO. 河流湖水面
			label = new Label(40, 0, "河流湖水面", wcf1);
			sheet.addCell(label);
			// AP. 公园
			label = new Label(41, 0, "公园", wcf1);
			sheet.addCell(label);
			// AQ. 娱乐场所
			label = new Label(42, 0, "娱乐场所", wcf1);
			sheet.addCell(label);
			// AR.错误信息
			label = new Label(43, 0, "错误信息", wcf1);
			sheet.addCell(label);

			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);

			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				// A.行政区域
				label = SzqyLable(0, i + 1, ebList.get(i).getSzqy(), ebList
						.get(i).getCd00001Szqy(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// B.分区
				label = myDZLable(1, i + 1, ebList.get(i).getXqnm(), ebList
						.get(i).getXqdm(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// C.街道门牌号
				label = new Label(2, i + 1, ebList.get(i).getJdmph());
				sheet.addCell(label);
				// D.东面描述
				label = new Label(3, i + 1, ebList.get(i).getDmms());
				sheet.addCell(label);
				// E.西面描述
				label = new Label(4, i + 1, ebList.get(i).getXmms());
				sheet.addCell(label);
				// F.南面描述
				label = new Label(5, i + 1, ebList.get(i).getNmms());
				sheet.addCell(label);
				// G.北面描述
				label = new Label(6, i + 1, ebList.get(i).getBmms());
				sheet.addCell(label);
				// H.小区代码号
				label = myDZLable(7, i + 1, ebList.get(i).getXqdmhm(), ebList
						.get(i).getDmhId(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// I.小区类型
				label = new Label(8, i + 1, ebList.get(i).getXqlx());
				sheet.addCell(label);
				// J.房屋类型
				label = new Label(9, i + 1, ebList.get(i).getFwlx());
				sheet.addCell(label);
				// K.住宅总幢数(不包含别墅)
				label = new Label(10, i + 1,
						ebList.get(i).getZzzzggs() == null ? "0" : ebList
								.get(i).getZzzzggs().toString());
				sheet.addCell(label);
				// L.独院
				label = new Label(11, i + 1,
						ebList.get(i).getDmylgs() == null ? "0" : ebList.get(i)
								.getDmylgs().toString());
				sheet.addCell(label);
				// M.低层
				label = new Label(12, i + 1,
						ebList.get(i).getDczzgs() == null ? "0" : ebList.get(i)
								.getDczzgs().toString());
				sheet.addCell(label);
				// N.多层
				label = new Label(13, i + 1,
						ebList.get(i).getDuczzgs() == null ? "0" : ebList
								.get(i).getDuczzgs().toString());
				sheet.addCell(label);
				// O.中高层
				label = new Label(14, i + 1,
						ebList.get(i).getZgczzgs() == null ? "0" : ebList
								.get(i).getZgczzgs().toString());
				sheet.addCell(label);
				// P.高层
				label = new Label(15, i + 1,
						ebList.get(i).getGczzgs() == null ? "0" : ebList.get(i)
								.getGczzgs().toString());
				sheet.addCell(label);
				// Q.超高层
				label = new Label(16, i + 1,
						ebList.get(i).getCgczzgs() == null ? "0" : ebList
								.get(i).getCgczzgs().toString());
				sheet.addCell(label);
				// R.别墅总幢数
				label = new Label(17, i + 1,
						ebList.get(i).getBszzsgs() == null ? "0" : ebList
								.get(i).getBszzsgs().toString());
				sheet.addCell(label);
				// S.独栋别墅
				label = new Label(18, i + 1,
						ebList.get(i).getDdbsgs() == null ? "0" : ebList.get(i)
								.getDdbsgs().toString());
				sheet.addCell(label);
				// T.双拼别墅
				label = new Label(19, i + 1,
						ebList.get(i).getSpbsgs() == null ? "0" : ebList.get(i)
								.getSpbsgs().toString());
				sheet.addCell(label);
				// U.联排别墅
				label = new Label(20, i + 1,
						ebList.get(i).getLpbsgs() == null ? "0" : ebList.get(i)
								.getLpbsgs().toString());
				sheet.addCell(label);
				// V.土地面积
				label = new Label(21, i + 1,
						ebList.get(i).getTdmj() == null ? "0" : ebList.get(i)
								.getTdmj().toString());
				sheet.addCell(label);
				// W.建筑面积
				label = new Label(22, i + 1,
						ebList.get(i).getJzmj() == null ? "0" : ebList.get(i)
								.getJzmj().toString());
				sheet.addCell(label);
				// X.开发时间
				label = new Label(23, i + 1, ebList.get(i).getKfsj());
				sheet.addCell(label);
				// Y.容积率
				label = new Label(24, i + 1,
						ebList.get(i).getRjl() == null ? "0" : ebList.get(i)
								.getRjl().toString());
				sheet.addCell(label);
				// Z.公交条数
				label = new Label(25, i + 1,
						ebList.get(i).getGjtgs() == null ? "0" : ebList.get(i)
								.getGjtgs().toString());
				sheet.addCell(label);
				// AA.菜市场数
				label = new Label(26, i + 1,
						ebList.get(i).getCscgs() == null ? "0" : ebList.get(i)
								.getCscgs().toString());
				sheet.addCell(label);
				// AB.物业管理
				label = new Label(27, i + 1,
						ebList.get(i).getWyglgs() == null ? "0" : ebList.get(i)
								.getWyglgs().toString());
				sheet.addCell(label);
				// AC.停车位
				label = new Label(28, i + 1,
						ebList.get(i).getTcwgs() == null ? "0" : ebList.get(i)
								.getTcwgs().toString());
				sheet.addCell(label);
				// AD.绿化率
				label = new Label(29, i + 1,
						ebList.get(i).getLhl() == null ? "0" : ebList.get(i)
								.getLhl().toString());
				sheet.addCell(label);
				// AE.暖气
				label = new Label(30, i + 1, ebList.get(i).getNq() == 1 ? "有"
						: "无");
				sheet.addCell(label);
				// AF.天然气
				label = new Label(31, i + 1, ebList.get(i).getTrq() == 1 ? "有"
						: "无");
				sheet.addCell(label);
				// AG.自备深水井
				label = new Label(32, i + 1,
						ebList.get(i).getZbssj() == 1 ? "有" : "无");
				sheet.addCell(label);
				// AH.幼儿园
				label = new Label(33, i + 1, ebList.get(i).getYey() == 1 ? "有"
						: "无");
				sheet.addCell(label);
				// AI.小学
				label = new Label(34, i + 1, ebList.get(i).getXx() == 1 ? "有"
						: "无");
				sheet.addCell(label);
				// AJ.中学
				label = new Label(35, i + 1, ebList.get(i).getZx() == 1 ? "有"
						: "无");
				sheet.addCell(label);
				// AK.商场
				label = new Label(36, i + 1, ebList.get(i).getSc() == 1 ? "有"
						: "无");
				sheet.addCell(label);
				// AL.体育场馆
				label = new Label(37, i + 1, ebList.get(i).getTycg() == 1 ? "有"
						: "无");
				sheet.addCell(label);
				// AM.市级医院
				label = new Label(38, i + 1, ebList.get(i).getSjyy() == 1 ? "有"
						: "无");
				sheet.addCell(label);
				// AN.声、气污染
				label = new Label(39, i + 1, ebList.get(i).getSqwr() == 1 ? "有"
						: "无");
				sheet.addCell(label);
				// AO.河流湖水面
				label = new Label(40, i + 1,
						ebList.get(i).getHlhsm() == 1 ? "有" : "无");
				sheet.addCell(label);
				// AP. 公园
				label = new Label(41, i + 1, ebList.get(i).getGy() == 1 ? "有"
						: "无");
				sheet.addCell(label);
				// AQ.娱乐场所
				label = new Label(42, i + 1, ebList.get(i).getYlcs() == 1 ? "有"
						: "无");
				sheet.addCell(label);
				// AR.错误信息
				label = new Label(43, i + 1, ebList.get(i).getImpErrorMsg());
				sheet.addCell(label);

			}

			workbook.write();
		} catch (Exception e) {
			// e.printStackTrace();
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}	
	
	
	/**
	 * 导入商业建筑层次修正
	 */
	public static ArrayList<Pgv02052> importDataJZCCXZ(String sourceFile,
			String userId, String ssgx) throws Exception {
		ArrayList<Pgv02052> resultList = new ArrayList<Pgv02052>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);

				for (int i = 1; i < rowSheet; i++) {
					Pgv02052 bean = new Pgv02052();
					try {

						// A.所在区域
						String szqy = CheckUtil.chkTrim(sht.getCell(0, i)
								.getContents());
						/*
						 * if(CheckUtil.chkEmpty(szqy)){ bean.setSzqy(szqy);
						 * }else{ throw new Exception("所在区域为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setSzqy(ExcelUtil.excelIsEmpty(szqy, "所在区域", i));
						// B.房屋类别
						bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(1, i)
								.getContents(), "房屋类型", i));
						// String fwlx =
						// CheckUtil.chkTrim(sht.getCell(1,i).getContents());
						// if(CheckUtil.chkEmpty(fwlx)){
						// bean.setFwlx(fwlx);
						// }else{
						// throw new Exception("房屋类型为空，请检查第" + (i+1) + "条");
						// }
						// C.楼层
						String lc = CheckUtil.chkTrim(sht.getCell(2, i).getContents());
						/*
						 * if(CheckUtil.chkEmpty(lc)){ bean.setLc(lc); }else{
						 * throw new Exception("所在楼层为空，请检查第"+(i+1)+"条数据"); }
						 */
						bean.setLc(ExcelUtil.excelIsEmpty(lc, "所在楼层", i));
						// D.总楼层
						String zlc = CheckUtil.chkTrim(sht.getCell(3, i)
								.getContents());
						if (CheckUtil.chkEmpty(zlc) || zlc.length() > 2) {
							Exception e = new Exception("总楼层格式不正确，请核实第"
									+ (i + 1) + "条数据");
							throw e;

						} else {
							try {
								bean.setZcs(zlc.toUpperCase());
							} catch (Exception e) {
								Exception e1 = new Exception("总楼层格式不正确，请核实第"
										+ (i + 1) + "条数据");
								throw e1;
							}
							// bean.setZcs(ConvertUtil.toShort(sht.getCell(3,i).getContents()));
						}

						// 判断总楼层是否小于所在楼层
						// if(bean.getZcs() < bean.getLc()){
						// continue;
						// }

						// E.修正值
						try {
							String value = CheckUtil.chkTrim(sht.getCell(4, i)
									.getContents());
							bean.setXzxs(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第"
									+ (i + 1) + "条数据");
							throw e1;
						}
						/*
						 * if(!CheckUtil.chkEmpty(sht.getCell(4,i).getContents(
						 * ))){
						 * bean.setXzxs(ConvertUtil.toDouble(sht.getCell(4
						 * ,i).getContents())); }else{ double j = 0;
						 * bean.setXzxs(j); }
						 */
						bean.setCd00002Czr(userId);
						bean.setCd00001Ssgx(ssgx);
						resultList.add(bean);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}	
	
	
	/**
	 * 导出错误格式商业建筑层次修正
	 */
	public static OutputStream exportDataJZCCXZ(ArrayList<Pgv02052> v02052List)
			throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的楼层修正数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "所在楼层", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "总楼层", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v02052List.size(); i++) {
				label = myLable(0, i + 1, v02052List.get(i).getSzqy(),
						v02052List.get(i).getCd00001Szqy(), wcf1);
				sheet.addCell(label);
				label = myLable(1, i + 1, v02052List.get(i).getFwlx(),
						v02052List.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = new Label(2, i + 1, v02052List.get(i).getLc()
						.toString());
				sheet.addCell(label);
				label = new Label(3, i + 1, v02052List.get(i).getZcs()
						.toString());
				sheet.addCell(label);
				label = new Label(4, i + 1, v02052List.get(i).getXzxs()
						.toString());
				sheet.addCell(label);
				label = new Label(5, i + 1, v02052List.get(i).getImpErrorMsg());
				sheet.addCell(label);

			}
			workbook.write();
		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}	
	

	/**
	 * 新导入商业建筑层次修正
	 */
	public static ArrayList<Pgv02052> importDataJZCCXZA(String sourceFile,
			String userId, String ssgx) throws Exception {
		ArrayList<Pgv02052> resultList = new ArrayList<Pgv02052>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);

				for (int i = 1; i < rowSheet; i++) {
					Pgv02052 bean = new Pgv02052();
					try {

						// A.所在区域
						String szqy = CheckUtil.chkTrim(sht.getCell(0, i)
								.getContents());
						/*
						 * if(CheckUtil.chkEmpty(szqy)){ bean.setSzqy(szqy);
						 * }else{ throw new Exception("所在区域为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setSzqy(ExcelUtil.excelIsEmpty(szqy, "所在区域", i));
						// B.代码号
						bean.setDmh(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// C.小区名称
						bean.setXqnm(CheckUtil.chkTrim(sht.getCell(2, i)
								.getContents()));

						// D.房屋类别
						bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(3, i)
								.getContents(), "房屋类型", i));
						// String fwlx =
						// CheckUtil.chkTrim(sht.getCell(3,i).getContents());
						// if(CheckUtil.chkEmpty(fwlx)){
						// bean.setFwlx(fwlx);
						// }else{
						// throw new Exception("房屋类型为空，请检查第" + (i+1) + "条");
						// }

						// E.楼层
						//
						String lc = CheckUtil.chkTrim(sht.getCell(4, i).getContents());
						/*
						 * if(CheckUtil.chkEmpty(lc)){ bean.setLc(lc); }else{
						 * throw new Exception("所在楼层为空，请检查第" + (i+1) + "条"); }
						 */
						bean.setLc(ExcelUtil.excelIsEmpty(lc, "所在楼层", i));
						// F.总楼层
						String zlc = CheckUtil.chkTrim(sht.getCell(5, i)
								.getContents());
						if (CheckUtil.chkEmpty(zlc) || zlc.length() > 2) {
							Exception e = new Exception("总楼层格式不正确，请核实第"
									+ (i + 1) + "条数据");
							throw e;

						} else {
							try {
								bean.setZcs(zlc.toUpperCase());
							} catch (Exception e) {
								Exception e1 = new Exception("总楼层格式不正确，请核实第"
										+ (i + 1) + "条数据");
								throw e1;
							}
							// bean.setZcs(ConvertUtil.toShort(sht.getCell(3,i).getContents()));
						}

						// 判断总楼层是否小于所在楼层
						// if(bean.getZcs() < bean.getLc()){
						// continue;
						// }
						// G.修正值
						try {
							String value = CheckUtil.chkTrim(sht.getCell(6, i)
									.getContents());
							bean.setXzxs(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第"
									+ (i + 1) + "条数据");
							throw e1;
						}

						/*
						 * if(!CheckUtil.chkEmpty(sht.getCell(6,i).getContents(
						 * ))){
						 * bean.setXzxs(ConvertUtil.toDouble(sht.getCell(6
						 * ,i).getContents())); }else{ double j = 0;
						 * bean.setXzxs(j); }
						 */
						bean.setCd00002Czr(userId);
						bean.setCd00001Ssgx(ssgx);
						resultList.add(bean);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}	
	

	/**
	 * 新导出错误格式商业建筑层次修正
	 */
	public static OutputStream exportDataJZCCXZA(ArrayList<Pgv02052> v02052List)
			throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的楼层修正数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "代码号", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "小区名称", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "所在楼层", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "总楼层", wcf);
			sheet.addCell(label);
			label = new Label(6, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			label = new Label(7, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v02052List.size(); i++) {
				label = myDZLable(0, i + 1, v02052List.get(i).getSzqy(),
						v02052List.get(i).getCd00001Szqy(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myDZLable(1, i + 1, v02052List.get(i).getDmh(),
						v02052List.get(i).getDmhId(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myDZLable(2, i + 1, v02052List.get(i).getXqnm(),
						v02052List.get(i).getCd02050Xqdm(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myLable(3, i + 1, v02052List.get(i).getFwlx(),
						v02052List.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = new Label(4, i + 1, v02052List.get(i).getLc()
						.toString());
				sheet.addCell(label);
				label = new Label(5, i + 1, v02052List.get(i).getZcs()
						.toString());
				sheet.addCell(label);
				label = new Label(6, i + 1, v02052List.get(i).getXzxs()
						.toString());
				sheet.addCell(label);
				label = new Label(7, i + 1, v02052List.get(i).getImpErrorMsg());
				sheet.addCell(label);

			}
			workbook.write();
		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}	
	
	/**
	 * 解析通用Excel文件
	 * @param sourceFile 文件路径
	 * @return 文件中的数据集
	 */
//	public static ArrayList<Pgv02053> ZHXZExcel_SP(String sourceFile, String userId, String ssgx)throws Exception{
//		ArrayList<Pgv02053> resultList = new ArrayList<Pgv02053>();
//		Sheet sht = null;
//		InputStream is = null;
//		Workbook wb= null;
//		try{
//			sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
//		    is = new FileInputStream(sourceFile);
//		    wb = Workbook.getWorkbook(is);
//		    if(wb.getNumberOfSheets()>0)
//		    	sht = wb.getSheet(0);
////			int rowSheet = sht.getRows();
//			//有效行数
//			int rowSheet = getValidRowNumbers(sht.getRows(),sht);
//			
//			for(int i=1; i<rowSheet; i++){
//				Pgv02053 bean = new Pgv02053();
//				try{
//					//A. 所在区域
//					bean.setSzqy(CheckUtil.chkTrim(sht.getCell(0,i).getContents()));
//					//C. 房屋类型
//					bean.setFwlx(CheckUtil.chkTrim(sht.getCell(1,i).getContents()));
//					//B.类型名称
//					bean.setLxmc(CheckUtil.chkTrim(sht.getCell(2,i).getContents()));					
//					//D.修正值
//				    try{
//				    	String xzxs = CheckUtil.chkTrim(sht.getCell(3,i).getContents());
//				    	bean.setXzxs(Double.parseDouble(xzxs));
//				    }catch(Exception e){
//				    	Exception e1 =new Exception("修正系数格式不正确，请核实"+i+"条数据");
//				    	throw e1;
//				    }
//					//E. 运算类型
//					bean.setCzlx(CheckUtil.chkTrim(sht.getCell(4,i).getContents()).equals("乘")?0:1);
//					//F. 备注
////					bean.setNote(sht.getCell(6,i).getContents());
//					bean.setCd00001Ssgx(ssgx);
//					bean.setCd00002Czr(userId);
//					bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
//					resultList.add(bean);
//				}catch (Exception e) {
//					e.printStackTrace();
//					throw e;
//				}finally{
//					bean = null;
//				}
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}finally {
//			if(null != is){
//				try{
//					is.close();
//				}catch(Exception e){}
//			}
//			if(null != wb){
//				try{
//					wb.close();
//				}catch(Exception e){}
//			}
//		}
//		return resultList;
//	}	
	
	/**
	 * 商铺，导出“综合修正数据”
	 * @param ebList
	 * @return
	 */
//	public static OutputStream exportDataZHXZ_SP(ArrayList<Pgv02053> ebList, Integer exportType){
//		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
//		// 创建excel对象
//        Label label;   
//        Number number;
//        WritableWorkbook workbook; 
//        try {
//        	workbook = Workbook.createWorkbook(strBufResult);
//            WritableSheet sheet = workbook.createSheet("错误数据", 0);
//            WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
//            WritableCellFormat wcf = new WritableCellFormat(wf); 
//            wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
//            wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
//            wcf.setBackground(Colour.GREEN);
//            int j = 0;
//            // 写入表头
//
//            //A.所在区域
//    		label = new Label(j++, 0, "所在区域" ,wcf);
//    		sheet.addCell(label);
//    		//B.房屋类型	
//    		label = new Label(j++, 0, "房屋类型" ,wcf);
//    		sheet.addCell(label);
//    		//A.所在区域
//    		label = new Label(j++, 0, "类型名称" ,wcf);
//    		sheet.addCell(label);			
//    		//E.修正值(元)
//    		label = new Label(j++, 0, "修正值(%)" ,wcf);
//    		sheet.addCell(label);
//    		//F.运算类型	
//    		label = new Label(j++, 0, "运算类型" ,wcf);
//    		sheet.addCell(label);
////    		//G.备注
////    		label = new Label(j++, 0, "备注" ,wcf);
////    		sheet.addCell(label);
//    		//H.错误信息
//    		label = new Label(j++, 0, "错误信息" ,wcf);
//    		sheet.addCell(label);
//    		//定义错误数据样式1
//    		WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.RED);
//            WritableCellFormat ewcf1 = new WritableCellFormat(ewf1); 
//    		// 写入数据
//    		for (int i = 0; i < ebList.size(); i++) {
//    			j = 0;
//    			//A. 所在区域
//					label = SzqyLable(j++, i+1, ebList.get(i).getSzqy(), ebList.get(i).getCd00001Szqy(), ewcf1, "(不存在)");
//					sheet.addCell(label);
//				//K. 房屋类别
//					label = myLable(j++, i+1, ebList.get(i).getFwlx(), ebList.get(i).getCd00001Fwlx(), ewcf1);
//					sheet.addCell(label);	
//				//A. 类别名称
//					label = myLable(j++, i+1, ebList.get(i).getLxmc(), ebList.get(i).getCd00001Infoid(), ewcf1);
//					sheet.addCell(label);			
//	    		//E.修正值(元)
//					number = new Number(j++, i+1, ebList.get(i).getXzxs());
//					sheet.addCell(number);
//	    		//F.运算类型	
//					label = new Label(j++, i+1, ebList.get(i).getCzlx()==0?"乘":"加");
//					sheet.addCell(label);
////	    		//G.备注
////					label = new Label(j++, i+1, ebList.get(i).getNote().toString());
////					sheet.addCell(label);
//				//H.错误信息
//					label = new Label(j++, i+1, ebList.get(i).getCwxx().toString());
//					sheet.addCell(label);
//			}
//    		
//		  workbook.write();  
//	      workbook.close();  
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return strBufResult;
//	}

	/**
	 * 交易价格指数导入
	 * @param txtFilePath
	 * @param userId
	 * @param get
	 * @return
	 */

	public static ArrayList<Pgv02056> importDataJyjgzs_SP(String txtFilePath,String userId, String sourceFile)throws Exception {
		ArrayList<Pgv02056> resultList =new ArrayList<Pgv02056>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		try{
		     is = new FileInputStream(txtFilePath);
		     wb = Workbook.getWorkbook(is);
		    if(wb.getNumberOfSheets()>0)
		    	sht = wb.getSheet(0);
		    else
		    	return resultList;
			int rowSheet = sht.getRows();
			for(int i=1; i<rowSheet; i++){
				Pgv02056 bean = new Pgv02056();

				try{
					//A.所在区域
					bean.setSzqy(sht.getCell(0,i).getContents());	
					//B.评税时点
					try{
					String value=CheckUtil.chkTrim(sht.getCell(1,i).getContents());
					bean.setCd00002Pssd(String.valueOf(Integer.parseInt(value)).toString());
					}catch(Exception e){
						Exception e1 = new Exception("估价时点格式不正确,请核实第"+i+"条数据");
					    throw e1;
					}
				   //C.修正系数
					try{
						String value = CheckUtil.chkTrim(sht.getCell(2,i).getContents()); 
						bean.setXzxs(Double.parseDouble(value));
					}catch(Exception e){
						Exception e1 = new Exception("修正系数格式不正确,请核实第"+i+"条数据");
					    throw e1;
					}
					//税收管辖
					bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
					bean.setCd00002Czr(userId);
					resultList.add(bean);
				}catch (Exception e) {
					e.printStackTrace();
					throw e;
				}finally{
					bean = null;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
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
	
	public static OutputStream exportDataJyjgzs_SP(ArrayList<Pgv02056> ebList){
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		// 创建excel对象
        Label label;   
        Number number;
        WritableWorkbook workbook; 
        try {
        	workbook = Workbook.createWorkbook(strBufResult);
            WritableSheet sheet = workbook.createSheet("错误数据", 0);
            WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
            WritableCellFormat wcf = new WritableCellFormat(wf); 
            wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
            wcf.setBackground(Colour.GREEN);
            int j = 0;
            // 写入表头

            //A.所在区域
    		label = new Label(j++, 0, "所在区域" ,wcf);
    		sheet.addCell(label);
    		//B.评税时点
    		label = new Label(j++, 0, "评税时点" ,wcf);
    		sheet.addCell(label);
			//C.修正值
    		label = new Label(j++, 0, "修正值" ,wcf);
    		sheet.addCell(label);
    		//D.错误信息
    		label = new Label(j++, 0, "错误信息" ,wcf);
    		sheet.addCell(label);
    		//定义错误数据样式1
    		WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.RED);
            WritableCellFormat ewcf1 = new WritableCellFormat(ewf1); 
    		// 写入数据
    		for (int i = 0; i < ebList.size(); i++) {
    			j = 0;
    			//A. 所在区域
					label = SzqyLable(j++, i+1, ebList.get(i).getSzqy(), ebList.get(i).getSzqyId(), ewcf1, "(不存在)");
					sheet.addCell(label);
			 		//B.评税时点
					label = new Label(j++, i+1, ebList.get(i).getCd00002Pssd());
					sheet.addCell(label);
					//C.修正值
					number = new Number(j++, i+1, ebList.get(i).getXzxs());
					sheet.addCell(number);
					//D.错误信息
					label = new Label(j++, i+1, ebList.get(i).getCwxx());
					sheet.addCell(label);	
	    		
			}
    		
		  workbook.write();  
	      workbook.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strBufResult;
	}
			
	/*
	private static Date valiExcelDateIsEmpty(String str, String msg, Integer i)
			throws Exception {
		if (!CheckUtil.chkEmpty(str)) {
			return ConvertUtil.toUtilDate(str);
		} else {
			Exception e = new Exception(msg + "数据格式不正确或者有空行，请核实第" + (i + 1)
					+ "条");
			throw e;
		}

	}	*/
	
	/**
	 * 商业标准房市场法解析通用Excel文件
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 */
	public static ArrayList<ExcelBean> resolveExcelSYSCF(String sourceFile,
			String userId, String ssgx, Integer SFSC) throws Exception {
		ArrayList<ExcelBean> resultList = new ArrayList<ExcelBean>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0)
				sht = wb.getSheet(0);
			else
				return resultList;
			// int rowSheet = sht.getRows();
			// 有效行数
			int rowSheet = getValidRowNumbers(sht.getRows(), sht);
			//检查导入的条数
			chkRowNum(rowSheet);
			for (int i = 1; i < rowSheet; i++) {
				ExcelBean bean = new ExcelBean();
				try {
					// A.行政区域
					/*
					 * String szqy =
					 * CheckUtil.chkTrim(sht.getCell(0,i).getContents());
					 * if(CheckUtil.chkEmpty(szqy)){ bean.setSzqyNm(szqy); }else{
					 * throw new Exception("所在区域为空请检查,第"+ (i+1) +"条"); }
					 */
					bean.setSzqyNm(ExcelUtil.excelIsEmpty(sht.getCell(0, i)
							.getContents(), "所在区域", i));
					// D.小区代码号
					String xqDmh = CheckUtil.chkTrim(sht.getCell(1, i).getContents());
					bean.setDmh(xqDmh);
					// E.小区名称
					String xqnm = CheckUtil.chkTrim(sht.getCell(2, i).getContents());
					bean.setXqNm(xqnm);

					// H.房屋类别
					bean.setFwlxNm(ExcelUtil.excelIsEmpty(sht.getCell(3, i)
							.getContents(), "房屋类型", i));
					// String fwlxNm =
					// CheckUtil.chkTrim(sht.getCell(3,i).getContents());
					// if(CheckUtil.chkEmpty(fwlxNm)){
					// bean.setFwlxNm(fwlxNm);
					// }else{
					// throw new Exception("房屋类别为空请检查,第"+ (i+1) +"条");
					// }
					// J.基准时点
					bean.setJysj(ConvertUtil.toSqlDate(CheckUtil.chkTrim(sht
							.getCell(4, i).getContents())));
					// I.基准价格（元/㎡）
					if (!CheckUtil.chkEmpty(sht.getCell(5, i).getContents())) {
						try {
							String value = CheckUtil.chkTrim(sht.getCell(5, i)
									.getContents());
							bean.setPfmjg(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e1 = new Exception("基准价格格式不正确,第"
									+ (i + 1) + "条");
							throw e1;
						}
					} else {

						bean.setPfmjg(0.0);
					}

					
					bean.setCd00001Ssgx(ssgx);
					bean.setCd00002Czr(userId);
					bean.setSfsc(SFSC);
					resultList.add(bean);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					bean = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}	

	public static OutputStream exportCommonDataSYSCF(
			ArrayList<ExcelBean> ebList, Integer exportType, Integer sfsc)
			throws Exception {
		ByteArrayOutputStream strBufResult = null;
		// 创建excel对象
		Label label;
		WritableWorkbook workbook = null;
		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的数据", 0);
			// 导出列格式1
			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);
			wcf1.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf1.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf1.setBackground(Colour.GREEN);

			// 导出列格式2
			WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf2 = new WritableCellFormat(wf2);
			wcf2.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf2.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf2.setBackground(Colour.ORANGE);

			// 写入表头

			// A.行政区域
			label = new Label(0, 0, "所在区域", wcf1);
			sheet.addCell(label);
			// B.小区代码号
			label = new Label(1, 0, "小区代码号", wcf1);
			sheet.addCell(label);
			// D.分区
			label = new Label(2, 0, "小区名称", wcf1);
			sheet.addCell(label);
			// G.房屋类别
			label = new Label(3, 0, "房屋类型", wcf1);
			sheet.addCell(label);
			// J.基准试点
			label = new Label(4, 0, "基准时点", wcf1);
			sheet.addCell(label);
			// H.基准价格（元/㎡）
			/*if (sfsc == 0) {
				label = new Label(5, 0, "当前租赁单价(元/㎡.年)", wcf1);
			} else if (sfsc == 1) {*/
			label = new Label(5, 0, "当前单价(元/㎡)", wcf1);
			/*}*/
			sheet.addCell(label);
			

			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);

			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				// A.行珠区域
				label = SzqyLable(0, i + 1, ebList.get(i).getSzqyNm(), ebList
						.get(i).getSzqyId(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// B.小区代码号
				label = myDZLable(1, i + 1, ebList.get(i).getDmh(),
						ebList.get(i).getDmhId(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// D.分区
				label = myDZLable(2, i + 1, ebList.get(i).getXqNm(), ebList
						.get(i).getXqId(), ewcf1, "(不存在)");
				sheet.addCell(label);

				// G.房屋类别
				label = myLable(3, i + 1, ebList.get(i).getFwlxNm(), ebList
						.get(i).getFwlxId(), ewcf1);
				sheet.addCell(label);
				// J.基准时点
				Date jysj = ebList.get(i).getJysj();
				if (null != jysj) {
					label = new Label(4, i + 1, jysj.toString());
				} else {
					label = new Label(4, i + 1, "");
				}
				sheet.addCell(label);
				// H.基准价格（元/㎡）
				label = new Label(5, i + 1,  ebList.get(i).getPfmjg().toString());
				sheet.addCell(label);	

			}

			workbook.write();
		} catch (Exception e) {
			// e.printStackTrace();
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}
	
	public static ArrayList<Pgv02063> importDataQzbSY(String sourceFile,
			String userId, String ssgx) throws Exception {
		ArrayList<Pgv02063> resultList = new ArrayList<Pgv02063>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv02063 bean = new Pgv02063();
					try {
						// A.所在区域
						/*
						 * String szqy =
						 * CheckUtil.chkTrim(sht.getCell(0,i).getContents());
						 * if(!CheckUtil.chkEmpty(szqy)){ bean.setSzqy(szqy);
						 * }else{ throw new Exception("所在区域为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setSzqy(ExcelUtil.excelIsEmpty(sht.getCell(0, i)
								.getContents(), "所在区域", i));
						// 房屋用途
						bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(1, i)
								.getContents(), "房屋类型", i));
						// if(!CheckUtil.chkEmpty(sht.getCell(1,i).getContents()))
						// bean.setFwlx(Common.converType((sht.getCell(1,i).getContents()).trim()));
						// C.市场法权重比系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(2, i)
									.getContents());
							bean.setScqzb(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e1 = new Exception("市场法权重比修正系数格式不正确,请核实第"
									+ (i + 1) + "条数据");
							throw e1;
						}
						// C.收益法权重比系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(3, i)
									.getContents());
							bean.setSyqzb(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e1 = new Exception("收益法权重比修正系数格式不正确,请核实第"
									+ (i + 1) + "条数据");
							throw e1;
						}
						/*
						 * //D.更新时间 String update
						 * =CheckUtil.chkTrim(sht.getCell(4,i).getContents());
						 * bean.setUpddate
						 * (ConvertUtil.toTimestamp(update));
						 */
						// 税收管辖
						bean.setCd00002Czr(userId);
						bean.setCd00001Ssgx(ssgx);
						resultList.add(bean);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					} finally {
						// bean = null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}	
	
	public static OutputStream exportSYQzbCommonDataSY(
			ArrayList<Pgv02063> ebList, Integer exportType) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		// 创建excel对象
		Label label;
		WritableWorkbook workbook = null;
		int m = -1;
		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的资本化率系数修正数据", 0);
			// 导出列格式1
			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);
			wcf1.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf1.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf1.setBackground(Colour.GREEN);

			// 导出列格式2
			WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf2 = new WritableCellFormat(wf2);
			wcf2.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf2.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf2.setBackground(Colour.ORANGE);

			// 写入表头

			// B.行政区域
			label = new Label(++m, 0, "所在区域", wcf1);
			sheet.addCell(label);
			// C.房屋用途
			label = new Label(++m, 0, "房屋类型", wcf1);
			sheet.addCell(label);
			// D.市场法权重比(%)
			label = new Label(++m, 0, "市场法权重比(%)", wcf1);
			sheet.addCell(label);
			// E.收益法权重比(%)
			label = new Label(++m, 0, "收益法权重比(%)", wcf1);
			sheet.addCell(label);
			/*
			 * //F.更新时间 label = new Label(++m, 0, "更新时间" ,wcf1);
			 * sheet.addCell(label); //G.操作人 label = new Label(++m, 0, "操作人"
			 * ,wcf1); sheet.addCell(label);
			 */
			// H.错误信息
			label = new Label(++m, 0, "错误信息", wcf1);
			sheet.addCell(label);

			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);

			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				m = -1;

				// B.所在区域
				label = ISCZLable(++m, i + 1, ebList.get(i).getSzqy(), ebList
						.get(i).getCd00001Szqy(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// C.星级标准
				label = ISCZLable(++m, i + 1, ebList.get(i).getFwlx(), ebList
						.get(i).getCd00001Fwlx(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// D.市场法法权重比(%)
				label = new Label(++m, i + 1, ebList.get(i).getScqzb()
						.toString());
				sheet.addCell(label);
				// E.收益法权重比(%)
				label = new Label(++m, i + 1, ebList.get(i).getSyqzb()
						.toString());
				sheet.addCell(label);
				/*
				 * //F.更新时间 label = new Label(++m, i+1,
				 * ebList.get(i).getUpddate().toString()); sheet.addCell(label);
				 * //G.操作人 label = new Label(++m, i+1,
				 * ebList.get(i).getCd00002Czr().toString());
				 * sheet.addCell(label);
				 */
				// H.错误信息
				label = new Label(++m, i + 1, ebList.get(i).getImpErrorMsg());
				sheet.addCell(label);

			}

			workbook.write();
		} catch (Exception e) {
			// e.printStackTrace();
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}	
	
	private static Label ISCZLable(int c, int r, String cont, String flag,
			CellFormat cf, String errorMsg) {
		Label label = null;
		try {
			label = (CheckUtil.chkNull(flag).equals("N")) ? new Label(c, r, cont
					+ errorMsg, cf) : new Label(c, r, cont);
		} catch (Exception e) {

		}
		return label;
	}	
	
	/**
	 * 导入“收益法资本化率维护”
	 * 
	 * @param sourceFile
	 *            文件路径
	 * @return 文件中的数据集
	 * @throws Exception
	 */
	public static ArrayList<Pgv02057> importDataZbhsjSY(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv02057> resultList = new ArrayList<Pgv02057>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv02057 bean = new Pgv02057();
					try {
						// A.所在区域
						/*
						 * String szqy =
						 * CheckUtil.chkTrim(sht.getCell(0,i).getContents());
						 * if(!CheckUtil.chkEmpty(szqy)){ bean.setSzqy(szqy);
						 * }else{ throw new Exception("所在区域为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setSzqy(ExcelUtil.excelIsEmpty(sht.getCell(0, i)
								.getContents(), "所在区域", i));
						// 房屋用途
						bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(1, i)
								.getContents(), "房屋类型", i));
						// String fwlx=sht.getCell(1,i).getContents();
						// if(!CheckUtil.chkEmpty(fwlx)){
						// bean.setFwlx(Common.converType(fwlx.trim()));
						// }else{
						// throw new Exception("房屋类型为空，请检查第" + (i+1) + "条");
						// }
						// C.修正系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(2, i)
									.getContents());
							bean.setZbhl(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第"
									+ (i + 1) + "条数据");
							throw e1;
						}
						/*
						 * //D.更新时间 String update
						 * =CheckUtil.chkTrim(sht.getCell(3,i).getContents());
						 * bean.setUpddate
						 * (ConvertUtil.toTimestamp(update));
						 */
						// E.备注
						bean.setNote(CheckUtil.chkTrim(sht.getCell(3, i)
								.getContents()));
						bean.setCd00002Czr(userId);
						// 税收管辖
						bean.setCd00001Ssgx(ssgx);
						resultList.add(bean);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					} finally {
						// bean = null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}	

	public static ArrayList<Pgv02057> importDataZbhsjASY(String sourceFile,
			String userId, String ssgx) {
		ArrayList<Pgv02057> resultList = new ArrayList<Pgv02057>();
		Sheet sht = null;
		sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		try {
			InputStream is = new FileInputStream(sourceFile);
			Workbook wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0)
				sht = wb.getSheet(0);
			else
				return resultList;
			int rowSheet = sht.getRows();
			for (int i = 1; i < rowSheet; i++) {
				Pgv02057 bean = new Pgv02057();
				try {

					// 所在区域
					if (!CheckUtil.chkEmpty(sht.getCell(0, i).getContents()))
						bean.setSzqy(Common.converType((sht.getCell(0, i).getContents()).trim()));
					// C.代码号
					bean.setXqdmhm(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
					// D.小区名称
					bean.setXqnm(CheckUtil.chkTrim(sht.getCell(2, i).getContents()));
					// 房屋用途
					bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(3, i)
							.getContents(), "房屋类型", i));
					// if(!CheckUtil.chkEmpty(sht.getCell(3,i).getContents()))
					// bean.setFwlx(Common.converType((sht.getCell(3,i).getContents()).trim()));
					// 资本化率
					if (!CheckUtil.chkEmpty(sht.getCell(4, i).getContents()))
						bean.setZbhl(ConvertUtil.toDouble((sht.getCell(4, i)
								.getContents()).trim()));
					// //更新时间
					// bean.setUpddate(ConvertUtil.toTimestamp((sht.getCell(5,i).getContents()).trim()));
					// 操作人
					bean.setCd00002Czr(userId);
					// 备注
					if (!CheckUtil.chkEmpty(sht.getCell(5, i).getContents()))
						bean.setNote((sht.getCell(5, i).getContents()).trim());
					// 税收管辖
					bean.setCd00001Ssgx(ssgx);

					resultList.add(bean);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					bean = null;
				}
			}
			wb.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//
		}
		return resultList;
	}	

	public static OutputStream exportSYzbhlCommonDataSY(
			ArrayList<Pgv02057> ebList, Integer exportType) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		// 创建excel对象
		Label label;
		WritableWorkbook workbook = null;
		int m = -1;
		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的资本化率系数修正数据", 0);
			// 导出列格式1
			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);
			wcf1.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf1.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf1.setBackground(Colour.GREEN);

			// 导出列格式2
			WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf2 = new WritableCellFormat(wf2);
			wcf2.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf2.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf2.setBackground(Colour.ORANGE);

			// 写入表头

			// B.行政区域
			label = new Label(++m, 0, "所在区域", wcf1);
			sheet.addCell(label);
			// C.房屋用途
			label = new Label(++m, 0, "房屋类型", wcf1);
			sheet.addCell(label);
			// D.修正值(%)
			label = new Label(++m, 0, "修正值(%)", wcf1);
			sheet.addCell(label);
			/*
			 * //E.更新时间 label = new Label(++m, 0, "更新时间" ,wcf1);
			 * sheet.addCell(label);
			 */
			/*
			 * //F.操作人 label = new Label(++m, 0, "操作人" ,wcf1);
			 * sheet.addCell(label);
			 */
			// G.备注信息
			label = new Label(++m, 0, "备注信息", wcf1);
			sheet.addCell(label);
			// H.错误信息
			label = new Label(++m, 0, "错误信息", wcf1);
			sheet.addCell(label);

			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);

			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				m = -1;

				// B.所在区域
				label = ISCZLable(++m, i + 1, ebList.get(i).getSzqy(), ebList
						.get(i).getCd00001Szqy(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// C.星级标准
				label = ISCZLable(++m, i + 1, ebList.get(i).getFwlx(), ebList
						.get(i).getCd00001Fwlx(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// D.修正值(%)
				label = new Label(++m, i + 1, ebList.get(i).getZbhl()
						.toString());
				sheet.addCell(label);
				/*
				 * //E.更新时间 label = new Label(++m, i+1,
				 * ebList.get(i).getUpddate().toString()); sheet.addCell(label);
				 */
				/*
				 * //F.操作人 label = new Label(++m, i+1,
				 * ebList.get(i).getCd00002Czr().toString());
				 * sheet.addCell(label);
				 */
				// G.备注信息
				label = new Label(++m, i + 1, ebList.get(i).getNote());
				sheet.addCell(label);
				// H.错误信息
				label = new Label(++m, i + 1, ebList.get(i).getImpErrorMsg());
				sheet.addCell(label);

			}

			workbook.write();
		} catch (Exception e) {
			// e.printStackTrace();
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}
	
	public static OutputStream exportSYzbhlCommonDataASY(
			ArrayList<Pgv02057> ebList, Integer exportType) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		// 创建excel对象
		Label label;
		WritableWorkbook workbook = null;
		int m = -1;
		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的资本化率系数修正数据", 0);
			// 导出列格式1
			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);
			wcf1.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf1.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf1.setBackground(Colour.GREEN);

			// 导出列格式2
			WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf2 = new WritableCellFormat(wf2);
			wcf2.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf2.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcf2.setBackground(Colour.ORANGE);

			// B.行政区域
			label = new Label(++m, 0, "所在区域", wcf1);
			sheet.addCell(label);
			// C.代码号
			label = new Label(++m, 0, "代码号", wcf1);
			sheet.addCell(label);
			// D.小区名称
			label = new Label(++m, 0, "小区名称", wcf1);
			sheet.addCell(label);
			// E.房屋用途
			label = new Label(++m, 0, "房屋类型", wcf1);
			sheet.addCell(label);
			// F.修正值(%)
			label = new Label(++m, 0, "修正值(%)", wcf1);
			sheet.addCell(label);
			// I.备注信息
			label = new Label(++m, 0, "备注信息", wcf1);
			sheet.addCell(label);
			// J.错误信息
			label = new Label(++m, 0, "错误信息", wcf1);
			sheet.addCell(label);

			// 定义错误数据样式1
			WritableFont ewf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat ewcf1 = new WritableCellFormat(ewf1);

			// 写入数据
			for (int i = 0; i < ebList.size(); i++) {
				m = -1;

				// B.所在区域
				label = ISCZLable(++m, i + 1, ebList.get(i).getSzqy(), ebList
						.get(i).getCd00001Szqy(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// C.代码号
				label = ISCZLable(++m, i + 1, ebList.get(i).getXqdmhm(), ebList
						.get(i).getDmhId(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// D.小区名称
				label = ISCZLable(++m, i + 1, ebList.get(i).getXqnm(), ebList
						.get(i).getCd02050Xqdm(), ewcf1, "(不存在)");
				sheet.addCell(label);

				// E.星级标准
				label = ISCZLable(++m, i + 1, ebList.get(i).getFwlx(), ebList
						.get(i).getCd00001Fwlx(), ewcf1, "(不存在)");
				sheet.addCell(label);
				// F.修正值(%)
				label = new Label(++m, i + 1, ebList.get(i).getZbhl()
						.toString());
				sheet.addCell(label);
				// I.备注信息
				label = new Label(++m, i + 1, ebList.get(i).getNote());
				sheet.addCell(label);
				// J.错误信息
				label = new Label(++m, i + 1, ebList.get(i).getImpErrorMsg());
				sheet.addCell(label);

			}

			workbook.write();
		} catch (Exception e) {
			// e.printStackTrace();
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}	
	
	/**
	 * 导入进深修正
	 */
	public static ArrayList<Pgv02055> importDataJSXZ(String sourceFile,	String userId, String ssgx) throws Exception {
		ArrayList<Pgv02055> resultList = new ArrayList<Pgv02055>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv02055 bean = new Pgv02055();
					try {
						// A.所在区域
						String szqy = CheckUtil.chkTrim(sht.getCell(0, i).getContents());
						/*
						 * if(!CheckUtil.chkEmpty(szqy)){ bean.setSzqy(szqy);
						 * }else{ throw new Exception("所在区域为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setSzqy(ExcelUtil.excelIsEmpty(szqy, "所在区域", i));
						// B.房屋类别
						bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(1, i).getContents(), "房屋类型", i));
						// String fwlx =
						// CheckUtil.chkTrim(sht.getCell(1,i).getContents());
						// if(!CheckUtil.chkEmpty(fwlx)){
						// bean.setFwlx(fwlx);
						// }else{
						// throw new Exception("房屋类型为空，请检查第" + (i+1) + "条");
						// }
						// C.进深下限
						try {
							String value = CheckUtil.chkTrim(sht.getCell(2, i).getContents());
							bean.setJsMin(BigDecimal.valueOf(Double.parseDouble(value)));
						} catch (Exception e) {
							Exception e1 = new Exception("进深下限格式不正确,请核实第" + (i + 1) + "条数据");
							throw e1;
						}
						// D.进深上限
						try {
							String value = CheckUtil.chkTrim(sht.getCell(3, i).getContents());
							bean.setJsMax(BigDecimal.valueOf(Double.parseDouble(value)));
						} catch (Exception e) {
							Exception e1 = new Exception("进深上限格式不正确,请核实第" + (i + 1) + "条数据");
							throw e1;
						}
						// E.修正系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(4, i).getContents());
							bean.setXzxs(BigDecimal.valueOf(Double.parseDouble(value)));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第" + (i + 1) + "条数据");
							throw e1;
						}
						bean.setSsgx(ssgx);
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}	

	/**
	 * 导出错误格式进深修正
	 */
	public static OutputStream exportDataJSXZ(ArrayList<Pgv02055> v02055List) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的进深修正数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "进深下限", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "进深上限", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v02055List.size(); i++) {
				label = myLable(0, i + 1, v02055List.get(i).getSzqy(),
						v02055List.get(i).getCd00001Szqy(), wcf1);
				sheet.addCell(label);
				label = myLable(1, i + 1, v02055List.get(i).getFwlx(),
						v02055List.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = new Label(2, i + 1, v02055List.get(i).getJsMin()
						.toString());
				sheet.addCell(label);
				label = new Label(3, i + 1, v02055List.get(i).getJsMax()
						.toString());
				sheet.addCell(label);
				label = new Label(4, i + 1, v02055List.get(i).getXzxs()
						.toString());
				sheet.addCell(label);
				label = new Label(5, i + 1, v02055List.get(i).getImpErrorMsg());
				sheet.addCell(label);
			}
			workbook.write();
		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}	
	
	/**
	 * 新导入进深修正
	 * 
	 * @throws Exception
	 */
	public static ArrayList<Pgv02055> importDataJSXZA(String sourceFile, String userId, String ssgx) throws Exception {
		ArrayList<Pgv02055> resultList = new ArrayList<Pgv02055>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv02055 bean = new Pgv02055();
					try {
						// A.所在区域
						String szqy = sht.getCell(0, i).getContents();
						/*
						 * if(!CheckUtil.chkEmpty(szqy)){ bean.setSzqy(szqy);
						 * }else{ throw new Exception("所在区域为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setSzqy(ExcelUtil.excelIsEmpty(szqy, "所在区域", i));
						// B.代码号
						bean.setDmh(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// C.小区名称
						bean.setXqnm(CheckUtil.chkTrim(sht.getCell(2, i)
								.getContents()));
						// D.房屋类别
						bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(3, i)
								.getContents(), "房屋类型", i));
						// String fwlx = sht.getCell(3,i).getContents();
						// if(!CheckUtil.chkEmpty(fwlx)){
						// bean.setFwlx(fwlx);
						// }else{
						// throw new Exception("房屋类型为空，请检查第" + (i+1) + "条");
						// }

						// F.进深下限
						try {
							String value = CheckUtil.chkTrim(sht.getCell(4, i)
									.getContents());
							bean.setJsMin(BigDecimal.valueOf(Double
									.parseDouble(value)));
						} catch (Exception e) {
							Exception e1 = new Exception("进深下限格式不正确,请核实第"
									+ (i + 1) + "条数据");
							throw e1;
						}
						// G.进深上限
						try {
							String value = CheckUtil.chkTrim(sht.getCell(5, i)
									.getContents());
							bean.setJsMax(BigDecimal.valueOf(Double
									.parseDouble(value)));
						} catch (Exception e) {
							Exception e1 = new Exception("进深上限格式不正确,请核实第"
									+ (i + 1) + "条数据");
							throw e1;
						}
						// H.修正系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(6, i)
									.getContents());
							bean.setXzxs(BigDecimal.valueOf(Double
									.parseDouble(value)));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第"
									+ (i + 1) + "条数据");
							throw e1;
						}

						bean.setSsgx(ssgx);
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}
	
	/**
	 * 新导出错误格式进深范围修正
	 */
	public static OutputStream exportDataJSXZA(ArrayList<Pgv02055> v02055List)
			throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的进深修正数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "代码号", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "小区名称", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "进深下限", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "进深上限", wcf);
			sheet.addCell(label);
			label = new Label(6, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			label = new Label(7, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v02055List.size(); i++) {
				label = myDZLable(0, i + 1, v02055List.get(i).getSzqy(),
						v02055List.get(i).getCd00001Szqy(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myDZLable(1, i + 1, v02055List.get(i).getDmh(),
						v02055List.get(i).getDmhId(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myDZLable(2, i + 1, v02055List.get(i).getXqnm(),
						v02055List.get(i).getCd02050Xqdm(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myLable(3, i + 1, v02055List.get(i).getFwlx(),
						v02055List.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = new Label(4, i + 1, v02055List.get(i).getJsMin()
						.toString());
				sheet.addCell(label);
				label = new Label(5, i + 1, v02055List.get(i).getJsMax()
						.toString());
				sheet.addCell(label);
				label = new Label(6, i + 1, v02055List.get(i).getXzxs()
						.toString());
				sheet.addCell(label);
				label = new Label(7, i + 1, v02055List.get(i).getImpErrorMsg());
				sheet.addCell(label);
			}
			workbook.write();
		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}	
	
	/**
	 * 导入面宽修正
	 */
	public static ArrayList<Pgv02054> importDataMKXZ(String sourceFile,	String userId, String ssgx) throws Exception {
		ArrayList<Pgv02054> resultList = new ArrayList<Pgv02054>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv02054 bean = new Pgv02054();
					try {
						// A.所在区域
						String szqy = CheckUtil.chkTrim(sht.getCell(0, i)
								.getContents());
						/*
						 * if(!CheckUtil.chkEmpty(szqy)){ bean.setSzqy(szqy);
						 * }else{ throw new Exception("所在区域为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setSzqy(ExcelUtil.excelIsEmpty(szqy, "所在区域", i));
						// B.房屋类别
						bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(1, i).getContents(), "房屋类型", i));
						// String fwlx =
						// CheckUtil.chkTrim(sht.getCell(1,i).getContents());
						// if(!CheckUtil.chkEmpty(fwlx)){
						// bean.setFwlx(fwlx);
						// }else{
						// throw new Exception("房屋类型为空，请检查第" + (i+1) + "条");
						// }
						// C.面宽下限
						try {
							String value = CheckUtil.chkTrim(sht.getCell(2, i)
									.getContents());
							bean.setMkMin(BigDecimal.valueOf(Double
									.parseDouble(value)));
						} catch (Exception e) {
							Exception e1 = new Exception("面宽下限格式不正确,请核实第"+ (i + 1) + "条数据");
							throw e1;
						}
						// D.面宽上限
						try {
							String value = CheckUtil.chkTrim(sht.getCell(3, i)
									.getContents());
							bean.setMkMax(BigDecimal.valueOf(Double
									.parseDouble(value)));
						} catch (Exception e) {
							Exception e1 = new Exception("面宽上限格式不正确,请核实第"+ (i + 1) + "条数据");
							throw e1;
						}
						// E.修正系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(4, i)
									.getContents());
							bean.setXzxs(BigDecimal.valueOf(Double
									.parseDouble(value)));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第"+ (i + 1) + "条数据");
							throw e1;
						}
						bean.setSsgx(ssgx);
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}	
	
	/**
	 * 导出错误格式面宽修正
	 */
	public static OutputStream exportDataMKXZ(ArrayList<Pgv02054> v02054List)
			throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的面宽修正数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "面宽下限", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "面宽上限", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v02054List.size(); i++) {
				label = myLable(0, i + 1, v02054List.get(i).getSzqy(),
						v02054List.get(i).getCd00001Szqy(), wcf1);
				sheet.addCell(label);
				label = myLable(1, i + 1, v02054List.get(i).getFwlx(),
						v02054List.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = new Label(2, i + 1, v02054List.get(i).getMkMin()
						.toString());
				sheet.addCell(label);
				label = new Label(3, i + 1, v02054List.get(i).getMkMax()
						.toString());
				sheet.addCell(label);
				label = new Label(4, i + 1, v02054List.get(i).getXzxs()
						.toString());
				sheet.addCell(label);
				label = new Label(5, i + 1, v02054List.get(i).getImpErrorMsg());
				sheet.addCell(label);
			}
			workbook.write();
		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}	
	
	/**
	 * 新导入面宽修正
	 * 
	 * @throws Exception
	 */
	public static ArrayList<Pgv02054> importDataMKXZA(String sourceFile,
			String userId, String ssgx) throws Exception {
		ArrayList<Pgv02054> resultList = new ArrayList<Pgv02054>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv02054 bean = new Pgv02054();
					try {
						// A.所在区域
						String szqy = sht.getCell(0, i).getContents();
						/*
						 * if(!CheckUtil.chkEmpty(szqy)){ bean.setSzqy(szqy);
						 * }else{ throw new Exception("所在区域为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setSzqy(ExcelUtil.excelIsEmpty(szqy, "所在区域", i));
						// B.代码号
						bean.setDmh(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// C.小区名称
						bean.setXqnm(CheckUtil.chkTrim(sht.getCell(2, i)
								.getContents()));
						// D.房屋类别
						bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(3, i).getContents(), "房屋类型", i));
						// String fwlx = sht.getCell(3,i).getContents();
						// if(!CheckUtil.chkEmpty(fwlx)){
						// bean.setFwlx(fwlx);
						// }else{
						// throw new Exception("房屋类型为空，请检查第" + (i+1) + "条");
						// }

						// F.面宽下限
						try {
							String value = CheckUtil.chkTrim(sht.getCell(4, i)
									.getContents());
							bean.setMkMin(BigDecimal.valueOf(Double
									.parseDouble(value)));
						} catch (Exception e) {
							Exception e1 = new Exception("面宽下限格式不正确,请核实第"+ (i + 1) + "条数据");
							throw e1;
						}
						// G.面宽上限
						try {
							String value = CheckUtil.chkTrim(sht.getCell(5, i)
									.getContents());
							bean.setMkMax(BigDecimal.valueOf(Double
									.parseDouble(value)));
						} catch (Exception e) {
							Exception e1 = new Exception("面宽上限格式不正确,请核实第"+ (i + 1) + "条数据");
							throw e1;
						}
						// H.修正系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(6, i)
									.getContents());
							bean.setXzxs(BigDecimal.valueOf(Double
									.parseDouble(value)));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第"+ (i + 1) + "条数据");
							throw e1;
						}

						bean.setSsgx(ssgx);
						bean.setCd00002Czr(userId);
						resultList.add(bean);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}	
	
	/**
	 * 新导出错误格式面宽修正
	 */
	public static OutputStream exportDataMKXZA(ArrayList<Pgv02054> v02054List)
			throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的面宽修正数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "代码号", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "小区名称", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "面宽下限", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "面宽上限", wcf);
			sheet.addCell(label);
			label = new Label(6, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			label = new Label(7, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v02054List.size(); i++) {
				label = myDZLable(0, i + 1, v02054List.get(i).getSzqy(),
						v02054List.get(i).getCd00001Szqy(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myDZLable(1, i + 1, v02054List.get(i).getDmh(),
						v02054List.get(i).getDmhId(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myDZLable(2, i + 1, v02054List.get(i).getXqnm(),
						v02054List.get(i).getCd02050Xqdm(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myLable(3, i + 1, v02054List.get(i).getFwlx(),
						v02054List.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = new Label(4, i + 1, v02054List.get(i).getMkMin()
						.toString());
				sheet.addCell(label);
				label = new Label(5, i + 1, v02054List.get(i).getMkMax()
						.toString());
				sheet.addCell(label);
				label = new Label(6, i + 1, v02054List.get(i).getXzxs()
						.toString());
				sheet.addCell(label);
				label = new Label(7, i + 1, v02054List.get(i).getImpErrorMsg());
				sheet.addCell(label);
			}
			workbook.write();
		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}	

	/**
	 * 导入商业综合修正赋值
	 */
	public static ArrayList<Pgv02053> importDataSYZHXZ(String sourceFile,
			String userId, String ssgx) throws Exception {
		ArrayList<Pgv02053> resultList = new ArrayList<Pgv02053>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv02053 bean = new Pgv02053();
					try {
						// A.所在区域
						String szqy = CheckUtil.chkTrim(sht.getCell(0, i)
								.getContents());
						/*
						 * if(!CheckUtil.chkEmpty(szqy)){ bean.setSzqy(szqy);
						 * }else{ throw new Exception("所在区域为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setSzqy(ExcelUtil.excelIsEmpty(szqy, "类型名称", i));
						// B.房屋类别
						bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(1, i)
								.getContents(), "房屋类型", i));						

						// C.类型名称
						String rootNm = CheckUtil.chkTrim(sht.getCell(2, i)
								.getContents());						
						/*
						 * if(!CheckUtil.chkEmpty(lxmc)){ bean.setLxmc(lxmc);
						 * }else{ throw new Exception("类型名称为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setRootNm(ExcelUtil.excelIsEmpty(rootNm, "类型名称", i));
						// C.类型名称
						String infoNm = CheckUtil.chkTrim(sht.getCell(3, i)
								.getContents());
						
						bean.setInfoNm(ExcelUtil.excelIsEmpty(infoNm, "选项名称", i));
						
						// D.修正系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(4, i)
									.getContents());
							bean.setXzxs(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第"
									+ (i + 1) + "条");
							throw e1;
						}
						bean.setSfmr("是".equals(CheckUtil.chkTrim(sht.getCell(5, i)
								.getContents())) ? 1 : 0);

						bean.setCd00002czr(userId);
						bean.setSsgx(ssgx);

						resultList.add(bean);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}
	
	/**
	 * 导出错误格式商业综合修正赋值
	 */
	public static OutputStream exportDataSYZhxz(ArrayList<Pgv02053> v02053List) {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream();
		Label label;
		WritableWorkbook workbook;

		try {
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的综合修正数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "类型名称", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "选择名称", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "是否默认", wcf);
			sheet.addCell(label);
			label = new Label(6, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v02053List.size(); i++) {
				label = myDZLable(0, i + 1, v02053List.get(i).getSzqy(),
						v02053List.get(i).getCd00001Szqy(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myLable(1, i + 1, v02053List.get(i).getFwlx(),
						v02053List.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = myLable(2, i + 1, v02053List.get(i).getRootNm(),
						v02053List.get(i).getCd00001Infoid(), wcf1);
				sheet.addCell(label);
				label = myLable(3, i + 1, v02053List.get(i).getInfoNm(),
						v02053List.get(i).getCd00001Infoid(), wcf1);
				sheet.addCell(label);
				label = new Label(4, i + 1, v02053List.get(i).getXzxs()
						.toString());
				sheet.addCell(label);
				label = new Label(5, i + 1, v02053List.get(i).getSfmr()==0?"否":"是");
				sheet.addCell(label);
				label = new Label(6, i + 1, v02053List.get(i).getImpErrorMsg());
				sheet.addCell(label);
			}
			workbook.write();
			workbook.close();

		} catch (Exception e) {

		}
		return strBufResult;
	}
	
	/**
	 * 新导入商业综合修正赋值
	 */
	public static ArrayList<Pgv02053> importDataSYZHXZA(String sourceFile,
			String userId, String ssgx) throws Exception {
		ArrayList<Pgv02053> resultList = new ArrayList<Pgv02053>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv02053 bean = new Pgv02053();
					try {
						// A.所在区域
						String szqy = CheckUtil.chkTrim(sht.getCell(0, i)
								.getContents());
						/*
						 * if(!CheckUtil.chkEmpty(szqy)){ bean.setSzqy(szqy);
						 * }else{ throw new Exception("所在区域为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setSzqy(ExcelUtil.excelIsEmpty(szqy, "类型名称", i));
						// B.代码号
						bean.setDmh(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// C.小区名称
						bean.setXqnm(CheckUtil.chkTrim(sht.getCell(2, i)
								.getContents()));
						// D.房屋类别
						bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(3, i)
								.getContents(), "房屋类型", i));
						

						// C.类型名称
						String rootNm = CheckUtil.chkTrim(sht.getCell(4, i)
								.getContents());						
						/*
						 * if(!CheckUtil.chkEmpty(lxmc)){ bean.setLxmc(lxmc);
						 * }else{ throw new Exception("类型名称为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setRootNm(ExcelUtil.excelIsEmpty(rootNm, "类型名称", i));
						// C.类型名称
						String infoNm = CheckUtil.chkTrim(sht.getCell(5, i)
								.getContents());
						
						bean.setInfoNm(ExcelUtil.excelIsEmpty(infoNm, "选项名称", i));
						
						// F.修正系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(6, i)
									.getContents());
							bean.setXzxs(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e2 = new Exception("修正系数格式不正确，请核实第"
									+ (i + 1) + "条");
							throw e2;
						}

						// bean.setSfmr("是".equals(CheckUtil.chkTrim(sht.getCell(6,
						// i).getContents()))?1:0);

						bean.setCd00002czr(userId);
						bean.setSsgx(ssgx);

						resultList.add(bean);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}	
	
	/**
	 * 新导出错误格式商业综合修正赋值
	 */
	public static OutputStream exportDataSYZhxzA(ArrayList<Pgv02053> v02053List)
			throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的建筑成新修正数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "代码号", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "小区名称", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "类型名称", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "选择名称", wcf);
			sheet.addCell(label);
			label = new Label(6, 0, "修正值(%)", wcf);
			sheet.addCell(label);
			label = new Label(7, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v02053List.size(); i++) {
				label = myDZLable(0, i + 1, v02053List.get(i).getSzqy(),
						v02053List.get(i).getCd00001Szqy(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myDZLable(1, i + 1, v02053List.get(i).getDmh(),
						v02053List.get(i).getDmhid(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myDZLable(2, i + 1, v02053List.get(i).getXqnm(),
						v02053List.get(i).getCd02050Xqdm(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myLable(3, i + 1, v02053List.get(i).getFwlx(),
						v02053List.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = myLable(4, i + 1, v02053List.get(i).getRootNm(),
						v02053List.get(i).getCd00001Infoid(), wcf1);
				sheet.addCell(label);
				label = myLable(5, i + 1, v02053List.get(i).getInfoNm(),
						v02053List.get(i).getCd00001Infoid(), wcf1);
				sheet.addCell(label);
				label = new Label(6, i + 1, v02053List.get(i).getXzxs()
						.toString());
				sheet.addCell(label);
				label = new Label(7, i + 1, v02053List.get(i).getImpErrorMsg());
				sheet.addCell(label);
			}
			workbook.write();

		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}	
	
	/**
     * 将String转化为Date
     *
     * @param value 原值
     * @return 转化后值
     */
    public static Date toUtilDate(String value) {
    	
		Date result = null;
		if(null!=value){
			String parse = value;
			parse = parse.replaceFirst("^[0-9]{4}([^0-9]?)", "yyyy$1");
			parse = parse.replaceFirst("^[0-9]{2}([^0-9]?)", "yy$1");
			parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1MM$2");
			parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}( ?)", "$1dd$2");
			parse = parse.replaceFirst("( )[0-9]{1,2}([^0-9]?)", "$1HH$2");
			parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1mm$2");
			parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1ss$2");
			SimpleDateFormat format = new SimpleDateFormat(parse);
			try {
				result = format.parse(value);
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 导入交易时间修正
	 */
	public static ArrayList<Pgv02058> importDataJYSJSY(String sourceFile,
			String userId, String ssgx, int sfsc) throws Exception {
		ArrayList<Pgv02058> resultList = new ArrayList<Pgv02058>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv02058 bean = new Pgv02058();
					try {
						// A.所在区域
						/*
						 * String szqy =
						 * CheckUtil.chkTrim(sht.getCell(0,i).getContents());
						 * if(!CheckUtil.chkEmpty(szqy)){ bean.setSzqy(szqy);
						 * }else{ throw new Exception("所在区域为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setSzqy(ExcelUtil.excelIsEmpty(sht.getCell(0, i).getContents(), "所在区域", i));
						bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(1, i).getContents(), "房屋类型", i));
						// B.估价时点
						bean.setPssd(ConvertUtil.toUtilDate(CheckUtil.chkTrim(sht.getCell(2, i).getContents()) + "01"));
						// C.修正系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(3, i).getContents());
							bean.setXzxs(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第"+ (i + 1) + "条数据");
							throw e1;
						}
						bean.setCd00001Ssgx(ssgx);
						bean.setCd00002Czr(userId);
						bean.setSfsc(sfsc);
						resultList.add(bean);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}	
	
	/**
	 * 导出错误格式交易日期修正
	 */
	public static OutputStream exportDataJYRQXZSY(ArrayList<Pgv02058> v02058List)
			throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("格式错误的交易日期数据", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "时间", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "价格指数(%)", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v02058List.size(); i++) {
				label = myDZLable(0, i + 1, v02058List.get(i).getSzqy(),
						v02058List.get(i).getCd00001Szqy(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myDZLable(1, i + 1, v02058List.get(i).getFwlx(),
						v02058List.get(i).getCd00001Fwlx(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = new Label(2, i + 1, FormatUtil.toYYYYMM(v02058List
						.get(i).getPssd()));
				sheet.addCell(label);
				label = new Label(3, i + 1, v02058List.get(i).getXzxs()
						.toString());
				sheet.addCell(label);
				label = new Label(4, i + 1, v02058List.get(i).getImpErrorMsg());
				sheet.addCell(label);
			}
			workbook.write();
		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}	
	/**
	 * 导入交易时间修正
	 */
	public static ArrayList<Pgv02058> importDataJYSJASY(String sourceFile,
			String userId, String ssgx, int sfsc) throws Exception {
		ArrayList<Pgv02058> resultList = new ArrayList<Pgv02058>();
		Sheet sht = null;
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(sourceFile);
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int rowSheet = getValidRowNumbers(sht.getRows(), sht);
				for (int i = 1; i < rowSheet; i++) {
					Pgv02058 bean = new Pgv02058();
					try {
						// A.所在区域
						/*
						 * String szqy =
						 * CheckUtil.chkTrim(sht.getCell(0,i).getContents());
						 * if(!CheckUtil.chkEmpty(szqy)){ bean.setSzqy(szqy);
						 * }else{ throw new Exception("所在区域为空，请检查第" + (i+1) +
						 * "条"); }
						 */
						bean.setSzqy(ExcelUtil.excelIsEmpty(sht.getCell(0, i)
								.getContents(), "所在区域", i));

						// C.代码号
						bean.setDmh(CheckUtil.chkTrim(sht.getCell(1, i).getContents()));
						// D.小区名称
						bean.setXqnm(CheckUtil.chkTrim(sht.getCell(2, i)
								.getContents()));
						// B.房屋类别
						bean.setFwlx(ExcelUtil.excelIsEmpty(sht.getCell(3, i)
								.getContents(), "房屋类型", i));
						// String fwlx =
						// CheckUtil.chkTrim(sht.getCell(3,i).getContents());
						// if(!CheckUtil.chkEmpty(fwlx)){
						// bean.setFwlx(fwlx);
						// }else{
						// throw new Exception("房屋类型为空，请检查第" + (i+1) + "条");
						// }
						// E.估价时点
						bean.setPssd(ConvertUtil.toUtilDate(CheckUtil.chkTrim(sht
								.getCell(4, i).getContents())));
						// F.修正系数
						try {
							String value = CheckUtil.chkTrim(sht.getCell(5, i)
									.getContents());
							bean.setXzxs(Double.parseDouble(value));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确,请核实第"
									+ (i + 1) + "条数据");
							throw e1;
						}
						bean.setCd00001Ssgx(ssgx);
						bean.setCd00002Czr(userId);
						bean.setSfsc(sfsc);
						resultList.add(bean);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					} finally {
						bean = null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
		}
		return resultList;
	}	

	/**
	 * 导出错误格式交易日期修正
	 */
	public static OutputStream exportDataJYRQXZASY(
			ArrayList<Pgv02058> v02058List) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Label label;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("错误格式的交易日期修正", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBackground(Colour.GREEN);

			label = new Label(0, 0, "所在区域", wcf);
			sheet.addCell(label);
			label = new Label(1, 0, "代码号", wcf);
			sheet.addCell(label);
			label = new Label(2, 0, "小区名称", wcf);
			sheet.addCell(label);
			label = new Label(3, 0, "房屋类型", wcf);
			sheet.addCell(label);
			label = new Label(4, 0, "时间", wcf);
			sheet.addCell(label);
			label = new Label(5, 0, "价格指数(%)", wcf);
			sheet.addCell(label);
			label = new Label(6, 0, "错误信息", wcf);
			sheet.addCell(label);

			WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			WritableCellFormat wcf1 = new WritableCellFormat(wf1);

			for (int i = 0; i < v02058List.size(); i++) {
				label = myDZLable(0, i + 1, v02058List.get(i).getSzqy(),
						v02058List.get(i).getCd00001Szqy(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myDZLable(1, i + 1, v02058List.get(i).getDmh(),
						v02058List.get(i).getDmhId(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myDZLable(2, i + 1, v02058List.get(i).getXqnm(),
						v02058List.get(i).getCd02050Xqdm(), wcf1, "(不存在)");
				sheet.addCell(label);
				label = myLable(3, i + 1, v02058List.get(i).getFwlx(),
						v02058List.get(i).getCd00001Fwlx(), wcf1);
				sheet.addCell(label);
				label = new Label(4, i + 1, FormatUtil.toYYYYMM(v02058List
						.get(i).getPssd()));
				sheet.addCell(label);
				label = new Label(5, i + 1, v02058List.get(i).getXzxs()
						.toString());
				sheet.addCell(label);
				label = new Label(6, i + 1, v02058List.get(i).getImpErrorMsg());
				sheet.addCell(label);
			}
			workbook.write();
		} catch (Exception e) {
			if (null != strBufResult) {
				try {
					strBufResult.close();
				} catch (Exception e1) {
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}
		return strBufResult;
	}
	
}
