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
public class DataJsonSingleEntry {
    // Main info
    private String title;
    private String description;
    // Web endpoint (in order of priority)
    private String webService;
    private String accessURL;
//    private DistributionObject[] distribution;
    // The date modified
    private String modified;
    // The keywords and tags (in order of priority)
    private String[] keyword;
    private String[] keywords;
    private String sourceDomain;
    private String theme;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("webService")
    public String getWebService() {
        return webService;
    }

    @JsonProperty("webService")
    public void setWebService(String webService) {
        this.webService = webService;
    }

    @JsonProperty("accessURL")
    public String getAccessURL() {
        return accessURL;
    }

    @JsonProperty("accessURL")
    public void setAccessURL(String accessURL) {
        this.accessURL = accessURL;
    }
/*
    @JsonProperty("distribution")
    public DistributionObject[] getDistribution() {
        return distribution;
    }

    @JsonProperty("distribution")
    public void setDistribution(DistributionObject[] distribution) {
        this.distribution = distribution;
    }
*/
    @JsonProperty("modified")
    public String getModified() {
        return modified;
    }

    @JsonProperty("modified")
    public void setModified(String modified) {
        this.modified = modified;
    }

    @JsonProperty("keyword")
    public String[] getKeyword() {
        return keyword;
    }

    @JsonProperty("keyword")
    public void setKeyword(String[] keyword) {
        this.keyword = keyword;
    }

    @JsonProperty("keywords")
    public String[] getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("sourceDomain")
    public String getSourceDomain() {
        return sourceDomain;
    }

    @JsonProperty("sourceDomain")
    public void setSourceDomain(String sourceDomain) {
        this.sourceDomain = sourceDomain;
    }

    @JsonProperty("theme")
    public String getTheme() {
        return theme;
    }

    @JsonProperty("theme")
    public void setTheme(String theme) {
        this.theme = theme;
    }
 /*
    public class DistributionObject {
        private URL accessURL;
        private FormatObject format;

        @JsonProperty("accessURL")
        public URL getAccessURL() {
            return accessURL;
        }

        @JsonProperty("accessURL")
        public void setAccessURL(URL accessURL) {
            this.accessURL = accessURL;
        }

        @JsonProperty("format")
        public FormatObject getFormat() {
            return format;
        }

        @JsonProperty("format")
        public void setFormat(FormatObject format) {
            this.format = format;
        }

        public class FormatObject {
            private String label;
            private String value;

            @JsonProperty("label")
            public String getLabel() {
                return label;
            }

            @JsonProperty("label")
            public void setLabel(String label) {
                this.label = label;
            }

            @JsonProperty("value")
            public String getValue() {
                return value;
            }

            @JsonProperty("value")
            public void setValue(String value) {
                this.value = value;
            }
        }
    }    */
}


