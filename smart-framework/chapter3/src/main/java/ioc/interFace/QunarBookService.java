package ioc.interFace;

import ioc.impl.BookingService;
import org.springframework.stereotype.Component;

/**
 * Created by wh1te on 2017/11/30.
 */
@Component
public class QunarBookService implements BookingService {
    @Override
    public void bookflight() {
        System.out.println("go by Qunar");
    }
}
