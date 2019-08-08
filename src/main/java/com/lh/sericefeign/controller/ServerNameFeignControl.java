package com.lh.sericefeign.controller;

import com.lh.VO.ResultVO;
import com.lh.sericefeign.FeignInterface.AuthorityFeignInterface;
import com.lh.sericefeign.FeignInterface.ServerNameFeignInterface;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.netflix.discovery.DiscoveryManager.getInstance;

@RestController
public class ServerNameFeignControl {

    @Value("${server.port}")
    String mySelfPort;
    @Value("${eureka.instance.metadata-map.version}")
    private String version;

    @Autowired
    ServerNameFeignInterface serverNameFeignInterface;

    @Autowired
    AuthorityFeignInterface authorityFeignInterface;

    @PostMapping("/testTimeOut")
    public String testTimeOut(@RequestParam(value = "timeOut") long timeOut) {
        return serverNameFeignInterface.testTimeOut(timeOut);
    }

    @PostMapping(value = "/useLogOfManagerInBS")
    public ResultVO useLogOfManagerInBS(@RequestParam(value = "num") String num
            , @RequestParam(value = "passWord") String passWord) {
        return authorityFeignInterface.useLogOfManagerInBS(num, passWord);
    }

    @PostMapping("/selectMySystemNameList")
    public ResultVO selectMySystemNameList(@RequestParam(value = "id") String id) {
        return authorityFeignInterface.selectMySystemNameList(id);
    }

    @PostMapping(value = "/myVersion")
    public String myVersion() {
        RibbonFilterContextHolder.getCurrentContext().add("version", version);
        return String.format("My port is %s; My version is %s; 粒子层：%s", this.mySelfPort, this.version, serverNameFeignInterface.myVersion());
    }

    //    @PostMapping(value = "/isGet")
//    public boolean isGet(){
//        return serverNameFeignInterface.isGet();
//    }
//
//    @PostMapping(value = "/hello2")
//    public String hello2(@RequestParam(value = "index",defaultValue = "2") int index){
//        return "Feign:" + serverNameFeignInterface.hello2(index);
//    }
    @PostMapping(value = "/myPort")
    public String myPort() {
        return "Feign:" + this.mySelfPort + ",Server-name:" + serverNameFeignInterface.myPort();
    }

    @GetMapping(value = "/downLine")
    public void downLine() {
        getInstance().shutdownComponent();
    }
}
