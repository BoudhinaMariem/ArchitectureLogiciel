package tn.esb.bi2.ecommerceApi.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esb.bi2.ecommerceApi.Services.AddressService;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressServ;
}
