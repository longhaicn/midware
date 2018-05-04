package com.poly.midware.api.sso;

import com.poly.midware.entity.OrganizationEntity;
import com.poly.midware.utils.R;
import com.poly.midware.utils.annotation.IgnoreAuth;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.api.sso
 * @Author: longhai
 * @CreateDate: 2018/5/3 17:55
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Controller
public class OrganizationController {

    @IgnoreAuth
    @ApiOperation(value = "新增一条组织架构信息")
    @RequestMapping(method = RequestMethod.POST, value = "/organizationInterestSave")
    public R organizationInterestSave(HttpServletRequest request, @RequestBody OrganizationEntity organizationEntity){


        return R.ok();
    }
    @IgnoreAuth
    @ApiOperation(value = "删除一条组织架构信息")
    @RequestMapping(method = RequestMethod.POST, value = "/organizationInterestDelete")
    public R organizationInterestDelete(HttpServletRequest request, @RequestBody OrganizationEntity organizationEntity){


        return R.ok();
    }
    @IgnoreAuth
    @ApiOperation(value = "更新一条组织架构信息")
    @RequestMapping(method = RequestMethod.POST, value = "/organizationInterestUpdate")
    public R organizationInterestUpdate(HttpServletRequest request, @RequestBody OrganizationEntity organizationEntity){


        return R.ok();
    }
    @IgnoreAuth
    @ApiOperation(value = "查询一条组织架构信息")
    @RequestMapping(method = RequestMethod.POST, value = "/organizationInterestSelect")
    public R organizationInterestSelect(HttpServletRequest request, @RequestBody OrganizationEntity organizationEntity){


        return R.ok();
    }
    @IgnoreAuth
    @ApiOperation(value = "查询组织架构信息列表")
    @RequestMapping(method = RequestMethod.POST, value = "/organizationInterestList")
    public R organizationInterestList(HttpServletRequest request, @RequestBody OrganizationEntity organizationEntity){


        return R.ok();
    }

}
