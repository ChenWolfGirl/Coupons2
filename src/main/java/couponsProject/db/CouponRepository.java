package couponsProject.db;

import couponsProject.beans.Category;
import couponsProject.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    @Modifying
    @Query(value = "insert into coupons_vs_customers values (:?1,:?2)",nativeQuery = true)
    void addCouponIntoCouponsVsCustomers(int couponId, int customerId);
    List<Coupon> findCouponsByCategory(Category category);
    List<Coupon> findCouponsByPriceLessThan(double maxPrice);
}
