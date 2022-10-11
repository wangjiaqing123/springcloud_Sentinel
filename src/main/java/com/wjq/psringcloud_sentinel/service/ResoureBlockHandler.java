package com.wjq.psringcloud_sentinel.service;


import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ResoureBlockHandler {
    public static String dohandle(BlockException ex){
        log.error("限流成功");
        return "访问太频繁了,稍等片刻再访问";
    }

}
//限流后的异常处理方法,应用于@SentinelResource注解中,
//此方法在编写时有如下几个要求:
//1)方法修饰符为public
//2)必须为static方法
//3)返回值类型与@SentinelResource注解描述的方法相同
//4)参数类型为BlockException
//5)方法名自己定义
