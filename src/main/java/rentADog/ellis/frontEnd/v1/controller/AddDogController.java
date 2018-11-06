package rentADog.ellis.frontEnd.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rentADog.ellis.frontEnd.v1.domain.DogDatabase;
import rentADog.ellis.frontEnd.v1.formHandling.addDog;

@Controller
public class AddDogController {
    private DogDatabase database = new DogDatabase();

    @RequestMapping(value = "/addDog", method = RequestMethod.GET)
    public String getAddDog(Model model)
    {
        model.addAttribute("addDog", new addDog());
        return "addDog";
    }

    @RequestMapping(value = "/addDog", method = RequestMethod.POST)
    public String postAddDog(@ModelAttribute addDog dog)
    {
        database.addDog(
                dog.getIdNumber(),
                dog.getName(),
                dog.getGender(),
                dog.getBreed(),
                dog.getAge()
        );
        return "addedDog";
    }

}
