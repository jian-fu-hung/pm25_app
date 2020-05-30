package com.jerryHong.mypm25app.data.model;

public class RepoQiaotouResponse {
    /**
     * SiteId : 48
     * SiteName : 橋頭
     * County : 高雄市
     * ItemId : 33
     * ItemName : 細懸浮微粒
     * ItemEngName : PM2.5
     * ItemUnit : μg/m3
     * MonitorDate : 2020/5/28 下午 09:00:00
     * Concentration : 6
     */

    private String SiteId;
    private String SiteName;
    private String County;
    private String ItemId;
    private String ItemName;
    private String ItemEngName;
    private String ItemUnit;
    private String MonitorDate;
    private String Concentration;

    public String getSiteId() {
        return SiteId;
    }

    public void setSiteId(String SiteId) {
        this.SiteId = SiteId;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String SiteName) {
        this.SiteName = SiteName;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String County) {
        this.County = County;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getItemEngName() {
        return ItemEngName;
    }

    public void setItemEngName(String ItemEngName) {
        this.ItemEngName = ItemEngName;
    }

    public String getItemUnit() {
        return ItemUnit;
    }

    public void setItemUnit(String ItemUnit) {
        this.ItemUnit = ItemUnit;
    }

    public String getMonitorDate() {
        return MonitorDate;
    }

    public void setMonitorDate(String MonitorDate) {
        this.MonitorDate = MonitorDate;
    }

    public String getConcentration() {
        return Concentration;
    }

    public void setConcentration(String Concentration) {
        this.Concentration = Concentration;
    }
}
