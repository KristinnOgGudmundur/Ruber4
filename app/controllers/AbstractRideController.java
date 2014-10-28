package controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by Gvendur Stefáns on 28.10.2014.
 */
public abstract class AbstractRideController {
	protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/RideService.xml");
	protected static ApplicationContext importCtx = new FileSystemXmlApplicationContext("/conf/ImportProcess.xml");
}
