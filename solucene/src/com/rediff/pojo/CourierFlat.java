package com.rediff.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "track")
public class CourierFlat implements Serializable {

	private static final long serialVersionUID = 1L;

	// basic
	private String logisticprovider;
	private String airwaybillnumber;
	private String deliverystatus;
	private String rtostate;
	private String redirect;
	private String newawbill;
	private String newlogisticprovider;

	// origin
	private String sendername;
	private String origindate;
	private String originaddress;
	private String origincity;
	private String originstate;
	private String originpincode;
	private String originlocation;

	// destination
	private String receivername;
	private String destinationdate;
	private String destinationaddress;
	private String destinationcity;
	private String destinationstate;
	private String destinationpincode;
	private String destinationlocation;

	// Events
	private String transitaction;
	private String transitorigin;
	private String transitdestination;
	private String transitdate;
	private String status;
	private String transitlocation;
	private String remark;
	private String logisticprovider_awb;

	// original field
	private String original_status;

	// offline field
	private String offline_response;
	private String offline_reason;

	// error field
	private String error_code;
	private String error_message;

	public String getAirwaybillnumber() {
		return airwaybillnumber;
	}

	public String getDeliverystatus() {
		return deliverystatus;
	}

	public String getDestinationaddress() {
		return destinationaddress;
	}

	public String getDestinationcity() {
		return destinationcity;
	}

	public String getDestinationdate() {
		return destinationdate;
	}

	public String getDestinationlocation() {
		return destinationlocation;
	}

	public String getDestinationpincode() {
		return destinationpincode;
	}

	public String getDestinationstate() {
		return destinationstate;
	}

	public String getError_code() {
		return error_code;
	}

	public String getError_message() {
		return error_message;
	}

	public String getLogisticprovider() {
		return logisticprovider;
	}

	public String getLogisticprovider_awb() {
		return logisticprovider_awb;
	}

	public String getOffline_reason() {
		return offline_reason;
	}

	public String getOffline_response() {
		return offline_response;
	}

	public String getOriginaddress() {
		return originaddress;
	}

	public String getOriginal_status() {
		return original_status;
	}

	public String getOrigincity() {
		return origincity;
	}

	public String getOrigindate() {
		return origindate;
	}

	public String getOriginlocation() {
		return originlocation;
	}

	public String getOriginpincode() {
		return originpincode;
	}

	public String getOriginstate() {
		return originstate;
	}

	public String getReceivername() {
		return receivername;
	}

	public String getRemark() {
		return remark;
	}

	public String getRtostate() {
		return rtostate;
	}

	public String getSendername() {
		return sendername;
	}

	public String getStatus() {
		return status;
	}

	public String getTransitaction() {
		return transitaction;
	}

	public String getTransitdate() {
		return transitdate;
	}

	public String getTransitdestination() {
		return transitdestination;
	}

	public String getTransitlocation() {
		return transitlocation;
	}

	public String getTransitorigin() {
		return transitorigin;
	}

	public void setAirwaybillnumber(String airwaybillnumber) {
		this.airwaybillnumber = airwaybillnumber;
	}

	public void setDeliverystatus(String deliverystatus) {
		this.deliverystatus = deliverystatus;
	}

	public void setDestinationaddress(String destinationaddress) {
		this.destinationaddress = destinationaddress;
	}

	public void setDestinationcity(String destinationcity) {
		this.destinationcity = destinationcity;
	}

	public void setDestinationdate(String destinationdate) {
		this.destinationdate = destinationdate;
	}

	public void setDestinationlocation(String destinationlocation) {
		this.destinationlocation = destinationlocation;
	}

	public void setDestinationpincode(String destinationpincode) {
		this.destinationpincode = destinationpincode;
	}

	public void setDestinationstate(String destinationstate) {
		this.destinationstate = destinationstate;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public void setLogisticprovider(String logisticprovider) {
		this.logisticprovider = logisticprovider;
	}

	public void setLogisticprovider_awb(String logisticprovider_awb) {
		this.logisticprovider_awb = logisticprovider_awb;
	}

	public void setOffline_reason(String offline_reason) {
		this.offline_reason = offline_reason;
	}

	public void setOffline_response(String offline_response) {
		this.offline_response = offline_response;
	}

	public void setOriginaddress(String originaddress) {
		this.originaddress = originaddress;
	}

	public void setOriginal_status(String original_status) {
		this.original_status = original_status;
	}

	public void setOrigincity(String origincity) {
		this.origincity = origincity;
	}

	public void setOrigindate(String origindate) {
		this.origindate = origindate;
	}

	public void setOriginlocation(String originlocation) {
		this.originlocation = originlocation;
	}

	public void setOriginpincode(String originpincode) {
		this.originpincode = originpincode;
	}

	public void setOriginstate(String originstate) {
		this.originstate = originstate;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setRtostate(String rtostate) {
		this.rtostate = rtostate;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTransitaction(String transitaction) {
		this.transitaction = transitaction;
	}

	public void setTransitdate(String transitdate) {
		this.transitdate = transitdate;
	}

	public void setTransitdestination(String transitdestination) {
		this.transitdestination = transitdestination;
	}

	public void setTransitlocation(String transitlocation) {
		this.transitlocation = transitlocation;
	}

	public void setTransitorigin(String transitorigin) {
		this.transitorigin = transitorigin;
	}

	public String getNewawbill() {
		return newawbill;
	}

	public void setNewawbill(String newawbill) {
		this.newawbill = newawbill;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public String getNewlogisticprovider() {
		return newlogisticprovider;
	}

	public void setNewlogisticprovider(String newlogisticprovider) {
		this.newlogisticprovider = newlogisticprovider;
	}

}
