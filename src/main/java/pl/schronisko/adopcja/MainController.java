package pl.schronisko.adopcja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Controller
public class MainController {
    AnimalsRepository animals;

    public MainController(AnimalsRepository animals) {
        this.animals = animals;
    }



    @RequestMapping("/")
    public String main(Model model){
        Set<Entry<Long,Animals>> animals = this.animals.getMap();
        model.addAttribute("allAnimals",animals);
        return "animals";
    }

    @GetMapping("/animal")
    public String animal(@RequestParam Long id, Model model){
         Animals animal = this.animals.findbyId(id);
         model.addAttribute("animal",animal);
         return "showInfoAnimal";
    }
    @GetMapping("/add")
    public String addAnimal(Model model){
        model.addAttribute("addAnimal",new Animals());
        return "addAnimal";
    }

    @PostMapping("/addAnimal")
    public String addForm(Animals animal){
        animals.add(animal);
        return "redirect:/";
    }
}
