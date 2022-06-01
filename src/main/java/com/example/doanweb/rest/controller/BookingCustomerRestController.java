package com.example.doanweb.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.doanweb.entity.Booking;
import com.example.doanweb.service.BookingContactService;
import com.example.doanweb.service.BookingCustomerService;
import com.example.doanweb.service.dto.BookingContactDTO;
import com.example.doanweb.service.dto.BookingCustomerDTO;
import com.example.doanweb.service.dto.BookingIatDTO;
import com.example.doanweb.service.impl.ServiceService;
import com.example.doanweb.service.sms.SmsRequest;
import com.example.doanweb.service.sms.SmsService;

import java.util.List;

@RestController
public class BookingCustomerRestController {

    @Autowired
    BookingCustomerService bcService;
    
    @Autowired
    BookingContactService bookingContactService;

    @Autowired
    ServiceService serService;

    @Autowired
    SmsService smsService;


    @PostMapping("rest/bookingCus")
    public ResponseEntity<BookingCustomerDTO> AddBookingInfo(@RequestBody BookingCustomerDTO bookingCustomerDTO) {
       bcService.AddInfoBookingCustomer(bookingCustomerDTO);
        String sdt = bookingCustomerDTO.getPhone();
        System.out.println("so dien thoai la :" + sdt);
        SmsRequest smsRequest = new SmsRequest(bookingCustomerDTO.getPhone(),
                "Xin chào " + bookingCustomerDTO.getFullName() + " Yourth Hairs xin thông báo lịch cắt tóc của bạn đã được ghi nhận. Cửa hàng sẽ gọi điện để xác nhận lần cuối, bạn vui lòng để ý điện thoại. Cảm ơn bạn đã lựa chọn dịch vụ của chúng tôi");
       smsService.sendSms(smsRequest);
       return new  ResponseEntity<BookingCustomerDTO>(bookingCustomerDTO,HttpStatus.OK);
    }

    @GetMapping("rest/bookingCusByStylist/{id}")
    public Booking bookingCusByStylist(@PathVariable("id") Integer id) {
        return bcService.bookingStatusIAT(id);
    }


    @GetMapping("rest/bookingIAT")
    public List<BookingIatDTO> bookingIAT(){
        return bcService.bookingIAT();
    }

    @GetMapping("rest/checkBooking/{phone}")
    public Booking checkBooking(@PathVariable("phone") String phone){
        return bcService.checkBookingUCF(phone);
    }
    
    @PostMapping("rest/bookingContact")
    public ResponseEntity<BookingContactDTO> AddBookingInfo(@RequestBody BookingContactDTO bookingContactDTO) {
    	bookingContactService.AddInfoBookingCustomer(bookingContactDTO);
       return new ResponseEntity<BookingContactDTO>(bookingContactDTO,HttpStatus.OK);
    }
}
