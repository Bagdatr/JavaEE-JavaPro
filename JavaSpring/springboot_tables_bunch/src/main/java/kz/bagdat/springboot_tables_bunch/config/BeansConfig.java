package kz.bagdat.springboot_tables_bunch.config;

import kz.bagdat.springboot_tables_bunch.beans.FirstBean;
import kz.bagdat.springboot_tables_bunch.beans.ThirdBean;
import kz.bagdat.springboot_tables_bunch.beans.ThirdBeanImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public FirstBean firstBean(){
        return new FirstBean();
    }

    @Bean
    public FirstBean secondBean(){
        return new FirstBean("Bagdat",36);
    }

    @Bean
    public ThirdBean thirdBean(){
        return new ThirdBeanImpl();
    }

}
