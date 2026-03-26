package com.srikanth.jobportal.scopes;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@Component
@SessionScope
public class SessionScopedBean {
    String userName;

    public SessionScopedBean() {

        System.out.println("SessionScopedBean()");
    }
}
