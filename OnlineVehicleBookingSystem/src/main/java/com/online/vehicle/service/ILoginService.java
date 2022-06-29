package com.online.vehicle.service;

import com.online.vehicle.model.pojo.LoginRegistration;

public interface ILoginService {
	LoginRegistration validateLogin(String userId,String password);
	String doRegistration(LoginRegistration registration);

}
