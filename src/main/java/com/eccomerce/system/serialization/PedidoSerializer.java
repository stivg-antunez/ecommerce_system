package com.eccomerce.system.serialization;

import com.eccomerce.system.model.Pedido;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PedidoSerializer {

    public static void guardar(
            Pedido pedido,
            String archivo
    ) {

        try (

                ObjectOutputStream out =
                        new ObjectOutputStream(
                                new FileOutputStream(
                                        archivo
                                )
                        )

        ) {

            out.writeObject(pedido);

            System.out.println(
                    "Pedido serializado correctamente"
            );

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static Pedido leer(
            String archivo
    ) {

        try (

                ObjectInputStream in =
                        new ObjectInputStream(
                                new FileInputStream(
                                        archivo
                                )
                        )

        ) {

            return (Pedido) in.readObject();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

}