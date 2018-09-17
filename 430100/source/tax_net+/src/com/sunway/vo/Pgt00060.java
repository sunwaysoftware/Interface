package com.sunway.vo;
/**
 * 通用选择控件BEAN
 * @author Light
 *
 */
public class Pgt00060 {
	private String tablename;						//表名
	private String columnname;						//列名
	private String tablecolumn;						//数据库列字段
	private String columntype;						//列字段类型
	private String sql;
	private String javafield;
	private Integer sfcx;							//是否查询
	private Integer sfdc;							//是否导出
	private Integer isNull;							//是否必须填写
	private Integer isDataType;						//是否是数据类型
	private Integer sfdr;							//是否导入
	private Integer impModelColumn;					//导入模版该字段所对应模版列
	private String impErrorSign;					//导入错误标识
	private String impErrorMsg;						//导入错误信息
	private String impColumnContent;				//导入模版列内容
	private Integer impModelRow;					//导入模板该字段所对应模板行
	private String drmrz;							//导入默认值
	private Integer dataLength;						//字段数据长度
	
	public Pgt00060(){
		
	}
	
	public Pgt00060(String tablename){
		this.tablename = tablename;
	}
	
	/**
	 * @return the columnname
	 */
	public String getColumnname() {
		return columnname;
	}
	/**
	 * @param columnname the columnname to set
	 */
	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}
	/**
	 * @return the tablecolumn
	 */
	public String getTablecolumn() {
		return tablecolumn;
	}
	/**
	 * @param tablecolumn the tablecolumn to set
	 */
	public void setTablecolumn(String tablecolumn) {
		this.tablecolumn = tablecolumn;
	}
	/**
	 * @return the columntype
	 */
	public String getColumntype() {
		return columntype;
	}
	/**
	 * @param columntype the columntype to set
	 */
	public void setColumntype(String columntype) {
		this.columntype = columntype;
	}
	/**
	 * @return the sql
	 */
	public String getSql() {
		return sql;
	}
	/**
	 * @param sql the sql to set
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}
	/**
	 * @return the javafield
	 */
	public String getJavafield() {
		return javafield;
	}
	/**
	 * @param javafield the javafield to set
	 */
	public void setJavafield(String javafield) {
		this.javafield = javafield;
	}
	/**
	 * @return the sfcx
	 */
	public Integer getSfcx() {
		return sfcx;
	}
	/**
	 * @param sfcx the sfcx to set
	 */
	public void setSfcx(Integer sfcx) {
		this.sfcx = sfcx;
	}
	/**
	 * @return the sfdc
	 */
	public Integer getSfdc() {
		return sfdc;
	}
	/**
	 * @param sfdc the sfdc to set
	 */
	public void setSfdc(Integer sfdc) {
		this.sfdc = sfdc;
	}
	/**
	 * @return the tablename
	 */
	public String getTablename() {
		return tablename;
	}
	/**
	 * @param tablename the tablename to set
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * @return the isNull
	 */
	public Integer getIsNull() {
		return isNull;
	}

	/**
	 * @param isNull the isNull to set
	 */
	public void setIsNull(Integer isNull) {
		this.isNull = isNull;
	}

	/**
	 * @return the isDataType
	 */
	public Integer getIsDataType() {
		return isDataType;
	}

	/**
	 * @param isDataType the isDataType to set
	 */
	public void setIsDataType(Integer isDataType) {
		this.isDataType = isDataType;
	}

	/**
	 * @return the sfdr
	 */
	public Integer getSfdr() {
		return sfdr;
	}

	/**
	 * @param sfdr the sfdr to set
	 */
	public void setSfdr(Integer sfdr) {
		this.sfdr = sfdr;
	}

	/**
	 * @return the impModelColumn
	 */
	public Integer getImpModelColumn() {
		return impModelColumn;
	}

	/**
	 * @param impModelColumn the impModelColumn to set
	 */
	public void setImpModelColumn(Integer impModelColumn) {
		this.impModelColumn = impModelColumn;
	}

	/**
	 * @return the impErrorSign
	 */
	public String getImpErrorSign() {
		return impErrorSign;
	}

	/**
	 * @param impErrorSign the impErrorSign to set
	 */
	public void setImpErrorSign(String impErrorSign) {
		this.impErrorSign = impErrorSign;
	}

	/**
	 * @return the impErrorMsg
	 */
	public String getImpErrorMsg() {
		return impErrorMsg;
	}

	/**
	 * @param impErrorMsg the impErrorMsg to set
	 */
	public void setImpErrorMsg(String impErrorMsg) {
		this.impErrorMsg = impErrorMsg;
	}

	/**
	 * @return the impColumnContent
	 */
	public String getImpColumnContent() {
		return impColumnContent;
	}

	/**
	 * @param impColumnContent the impColumnContent to set
	 */
	public void setImpColumnContent(String impColumnContent) {
		this.impColumnContent = impColumnContent;
	}

	/**
	 * @return the impModelRow
	 */
	public Integer getImpModelRow() {
		return impModelRow;
	}

	/**
	 * @param impModelRow the impModelRow to set
	 */
	public void setImpModelRow(Integer impModelRow) {
		this.impModelRow = impModelRow;
	}

	/**
	 * @return the drmrz
	 */
	public String getDrmrz() {
		return drmrz;
	}

	/**
	 * @param drmrz the drmrz to set
	 */
	public void setDrmrz(String drmrz) {
		this.drmrz = drmrz;
	}

	/**
	 * @return the dataLength
	 */
	public Integer getDataLength() {
		return dataLength;
	}

	/**
	 * @param dataLength the dataLength to set
	 */
	public void setDataLength(Integer dataLength) {
		this.dataLength = dataLength;
	}
	
	
}
