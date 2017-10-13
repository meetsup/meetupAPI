package top.shellteo.exception;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private static Map<String,String> errMsgMap = new HashMap<String,String>();
	
	public BusinessException(Throwable cause)
	{
		super(cause);
	}
	public BusinessException(String message){
		super(message);
	}
	
	public BusinessException(String message, Throwable cause)
	{
		super(message,cause);
	}
	/**
	 * errorCode  异常代码
	 * flag  是否显示异常信息
	 * */
	public BusinessException(String errorCode, Boolean flag){
		String msg;
		if(errMsgMap==null||errMsgMap.get(errorCode)==null||"".equals(errMsgMap.get(errorCode))){
			initMsgMap();
		}
		msg = errMsgMap.get(errorCode);
		if(flag&&msg!=null&&!"".equals(msg)){
			throw new BusinessException(msg);
		}else{
			throw new BusinessException(errorCode);
		}
	}
	 /**
	 * errorCode  异常代码
	 * variableCode  拼入异常信息内的代码
	 * flag  是否显示异常信息
	 * */
	public BusinessException(String errorCode, String variableCode, Boolean flag){
		String msg;
		if(errMsgMap==null||errMsgMap.get(errorCode)==null||"".equals(errMsgMap.get(errorCode))){
			initMsgMap();
		}
		msg = errMsgMap.get(errorCode);
		if(variableCode!=null&&!"".equals(variableCode)){
			msg = variableCode+""+msg;
		}
		if(flag&&msg!=null&&!"".equals(msg)){
			throw new BusinessException(msg);
		}else{
			throw new BusinessException(errorCode);
		}
	}
	public void initMsgMap(){
		Properties p = new Properties();
		InputStream is = null;
		Reader reader = null;
		try {
			is = BusinessException.class.getClassLoader().getResourceAsStream("Exception.properties");
			reader = new InputStreamReader(is, "UTF-8");
			p.load(reader);
			Enumeration<Object> enumer = p.keys();
			   while(enumer.hasMoreElements()){
				   String key =(String) enumer.nextElement();
				   errMsgMap.put(key, p.getProperty(key));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
