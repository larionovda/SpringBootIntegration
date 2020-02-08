package com.larionov.epam.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/service/*");
    }

    @Bean
    public XsdSchema brandSchema() {
        return new SimpleXsdSchema(new ClassPathResource("brand.xsd"));
    }

    @Bean(name = "brandWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema brandSchema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("BrandPort");
        defaultWsdl11Definition.setLocationUri("/service/brand");
        defaultWsdl11Definition.setTargetNamespace("http://larionov.com/epam-spring-boot-soap");
        defaultWsdl11Definition.setSchema(brandSchema);
        return  defaultWsdl11Definition;
    }
}
