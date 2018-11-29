package rentADog.ellis.frontEnd.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rentADog.ellis.frontEnd.v1.domain.Client;
import rentADog.ellis.frontEnd.v1.domain.ClientDatabase;

@Controller
public class ClientController {
    private ClientDatabase database = new ClientDatabase();

    @RequestMapping(value = "/addClient", method = RequestMethod.GET)
    public String getAddClient(Model model)
    {
        model.addAttribute("Client", new Client("", "", 6, 2, 1998, "", "", "", "", 0));
        return "addClient";
    }

    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public String postAddClient(@ModelAttribute Client client)
    {
        client.setAge(
                client.getMonthBorn(),
                client.getDayBorn(),
                client.getyearBorn()
        );

        database.addClient(
                client.getFirstName(),
                client.getLastName(),
                client.getMonthBorn(),
                client.getDayBorn(),
                client.getyearBorn(),
                client.getLicenseNum(),
                client.getStreet(),
                client.getCity(),
                client.getState(),
                client.getZipCode()
        );
        return "addedClient";
    }
}
