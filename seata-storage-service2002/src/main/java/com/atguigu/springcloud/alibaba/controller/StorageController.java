package com.atguigu.springcloud.alibaba.controller;


import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     */

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        log.info("收到 减少库存 请求");
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
