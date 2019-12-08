/**
 * 彈出窗口
 * @param value 稅務ID
 * @return
 */
function showWin(value){
	Show("../pg/FINDSCPGNGMX.action?txtSWIDFind="+value, 330, 400, value);
}