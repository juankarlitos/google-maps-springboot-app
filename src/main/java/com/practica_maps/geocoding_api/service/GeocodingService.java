package com.practica_maps.geocoding_api.service;

import com.practica_maps.geocoding_api.model.GeocodingResponse;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

/*
Se encarga de hacer la llamada a la API externa de Google Maps Geocoding.
 **Qué hace:**
-Recibe una dirección como texto.
-Construye la URL para llamar a la API REST de Google Maps Geocoding con tu API Key.
-Realiza la petición HTTP (usando RestTemplate).
-Procesa el JSON que devuelve Google Maps y extrae la latitud y longitud.
-Retorna un objeto GeocodingResponse con los datos. */
@Service
public class GeocodingService {

    // Cambio esto por mi API Key real
    // clave privada que entrega google  para acceder a sus servicios
    //private final String API_KEY = System.getenv("GOOGLE_MAPS_API_KEY");
        private final String API_KEY = "MYKEY";

    public GeocodingResponse getCoordinates(String address) throws JSONException {//devuelve una latitud y longitud
        //se construye la url completa para hacer la consulta HTTP a Google
        //reemplaza espacios por + formato URL valido
        //incliye la clave (API_KEY) como parametro
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                address.replace(" ", "+") + "&key=" + API_KEY;
        // es parte de la convención oficial de la Google Maps Platform. Yo me guié por la documentación
        // oficial de Google para la API de geocodificación, donde se indica que las solicitudes deben
        // enviarse a esa base URL.

        RestTemplate restTemplate = new RestTemplate();//para realizar peticiones, y para consumir APIs REST externas

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        //realiza la peticion HTTP GET a la URL armada anteriormente
        //guarda la respuesta completa en un ResponseEntity(el cuerpo es un JSON en forma de texto)

        JSONObject json = new JSONObject(response.getBody());// convierte el String de respuesta en un objeto
        //Esto permite navegar el JSON fácilmente para extraer datos.

        if (!json.has("results")) {
            throw new RuntimeException("Respuesta inválida del servicio de geocodificación.");
            //Verifica si el JSON tiene el campo results
            //Si no lo tiene, lanza una excepción indicando que la respuesta no es válida.
        }

        JSONArray results = json.getJSONArray("results");//Obtiene el arreglo de resultados (results[]) que devuelve la API de Google.

        if (results.length() == 0) {
            throw new RuntimeException("No se encontraron coordenadas para esa dirección.");
            //Si el arreglo está vacío, significa que Google no pudo encontrar la dirección.
            //Lanza un error controlado.
        }

        JSONObject location = results.getJSONObject(0)//Accede a la estructura del JSON anidado:
                .getJSONObject("geometry")//El primer resultado [0], El objeto geometry
                .getJSONObject("location");//Luego el objeto location que contiene
                                                //"lat": latitud
                                                //"lng": longitud

        double lat = location.getDouble("lat");//Extrae los valores de latitud y longitud del JSON.
        double lng = location.getDouble("lng");

        return new GeocodingResponse(lat, lng);//Crea un nuevo objeto GeocodingResponse con los valores obtenidos.
        //Este objeto será enviado al Controller para devolver al frontend en formato JSON.
    }
}