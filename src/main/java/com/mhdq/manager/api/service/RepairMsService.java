package com.mhdq.manager.api.service;

import com.manager.product.dto.MRepairInfoDTO;
import com.mhdq.rpc.RpcRespDTO;
import com.server.api.easyui.DataGrid;
import com.server.api.easyui.Page;

/**  
* 类说明   
*  
* @author zkj  
* @date 2017年4月24日  新建  
*/
public interface RepairMsService {
	
	DataGrid getRepairList(MRepairInfoDTO mrepairInfoDTO, Page page);
	
	RpcRespDTO<Integer> changeRepairStatusOne(Long id);
}
