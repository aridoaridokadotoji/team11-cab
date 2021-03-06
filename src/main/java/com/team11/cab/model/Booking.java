package com.team11.cab.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "BookingId")
	private int bookingId;
	
	@Column(name="TransDate")
	//, columnDefinition="DATE")
	//@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime transDate;
	@Column(name = "StartDate")
	//@JsonFormat(pattern = "dd::MM::yyyy")
	private LocalDateTime startDateTime;
	@Column(name = "EndDate")
	//@JsonFormat(pattern = "dd::MM::yyyy")
	private LocalDateTime endDateTime;
	
	private String status;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "FacilityId")
	private Facility facility;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "UserId")
	private Member member;

	public Booking() {
		super();
	}

	public int getBookingId() {
		return bookingId;
	}

	@JsonGetter
	public String getEndDateDate() 
	{
		String result;
		if((endDateTime.getMonth().getValue()<10) && (endDateTime.getDayOfMonth()<10))
			result=String.valueOf(endDateTime.getYear())+"-0"+String.valueOf(endDateTime.getMonth().getValue())+"-0"	+ String.valueOf(startDateTime.getDayOfMonth());
		else if(endDateTime.getMonth().getValue()<10)
			result=String.valueOf(endDateTime.getYear())+"-0"+String.valueOf(endDateTime.getMonth().getValue())+"-"	+ String.valueOf(startDateTime.getDayOfMonth());
		else if(endDateTime.getDayOfMonth()<10)
			result=String.valueOf(endDateTime.getYear())+"-"+String.valueOf(endDateTime.getMonth().getValue())+"-0"	+ String.valueOf(startDateTime.getDayOfMonth());
		else
			result=String.valueOf(endDateTime.getYear())+"-"+String.valueOf(endDateTime.getMonth().getValue())+"-"	+ String.valueOf(startDateTime.getDayOfMonth());
		return result;
	}
	
	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	@JsonGetter
	public String getEndTime() 
	{
		String result;
		if(endDateTime.getMinute()<10)
			result=String.valueOf(endDateTime.getHour())+":0"+String.valueOf(endDateTime.getMinute());
		else
			result=String.valueOf(endDateTime.getHour())+":"+String.valueOf(endDateTime.getMinute());
		return result;
		
		
	}
	
	@JsonGetter
	public String getNowDateTime() {
		Date dt= new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm ");
		return dateFormat.format(dt);
		
	}

	public Facility getFacility() {
		return facility;
	}

	@JsonGetter
	public String getfacilityName() 
	{	
		return facility.getFacilityName();
	}

	public Member getMember() {
		return member;
	}

	@JsonGetter
	public String getStartDateDate() 
	{	
		String result;
		if((startDateTime.getMonth().getValue()<10) && (startDateTime.getDayOfMonth()<10))
			result=String.valueOf(startDateTime.getYear())+"-0"+String.valueOf(startDateTime.getMonth().getValue())+"-0"	+ String.valueOf(startDateTime.getDayOfMonth());
		else if(startDateTime.getMonth().getValue()<10)
			result=String.valueOf(startDateTime.getYear())+"-0"+String.valueOf(startDateTime.getMonth().getValue())+"-"	+ String.valueOf(startDateTime.getDayOfMonth());
		else if(startDateTime.getDayOfMonth()<10)
			result=String.valueOf(startDateTime.getYear())+"-"+String.valueOf(startDateTime.getMonth().getValue())+"-0"	+ String.valueOf(startDateTime.getDayOfMonth());
		else
			result=String.valueOf(startDateTime.getYear())+"-"+String.valueOf(startDateTime.getMonth().getValue())+"-"	+ String.valueOf(startDateTime.getDayOfMonth());
		return result;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	@JsonGetter
	public String getStartTime() 
	{
		String result;
		if(startDateTime.getMinute()<10)
			result=String.valueOf(startDateTime.getHour())+":0"+String.valueOf(startDateTime.getMinute());
		else
			result=String.valueOf(startDateTime.getHour())+":"+String.valueOf(startDateTime.getMinute());
		return result;
	}

	public String getStatus() {
		return status;
	}

	public LocalDateTime getTransDate() {
		return transDate;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
	public void setMember(Member member) {
		
		this.member = member;
	}
	
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setTransDate(LocalDateTime transDate) {
		this.transDate = transDate;
	}
	
}