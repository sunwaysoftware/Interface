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
        logger.debug("不动产接口请求报文：\n{}" , info);

        long startTime = System.currentTimeMillis();    //获取开始时间
        BaseFunction bf = new BaseFunction();
        String strRtn = bf.combineXML(bf.parseFunction(bf.parseXML(info)));
        long endTime = System.currentTimeMillis();    //获取结束时间
        logger.info("不动产接口处理共耗时：{}ms", endTime-startTime);      //输出程序运行时

        logger.debug("不动产接口响应报文：\n{}", strRtn);
        return strRtn;
    }
}
