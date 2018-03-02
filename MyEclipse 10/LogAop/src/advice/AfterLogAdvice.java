package advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.aop.AfterReturningAdvice;

public class AfterLogAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getLogger(BeforeLogAdvice.class);
		logger.info(arg3.getClass().getName()+"µÄ"+arg1.getName()+"Ö´ÐÐ½áÊø");
	}

}
