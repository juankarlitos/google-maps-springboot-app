package com.practica_maps.geocoding_api.model;

/*
Sirve para modelar la respuesta que tu backend devuelve cuando haces la consulta de geocodificación
 (es decir, convertir una dirección en latitud y longitud).
 **Qué hace**
 Guarda sólo dos datos: lat y lng (latitud y longitud).
 Tiene constructor y getters para que Spring Boot pueda convertirla automáticamente a JSON
  al devolverla en la respuesta HTTP.
 */
public class GeocodingResponse {

    private double lat;
    private double lng;

    public GeocodingResponse(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}