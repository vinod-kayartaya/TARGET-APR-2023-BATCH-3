package com.targetindia.programs;

import com.targetindia.model.*;

public class AnimalDemo {

    public static void main(String[] args) {
        Animal[] animals = {
            new Cat(), // Cat is-a Animal
            new Tiger(), // Tiger is-a Animal
            new Cat(), // Cat is-a Animal
            new Dog(),  // Dog is-a Animal
            // new Car(), // Car is-not-a Animal
        };

        // animals[1].talk(); // this should work at the runtime

        for (Animal a: animals){
            // using "a" we can call methods defined in Animal (and it's superclass)
            a.talk();
            if(a instanceof Tiger){ // "a" references to an object of Tiger
                ((Tiger) a).hunt(); // converting "a" to be a reference of Tiger class
                // Tiger t = (Tiger) a; t.hunt();
            }
        }
    }
}
