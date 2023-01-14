package couponsProject.expiredCoupons;

import couponsProject.beans.Coupon;
import couponsProject.db.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
@Service
public class ExpiredWorker implements Runnable {

    private CouponRepository couponRepository;
    private boolean quit=false;

    public ExpiredWorker(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public void run() {
        //running as long as the stop command hasn't been used
        while (!quit) {
            Calendar now = Calendar.getInstance();
            for (Coupon c : couponRepository.findAll())
                if (c.getEndDate().getTime() <= now.getTimeInMillis())
                    couponRepository.deleteById(c.getId());
            try {
                Thread.sleep(24 * 60 * 60 * 1000);
                //sleep for 24 hours
            } catch (InterruptedException e) {
            }
        }
    }

    public void stop() {
        quit = true;
    }
}
