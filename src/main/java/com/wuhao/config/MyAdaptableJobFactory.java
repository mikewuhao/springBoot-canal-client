package com.wuhao.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @description: 继承AdaptableFactory类, 重写实例化方法, 把对象手动注入springIOC容器, 实现业务层service的注入
 * @author: wuhao
 * @create: 2020-06-19 11:15
 **/
@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {

    @Autowired //將對象添加到springIOC的容器中並且完成對象的注入
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object obj = super.createJobInstance(bundle);
        //把obj對象加入到springIOC容器中,完成注入
        this.autowireCapableBeanFactory.autowireBean(obj);
        return obj;
    }



}
