package com.jyx.vip.web.handler.test;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author:jyx
 * @date:2019-05-31 11:38
 * @desc(描述):
 */
@Controller
@RequestMapping("/test")
public class TestHandler {

    @RequestMapping(value = "/test.do", method = RequestMethod.GET)
    @ResponseBody
    public String Test(@Param("name") String name) {
        System.out.println("test"+name);
        return "welcome";
    }

    @RequestMapping(value = "/test.do", method = RequestMethod.POST, params = "name")
    @ResponseBody
    public String TestPost(@Param("name") String name) {
        System.out.println("test"+name);
        return "welcome";
    }

    @RequestMapping(value = "/test/{id}" ,method = RequestMethod.POST)
    public void testPathVariable(@PathVariable("id") String id){

    }

    @RequestMapping(value = "/testFrom.do" ,method = RequestMethod.GET)
    public String testFormView(){
        return "redirect:/test.jsp";
    }

    @RequestMapping(value = "/testFrom.do" ,method = RequestMethod.POST)
    public void testForm(TestEntity entity){
        System.out.println(entity.getAccount());
    }
}
