package org.spring.springboot.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Spring Boot MessageConfiguration 测试 - {@link MessageConfiguration}
 *
 */
public class MessageConfigurationTest {

    @Test
    public void testGetMessageBean() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageConfiguration.class);
        System.out.println(ctx.getBean("message"));
        assertEquals("message configuration", ctx.getBean("message"));
    }

    @Test
    public void testScanPackages() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("org.spring.springboot");
        ctx.refresh();
        System.out.println(ctx.getBean("message"));
        System.out.println(ctx.getBean("jsonHttpTransportListener"));
        assertEquals("message configuration", ctx.getBean("message"));
    }
}
