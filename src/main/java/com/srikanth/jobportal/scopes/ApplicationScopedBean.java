package com.srikanth.jobportal.scopes;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@Getter
@Setter
@ApplicationScope
public class ApplicationScopedBean {

    private int vistorsCount;

    public ApplicationScopedBean() {
        System.out.println("ApplicationScopedBean Created");
    }

    public void incrementVistorsCount() {
        vistorsCount++;
    }
}
