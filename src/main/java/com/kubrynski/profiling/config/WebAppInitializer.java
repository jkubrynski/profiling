package com.kubrynski.profiling.config;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-06-22
 */
public class WebAppInitializer implements WebApplicationInitializer {

  private static final Logger LOG = LoggerFactory.getLogger(WebAppInitializer.class);

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    LOG.debug("Initializing web application...");

    AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
    springContext.setServletContext(servletContext);
    springContext.register(SpringConfig.class);

    ServletRegistration.Dynamic dispatcher =
        servletContext.addServlet("dispatcher", new DispatcherServlet(springContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");

    servletContext.addFilter("sitemesh", new SiteMeshFilter()).addMappingForUrlPatterns(null, true, "/*");
  }
}
