package com.mhdq.rpc;
/**  
* 公共数据传输类 
*  
* @author zkj  
* @date 2017年3月27日  新建  
*/

import java.io.Serializable;

/**
 * 用于 Ajax 请求返回
 */
public class RpcRespDTO<T> implements Serializable {
	private static final long serialVersionUID = 7666778243265202736L;
	private String code;
	private String msg;
	private T data;

	public RpcRespDTO() {

	}

	public RpcRespDTO(String code) {
		this(code, "", null);
	}

	public RpcRespDTO(String code, String msg) {
		this(code, msg, null);
	}

	public RpcRespDTO(String code, T data) {
		this(code, "", data);
	}

	public RpcRespDTO(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RpcRespDTO<T> buildSuccessResp(T data) {
		this.code = RpcCommonConstant.CODE_SUCCESS;
		this.msg = RpcCommonConstant.MSG_SUCCESS;
		this.data = data;
		return this;
	}

	public RpcRespDTO<T> buildFailedResp(T data) {
		this.code = RpcCommonConstant.CODE_ERR_UNKNOW;
		this.msg = RpcCommonConstant.MSG_ERR_UNKNOW;
		this.data = data;
		return this;
	}

	public RpcRespDTO<T> buildResp(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		return this;
	}

	public RpcRespDTO<T> buildResp(String code, String msg) {
		return buildResp(code, msg, null);
	}
	@Override
	public String toString() {
		return "RpcRespDTO [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
