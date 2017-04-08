package com.manager.product.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品的信息DTO
 * @author zkj
 *
 */
public class ProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7367045807395084703L;

	private Long id;
	
	private String prodId;
	
	private String codeId;
	
	private String prodName;
	
	private String prodDetail;
	
	private String prodTypeName;
	
	private String prodPrizeStr;
	
	private BigDecimal prodPrize;
	
	private String prodFreeTime;
	
	private Integer prodSum;
	
	private Integer prodSellSum;
	
	private Integer status;
	
	private String statusStr;
	
	private Date createTime;
	
	private String bandId;
	
	private Integer prodTypeCode;
	
	private Integer isNew;
	
	private Integer isHot;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDetail() {
		return prodDetail;
	}

	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}

	public String getProdTypeName() {
		return prodTypeName;
	}

	public void setProdTypeName(String prodTypeName) {
		this.prodTypeName = prodTypeName;
	}

	public String getProdPrizeStr() {
		return prodPrizeStr;
	}

	public void setProdPrizeStr(String prodPrizeStr) {
		this.prodPrizeStr = prodPrizeStr;
	}

	public BigDecimal getProdPrize() {
		return prodPrize;
	}

	public void setProdPrize(BigDecimal prodPrize) {
		this.prodPrize = prodPrize;
	}

	public String getProdFreeTime() {
		return prodFreeTime;
	}

	public void setProdFreeTime(String prodFreeTime) {
		this.prodFreeTime = prodFreeTime;
	}

	public Integer getProd_sum() {
		return prodSum;
	}

	public void setProdSellSum(Integer prodSellSum) {
		this.prodSellSum = prodSellSum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusStr() {
		if(this.status == 0) {
			statusStr = "预发布";
		} else if(this.status == 1){
			statusStr = "已发布";
		} else if(this.status == 2) {
			statusStr = "已售完";
		} else if(this.status == 3) {
			statusStr = "已下架";
		}
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getProdSum() {
		return prodSum;
	}

	public void setProdSum(Integer prodSum) {
		this.prodSum = prodSum;
	}

	public Integer getProdSellSum() {
		return prodSellSum;
	}

	public String getBandId() {
		return bandId;
	}

	public void setBandId(String bandId) {
		this.bandId = bandId;
	}

	public Integer getProdTypeCode() {
		return prodTypeCode;
	}

	public void setProdTypeCode(Integer prodTypeCode) {
		this.prodTypeCode = prodTypeCode;
	}

	public Integer getIsNew() {
		return isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	
}
