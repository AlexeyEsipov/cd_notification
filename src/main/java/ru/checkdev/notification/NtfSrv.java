package ru.checkdev.notification;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@OpenAPIDefinition(info = @Info(title = "Notification service", description = "Description"))
@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = "ru.checkdev.notification.repository")
@EntityScan(basePackages = "ru.checkdev.notification.domain")
public class NtfSrv {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NtfSrv.class);
        application.addListeners(new ApplicationPidFileWriter("./notification.pid"));
        application.run(args);
    }

    @Bean
    public SpringLiquibase liquibase(DataSource ds) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/db.changelog-master.xml");
        liquibase.setDataSource(ds);
        return liquibase;
    }

}
