package rentADog.ellis.frontEnd.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import rentADog.ellis.frontEnd.v1.domain.Dog;
import rentADog.ellis.frontEnd.v1.domain.DogDatabase;
import java.sql.Blob;
import java.sql.SQLException;

@Controller
public class AddDogController {

    private DogDatabase database = new DogDatabase();

    @RequestMapping(value = "/addDog", method = RequestMethod.GET)
    public String getAddDog(Model model)
    {
        model.addAttribute("Dog", new Dog(0, "", "", "", 0, null));
        return "addDog";
    }

    @RequestMapping(value = "/addDog", method = RequestMethod.POST)
    public String postAddDog(@ModelAttribute Dog dog)
    {
        database.addDog(
                dog.getIdNumber(),
                dog.getName(),
                dog.getGender(),
                dog.getBreed(),
                dog.getAge(),
                dog.getImage()
        );


        return "addedDog";
    }

}
