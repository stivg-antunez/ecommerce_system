package com.eccomerce.system.socket;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class PedidoSocketServer {

    private final List<ClienteSocketHandler> clientes =
            new CopyOnWriteArrayList<>();

    @PostConstruct
    public void iniciarServidor() {

        Thread servidor = new Thread(() -> {

            try {

                ServerSocket serverSocket =
                        new ServerSocket(9000);

                System.out.println(
                        "Socket Server iniciado en puerto 9000"
                );

                while (true) {

                    Socket socket =
                            serverSocket.accept();

                    ClienteSocketHandler cliente =
                            new ClienteSocketHandler(socket);

                    clientes.add(cliente);

                    System.out.println(
                            "Nuevo cliente conectado"
                    );

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        servidor.start();

    }

    public void enviarATodos(String mensaje) {

        clientes.forEach(
                cliente ->
                        cliente.enviarMensaje(mensaje)
        );

    }

}