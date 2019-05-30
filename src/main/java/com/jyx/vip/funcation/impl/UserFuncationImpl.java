package com.jyx.vip.funcation.impl;

import com.jyx.vip.common.AssertThrowUtils;
import com.jyx.vip.common.Md5Utils;
import com.jyx.vip.common.ThisSystemUtils;
import com.jyx.vip.dao.UserDao;
import com.jyx.vip.entity.UserEntity;
import com.jyx.vip.funcation.UserFuncation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:jyx
 * @date:2019-05-29 16:52
 * @desc(描述):
 */
@Service
public class UserFuncationImpl implements UserFuncation {

    @Autowired
    UserDao userDao;

    @Override
    public UserEntity login(String account, String password) throws Exception {

        account = AssertThrowUtils.throwIsNull("账户不能为空", account);
        password = AssertThrowUtils.throwIsNull("密码不能为空", password);

        UserEntity userEntity = userDao.select("account", account);
        if (userEntity == null) {
            AssertThrowUtils.throwSystemException("账户不存在");
        }

        password = Md5Utils.MD5Encode(password);
        if (!password.equals(userEntity.getPassword())) {
            AssertThrowUtils.throwSystemException("密码错误");
        }
        return userEntity;
    }

    @Override
    public UserEntity updatePassword(String id, String oldPassword, String newPassword, String newPasswordConfirm) throws Exception {
        //1.验证参数
        id = AssertThrowUtils.throwIsNull("id不能为空", id);
        oldPassword = AssertThrowUtils.throwIsNull("旧密码不能为空", oldPassword);
        newPassword = AssertThrowUtils.throwIsNull("新密码不能为空", newPassword);
        newPasswordConfirm = AssertThrowUtils.throwIsNull("新密码确认不能为空", newPasswordConfirm);
        AssertThrowUtils.assertEquals("两次密码不一致", newPassword, newPasswordConfirm);
        AssertThrowUtils.assertNotEquals("新旧密码不能一样", oldPassword, newPassword);
        UserEntity userEntity = userDao.select("id", id);
        AssertThrowUtils.assertNotNull("无法找到用户!", userEntity);
        oldPassword = Md5Utils.MD5Encode(oldPassword);
        AssertThrowUtils.assertEquals("旧密码不正确", userEntity.getPassword(), oldPassword);
        newPassword = Md5Utils.MD5Encode(newPassword);
        userEntity.setPassword(newPassword);
        userDao.update(userEntity);
        return userEntity;
    }
}
