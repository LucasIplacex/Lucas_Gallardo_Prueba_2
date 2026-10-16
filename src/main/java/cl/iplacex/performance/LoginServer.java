
package cl.iplacex.performance;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class LoginServer {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(
                new InetSocketAddress("localhost", 8080), 0);

        server.createContext("/login", LoginServer::handleLogin);
        server.start();

        System.out.println(
                "Servidor de login simulado disponible en http://localhost:8080/login");
    }

    private static void handleLogin(HttpExchange exchange)
            throws IOException {

        if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            exchange.getResponseHeaders().set("Allow", "POST");
            sendResponse(exchange, 405, "{\"error\":\"Metodo no permitido\"}");
            return;
        }

        String body = new String(
                exchange.getRequestBody().readAllBytes(),
                StandardCharsets.UTF_8);

        boolean validCredentials =
                body.contains("\"correo\":\"usuario@empresa.cl\"")
                && body.contains("\"contrasena\":\"Clave123\"");

        if (validCredentials) {
            sendResponse(exchange, 200,
                    "{\"mensaje\":\"Acceso permitido\"}");
        } else {
            sendResponse(exchange, 401,
                    "{\"mensaje\":\"Credenciales invalidas\"}");
        }
    }

    private static void sendResponse(
            HttpExchange exchange, int status, String response)
            throws IOException {

        exchange.getResponseHeaders().set(
                "Content-Type", "application/json; charset=UTF-8");

        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(status, bytes.length);

        try (var output = exchange.getResponseBody()) {
            output.write(bytes);
        }
    }
}
