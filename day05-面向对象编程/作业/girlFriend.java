
public class girlFriend {
    public String name;
    public double height;
    public double weight;
    
}

class Test {
    public static void main(String[] args) {
        Teacher t1=new Teacher();
        t1.setName("杨老师");
        t1.setWorkId(001);
        Teacher t2=new Teacher("李老师",002);
        t1.show();

    }
}

class Student{
    private String name;
    private int age;
    public void show() {
        System.out.println("姓名" + name + " " + "年龄" + age);
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

class Teacher{
    private String name;
    private int workId;
    public void teach(){
        System.out.println("工号为"+workId+ "的老师" + name + "正在讲课");
    }

    public Teacher(){

    }

    public Teacher(String name,int workId){
        this.name = name;
        this.workId = workId;
    }

    public void setName(String name){ // 获取姓名
        this.name = name;
    }

    public String getName(){ // 获取姓名
        return name;
    }

    public void setWorkId(int workId){ // 设置工号
        this.workId = workId;
    }

    public int getWorkId() { // 获取工号
        return workId;
    }

}