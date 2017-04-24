package com.manager.product.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**  
* 类说明   
*  
* @author zkj  
* @date 2017年4月24日  新建  
*/
public class MRepairInfoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3714738937533542253L;

	private Long id;
	
	private String repairId;
	
	private String orderId;
	
	private String prodId;
	
	private String userId;
	
	private String userAddress;
	
	private String userPhone;
	
	private String userName;
	
	private Integer status;
	
	private Date createTime;
	
	private String whatProblem;
	
	private String dateStr;
	
	public String getDateStr() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateStr = sdf.format(this.createTime);
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRepairId() {
		return repairId;
	}

	public void setRepairId(String repairId) {
		this.repairId = repairId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getWhatProblem() {
		return whatProblem;
	}

	public void setWhatProblem(String whatProblem) {
		this.whatProblem = whatProblem;
	}

}
