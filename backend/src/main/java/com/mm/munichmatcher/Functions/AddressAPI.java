package com.mm.munichmatcher.Functions;

import com.opencagedata.jopencage.JOpenCageGeocoder;
import com.opencagedata.jopencage.model.JOpenCageForwardRequest;
import com.opencagedata.jopencage.model.JOpenCageLatLng;
import com.opencagedata.jopencage.model.JOpenCageResponse;
import org.springframework.stereotype.Service;

@Service
public class AddressAPI {

    public JOpenCageLatLng getLonLat(String address) {
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder("f8ee3c3e13544b1c9848c2ed1501424e");
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(address);
        request.setRestrictToCountryCode("DE"); // restrict results to a specific country

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        return response.getFirstPosition(); // get the coordinate pair of the first resul
    }
}
