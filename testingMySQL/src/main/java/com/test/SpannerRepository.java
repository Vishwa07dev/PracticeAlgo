package com.test;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpannerRepository extends JpaRepository<Spanners, Long>{

}
