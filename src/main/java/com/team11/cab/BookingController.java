package com.team11.cab;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team11.cab.model.Booking;
import com.team11.cab.model.Facility;
import com.team11.cab.service.BookingService;
import com.team11.cab.service.FacilityService;

@RequestMapping(value = "/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingService bService;
	@Autowired
	private FacilityService facilityService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView bookingPostPage(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("booking");

		// System.out.println(request.getParameter("ftype"));

		mav.addObject("ftype", request.getParameter("ftype"));
		mav.addObject("date", request.getParameter("date"));
		mav.addObject("room", request.getParameter("room"));
		mav.addObject("stime", request.getParameter("stime"));
		mav.addObject("endtime", request.getParameter("endtime"));

		return mav;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView bookingPage() {
		ModelAndView mav = new ModelAndView("booking");

		ArrayList<Facility> facilityList = (ArrayList<Facility>) facilityService.findAllFacilities();
		ArrayList<Facility> fList2 = facilityService.findFacilitiesByFacilityType(1);
		
		System.out.println("--TEST--");
		for (Facility facility : fList2) {
			System.out.println(facility.getFacilityName());
		}

		mav.addObject("facilityList", facilityList);

		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String bookingsList()
	{
		return "booking-list";
	}
	
	
}
