package com.jyx.vip.funcation.impl;

import com.jyx.vip.common.AssertThrowUtils;
import com.jyx.vip.dao.VipDao;
import com.jyx.vip.entity.VipEntity;
import com.jyx.vip.funcation.VipFuncation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:jyx
 * @date:2019-05-30 15:40
 * @desc(描述):
 */
@Service
public class VipFuncationImpl implements VipFuncation {

    @Autowired
    VipDao vipDao;

    @Override
    public VipEntity queryVip(String code) throws Exception {
        //1验证参数
            code = AssertThrowUtils.throwIsNull("VIP账户必须填写",code);
        //2业务处理
        VipEntity code1 = vipDao.select("code", code);
        //3封装业务结果
        AssertThrowUtils.assertNotNull("没找到相关用户!",code1);
        return code1;
    }
}
