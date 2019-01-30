package com.feiyst.springbootlearn.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * @author: feiyst
 * @modified by:
 * @description: 阿里Druid数据库连接池
 * @create: 2019-01-30 10:38
 **/
@Data
@Configuration
// 这个注解是从application.yml文件中读取数据配置给成员变量，spring.datasource.druid是前缀
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidConfig {

    private String username;

    private String password;

    private String logSlowSql;

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean regist = new ServletRegistrationBean();
        regist.setServlet(new StatViewServlet());
        regist.addUrlMappings("/druid/*");
        regist.addInitParameter("loginUsername", username);
        regist.addInitParameter("loginPassword", password);
        regist.addInitParameter("logSlowSql", logSlowSql);
        return regist;
    }

    /**
     * 配置Druid的属性，和DataSource进行绑定，前缀设置为：spring.datasource
     * 不配置的话，很多初始化的属性是没有绑定的
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druid() {
        return new DruidDataSource();
    }
}
