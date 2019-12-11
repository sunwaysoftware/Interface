package com.sunway.webService;

import com.sunway.function.impl.BaseFunction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Process {
    private static Logger logger = LogManager.getLogger(Process.class);

    /**
     * 执行PgProcess方法
     *
     * @param info
     * @return
     */
    public String PgProcess(String info) {
        BaseFunction bf = new BaseFunction();
        logger.info("接口请求报文：" , info);
        return bf.combineXML(bf.parseFunction(bf.parseXML(info)));
    }
}
