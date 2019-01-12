package top.osfun.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

// 容器中加入自定义的ErrorAttributes代替默认
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    /**
     *
         {
             "timestamp": 1547297668514,
             "status": 500,
             "error": "Internal Server Error",
             "exception": "java.lang.RuntimeException",
             "message": "测试异常",
             "path": "/ex",
             "company": "xxxxxx",
             "name": "aaaaaa",
             "pwd": "bbbbbb",
             "extendError": {
                 "code": 10001400,
                 "message": "测试异常"
             }
         }
     */
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes,
                                                  boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes,
                includeStackTrace);
        map.put("company", "xxxxxx");
        map.put("name", "aaaaaa");
        map.put("pwd", "bbbbbb");
        Map<String, Object> extendError = (Map<String, Object>) requestAttributes.getAttribute("extendError", 0);
        map.put("extendError", extendError);
        return map;
    }
}