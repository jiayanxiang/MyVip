package com.jyx.vip.funcation;

import com.jyx.vip.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:jyx
 * @date:2019-05-29 16:51
 * @desc(描述):
 */
public interface UserFuncation {
    UserEntity login(String account,String password) throws Exception;

    @Transactional
    UserEntity updatePassword(String id,String oldPassword,String newPassword,String newPasswordConfirm) throws Exception;
}
