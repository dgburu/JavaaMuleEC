package com.iukonline.amule.ec;

public class ECStats {
    
    private ECClient client;

    private long speedDl;
    private long speedUl;
    
    void setClient(ECClient client) {
        this.client = client;
    }

    public long getSpeedDl() {
        return speedDl;
    }
    public void setSpeedDl(long speedDl) {
        this.speedDl = speedDl;
    }
    public long getSpeedUl() {
        return speedUl;
    }
    public void setSpeedUl(long speedUl) {
        this.speedUl = speedUl;
    }    
    
}