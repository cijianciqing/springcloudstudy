package com.atguigu.springcloud.alibaba.service.fallback;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.StorageService;
import org.springframework.stereotype.Component;

@Component
public class StorageFallbackService implements StorageService {
    @Override
    public CommonResult decrease(Long productId, Integer count) {
        return new CommonResult<>(44444,"服务降级返回,---请联系管理员");
    }
}
