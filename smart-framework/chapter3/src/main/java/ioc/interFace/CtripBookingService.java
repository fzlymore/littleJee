package ioc.interFace;

import ioc.impl.BookingService;

/**
 * Created by wh1te on 2017/11/30.
 */
public class CtripBookingService implements BookingService {
    @Override
    public void bookflight() {
        System.out.println("book fight by Ctrip!");
    }
}
