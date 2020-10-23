package prw.jws.sfgpetclinic.controllers;

import prw.jws.sfgpetclinic.fauxspring.Model;
import prw.jws.sfgpetclinic.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
