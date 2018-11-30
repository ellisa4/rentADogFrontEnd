package rentADog.ellis.frontEnd.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rentADog.ellis.frontEnd.v1.domain.Client;
import rentADog.ellis.frontEnd.v1.domain.ClientDatabase;

@Controller
public class ClientController {
    private ClientDatabase database = new ClientDatabase();

    @RequestMapping(value = "/addClient", method = RequestMethod.GET)
    public String getAddClient(Model model)
    {
        model.addAttribute("Client", new Client("", "", 6, 2, 1998, "", "", "", "", 0, ""));
        return "addClient";
    }

    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public String postAddClient(@ModelAttribute Client client)
    {
        client.setAge(
                client.getMonthBorn(),
                client.getDayBorn(),
                client.getYearBorn()
        );

        database.addClient(
                client.getFirstName(),
                client.getLastName(),
                client.getMonthBorn(),
                client.getDayBorn(),
                client.getYearBorn(),
                client.getLicenseNum(),
                client.getStreet(),
                client.getCity(),
                client.getState(),
                client.getZipCode(),
                client.getEmail()
        );
        return "addedClient";
    }

    @RequestMapping(value = "/getClient", method = RequestMethod.GET)
    public String getGetDog(Model model)
    {
        model.addAttribute("Client", new Client("", "", 6, 2, 1998, "", "", "", "", 0, ""));
        return "getClient";
    }

    @RequestMapping(value = "/gotClient", method = RequestMethod.GET)
    public String getGotDog(Model model, @RequestParam int idNumber) throws Exception
    {
        Client client = database.getClient(idNumber);
        model.addAttribute(client);

        return "gotClient";
    }
}
