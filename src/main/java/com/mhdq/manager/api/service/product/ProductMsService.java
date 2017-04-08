package com.mhdq.manager.api.service.product;

import java.util.List;

import com.manager.product.dto.ProductBandDTO;
import com.manager.product.dto.ProductDTO;
import com.mhdq.rpc.RpcRespDTO;
import com.server.api.easyui.DataGrid;
import com.server.api.easyui.Page;

/**  
* 类说明   
*  
* @author zkj  
* @date 2017年3月27日  新建  
*/
public interface ProductMsService {

	RpcRespDTO<String> createPrpduct(ProductDTO productDTO);
	
	DataGrid dataGrid(ProductDTO productDTO, Page page);
	
	RpcRespDTO<Integer> deleteProduct(String productId);
	
	RpcRespDTO<Integer> updateProduct(ProductDTO productDTO);
	
	RpcRespDTO<Integer> releaseProduct(String productId);
	
	ProductDTO showProduct(Long id);
	
	RpcRespDTO<String> addBand(ProductBandDTO productBandDTO);
	
	DataGrid showBand(ProductBandDTO productBandDTO, Page page);
	
	List<ProductBandDTO> getProductBandList();
	
	RpcRespDTO<Integer> gonew(Long id);
	
	RpcRespDTO<Integer> cacelgonew(Long id);
	
	RpcRespDTO<Integer> gohot(Long id);
	
	RpcRespDTO<Integer> cacelgohot(Long id);
}
