package com.poly.midware.service;

import com.poly.midware.modle.InfluenceDateModel;
import com.poly.midware.mapper.ConnectionTestMapper;
import com.poly.midware.utils.DateTimeUtils;
import com.poly.midware.utils.constant.ExceptionCode;
import com.poly.midware.utils.constant.Message;
import com.poly.midware.utils.response.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.service
 * @Author: longhai
 * @CreateDate: 2018/5/28 17:04
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class ConnectionTestService {
    @Resource
    private ConnectionTestMapper connectionTestMapper;
    public JsonResult<String> testConn() {
        JsonResult<String> result = new JsonResult<>();

        try {
                result.setRow(connectionTestMapper.testConn());
                result.setData(Message.SUCCES);

        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_5000+e.getMessage());
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_5000);
        }
        return result;

    }

    public JsonResult<String> influnencedDate() {
        JsonResult<String> result = new JsonResult<>();

        try {
            InfluenceDateModel ifd =  connectionTestMapper.influnencedDate();
            result.setRow(1);
            result.setData(DateTimeUtils.formatDateStr(ifd.getInfluenced()));

        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_5000+e.getMessage());
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_5000);
        }
        return result;


    }
}
