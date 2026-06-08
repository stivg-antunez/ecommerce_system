package com.eccomerce.system.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet>
    messageDispatcherServlet(
            ApplicationContext context
    ) {

        MessageDispatcherServlet servlet =
                new MessageDispatcherServlet();

        servlet.setApplicationContext(
                context
        );

        servlet.setTransformWsdlLocations(
                true
        );

        return new ServletRegistrationBean<>(
                servlet,
                "/ws/*"
        );

    }

    @Bean
    public XsdSchema pedidoSchema() {

        return new SimpleXsdSchema(
                new ClassPathResource(
                        "pedidos.xsd"
                )
        );

    }

    @Bean(name = "pedidos")
    public DefaultWsdl11Definition defaultWsdl11Definition(
            XsdSchema pedidoSchema
    ) {

        DefaultWsdl11Definition definition =
                new DefaultWsdl11Definition();

        definition.setPortTypeName(
                "PedidoPort"
        );

        definition.setLocationUri(
                "/ws"
        );

        definition.setTargetNamespace(
                "http://eccomerce.com/pedido"
        );

        definition.setSchema(
                pedidoSchema
        );

        return definition;
    }
}