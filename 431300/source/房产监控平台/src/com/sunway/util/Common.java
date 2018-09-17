/**
 * 
 */
package com.sunway.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionContext;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;



/**
 * @author Andy.Gao
 * 
 */
public class Common {
	/**
	 * @param str
	 * @return
	 */
	public static String converType(String str){
		String tmpStr = "";
		try {
			
			int i = str.indexOf("--");
			if(i!=-1)
			{
				tmpStr = str.substring(0,i);
			}
			else
			{
				tmpStr = str;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmpStr;
	}
	
	public static void CheckCreateDir(String url, String dir) throws Exception
    {
    	String[] path = dir.split("/");
    	String tempPath = "";
    	for(int i = 0; i < path.length; i++){
    		if (Common.isNullOrEmpty(path[i])) continue;
    		tempPath = tempPath + path[i] + "/";
    		SmbFile uploadFile = new SmbFile(url+ tempPath); 
    		if(!uploadFile.exists()){  
                //创建远程文件夹   
				 uploadFile.mkdir();				 
           } 
    	}
    	
    }
	
	public static void CopyRemoteFile(String iFile, String oFile) throws Exception
    {
		FileInputStream inpic=new FileInputStream(iFile);
		try
		{
			SmbFile sw=new SmbFile(oFile);
			SmbFileOutputStream out = new SmbFileOutputStream(sw);
			try
			{
				byte []b =new byte[1024*8];
				int len =0;
				while((len=inpic.read(b)) != -1)
				{
					out.write(b, 0, len);
				}
				out.flush();
			}
			finally{				
				out.close();
				out = null;
			}			
		}
		finally{
			inpic.close();
			inpic = null;
		}
    }
	
	public static void CopyLocalFile(String iFile, String oFile) throws Exception
    {
		FileInputStream inpic=new FileInputStream(iFile);
		try
		{
			FileOutputStream out = new FileOutputStream(oFile); 
			try
			{
				byte []b =new byte[1024*8];
				int len =0;
				while((len=inpic.read(b)) != -1)
				{
					out.write(b, 0, len);
				}
				out.flush();
			}
			finally{				
				out.close();
				out = null;
			}			
		}
		finally{
			inpic.close();
			inpic = null;
		}
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
	 * 處理String型為NULL時
	 * 
	 * @param value
	 * @return
	 */
	public static String checkNullEx(String value) {
		String resultValue = "";
		if (null != value || !"null".equals(value) || !"".equals(value))
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
			// e.printStackTrace();
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
			e.printStackTrace();
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
				// e.printStackTrace();
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
			// e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 將字符串轉換成Timestamp類型
	 * 
	 * @param time
	 * @return
	 */
	public static String convertStringToDue(String time) {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = df1.parse(time);
			String tmpTime = df1.format(date);
			//Timestamp ts = Timestamp.valueOf(tmpTime);
			return tmpTime;
		} catch (Exception e) {
			// e.printStackTrace();
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
			// e.printStackTrace();
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
			// e.printStackTrace();
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
			// e.printStackTrace();
		}
		return result;
	}
	public static String convertSqlDateToString(java.sql.Date sqlDate) {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = Constant.STRING_EMPTY;
		try {
			result = df1.format(sqlDate);
		} catch (Exception e) {
			// e.printStackTrace();
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
			   	e.printStackTrace();
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
			   	e.printStackTrace();
		   }     
		}else{
			try {
				byte[] excelString = "".getBytes(Constant.CHARSET_UTF8);
				resultStream = new ByteArrayInputStream(excelString, 0, excelString.length);
		   } catch (Exception e) {
			   	e.printStackTrace();
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
	 * 对日期进行格式化(yyyy-mm-dd)
	 * @param value 日期
	 * @return 格式后的日期字符串
	 */
	public static String formatToYMDHMS(Date value) {
		String resultValue = null;
		if(null!=value) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			resultValue = sdf.format(value);
		}
		return resultValue;
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
		if(null != date && !"".equals(date)){
			StringBuffer buffer = new StringBuffer(date.toString());
			buffer.append(" ");
			buffer.append(time.toString());
			result = buffer.toString();
		}
		
		return result;
	}
	
	/**
	 * 取得系统当前日期
	 */
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	/**
	 * 取得距离当前日期N年前的日期
	 */
	public static String getCurrentDateBeforNYears(int years){    
	       String str = "";    
	       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");        
	   
	       Calendar lastDate = Calendar.getInstance();
	       lastDate.add(Calendar.YEAR, 0-years);
	       str=sdf.format(lastDate.getTime());    
	       return str;      
	}
	/**
	 * 取得系统当前日期
	 */
	public static String getCurrentMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		return sdf.format(new Date());
	}
	/**
	 * 取得系统当前日期
	 */
	public static String getCurrentMonthB() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		return sdf.format(new Date());
	}
	/**
	 * 取得系统当前日期yyyyMM
	 */
	public static String getCurrentMontha() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		return sdf.format(new Date());
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
	 * 取得系统当月月份
	 */
	public static String getNextMonth(){    
	        String str = "";    
	       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");        
	   
	       Calendar lastDate = Calendar.getInstance();    
	      //lastDate.add(Calendar.MONTH,1);//减一个月    
	      lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天     
	       str=sdf.format(lastDate.getTime());    
	       return str;      
	    }
	/**
	 * 取得系统当月月份
	 */
	public static String getNextMonthB(){    
	        String str = "";    
	       SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");        
	   
	       Calendar lastDate = Calendar.getInstance();    
	      //lastDate.add(Calendar.MONTH,1);//减一个月    
	      lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天     
	       str=sdf.format(lastDate.getTime());    
	       return str;      
	    }
	/**
	 * 取得系统当上个月月份
	 */
	public static String getPreviousMonthB(){    
	        String str = "";    
	       SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");        
	   
	       Calendar lastDate = Calendar.getInstance();    
	       lastDate.add(Calendar.MONTH,-1);//减一个月    
	       //lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天     
	       str=sdf.format(lastDate.getTime());    
	       return str;      
	    }
	/**
	 * 取得系统当前时间
	 */
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(new Date());
	}
	
	/**
	 * 取得系统当前时间
	 */
	public static String getCurrentTimeA() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
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
		if(!isNullOrEmpty(value))
			resultValue = Constant.STRING_PERCENT + value.trim() + Constant.STRING_PERCENT;
		else
			resultValue = value;
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
		if (filePath==null) return false;
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
	public static boolean isNullOrEmpty(Date datestrParam) {

		if (null == datestrParam) {
			return true;
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
			resultValue = isNullOrEmpty(value) ? new BigDecimal(0.0)
					: new BigDecimal(value);
		} catch (Exception ex) {
			// ex.printStackTrace();
		} finally {
			//
		}
		return resultValue;
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
			
		}
		return currentDate;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Boolean isPastDue(){
		Boolean resultValue = false;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date lockDate = sdf.parse(Constant.SYS_LOCK_DATE);
			Date curDate = new Date();
			resultValue = curDate.before(lockDate);
			
		} catch (Exception e) {
			
		}
		return resultValue;
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
	 * 把丘地号拆分出 丘号
	 * @param qdh
	 * @return
	 */
	public static String splitQdhToQh(String qdh){
		String tmpStr = "";
		try {
			tmpStr = qdh.substring(0,qdh.indexOf("-"));
		} catch (Exception e) {
			
		}
		return tmpStr;
	}
	
	/**
	 * 把丘地号拆分出 地号
	 * @param qdh
	 * @return
	 */
	public static String splitQdhToDh(String qdh){
		
		String tmpStr = "";
		try {
			tmpStr = qdh.substring(qdh.indexOf("-")+1,qdh.length());
		} catch (Exception e) {
			
		}
		return tmpStr;
	}
	
	/**
	 * 转换丘地号格式
	 * @param value
	 * @return
	 */
	public static  String formatQDH(String value){
		if(null != value && !"".equals(value)){
			return value.replace(",", " ");
		}else{
			return value;
		}
		
	}
	
	/**
	 * 对导出数据金钱进行格式化，
	 * @param type
	 * @param value
	 * @return
	 */
	public static String  formatExportMoney(String type,Double value){
		if("int".equals(type) && String.valueOf(value).contains(".")){
			String[] strValue = String.valueOf(value).split("\\.");
			return strValue[0];
		}else if("double".equals(type) && String.valueOf(value).contains(".")){
			String[] strValue = String.valueOf(value).split("\\.");
			StringBuffer strBuffer = new StringBuffer(strValue[0]);
			strBuffer.append(".");
			if(strValue[1].length() >= 2){
				strBuffer.append(strValue[1].substring(0, 2));
			}else{
				strBuffer.append(strValue[1]);
			}
			
			return strBuffer.toString();
		}else{
			return String.valueOf(value);
		}
		
	}
	
	/**
	 * 创建装载上传文件的数组
	 * @param session
	 */
	public static void createUploadFiles(){
		ArrayList<String> uploadFileArrayList = new ArrayList<String>();
		ActionContext.getContext().getSession().put("uploadFileArrayList", uploadFileArrayList);
	}
	
	/**
	 * 装载文件路径
	 * @param path
	 */
	@SuppressWarnings("unchecked")
	public static void addUploadFiles(String path){
		ArrayList<String> uploadFileArray = (ArrayList<String>)ActionContext.getContext().getSession().get("uploadFileArrayList");
		uploadFileArray.add(path);
		ActionContext.getContext().getSession().put("uploadFileArrayList", uploadFileArray);
	}
	
	/**
	 * SESSION失效删除该SESSION上传的文件
	 * @param filePaths
	 */
	public static void removeUploadFiles(ArrayList<String> filePaths){
		if(null != filePaths && !"".equals(filePaths) && filePaths.size() > 0){
			for(int i = 0;i < filePaths.size();i++){
				(new   File(filePaths.get(i))).delete(); 
			}
		}
		
	}
	
	/**
	 * URL解码
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String decodeURL(String url) throws Exception {
		
		return java.net.URLDecoder.decode(url, "UTF-8");
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
			String os = System.getProperty("os.name");//获取系统名称
			Process p = null;
			if(null != os && os.startsWith("Windows")){
				p = rt.exec("C:\\Program Files\\WinRAR\\UNRAR.EXE x -o+ -p- " + compress + " " + decompression);
			}else{
				p = rt.exec("unrar x -o- -y " + compress + " " + decompression + "/");        //for Linux
			}
		    StringBuffer sb = new StringBuffer();
		    java.io.InputStream fis = p.getInputStream();
		    int value = 0;
		    while ((value = fis.read()) != -1)
		    {
		            sb.append((char) value);
		    }
		    fis.close();
			new String(sb.toString().getBytes("ISO-8859-1"), "GBK");
		}catch(Exception e){
			e.printStackTrace();
			resultB = false;
			return resultB;
		}
	    return resultB;
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
	        wcf.setAlignment(Alignment.CENTRE);//水平对齐
	        wcf.setBackground(Colour.GREEN);
	        return wcf;
	}
	
	/**
	 * 得到标题的样式
	 * @param value
	 * @return
	 * @throws WriteException 
	 */
	public static WritableCellFormat getExcelTableStyle() throws WriteException {
	WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
	        WritableCellFormat wcf = new WritableCellFormat(wf); 
	        //wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
	        wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
	        wcf.setAlignment(Alignment.CENTRE);//水平对齐
	        return wcf;
	}
	/**
	 * 得到标题的样式
	 * @param value
	 * @return
	 * @throws WriteException 
	 */
	public static WritableCellFormat getExcelOtherTitleStyle() throws WriteException {
	WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
	        WritableCellFormat wcf2 = new WritableCellFormat(wf2); 
	        wcf2.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
	        wcf2.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
	        wcf2.setBackground(Colour.ORANGE);
	        return wcf2;
	}
	/**
	 * 得到标题的样式
	 * @param value
	 * @return
	 * @throws WriteException 
	 */
	public static WritableCellFormat getExcelErrStyle() throws WriteException {
	WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.RED);
	        WritableCellFormat wcf = new WritableCellFormat(wf); 
	        return wcf;
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
	
	/**
	 * 处理报出异常时字符串中含有网页无法显示字符
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String dealErrors(String str)throws Exception 
	{
		return str.replace("/", "\\").replace("\n", "<br />");
	}
	
	/**
	 * 判断字符串是否为空，   true:不为空  false:为空
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static boolean valiEmpty(String str)throws Exception
	{
		if(null != str && !"".equals(str))
		{
			return true;
		}else{
			return false;
		}
		
	}
	/**
	 * 用户权限转换String
	 * 
	 * @param roleList
	 * @return roleString
	 */
	public static String converRoleListToString(ArrayList<String> roleList)
	{
		String userRole = null;
		try {
			for (Integer i = 0; i < roleList.size(); i++) {
				userRole = Common.checkNull(userRole) + roleList.get(i)
						+ Constant.STRING_COMMA;
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return userRole;
	}

	/**
	 * 写入导入错误模版
	 * @param path
	 * @param filePath
	 * @param outStream
	 * @return
	 */
	public static boolean writeImpErrorFile(String path, String filePath, ByteArrayOutputStream outStream){
		if(!new File(path).exists()){
			new File(path).mkdir();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(filePath));
			byte[] b = outStream.toByteArray();
			fos.write(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			closeObj(fos);
		}
		return true;
	}
	

	//释放对象
	public static void upload(String fileServerPath,File getUpload){
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try{
			
			//建立文件上传的输出流
			fos = new FileOutputStream(fileServerPath);
			//以上传文件建立一个文件上传流
			fis = new FileInputStream(getUpload);
			//将上传文件的内容写入服务器
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer))>0){
				fos.write(buffer,0,len);			
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		} finally {
			Common.closeObj(fos);
			Common.closeObj(fis);
		}
	}
	
	//释放对象
	public static void closeObj(FileOutputStream obj){
		try{
			if(null!=obj) 
				obj.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			obj = null;
		}
		
	}
	
	public static void closeObj(FileInputStream obj){
		try{
			if(null!=obj) 
				obj.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			obj = null;
		}
		
	}

}
	