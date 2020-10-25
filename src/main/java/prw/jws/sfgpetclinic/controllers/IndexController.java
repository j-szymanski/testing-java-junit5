package prw.jws.sfgpetclinic.controllers;

import prw.jws.sfgpetclinic.controllers.exceptions.ValueNotFoundException;

public class IndexController {

    public String index(){
        return "index";
    }

    public String oopsHandler(){

        throw new ValueNotFoundException();
//        return "notimplemented";
    }
}
