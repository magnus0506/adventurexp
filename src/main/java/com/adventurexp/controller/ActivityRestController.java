package com.adventurexp.controller;

import com.adventurexp.model.Activity;
import com.adventurexp.model.Booking;
import com.adventurexp.model.Employee;
import com.adventurexp.model.User;
import com.adventurexp.repository.BookingRepository;
import com.adventurexp.repository.ActivityRepository;
import com.adventurexp.repository.EmployeeRepository;
import com.adventurexp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ActivityRestController {

    private final ActivityRepository activityRepository;
    private final BookingRepository bookingRepository;
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    public ActivityRestController(ActivityRepository activityRepository, BookingRepository bookingRepository, EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.bookingRepository = bookingRepository;
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/activities")
    public List<Activity> findAllActivity() {

        return activityRepository.findAll();
    }



    @GetMapping("/booking")
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();

    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }


    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }


    @GetMapping("/activities/{act_id}")
    public ResponseEntity<Activity> findActivityById(@PathVariable Long act_id) {
        Optional<Activity> activity = activityRepository.findById(act_id);
        if (activity.isPresent()) {
            Activity realactivity = activity.get();
            return new ResponseEntity<>(realactivity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/booking/{booking_id}")
    public ResponseEntity<Object> putBooking(@RequestBody Booking booking, @PathVariable Long booking_id){
        Optional<Booking> bookingOptional = bookingRepository.findById(booking_id);
        if (bookingOptional.isEmpty())
            return ResponseEntity.notFound().build();
        booking.setBookingId(booking_id);
        bookingRepository.save(booking);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/booking/{booking_id}")
    public void deleteBooking(@PathVariable Long booking_id){
        bookingRepository.deleteById(booking_id);
    }

    @GetMapping("/booking/{booking_id}")
    public ResponseEntity<Booking> findBookedActivity(@PathVariable Long booking_id) {
        Optional<Booking> booking = bookingRepository.findById(booking_id);
        if (booking.isPresent()) {
            Booking booking1 = booking.get();
            return new ResponseEntity<>(booking1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "/newbooking", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking postBooking(@RequestBody Booking booking) {
        if (booking.getBookingTime() != null
        && booking.getBookingDate() != null
        && booking.getParticipantCount() != 0
        && booking.getParticipantCount() <= 50) {
            return bookingRepository.save(booking);
        }
        return null;
    }

    @PostMapping(value = "/newactivity", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Activity newActivity(@RequestBody Activity activity) {
        return activityRepository.save(activity);
    }


}

