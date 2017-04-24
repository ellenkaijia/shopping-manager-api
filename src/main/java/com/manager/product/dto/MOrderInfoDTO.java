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
public class MOrderInfoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6006846603020661250L;

	private Long id;
	
	private String userId;
	
	private String prodId;
	
	private String orderId;
	
	private Integer status;
	
	private Integer talkStatus;
	
	private Integer buyCount;
	
	private BigDecimal moneySum;
	
	private Long attachAddress;
	
	private Date createTime;

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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTalkStatus() {
		return talkStatus;
	}

	public void setTalkStatus(Integer talkStatus) {
		this.talkStatus = talkStatus;
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

	public Long getAttachAddress() {
		return attachAddress;
	}

	public void setAttachAddress(Long attachAddress) {
		this.attachAddress = attachAddress;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
