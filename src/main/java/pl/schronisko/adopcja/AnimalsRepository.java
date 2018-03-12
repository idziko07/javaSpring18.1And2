package pl.schronisko.adopcja;


import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AnimalsRepository {
    TreeMap<Long,Animals> animals;



    public AnimalsRepository() {
        animals = new TreeMap<>();
        animals.put(1L,new Animals("Reksio","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ultricies luctus turpis vitae laoreet. Morbi purus nulla, maximus in dictum mollis, lacinia auctor velit. Aliquam facilisis lorem sed magna varius, eu aliquet neque elementum. Suspendisse potenti. Sed lorem sapien, vestibulum in suscipit id, pellentesque vitae odio. Donec sapien enim, ornare ut ligula aliquam, facilisis lacinia nunc. Suspendisse et ","/pies1.jpg"));
        animals.put(2L,new Animals("Fafik","Cras consectetur est quis turpis pellentesque, eu sollicitudin lectus blandit. Sed massa massa, scelerisque a nulla vitae, aliquam euismod magna. Aenean dignissim metus erat","/fafik.jpg"));
        animals.put(3L,new Animals("Kajtek","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ac vehicula est, nec accumsan ipsum. Morbi quis magna porta tellus mattis feugiat.","/kajtek.jpg"));
        animals.put(4L,new Animals("Manier","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ac vehicula est, nec accumsan ipsum. Morbi quis magna porta tellus mattis feugiat.","/manier.jpg"));
    }

   public Set<Map.Entry<Long,Animals>> getMap(){
        Set<Map.Entry<Long,Animals>> entryset = animals.entrySet();
        return entryset;
   }

    public Animals findbyId(Long id){
       return animals.get(id);

    }

    public void add(Animals animal){
        Long id = this.animals.firstKey();
        boolean add = true;
        while (add){
            if (animals.containsKey(id)){
                id++;
            }else{
                animals.put(id,animal);
                add = false;
            }
        }

    }
}
