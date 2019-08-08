package com.lh.sericefeign.FeignInterface;

import com.lh.VO.ResultVO;
import com.lh.sericefeign.FeignInterface.Hystric.AuthorityFeignInterfaceHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@FeignClient(value = "authority-mucon/authority", fallback = AuthorityFeignInterfaceHystric.class)
public interface AuthorityFeignInterface {
    @PostMapping(value = "/useLogOfManagerInBS")
    ResultVO useLogOfManagerInBS(@RequestParam(value = "num") String num
            , @RequestParam(value = "passWord") String passWord);

    @PostMapping("/selectMySystemNameList")
    ResultVO selectMySystemNameList(@RequestParam(value = "id") String id);

}
