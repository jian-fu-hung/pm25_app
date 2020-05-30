package com.jerryHong.mypm25app.data.model;

public class RepoAQIResponse {

    /**
     * SiteId : 84
     * SiteName : 富貴角
     * MonitorDate : 2020-05-27
     * AQI : 43
     * SO2SubIndex : 1
     * COSubIndex : 1
     * O3SubIndex :
     * PM10SubIndex : 19
     * NO2SubIndex : 5
     * O38SubIndex : 43
     * PM25SubIndex : 11
     */

    private String SiteId;
    private String SiteName;
    private String MonitorDate;
    private String AQI;
    private String SO2SubIndex;
    private String COSubIndex;
    private String O3SubIndex;
    private String PM10SubIndex;
    private String NO2SubIndex;
    private String O38SubIndex;
    private String PM25SubIndex;

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

    public String getMonitorDate() {
        return MonitorDate;
    }

    public void setMonitorDate(String MonitorDate) {
        this.MonitorDate = MonitorDate;
    }

    public String getAQI() {
        return AQI;
    }

    public void setAQI(String AQI) {
        this.AQI = AQI;
    }

    public String getSO2SubIndex() {
        return SO2SubIndex;
    }

    public void setSO2SubIndex(String SO2SubIndex) {
        this.SO2SubIndex = SO2SubIndex;
    }

    public String getCOSubIndex() {
        return COSubIndex;
    }

    public void setCOSubIndex(String COSubIndex) {
        this.COSubIndex = COSubIndex;
    }

    public String getO3SubIndex() {
        return O3SubIndex;
    }

    public void setO3SubIndex(String O3SubIndex) {
        this.O3SubIndex = O3SubIndex;
    }

    public String getPM10SubIndex() {
        return PM10SubIndex;
    }

    public void setPM10SubIndex(String PM10SubIndex) {
        this.PM10SubIndex = PM10SubIndex;
    }

    public String getNO2SubIndex() {
        return NO2SubIndex;
    }

    public void setNO2SubIndex(String NO2SubIndex) {
        this.NO2SubIndex = NO2SubIndex;
    }

    public String getO38SubIndex() {
        return O38SubIndex;
    }

    public void setO38SubIndex(String O38SubIndex) {
        this.O38SubIndex = O38SubIndex;
    }

    public String getPM25SubIndex() {
        return PM25SubIndex;
    }

    public void setPM25SubIndex(String PM25SubIndex) {
        this.PM25SubIndex = PM25SubIndex;
    }
}
