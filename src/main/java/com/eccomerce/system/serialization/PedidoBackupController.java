package com.eccomerce.system.serialization;

import com.eccomerce.system.model.Pedido;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/backup")
public class PedidoBackupController {

    @GetMapping("/{id}")
    public Pedido restaurar(
            @PathVariable Long id
    ) {

        return PedidoSerializer.leer(
                "backups/pedido_" + id + ".dat"
        );

    }
}