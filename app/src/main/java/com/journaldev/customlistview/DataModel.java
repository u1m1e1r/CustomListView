package com.journaldev.customlistview;

public class DataModel {

    String name;
    String type;
    String version_number;
    String feature;
    String imgurl;

    public DataModel(String name, String type, String version_number, String feature, String imgurl) {
        this.name = name;
        this.type = type;
        this.version_number = version_number;
        this.feature = feature;
        this.imgurl = imgurl;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getVersion_number() {
        return version_number;
    }
    public String getFeature() {
        return feature;
    }
    public String getImgurl() {
        return imgurl;
    }
}