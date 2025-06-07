package br.com.fiap.horadaprotecao.repository;


import br.com.fiap.horadaprotecao.entity.ZonasPerigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZonasPerigoRepository extends JpaRepository<ZonasPerigo, String> {

    Optional<ZonasPerigo> findById(String id);

}
