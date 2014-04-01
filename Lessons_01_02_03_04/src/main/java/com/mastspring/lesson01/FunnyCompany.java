package com.mastspring.lesson01;

public class FunnyCompany {
	private CanteenService canteenService;
	private SecurityService securityService;
	
	FunnyCompany() {}
	
	public FunnyCompany(CanteenService canteenService, SecurityService secService) {
		this.canteenService = canteenService;
		this.securityService = secService;
	}
	
	public void setCanteenService(CanteenService canteenService) {
		this.canteenService = canteenService;
	}
	public void setSecService(SecurityService secService) {
		this.securityService = secService;
	}
	
	public String toString() {
		return securityService + " , " + canteenService;
	}	
}

class CanteenService {
	private String canteenName;
	CanteenService(String canteenName) {
		this.canteenName = canteenName;
	}
	
	public String toString() {
		return "Your lunch will be at : " + canteenName;
	}
}

class SecurityService {
	public String typeOfSecurity;
	SecurityService(String typeOfSec) {
		this.typeOfSecurity = typeOfSec;
	}
}

class FingerPrintService extends SecurityService {
	private String scanMachineName;
	
	FingerPrintService(String typeOfSecurity, String scannerMachineName) {
		super(typeOfSecurity);
		this.scanMachineName = scannerMachineName;
	}
	
	public String toString() {
		return "You will be scanned by : \"" + scanMachineName + "\" for \"" + typeOfSecurity + "\" checks";
	}
}