package ioc.bean;

import ioc.impl.BookingService;
import ioc.interFace.QunarBookService;

/**
 * Created by wh1te on 2017/11/30.
 */
public class Boss {
    private BookingService bookingService;

    public Boss() {
        this.bookingService = new QunarBookService();
    }

    public BookingService getBookingService(){
        return bookingService;
    }

    public void setBookingService(BookingService bookingService){
        this.bookingService = bookingService;
    }

    public void goSomeWhere (){
        bookingService.bookflight();
    }
}
