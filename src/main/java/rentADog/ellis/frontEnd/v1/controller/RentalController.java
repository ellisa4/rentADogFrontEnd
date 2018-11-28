package rentADog.ellis.frontEnd.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rentADog.ellis.frontEnd.v1.domain.ClientDatabase;
import rentADog.ellis.frontEnd.v1.domain.Dog;
import rentADog.ellis.frontEnd.v1.domain.DogDatabase;

import java.util.ArrayList;

@Controller
public class RentalController {
    private DogDatabase database = new DogDatabase();
    private ClientDatabase clientDatabase = new ClientDatabase();

    @RequestMapping(value = "/rentDog", method = RequestMethod.GET)
    public String getRentDog(Model model)
    {
        ArrayList<Integer> ids = database.getAllIDs();
        Dog[] dogs = new Dog[ids.size()];

        for(int i = 0; i < ids.size(); ++i)
        {
            dogs[i] = database.getDog(ids.get(i));
            System.out.println(dogs[i].getIdNumber());
        }
        model.addAttribute("dogs", dogs);

        return "rentDog";
    }

    @RequestMapping(value = "/reserveDog", method = RequestMethod.GET)
    public String getReserveDog(@RequestParam int dogId, @RequestParam int clientId)
    {
        database.changeReserved(
                dogId,
                clientDatabase.getFirstName(clientId),
                false
        );

        return "reserveDog";
    }
}
