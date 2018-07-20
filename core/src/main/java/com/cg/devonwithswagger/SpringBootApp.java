package com.cg.devonwithswagger;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.openapi.SwaggerToOpenApiConversionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.cg.devonwithswagger.general.service.impl.rest.GeneralRestServiceImpl;

import io.oasp.module.jpa.dataaccess.api.AdvancedRevisionEntity;

/**
 * Main entry point of this {@link SpringBootApplication}. Simply run this class to start this app.
 */
@SpringBootApplication
@EntityScan(basePackages = { "com.cg.devonwithswagger" }, basePackageClasses = { AdvancedRevisionEntity.class })
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SpringBootApp {

  @Autowired
  private Bus bus;

  @Autowired
  private Feature swagger2Feature;

  /**
   * Entry point for spring-boot based app
   *
   * @param args - arguments
   */
  public static void main(String[] args) {

    SpringApplication.run(SpringBootApp.class, args);
  }

  @Bean
  public Server rsServer() {

    // setup CXF-RS
    JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
    endpoint.setBus(this.bus);
    endpoint.setServiceBeans(Arrays.<Object> asList(new GeneralRestServiceImpl()));
    endpoint.setAddress("/");
    endpoint.setFeatures(Arrays.asList(this.swagger2Feature));
    endpoint.setProvider(new SwaggerToOpenApiConversionFilter());
    return endpoint.create();
  }

}
