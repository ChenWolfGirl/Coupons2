package couponsProject.services;

import couponsProject.beans.Category;
import couponsProject.beans.Company;
import couponsProject.beans.Coupon;
import couponsProject.db.CompanyRepository;
import couponsProject.db.CouponRepository;
import couponsProject.db.CustomerRepository;
import couponsProject.exceptions.DoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService extends ClientService {
    private int id;

    public CompanyService(CustomerRepository customerRepository, CouponRepository couponRepository, CompanyRepository companyRepository) {
        super(customerRepository, couponRepository, companyRepository);
    }


    @Override
    public int login(String email, String password) {
        if (companyRepository.existsByEmailAndPassword(email, password))
            return companyRepository.findIdByEmailAndPassword(email, password);
        return -1;
    }

    public void addCoupon(Coupon coupon) {
        couponRepository.save(coupon);
    }

    public void updateCoupon(Coupon coupon) throws DoesNotExistException {
        if (couponRepository.existsById(coupon.getId()))
            couponRepository.save(coupon);
        else
            throw new DoesNotExistException("coupon doesn't exist");
    }

    public void deleteCoupon(int id) {
        couponRepository.deleteById(id);
    }

    public List<Coupon> getCompanyCoupons() throws DoesNotExistException {
        Company c = companyRepository.findById(id).orElseThrow(() -> new DoesNotExistException("company doesn't exist"));
        return c.getCoupons();
    }

    public List<Coupon> getCompanyCoupons(Category category) throws DoesNotExistException {
        List<Coupon> coups = new ArrayList<>();
        for (Coupon c : companyRepository.findById(id).orElseThrow(() -> new DoesNotExistException("company doesn't exist")).getCoupons())
            if (c.getCategory().equals(category))
                coups.add(c);
        return coups;
    }

    public List<Coupon> getCompanyCoupons(double maxPrice) throws DoesNotExistException {
        List<Coupon> coups = new ArrayList<>();
        for (Coupon c : companyRepository.findById(id).orElseThrow(() -> new DoesNotExistException("company doesn't exist")).getCoupons())
            if (c.getPrice() < maxPrice)
                coups.add(c);
        return coups;
    }

    public Company getCompanyDetails() throws DoesNotExistException {
        return companyRepository.findById(id).orElseThrow(() -> new DoesNotExistException("company doesn't exist"));
    }


}
