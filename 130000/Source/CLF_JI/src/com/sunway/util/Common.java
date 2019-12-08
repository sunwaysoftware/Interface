/**
 * 
 */
package com.sunway.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;

import com.opensymphony.xwork2.ActionContext;
import com.sunway.interceptor.LoginInterceptor;

/**
 * @author Andy.Gao
 * 
 */
public class Common implements Serializable {
	private static Logger logger = LogManager.getLogger(LoginInterceptor.class.getName());
	private static final long serialVersionUID = -4863487906623284777L;

	/**
	 * 生成UUID
	 * @return
	 */
	public static String makeUUID() {
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}
	
	/**
	 * 處理Boolean型為NULL時
	 * @param value
	 * @return
	 */
	public static Boolean checkNull(Boolean value) {
		Boolean resultValue = false;
		if (null != value)
			resultValue = value;
		return resultValue;
	}
	
	/**
	 * 處理Double型為NULL時
	 * 
	 * @param value
	 * @return
	 */
	public static Double checkNull(Double value) {
		Double resultValue = 0.0;
		if (null != value)
			resultValue = value;
		return resultValue;
	}

	/**
	 * 處理Integer型為NULL時
	 * 
	 * @param value
	 * @return
	 */
	public static Integer checkNull(Integer value) {
		Integer resultValue = 0;
		if (null != value)
			resultValue = value;
		return resultValue;
	}

	/**
	 * 處理Long型為NULL時
	 * 
	 * @param value
	 * @return
	 */
	public static Long checkNull(Long value) {
		Long resultValue = 0l;
		if (null != value)
			resultValue = value;
		return resultValue;
	}

	/**
	 * 處理Short型為NULL時
	 * 
	 * @param value
	 * @return
	 */
	public static Short checkNull(Short value) {
		Short resultValue = 0;
		if (null != value)
			resultValue = value;
		return resultValue;
	}

	/**
	 * 處理String型為NULL時
	 * 
	 * @param value
	 * @return
	 */
	public static String checkNull(String value) {
		String resultValue = "";
		if (null != value)
			resultValue = value;
		return resultValue;
	}
	
	/**
	 * 處理BigDecimal型為NULL時
	 * 
	 * @param value
	 * @return
	 */
	public static BigDecimal checkNull(BigDecimal value) {
		BigDecimal resultValue = BigDecimal.valueOf(0.0);
		if (null != value)
			resultValue = value;
		return resultValue;
	}
	
	/**
	 * 转换时间 util.Date to sql.Date
	 */
	public static java.sql.Date converDate(java.util.Date date) {
		try {
			if (date == null)
				return null;
			else
				return new java.sql.Date(date.getTime());
		} catch (Exception e) {
			// logger.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * URL转码
	 * 
	 * @param param
	 *            参数值
	 * @return 转码后的字符
	 */
	public static String convertEncoding(String param) {
		try {
			if (isNullOrEmpty(param)) return "";
			byte[] bytes1 = param.getBytes("UTF-8");
			byte[] bytes2 = param.getBytes("ISO-8859-1");
			byte[] bytes3 = param.getBytes("Unicode");
			if (param.equals(new String(bytes1))) {
				param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
			}else if (param.equals(new String(bytes2))) {
				param = new String(param.getBytes("ISO-8859-1"), "ISO-8859-1");
			}else if (param.equals(new String(bytes3))) {
				param = new String(param.getBytes("ISO-8859-1"), "Unicode");
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}
		return param;
	}

	/**
	 * 將字符串轉換成Date類型
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertStringToDate(String date) {
		Date result = null;
		if(null!=date){
			String parse = date;
			parse = parse.replaceFirst("^[0-9]{4}([^0-9]?)", "yyyy$1");
			parse = parse.replaceFirst("^[0-9]{2}([^0-9]?)", "yy$1");
			parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1MM$2");
			parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}( ?)", "$1dd$2");
			parse = parse.replaceFirst("( )[0-9]{1,2}([^0-9]?)", "$1HH$2");
			parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1mm$2");
			parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1ss$2");
			DateFormat format = new SimpleDateFormat(parse);
			try {
				result = format.parse(date);
			} catch (ParseException e) {
				// logger.error(e.getMessage());
			}
		}
		return result;
	}
	
	/**
	 * 將字符串轉換成Timestamp類型
	 * 
	 * @param time
	 * @return
	 */
	public static Timestamp convertStringToTimestamp(String time) {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = df1.parse(time + " 00:00:00");
			String tmpTime = df1.format(date);
			Timestamp ts = Timestamp.valueOf(tmpTime);
			return ts;
		} catch (Exception e) {
			// logger.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * 將字符串轉換成Timestamp類型(查询时间范围时，结束时间用)
	 * 
	 * @param time
	 * @return
	 */
	public static Timestamp convertStringToTimestampE(String time) {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = df1.parse(time + " 23:59:59");
			String tmpTime = df1.format(date);
			Timestamp ts = Timestamp.valueOf(tmpTime);
			return ts;
		} catch (Exception e) {
			// logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 將字符串轉換成Timestamp類型
	 * 
	 * @param time
	 * @return
	 */
	public static Timestamp convertStringToTimestampHMS(String time) {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = df1.parse(time);
			String tmpTime = df1.format(date);
			Timestamp ts = Timestamp.valueOf(tmpTime);
			return ts;
		} catch (Exception e) {
			// logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 將字符串轉換成Timestamp類型
	 * 
	 * @param time
	 * @return
	 */
	public static String convertTimestampToString(Timestamp timestamp) {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = Constant.STRING_EMPTY;
		try {
			result = df1.format(timestamp);
		} catch (Exception e) {
			// logger.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 将String转化为Boolean
	 * 
	 * @param value
	 *            原值
	 * @return 转化后值
	 */
	public static Boolean convertToBoolean(String value) {
		Boolean resultValue = false;
		try {
			resultValue = Boolean.parseBoolean(value);
		} catch (Exception ex) {
			// ex.printStackTrace();
		} finally {
			//
		}
		return resultValue;
	}

	/**
	 * 将String转化为Date
	 * 
	 * @param value
	 *            原值
	 * @return 转化后值
	 */
	public static Date convertToDate(String value) {
		Date resultValue = null;
		SimpleDateFormat sdf = new SimpleDateFormat(Constant.FORMAT_DATE);
		try {
			resultValue = sdf.parse(value);
		} catch (Exception ex) {
			// ex.printStackTrace();
		} finally {
			//
		}
		return resultValue;
	}
	/**
	 * 将String转化为java.sql.Date
	 * 
	 * @param value
	 *            原值
	 * @return 转化后值
	 */
	public static java.sql.Date convertToSqlDate(String value) {
		java.sql.Date resultValue = null;
		try {
			resultValue = new java.sql.Date(convertToDate(value).getTime());
			
		} catch (Exception ex) {
			// ex.printStackTrace();
		} finally {
			//
		}
		return resultValue;
	}
	
	/**
	 * 将String转化为Double
	 * 
	 * @param value
	 *            原值
	 * @return 转化后值
	 */
	public static Double convertToDouble(String value) {
		Double resultValue = 0.0;
		try {
			resultValue = Double.parseDouble(value.replace(",", ""));
		} catch (Exception ex) {
			// ex.printStackTrace();
		} finally {
			//
		}
		return resultValue;
	}	
	
	/**
	 * 将String转化为Byte
	 * 
	 * @param value
	 *            原值
	 * @return 转化后值
	 */
	public static Byte convertToByte(String value) {
		Byte resultValue = 0;
		try {
			resultValue = Byte.parseByte(value.replace(",", ""));
		} catch (Exception ex) {
			// ex.printStackTrace();
		} finally {
			//
		}
		return resultValue;
	}	
	
	
	/**
	 * 将String转化为Integer
	 * 
	 * @param value
	 *            原值
	 * @return 转化后值
	 */
	public static Integer convertToInteger(String value) {
		Integer resultValue = 0;
		try {
			resultValue = Integer.parseInt(value);
		} catch (Exception ex) {
			// ex.printStackTrace();
		} finally {
			//
		}
		return resultValue;
	}
	
	/**
	 * 将String转化为Long
	 * 
	 * @param value
	 *            原值
	 * @return 转化后值
	 */
	public static Long convertToLong(String value) {
		Long resultValue = 0l;
		try {
			resultValue = Long.parseLong(value);
		} catch (Exception ex) {
			// ex.printStackTrace();
		} finally {
			//
		}
		return resultValue;
	}
	
	/**
	 * 将String转化为Short
	 * 
	 * @param value
	 *            原值
	 * @return 转化后值
	 */
	public static Short convertToShort(String value) {
		Short resultValue = 0;
		try {
			resultValue = Short.parseShort(value);
		} catch (Exception ex) {
			// ex.printStackTrace();
		} finally {
			//
		}
		return resultValue;
	}

	/**
	 * 将集合输出为CSV
	 * @param list
	 * @return
	 */
	public static InputStream exportCSV(StringBuffer strBuf){
		InputStream resultStream = null;
		if( strBuf!=null && strBuf.length()>0 ){
			try {
				byte[] excelString = strBuf.toString().getBytes(Constant.CHARSET_GBK);
				resultStream = new ByteArrayInputStream(excelString, 0, excelString.length);
		   } catch (Exception e) {
			   	logger.error(e.getMessage());
		   }     
		}
		return resultStream;
	}

	/**
	 * 输出为TEXT
	 * @param strBuf
	 * @return
	 */
	public static InputStream exportTEXT(StringBuffer strBuf){
		InputStream resultStream = null;
		if( strBuf!=null && strBuf.length()>0 ){
			try {
				byte[] excelString = strBuf.toString().getBytes(Constant.CHARSET_UTF8);
				resultStream = new ByteArrayInputStream(excelString, 0, excelString.length);
		   } catch (Exception e) {
			   	logger.error(e.getMessage());
		   }     
		}else{
			try {
				byte[] excelString = "".getBytes(Constant.CHARSET_UTF8);
				resultStream = new ByteArrayInputStream(excelString, 0, excelString.length);
		   } catch (Exception e) {
			   	logger.error(e.getMessage());
		   }  
		}
		return resultStream;
	}

	/**
	 * 对日期进行格式化(yyyy)
	 * @param value 日期
	 * @return 格式后的日期字符串
	 */
	public static String formatToYYYY(Date value) {
		String resultValue = null;
		if(null!=value) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			resultValue = sdf.format(value);
		}
		return resultValue;
	}

	/**
	 * 对日期进行格式化(yyyy-mm)
	 * @param value 日期
	 * @return 格式后的日期字符串
	 */
	public static String formatToYYYYMM(Date value) {
		String resultValue = null;
		if(null!=value) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			resultValue = sdf.format(value);
		}
		return resultValue;
	}

	/**
	 * 对日期进行格式化(yyyy-mm-dd)
	 * @param value 日期
	 * @return 格式后的日期字符串
	 */
	public static String formatToYYYYMMDD(Date value) {
		String resultValue = null;
		if(null!=value) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			resultValue = sdf.format(value);
		}
		return resultValue;
	}
	
	/**
	 * 对日期进行格式化(YYYYMMDD)
	 * @param value
	 * @return
	 */
	public static String formatToYYYYMMDDSimple(Date value){
		String resultValue = null;
		StringBuffer resBuffer = new StringBuffer();
		
		if(null!=value) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			resultValue = sdf.format(value);
			String[] strBuffer = resultValue.split("-");
			for(int i = 0;i < strBuffer.length;i++){
				resBuffer.append(strBuffer[i]);
			}
		}
		return resBuffer.toString();
	}

	/**
	 * 对日期进行格式化(yyyy-mm-dd)
	 * @param value 日期
	 * @return 格式后的日期字符串
	 */
	public static String formatToYMDHMS(Date value) {
		String resultValue = null;
		if(null!=value) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			resultValue = sdf.format(value);
		}
		return resultValue;
	}
	
	/**
	 * 取得系统当前日期
	 */
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}

	/**
	 * 取得系统当前时间
	 */
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(new Date());
	}

	/**
	 * 取得客戶端IP地址
	 * @param request
	 * @return 客戶端IP地址
	 */
	public static String getIpAddr(HttpServletRequest request) {
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    }
	    return ip;
	}
	
	public static Integer getPageSize(Integer pageSize) {
		if (pageSize==null)
		{
			return 20;
		}
		else
		{
			return pageSize;
		}
	}
	
	/**
	 * 取得记录总页数
	 * 
	 * @return 记录总页数
	 */
	public static Integer getPageCount(Integer total, String dataSize) {
		Integer resultValue = 1;
		Integer pageSize = 0;
		
		if(!Common.isNullOrEmpty(dataSize))
			pageSize = Common.convertToInteger(dataSize);
		else
			pageSize = Constant.PAGE_SIZE;
		if (null == total)
			total = 0;
		resultValue = total / pageSize;
		if (total % pageSize > 0) {
			resultValue++;
		}
		return resultValue;
	}
	
	/**
	 * 对模糊查询字段进行处理
	 * @param value 查询内容(例:aaa123)
	 * @return 处理后内容(例:%aaa123%)
	 */
	public static String getSearchLike(String value) {
		String resultValue = null;
		if(!isNullOrEmpty(value)){
			value = value.replace(" ", Constant.STRING_PERCENT);
			value = value.replace("　", Constant.STRING_PERCENT);
			resultValue = Constant.STRING_PERCENT + value.trim() + Constant.STRING_PERCENT;
		} else {
			resultValue = value;
		}
		return resultValue;
	}
	
	/**
	 * 是否目录
	 * 
	 * @param filePath
	 *            文件路径
	 * @return
	 */
	public static Boolean isDirectory(String filePath) {
		Boolean resultValue = false;
		File file = new File(filePath);
		if (file.isDirectory()) {
			resultValue = true;
		}
		return resultValue;
	}

	/**
	 * 判读文件是否存在并可读取
	 * 
	 * @param filePath
	 *            文件路径
	 * @return
	 */
	public static Boolean isFileExist(String filePath) {
		Boolean resultValue = false;
		File file = new File(filePath);
		if (file.exists()) {
			if (file.canRead()) {
				resultValue = true;
			}
		}
		return resultValue;
	}
	
	/**
	 * 判斷字符串是否為空
	 * 
	 * @param strParam
	 *            待判斷的字符串
	 * @return True空; False非空
	 */
	public static boolean isNullOrEmpty(String strParam) {

		if (null == strParam) {
			return true;
		} else {
			if (Constant.STRING_EMPTY.equals(strParam.trim())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判斷 更新日期是否為空
	 * 
	 * @param timestampParam
	 *            待判斷的字符串
	 * @return True空; False非空
	 */
	public static boolean isNullOrEmpty(Timestamp timestampParam) {

		if (null == timestampParam) {
			return true;
		} 
		return false;
	}
	
	/**
	 * 去掉逗号
	 * @param oldStr
	 * @return
	 */
	public static String removeComma (String oldStr){
		if (!Common.isNullOrEmpty(oldStr)) {
			String newStr = oldStr.substring(0,oldStr.length()-1);
			return newStr;
		}
		return Constant.STRING_EMPTY;
	}
	
	/**
	 *  去空格
	 * @param value
	 * @return
	 */
	public static String trim(String str)
	{		
		return checkNull(str).trim();
	}
	
	/**
	 * 将String转化为BigDecimal
	 * 
	 * @param value
	 *            原值
	 * @return 转化后值
	 */
	public static BigDecimal convertToBigDecimal(String value) {
		BigDecimal resultValue = null;
		try {
			resultValue = isNullOrEmpty(value) ? new BigDecimal(0.0) : new BigDecimal(value);
		} catch (Exception ex) {
			logger.error(ex);
		} finally {
			//
		}
		return resultValue;
	}

	/**
	 * 读取系统当前年份
	 * @param value
	 * @return
	 */
	public static String readCurrentYear() {
		String currentDate = "";
		
		try {
			Date resultValue = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			currentDate = sdf.format(resultValue);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return currentDate;
	}
	
	/**
	 * 读取系统当前日期
	 * @param value
	 * @return
	 */
	public static String readCurrentDate() {
		String currentDate = "";
		
		try {
			Date resultValue = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			currentDate = sdf.format(resultValue);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return currentDate;
	}
	
	/**
	 * 读取系统当前日期
	 * @param value
	 * @return
	 */
	public static String readCurrentDateHMS() {
		String currentDate = "";
		
		try {
			Date resultValue = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			currentDate = sdf.format(resultValue);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return currentDate;
	}
	
	public static void main(String[] args) {
	}
	
	
	/**
	 * 正负数值判断(供公式显示用)
	 * @param value
	 * @return
	 */
	public static String isPlusOrSubtractionSign(Double value) {
		String resultValue = "";
		
		if (null != value){
			Double tmpValue = Math.abs(value);
			resultValue = (tmpValue.equals(value))?"-":"+";
		}
		return resultValue;
	}
	
	
	
	/**
	 * 取得系统当前年
	 */
	public static String getCurrentDatea() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(new Date());
	}
	
	/**
	 * 取得系统当月1号
	 */
	
	public static String getNextMonthFirst(){    
	        String str = "";    
	       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");        
	   
	       Calendar lastDate = Calendar.getInstance();    
	      //lastDate.add(Calendar.MONTH,1);//减一个月    
	      lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天     
	       str=sdf.format(lastDate.getTime());    
	       return str;      
	    } 
	
	/**
	 * 装载文件路径
	 * @param path
	 */
	public static void addUploadFiles(String path){
		ArrayList<String> uploadFileArray = (ArrayList<String>)ActionContext.getContext().getSession().get("uploadFileArrayList");
		uploadFileArray.add(path);
		ActionContext.getContext().getSession().put("uploadFileArrayList", uploadFileArray);
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
	 * 对导出日期格式掉.0
	 * @param value
	 * @return
	 */
	public static String formatExportDateTime(ResultSet rs,String value) throws Exception{
		Date date = rs.getDate(value);
		Time time = rs.getTime(value);
		String result = "";
		if(null != date){
			StringBuffer buffer = new StringBuffer(date.toString());
			buffer.append(" ");
			buffer.append(time.toString());
			result = buffer.toString();
		}
		
		return result;
	}
	
	/**
	 * 逐个文件夹URL编码
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String picPathUrl(String url) throws Exception {
		
		String[] path = url.replace("\\", "/").split("/");
		String result = "";
		for (int i = 0;i< path.length;i++){
			if (!"".equals(path[i]))
				result = result + "/" + encoderURL(path[i]);
		}
		return result;
	}
	
	/**
	 * URL编码
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String encoderURL(String url) throws Exception {
		
		return java.net.URLEncoder.encode(url, "UTF-8");
		
	}
	
	/**
	 * SESSION失效删除该SESSION上传的文件
	 * @param filePaths
	 */
	public static void removeUploadFiles(ArrayList<String> filePaths){
		if(null != filePaths && filePaths.size() > 0){
			for(int i = 0;i < filePaths.size();i++){
				(new   File(filePaths.get(i))).delete(); 
			}
		}
		
	}
	
	
	/**
	    * 解压
	    * 
	    * @param compress
	    *             rar压缩文件
	    * @param decompression
	    *             解压路径
	    */
	public static Boolean unRar(String compress, String decompression) throws Exception {
		boolean resultB = true;
		try{
			java.lang.Runtime rt = java.lang.Runtime.getRuntime();
		    Process p = rt.exec("UNRAR.EXE x -o+ -p- " + compress + " " + decompression);
			//Process p = rt.exec("unrar x -o- -y " + compress + " " + decompression + "/");        for Linux
		    StringBuffer sb = new StringBuffer();
		    java.io.InputStream fis = p.getInputStream();
		    int value = 0;
		    while ((value = fis.read()) != -1)
		    {
		            sb.append((char) value);
		    }
		    fis.close();
			String result = new String(sb.toString().getBytes("ISO-8859-1"), "GBK");
			System.out.println(result);
		}catch(Exception e){
			logger.error(e.getMessage());
			resultB = false;
			return resultB;
		}
	    return resultB;
	}
	
	/**
	 * 去括号{str,s}str：标识；s:字符串;n:数字
	 * @param str
	 * @return
	 */
	public static String[] ToBracket(String str){
		String res = trim(str.toLowerCase());
		return res.substring(1, str.length()-1).split(",");
	}
}




