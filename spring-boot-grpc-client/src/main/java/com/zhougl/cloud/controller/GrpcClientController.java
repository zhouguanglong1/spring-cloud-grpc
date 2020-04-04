package com.zhougl.cloud.controller;

import com.zhougl.cloud.service.GrpcClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhougl
 * @version v1.0.0
 * @since 2020/4/4 22:56
 */
@RestController
public class GrpcClientController {
    @Resource
    private GrpcClientService grpcClientService;

    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "jack") String name) {
        return grpcClientService.sendMessage(name);
    }
}
