package com.morocco.fanPass.service;

import com.morocco.fanPass.dto.OrderDTO;
import com.morocco.fanPass.dto.UserDTO;
import com.morocco.fanPass.entity.Order;
import com.morocco.fanPass.entity.Ticket;
import com.morocco.fanPass.entity.User;
import com.morocco.fanPass.mapper.OrderMapper;
import com.morocco.fanPass.mapper.TicketMapper;
import com.morocco.fanPass.mapper.UserMapper;
import com.morocco.fanPass.repository.OrderRepository;
import com.morocco.fanPass.repository.TicketRepository;
import com.morocco.fanPass.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List; 
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    
    private final TicketRepository ticketRepository;

    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository,
                        UserMapper userMapper, UserRepository userRepository,       
                        TicketMapper ticketMapper,TicketRepository ticketRepository){
       
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<OrderDTO> getMyOrders(){
        return orderRepository.findAll().stream().map(orderMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO creatOrder(Long userId, List<Long> ticketIds, LocalDateTime orderDate){

        UserDTO userDto = userRepository.findById(userId).map(userMapper::toDTO).orElseThrow(() -> new RuntimeException("User not found"));

        List<Ticket> tickets = ticketRepository.findAllById(ticketIds);
        
        if (tickets.isEmpty()) {
            throw new RuntimeException("No valid tickets selected.");
        }

        double totalAmount = tickets.stream().mapToDouble(ticket ->ticket.getTicketCategory().getPrice()).sum();

        User user = userMapper.toEntity(userDto);
        Order order = new Order(orderDate, totalAmount, user);
        order.setTickets(tickets);

        Order orderEntity = orderRepository.save(order);
        return orderMapper.toDTO(orderEntity);
    }

    public OrderDTO CancelOrderByTicketId(Long TicketId){

        List<Order> orders = orderRepository.findAll(); 
        Order orderEntity=null;
        for (Order order : orders) {
            Optional<Ticket> ticketToRemove = order.getTickets().stream().filter(ticket -> ticket.getId().equals(TicketId)).findFirst();

            if (ticketToRemove.isPresent()) {
                order.setOrderStatus();
            }
            
            orderEntity = orderRepository.save(order);
        }
        return orderMapper.toDTO(orderEntity);
    }
    
}
