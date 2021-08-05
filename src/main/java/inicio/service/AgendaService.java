package inicio.service;

import inicio.model.Contacto;

import java.util.List;

public interface AgendaService {
    boolean agregarContacto(Contacto contacto);
    List<Contacto> litarContactos();
    boolean eliminarContactoPorId(int id);
    Contacto recuperarContactoPorId(int id);
    void actualizarContacto(Contacto contacto);
}
