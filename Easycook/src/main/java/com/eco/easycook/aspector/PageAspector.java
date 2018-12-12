package com.eco.easycook.aspector;

import com.eco.easycook.contants.PageContants;
import com.github.pagehelper.PageHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PageAspector {

    @Pointcut("execution(* com.eco.easycook.service.impl.*.*List(java.lang.Integer, java.lang.Integer,..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] params = joinPoint.getArgs();
        String pageNum = (String) params[0];
        String pageSize = (String) params[1];

        int pageNumInt = 0;
        int pageSizeInt = 0;
        if (pageNum == null || pageNum.length() == 0) {
            System.out.println("设置默认值为1");
            pageNumInt = PageContants.PAGENUM;
        } else {
            pageNumInt = Integer.valueOf(pageNum);
        }
        if (pageSize == null || pageSize.length() == 0) {
            pageSizeInt = PageContants.PAGESIZE;
        } else {
            pageSizeInt = Integer.valueOf(pageSize);
        }

        PageHelper.startPage(pageNumInt, pageSizeInt);

        Object obj = joinPoint.proceed(params);

        return obj;
    }
}
