
public class girlFriend {
    public String name;
    public double height;
    public double weight;
    
}

class Test {
    public static void main(String[] args) {
        Student s1 = new Student("张三",18);
        Student s2 = new Student("李思",33);
        System.out.println(s1.getName()); // 输出: 张三
        System.out.println(s2.getName()); // 输出: 李思
        s1.show();
    }
}

class Student{
    private String name;
    private int age;
    public void show(){
        System.out.println("姓名"+name + " " +"年龄"+ age);
    }
    public Student(){

    }
    public Student(String n,int a){
        this.name = n;
        this.age = a;
    }
    public void setName(String name){ // 设置姓名
        this.name = name;
    }
    public String getName(){ // 获取姓名
        return name;
    }
    public void setAge(int age){ // 设置年龄
        this.age = age;
    }
    public int getAge() { // 获取年龄
        return age;
    }
}

