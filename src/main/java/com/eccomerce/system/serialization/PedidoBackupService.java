package com.eccomerce.system.serialization;

import com.eccomerce.system.model.Pedido;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class PedidoBackupService {

    private static final String RUTA_BACKUP =
            "backups/";

    public void backup(
            Pedido pedido
    ) {

        try {

            File directorio =
                    new File(RUTA_BACKUP);

            if (!directorio.exists()) {

                directorio.mkdirs();

            }

            String archivo =
                    RUTA_BACKUP +
                            "pedido_" +
                            pedido.getId() +
                            ".dat";

            PedidoSerializer.guardar(
                    pedido,
                    archivo
            );

            System.out.println(
                    "Backup creado: " +
                            archivo
            );

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}