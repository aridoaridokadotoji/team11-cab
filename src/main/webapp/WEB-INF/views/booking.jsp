<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Make Booking</h3>

<c:if test="${param.bookingSuccess == 'true'}">
	<div class="alert alert-success">
		Booking Successful!
	</div>
</c:if>
<c:if test="${param.bookingSuccess == 'false'}">
	<div class="alert alert-danger">
		Invalid booking.
	</div>
</c:if>

<div class="form-group">
<form:form action="${pageContext.request.contextPath}/booking" method="POST" id="form">
	<div class="row">
		<div class="col-md-4">
			<label>Choose Facility Type</label>
			<select id="typeId" name="typeId" class="form-control" data-validation="required">
				<option value="-1" selected disabled hidden>- Select a Facility Type -</option>
				<c:forEach var="facilityType" items="${ftypes}">
					<option value="${facilityType.typeId}"
						${facilityType.typeId == typeId ? 'selected="selected"' : ''}>
						${facilityType.typeName}</option>
				</c:forEach>
			</select>
			<br>
			<button class="btn btn-default" id="submit" type="submit" value="Load"><i class="fa fa-refresh " style="font-size:20px;" ></i>
			</button>
			<br>
			<label class="hidden">Choose Facility</label>
<%-- 			<label class="${showFacility == true ? '' : 'hidden' }">Choose Facility</label> --%>
			<select id="choose-room" name="facility" class="form-control hidden" data-validation="required">
				<c:forEach var="facility" items="${facilities}">
					<option value="${facility.facilityId}">${facility.facilityName}</option>
				</c:forEach>
			</select>
<%-- 			<select id="choose-room" name="facility" class="form-control ${showFacility == true ? '' : 'hidden' }" data-validation="required"> --%>
<%-- 				<c:forEach var="facility" items="${facilities}"> --%>
<%-- 					<option value="${facility.facilityId}">${facility.facilityName}</option> --%>
<%-- 				</c:forEach> --%>
<!-- 			</select> -->
		</div>
		<div class="row">
		<div class="col-md-4">
			<label>Date</label> <input id="datepicker" name="date" type="text"
				class="form-control datepicker" value="${date}" autocomplete="off" data-validation="required">
<!-- 			<label>Start Time</label> -->
			<input class="timepicker form-control hidden" name="stime" id="starttime" type="text" step=3600 value="${stime}" autocomplete="off" data-validation="required" hidden=true>
<!-- 			<label>End Time</label> -->
			<input class="timepicker form-control hidden" name="endtime" id="endtime" type="text" step=3600 value="${endtime}" autocomplete="off" data-validation="required" hidden=true>
		</div>
		<div class="col-md-4">
		<br>
			<span class="pull-right"><input class="btn btn-primary btn-block" type="submit" name="submit" value="Submit" ${facilitySchedules == null ? 'disabled' : '' }></span>
		</div>
		</div>
	</div>
</form:form>
</div>

<c:if test="${facilitySchedules != null}">
	<p>Click table below to select.</p>
</c:if>


<!-- Generate tables for each facility -->
<c:forEach var="facilitySchedule" items="${facilitySchedules}">
	<h4>${facilitySchedule.facilityName}</h4>
	<div class="container booking-grid">
		<div class="row" data-value="${facilitySchedule.facilityId}">
			<c:forEach var="schedule" items="${facilitySchedule.schedule}">
				<div class="col-sm-2 ${schedule.booked ? 'booked' : ''}">${schedule.slotName}</div>
			</c:forEach>
		</div>
	</div>
</c:forEach>


<script type="text/javascript" src="<c:url value="/js/booking.js" />"></script>
