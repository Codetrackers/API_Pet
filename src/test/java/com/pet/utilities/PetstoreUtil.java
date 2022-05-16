package com.pet.utilities;

public class PetstoreUtil {

    public String getUrl() {
        final String URL = ConfigurationReader.get("url");
        return URL;
    }
}
