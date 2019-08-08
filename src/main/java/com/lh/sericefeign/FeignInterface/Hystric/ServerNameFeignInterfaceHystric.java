package com.lh.sericefeign.FeignInterface.Hystric;

import com.lh.sericefeign.FeignInterface.ServerNameFeignInterface;
import org.springframework.stereotype.Service;

@Service
public class ServerNameFeignInterfaceHystric implements ServerNameFeignInterface {
    @Override
    public String myPort() {
        return "sorry port is error.";
    }

    @Override
    public String testTimeOut(long timeOut) {
        return "sorry, already time out.";
    }

    @Override
    public String myVersion() {
        return "sorry version is error.";
    }

//    @Override
//    public boolean isGet() {
//        return false;
//    }
//
//    @Override
//    public String hello2(int index) {
//        return null;
//    }

}


