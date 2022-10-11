package com.wjq.psringcloud_sentinel.service;


import com.alibaba.csp.sentinel.annotation.SentinelResource;


import org.springframework.stereotype.Service;

@Service
public class ResourceService {
//    @SentinelResource("doGetResource")

    @SentinelResource(value = "doGetResource",
    blockHandlerClass = ResoureBlockHandler.class,
    blockHandler = "dohandle")
    public String dogetResource(){
        return "Resource欢迎你";
    }
}
