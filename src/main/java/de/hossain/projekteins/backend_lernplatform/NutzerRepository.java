package de.hossain.projekteins.backend_lernplatform;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutzerRepository extends CrudRepository<Nutzer, String> {

}
