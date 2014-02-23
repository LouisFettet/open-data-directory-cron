package com.socrata.open_data_directory_cron.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Author: Louis Fettet
 * Date: 2/22/14
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DataJsonEndpoint {
    private String url;
    private String label;
    private String type;
    private String vendor;

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("vendor")
    public String getVendor() {
        return vendor;
    }

    @JsonProperty("vendor")
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
