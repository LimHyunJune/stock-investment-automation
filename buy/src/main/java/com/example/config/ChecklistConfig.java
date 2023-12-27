package com.example.config;

import com.example.robot.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChecklistConfig {

    @Bean
    public BuyChecklist1 buyChecklist1()
    {
        return new BuyChecklist1();
    }

    @Bean
    public BuyChecklist2 buyChecklist2()
    {
        return new BuyChecklist2();
    }

    @Bean
    public BuyChecklist3 buyChecklist3()
    {
        return new BuyChecklist3();
    }

    @Bean
    public BuyChecklist4 buyChecklist4()
    {
        return new BuyChecklist4();
    }

    @Bean
    public BuyChecklist5 buyChecklist5()
    {
        return new BuyChecklist5();
    }

    @Bean
    public BuyChecklist6 buyChecklist6()
    {
        return new BuyChecklist6();
    }

    @Bean
    public BuyChecklist7 buyChecklist7()
    {
        return new BuyChecklist7();
    }

    @Bean
    public BuyChecklist8 buyChecklist8()
    {
        return new BuyChecklist8();
    }

    @Bean
    public BuyChecklist9 buyChecklist9()
    {
        return new BuyChecklist9();
    }

    @Bean
    public BuyChecklist10 buyChecklist10()
    {
        return new BuyChecklist10();
    }
}
