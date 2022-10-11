package com.wjq.psringcloud_sentinel.controller;


import com.wjq.psringcloud_sentinel.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/provider")
public class ProviderSentinelController {
    int i=1;
    @GetMapping("/sentinel01")
    public String doSentinel01(){
        return "sentinel 01 hello world";
    }
    @GetMapping("/sentinel02")
    public String doSentinel02(){
        return "sentinel 02 hello world";
    }
    @Autowired
    private ResourceService resourceService;
    @GetMapping("/sentinel03")
    public String doSentinel03(){
//        resourceService.dogetResource();
//        return "sentinel 03 hello world";
        return resourceService.dogetResource();
    }
    @GetMapping("/sentinel04")
    public String doSentinel04(){
        return resourceService.dogetResource();
    }
    private AtomicLong atomicLong=new AtomicLong(1);
    @GetMapping("/sentinel05")
    public String doSentinel05() throws InterruptedException {
        long num=atomicLong.getAndIncrement();
        if(num%2==0){//模拟50%的慢调用比例
            Thread.sleep(200);
        }
        return "sentinel 05 hello world";
    }//熔断测试



}
