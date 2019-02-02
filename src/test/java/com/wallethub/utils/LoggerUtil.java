package com.wallethub.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtil {
	public static Logger logger = Logger.getLogger("WHLogs.log");
	public static String loggerNull = null;

	public static Logger logger() {
		if (loggerNull == null) {
			PropertyConfigurator.configure(
					ConfigUtil.getRootDir() + "/src/test/resources/log4j.properties");
			loggerNull = "loggerSet";
		}
		return logger;
	}
}
