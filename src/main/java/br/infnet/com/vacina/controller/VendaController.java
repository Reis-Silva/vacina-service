package br.infnet.com.vacina.controller;

import br.infnet.com.vacina.exception.VendaNotFoundException;
import br.infnet.com.vacina.model.Venda;
import br.infnet.com.vacina.payload.ResponsePayLoad;
import br.infnet.com.vacina.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity buscaPorId(@PathVariable Long id) {
        try {
            Venda venda = vendaService.obterPorId(id);

            return ResponseEntity.ok(venda);

        }catch (VendaNotFoundException ex){

            ResponsePayLoad message = ResponsePayLoad.builder().Message("Not Found").dateTime(LocalDateTime.now()).build();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
