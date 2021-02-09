package com.tp.dealership.controllers;

import com.tp.dealership.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealerController {

    @Autowired
    DealerService service;


}
