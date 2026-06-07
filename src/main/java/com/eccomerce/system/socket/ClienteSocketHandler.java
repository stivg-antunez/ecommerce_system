package com.eccomerce.system.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSocketHandler {

    private final Socket socket;
    private final PrintWriter writer;

    public ClienteSocketHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.writer = new PrintWriter(
                socket.getOutputStream(),
                true
        );
    }

    public void enviarMensaje(String mensaje) {
        writer.println(mensaje);
    }

    public Socket getSocket() {
        return socket;
    }

}