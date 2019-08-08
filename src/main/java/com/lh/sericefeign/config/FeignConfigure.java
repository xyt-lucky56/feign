package com.lh.sericefeign.config;

import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FeignConfigure {
    public static int connectTimeOutMillis = 3000;//连接服务端超时时间，连接器时间，3000即3秒;
    public static int readTimeOutMillis = 5000;//服务端响应超时时间，即断路器时间
    //说明：连接器时间不可大于断路器时间
    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }

    @Bean
    public Retryer feignRetryer() {
        Retryer retryer = new Retryer.Default(100, 1000, 4);
//        return new Retryer.Default();
        return retryer;
    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
