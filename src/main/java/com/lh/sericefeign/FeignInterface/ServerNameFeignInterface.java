package com.lh.sericefeign.FeignInterface;

import com.lh.sericefeign.FeignInterface.Hystric.ServerNameFeignInterfaceHystric;
import com.lh.sericefeign.config.FeignConfigure;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Repository
@FeignClient(value = "authority-mucon/universal", fallback = ServerNameFeignInterfaceHystric.class)
public interface ServerNameFeignInterface {
    @PostMapping(value = "/myVersion")
    String myVersion();

//    @GetMapping(value = "/isGet")
//    boolean isGet();
//
//    @PostMapping(value = "/hello2")
//    String hello2(@RequestParam(value = "index",defaultValue = "2") int index);

    @PostMapping(value = "/myPort")
    String myPort();

    @PostMapping(value = "/testTimeOut")
    String testTimeOut(@RequestParam(value = "timeOut")long timeOut);
}
