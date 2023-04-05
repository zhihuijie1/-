package Novice_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ShowComparator {
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
            if (o1.age < o2.age) {
                return -1;
            } else if (o1.age > o2.age) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void printArray2(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 3, 7, 2, 9, 6, 4, 1, 5};
        printArray(array);
        Arrays.sort(array);
        System.out.println();
        printArray(array);

        Student s1 = new Student("张三", 1, 20);
        Student s2 = new Student("李四", 2, 23);
        Student s3 = new Student("王五", 3, 17);
        Student s4 = new Student("老六", 4, 52);
        Student s5 = new Student("哈奇", 5, 34);
        Student[] students = {s1, s2, s3, s4, s5};
        System.out.println("-------------------");
        printArray2(students);
        System.out.println();
        Arrays.sort(students, new IdComparator());
        printArray2(students);
        System.out.println("----------------");
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);
        arrayList.add(s4);
        arrayList.add(s5);
        for (Student s : arrayList) {
            System.out.println(s);
        }
        arrayList.sort(new IdComparator());
        System.out.println("-------------------------");
        for (Student s : arrayList) {
            System.out.println(s);
        }

    }
}