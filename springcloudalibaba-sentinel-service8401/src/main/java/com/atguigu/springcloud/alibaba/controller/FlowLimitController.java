package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @auther zzyy
 * @create 2020-02-24 16:26
 */
@RestController
@Slf4j
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2L);
        log.info(Thread.currentThread().getName()+"\t"+"...testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotHot",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "pp",required = false) String p1,
                             @RequestParam(value = "bb",required = false) String bb)
    {
        log.info(Thread.currentThread().getName()+"\t"+"...testHotKey");
        return "------testHotKey";
    }

    public String deal_testHotKey (String p1, String p2, BlockException exception)
    {
        return "------deal_testHotKey,o(╥﹏╥)o";  //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    }
}
