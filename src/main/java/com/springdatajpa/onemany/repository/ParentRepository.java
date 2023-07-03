package com.springdatajpa.onemany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.onemany.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long>{

}
