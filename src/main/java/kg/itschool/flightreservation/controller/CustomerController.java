package kg.itschool.flightreservation.controller;

import kg.itschool.flightreservation.model.request.CreateBookingRequest;
import kg.itschool.flightreservation.model.request.CreateCustomerRequest;
import kg.itschool.flightreservation.service.CustomerService;
import kg.itschool.flightreservation.service.impl.CustomerServiceImpl;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerController {

    @NonNull CustomerService customerService; // bean injection

    @PostMapping("/create")
    public ResponseEntity<?> create(@Validated @RequestBody CreateCustomerRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.create(request));
    }

    @GetMapping("/get/{id}") // http://localhost:8000/api/v1/customer/get/
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.getById(id));
    }

}