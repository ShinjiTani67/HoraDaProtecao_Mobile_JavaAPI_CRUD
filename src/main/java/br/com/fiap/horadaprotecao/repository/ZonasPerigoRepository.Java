package br.com.fiap.horadaprotecao.repository;




@Repository
public interface ZonasPerigoRepository extends JpaRepository<ZonasPerigo, ID> {

    List<ZonasPerigo> findById(String Id);

}
