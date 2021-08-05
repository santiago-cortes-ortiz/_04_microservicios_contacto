package inicio.controller;

import inicio.model.Contacto;
import inicio.service.AgendaService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactoController {

    private final AgendaService agendaService;

    public ContactoController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping(value="contactos",produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto> recuperarContactos() {
        return agendaService.litarContactos();
    }
    @GetMapping(value="contactos/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public Contacto recuperarContactos(@PathVariable("id") int id) {
        return agendaService.recuperarContactoPorId(id);
    }

    @PostMapping(value="contactos",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
    public String guardarContacto(@RequestBody Contacto contacto) {
        return String.valueOf(agendaService.agregarContacto(contacto));
    }

    @PutMapping(value="contactos",consumes=MediaType.APPLICATION_JSON_VALUE)
    public void actualizarContacto(@RequestBody Contacto contacto) {
        agendaService.actualizarContacto(contacto);
    }

    @DeleteMapping(value="contactos/{id}")
    public void eliminarPorId(@PathVariable("id") int idContacto) {
        agendaService.eliminarContactoPorId(idContacto);

    }

}
