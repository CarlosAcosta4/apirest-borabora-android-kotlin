package pe.borabora.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.borabora.entity.RoleEntity;
import pe.borabora.model.RoleEnum;


@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByName(RoleEnum name);
}