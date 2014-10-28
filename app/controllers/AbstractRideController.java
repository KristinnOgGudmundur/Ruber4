package controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * All controller classes that will use the ride service will need to extend this controller
 */
public abstract class AbstractRideController {
	protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/RideService.xml");
	protected static ApplicationContext importCtx = new FileSystemXmlApplicationContext("/conf/ImportProcess.xml");
}
