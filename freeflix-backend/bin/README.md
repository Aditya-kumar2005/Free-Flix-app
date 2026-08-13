# FreeFlix

**Legal-first, ad-supported streaming** for public domain and indie films.

## Prerequisites
- Java 17+
- Maven 3.9+
- MongoDB running locally
- FFmpeg for HLS transcoding
- Optional: Nginx to serve `/hls` with good performance

## Run
```bash
mvn spring-boot:run