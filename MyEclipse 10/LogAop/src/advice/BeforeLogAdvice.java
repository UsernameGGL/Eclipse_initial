package advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getLogger(BeforeLogAdvice.class);
		logger.info(arg2.getClass().getName()+"的"+arg0.getName()+"方法开始被执行！！！！");
	}
}
















