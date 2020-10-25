package prw.jws.sfgpetclinic.fauxspring;

import prw.jws.sfgpetclinic.model.Pet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jerzy Szymanski on 24.10.2020 at 22:55
 */
public class ModelMapImpl implements Model {
    private Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(final String key, final Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(final Object o) {
        //do nothing
    }

    public Map<String, Object> getMap() {
        return map;
    }
}
