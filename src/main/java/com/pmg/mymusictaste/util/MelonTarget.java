package com.pmg.mymusictaste.util;

public enum MelonTarget {

    REALTIME("https://www.melon.com/chart/index.htm"),
    DAILY("https://www.melon.com/chart/day/index.htm"),
    WEEKLY("https://www.melon.com/chart/week/index.htm"),
    MONTHLY("https://www.melon.com/chart/month/index.htm");

    private final String url;

    MelonTarget(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}