package com.jyx.vip.listener;

import com.jyx.vip.dao.VipRankDao;
import com.jyx.vip.entity.VipRankEntity;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:jyx
 * @date:2019-05-30 16:42
 * @desc(描述):
 */
public class ApplicationListener extends ContextLoaderListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
        ServletContext servletContext = sce.getServletContext();
        try {
            initVipRank(servletContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        super.contextDestroyed(sce);
    }

    private void initVipRank(ServletContext servletContext) throws Exception {
        WebApplicationContext requiredWebApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        VipRankDao vipRankDao = requiredWebApplicationContext.getBean(VipRankDao.class);
        List<VipRankEntity> vipRankEntities = vipRankDao.selectAll();
        Map<Integer, VipRankEntity> rankEntityMap = new HashMap<>();
        for (VipRankEntity vipRankEntity : vipRankEntities) {
            rankEntityMap.put(vipRankEntity.getId(), vipRankEntity);
        }
        servletContext.setAttribute("RANKS-MAP", rankEntityMap);
    }
}
