package com.wuhao.job;

import com.wuhao.dao.UserMapper;
import com.wuhao.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: job类, 自定义任务
 * @author: wuhao
 * @create: 2020-06-18 21:34
 **/
@Slf4j
public class MyJob implements Job {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        User user = userMapper.queryUserById(1L);
        log.info("job执行: ---job------->"+user.toString());
    }

}
