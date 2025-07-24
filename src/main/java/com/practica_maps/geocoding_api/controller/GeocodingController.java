package com.practica_maps.geocoding_api.controller;

import com.practica_maps.geocoding_api.service.GeocodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
** Qué hace **
- Recibe una solicitud HTTP GET con un parámetro address.
- Llama al GeocodingService para obtener lat/lng.
- Devuelve el resultado al cliente (frontend) en formato JSON.
* Sirve Para *
- Permite desacoplar la interfaz web del acceso a servicios externos.
- Controla las rutas HTTP y el manejo de la petición/respuesta. */

@RestController
@RequestMapping("/geocode")
public class GeocodingController {

    @Autowired
    private GeocodingService geocodingService;

    @GetMapping
    public ResponseEntity<?> getCoordinates(@RequestParam String address) throws JSONException {
        return ResponseEntity.ok(geocodingService.getCoordinates(address));
    }
}