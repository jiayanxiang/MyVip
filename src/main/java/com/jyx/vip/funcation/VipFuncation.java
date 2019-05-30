package com.jyx.vip.funcation;

import com.jyx.vip.entity.VipEntity;

/**
 * @author:jyx
 * @date:2019-05-30 15:39
 * @desc(描述):
 */
public interface VipFuncation {
    VipEntity queryVip(String code) throws Exception;
}
