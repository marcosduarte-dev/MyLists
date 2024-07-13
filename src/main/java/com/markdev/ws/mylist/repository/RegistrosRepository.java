package com.markdev.ws.mylist.repository;

import com.markdev.ws.mylist.model.Registros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrosRepository extends JpaRepository<Registros, Long> {
}
