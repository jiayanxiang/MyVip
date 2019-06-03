package com.jyx.vip.web.handler;

import com.jyx.vip.common.ThisSystemException;
import com.jyx.vip.entity.UserEntity;
import com.jyx.vip.funcation.UserFuncation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:jyx
 * @date:2019-05-29 15:35
 * @desc(描述):
 */
@Controller
public class LoginHandler {

    @Autowired
    UserFuncation userFuncation;

    @RequestMapping(method = RequestMethod.POST, path = "/login.do")
    public String login(String account, String password, HttpServletRequest httpServletRequest) {
        try {
            UserEntity login = userFuncation.login(account, password);
            httpServletRequest.getSession().setAttribute("currentUser", login);
        } catch (Exception e) {
            httpServletRequest.setAttribute("message", e.getMessage());
            return "forward:/login.jsp";
        }
        return "redirect:/index.do";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login.do")
    public String loginView() {
        return "forward:/login.jsp";
    }

    @RequestMapping("/index.do")
    public String index() {
        return "index";
    }

    @RequestMapping("/welcome.do")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return "redirect:/login.jsp";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/updatepassword.do")
    public String updatePasswordView() {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/updatepassword.do")
    public String updatePassword(String oldPassword, String newPassword, String newPasswordConfirm, HttpServletRequest httpServletRequest) throws Exception {
        try {
            UserEntity currentUser = (UserEntity) httpServletRequest.getSession().getAttribute("currentUser");
            userFuncation.updatePassword(currentUser.getId(), oldPassword, newPassword, newPasswordConfirm);
        } catch (ThisSystemException e) {
            httpServletRequest.setAttribute("message", e.getMessage());
            return "updatepassword";
        }

        httpServletRequest.getSession().setAttribute("message", "修改成功，请重新登录！");
        return "redirect:/login.jsp";
    }
}
