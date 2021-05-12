package com.sicongtang.geographic.service;


import com.sicongtang.geographic.model.LocationResponse;
import com.sicongtang.geographic.model.TimeZone;
import com.sicongtang.geographic.model.ZipcodeApiResponse;
import com.sicongtang.geographic.model.ZipcodeRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GeographicServiceMockTest {
    @InjectMocks
    private GeographicServiceImpl service;
    @Mock
    private ZipCodeService zipCodeService;

//    @BeforeEach
//    public void setup() {
//        service = new GeographicServiceImpl();
//        zipCodeService = Mockito.mock(ZipCodeService.class);
//        service.setZipCodeService(zipCodeService);
//    }

    @Test
    public void testGetLocation() {
        Mockito.when(zipCodeService.getZipcodeInfo("08536"))
                .thenReturn(createResponse("08536", "Plainsboro", "NJ"));
        LocationResponse response = service.getLocation("08536");
        Assertions.assertNotNull(response);
        Assertions.assertEquals("08536", response.getZipcode());
        Assertions.assertEquals("Plainsboro", response.getCity());
        Assertions.assertEquals("NJ", response.getState());
        Assertions.assertEquals("EST", response.getTimezone());
        Mockito.verify(zipCodeService).getZipcodeInfo("08536");

        //Null output from zipcodeService
        Mockito.when(zipCodeService.getZipcodeInfo("11111")).thenReturn(null);
        response = service.getLocation("11111");
        Assertions.assertNotNull(response);
        Assertions.assertEquals("11111", response.getZipcode());
        Assertions.assertEquals("Unknown", response.getCity());
        Assertions.assertEquals("Unknown", response.getState());
        Assertions.assertEquals("N/A", response.getTimezone());
        Mockito.verify(zipCodeService).getZipcodeInfo("11111");
    }

    @Test
    public void testGetLocation_error() {
        Mockito.when(zipCodeService.getZipcodeInfo("08536")).thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class, () -> service.getLocation("08536"));
    }

    @Test
    public void testGetLocations() {
        ZipcodeRequest request = new ZipcodeRequest();
        request.setZipcodes(new String[] {"08536", "08540", null});
        Mockito.doAnswer(invocation -> {
           String zipcode = invocation.getArgument(0);
           if (zipcode == null) return  null;
           ZipcodeApiResponse zipcodeApiResponse = null;
           switch (zipcode) {
               case "08536" : zipcodeApiResponse = createResponse("08536", "Plainsboro", "NJ"); break;
               case "08540" : zipcodeApiResponse = createResponse("08540", "Princeton", "NJ"); break;
           }
           return zipcodeApiResponse;
        }).when(zipCodeService).getZipcodeInfo(ArgumentMatchers.anyString());
        Mockito.when(zipCodeService.getZipcodeInfo("08536")).thenReturn(createResponse("08536", "Plainsboro", "NJ"));
        Mockito.when(zipCodeService.getZipcodeInfo("08540")).thenReturn(createResponse("08540", "Princeton", "NJ"));
        LocationResponse[] responses = service.getLocations(request);
        Assertions.assertEquals(3, responses.length);
    }

    private ZipcodeApiResponse createResponse(String zipcode, String city, String state) {
        ZipcodeApiResponse response = new ZipcodeApiResponse();
        response.setCity(city);
        response.setZipcode(zipcode);
        response.setState(state);
        response.setTimezone(new TimeZone());
        response.getTimezone().setTimezoneAbbr("EST");
        return response;
    }
}
