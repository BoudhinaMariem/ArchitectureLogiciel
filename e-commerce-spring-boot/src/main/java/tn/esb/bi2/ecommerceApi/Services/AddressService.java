package tn.esb.bi2.ecommerceApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.bi2.ecommerceApi.Repositories.AddressRepository;

@Service
public class AddressService {
    @Autowired
    //etablir d'une manière automatique les liens avec la classe implementant
    //L'interface AddressRepository pour créer l'instance coté serveur au moment de l'excution.
    private AddressRepository addressRepository;
}
