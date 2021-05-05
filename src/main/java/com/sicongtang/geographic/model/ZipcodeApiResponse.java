package com.sicongtang.geographic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZipcodeApiResponse {

    @JsonProperty("zip_code")
    private String zipcode;

    @JsonProperty("lat")
    private String latitude;

    @JsonProperty("lng")
    private String longitude;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("timezone")
    private TimeZone timezone;

    @JsonProperty("acceptable_city_names")
    private CityStateInfo[] acceptableCities;

    @JsonProperty("area_codes")
    private String[] areaCodes;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public void setTimezone(TimeZone timezone) {
        this.timezone = timezone;
    }

    public CityStateInfo[] getAcceptableCities() {
        return acceptableCities;
    }

    public void setAcceptableCities(CityStateInfo[] acceptableCities) {
        this.acceptableCities = acceptableCities;
    }

    public String[] getAreaCodes() {
        return areaCodes;
    }

    public void setAreaCodes(String[] areaCodes) {
        this.areaCodes = areaCodes;
    }
}
