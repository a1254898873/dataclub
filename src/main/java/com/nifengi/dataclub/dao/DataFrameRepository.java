package com.nifengi.dataclub.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataFrameRepository extends JpaRepository<DataFrame,Long> {


}
