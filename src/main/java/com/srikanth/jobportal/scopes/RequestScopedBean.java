package com.srikanth.jobportal.scopes;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

@Getter
@Setter
@Component
@RequestScope
public class RequestScopedBean {
    String userName;

    public RequestScopedBean() {
        System.out.println("RequestScopedBean()");
    }
}
