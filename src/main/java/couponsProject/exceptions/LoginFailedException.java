package couponsProject.exceptions;

public class LoginFailedException extends Exception{
    public LoginFailedException() {
        super("could not login");
    }
}
