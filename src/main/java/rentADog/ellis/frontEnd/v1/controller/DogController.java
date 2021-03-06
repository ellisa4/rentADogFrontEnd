package rentADog.ellis.frontEnd.v1.controller;

import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import rentADog.ellis.frontEnd.v1.domain.Dog;
import rentADog.ellis.frontEnd.v1.domain.DogDatabase;

@Controller
public class DogController {

    private DogDatabase database = new DogDatabase();

    @RequestMapping(value = "/addDog", method = RequestMethod.GET)
    public String getAddDog(Model model)
    {
        model.addAttribute("Dog", new Dog(0, "", "", "", 0, null, false));
        return "addDog";
    }

    @RequestMapping(value = "/addDog", method = RequestMethod.POST)
    public String postAddDog(@ModelAttribute Dog dog, @RequestParam("picturesIn")MultipartFile pictureIn) throws IOException
    {
        InputStream inputStream = new BufferedInputStream(pictureIn.getInputStream());

        int i;
        int size = 0;
        while ((i = inputStream.read()) != -1)
        {

            System.out.println((byte)i);
            size++;
        }

        System.out.println("size: "+ size);
        byte[] temp = new byte[size];
        size=0;

        while ((i = inputStream.read()) != -1)
        {
            temp[size] = (byte)i;
            size++;
        }
        dog.setImage(temp);

            database.addDog(
                    dog.getIdNumber(),
                    dog.getName(),
                    dog.getGender(),
                    dog.getBreed(),
                    dog.getAge(),
                    dog.getImage(),
                    dog.getAvailable()
            );


        return "addedDog";
    }

    @RequestMapping(value = "/getDog", method = RequestMethod.GET)
    public String getGetDog(Model model)
    {
        model.addAttribute("dog", new Dog(0, "", "", "", 0, null, false));
        return "getDog";
    }

    @RequestMapping(value = "/gotDog", method = RequestMethod.GET)
    public String getGotDog(Model model, @RequestParam int idNumber) throws Exception
    {
        Dog dog = database.getDog(idNumber);
        ByteArrayInputStream stream = new ByteArrayInputStream(dog.getImage());
        System.out.println(stream);

        int i = 0;
        byte[] in = dog.getImage();
        while(i < in.length)
        {
            System.out.println(in[i]);
            ++i;
        }

        BufferedImage image = ImageIO.read(stream);
        /**
        ImageIO.write(image, "jpg", new File("image.jpg"));
         **/
        model.addAttribute(dog);
        return "gotDog";
    }

    @RequestMapping(value = "/allDogs", method = RequestMethod.GET)
    public String getAllDogs(Model model)
    {
        ArrayList<Integer> ids = database.getAllIDs();
        System.out.println(ids.size());
        Dog[] dogs = new Dog[ids.size()];

        for(int i = 0; i < ids.size(); ++i)
        {
            dogs[i] = database.getDog(ids.get(i));
            System.out.println(dogs[i].getIdNumber());
        }
        model.addAttribute("dogs", dogs);

        return "getAllDogs";
    }

}
