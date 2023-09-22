package br.com.ada.party.repository;

import br.com.ada.party.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartyRepository extends JpaRepository<Party,Long> {
    Optional<Party> findById(Long id);
}
