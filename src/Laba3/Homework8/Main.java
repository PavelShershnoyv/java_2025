package Laba3.Homework8;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.createHead(0);
        list.createTail(1);
        list.AddFirst(new Node(2));
        list.AddLast(new Node(3));
        System.out.println("Список до вставки: " + list.toString());
        list.Insert(2, new Node(4));
        System.out.println("Список после вставки: " + list.toString());
        list.RemoveFirst();
        System.out.println("Список после удаления первого элемента: " + list.toString());
        list.RemoveLast();
        System.out.println("Список после удаления последнего элемента: " + list.toString());
        list.Remove(1);
        System.out.println("Список после удаления элемента под индексом 1: " + list.toString());
        list.createHeadRec(5);
        list.createTailRec(6);
        System.out.println("Список после добавления головы и хвоста: " + list.toStringRec());
    }
}
