package com.jyx.vip.web.handler;

import com.jyx.vip.common.ThisSystemException;
import com.jyx.vip.entity.VipEntity;
import com.jyx.vip.funcation.VipFuncation;
import com.jyx.vip.web.handler.vo.VipVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author:jyx
 * @date:2019-05-30 15:27
 * @desc(描述):
 */
@Controller
@RequestMapping("/vip")
public class VipHandler extends AbstractHandler {

    @Autowired
    VipFuncation vipFuncation;

    @RequestMapping(method = RequestMethod.GET, path = "/qry.do")
    public String qryView() throws Exception {
        return "vip/qry";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/qry.do")
    public String qry(HttpServletRequest httpServletRequest, String code, Map model) throws Exception {
        try {
            VipEntity vipEntity = vipFuncation.queryVip(code);
            VipVo vipVo = new VipVo();
            vipVo.setAddress(vipEntity.getAddress());
            vipVo.setCode(vipEntity.getCode());
            vipVo.setQq(vipEntity.getQq());
            vipVo.setName(vipEntity.getName());
            vipVo.setAge(vipEntity.getAge() + "");
            vipVo.setRemark(vipEntity.getRemark());
            vipVo.setAmount(vipEntity.getAmount() / 100.00 + "");
            vipVo.setEmail(vipEntity.getEmail());
            vipVo.setSex(vipEntity.getSex() ? "男" : "女");
            vipVo.setZip(vipEntity.getZip() + "");
            vipVo.setRank(getRank(httpServletRequest, vipEntity.getRank()).getName());
            model.put("v", vipVo);
        } catch (ThisSystemException e) {
            model.put("message", e.getMessage());
        }
        return "vip/qry";
    }
}
