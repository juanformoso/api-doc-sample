package ar.com.jmfsg.documentation.sample;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Application entry point. Initializes jetty with spring mvc.
 * 
 * @author jformoso
 */
public class App {
	public static void main(String[] args) throws Exception {

		Server server = new Server(1337);
		Context root = new Context(server, "/", Context.SESSIONS);
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		dispatcherServlet
				.setContextConfigLocation("classpath:application-context.xml");

		root.addServlet(new ServletHolder(dispatcherServlet), "/*");

		server.start();
	}
}
