package com.jyx.vip.funcation;

import com.jyx.vip.entity.VipEntity;
import com.jyx.vip.web.handler.ao.VipAo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:jyx
 * @date:2019-05-30 15:39
 * @desc(描述):
 */
public interface VipFuncation {
    VipEntity queryVip(String code) throws Exception;

    @Transactional
    VipEntity addVip(VipAo vipAo) throws Exception;//录入VIP
}
