package com.morocco.fanPass.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
@Entity
@Table
public class Order {

    enum OrderStatus {Pending, Paid, Cancelled, Refunded};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder ;
    private LocalDateTime orderDate ;
    private double totalAmount ;
    private OrderStatus orderStatus ;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

    public Order(LocalDateTime orderDate, double totalAmount, User user) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.user = user;
        this.orderStatus=OrderStatus.Pending;
    }

    
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setOrderStatus() {
        this.orderStatus = OrderStatus.Cancelled;
    }


}
