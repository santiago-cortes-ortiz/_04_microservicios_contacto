package inicio.dao;

import inicio.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AgendaRepository extends JpaRepository<Contacto,Integer> {
    Contacto findByEmail (String email);

    @Transactional
    @Modifying
    @Query("delete from Contacto c where c.email = ?1")
    void eliminarPorEmail(String email);
}
