<%@include file="../header/vendor_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<div class="content" ng-controller="vendorLeadsCtrl">
	<div class="col-md-3" >
		<select name="change" id="change" ng-model="change" ng-change="readLead(change)">
			<option selected value="read">read</option>
			<option value="unread">unread</option>
			<option value="all">all</option>
		</select>
	</div>
	<table id="myTable" class="table table-striped">
		<thead>
			<tr>
				<th>Customer name</th>
				<th>Vendor name</th>
				<th>Phone no</th>
				<th>Hits</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="thisLeads in leadList">
				<td>{{thisLeads.name}}</td>
				<td>{{thisLeads.vendorName}}</td>
				<td>{{thisLeads.mobileNo}}</td>
				<td>{{thisLeads.visitCount}}</td>
				<td>{{thisLeads.vendorStatus}}</td>
				<td><button ng-click="markRead(thisLeads.id)">Mark as Read</button></td>
			</tr>
		</tbody>
	</table>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/vendor_leads.js"></script>