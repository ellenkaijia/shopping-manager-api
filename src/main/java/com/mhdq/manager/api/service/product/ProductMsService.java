package com.mhdq.manager.api.service.product;

import com.manager.product.dto.ProductDTO;
import com.mhdq.rpc.RpcRespDTO;

/**  
* 类说明   
*  
* @author zkj  
* @date 2017年3月27日  新建  
*/
public interface ProductMsService {

	RpcRespDTO<String> createPrpduct(ProductDTO productDTO);
}
