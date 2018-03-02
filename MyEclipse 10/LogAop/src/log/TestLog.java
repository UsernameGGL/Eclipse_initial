package log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import advice.BeforeLogAdvice;

public class TestLog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getLogger(TestLog.class);
		logger.info("aTestLog Ö´ÐÐ½áÊø4343434343");

	}

}
