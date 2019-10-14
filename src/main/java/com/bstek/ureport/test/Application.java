package com.bstek.ureport.test;

import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
/**
 * 加载对应的xml配置文件
 */
@ImportResource("classpath:context.xml")
/** 指定类为应用启动类 */
@SpringBootApplication
public class Application {
    /**
     * main 函数
     */
    public static void main(String[] args) {
        /** main方法中通过SpringApplication的run方法启动应用。 */
        SpringApplication.run(Application.class, args);
    }
    /**
     * 进行注册Servlet
     * 配置 UReport2 需要使用到的servlet
     */
    @Bean
    public ServletRegistrationBean buildUReportServlet() {
        /**
         * @param  servlet
         * @param  urlMappings 值为“/ureport/*”的 urlMappings 是一定不能变的，否则系统将无法运行。
         */
        return new ServletRegistrationBean(new UReportServlet(), "/ureport/*");
    }
}