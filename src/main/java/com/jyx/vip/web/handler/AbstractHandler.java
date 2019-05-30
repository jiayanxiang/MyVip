package com.jyx.vip.web.handler;

import com.jyx.vip.entity.VipRankEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author:jyx
 * @date:2019-05-30 16:59
 * @desc(描述):
 */
public abstract class AbstractHandler {

    public VipRankEntity getRank(HttpServletRequest httpServletRequest,int rank){
        Map<Integer, VipRankEntity> rankEntityMap = (Map<Integer, VipRankEntity>) httpServletRequest.getServletContext().getAttribute("RANKS-MAP");
        return rankEntityMap.get(rank);
    }
}
