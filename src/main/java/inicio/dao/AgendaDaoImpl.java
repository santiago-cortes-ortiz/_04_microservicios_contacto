package inicio.dao;

import inicio.model.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class AgendaDaoImpl implements AgendaDao {

    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    public void agregarContacto(Contacto contacto) {
        agendaRepository.save(contacto);
    }

    @Override
    public Contacto recuperarContacto(String email) {

        return agendaRepository.findByEmail(email);
    }

    @Override
    public void eliminarContacto(String email) {
        agendaRepository.eliminarPorEmail(email);
    }

    @Override
    public List<Contacto> devolverContactos() {
        return agendaRepository.findAll();
    }

    @Override
    public void eliminarContactoPorId(int id) {
        agendaRepository.deleteById(id);
    }

    @Override
    public Contacto recuperarContactoPorId(int id) {
        return agendaRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
    }

    @Override
    public void actualizarContacto(Contacto contacto) {
        agendaRepository.save(contacto);
    }
}
