package com.targetindia.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.targetindia.entity.Shipper;

@Controller
public class ShipperController {

	public ShipperController() {
		System.out.println("ShipperController constructor called");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/api/shippers", produces = "text/html")
	public String home() {
		System.out.println("ShipperController.home() called");
		return "/home.jsp"; // view
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, path = "/api/shippers", produces = "application/json")
	public List<Shipper> handleGetAsJson() {
		List<Shipper> shippers = new ArrayList<>();
		shippers.add(new Shipper(1, "Speedy Express", "(555) 445-1235"));
		shippers.add(new Shipper(2, "Federal Shipping", "(555) 711-9823"));
		return shippers;
	}
}
