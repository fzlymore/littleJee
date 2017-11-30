package ioc.bean;

import ioc.impl.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wh1te on 2017/11/30.
 */
@Component
public class SmartBoss {
    private BookingService bookingService;

    @Autowired
    public void setBookingService(BookingService bookingService){
        this.bookingService = bookingService;
    }

    public BookingService getBookingService(){
        return bookingService;
    }

    public void goSomewhere() {
        bookingService.bookflight();
    }
}
