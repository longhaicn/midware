package com.poly.midware.api.sso;

import com.poly.midware.entity.StuffEntity;
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
public class StuffController {



    @IgnoreAuth
    @ApiOperation(value = "新增一条人员信息")
    @RequestMapping(method = RequestMethod.POST, value = "/stuffInterestSave")
    public R stuffInterestSave(HttpServletRequest request, @RequestBody StuffEntity stuffEntity){


        return R.ok();
    }
    @IgnoreAuth
    @ApiOperation(value = "删除一条人员信息")
    @RequestMapping(method = RequestMethod.POST, value = "/stuffInterestDelete")
    public R stuffInterestDelete(HttpServletRequest request, @RequestBody StuffEntity stuffEntity){


        return R.ok();
    }
    @IgnoreAuth
    @ApiOperation(value = "更新一条人员信息")
    @RequestMapping(method = RequestMethod.POST, value = "/stuffInterestUpdate")
    public R stuffInterestUpdate(HttpServletRequest request, @RequestBody StuffEntity stuffEntity){


        return R.ok();
    }
    @IgnoreAuth
    @ApiOperation(value = "查询一条人员信息")
    @RequestMapping(method = RequestMethod.POST, value = "/stuffInterestSelect")
    public R stuffInterestSelect(HttpServletRequest request, @RequestBody StuffEntity stuffEntity){


        return R.ok();
    }
    @IgnoreAuth
    @ApiOperation(value = "查询人员信息列表")
    @RequestMapping(method = RequestMethod.POST, value = "/stuffInterestList")
    public R stuffInterestList(HttpServletRequest request){


        return R.ok();
    }

}
