package com.markdev.ws.mylist.repository;

import com.markdev.ws.mylist.model.ApiConsumida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiConsumidaRepository extends JpaRepository<ApiConsumida, Long> {
}
