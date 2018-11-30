package rentADog.ellis.frontEnd.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rentADog.ellis.frontEnd.v1.domain.Dog;
import rentADog.ellis.frontEnd.v1.domain.DogDatabase;

import java.util.ArrayList;

@Controller
public class RentalController {
    private DogDatabase database = new DogDatabase();

    @RequestMapping(value = "/rentDog", method = RequestMethod.GET)
    public String getRentDog(Model model)
    {
        ArrayList<Integer> ids = database.getAllIDs();
        Dog[] dogs = new Dog[ids.size()];

        for(int i = 0; i < ids.size(); ++i)
        {
            dogs[i] = database.getDog(ids.get(i));
        }
        model.addAttribute("dogs", dogs);

        return "rentDog";
    }
}
