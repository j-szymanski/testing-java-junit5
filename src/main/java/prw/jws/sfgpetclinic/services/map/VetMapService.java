package prw.jws.sfgpetclinic.services.map;

import prw.jws.sfgpetclinic.model.Speciality;
import prw.jws.sfgpetclinic.model.Vet;
import prw.jws.sfgpetclinic.services.SpecialtyService;
import prw.jws.sfgpetclinic.services.VetService;

import java.util.Set;

import static java.util.Objects.nonNull;

public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if (nonNull(object.getSpecialities()) && object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpecialty = specialtyService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
