package com.morocco.fanPass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.morocco.fanPass.entity.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>  {
}
