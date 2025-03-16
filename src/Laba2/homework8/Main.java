package Laba2.homework8;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("Тузик");
        dog.setAge(3);
        dog.voice();
        dog.setBreed("Мальтипу");
        System.out.println("Порода собаки: " + dog.getBreed());

        Cat cat = new Cat();
        cat.setName("Маркиз");
        cat.setAge(5);
        cat.setTypeFeed("Мокрый");
        cat.voice();
        System.out.println("Тип корма кота: " + cat.getTypeFeed());

        Bird bird = new Bird();
        bird.setName("Даша");
        bird.setAge(1);
        bird.setFlying(true);
        bird.voice();
        System.out.println("Способность летать у птицы: " + bird.isFlying());



    }
}
