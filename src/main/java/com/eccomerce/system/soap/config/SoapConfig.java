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
                new ClassPathResource("pedidos.xsd")
        );

    }

    @Bean
    public XsdSchema productoSchema() {
        return new SimpleXsdSchema(
                new ClassPathResource("productos.xsd")
        );
    }

    @Bean
    public XsdSchema clienteSchema() {
        return new SimpleXsdSchema(
                new ClassPathResource("clientes.xsd")
        );
    }

    @Bean
    public XsdSchema categoriaSchema() {

        return new SimpleXsdSchema(
                new ClassPathResource("categorias.xsd")
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

    @Bean(name = "productos")
    public DefaultWsdl11Definition productoWsdl(
            XsdSchema productoSchema
    ) {

        DefaultWsdl11Definition definition =
                new DefaultWsdl11Definition();

        definition.setPortTypeName(
                "ProductoPort"
        );

        definition.setLocationUri("/ws");

        definition.setTargetNamespace(
                "http://eccomerce.com/producto"
        );

        definition.setSchema(productoSchema);

        return definition;
    }

    @Bean(name = "categorias")
    public DefaultWsdl11Definition categoriaWsdl(
            XsdSchema categoriaSchema
    ) {

        DefaultWsdl11Definition definition =
                new DefaultWsdl11Definition();

        definition.setPortTypeName(
                "CategoriaPort"
        );

        definition.setLocationUri(
                "/ws"
        );

        definition.setTargetNamespace(
                "http://eccomerce.com/categoria"
        );

        definition.setSchema(
                categoriaSchema
        );

        return definition;

    }

    @Bean(name = "clientes")
    public DefaultWsdl11Definition clienteWsdl(
            XsdSchema clienteSchema
    ) {

        DefaultWsdl11Definition definition =
                new DefaultWsdl11Definition();

        definition.setPortTypeName(
                "ClientePort"
        );

        definition.setLocationUri("/ws");

        definition.setTargetNamespace(
                "http://eccomerce.com/cliente"
        );

        definition.setSchema(clienteSchema);

        return definition;
    }
}