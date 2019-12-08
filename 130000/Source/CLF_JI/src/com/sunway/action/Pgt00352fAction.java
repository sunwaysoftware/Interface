/**
 * 
 */
package com.sunway.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00001Service;
import com.sunway.service.IPgt00352fService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.DwindlePic;
import com.sunway.util.FileUpload;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00352f;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00352f;

import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

/**
 * 
 * 土地相关照片
 * 
 * @author Andy.Gao
 * 
 */
public class Pgt00352fAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 8436236294136311930L;
	private IPgt00352fService t00352fService;
	private IPgt00001Service t00001Service;
	private String ACT;
	private ArrayList<Pgv00352f> tabList;
	private ArrayList<Pgv00052> szqyList;
	private Pgt00352f t00352fBean;
	private String savePath;
//	private File txtFile;
	private String txtSWID;
	private String txtXQDM;
	private String txtXQDMHM;
	private String txtFileFileName;
	private String txtZPID;
	private String txtZPLX;
	private String txtNote;
	private String PATH;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String resMsg;
	private String txtXQDMDEL;
	private String txtXQDMHMDEL;
	private File txtRar;
	private String srcRootPath;
	private String txtXQDMR;
	private String txtXQDMHMR;
	private SmbFileInputStream PicStream;
	private String zpid;
	private String zplx;
	private FileOutputStream OutPicStream;
	private InputStream IPicStream;
	private Integer isSW;
	// 图片上传
	private ArrayList<Pgt00352f> photoList;
	private ArrayList<String> makedPhotoList;
	private ArrayList<Pgt00352f> photoCopyList;
	private Integer photoCount = 0;
	private HashMap<String, String> tempMap;
	private ArrayList<HashMap<String, String>> tempList;
	private Integer Tpbig;
	private String file_url;
	private BufferedInputStream butt;
	private String fileServerPath;
	private String ip;

	private String FROMA;
	private String SZQY;

	private File Filedata;
	private String Filename;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		try {

		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}

	/**
	 * 查询列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgt00352f t00352f = new Pgt00352f();
		t00352f.setCd00352Xqdm(txtXQDM);
		// SmbFile swUrl=new SmbFile(file_url);
		// t00352f.setCd00352Xqdm(txtXQDMHM); //2011-12-7修改，将小区编码改为代码号
		try {
			tabList = t00352fService.LoadAll(t00352f);
			if (tabList.size() > 0)
				PATH = tabList.get(0).getZplj();

			String url = "http://" + ip;
			for (int i = 0; i < tabList.size(); i++) {
				Pgv00352f e = tabList.get(i);
				// String fileServerPath =
				// ServletActionContext.getServletContext().getRealPath("upload\\xqPic");
				if (!Common.isNullOrEmpty(e.getZplj()))
					e.setZplj(url + Common.picPathUrl(e.getZplj()));
				if (!Common.isNullOrEmpty(e.getZpljMin()))
					e.setZpljMin(url + Common.picPathUrl(e.getZpljMin()));
				if (!Common.isNullOrEmpty(e.getZpLjdownLoad()))
					e.setZpLjdownLoad(url
							+ Common.picPathUrl(e.getZpLjdownLoad()));
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 查询列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryFC() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgt00352f t00352f = new Pgt00352f();
		t00352f.setCd00352Xqdm(txtXQDM);
		// t00352f.setCd00352Xqdm(txtXQDMHM); //2011-12-7修改，将小区编码改为代码号
		try {
			tabList = t00352fService.LoadAllFC(t00352f);

			if (tabList.size() > 0)
				PATH = tabList.get(0).getZplj();
			String url = "http://" + ip;
			for (int i = 0; i < tabList.size(); i++) {
				Pgv00352f e = tabList.get(i);
				// String fileServerPath =
				// ServletActionContext.getServletContext().getRealPath("upload\\xqPic");
				if (!Common.isNullOrEmpty(e.getZplj()))
					e.setZplj(url + Common.picPathUrl(e.getZplj()));
				if (!Common.isNullOrEmpty(e.getZpljMin()))
					e.setZpljMin(url + Common.picPathUrl(e.getZpljMin()));
				if (!Common.isNullOrEmpty(e.getZpLjdownLoad()))
					e.setZpLjdownLoad(url
							+ Common.picPathUrl(e.getZpLjdownLoad()));
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	public String queryById() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		SmbFile swUrl = null;
		// Pgt00352f t00352f = new Pgt00352f();
		// t00352f.setZpid(Common.convertToBigDecimal());
		try {
			// t00352fBean = t00352fService.LoadByPrimaryKey(t00352f);
			if (file_url != null) {
				swUrl = new SmbFile(file_url);
				isSW = 1;
				if (!swUrl.isDirectory()) {
					file_url = ServletActionContext.getServletContext()
							.getRealPath("");
					isSW = 0;
				}

			}
			if (isSW == 1) {

				if (Tpbig == 0)
					swUrl = new SmbFile(file_url + Common.convertEncoding(zpid));//
				else if (Tpbig == 1)
					swUrl = new SmbFile(file_url + Common.convertEncoding(zpid));
				else if (Tpbig == 2)
					swUrl = new SmbFile(file_url + Common.convertEncoding(zpid));

				butt = new BufferedInputStream(new SmbFileInputStream(swUrl));

			} else {
				FileInputStream file = null;
				if (Tpbig == 0)
					file = new FileInputStream(file_url
							+ Common.convertEncoding(zpid));//
				else if (Tpbig == 1)
					file = new FileInputStream(file_url
							+ Common.convertEncoding(zpid));
				else if (Tpbig == 2)
					file = new FileInputStream(file_url
							+ Common.convertEncoding(zpid));

				butt = new BufferedInputStream(file);

			}

		} catch (Exception e) {
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}

			if (Tpbig == 1) {
				return "inputMin";
			} else {
				return INPUT;
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	public String queryByIdFC() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		SmbFile swUrl = null;
		try {
			if (file_url != null) {
				swUrl = new SmbFile(file_url);
				isSW = 1;
				if (!swUrl.isDirectory()) {
					file_url = ServletActionContext.getServletContext()
							.getRealPath("");
					isSW = 0;
				}

			}
			if (isSW == 1) {

				if (Tpbig == 0)
					swUrl = new SmbFile(file_url + Common.convertEncoding(zpid));//
				else if (Tpbig == 1)
					swUrl = new SmbFile(file_url + Common.convertEncoding(zpid));
				else if (Tpbig == 2)
					swUrl = new SmbFile(file_url + Common.convertEncoding(zpid));

				butt = new BufferedInputStream(new SmbFileInputStream(swUrl));

			} else {
				FileInputStream file = null;
				if (Tpbig == 0)
					file = new FileInputStream(file_url	+ Common.convertEncoding(zpid));//
				else if (Tpbig == 1)
					file = new FileInputStream(file_url	+ Common.convertEncoding(zpid));
				else if (Tpbig == 2)
					file = new FileInputStream(file_url	+ Common.convertEncoding(zpid));

				butt = new BufferedInputStream(file);

			}

		} catch (Exception e) {
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}
			if (Tpbig == 1) {
				return "inputMin";
			} else {
				return INPUT;
			}

		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 验证文件上传
	 */
	public void validateCreate() {
		if (this.hasErrors()) {
			this.clearErrorsAndMessages();
			this.addActionError(getText("app.msg.error.fileupload"));
		}
		// 讀取"照片類型"
		try {

		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	public int Random() {
		Random random = new Random();
		int num = random.nextInt();
		return num;

	}

	/**
	 * 保存地產圖片信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********"
					+ Common.getCurrentTime());
		}

		DwindlePic mypic = new DwindlePic();
		String fileServerPath = null;
		String Radnumber = Integer.toString(Random());
		txtFileFileName = Radnumber + ".jpg";
		String shortFileName = "min" + txtFileFileName;
		String viewFileName = "view" + txtFileFileName;
		String swUrl = file_url;
		SmbFile swFile = new SmbFile(swUrl);
		SmbFile uploadFile = new SmbFile(swFile + "upload/");
		SmbFile xqPicFile = new SmbFile(swFile + "upload/xqPic/");
		SmbFile xqPicURLMax = null;
		try {
			fileServerPath = ServletActionContext.getServletContext().getRealPath(savePath + "/" + txtXQDM) + "/";
			if (file_url != null) {
				isSW = 1;
				if (!swFile.isDirectory()) {
					file_url = ServletActionContext.getServletContext().getRealPath("");
					isSW = 0;
				}
			}
			if (isSW == 1) {
				// 判断服务器是否有对应的共享文件如果没有就创建
				if (!uploadFile.exists()) {
					// 创建远程文件夹
					uploadFile.mkdir();
					if (!xqPicFile.exists()) {

						xqPicFile.mkdir();
					}
				}
				SmbFile RadFile = new SmbFile(xqPicFile + txtXQDM);
				// SmbFile RadFile = new SmbFile(xqPicFile + txtXQDMHM);
				// //2011-12-7修改，将小区编码改为代码号
				if (!RadFile.exists()) {
					RadFile.mkdir();
				}
				xqPicURLMax = new SmbFile(RadFile + "/" + txtFileFileName);
				// 上传共享文件
				FileInputStream inpic = new FileInputStream(Filedata);
				SmbFileOutputStream in = new SmbFileOutputStream(xqPicURLMax);
				byte[] b = new byte[1024 * 8];
				int len = 0;
				while ((len = inpic.read(b)) != -1) {
					in.write(b, 0, len);
				}
				in.flush();
				in.close();
				inpic.close();
				// 生成縮略圖
				/*
				 * if(!mypic.s_pic(txtFile.toString(),
				 * RadFile+"/"+shortFileName,false)){ throw new
				 * Exception(getText("app.msg.error.filezoomout")); }
				 */
				if (!mypic.s_pic(Filedata.getPath(), RadFile + "/" + shortFileName, true)) {
					throw new Exception(getText("app.msg.error.filezoomout"));
				}

				// 生成显示圖
				/*
				 * if(!mypic.s_pic(txtFile.toString(), RadFile+"/"+viewFileName,
				 * 550, 550,true)){ throw new
				 * Exception(getText("app.msg.error.filezoomout"
				 * )+"请检查格式是否为.jpg，或者.png"); }
				 */
				if (!mypic.s_pic(Filedata.getPath(), RadFile + "/" + viewFileName, 550, 550, true)) {
					throw new Exception(getText("app.msg.error.filezoomout") + "请检查格式是否为.jpg，或者.png");
				}
			} else {
				// 上传到本地文件夹
				FileUpload fileUpload = new FileUpload();
				File file = new File(getSavePath());

				if (!file.exists())
					file.mkdir();
				// 文件上傳處理
				fileUpload.setFile(Filedata);
				fileUpload.setFileName(txtFileFileName);
				fileUpload.setFileServerPath(fileServerPath);

				if (!fileUpload.upload()) {
					throw new Exception(getText("app.msg.error.fileupload"));
				}
				// 生成縮略圖
				/*
				 * if(!mypic.s_pic(fileServerPath+txtFileFileName,
				 * fileServerPath + shortFileName,false)){ throw new
				 * Exception(getText
				 * ("app.msg.error.filezoomout")+"请检查格式是否为.jpg或者.png"); }
				 */
				if (!mypic.s_pic(fileServerPath + txtFileFileName, fileServerPath + shortFileName, false)) {
					throw new Exception(getText("app.msg.error.filezoomout")+ "请检查格式是否为.jpg或者.png");
				}

				// 生成显示圖
				/*
				 * if(!mypic.s_pic(fileServerPath+txtFileFileName,
				 * fileServerPath + viewFileName, 550, 550,false)){ throw new
				 * Exception
				 * (getText("app.msg.error.filezoomout")+"请检查格式是否为.jpg或者.png");
				 * }
				 */
				if (!mypic.s_pic(fileServerPath + txtFileFileName, fileServerPath + viewFileName, 550, 550, false)) {
					throw new Exception(getText("app.msg.error.filezoomout") + "请检查格式是否为.jpg或者.png");
				}
			}

			// 文件信息入庫
			Pgt00352f t00352f = new Pgt00352f();
			t00352f.setCd00352Xqdm(txtXQDM);
			// t00352f.setCd00352Xqdm(txtXQDMHM); //2011-12-7修改，将小区编码改为代码号
			t00352f.setZplx(Common.convertToInteger(txtZPLX));
			t00352f.setZplj("/upload/xqPic/" + txtXQDM + "/" + viewFileName);
			t00352f.setZpljMin("/upload/xqPic/" + txtXQDM + "/" + shortFileName);
			// t00352f.setZplj("/upload/xqPic/" + txtXQDMHM + "/" +
			// viewFileName); //2011-12-7修改，将小区编码改为代码号
			// t00352f.setZpljMin("/upload/xqPic/" + txtXQDMHM + "/" +
			// shortFileName); //2011-12-7修改，将小区编码改为代码号
			t00352f.setNote(txtNote);
			t00352f.setCd00002Czr(sessionCtrl.getUserId());
			t00352f.setZpLjdownLoad("/upload/xqPic/" + txtXQDM + "/"
					+ txtFileFileName);
			// t00352f.setZpLjdownLoad("/upload/xqPic/" + txtXQDMHM + "/" +
			// txtFileFileName); //2011-12-7修改，将小区编码改为代码号
			if (t00352fService.GetInsertCommand(t00352f))
				this.addActionMessage(getText(Constant.MSG_CREATE_OK,
						new String[] { t00352f.getCd00352Xqdm().toString() }));
			else
				this.addActionError(getText(Constant.MSG_CREATE_NG,
						new String[] { t00352f.getCd00352Xqdm().toString() }));
		} catch (Exception ex) {
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********"
					+ Common.getCurrentTime());
		}
		return SUCCESS;

	}

	/**
	 * 验证文件上传
	 */
	public void validateUpdate() {
		this.clearErrorsAndMessages();
		Pgt00352f t00352f = new Pgt00352f();
		try {
			t00352f.setZpid(txtZPID);
			t00352fBean = t00352f;

		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
		}
	}

	/**
	 * 刪除地產圖片信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			Pgt00352f t00352f = t00352fService.LoadByPrimaryKey(t00352fBean);
			ArrayList<String> delList = new ArrayList<String>();
			String fileServerPath = ServletActionContext.getServletContext()
					.getRealPath("upload/xqPic").replace("\\", "/");
			String path = fileServerPath.substring(0,
					fileServerPath.indexOf("upload/xqPic"));
			if (t00352fService.GetDeleteCommand(t00352fBean)) {
				String swUrl = file_url;
				if (null != file_url && !"".equals(file_url)) {
					isSW = 1;
				}
				if (isSW == 1) {
					SmbFile temp1 = new SmbFile(swUrl
							+ t00352f.getZpLjdownLoad());
					temp1.delete();
					SmbFile temp2 = new SmbFile(swUrl + t00352f.getZplj());
					temp2.delete();
					SmbFile temp3 = new SmbFile(swUrl + t00352f.getZpljMin());
					temp3.delete();
				} else {
					delList.add(path + t00352f.getZpLjdownLoad());
					delList.add(path + t00352f.getZplj());
					delList.add(path + t00352f.getZpljMin());
					Common.removeUploadFiles(delList);
				}
				this.addActionMessage(getText(Constant.MSG_DELETE_OK,
						new String[] { t00352fBean.getZpid().toString() }));
			} else {
				this.addActionError(getText(Constant.MSG_DELETE_NG,
						new String[] { t00352fBean.getZpid().toString() }));
			}
		} catch (Exception e) {
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 根据小区代码，删除该小区内所有图片
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delPhotoByXQ() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("delPhotoByXQ() ********** start **********");
		}
		try {
			setTxtXQDM(txtXQDMDEL);
			setTxtXQDMHM(txtXQDMHMDEL);
			String fileServerPath = ServletActionContext.getServletContext()
					.getRealPath("upload//xqPic");
			Pgt00352f t00352f = new Pgt00352f();
			t00352f.setCd00352Xqdm(txtXQDMDEL);
			// t00352f.setCd00352Xqdm(txtXQDMHMDEL); //2011-12-7修改，将小区编码改为代码号
			if (t00352fService.GetDeleteByXQCommand(t00352f)) {
				String swUrl = file_url;
				if (null != file_url && !"".equals(file_url)) {
					isSW = 1;
				}
				if (isSW == 1) {
					SmbFile temp = new SmbFile(swUrl + "upload/xqPic/"
							+ txtXQDMDEL + "/");
					// SmbFile temp = new
					// SmbFile(swUrl+"upload/xqPic/"+txtXQDMHMDEL+"/");
					// //2011-12-7修改，将小区编码改为代码号
					temp.delete();
				} else {
					FileUtils.deleteDirectory(new File(fileServerPath + "/"
							+ txtXQDMDEL));
					// FileUtils.deleteDirectory(new
					// File(fileServerPath+"/"+txtXQDMHMDEL));
					// //2011-12-7修改，将小区编码改为代码号
				}

				this.addActionMessage("删除成功");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError("删除出现异常");
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("delPhotoByXQ() ********** end **********");
		}
		return SUCCESS;
	}

	// 图片上传
	public String photoUpload() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("photoUpload() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try {
			// sessionCtrl = new
			// SessionCtrl(ActionContext.getContext().getSession());
			ReadInfo();
			// 获取图片保存路径
			photoList = new ArrayList<Pgt00352f>();
			tempMap = new HashMap<String, String>();
			tempList = new ArrayList<HashMap<String, String>>();
			if (ListFilesInDirectory(srcRootPath)) {
				// 生成缩略图和显示图
				photoCopyList = new ArrayList<Pgt00352f>();
				if (makeupPhotos()) {
					// 复制源文件夹至目标文件夹
					if (copyFolder(srcRootPath, fileServerPath, makedPhotoList,
							photoCopyList, tempList)) {
						this.addActionMessage("图片上传成功");
					} else {
						this.addActionError("部分图片上传失败，请检查小区名称及图片格式是否正确");
					}
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError("操作失败，请确认文件位置是否放置正确以及文件格式为.JPG格式或者.PNG格式");
			// 删除生成的缩略图和显示图
			if (null != makedPhotoList && makedPhotoList.size() > 0) {
				Common.removeUploadFiles(makedPhotoList);
			}
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("photoUpload() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 上传RAR
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updPhotoByRar() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("updPhotoByRar() ********** start **********");
		}
		try {

			setTxtXQDM(txtXQDMR);
			setTxtXQDMHM(txtXQDMHMR);
			File rootFile = new File(srcRootPath);
			if (!rootFile.exists()) {
				rootFile.mkdir();
			}

			// 删除已存在文件夹
			FileUtils.deleteDirectory(new File(srcRootPath + "/" + txtXQDMR));
			File decFile = new File(srcRootPath + "/" + txtXQDMR);
			// FileUtils.deleteDirectory(new File(srcRootPath + "/" +
			// txtXQDMHMR)); //2011-12-7修改，将小区编码改为代码号
			// File decFile = new File(srcRootPath + "/" + txtXQDMHMR);
			// //2011-12-7修改，将小区编码改为代码号
			if (!decFile.exists()) {
				decFile.mkdir();
			}
			if (Common.unRar(getTxtRar().getPath(), srcRootPath + "/"
					+ txtXQDMR)) {
				photoUpload();
				this.addActionMessage("该小区图片上传成功");
			}
			/*
			 * if(Common.unRar(getTxtRar().getPath(), srcRootPath + "/" +
			 * txtXQDMHMR)){ //2011-12-7修改，将小区编码改为代码号 photoUpload();
			 * this.addActionMessage("该小区图片上传成功"); }
			 */

			// 删除已存在文件夹
			FileUtils.deleteDirectory(new File(srcRootPath + "/" + txtXQDMR));
			// FileUtils.deleteDirectory(new File(srcRootPath + "/" +
			// txtXQDMHMR)); //2011-12-7修改，将小区编码改为代码号
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			// 删除生成的缩略图和显示图
			if (null != makedPhotoList && makedPhotoList.size() > 0) {
				Common.removeUploadFiles(makedPhotoList);
			}
			if (LOG.isDebugEnabled()) {
				LOG.debug("updPhotoByRar() ********** end **********");
			}
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("updPhotoByRar() ********** end **********");
		}
		return SUCCESS;
	}

	// 获取图片路径
	protected Boolean ListFilesInDirectory(String rootPath) throws Exception {
		File file = new File(rootPath);
		File[] files = file.listFiles();
		for (File fl : files) {
			if (fl.isDirectory()) {
				ListFilesInDirectory(fl.toString());
			} else {
				if (fl.getName().toLowerCase().endsWith(".jpg")
						|| fl.getName().toLowerCase().endsWith(".png")) {
					packupPhotoPath(fl.getName(),
							fl.getPath().replace("\\", "/"));
				}
				photoCount++;
			}
		}
		return true;
	}

	// 拼接图片路径
	protected void packupPhotoPath(String fileName, String filePath)
			throws Exception {
		Pgt00352f t00352f = new Pgt00352f();
		String MapFileNamePath = filePath.substring(srcRootPath.length() + 1,
				filePath.length());
		t00352f.setIsFilePath(filePath);
		String xqnm = MapFileNamePath
				.substring(0, MapFileNamePath.indexOf("/"));
		String xqdm = getXQDMByXQNM(xqnm);
		// String xqdm = xqnm.toUpperCase();
		MapFileNamePath = xqdm
				+ MapFileNamePath.substring(MapFileNamePath.indexOf("/"),
						MapFileNamePath.length());
		// 获取小区名
		fileServerPath = ServletActionContext.getServletContext()
				.getRealPath("upload\\xqPic\\").replace("\\", "/");
		t00352f.setFileSavePath(fileServerPath + "/" + MapFileNamePath);
		t00352f.setSrcPhotoPath(filePath.substring(0,
				filePath.indexOf(fileName)));
		t00352f.setSrcPhotoName(fileName);
		t00352f.setCd00352Xqdm(xqdm);
		photoList.add(t00352f);
	}

	// 生成缩略图以及显示图
	protected Boolean makeupPhotos() throws Exception {
		DwindlePic mypic = new DwindlePic();
		makedPhotoList = new ArrayList<String>();
		for (int i = 0; i < photoList.size(); i++) {
			Pgt00352f t00352f = photoList.get(i);

			if ("N".equals(t00352f.getCd00352Xqdm())) {
				continue; // 若不存在或者小区名称错误，则跳过
			}
			t00352f.setShortFileName("min" + t00352f.getSrcPhotoName());
			t00352f.setViewFileName("view" + t00352f.getSrcPhotoName());
			// 源文件生成
			if (!mypic.s_pic(
					t00352f.getSrcPhotoPath() + t00352f.getSrcPhotoName(),
					t00352f.getSrcPhotoPath() + t00352f.getSrcPhotoName(),
					1024, 768, false)) {
				throw new Exception(getText("app.msg.error.filezoomout"));
			}
			// 生成缩略图
			if (!mypic.s_pic(
					t00352f.getSrcPhotoPath() + t00352f.getSrcPhotoName(),
					t00352f.getSrcPhotoPath() + t00352f.getShortFileName(), 80,
					80, false)) {
				throw new Exception(getText("app.msg.error.filezoomout"));
			}
			t00352f.setShortFilePath(t00352f.getFileSavePath().substring(0,
					t00352f.getFileSavePath().lastIndexOf("/"))
					+ "/" + t00352f.getShortFileName());
			t00352f.setSrcShortFilePath(t00352f.getIsFilePath().substring(0,
					t00352f.getIsFilePath().lastIndexOf("/"))
					+ "/" + t00352f.getShortFileName());
			makedPhotoList.add(t00352f.getSrcPhotoPath()
					+ t00352f.getShortFileName()); // 如果缩略图创建成功，则保存至已上传列表中，方便出错时删除
			// 生成显示图
			if (!mypic.s_pic(
					t00352f.getSrcPhotoPath() + t00352f.getSrcPhotoName(),
					t00352f.getSrcPhotoPath() + t00352f.getViewFileName(), 550,
					550, false)) {
				throw new Exception(getText("app.msg.error.filezoomout"));
			}
			t00352f.setViewFilePath(t00352f.getFileSavePath().substring(0,
					t00352f.getFileSavePath().lastIndexOf("/"))
					+ "/" + t00352f.getViewFileName());
			t00352f.setSrcViewFilePath(t00352f.getIsFilePath().substring(0,
					t00352f.getIsFilePath().lastIndexOf("/"))
					+ "/" + t00352f.getViewFileName());
			makedPhotoList.add(t00352f.getSrcPhotoPath()
					+ t00352f.getViewFileName()); // 如果显示图创建成功，则保存至已上传列表中，方便出错时删除
			t00352f.setSrcFilePath(t00352f.getIsFilePath());
			photoCopyList.add(t00352f); // 装载COPY图片列表
		}
		return true;
	}

	/**
	 * 复制整个文件夹内容
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/old
	 * @param newPath
	 *            String 复制后路径 如：f:/new
	 * @return boolean
	 **/
	protected Boolean copyFolder(String oldPath, String newPath,
			ArrayList<String> makedPhotoList,
			ArrayList<Pgt00352f> photoCopyList,
			ArrayList<HashMap<String, String>> tempList) throws Exception {
		try {
			String swUrl = file_url;
			SmbFile xqPicURLMax = null;
			SmbFile RadFile = null;
			if (null != file_url && !"".equals(file_url)) {
				isSW = 1;
			}
			if (isSW == 1) {
				// 判断服务器是否有对应的共享文件如果没有就创建
				RadFile = new SmbFile(swUrl + getSDPath(newPath));
				if (!RadFile.exists()) {

					RadFile.mkdir();
				}
			} else {
				(new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			}
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					if (temp.getName().toLowerCase().endsWith(".jpg")
							|| temp.getName().toLowerCase().endsWith(".png")) {
						Pgt00352f t00352f = isExistFilePath(temp.getPath()
								.replace("\\", "/"), photoCopyList);
						if (null != t00352f) {
							if (temp.getName().toLowerCase().indexOf(".jpg") != -1) {
								if (temp.getName().getBytes().length == temp
										.getName().length()) {
									t00352f.setNote(temp.getParentFile()
											.getName());
								} else {
									t00352f.setNote(temp.getName().substring(
											0,
											temp.getName().toLowerCase()
													.indexOf(".jpg"))); // 如果文件名为中文则作为备注
								}
							} else if (temp.getName().toLowerCase()
									.indexOf(".png") != -1) {
								if (temp.getName().getBytes().length == temp
										.getName().length()) {
									t00352f.setNote(temp.getParentFile()
											.getName());
								} else {
									t00352f.setNote(temp.getName().substring(
											0,
											temp.getName().toLowerCase()
													.indexOf(".png"))); // 如果文件名为中文则作为备注
								}

							}

							t00352f.setZplx(0);
							t00352f.setCd00002Czr(sessionCtrl.getUserId());
							String path = t00352f.getFileSavePath();
							Integer strNum = path.indexOf("/upload/xqPic/");
							Integer endNum = path.lastIndexOf("/");
							String pathD = path.substring(strNum, endNum);
							System.out.println(pathD);
							t00352f.setZplj(pathD + "/"
									+ t00352f.getViewFileName());
							t00352f.setZpljMin(pathD + "/"
									+ t00352f.getShortFileName());
							t00352f.setZpLjdownLoad(pathD + "/"
									+ t00352f.getSrcPhotoName());

							if (!temp.getName().startsWith("view")
									&& !temp.getName().startsWith("min")) {
								if (t00352fService.GetInsertCommand(t00352f)) {
									if (isSW == 1) {
										makedPhotoList.add(swUrl
												+ t00352f.getZpLjdownLoad());
										xqPicURLMax = new SmbFile(swUrl
												+ t00352f.getZpLjdownLoad());

										// 上传共享文件
										SmbFileOutputStream in = new SmbFileOutputStream(
												xqPicURLMax);
										byte[] b = new byte[1024 * 8];
										int len = 0;
										while ((len = input.read(b)) != -1) {
											in.write(b, 0, len);
										}
										in.flush();
										in.close();
										input.close();
										temp.delete();
									} else {
										makedPhotoList.add(t00352f
												.getFileSavePath());
										FileOutputStream output = new FileOutputStream(
												t00352f.getFileSavePath());
										byte[] b = new byte[1024 * 5];
										int len;
										while ((len = input.read(b)) != -1) {
											output.write(b, 0, len);
										}
										output.flush();
										output.close();
										input.close();
										temp.delete();
									}
								}

							} else if (temp.getName().startsWith("view")) {

								if (isSW == 1) {
									makedPhotoList.add(swUrl
											+ t00352f.getZplj());
									xqPicURLMax = new SmbFile(swUrl
											+ t00352f.getZplj());

									// 上传共享文件
									SmbFileOutputStream in = new SmbFileOutputStream(
											xqPicURLMax);
									byte[] b = new byte[1024 * 8];
									int len = 0;
									while ((len = input.read(b)) != -1) {
										in.write(b, 0, len);
									}
									in.flush();
									in.close();
									input.close();
									temp.delete();
								} else {
									makedPhotoList.add(t00352f
											.getViewFilePath());
									FileOutputStream output = new FileOutputStream(
											t00352f.getViewFilePath());
									byte[] b = new byte[1024 * 5];
									int len;
									while ((len = input.read(b)) != -1) {
										output.write(b, 0, len);
									}
									output.flush();
									output.close();
									input.close();
									temp.delete();
								}
							} else if (temp.getName().startsWith("min")) {

								if (isSW == 1) {
									makedPhotoList.add(swUrl
											+ t00352f.getZpljMin());
									xqPicURLMax = new SmbFile(swUrl
											+ t00352f.getZpljMin());

									// 上传共享文件
									SmbFileOutputStream in = new SmbFileOutputStream(
											xqPicURLMax);
									byte[] b = new byte[1024 * 8];
									int len = 0;
									while ((len = input.read(b)) != -1) {
										in.write(b, 0, len);
									}
									in.flush();
									in.close();
									input.close();
									temp.delete();
								} else {
									makedPhotoList.add(t00352f
											.getShortFilePath());
									FileOutputStream output = new FileOutputStream(
											t00352f.getShortFilePath());
									byte[] b = new byte[1024 * 5];
									int len;
									while ((len = input.read(b)) != -1) {
										output.write(b, 0, len);
									}
									output.flush();
									output.close();
									input.close();
									temp.delete();
								}
							}
						}
					}
				}
				if (temp.isDirectory()) {// 如果是子文件夹

					makedPhotoList.add(newPath + "/" + file[i]);
					String folderName = getXQDMByXQNMForFolder(file[i],
							tempList);
					copyFolder(oldPath + "/" + file[i], newPath + "/"
							+ folderName, makedPhotoList, photoCopyList,
							tempList);
				}

			}
		} catch (Exception e) {
			System.out.println("复制整个文件夹内容操作出错");
			LOG.error(e.getMessage());
			throw e;
		}
		return true;
	}

	/**
	 * 上传时取得文件夹名称
	 * 
	 * @param xqnm
	 * @param tempList
	 * @return
	 * @throws Exception
	 */
	protected String getXQDMByXQNMForFolder(String xqnm,
			ArrayList<HashMap<String, String>> tempList) throws Exception {
		for (int i = 0; i < tempList.size(); i++) {
			HashMap<String, String> temp = tempList.get(i);
			String value = temp.get(xqnm);
			if (null != value && !"".equals(value)) {
				return value;
			}
		}
		return xqnm;
	}

	/**
	 * 判断遍历文件是否存在于上传列表
	 * 
	 * @param path
	 * @param photoCopyList
	 * @return
	 * @throws Exception
	 */
	protected Pgt00352f isExistFilePath(String path,
			ArrayList<Pgt00352f> photoCopyList) throws Exception {
		for (int i = 0; i < photoCopyList.size(); i++) {
			Pgt00352f t00352f = photoCopyList.get(i);
			if (!path.equals(t00352f.getSrcFilePath())) {
				if (!path.equals(t00352f.getSrcShortFilePath())) {
					if (!path.equals(t00352f.getSrcViewFilePath())) {
						continue;
					} else {
						return t00352f;
					}
				} else {
					return t00352f;
				}
			} else {
				return t00352f;
			}
		}
		return null;
	}

	/**
	 * 获取相对路径
	 * 
	 * @param path
	 * @return
	 */
	protected String getSDPath(String path) {
		Integer strNum = path.indexOf("/upload/xqPic/");
		if (strNum == -1)
			return "";
		return path.substring(strNum, path.length());
	}

	/**
	 * 根据小区名称获取小区编码
	 * 
	 * @param xqnm
	 * @return
	 * @throws Exception
	 */
	protected String getXQDMByXQNM(String xqnm) throws Exception {
		if (!Common.isNullOrEmpty(txtXQDMR)) {
			tempMap.put(xqnm, txtXQDMR);
			tempList.add(tempMap);
			return txtXQDMR;
		}
		// if (!Common.isNullOrEmpty(txtXQDMHMR)) { //2011-12-7修改 小区编码改为代码号
		// tempMap.put(xqnm, txtXQDMHMR);
		// tempList.add(tempMap);
		// return txtXQDMHMR;
		// }
		for (int i = 0; i < tempList.size(); i++) {
			HashMap<String, String> temp = tempList.get(i);
			String value = temp.get(xqnm);
			if (null != value && !"".equals(value)) {
				return value;
			}
		}
		String xqdm = t00001Service.GetXQDMByXQNM(xqnm,
				sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		tempMap.put(xqnm, xqdm);
		tempList.add(tempMap);
		return xqdm;
	}

	/**
	 * 取得下拉菜单信息
	 * 
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		// sessionCtrl = new
		// SessionCtrl(ActionContext.getContext().getSession());
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}

	/*********************** set and get ******************************/

	/**
	 * @param savePath
	 *            the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	/**
	 * @return the savePath
	 */
	public String getSavePath() {
		return savePath;
	}

	/**
	 * @return the txtFileFileName
	 */
	public String getTxtFileFileName() {
		return txtFileFileName;
	}

	/**
	 * @param txtFileFileName
	 *            the txtFileFileName to set
	 */
	public void setTxtFileFileName(String txtFileFileName) {
		this.txtFileFileName = txtFileFileName;
	}

	/**
	 * @param t00352fService
	 *            the t00352fService to set
	 */
	public void setT00352fService(IPgt00352fService t00352fService) {
		this.t00352fService = t00352fService;
	}

	/**
	 * @return the t00352fService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00352fService getT00352fService() {
		return t00352fService;
	}

	/**
	 * @param tabList
	 *            the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00352f> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv00352f> getTabList() {
		return tabList;
	}

	/**
	 * @param txtZPID
	 *            the txtZPID to set
	 */
	public void setTxtZPID(String txtZPID) {
		this.txtZPID = txtZPID;
	}

	/**
	 * @return the txtZPID
	 */
	public String getTxtZPID() {
		return txtZPID;
	}

	/**
	 * @param t00352fBean
	 *            the t00352fBean to set
	 */
	public void setT00352fBean(Pgt00352f t00352fBean) {
		this.t00352fBean = t00352fBean;
	}

	/**
	 * @return the t00352fBean
	 */
	public Pgt00352f getT00352fBean() {
		return t00352fBean;
	}

	/**
	 * @param txtZPLX
	 *            the txtZPLX to set
	 */
	public void setTxtZPLX(String txtZPLX) {
		this.txtZPLX = txtZPLX;
	}

	/**
	 * @return the txtZPLX
	 */
	public String getTxtZPLX() {
		return txtZPLX;
	}

	/**
	 * @param txtNote
	 *            the txtNote to set
	 */
	public void setTxtNote(String txtNote) {
		this.txtNote = txtNote;
	}

	/**
	 * @return the txtNote
	 */
	public String getTxtNote() {
		return txtNote;
	}

	/**
	 * @param aCT
	 *            the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * @param txtSWID
	 *            the txtSWID to set
	 */
	public void setTxtSWID(String txtSWID) {
		this.txtSWID = txtSWID;
	}

	/**
	 * @return the txtSWID
	 */
	public String getTxtSWID() {
		return txtSWID;
	}

	/**
	 * @param pATH
	 *            the pATH to set
	 */
	public void setPATH(String pATH) {
		PATH = pATH;
	}

	/**
	 * @return the pATH
	 */
	public String getPATH() {
		return PATH;
	}

	public String getTxtXQDM() {
		return txtXQDM;
	}

	public void setTxtXQDM(String txtXQDM) {
		this.txtXQDM = txtXQDM;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public String getTxtXQDMDEL() {
		return txtXQDMDEL;
	}

	public void setTxtXQDMDEL(String txtXQDMDEL) {
		this.txtXQDMDEL = txtXQDMDEL;
	}

	public File getTxtRar() {
		return txtRar;
	}

	public void setTxtRar(File txtRar) {
		this.txtRar = txtRar;
	}

	public String getSrcRootPath() {
		return srcRootPath;
	}

	public void setSrcRootPath(String srcRootPath) {
		this.srcRootPath = srcRootPath;
	}

	public String getTxtXQDMR() {
		return txtXQDMR;
	}

	public void setTxtXQDMR(String txtXQDMR) {
		this.txtXQDMR = txtXQDMR;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	public String getFile_url() {
		return file_url;
	}

	public SmbFileInputStream getPicStream() {
		return PicStream;
	}

	public void setPicStream(SmbFileInputStream picStream) {
		PicStream = picStream;
	}

	public String getZpid() {
		return zpid;
	}

	public void setZpid(String zpid) {
		this.zpid = zpid;
	}

	public FileOutputStream getOutPicStream() {
		return OutPicStream;
	}

	public void setOutPicStream(FileOutputStream outPicStream) {
		OutPicStream = outPicStream;
	}

	public InputStream getIPicStream() {
		return IPicStream;
	}

	public void setIPicStream(InputStream iPicStream) {
		IPicStream = iPicStream;
	}

	public Integer getIsSW() {
		return isSW;
	}

	public void setIsSW(Integer isSW) {
		this.isSW = isSW;
	}

	public Integer getTpbig() {
		return Tpbig;
	}

	public void setTpbig(Integer tpbig) {
		Tpbig = tpbig;
	}

	public BufferedInputStream getButt() {
		return butt;
	}

	public void setButt(BufferedInputStream butt) {
		this.butt = butt;
	}

	public ArrayList<Pgt00352f> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(ArrayList<Pgt00352f> photoList) {
		this.photoList = photoList;
	}

	public ArrayList<String> getMakedPhotoList() {
		return makedPhotoList;
	}

	public void setMakedPhotoList(ArrayList<String> makedPhotoList) {
		this.makedPhotoList = makedPhotoList;
	}

	public ArrayList<Pgt00352f> getPhotoCopyList() {
		return photoCopyList;
	}

	public void setPhotoCopyList(ArrayList<Pgt00352f> photoCopyList) {
		this.photoCopyList = photoCopyList;
	}

	public Integer getPhotoCount() {
		return photoCount;
	}

	public void setPhotoCount(Integer photoCount) {
		this.photoCount = photoCount;
	}

	public HashMap<String, String> getTempMap() {
		return tempMap;
	}

	public void setTempMap(HashMap<String, String> tempMap) {
		this.tempMap = tempMap;
	}

	public ArrayList<HashMap<String, String>> getTempList() {
		return tempList;
	}

	public void setTempList(ArrayList<HashMap<String, String>> tempList) {
		this.tempList = tempList;
	}

	public String getFileServerPath() {
		return fileServerPath;
	}

	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
	}

	@JSON(deserialize = false, serialize = false)
	public IPgt00001Service getT00001Service() {
		return t00001Service;
	}

	public void setT00001Service(IPgt00001Service t00001Service) {
		this.t00001Service = t00001Service;
	}

	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	public String getZplx() {
		return zplx;
	}

	public void setZplx(String zplx) {
		this.zplx = zplx;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getFROMA() {
		return FROMA;
	}

	public void setFROMA(String fROMA) {
		FROMA = fROMA;
	}

	public String getSZQY() {
		return SZQY;
	}

	public void setSZQY(String sZQY) {
		SZQY = sZQY;
	}

	public String getTxtXQDMHM() {
		return txtXQDMHM;
	}

	public void setTxtXQDMHM(String txtXQDMHM) {
		this.txtXQDMHM = txtXQDMHM;
	}

	public String getTxtXQDMHMDEL() {
		return txtXQDMHMDEL;
	}

	public void setTxtXQDMHMDEL(String txtXQDMHMDEL) {
		this.txtXQDMHMDEL = txtXQDMHMDEL;
	}

	public String getTxtXQDMHMR() {
		return txtXQDMHMR;
	}

	public void setTxtXQDMHMR(String txtXQDMHMR) {
		this.txtXQDMHMR = txtXQDMHMR;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

	/**
	 * @return the filedata
	 */
	public File getFiledata() {
		return Filedata;
	}

	/**
	 * @param filedata
	 *            the filedata to set
	 */
	public void setFiledata(File filedata) {
		Filedata = filedata;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return Filename;
	}

	/**
	 * @param filename
	 *            the filename to set
	 */
	public void setFilename(String filename) {
		Filename = filename;
	}

}
