package com.lh.sericefeign.FeignInterface.Hystric;

import com.lh.VO.ResultVO;
import com.lh.sericefeign.FeignInterface.AuthorityFeignInterface;
import com.lh.utils.ResultUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthorityFeignInterfaceHystric implements AuthorityFeignInterface {
    @Override
    public ResultVO useLogOfManagerInBS(String num, String passWord) {
        return ResultUtils.error();
    }

    @Override
    public ResultVO selectMySystemNameList(String id) {
        return ResultUtils.error();
    }
}
