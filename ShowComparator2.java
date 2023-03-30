package Novice_class;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ShowComparator2 {

    static class Student {
        // 属性
        String name;
        int age;
        int id;
        // 方法
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", id=" + id +
                    '}';
        }
        // 构造器
        public Student() {

        }
        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    // age小的放在前面
    static class IdComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.age < o2.age) {
                return -1;
            }else if(o1.age > o2.age) {
                return 1;
            }else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> heap = new PriorityQueue<>(new IdComparator());
        Student s1 = new Student("张三",1,20);
        Student s2 = new Student("李四",2,23);
        Student s3 = new Student("王五",3,17);
        Student s4 = new Student("老六",4,52);
        Student s5 = new Student("哈奇",5,34);
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        int length = heap.size();
        for (int i = 0; i < length; i++) {
            System.out.println(heap.poll());
        }

        TreeSet<Student> treeSet = new TreeSet<>(new IdComparator());
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);
        treeSet.add(s5);
        length = treeSet.size();
        System.out.println("-----------------");
        for (int i = 0; i < length; i++) {
            System.out.println(treeSet.pollFirst());
        }
    }
}
