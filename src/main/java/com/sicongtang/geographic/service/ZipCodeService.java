package com.sicongtang.geographic.service;

import com.sicongtang.geographic.model.ZipcodeApiResponse;

public interface ZipCodeService {
    public ZipcodeApiResponse getZipcodeInfo(String zipcode);

}
