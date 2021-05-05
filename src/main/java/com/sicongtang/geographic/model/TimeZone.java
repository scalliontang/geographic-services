package com.sicongtang.geographic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeZone {

    @JsonProperty("timezone_identifier")
    private String timezoneIdentifier;

    @JsonProperty("timezone_abbr")
    private String timezoneAbbr;

    @JsonProperty("utc_offset_sec")
    private String utcOffset;

    @JsonProperty("is_dst")
    private String isDst;

    public String getTimezoneIdentifier() {
        return timezoneIdentifier;
    }

    public void setTimezoneIdentifier(String timezoneIdentifier) {
        this.timezoneIdentifier = timezoneIdentifier;
    }

    public String getTimezoneAbbr() {
        return timezoneAbbr;
    }

    public void setTimezoneAbbr(String timezoneAbbr) {
        this.timezoneAbbr = timezoneAbbr;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getIsDst() {
        return isDst;
    }

    public void setIsDst(String isDst) {
        this.isDst = isDst;
    }
}
