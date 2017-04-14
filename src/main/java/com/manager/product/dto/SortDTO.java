package com.manager.product.dto;

import java.io.Serializable;

/**  
* 类说明   
*  
* @author zkj  
* @date 2017年4月12日  新建  
*/
public class SortDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6903724173660190732L;

	private Long id;
	
	private String sortId;
	
	private String sortName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	
	

}
