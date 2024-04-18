//package com.example.BookStore.Controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.BookStore.Models.OrderItem;
//import com.example.BookStore.Services.OrderItemService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/orderItems")
//public class OrderItemController {
//    @Autowired
//    private OrderItemService orderItemService;
//
//    @GetMapping
//    public List<OrderItem> getAllOrderItems() {
//        return orderItemService.findAllOrderItems();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
//        return orderItemService.findOrderItemById(id)
//            .map(ResponseEntity::ok)
//            .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
//        return orderItemService.saveOrderItem(orderItem);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItem) {
//        return orderItemService.findOrderItemById(id)
//            .map(existingOrderItem -> {
//                orderItem.setId(id); // Ensure the ID is not changed
//                return ResponseEntity.ok(orderItemService.saveOrderItem(orderItem));
//            })
//            .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
//        return orderItemService.findOrderItemById(id)
//            .map(orderItem -> {
//                orderItemService.deleteOrderItem(id);
//                return ResponseEntity.ok().<Void>build();
//            })
//            .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//}