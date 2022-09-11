package interfaces;

import usecase.vendor.VendorCreate;
import usecase.vendor.VendorFind;

public interface VendorConfig {
    VendorCreate createVendor();

    VendorFind findVendor();
}
