package com.poly.midware.api.alimail;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @PostMapping("/createAccounts")
    public String createAccounts(){

        return "createAccounts";
    }

}
