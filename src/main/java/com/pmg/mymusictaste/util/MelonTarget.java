package com.pmg.mymusictaste.util;

public enum MelonTarget {

    REALTIME("https://www.melon.com/chart/index.htm"),
    DAILY("https://www.melon.com/chart/day/index.htm"),
    WEEKLY("https://www.melon.com/chart/week/index.htm"),
    MONTHLY("https://www.melon.com/chart/month/index.htm");

    private final String value;
    
    MelonTarget(String value){
        this.value = value;
    }
    
    public String getValue(){
        return value;
    }

    
}