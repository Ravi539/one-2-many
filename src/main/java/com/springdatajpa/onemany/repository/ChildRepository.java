package com.springdatajpa.onemany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.onemany.entity.Child;
@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

}
