package top.shellteo.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware {

	@Autowired
	private static ApplicationContext applicationContext;
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  
	@Override  
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(SpringUtils.applicationContext == null){  
			SpringUtils.applicationContext  = applicationContext;  
		}  
		logger.info("---------------------------------------------------------------------");  
		logger.info("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+SpringUtils.applicationContext+"========");
		logger.info("---------------------------------------------------------------------");  
    } 
	
    //获取applicationContext  
    public static ApplicationContext getApplicationContext() {
       return applicationContext;  
    }  
  
    //通过Name 获取 Bean
    public static Object getBean(String name){  
       return getApplicationContext().getBean(name);  
  
    }  
  
    //通过Class 获取 Bean
    public static <T> T getBean(Class<T> clazz){  
       return getApplicationContext().getBean(clazz);  
    }  
  
    //通过Name、Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){  
       return getApplicationContext().getBean(name, clazz);  
    }

}
