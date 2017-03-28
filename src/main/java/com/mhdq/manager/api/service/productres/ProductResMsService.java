package com.mhdq.manager.api.service.productres;

import java.util.List;

import com.manager.product.dto.ProductResDTO;
import com.mhdq.rpc.RpcRespDTO;

/**  
* 类说明   
*  
* @author zkj  
* @date 2017年3月28日  新建  
*/
public interface ProductResMsService {

	RpcRespDTO<Integer> createProductRes(List<ProductResDTO> list);
}
