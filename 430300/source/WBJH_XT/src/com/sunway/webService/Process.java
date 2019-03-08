package com.sunway.webService;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.log4j.Logger;
import com.sunway.function.impl.BaseFunction;

public class Process {
    static Logger logger = Logger.getLogger(Process.class);

    /**
     * 执行PgProcess方法
     *
     * @param info
     * @return
     */
    public String PgProcess(String info) {
        BaseFunction bf = new BaseFunction();
        logger.info("请求报文：" + info);
        return bf.combineXML(bf.parseFunction(bf.parseXML(info)));
    }
}
