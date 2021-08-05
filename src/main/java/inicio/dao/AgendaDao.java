package inicio.dao;

import inicio.model.Contacto;

import java.util.List;

public interface AgendaDao {
    void agregarContacto(Contacto contacto);
    Contacto recuperarContacto(String email);
    void eliminarContacto(String email);
    List<Contacto> devolverContactos();
    void eliminarContactoPorId(int id);
    Contacto recuperarContactoPorId(int id);
    void actualizarContacto(Contacto contacto);
}
