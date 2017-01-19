package com.ai.opt.data.api.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.data.api.user.interfaces.ILoginSV;
import com.ai.opt.data.api.user.param.UserLoginResponse;
import com.ai.opt.data.constants.AccountConstants.ResultCode;
import com.ai.opt.data.dao.mapper.bo.UcMembers;
import com.ai.opt.data.service.busi.interfaces.ILoginBusiSV;
import com.ai.opt.data.service.busi.interfaces.IVoValidateSV;
import com.ai.opt.data.util.RegexUtils;
import com.ai.opt.sdk.util.BeanUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class LoginSVImpl implements ILoginSV {
    @Autowired
    private ILoginBusiSV iLoginBusiSV;
    @Autowired
	IVoValidateSV iVoValidateSV;

    @Override
    public UserLoginResponse queryUserByUserName(String username)
            throws BusinessException,SystemException {
        iVoValidateSV.validateLogin(username);
        // 判断用户名是手机还是邮箱
        /* boolean isEmial = RegexUtils.checkIsEmail(username);
        boolean isPhone = RegexUtils.checkIsPhone(username);
        UcMembers account = new UcMembers();
        if (isPhone == true) {
            account.setMobilephone(username);
        }else if (isEmial == true) {
            account.setEmail(username);
        }else{
            account.setUsername(username); 
        }*/
        UcMembers sysUser = iLoginBusiSV.queryByUserNamePhoneEmail(username);
        // 组织返回对象
        UserLoginResponse response = new UserLoginResponse();
        if (sysUser != null) {
            BeanUtils.copyProperties(response, sysUser);
            response.setUserId(String.valueOf(sysUser.getUid()));
			response.setLoginName(sysUser.getUsername());
			response.setEmail(sysUser.getEmail());
			response.setMobile(sysUser.getMobilephone());
			response.setLoginPassword(sysUser.getPassword());
			response.setSalt(sysUser.getSalt());
			response.setDomainname(sysUser.getDomainName());
			response.setEmailcheck(sysUser.getEmailcheck());
			
            ResponseHeader responseHeaders = new ResponseHeader(true, ResultCode.SUCCESS_CODE,
                    "成功");
            response.setResponseHeader(responseHeaders);
        } else {
            ResponseHeader responseHeaders = new ResponseHeader(false, ResultCode.FAIL_CODE,
                    "用户不存在");
            response.setResponseHeader(responseHeaders);
        }
        return response;
    }


}
