package inicio.service;

import inicio.dao.AgendaDao;
import inicio.model.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private AgendaDao agendaDao;

    @Override
    public void agregarContacto(Contacto contacto) throws Exception {
        if (agendaDao.recuperarContacto(contacto.getEmail()) == null){
            agendaDao.agregarContacto(contacto);
            return;
        }
        throw new Exception("Contacto repetido");
    }

    @Override
    public List<Contacto> litarContactos() {
        return agendaDao.devolverContactos();
    }

    @Override
    public boolean eliminarContactoPorId(int id) {
        if (agendaDao.recuperarContactoPorId(id) != null){
            agendaDao.eliminarContactoPorId(id);
            return true;
        }
        return false;
    }

    @Override
    public Contacto recuperarContactoPorId(int id) {
        return agendaDao.recuperarContactoPorId(id);
    }

    @Override
    public void actualizarContacto(Contacto contacto) {
        if (agendaDao.recuperarContactoPorId(contacto.getIdContacto()) != null){
            agendaDao.actualizarContacto(contacto);
        }
    }
}
