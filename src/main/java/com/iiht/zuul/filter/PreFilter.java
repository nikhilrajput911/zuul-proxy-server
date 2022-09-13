package com.iiht.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.util.Enumeration;
import java.util.Set;

public class PreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println("Pre Filter, Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());

//        Enumeration<String> headerNames = ctx.getRequest().getHeaderNames();
//        while(headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            String headerValue = request.getHeader(headerName);
//            ctx.addZuulRequestHeader(headerName, headerValue);
//            System.out.println("headerName: " + headerName + ", headerValue: " + headerValue);
//        }

        return null;
    }
}
