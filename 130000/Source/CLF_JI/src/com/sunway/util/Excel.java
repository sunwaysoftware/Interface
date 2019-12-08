/**
 * 
 */
package com.sunway.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

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
import com.sunway.util.SessionCtrl;

/**
 * 
 * Excel操作
 * 
 * @author Andy.Gao
 *
 */
public class Excel implements Serializable {
	private static Logger logger = LogManager.getLogger(Excel.class.getName());
	private static final long serialVersionUID = 1466017959093917212L;
	private static SessionCtrl sessionCtrl;

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
					if (!Common.isNullOrEmpty(sht.getCell(3, i).getContents()))
						bean.setCd00001Jylx(sht.getCell(3, i).getContents().substring(0, 5));
					// 建筑结构
					if (!Common.isNullOrEmpty(sht.getCell(4, i).getContents()))
						bean.setCd00001Jzjg(sht.getCell(4, i).getContents().substring(0, 5));
					// 有无电梯
					if (!Common.isNullOrEmpty(sht.getCell(5, i).getContents()))
						bean.setYwdt(Common.convertToBoolean(sht.getCell(5, i).getContents().substring(0, 1)));
					else
						bean.setYwdt(false);
					// 总楼层
					if (!Common.isNullOrEmpty(sht.getCell(6, i).getContents()))
						bean.setZlc(Common.convertToShort(sht.getCell(6, i).getContents()));
					else
						bean.setZlc(Short.valueOf("0"));
					// 建筑面积
					if (!Common.isNullOrEmpty(sht.getCell(7, i).getContents()))
						bean.setJzmj(Common.convertToDouble(sht.getCell(7, i).getContents()));
					else
						bean.setJzmj(0.0);
					// 房屋朝向
					if (!Common.isNullOrEmpty(sht.getCell(8, i).getContents()))
						bean.setCd00001Fwcx(sht.getCell(8, i).getContents().substring(0, 5));
					// 采光状况
					if (!Common.isNullOrEmpty(sht.getCell(9, i).getContents()))
						bean.setCd00001Cgzk(sht.getCell(9, i).getContents().substring(0, 5));
					// 所在楼层
					if (!Common.isNullOrEmpty(sht.getCell(10, i).getContents()))
						bean.setSzlc(Common.convertToShort(sht.getCell(10, i).getContents()));
					else
						bean.setSzlc(Short.valueOf("0"));
					// 座落地址
					bean.setFwtdzl(sht.getCell(11, i).getContents());
					// 评税价格
					// if(!Common.isNullOrEmpty(sht.getCell(12,i).getContents()))
					// bean.setPgjg(Common.convertToDouble(sht.getCell(12,i).getContents()));
					// else
					// bean.setPgjg(0.0);
					// 交易时间
					if (!Common.isNullOrEmpty(sht.getCell(13, i).getContents()))
						bean.setGpsj(
								new java.sql.Date(Common.convertToDate(sht.getCell(13, i).getContents()).getTime()));
					// 小区编码
					if (!Common.isNullOrEmpty(sht.getCell(14, i).getContents()))
						bean.setCd00352Xqdm(sht.getCell(14, i).getContents());
					else
						bean.setCd00352Xqdm("xqid");
					// 小区名称
					bean.setXqmc(sht.getCell(15, i).getContents());
					// 户型
					bean.setHx(sht.getCell(16, i).getContents());
					// 自报价
					if (!Common.isNullOrEmpty(sht.getCell(17, i).getContents()))
						bean.setZbjg(Common.convertToDouble(sht.getCell(17, i).getContents()));
					else
						bean.setZbjg(0.0);
					// 是否中介
					if (!Common.isNullOrEmpty(sht.getCell(18, i).getContents())) {
						tmpStr = sht.getCell(18, i).getContents().substring(0, 1);
						if ("0".equals(tmpStr))
							bean.setSfzj(false);
						else
							bean.setSfzj(true);
					}
					// 挂牌时间
					if (!Common.isNullOrEmpty(sht.getCell(19, i).getContents()))
						bean.setGpsj(
								new java.sql.Date(Common.convertToDate(sht.getCell(19, i).getContents()).getTime()));
					// 房屋类型
					if (!Common.isNullOrEmpty(sht.getCell(20, i).getContents()))
						bean.setCd00001Fwlx(sht.getCell(20, i).getContents().substring(0, 5));
					if (colSheet > 21) {
						for (int j = 21; j < colSheet; j++) {
							// 其他修正
							if (!Common.isNullOrEmpty(sht.getCell(j, i).getContents())) {
								qtxz = sht.getCell(j, i).getContents().substring(0, 5) + Constant.STRING_COMMA;
								qtxzs += qtxz;
							}

						}
						bean.setQtids(qtxzs);
					}
					bean.setCd00002Czr(userId);
					resultList.add(bean);
				} catch (Exception e) {
					logger.error(e);
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
						bean.setSzqy(Common.trim(sht.getCell(0, i).getContents()));
						// B.小区名称
						bean.setXqnm(Common.trim(sht.getCell(1, i).getContents()));
						// C.房产证号
						bean.setFczh(Common.trim(sht.getCell(2, i).getContents()));
						// D.纳税人名称
						bean.setNsrmc(Common.trim(sht.getCell(3, i).getContents()));
						// E.证件类型
						bean.setZjlx(Common.trim(sht.getCell(4, i).getContents()));
						// F.证件号码
						bean.setZjhm(Common.trim(sht.getCell(5, i).getContents()));
						// G.联系电话
						bean.setLxdh(Common.trim(sht.getCell(6, i).getContents()));
						// H.测量号
						bean.setClh(Common.trim(sht.getCell(7, i).getContents()));
						// I.房屋坐落
						bean.setZcdzl(Common.trim(sht.getCell(8, i).getContents()));
						// J.幢号
						bean.setZh(Common.trim(sht.getCell(9, i).getContents()));
						// K.单元号
						bean.setDyh(Common.trim(sht.getCell(10, i).getContents()));
						// L.房号
						bean.setFh(Common.trim(sht.getCell(11, i).getContents()));
						// M.建筑面积
						bean.setJzmj(Common.convertToDouble(Common.trim(sht.getCell(12, i).getContents())));
						// N.总楼层
						bean.setZlc(Common.convertToInteger(Common.trim(sht.getCell(13, i).getContents())));
						// O.所在楼层
						bean.setSzlc(Common.convertToInteger(Common.trim(sht.getCell(14, i).getContents())));
						// P.房屋类型
						bean.setFwlx(Common.trim(sht.getCell(15, i).getContents()));
						// Q.建成年份
						bean.setJcnf(Common.trim(sht.getCell(16, i).getContents()));
						// R.建筑结构
						bean.setJzjg(Common.trim(sht.getCell(17, i).getContents()));
						// S.规划用途
						bean.setGhyt(Common.trim(sht.getCell(18, i).getContents()));
						// T.交易类型
						bean.setJylx(Common.trim(sht.getCell(19, i).getContents()));
						// U.核定价格
						bean.setHdjg(Common.convertToDouble(Common.trim(sht.getCell(20, i).getContents())));
						// V.综合修正
						bean.setZhxz(Common.trim(sht.getCell(21, i).getContents()));
						// W.备注
						bean.setNote(Common.trim(sht.getCell(22, i).getContents()));

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
					logger.error(e);
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
					logger.error(e);
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
			label = new Label(2, 0, "房产证号", wcf);
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
					logger.error(e1);
				}
			}
			throw e;
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
					logger.error(e);
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
						bean.setSzlc(Common.convertToShort(sht.getCell(8, i).getContents()));
						// J.总楼层
						bean.setZlc(sht.getCell(9, i).getContents());
						// K.房产证号
						bean.setFczh(sht.getCell(10, i).getContents());
						// L.交易类型
						bean.setJylx(sht.getCell(11, i).getContents());
						// M.房屋类别
						bean.setFwlx(sht.getCell(12, i).getContents());
						// N.建筑结构
						bean.setJzjg(sht.getCell(13, i).getContents());
						// O.建筑面积(平方米)
						bean.setJzmj(Common.convertToDouble(sht.getCell(14, i).getContents()));
						// P.交易时间
						String t = sht.getCell(15, i).getContents();
						if (!Common.isNullOrEmpty(t))
							bean.setJysj(new java.sql.Date(Common.convertToDate(t).getTime()));
						else
							bean.setJysj(new java.sql.Date(new Date().getTime()));// 如果为空，取系统当前时间
						// Q.成交价格(元)
						bean.setPgjg(Common.convertToDouble(sht.getCell(16, i).getContents()));
						// R.综合修正
						bean.setZhxz(sht.getCell(17, i).getContents());
						// S.发证日期
						t = sht.getCell(18, i).getContents();
						if (!Common.isNullOrEmpty(t))
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
			label = new Label(j++, 0, "房产证号", wcf);
			sheet.addCell(label);
			// //G.有无电梯
			// label = new Label(j++, 0, "有无电梯" ,wcf);
			// sheet.addCell(label);
			// H.房产证号
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
				// H.房产证号
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
			logger.error(e.getMessage());
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
	// if (!Common.isNullOrEmpty(ywdt) && ywdt.equals("有")) {
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
			 logger.error(e.getMessage());
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
			label = (Common.checkNull(flag).equals("N")) ? new Label(c, r, Common.checkNull(cont) + "(类型错误)", cf)
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
			label = (Common.checkNull(flag).equals("N")) ? new Label(c, r, cont + errorMsg, cf) : new Label(c, r, cont);
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
				// 导入上限设置为1000条
				if (rowSheet>1001){
					rowSheet = 1001;
				}
				for (int i = 1; i < rowSheet; i++) {
					ExcelBean bean = new ExcelBean();
					try {
						// A. 所在区域
						bean.setSzqyNm(Common.trim(sht.getCell(0, i).getContents()));
						// B. 大区名称
						bean.setParentXQNm(Common.trim(sht.getCell(1, i).getContents()));
						// C. 小区代码号
						bean.setXqdmh(Common.trim(sht.getCell(2, i).getContents()));
						// D. 小区名称
						bean.setXqNm(Common.trim(sht.getCell(3, i).getContents()));
						// E. 房屋类别
						bean.setFwlxNm(Common.trim(sht.getCell(4, i).getContents()));
						// F. 建筑结构
						bean.setJzjgNm(Common.trim(sht.getCell(5, i).getContents()));
						// G. 建成年份
						bean.setJcnf(Common.trim(sht.getCell(6, i).getContents()));
						// H. 交易时间
						bean.setJysj(Common.convertToSqlDate(Common.trim(sht.getCell(7, i).getContents())));
						// I. 基准价值(元/平方米)
						try {
							bean.setPfmjg(Double.parseDouble(Common.trim(sht.getCell(8, i).getContents())));
						} catch (Exception e) {
							logger.error(e);
							throw new Exception("基准价值格式不正确，请核实第" + i + "条数据");
						}

						// E. 备注
						bean.setNote(Common.trim(sht.getCell(9, i).getContents()));
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
					logger.error(e);
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
					logger.error(e);
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
						bean.setSzqyNm(Common.trim(sht.getCell(0, i).getContents()));
						// B. 片区代码号
						bean.setPqdmh(Common.trim(sht.getCell(1, i).getContents()));
						// C. 大区名称
						bean.setParentXQNm(Common.trim(sht.getCell(2, i).getContents()));
						// D.小区代码号
						bean.setXqdmh(Common.trim(sht.getCell(3, i).getContents()));
						// E. 小区名称
						bean.setXqNm(Common.trim(sht.getCell(4, i).getContents()));
						// F.坐落地址
						String zcdzl = Common.trim(sht.getCell(5, i).getContents());
						if (null != zcdzl && !"".equals(zcdzl)) {
							bean.setZcdzl(zcdzl);
						} else {
							throw new Exception("请检查第" + i + "数据，坐落地址不可为空");
						}
						// G. 小区地址别名
						bean.setXqdzbm(Common.trim(sht.getCell(6, i).getContents()));
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
					logger.error(e);
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
					logger.error(e);
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
						bean.setSzqyNm(Common.trim(sht.getCell(0, i).getContents()));
						// C. 小区名称
						bean.setXqNm(Common.trim(sht.getCell(1, i).getContents()));
						// D.楼房地址
						bean.setZcdzl(Common.trim(sht.getCell(2, i).getContents()));
						// E. 地址别名
						bean.setXqdzbm(Common.trim(sht.getCell(3, i).getContents()));
						// B. 总楼层
						try {
							String value = Common.trim(sht.getCell(4, i).getContents());
							bean.setZlc(Short.parseShort(value));
						} catch (Exception e) {
							logger.error(e);
							Exception e1 = new Exception("总楼层格式不正确,请核实第" + i + "条数据");
							throw e1;
						}
						// bean.setZlc(Common.convertToShort(Common.trim(sht.getCell(4,i).getContents())));
						// //.有无架空层
						// bean.setYwjkc(Common.trim(sht.getCell(5,i).getContents()).equals("无")?0:1);
						// .测量号
						/*
						 * try{ String value =
						 * Common.trim(sht.getCell(5,1).getContents());
						 * bean.setClh(String.valueOf(Integer.parseInt(value)).
						 * toString()); }catch(Exception e){ Exception e1 = new
						 * Exception("测量号格式不正确，请核实第"+i+"条数据"); throw e1; }
						 */
						bean.setClh(Common.trim(sht.getCell(5, i).getContents()));
						// .备注
						bean.setNote(Common.trim(sht.getCell(6, i).getContents()));
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

			if (Common.isNullOrEmpty(firstColumn) && Common.isNullOrEmpty(secondColumn)
					&& Common.isNullOrEmpty(thirdColumn)) {
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
			label = (Common.checkNull(flag).equals("N")) ? new Label(c, r, cont + errorMsg, cf) : new Label(c, r, cont);
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
			label = (Common.checkNull(flag).equals("N")) ? new Label(c, r, cont + errorMsg, cf) : new Label(c, r, cont);
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
			label = (!Common.checkNull(flag).equals("N")) ? new Label(c, r, cont + errorMsg, cf)
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
						bean.setSzqy(Common.trim(sht.getCell(0, i).getContents()));
						// B.小区代码号
						bean.setXqdmh(Common.trim(sht.getCell(1, i).getContents()));
						// C.小区名称
						bean.setXqnm(Common.trim(sht.getCell(2, i).getContents()));
						// D.纳税人名称
						bean.setNsrmc(Common.trim(sht.getCell(3, i).getContents()));
						// E.税务编码/证件号码
						bean.setCd00301Swid(Common.trim(sht.getCell(4, i).getContents()));
						// F.房屋类型
						bean.setFwlx(Common.trim(sht.getCell(5, i).getContents()));
						// G.测量号
						bean.setClh(Common.trim(sht.getCell(6, i).getContents()));
						// H.楼房地址
						bean.setZcdzl(Common.trim(sht.getCell(7, i).getContents()));
						// I.楼名
						bean.setLm(Common.trim(sht.getCell(8, i).getContents()));
						// J.单元
						bean.setDy(Common.trim(sht.getCell(9, i).getContents()));
						// K.房号
						bean.setBwjfh(Common.trim(sht.getCell(10, i).getContents()));
						// L.所在楼层
						try {
							bean.setSzlc(Short.parseShort(Common.trim(sht.getCell(11, i).getContents())));
						} catch (Exception e) {
							throw new Exception("所在楼层格式不正确， 请核实第" + i + "条数据 ");
						}
						// M.总楼层
						try {
							String zlc = Common.trim(sht.getCell(12, i).getContents());
							Short.parseShort(zlc);
							bean.setZlc(zlc);
						} catch (Exception e) {
							throw new Exception("总楼层格式不正确，请核实第" + i + "条数据");
						}
						// N.建筑结构
						bean.setJzjg(Common.trim(sht.getCell(13, i).getContents()));
						// O.建成年份
						bean.setJcnf(Common.trim(sht.getCell(14, i).getContents()));
						// P.建筑面积
						try {
							bean.setJzmj(Double.parseDouble(Common.trim(sht.getCell(15, i).getContents())));
						} catch (Exception e) {
							throw new Exception("建筑面积格式不正确，请核实第" + i + "条数据");
						}
						// Q.交易时间
						try {
							String t = sht.getCell(16, i).getContents();
							if (!Common.isNullOrEmpty(t))
								bean.setJysj(new java.sql.Date(Common.convertToDate(t).getTime()));
							else
								bean.setJysj(new java.sql.Date(new Date().getTime()));// 如果为空，取系统当前时间
						} catch (Exception e) {
							throw new Exception("交易时间格式不正确， 请核实第" + i + "条数据");
						}
						// R.成交价格（元）
						try {
							bean.setPgjg(Double.parseDouble(Common.trim(sht.getCell(17, i).getContents())));
						} catch (Exception e) {
							throw new Exception("成交价格格式不正确， 请核实第" + i + "条数据");
						}
						// S.备注
						bean.setNote(Common.trim(sht.getCell(18, i).getContents()));
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
						bean.setSzqy(Common.trim(sht.getCell(0, i).getContents()));
						// F. 房屋类型
						bean.setFwlx(Common.trim(sht.getCell(1, i).getContents()));
						// B. 楼层
						try {
							String lc = Common.trim(sht.getCell(2, i).getContents());
							bean.setLc(Short.parseShort(lc));
						} catch (Exception e) {
							Exception e1 = new Exception("所在楼层格式不正确，请核实第" + i + "条数据");
							throw e1;
						}
						// C. 总楼层
						try {
							String zlc = Common.trim(sht.getCell(3, i).getContents());
							bean.setZcs(Short.parseShort(zlc));
						} catch (Exception e) {
							Exception e1 = new Exception("总楼层格式不正确,请核实第" + i + "条数据");
							throw e1;
						}
						// D.修正值
						try {
							String xzxs = Common.trim(sht.getCell(4, i).getContents());
							bean.setXzxs(Double.parseDouble(xzxs));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确，请核实" + i + "条数据");
							throw e1;
						}
						// E. 运算类型
						bean.setCzlx(Common.trim(sht.getCell(5, i).getContents()).equals("乘") ? 0 : 1);
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
						bean.setSzqy(Common.trim(sht.getCell(0, i).getContents()));
						// B. 小区代码号
						bean.setXqdmh(Common.trim(sht.getCell(1, i).getContents()));
						// C.小区名称
						bean.setXqdm(Common.trim(sht.getCell(2, i).getContents()));
						// I. 房屋类型
						bean.setFwlx(Common.trim(sht.getCell(3, i).getContents()));
						// H.测量号
						bean.setClh(Common.trim(sht.getCell(4, i).getContents()));

						// D.房屋座落
						bean.setZcdzl(Common.trim(sht.getCell(5, i).getContents()));
						// E.幢号
						bean.setZh(Common.trim(sht.getCell(6, i).getContents()));
						// F.单元号
						bean.setDyh(Common.trim(sht.getCell(7, i).getContents()));
						// G.房号
						bean.setFh(Common.trim(sht.getCell(8, i).getContents()));

						// J. 楼层
						try {
							String lc = Common.trim(sht.getCell(9, i).getContents());
							bean.setLc(Short.parseShort(lc));
						} catch (Exception e) {
							Exception e1 = new Exception("所在楼层格式不正确，请核实第" + i + "条数据");
							throw e1;
						}

						// K. 总楼层
						try {
							String zlc = Common.trim(sht.getCell(10, i).getContents());
							bean.setZcs(Short.parseShort(zlc));
						} catch (Exception e) {
							Exception e1 = new Exception("总楼层格式不正确,请核实第" + i + "条数据");
							throw e1;
						}
						// M.建筑结构
						bean.setJzjg(Common.trim(sht.getCell(11, i).getContents()));
						// L.建成年份
						String jcnf = Common.trim(sht.getCell(12, i).getContents());
						if (jcnf.length() == 4) {
							bean.setJcnf(jcnf);
						} else {
							Exception e = new Exception("建成年份数据格式不正确或者有空行，请核实第" + i + "条");
							throw e;
						}

						// N.建筑面积
						String jzmj = Common.trim(sht.getCell(13, i).getContents());
						try {
							bean.setJzmj(Double.parseDouble(jzmj));
						} catch (Exception e) {
							Exception e1 = new Exception("建筑面积格式不正确或者有空行，请核实第" + i + "条");
							throw e1;
						}

						// O.评估价格
						String pgjg = Common.trim(sht.getCell(14, i).getContents());
						try {
							bean.setPgjg(Double.parseDouble(pgjg));
						} catch (Exception e) {
							Exception e1 = new Exception("单价格式不正确或者有空行，请核实第" + i + "条");
							throw e1;
						}
						// P.交易日期
						bean.setJysj(Common.convertStringToDate(Common.trim(sht.getCell(15, i).getContents())));
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
						bean.setSzqy(Common.trim(sht.getCell(0, i).getContents()));
						// B.小区名称
						bean.setXqdm(Common.trim(sht.getCell(1, i).getContents()));
						// C. 房屋类型
						bean.setFwlx(Common.trim(sht.getCell(2, i).getContents()));
						// D. 楼层
						try {
							String lc = Common.trim(sht.getCell(3, i).getContents());
							bean.setLc(Short.parseShort(lc));
						} catch (Exception e) {
							Exception e1 = new Exception("所在楼层格式不正确，请核实第" + i + "条数据");
							throw e1;
						}
						// E. 总楼层
						try {
							String zlc = Common.trim(sht.getCell(4, i).getContents());
							bean.setZcs(Short.parseShort(zlc));
						} catch (Exception e) {
							Exception e1 = new Exception("总楼层格式不正确,请核实第" + i + "条数据");
							throw e1;
						}

						// F.建成年份
						String jcnf = Common.trim(sht.getCell(5, i).getContents());
						if (jcnf.length() == 4) {
							bean.setJcnf(jcnf);
						} else {
							Exception e = new Exception("建成年份数据格式不正确或者有空行，请核实第" + i + "条");
							throw e;
						}

						// G.建筑面积
						String jzmj = Common.trim(sht.getCell(6, i).getContents());
						try {
							bean.setJzmj(Double.parseDouble(jzmj));
						} catch (Exception e) {
							Exception e1 = new Exception("建筑面积格式不正确或者有空行，请核实第" + i + "条");
							throw e1;
						}
						// H.房屋朝向
						bean.setFwcx(Common.trim(sht.getCell(7, i).getContents()));
						// I.房屋装修
						bean.setFwzx(Common.trim(sht.getCell(8, i).getContents()));
						// J.评估价格
						String pgjg = Common.trim(sht.getCell(9, i).getContents());
						try {
							bean.setPgjg(Double.parseDouble(pgjg));
						} catch (Exception e) {
							Exception e1 = new Exception("单价格式不正确或者有空行，请核实第" + i + "条");
							throw e1;
						}
						// K.交易日期
						bean.setJysj(Common.convertStringToDate(Common.trim(sht.getCell(10, i).getContents())));
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
						bean.setSzqy(Common.trim(sht.getCell(0, i).getContents()));
						// B.小区名称
						bean.setXqdm(Common.trim(sht.getCell(1, i).getContents()));
						// C. 房屋类型
						bean.setFwlx(Common.trim(sht.getCell(2, i).getContents()));
						// D. 楼层
						try {
							String lc = Common.trim(sht.getCell(3, i).getContents());
							bean.setLc(Short.parseShort(lc));
						} catch (Exception e) {
							Exception e1 = new Exception("所在楼层格式不正确，请核实第" + i + "条数据");
							throw e1;
						}
						// E. 总楼层
						try {
							String zlc = Common.trim(sht.getCell(4, i).getContents());
							bean.setZcs(Short.parseShort(zlc));
						} catch (Exception e) {
							Exception e1 = new Exception("总楼层格式不正确,请核实第" + i + "条数据");
							throw e1;
						}

						// F.建成年份
						String jcnf = Common.trim(sht.getCell(5, i).getContents());
						if (jcnf.length() == 4) {
							bean.setJcnf(jcnf);
						} else {
							Exception e = new Exception("建成年份数据格式不正确或者有空行，请核实第" + i + "条");
							throw e;
						}

						// G.建筑面积
						String jzmj = Common.trim(sht.getCell(6, i).getContents());
						try {
							bean.setJzmj(Double.parseDouble(jzmj));
						} catch (Exception e) {
							Exception e1 = new Exception("建筑面积格式不正确或者有空行，请核实第" + i + "条");
							throw e1;
						}
						// H.房屋朝向
						bean.setFwcx(Common.trim(sht.getCell(7, i).getContents()));
						// I.房屋装修
						bean.setFwzx(Common.trim(sht.getCell(8, i).getContents()));
						// J.评估价格
						String pgjg = Common.trim(sht.getCell(9, i).getContents());
						try {
							bean.setPgjg(Double.parseDouble(pgjg));
						} catch (Exception e) {
							Exception e1 = new Exception("单价格式不正确或者有空行，请核实第" + i + "条");
							throw e1;
						}
						// K.交易日期
						bean.setJysj(Common.convertStringToDate(Common.trim(sht.getCell(10, i).getContents())));
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
						bean.setSzqy(Common.trim(sht.getCell(0, i).getContents()));
						// C. 房屋类型
						bean.setFwlx(Common.trim(sht.getCell(1, i).getContents()));
						// B.类型名称
						bean.setLxmc(Common.trim(sht.getCell(2, i).getContents()));
						// D.修正值
						try {
							String xzxs = Common.trim(sht.getCell(3, i).getContents());
							bean.setXzxs(Double.parseDouble(xzxs));
						} catch (Exception e) {
							Exception e1 = new Exception("修正系数格式不正确，请核实" + i + "条数据");
							throw e1;
						}
						// E. 运算类型
						bean.setCzlx(Common.trim(sht.getCell(4, i).getContents()).equals("乘") ? 0 : 1);
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
				label = new Label(j++, i + 1, Common.formatToYYYYMMDD(ebList.get(i).getJysj()));
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
				label = new Label(j++, i + 1, Common.formatToYYYYMMDD(ebList.get(i).getJysj()));
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
				label = new Label(j++, i + 1, Common.formatToYYYYMMDD(ebList.get(i).getJysj()));
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
							String value = Common.trim(sht.getCell(1, i).getContents());
							bean.setCd00002Pssd(String.valueOf(Integer.parseInt(value)).toString());
						} catch (Exception e) {
							Exception e1 = new Exception("估价时点格式不正确,请核实第" + i + "条数据");
							throw e1;
						}
						// C.修正系数
						try {
							String value = Common.trim(sht.getCell(2, i).getContents());
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
						// Common.trim(sht.getCell(4,i).getContents());
						// bean.setZlc(Integer.parseInt(value));
						// }catch(Exception e){
						// Exception e1 = new
						// Exception("面积上限格式不正确,请核实第"+i+"条数据");
						// throw e1;
						// }
						// //F.单元格数
						// try{
						// String value =
						// Common.trim(sht.getCell(5,i).getContents());
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
							String value = Common.trim(sht.getCell(4, i).getContents());
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
							String value = Common.trim(sht.getCell(3, i).getContents());
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
	 * 通用导出
	 * 
	 * @param rs
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static ByteArrayOutputStream getExcelGen(ResultSet rs, String fileName,
			ArrayList<HashMap<String, String>> hashList) throws Exception {
		ByteArrayOutputStream bOutputStrem = new ByteArrayOutputStream();
		String root_path = ServletActionContext.getServletContext().getRealPath("/");
		root_path = root_path.replace('\\', '/');
		String filePath = root_path + "/reports/" + fileName;

		// 获取模板信息
		InputStream is = null;
		Workbook wb = null;
		Sheet sht = null;

		// 导出模板信息
		Label label;
		WritableWorkbook workbook = null;
		try {
			// 获取导入信息
			is = new FileInputStream(new File(filePath));
			wb = Workbook.getWorkbook(is);
			if (wb.getNumberOfSheets() > 0) {
				sht = wb.getSheet(0);
				int columnSheet = sht.getColumns();

				// 根据导入模板制作导出模板表头
				WorkbookSettings workSet = new WorkbookSettings();
				workSet.setArrayGrowSize(999999999);
				// 覆写模板中单个字段信息

				workbook = Workbook.createWorkbook(bOutputStrem, wb, workSet);
				WritableSheet sheet = workbook.getSheet(0);
				sheet = overWriteSimple(sheet, hashList);

				// 设置单元格样式
				WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD);
				WritableCellFormat cellFormatText = new WritableCellFormat(NumberFormats.TEXT);
				cellFormatText.setFont(font);
				cellFormatText.setAlignment(Alignment.LEFT);
				cellFormatText.setVerticalAlignment(VerticalAlignment.CENTRE);
				cellFormatText.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
				// 小数
				WritableCellFormat cellFormatNumber = new WritableCellFormat(new NumberFormat("0.00"));
				cellFormatNumber.setFont(font);
				cellFormatNumber.setAlignment(Alignment.RIGHT);
				cellFormatNumber.setVerticalAlignment(VerticalAlignment.CENTRE);
				cellFormatNumber.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
				// 百分数
				WritableCellFormat cellFormatPERCENT = new WritableCellFormat(NumberFormats.PERCENT_FLOAT);
				cellFormatPERCENT.setFont(font);
				cellFormatPERCENT.setAlignment(Alignment.RIGHT);
				cellFormatPERCENT.setVerticalAlignment(VerticalAlignment.CENTRE);
				cellFormatPERCENT.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
				// 百分数
				WritableCellFormat cellFormatINT = new WritableCellFormat(NumberFormats.INTEGER);
				cellFormatINT.setFont(font);
				cellFormatINT.setAlignment(Alignment.RIGHT);
				cellFormatINT.setVerticalAlignment(VerticalAlignment.CENTRE);
				cellFormatINT.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

				// 获取每列的最后一行取其内容
				int rowSheet = sht.getRows() - 1;
				// 若该列最后一行单元格有内容则作为选中咧，若没有内容则作为上下合并的单元格处理，取该列第一个单元格内容作为选中列
				// String columnStr = getColumnStr(sht, i, rowSheet);
				int row = rowSheet;
				ArrayList<String[]> columnStrList = new ArrayList<String[]>();
				while (null != rs && rs.next()) {

					for (int i = 0; i < columnSheet; i++) {
						if (row == rowSheet) {
							columnStrList.add(Common.ToBracket(sht.getCell(i, rowSheet).getContents()));
						}

						if ("s".equals(columnStrList.get(i)[1])) { // 字符
							String contentStr = null;
							contentStr = rs.getString(columnStrList.get(i)[0]);

							label = new Label(i, row, contentStr, cellFormatText);
							sheet.addCell(label);
						}
						if ("n".equals(columnStrList.get(i)[1])) { // 数值

							Double contentStr = null;
							contentStr = rs.getDouble(columnStrList.get(i)[0]);
							Number numLabel = new Number(i, row, contentStr, cellFormatNumber);
							sheet.addCell(numLabel);
						}
						if ("p".equals(columnStrList.get(i)[1])) { // 数值

							Double contentStr = null;
							contentStr = rs.getDouble(columnStrList.get(i)[0]);
							Number numLabel = new Number(i, row, contentStr, cellFormatPERCENT);
							sheet.addCell(numLabel);
						}
						if ("i".equals(columnStrList.get(i)[1])) { // 数值

							BigDecimal contentStr = null;
							contentStr = rs.getBigDecimal(columnStrList.get(i)[0]);
							Number numLabel = new Number(i, row, contentStr.floatValue(), cellFormatINT);
							sheet.addCell(numLabel);
						}

					}
					row++;
				}
				workbook.write();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			if (null != is) {
				try {
					is.close();
				} catch (Exception el) {
				}
			}
			throw e;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception el) {
				}
			}
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
				}
			}
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
		}

		return bOutputStrem;
	}

	/**
	 * 覆写单个字段信息
	 * 
	 * @return
	 * @throws Exception
	 */
	private static WritableSheet overWriteSimple(WritableSheet sht, ArrayList<HashMap<String, String>> hashList)
			throws Exception {

		if (hashList == null)
			return sht;
		try {
			// 循环每一个有内容的单元格
			for (int i = 0; i < sht.getRows(); i++) {
				for (int j = 0; j < sht.getColumns(); j++) {
					String content = sht.getCell(j, i).getContents();
					// 若单元格内容为{rs, s}，若不包含就跳过
					if (content.contains("{") && content.contains("}")) {
						// 括号
						String[] tempS = Common.ToBracket(content);
						// 判断映射中是否包含该信息
						for (int k = 0; k < hashList.size(); k++) {
							HashMap<String, String> tempHash = hashList.get(k);
							// 获取键值
							String tempStr = tempHash.get(tempS[0]);
							// 若获得键值则覆盖
							if (null != tempStr && !"".equals(tempStr)) {
								if ("s".equals(tempS[1])) { // 字符
									Label label = new Label(j, i, tempStr);
									sht.addCell(label);
								}
								if ("n".equals(tempS[1])) { // 数值
									Double value = null;
									try {
										value = Double.parseDouble(tempStr);
									} catch (Exception e) {
										throw new Exception("第" + i + "行，第" + j + "列单元格转换数字格式出错"
												+ e.getMessage().replace("\n", "<br />"));
									} finally {
										//
									}
									Number label = new Number(j, i, value);
									sht.addCell(label);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("覆写单个字段时出错：" + e.getMessage().replace("\n", "</ br>"));
		} finally {
			//
		}
		return sht;
	}

}
