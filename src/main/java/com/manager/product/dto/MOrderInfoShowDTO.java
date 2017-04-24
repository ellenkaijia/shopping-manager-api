package com.manager.product.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**  
* 类说明   
*  
* @author zkj  
* @date 2017年4月23日  新建  
*/
public class MOrderInfoShowDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4944376938992975024L;

	private Long id;
	
	private String userId;
	
	private String prodId;
	
	private String orderId;
	
	private String prodName;
	
	private String codeId;
	
	private Integer status;
	
	private Integer buyCount;
	
	private BigDecimal moneySum;
	
	private String userName;
	
	private String userAddress;
	
	private String userPhone;
	
	private Date createTime;
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}

	public BigDecimal getMoneySum() {
		return moneySum;
	}

	public void setMoneySum(BigDecimal moneySum) {
		this.moneySum = moneySum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
