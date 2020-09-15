package com.wuning.filter;


import com.wuning.utils.JdbcUtil;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author wu
 * @date 2020-04-25 18:25
 */
public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JdbcUtil.commitAndClose();
        } catch (Exception e) {
            JdbcUtil.rollbackAndClose();
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }

}
