package com.practica_maps.geocoding_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/*
* Que hace *
- Devuelve un JSON con latitud y longitud estática (por ejemplo, Santiago).
- También tiene un POST para recibir coordenadas (si quieres guardar o usar en backend).
* Sirve para *
- Sirve para pruebas simples y para separar una funcionalidad distinta.
 */

@RestController
@RequestMapping("/api/map")
public class MapController {

    @GetMapping("/location")
    public Map<String, Double> getLocation() {
        return Map.of("lat", -33.4489, "lng", -70.6693);// para hacer pruebas
        // y mostrar un punto fijo y mostrar un marcador por defecto en el mapa(se puede modificar)
    }

    @PostMapping("/location")//para recibir coordenadas que el font o una app le envie al backend
    public ResponseEntity<String> receiveLocation(@RequestBody Map<String, Double> coords) {//recibe un json
        System.out.println("Coordenadas recibidas: " + coords);//imprime en consola lo que recibio
        return ResponseEntity.ok("Coordenadas recibidas con éxito");//devuelve un mensaje de xito
    }
}