package com.jyx.vip.funcation.impl;

import com.jyx.vip.common.AssertThrowUtils;
import com.jyx.vip.common.ThisSystemUtils;
import com.jyx.vip.dao.VipDao;
import com.jyx.vip.entity.VipEntity;
import com.jyx.vip.funcation.VipFuncation;
import com.jyx.vip.web.handler.ao.VipAo;
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

    @Override
    public VipEntity addVip(VipAo vipAo) throws Exception {
        //1.参数验证
        if (vipAo == null){
            throw  new IllegalArgumentException("ao不能为空");
        }
        String phone = AssertThrowUtils.throwIsNull("手机号必须填写",vipAo.getPhone());
        String name = AssertThrowUtils.throwIsNull("姓名必须填写",vipAo.getName());
//        AssertThrowUtils.assertPhoneString("手机号码不合法",phone);
        Boolean sex = "1".equals(vipAo.getSex());
        int age = ThisSystemUtils.parseInt(vipAo.getAge()+"",0);
        //验证手机号码是否存在
        Boolean code = vipDao.exsits("code", phone);
        if (code){
            AssertThrowUtils.throwSystemException("手机号码已存在!");
        }
        //2.业务处理
        VipEntity vipEntity =new VipEntity();
        vipEntity.setId(ThisSystemUtils.uid());
        vipEntity.setRank(1);
        vipEntity.setAddress(vipAo.getAddress());
        vipEntity.setAge(age);
        vipEntity.setCode(phone);
        vipEntity.setQq(vipAo.getQq());
        vipEntity.setEmail(vipAo.getEmail());
        vipEntity.setName(name);
        vipEntity.setSex(sex);
        vipEntity.setRemark(vipAo.getRemark());
        vipEntity.setZip(vipAo.getZip());
        vipEntity.setAmount(0);
        //3.封装业务结果
        vipDao.insert(vipEntity);
        return vipEntity;
    }
}
