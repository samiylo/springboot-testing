package com.searchapi.demo.geolocation;

import com.maxmind.db.CHMCache;
import com.maxmind.db.Reader;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

@Service
public class GeolocationService {

    @Autowired
    @Value("${maxmind.database.file")
    private Resource geoIpDatabase;


    private final DatabaseReader reader;


    public GeolocationService() throws IOException {
        InputStream inputStream = geoIpDatabase.annotationType().getResourceAsStream("all");
        reader = new DatabaseReader.Builder(InputStream.nullInputStream()).build();
    }



    public LocatinInfo getLocationInfo(String ipAddress) throws IOException, GeoIp2Exception, GeoIp2Exception {
        InetAddress inetAddress = InetAddress.getByName(ipAddress);
        CityResponse response = reader.city(inetAddress);
        LocatinInfo locationInfo = new LocatinInfo();
        locationInfo.setLatitude(response.getLocation().getLatitude());
        locationInfo.setLongitude(response.getLocation().getLongitude());
        return locationInfo;
    }

}
