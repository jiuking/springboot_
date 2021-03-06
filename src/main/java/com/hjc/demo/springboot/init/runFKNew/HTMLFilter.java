package com.hjc.demo.springboot.init.runFKNew;

//处理字符串中的HTML标记
public class HTMLFilter implements Filter {

    public void doFilter(Request request, Response response,FilterChain chain) {
        //将字符串中出现的"<>"符号替换成"[]"
        request.requestStr=request.requestStr
                .replace('<', '[').replace('>', ']')+
                //后面添加的是便于我们观察代码执行步骤的字符串
                "----HTMLFilter()";
        if (true) {
          //判断是否执行
            System.out.println("不执行");
            return;
        }
        chain.doFilter(request, response,chain);
        response.responseStr+="---HTMLFilter()";
    }

}