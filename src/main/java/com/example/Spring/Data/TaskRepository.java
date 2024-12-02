package com.example.Spring.Data;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>
{
    @Override
    <S extends Task> S save(S entity);

    @Override
    Optional<Task> findById(Long aLong);

    @Override
    List<Task> findAll();



    @Override
    void deleteById(Long aLong);

}
