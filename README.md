
Google Maps Spring Boot App
Aplicación desarrollada con Java Spring Boot que se integra con Google Maps JavaScript API y Geocoding API para mostrar en un mapa la ubicación geográfica de una dirección.

Características
Consulta coordenadas (latitud y longitud) a partir de una dirección.
Muestra el resultado en un mapa interactivo de Google Maps.
Backend en Java con Spring Boot que consume la API de Geocoding.
Frontend HTML usando Google Maps JavaScript API.
Tecnologías
Java 17
Spring Boot 3.x
Google Maps JavaScript API
Google Geocoding API
HTML + JavaScript
RestTemplate
JSON (org.json)
Maven
¿Cómo ejecutar el proyecto?
Clona el repositorio:
git clone https://github.com/TU_USUARIO/google-maps-springboot-app.git Abre el proyecto en IntelliJ IDEA o tu IDE favorito.
=======
# Google Maps Spring Boot App

Aplicación desarrollada con **Java Spring Boot** que se integra con **Google Maps JavaScript API** y **Geocoding API** para mostrar en un mapa la ubicación geográfica de una dirección.

## Características

- Consulta coordenadas (latitud y longitud) a partir de una dirección.
- Muestra el resultado en un mapa interactivo de Google Maps.
- Backend en Java con Spring Boot que consume la API de Geocoding.
- Frontend HTML usando Google Maps JavaScript API.

## Tecnologías

- Java 17  
- Spring Boot 3.x  
- Google Maps JavaScript API  
- Google Geocoding API  
- HTML + JavaScript  
- RestTemplate  
- JSON (org.json)  
- Maven  

## ¿Cómo ejecutar el proyecto?

1. Clona el repositorio:

git clone https://github.com/TU_USUARIO/google-maps-springboot-app.git
Abre el proyecto en IntelliJ IDEA o tu IDE favorito.


Configura la clave de API en GeocodingService.java o, preferiblemente, usando una variable de entorno (ver sección siguiente).

Ejecuta la aplicación con:


./mvnw spring-boot:run Abre el navegador en http://localhost:9099/index.html

Configuración de la clave API de Google Maps Para que el proyecto funcione correctamente, necesitas una API Key de Google Maps con las siguientes APIs habilitadas:

./mvnw spring-boot:run
Abre el navegador en http://localhost:9099/index.html

Configuración de la clave API de Google Maps
Para que el proyecto funcione correctamente, necesitas una API Key de Google Maps con las siguientes APIs habilitadas:


✅ Geocoding API

✅ Maps JavaScript API


Cómo configurar la clave sin exponerla Este proyecto usa una variable de entorno llamada GOOGLE_MAPS_API_KEY para mantener la clave segura.

Pasos para configurarla: En Linux o macOS:

export GOOGLE_MAPS_API_KEY=tu_clave_real En Windows (CMD):

set GOOGLE_MAPS_API_KEY=tu_clave_real En Windows (PowerShell):

$env:GOOGLE_MAPS_API_KEY="tu_clave_real" 💡 Reemplaza tu_clave_real por tu clave API real obtenida desde Google Cloud Console.

¿Dónde se usa esta variable? En el backend, en esta línea de código:

private final String API_KEY = System.getenv("GOOGLE_MAPS_API_KEY"); En el frontend (HTML), asegúrate de reemplazar la clave directamente o usar alguna estrategia si el frontend es servido desde el backend (en desarrollo se puede dejar fija).

Ejemplo Dirección usada en el ejemplo:

Vicuña Mackenna 12500, La Florida, Santiago, Chile Resultado:

Cómo configurar la clave sin exponerla
Este proyecto usa una variable de entorno llamada GOOGLE_MAPS_API_KEY para mantener la clave segura.

Pasos para configurarla:
En Linux o macOS:

export GOOGLE_MAPS_API_KEY=tu_clave_real
En Windows (CMD):

set GOOGLE_MAPS_API_KEY=tu_clave_real
En Windows (PowerShell):

$env:GOOGLE_MAPS_API_KEY="tu_clave_real"
💡 Reemplaza tu_clave_real por tu clave API real obtenida desde Google Cloud Console.

¿Dónde se usa esta variable?
En el backend, en esta línea de código:


private final String API_KEY = System.getenv("GOOGLE_MAPS_API_KEY");
En el frontend (HTML), asegúrate de reemplazar la clave directamente o usar alguna estrategia si el frontend es servido desde el backend (en desarrollo se puede dejar fija).

Ejemplo
Dirección usada en el ejemplo:


Vicuña Mackenna 12500, La Florida, Santiago, Chile
Resultado:


Mapa con marcador en la ubicación.

Coordenadas obtenidas mediante la API de geocodificación.


Clave de API Para usar Google Maps debes:

Clave de API
Para usar Google Maps debes:


Crear un proyecto en Google Cloud Console.

Habilitar la Geocoding API y la Maps JavaScript API.

Obtener una API Key.

Insertarla en el backend (GeocodingService.java) o configurarla como variable de entorno.


Autor Desarrollado por Juan Carlos Inostroza 👨‍💻

Autor
Desarrollado por Juan Carlos Inostroza 👨‍💻

