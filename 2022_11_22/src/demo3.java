import java.util.HashMap;
import java.util.HashSet;

public class demo3 {

    static class Student {
        int value;
        public Student(int val) {
            this.value = val;
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        Integer b = 190000;
        Integer a = 190000;
        String abs = new String("你好我是小白");
        String abd = new String("你好我是小白");
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(abs == abd);
        System.out.println(abs.equals(abd));
        System.out.println("--------------------");

        hashMap.put(abs,"小白");
        System.out.println(hashMap.containsKey(abd));

        System.out.println("--------------------");

        HashMap<Student,String> hashMap2 = new HashMap<>();
        Student student1 = new Student(100);
        Student student2 = new Student(100);
        hashMap2.put(student1,"小白");
        System.out.println(hashMap2.containsKey(student2));
        System.out.println("---------------------");
        String[] arr1 = new String[]{"小白","小红"};
        String[] arr2 = new String[]{"小白","小红"};
        HashMap<String[],Integer> hashMap3 = new HashMap<>();
        hashMap3.put(arr1,1);
        System.out.println(hashMap3.containsKey(arr2));
    }
}
