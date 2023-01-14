package couponsProject;

import couponsProject.beans.Category;
import couponsProject.beans.Company;
import couponsProject.beans.Coupon;
import couponsProject.beans.Customer;
import couponsProject.exceptions.DoesNotExistException;
import couponsProject.exceptions.LoginFailedException;
import couponsProject.expiredCoupons.ExpiredWorker;
import couponsProject.loginManager.ClientType;
import couponsProject.loginManager.LoginManager;
import couponsProject.services.AdminService;
import couponsProject.services.CompanyService;
import couponsProject.services.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class Coupons2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(Coupons2Application.class, args);

		AdminService adminService=ctx.getBean(AdminService.class);
		CompanyService companyService=ctx.getBean(CompanyService.class);
		CustomerService customerService=ctx.getBean(CustomerService.class);
		ExpiredWorker dailyCouponCheck = ctx.getBean(ExpiredWorker.class);
		LoginManager loginManager=ctx.getBean(LoginManager.class);
//		dailyCouponCheck.run();
		// expired coupon tester ^



//								*********************    ADMIN TESTS ********************
//
//		initial test to see if logging in works(returns 1=logged in):
//		System.out.println(adminFacade.login("admin@admin.com","admin"));



//		try {
//			AdminService admin= loginManager.login("admin@admin.com","admin", ClientType.ADMIN);
//		} catch (LoginFailedException e) {
//			System.out.println(e.getMessage());
//		}
//
//
//
//		adding a new company:
//		Company comp=new Company("com2","com2@com","password");
//		adminService.addCompany(comp);
//
//
//
//		get a single company and print its name :
//		try {
//			Company c=adminService.getOneCompany(1);
//			System.out.println(c.getName());
//		} catch (DoesNotExistException e) {
//			System.out.println(e.getMessage());
//		}
//
//
//		add a new customer :
//		Customer cust=new Customer("first","last","cust@com","password");
//		adminService.addCustomer(cust);
//




//		get a single customer and print their first name :
//		try {
//			Customer c1=adminService.getOneCustomer(1);
//			System.out.println(c1.getFname());
//		} catch (DoesNotExistException e) {
//			System.out.println(e.getMessage());
//		}

//
//		returns a list of all the companies and prints their emails :
//		List<Company> compies=adminService.getAllCompanies();
//		for(Company c:compies)
//			System.out.println(c.getEmail());
//
//
//
//		returns a list of all customers and prints their first name :
//		List<Customer> custies=adminService.getAllCustomers();
//		for(Customer c:custies)
//			System.out.println(c.getFname());
//
//
//		updates company with id 1's password:
//		try {
//			Company compa=adminService.getOneCompany(1);
//			compa.setPassword("1234");
//			adminService.updateCompany(compa);
//		} catch (DoesNotExistException e) {
//			System.out.println(e.getMessage());
//		}
//
//
//
//
//		updates customer with id 1's last name to poopoo:
//		try {
//			Customer custo = adminService.getOneCustomer(1);
//			custo.setLname("poopoo");
//			adminService.updateCustomer(custo);
//		}catch (DoesNotExistException e){
//			System.out.println(e.getMessage());
//		}


//		deletes company with the id 1
//		adminService.deleteCompany(1);


//		deletes customer with id 1:
//		adminService.deleteCustomer(1);



//								*********************    COMPANY TESTS ********************


//		try {
//			loginManager.login("","",ClientType.COMPANY);
//		} catch (LoginFailedException e) {
//			System.out.println(e.getMessage());
//		}


		// adds a new coupon to company
//		try {
//			Company c1 = adminService.getOneCompany(1);
//			Date now= new Date(1111);
//			Coupon coup = new Coupon(c1,12,Category.Food,"food coup","food coupon for ur needs","food.png", now,now, 12.5);
//			companyService.addCoupon(coup);
//		}catch (DoesNotExistException e){
//			System.out.println(e.getMessage());
//		}

		//updates the first coupon of a company
//		try {
//			Coupon c=companyService.getCompanyCoupons().get(1);
//			c.setAmount(14);
//			companyService.updateCoupon(c);
//
//		} catch (DoesNotExistException e) {
//			System.out.println(e.getMessage());
//		}

		// returns information about the company
//		try {
//			companyService.getCompanyDetails();
//		} catch (DoesNotExistException e) {
//			System.out.println(e.getMessage());
//		}



		// returns company's coupons below max price of 1500
//		try {
//			companyService.getCompanyCoupons(1500);
//		} catch (DoesNotExistException e) {
//			System.out.println(e.getMessage());
//		}


		// returns company coupons of category food
//		try {
//			companyService.getCompanyCoupons(Category.Food);
//		} catch (DoesNotExistException e) {
//			System.out.println(e.getMessage());
//		}


		// returns company coupons
//		try {
//			companyService.getCompanyCoupons();
//		} catch (DoesNotExistException e) {
//			System.out.println(e.getMessage());
//		}


		// deletes company coupon with id 1
//		companyService.deleteCoupon(1);





//
//								*********************    CUSTOMER TESTS ********************


//		try {
//			loginManager.login("","",ClientType.CUSTOMER);
//		} catch (LoginFailedException e) {
//			System.out.println(e.getMessage());
//		}


		//returns the list of coupons belonging to the customer and prints their amount
//		try {
//			List<Coupon> cou=customerService.getCustomerCoupons();
//			for(Coupon c:cou)
//				System.out.println(c.getAmount());
//		} catch (DoesNotExistException e) {
//			System.out.println(e.getMessage());
//		}


		//returns a list of all coupons of a customer below the price 1500 and shows their description
//		List<Coupon> coop=customerService.getCustomerCoupons(1500);
//		for(Coupon c:coop)
//			System.out.println(c.getDescription());



		//returns a list of a customer with the category "food" and shows their price
//		List<Coupon>cooooop=customerService.getCustomerCoupons(Category.Food);
//		for (Coupon c:cooooop)
//			System.out.println(c.getPrice());


		//returns the customer's details
//		try {
//			System.out.println(customerService.getCustomerDetails());
//		} catch (DoesNotExistException e) {
//			System.out.println(e.getMessage());
//		}


		//adds a purchase to a customer
//		try {
//			customerService.purchaseCoupon(companyService.getCompanyCoupons().get(1));
//		} catch (DoesNotExistException e) {
//			System.out.println(e.getMessage());
//		}


		//stops the expired checker so program can end
//		dailyCouponCheck.stop();
	}
}
