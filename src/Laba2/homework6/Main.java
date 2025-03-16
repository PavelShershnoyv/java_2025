package Laba2.homework6;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        System.out.println("Площадь круга с радиусом (" + circle.getRadius() + ") равна: " + circle.getArea());
        System.out.println("Периметр круга с радиусом (" + circle.getRadius() + ") равен: " + circle.getPerimeter());

        Square square = new Square(4);
        System.out.println("Площадь квадрата со стороной (" + square.getSide() + ") равна: " + square.getArea());
        System.out.println("Периметр квадрата со стороной (" + square.getSide() + ") равен: " + square.getPerimeter());

        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("Площадь треугольника со сторонами (" + triangle.getA() + ", " + triangle.getB() + ", "
                + triangle.getC() + ") равна: " + triangle.getArea());
        System.out.println("Периметр треугольника со сторонами (" + triangle.getA() + ", " + triangle.getB() + ", "
                + triangle.getC() + ") равен: " + triangle.getPerimeter());

    }
}
