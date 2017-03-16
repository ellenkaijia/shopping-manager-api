package com.server.api.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 集合工具类
 * 
 * @author zkj
 * @date 2017-3-16
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class CollectionUtil{
    
	private static Logger log = LoggerFactory.getLogger(CollectionUtil.class);
	
    /**
     * 将源list浅复制为新的list（list元素类型不同）
     * @param fromList 源List
     * @param clazz 目标List的元素类型
     * @return
     */
    public static <T> List<T> lowCopyList(List<?> fromList, Class<T> clazz){
        List<T> toList = new ArrayList<T>();
        if( fromList==null || fromList.isEmpty() ){
            return toList;
        }
        for(Object source : fromList){
            if(source==null){
                continue;
            }
            T target = CollectionUtil.createInstance(clazz);
            if(target!=null){
                org.springframework.beans.BeanUtils.copyProperties(source, target); // 浅复制属性
                toList.add(target);
            }
        }
        return toList;
    }
    
    /**创建泛型类实例*/
    public static <T> T createInstance(Class<T> clazz) {
        T obj = null;
        try {
            obj = clazz.newInstance();
        } catch (Exception e) {
            obj = null;
            log.error(e.getMessage());
        }
        return obj;
    }
	
    /**list深度拷贝，元素类型相同，list中的元素须实现序列化接口*/
    public static List deepCopy(List list){
    	List result = null;
    	try{
    		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
	        ObjectOutputStream out = new ObjectOutputStream(byteOut);
	        out.writeObject(list);
	        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
	        ObjectInputStream in = new ObjectInputStream(byteIn);
	        result = (List) in.readObject();
    	}
    	catch(Exception e){
    	    log.error(e.getMessage());
    	}
        return result;
    }
	
	/**Object转换成map(通过get方法获取Object的属性值)*/
	public static Map<String , Object> obj2Map(Object obj){
		Map<String, Object> params = new HashMap<String, Object>();
		if(obj==null){
			return params;
		}
		try{
			//所有方法
			Method[] methods = obj.getClass().getMethods();
			if(methods==null || methods.length<1){
				return params;
			}
			for(Method one : methods){
                //获取方法的名字
                String methodName = one.getName(); 
                Class[] paramTypes = one.getParameterTypes();
                if("getClass".equals(methodName) || !methodName.startsWith("get") || paramTypes!=null && paramTypes.length>0 ){
                    continue;
                }
                // get方法，get + 属性名（首字母变大写）
                // 调用getter方法获取属性值
                try{
                    Object value = one.invoke(obj); 
                    String key = StringTools.firstToLower(methodName.substring(3));
                    if(value!=null && value.toString().trim().length()>0 && key!=null){
                        params.put(key, value);
                    }
                }
                catch(Exception e){
                    log.error(e.getMessage());
                }
            }
		}
		catch(Exception e){
			log.error(e.getMessage() , e);
		}
		return params;
	}
	
	/**
	 * 从fromList的开始位置移除元素，并返回移除的结果list
	 * @param fromList
	 * @param size
	 * @return
	 */
	public static <T> List<T> removeList(List<T> fromList, Integer size){
		List<T> results = new ArrayList<T>();
		if(size==null){
			size = 0;
		}
        if( fromList==null || fromList.isEmpty() ){
            return results;
        }
		while(results.size()<size && fromList.size()>0){
			results.add(fromList.remove(0)); // 从开头位置移除一个元素并放到结果list中
		}
		return results;
	}
	
}
