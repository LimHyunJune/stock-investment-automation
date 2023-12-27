package com.example.plugin;

import com.example.config.ChecklistConfig;
import com.example.dto.StockData;
import com.example.robot.BuyChecklist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class BuyChecklistPlugin {
    public void run(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ChecklistConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames)
        {
            if(beanDefinitionName.contains("buy"))
            {
                BuyChecklist buyChecklist =  ac.getBean(beanDefinitionName, BuyChecklist.class);
                log.info("{} : {}", beanDefinitionName, buyChecklist.run(new StockData()));
            }
        }
    }
}
