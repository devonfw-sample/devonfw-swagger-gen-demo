package com.cg.devonwithswagger.general.service.impl.config;

import org.apache.cxf.feature.Feature;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ABCHANDE
 *
 */
@Configuration
public class FeatureConfig {

  @Value("${cxf.path}")
  private String basePath;

  @Bean("swagger2Feature")
  public Feature swagger2Feature() {

    Swagger2Feature result = new Swagger2Feature();
    result.setTitle("Demo for integration of Devon application wtih Swagger");
    result.setDescription(
        "This is a demo for integration of Swagger into a Devon application using CXF. Additionally, it has been configured"
            + " to convert Swagger JSON produced by CXF Swagger2Feature into Open API JSON");
    result.setBasePath(this.basePath);
    result.setVersion("v1");
    result.setContact("Abhay Chandel");
    result.setSchemes(new String[] { "http", "https" });
    return result;
  }
}
