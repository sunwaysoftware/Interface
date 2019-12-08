/**
 * 
 */
package com.sunway.action;

import java.io.StringReader;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.fop.svg.PDFTranscoder;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Andy.Kou
 *
 */
public class ChartExportAction extends ActionSupport {

	private static final long serialVersionUID = 581047784009510523L;
	private String type;
	private String svg;
	private String filename;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		TranscoderInput input = null;
		TranscoderOutput output = null;
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletOutputStream out = response.getOutputStream();
		filename = filename == null ? "chart" : filename;
		try {
			if (null != type && null != svg) {
				svg = svg.replaceAll(":rect", "rect");
				String ext = "";
				Transcoder t = null;
				if (type.equals("image/png")) {
					ext = "png";
					t = new PNGTranscoder();
				} else if (type.equals("image/jpeg")) {
					ext = "jpg";
					t = new JPEGTranscoder();
				} else if (type.equals("application/pdf")) {
					ext = "pdf";
					t = new PDFTranscoder();
				}
				response.addHeader("Content-Disposition", "attachment; filename=" + filename + "." + ext);
				response.addHeader("Content-Type", type);
				if (null != t) {
					input = new TranscoderInput(new StringReader(svg));
					output = new TranscoderOutput(out);
					try {
						t.transcode(input, output);
					} catch (TranscoderException e) {
						LOG.error(e.getMessage());
					}
				} else if (ext.equals("svg")) {
					out.print(svg);
				} else {
					out.print("Invalid type: " + type);
				}
			} else {
				response.addHeader("Content-Type", "text/html");
				out.println("Usage:\n\tParameter [svg]: The DOM Element to be converted.\n\tParameter [type]: The destination MIME type for the elment to be transcoded.");
			}			
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			out.flush();
			out.close();
		}
		return SUCCESS;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the svg
	 */
	public String getSvg() {
		return svg;
	}

	/**
	 * @param svg the svg to set
	 */
	public void setSvg(String svg) {
		this.svg = svg;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

}
