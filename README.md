
Google Maps Spring Boot App
Aplicación desarrollada con Java Spring Boot que se integra con Google Maps JavaScript API y Geocoding API para mostrar en un mapa la ubicación geográfica de una dirección.

## Características
Consulta coordenadas (latitud y longitud) a partir de una dirección.

Muestra el resultado en un mapa interactivo de Google Maps.

Backend en Java con Spring Boot que consume la API de Geocoding.

Frontend HTML usando Google Maps JavaScript API.

## Tecnologías
Java 17
Spring Boot 3.x
Google Maps JavaScript API
Google Geocoding API
HTML + JavaScript
RestTemplate
JSON (org.json)
Maven

## ¿Cómo ejecutar el proyecto?
 ### Clona el repositorio:

git clone https://github.com/TU_USUARIO/google-maps-springboot-app.git
Abre el proyecto en IntelliJ IDEA o tu IDE favorito.

### Configura tu clave API de Google Maps:

Puedes colocar la clave directamente en la clase GeocodingService.java:

private final String API_KEY = "TU_CLAVE_AQUI";
Pero recomendamos usar variable de entorno para mayor seguridad (ver sección siguiente).

### Ejecuta la aplicación:
./mvnw spring-boot:run

###  Abre en tu navegador:
http://localhost:9099/index.html


## Configuración de la clave API de Google Maps
Para que el proyecto funcione correctamente, necesitas una API Key de Google Maps con estas APIs habilitadas:

✅ Geocoding API  
✅ Maps JavaScript API  

## Cómo configurar la clave sin exponerla
Este proyecto utiliza una variable de entorno llamada GOOGLE_MAPS_API_KEY para mantener la clave segura.

## Pasos para configurarla:

### En Linux o macOS:

export GOOGLE_MAPS_API_KEY=tu_clave_real

### En Windows (CMD):
set GOOGLE_MAPS_API_KEY=tu_clave_real

### En Windows (PowerShell):

$env:GOOGLE_MAPS_API_KEY="tu_clave_real"
💡 Reemplaza tu_clave_real por la clave API que obtuviste desde Google Cloud Console.

## ¿Dónde se usa esta variable?  
### En el backend, en la clase GeocodingService: 

private final String API_KEY = System.getenv("GOOGLE_MAPS_API_KEY");
En el frontend (HTML), reemplaza la clave directamente en el script de Google Maps, o utiliza alguna estrategia para inyectarla desde el backend (en desarrollo puedes dejarla fija).

### Ejemplo
## Dirección usada en el ejemplo:

Vicuña Mackenna 12500, La Florida, Santiago, Chile

### Resultado
Mapa con marcador en la ubicación solicitada.
Coordenadas obtenidas mediante la API de geocodificación.

### Cómo obtener tu clave API  
 ## Para usar Google Maps debes:  

Crear un proyecto en Google Cloud Console. 
Habilitar la Geocoding API y la Maps JavaScript API. 
Obtener una API Key. 
Insertarla en el backend (GeocodingService.java) o configurarla como variable de entorno.

## Autor 
Desarrollado por Juan Carlos Inostroza 👨‍💻
