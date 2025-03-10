package com.morocco.fanPass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.morocco.fanPass.entity.TicketCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long>  {
}
