package org.AutomateMobile.constants;

import lombok.Getter;

@Getter
public class EnvConfig {

    private String platform;

    public EnvConfig() {
        setPlatform();
    }

    public void setPlatform(){
       this.platform =  System.getProperty("platform").toLowerCase();
    }


}
