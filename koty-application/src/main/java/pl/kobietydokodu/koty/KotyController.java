package pl.kobietydokodu.koty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kobietydokodu.DAO.KotDAO;
import pl.kobietydokodu.model.Kot;

import java.util.List;

/**
 * Created by Jarek on 2017-01-21.
 */
@Controller
public class KotyController {

    @Autowired
    private KotDAO kotDAO;

    @RequestMapping("/getKoty")
    public List getKoty() {
        return kotDAO.getKoty();
    }

    @RequestMapping("/dodajKota")
    public void dodajKota(Kot kot) {
        kotDAO.dodajKota(kot);
    }

    @RequestMapping("/przedstawSie")
    public String przedstawSie(Integer nrKota) {
        return kotDAO.wezKota(nrKota).przedstawSie();
    }
}
