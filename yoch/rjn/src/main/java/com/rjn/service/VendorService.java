package com.rjn.service;
 
import java.util.List;

import com.rjn.model.BusinessEnquiry;
import com.rjn.model.CustomerProfile;
import com.rjn.model.VendorProfile;

public interface VendorService {
    void saveVendorDetails(VendorProfile vendorDetails);
    List<VendorProfile> getAllVendors(int limit, int startingPage);
    VendorProfile getVendor(String vendorID);
    List<CustomerProfile> getCustomerCompany();
    List<CustomerProfile> getAssignedTo(String assignedTo,String vendorID);
    List<BusinessEnquiry> getBusinessEnquiryList(int limit, int startingPage);
    void updateVendorDetails(VendorProfile vendorDetails);
    void updateVerify(String vendorId, boolean isVerified);	
}
 