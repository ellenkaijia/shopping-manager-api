package com.server.api.easyui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.server.api.util.CollectionUtil;


/**
 * 对分页的基本数据进行一个简单的封装
 * 
 * @author zkj
 * @date 2017年3月16日
 */
public class Page<T> implements java.io.Serializable{

    private static final long serialVersionUID = 7270757213653855323L;
    private Integer page = 1; // 当前页，默认第一页
    private Integer rows = 10000; //每页大小，默认1万条 
    private String sort; // 排序字段
    private String order = "asc"; // 降序/升序(asc/desc)，默认升序
	private Integer totalRecord; // 总记录数
	private Integer totalPage; // 总页数
	private List<T> results; // 对应的当前页记录
	private Map<String, Object> params = new HashMap<String, Object>();// 其他的参数我们把它分装成一个Map对象

	public Integer getTotalRecord(){
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord){
		this.totalRecord = totalRecord;
		// 在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
		int totalPage = totalRecord % this.rows == 0 ? totalRecord / this.rows : totalRecord / this.rows + 1;
		this.totalPage = totalPage;
	}

	public Integer getTotalPage(){
		return totalPage;
	}

	public void setTotalPage(Integer totalPage){
		this.totalPage = totalPage;
	}

	public List<T> getResults(){
		return results;
	}

	public void setResults(List<T> results){
		this.results = results;
	}

	public Map<String, Object> getParams(){
		return params;
	}

	/**设置查询条件参数，减少重复代码*/
    public void setParams(Object params){
        this.params = CollectionUtil.obj2Map(params);
    }

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * 获取DateGrid，减少重复代码
     * @param page 分页对象，用于获取总记录数
     * @param list 源list
     * @param clazz 结果list的元素类型，传入null说明不需要复制
     * @return
     */
    public static <T> DataGrid getDataGrid(Page<?> page, List<?> list,  Class<T> clazz){
        Integer total = 0;
        if(page!=null && page.getTotalRecord()!=null){
            total = page.getTotalRecord();
        }
        return Page.getDataGrid(total, list, clazz);
    }
    
    /**
     * 获取DateGrid，减少重复代码
     * @param total 总记录数
     * @param list 源list
     * @param clazz 结果list的元素类型，传入null说明不需要复制
     * @return
     */
    public static <T> DataGrid getDataGrid(Integer total, List<?> list,  Class<T> clazz){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setTotal(total);
        if(clazz!=null){
            // 将source list转换为result list，浅复制
            List<T> resultList = CollectionUtil.lowCopyList(list, clazz);
            // 利用page和list构造DateGrid对象
            dataGrid.setRows(resultList);
        }
        else{
            // clazz为null，说明不需要转换，直接返回source list的DataGrid
            dataGrid.setRows(list);
        }
        return dataGrid;
    }
}