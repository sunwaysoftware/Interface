/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunway.action;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.chart.ChartData;
import com.sunway.service.ITj00002Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.TJ00002;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

/**
 *
 * @author Amani
 */
public class Tj00002Action extends ActionSupport implements SessionAware {

    private ITj00002Service tj00002Service;
    private SessionCtrl sessionCtrl = new SessionCtrl();
    private ArrayList<ChartData> data;
    private String txtRDSJMinFind;
    private String txtRDSJMaxFind;

    @Override
    public String execute() throws Exception {
        txtRDSJMinFind = Common.getNextMonthFirst();
        txtRDSJMaxFind = Common.getCurrentDate();
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionCtrl.appSession = map;
    }

    /**
     * 查询
     *
     * @return
     * @throws Exception
     */
    public String query() throws Exception {
        TJ00002 bean = new TJ00002();
        try {
            bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
            bean.setRdsj1(Common.convertToDate(txtRDSJMinFind));
            bean.setRdsj2(Common.convertToDate(txtRDSJMaxFind));
            bean = tj00002Service.Load(bean);
            if (null != bean) {
                data = new ArrayList<ChartData>();
                data.add(new ChartData("城建税", BigDecimal.valueOf(bean.getCjs())));
                data.add(new ChartData("个税", BigDecimal.valueOf(bean.getGs())));
                data.add(new ChartData("教育费附加", BigDecimal.valueOf(bean.getJyffj())));
                data.add(new ChartData("地方教育附加", BigDecimal.valueOf(bean.getJyfj())));
                data.add(new ChartData("契税", BigDecimal.valueOf(bean.getQs())));
                data.add(new ChartData("土地增值税", BigDecimal.valueOf(bean.getTdzzs())));
                data.add(new ChartData("印花税", BigDecimal.valueOf(bean.getYhs())));
                data.add(new ChartData("增值税", BigDecimal.valueOf(bean.getYys())));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return INPUT;
        } finally {

        }
        return SUCCESS;
    }
    @JSON(deserialize=false, serialize=false)
    public ITj00002Service getTj00002Service() {
        return tj00002Service;
    }

    public void setTj00002Service(ITj00002Service tj00002Service) {
        this.tj00002Service = tj00002Service;
    }

    public String getTxtRDSJMinFind() {
        return txtRDSJMinFind;
    }

    public void setTxtRDSJMinFind(String txtRDSJMinFind) {
        this.txtRDSJMinFind = txtRDSJMinFind;
    }

    public String getTxtRDSJMaxFind() {
        return txtRDSJMaxFind;
    }

    public void setTxtRDSJMaxFind(String txtRDSJMaxFind) {
        this.txtRDSJMaxFind = txtRDSJMaxFind;
    }

    public ArrayList<ChartData> getData() {
        return data;
    }

    public void setData(ArrayList<ChartData> data) {
        this.data = data;
    }

}
