package com.wuhao.config;

import com.wuhao.job.MyJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @description: quartz配置类
 * @author: wuhao
 * @create: 2020-06-19 10:38
 **/
@Configuration
public class QuartzConfig {

    //1.创建Job对象
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        //关联自定义的job类
        factory.setJobClass(MyJob.class);
        return factory;
    }

    //2. 创建Trigger对象
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
        // 关联jobDetail对象
        factory.setJobDetail(jobDetailFactoryBean.getObject());
        //任务间隔毫秒数
        factory.setRepeatInterval(2000);
        // 任务重复次数
        factory.setRepeatCount(5);
        return factory;
    }

    //3. 创建Scheduler对象
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean, MyAdaptableJobFactory myAdaptableJobFactory){
        SchedulerFactoryBean factory= new SchedulerFactoryBean();
        //关联 trigger
        factory.setTriggers(simpleTriggerFactoryBean.getObject());
        factory.setJobFactory(myAdaptableJobFactory);
        return factory;
    }
}
