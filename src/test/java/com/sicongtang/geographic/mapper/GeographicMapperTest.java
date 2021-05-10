package com.sicongtang.geographic.mapper;

import com.sicongtang.geographic.model.LocationResponse;
import com.sicongtang.geographic.model.TimeZone;
import com.sicongtang.geographic.model.ZipcodeApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeographicMapperTest {
    @Test
    public void testToLocationResponse() {
        ZipcodeApiResponse zipcodeApi = createZipCodeApiResponse();
        LocationResponse response = GeographicMapper.toLocationResponse(zipcodeApi);
        Assertions.assertEquals("08536", response.getZipcode());
        Assertions.assertEquals("Plainsboro", response.getCity());
        Assertions.assertEquals("NJ", response.getState());
        Assertions.assertNull(response.getTimezone());
        zipcodeApi.setTimezone(this.createTimeZone());
        response = GeographicMapper.toLocationResponse(zipcodeApi);
        Assertions.assertEquals("EST", response.getTimezone());
    }

    @Test
    public void testToLocationResponse_null() {
        LocationResponse response = GeographicMapper.toLocationResponse(null);
        Assertions.assertEquals("Unknown", response.getCity());
        Assertions.assertEquals("Unknown", response.getState());
        Assertions.assertEquals("N/A", response.getTimezone());
        Assertions.assertNull(response.getZipcode());
    }

    private ZipcodeApiResponse createZipCodeApiResponse() {
        ZipcodeApiResponse response = new ZipcodeApiResponse();
        response.setZipcode("08536");
        response.setCity("Plainsboro");
        response.setState("NJ");
        return response;
    }

    private TimeZone createTimeZone() {
        TimeZone timeZone = new TimeZone();
        timeZone.setTimezoneAbbr("EST");
        return timeZone;
    }
}
