/**
 * 
 */
package com.sunway.util;

import java.io.*;     

import java.awt.image.*;   
import java.awt.*;   
import java.applet.*;   
import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
/**
 * 
 * 将图片文件，进行等比或非等比的大小转换。
 * @author Andy.Gao
 *
 */
public class DwindlePic implements Serializable {
	private static Logger logger = LogManager.getLogger(DwindlePic.class.getName());
    private static final long serialVersionUID = -7718139289459473609L;
    private String InputFilePath; 		//输入图路径   
    private String OutputFilePath; 		//输出图路径   
    private int OutputWidth = 80; 		//默认输出图片宽   
    private int OutputHeight = 80; 		//默认输出图片高   
    private boolean proportion = true; 	//是否等比缩放标记(默认为等比缩放)   
    private boolean isFwq;
  
    public DwindlePic() {   
        //初始化变量   
    	InputFilePath = "";   
    	OutputFilePath = "";   
        OutputWidth = 80;   
        OutputHeight = 80;   
    }   
  
    /**
     * 生成缩略图类
     * @return
     */
    public boolean s_pic() {
    	
        File file = new File(InputFilePath);
        Image imgSrc = null;
        
        //如果文件不存在，则立即退出
        if (!file.exists()) {   
            return false;   
        }  
        try {
        	imgSrc = javax.imageio.ImageIO.read(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }   
        Image img = null;   
        Toolkit tk = Toolkit.getDefaultToolkit();   
        Applet app = new Applet();   
        MediaTracker mt = new MediaTracker(app);   
        try {   
            img = tk.getImage(InputFilePath);   
            mt.addImage(img, 0);   
            mt.waitForID(0);   
        } catch (Exception e) {   
            logger.error(e.getMessage());   
        }   
  
        if (img.getWidth(null) == -1) {     
            return false;   
        } else {   
            int new_w;   
            int new_h; 
            //判断是否是等比缩放
            if (this.proportion == true) {    
            	//为等比缩放计算输出的图片宽度及高度   
                double rate1 = ((double) img.getWidth(null)) / (double) OutputWidth + 0.1;   
                double rate2 = ((double) img.getHeight(null)) / (double) OutputHeight + 0.1;   
                double rate = rate1 > rate2 ? rate1 : rate2;   
                new_w = (int) (((double) img.getWidth(null)) / rate);   
                new_h = (int) (((double) img.getHeight(null)) / rate);   
            } else {   
                new_w = OutputWidth; //输出的图片宽度   
                new_h = OutputHeight; //输出的图片高度   
            }   
            BufferedImage buffImg = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
            try {
            	//繪制縮略圖
                buffImg.getGraphics().drawImage(imgSrc.getScaledInstance(new_w, new_h,  Image.SCALE_SMOOTH), 0, 0, null);
               /* if(isFwq=true){//是即为将缩略图上传远程服务器
                	SmbFileOutputStream out= new SmbFileOutputStream(OutputFilePath);
                	JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
                	encoder.encode(buffImg);  
                    out.close();   
                	}
                else{
                	FileOutputStream out = new FileOutputStream(OutputFilePath); //isFwq=false即为将缩略图上传本地服务器
                	JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
                	encoder.encode(buffImg);  
                    out.close();   
                }*/
                if(isFwq){
                    SmbFile sw = new SmbFile(OutputFilePath);
                    SmbFileOutputStream out = new SmbFileOutputStream(sw);  
//                    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
//                    encoder.encode(buffImg);  
//                    out.close();
                    String formatName = OutputFilePath.substring(OutputFilePath.lastIndexOf(".") + 1);
                    ImageIO.write(buffImg, formatName, out);  
                    out.close();
                }else{
                    FileOutputStream out = new FileOutputStream(OutputFilePath);  
//                    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
//                    encoder.encode(buffImg);  
                    String formatName = OutputFilePath.substring(OutputFilePath.lastIndexOf(".") + 1);
                    ImageIO.write(buffImg, formatName, out);                      
                    out.close();   
                }
            } catch (IOException ex) {   
                ex.printStackTrace();
            }   
        }   
        return true;   
    }   
  
    /**
     * 生成缩略图类
     * @param inputFilePath 大图片路径
     * @param outputFilePath 生成小图片路径
     * @return
     */
    /*public boolean s_pic(String inputFilePath, String outputFilePath,boolean isFWQ) {   
    	//输入图路径   
        this.InputFilePath = inputFilePath;   
        //输出图路径   
        this.OutputFilePath = outputFilePath;    
        this.isFwq=isFWQ;
        return s_pic();          

    }*/  
    public boolean s_pic(String inputFilePath, String outputFilePath, int outputWidth, int outputHeight,boolean isFWQ) {   
    	//输入图路径   
        this.InputFilePath = inputFilePath;   
        //输出图路径   
        this.OutputFilePath = outputFilePath;   
        this.OutputHeight = outputHeight;
        this.OutputWidth = outputWidth;
        this.isFwq=isFWQ;
        return s_pic();   
        
    } 
    
    public boolean s_pic(String inputFilePath, String outputFilePath,boolean isFWQ) {   
    	//输入图路径   
        this.InputFilePath = inputFilePath;   
        //输出图路径   
        this.OutputFilePath = outputFilePath;    
        this.isFwq=isFWQ;
        return s_pic();          

    } 
  
    /**
     * 生成缩略图类
     * @param inputFilePath 大图片路径
     * @param outputFilePath 生成小图片路径
     * @param width 生成小图片宽度
     * @param height 生成小图片高度
     * @param gp 是否等比缩放(默认为true)
     * @return
     */
    public boolean s_pic(String inputFilePath, String outputFilePath, int width, int height, boolean gp,boolean isFWQ) {   
    	//输入图路径   
        this.InputFilePath = inputFilePath;   
        //输出图路径   
        this.OutputFilePath = outputFilePath;  
        //设置图片长宽   
        this.OutputWidth = width;   
        this.OutputHeight = height;    
        //是否是等比缩放 标记   
        this.proportion = gp;   
        this.isFwq=isFWQ;
        return s_pic();   
    }
 
}
