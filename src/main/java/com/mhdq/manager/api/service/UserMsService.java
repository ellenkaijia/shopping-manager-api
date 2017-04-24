package com.mhdq.manager.api.service;

import com.manager.product.dto.MAddressInfoDTO;
import com.manager.product.dto.UserInfoDTO;
import com.server.api.easyui.DataGrid;
import com.server.api.easyui.Page;

/**  
* 类说明   
*  
* @author zkj  
* @date 2017年4月21日  新建  
*/
public interface UserMsService {

	DataGrid dataGrid(UserInfoDTO userInfoDTO, Page page);
	
	DataGrid addressList(MAddressInfoDTO maddressInfoDTO, Page page);
}
