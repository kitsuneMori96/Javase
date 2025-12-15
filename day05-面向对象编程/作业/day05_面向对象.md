

## 课堂案例

### 案例一

> 目标：按照标准的JavaBean去创建一个实体类，使用无参构造+set方法实现创建对象并且赋值。使用有参构造去创建对象。

##### 需求：完成课堂的标准JavaBean创建对象的案例







## 基础部分

#### 练习一

> 目标：掌握标准JavaBean的书写流程。能够使用无参+set方法去创建对象，给属性赋值。能够掌握有参构造去创建对象

##### **1. 需求**

````java
定义一个女朋友类。女朋友的属性包含：姓名，身高，体重。
定义测试类，请在测试类中通过无参构造创建对象，通过set方法给属性进行赋值。通过有参构造创建对象。最终，把两个对象的属性输出
````

程序执行，在控制台输出效果

````java
我女朋友叫凤姐,身高155.0厘米,体重130.0斤
我女朋友叫迪妮热巴,身高175.0厘米,体重90.0斤    
````

##### 2. 知识点

* 标准JavaBean的制作

##### **3. 思路分析**

````java
1.先创建一个女朋友类GirlFriend，用于封装女朋友的数据
2.按照标准JavaBean的定义类中的数据：
    2.1 私有成员变量 name,height,weight
    2.2 提供无参构造器和满参构造器
    2.3 提供对应的get/set方法
    
3.创建一个女朋友测试类 GirlFriendTest
    3.1 先写上一个main方法
    3.2 使用无参构造创建对象【此时对象里面的属性是没有值的】
    3.3 调用对应的set方法去给名字，身高和体重赋值
    3.4 调用对应的get方法，获取对象的值，拼接输出
    
    3.5 使用满参构造创建对象【此时对象里面的属性是有值的】
    3.6 调用对应的get方法，获取对象的值，拼接输出
````

````java
/*
    1. 私有所有成员变量
    2. 提供get/set方法
    3. 提供无参和满参构造


 */
public class GirlFriend {
    private String name;
    private double height;
    private double weight;
    //无参的构造
    public GirlFriend(){

    }

    public GirlFriend(String name, double height ,double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }


    //先提供set方法 【赋值】
    public void setName(String name){
        this.name = name;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }

    //提供对应的get方法
    public String getName(){
        return name;
    }
    public double getHeight(){
        return height;
    }
    public double getWeight(){
        return weight;
    }

}

````

````java
public class Test {
    public static void main(String[] args) {
        //无参 + set
        girlFriend g1 = new girlFriend();
        g1.setName("凤姐");
        g1.setHeight(155.0);
        g1.setWeight(130.0);
        System.out.println("我的女朋友叫" + g1.getName() + ",身高" + g1.getHeight() + "厘米，体重" + g1.getWeight() + "斤");


        //满参
        girlFriend g2 = new girlFriend("迪丽热巴", 175.0, 90);
        System.out.println("我的女朋友叫" + g2.getName() + ",身高" + g2.getHeight() + "厘米，体重" + g2.getWeight() + "斤");


    }
}

````





#### 练习二

> 目标：掌握标准JavaBean的书写流程。能够使用无参+set方法去创建对象，给属性赋值。能够掌握有参构造去创建对象

##### **1. 需求**

````java
定义标准学生类，属性包括姓名和年龄，定义一个成员方法，show()用于展示当前学生对象的信息。
在测试类中,要求分别使用空参和有参构造方法创建对象，空参创建的对象通过setXx赋值，有参创建的对象直接赋值，并通过show方法展示数据。
````

程序执行，在控制台输出效果

````java
姓名：张三，年龄：23
姓名：李四，年龄：24    
````

##### 2. 知识点

* 标准JavaBean的制作

##### **3. 思路分析**

````java
1.先创建一个学生类Student，用于封装学生的数据
2.按照标准JavaBean的定义类中的数据：
    2.1 私有成员变量 name 和 age 
    2.2 提供无参构造器和满参构造器
    2.3 提供对应的get/set方法
    2.4 定义一个成员方法(没有static)show()，方法中打印学生的姓名和年龄
3.创建一个学生测试类 StudentTest
    3.1 先写上一个main方法
    3.2 使用无参构造创建对象【此时对象里面的属性是没有值的】
    3.3 调用对应的set方法去给年龄和姓名进行赋值
    3.4 调用学生对象中的show方法
    
    3.5 使用满参构造创建对象【此时对象里面的属性是有值的】
    3.6 调用学生对象中的show方法
````

````java
public class Student {
    private String name;
    private int age;

    public Student(){

    }
    public Student(String name , int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    //定义show方法
    public void show(){
        System.out.println("姓名:" + name + "年龄:" + getAge());
    }
}

````

````java
public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("张三");
        s.setAge(23);
        s.show();

        Student s2 = new Student("李四" , 24);
        s2.show();
    }
}

````



#### 练习三

> 目标：掌握标准JavaBean的书写流程。能够使用无参+set方法去创建对象，给属性赋值。能够掌握有参构造去创建对象

##### **1. 需求**

````java
请定义教师类（Teacher），属性包括姓名和工号，定义教课（teach）方法，输出“工号为xxx的xxx老师正在讲课”。
在测试类中，要求分别使用空参和有参构造方法创建对象，空参创建的对象通过setXxx赋值，有参创建的对象直接赋值。创建对象之后，调用对象中的teach()方法
````

程序执行，在控制台输出效果

````java
工号为t001的杨老师正在讲课
工号为t002的李老师正在讲课 
````

##### 2. 知识点

* 标准JavaBean的制作

##### **3. 思路分析**

````java
1.先创建一个教师类Teacher，用于封装老师的数据
2.按照标准JavaBean的定义类中的数据：
    2.1 私有成员变量 id 和 name 
    2.2 提供无参构造器和满参构造器
    2.3 提供对应的get/set方法
    2.4 定义一个成员方法(没有static)teach()，方法中打印 工号为xxx的xxx老师正在讲课
3.创建一个老师测试类 TeacherTest
    3.1 先写上一个main方法
    3.2 使用无参构造创建对象【此时对象里面的属性是没有值的】
    3.3 调用对应的set方法去给工号和姓名进行赋值
    3.4 调用老师对象中的teach方法
    
    3.5 使用满参构造创建对象【此时对象里面的属性是有值的】
    3.6 调用老师对象中的show方法
````

`````java
public class Teacher {
    private String name;
    private String id;

    //先把成员变量定义好之后，才能使用快捷键
    //鼠标右键 ->  generate[生成] -> Constructor(构造器)
    public Teacher() {
    }

    public Teacher(String name, String id) {
        this.name = name;
        this.id = id;
    }
    //鼠标右键 ->  generate[生成] -> getter and setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void teach(){
        System.out.println("工号为:" + id  + "的" + name + "老师正在讲课~");
    }
}
`````

````java
public class Test {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setName("杨");
        t1.setId("9527");
        t1.teach();

        Teacher t2 = new Teacher("李" , "9528");
        t2.teach();
    }
}

````





#### 练习四

> 目标：掌握标准JavaBean的书写流程。能够使用无参+set方法去创建对象，给属性赋值。能够掌握有参构造去创建对象

##### **1. 需求**

````java
定义手机类，手机有品牌(brand),价格(price)和颜色(color)三个属性，有打电话call()和sendMessage()两个功能。
定义测试类，在测试中请定义出手机类，类中要有空参构造创建对象，通过set方法去赋值。或者通过有参构造去创建个对象。使用对象分别调用call()方法和sendMessage() 方法
````

程序执行，在控制台输出效果

````java
正在使用价格为3998元黑色的小米手机打电话.
正在使用价格为3998元黑色的小米手机发短信.
````

##### 2. 知识点

* 标准JavaBean的制作

##### **3. 思路分析**

````java
1.先创建一个手机类Phone，用于封装手机的数据
2.按照标准JavaBean的定义类中的数据：
    2.1 私有成员变量 brand,price , color
    2.2 提供无参构造器和满参构造器
    2.3 提供对应的get/set方法
    2.4 定义一个成员方法(没有static)call()方法，方法中打印 正在使用价格为xxx元xx的xx手机打电话.
    2.5 定义一个成员方法(没有static)sendMessage()方法，方法中打印  正在使用价格为xxx元xx的xx手机发短信.
3.创建一个手机测试类 PhoneTest
    3.1 先写上一个main方法
    3.2 使用无参构造创建对象【此时对象里面的属性是没有值的】
    3.3 调用对应的set方法去给品牌，价格和颜色赋值
    3.4 调用手机对象的call()方法和sendMessage()方法
    
    3.5 使用满参构造创建对象【此时对象里面的属性是有值的】
    3.6 调用手机对象的call()方法和sendMessage()方法
````

````java
public class Phone {
    private String brand;
    private double price;
    private String color;

    public Phone() {
    }

    public Phone(String brand, double price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void call(){
        System.out.println("正在使用价格为" + price + "元" + color + "的" + brand + "手机打电话");
    }

    public  void sendMessage(){
        System.out.println("正在使用价格为" + price + "元" + color + "的" + brand + "手机发信息");

    }

}
````

````java
public class Test {
    public static void main(String[] args) {
        Phone p = new Phone("小米" , 3999 , "黑色");
        p.call();
        String s = p.getBrand();

        p.sendMessage();

        Phone p1 = new Phone();
        p1.setBrand("小米");
        p1.setColor("白色");
        p1.setPrice(4999);
        p1.sendMessage();
        p1.call();
    }
}

````

