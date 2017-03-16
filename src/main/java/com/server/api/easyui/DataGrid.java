package com.server.api.easyui;

import java.util.ArrayList;
import java.util.List;

/**
 * EasyUI DataGrid模型
 * 
 * @author zkj
 * @date 2017年3月16日
 */
@SuppressWarnings({"all"})
public class DataGrid implements java.io.Serializable {

    private static final long serialVersionUID = 7032020005110503680L;
    
    private Boolean ifException = false; // 后台是否异常
    private String msg;
    private Integer total = 0; // 总数量
	private List rows = new ArrayList(); // 结果集
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows != null ? rows : new ArrayList();
	}
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Boolean getIfException() {
        return ifException;
    }
    public void setIfException(Boolean ifException) {
        this.ifException = ifException;
    }
}

