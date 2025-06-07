package br.com.fiap.horadaprotecao.service;

import br.com.fiap.horadaprotecao.dto.ZonasPerigoDTO;
import br.com.fiap.horadaprotecao.entity.ZonasPerigo;
import br.com.fiap.horadaprotecao.repository.ZonasPerigoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ZonasPerigoService {

  private final ZonasPerigoRepository repository;

  private ZonasPerigoDTO convertToDTO(ZonasPerigo zonasperigo) {
    ZonasPerigoDTO dto = new ZonasPerigoDTO();
    dto.setId(zonasperigo.getId());
    dto.setNivelRisco(zonasperigo.getNivelRisco());
    dto.setRaioEmKm(zonasperigo.getRaioEmKm());
    return dto;
  }

  private ZonasPerigo convertToEntity(ZonasPerigoDTO dto) {
    ZonasPerigo zonasperigo = new ZonasPerigo();
    zonasperigo.setId(dto.getId());
    zonasperigo.setNivelRisco(dto.getNivelRisco());
    zonasperigo.setRaioEmKm(dto.getRaioEmKm());
    return zonasperigo;
  }

  public ZonasPerigoDTO save(ZonasPerigoDTO zonasperigoDTO) {
    ZonasPerigo zonasperigo = convertToEntity(zonasperigoDTO);

    if (zonasperigo.getId() == null) {
      zonasperigo.setId(java.util.UUID.randomUUID().toString());
    }

    zonasperigo = repository.save(zonasperigo);
    return convertToDTO(zonasperigo);
  }

  public List<ZonasPerigoDTO> getFloodedZone() {
    return repository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
  }

  public void deleteById(String id) {
    repository.deleteById(id);
  }

  public ZonasPerigoDTO findById(String id) {
    return repository.findById(id)
            .map(this::convertToDTO)
            .orElseThrow(() -> new RuntimeException("ZonasPerigo com id " + id + " não encontrado"));
  }

  public List<ZonasPerigoDTO> findByAddressId(String addressId) {
    return repository.findByAddress_Id(addressId).stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
  }
}
