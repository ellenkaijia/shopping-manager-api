package com.manager.product.dto;

import java.io.Serializable;

/**  
* 产品资源DTO  
*  
* @author zkj  
* @date 2017年3月27日  新建  
*/
public class ProductResDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -719994773953059335L;

	private Long id;
	
	private String resId;
	
	private String resParentId;
	
	private Integer resSeq;
	
	private String prodId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getResParentId() {
		return resParentId;
	}

	public void setResParentId(String resParentId) {
		this.resParentId = resParentId;
	}

	public Integer getResSeq() {
		return resSeq;
	}

	public void setResSeq(Integer resSeq) {
		this.resSeq = resSeq;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	
	
}
