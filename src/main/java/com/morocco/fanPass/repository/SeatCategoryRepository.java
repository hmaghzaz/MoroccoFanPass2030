package com.morocco.fanPass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morocco.fanPass.entity.SeatCategory;

@Repository
public interface SeatCategoryRepository extends JpaRepository<SeatCategory, Long>  {
}
