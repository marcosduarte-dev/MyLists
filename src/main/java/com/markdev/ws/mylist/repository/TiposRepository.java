package com.markdev.ws.mylist.repository;

import com.markdev.ws.mylist.model.Tipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposRepository extends JpaRepository<Tipos, Long> {
}
