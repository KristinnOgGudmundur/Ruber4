package controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by Gvendur Stefáns on 22.10.2014.
 */
public abstract class AbstractDriverController {
	protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/DriverService.xml");
}
