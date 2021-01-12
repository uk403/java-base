package com.ukyu.base.reflection;

import java.util.List;

/**
 * filed表示与类、接口，枚举相关的值
 *
 * @author ukyu
 * @date 2020/12/20
 **/
public class FieldDemo<T> {
    public boolean[][] b = {{ false, false }, { true, true } };
    public String name  = "Alice";
    public static List<Integer> list;
    public T val;
    class Inner {}

    public Integer num;

    public final int finalNum = new Integer(1);

    public static void main(String[] args) throws Exception {

//        ---------获取域的类型
//        try {
//            Class<?> c = Class.forName("com.ukyu.base.reflection.FieldDemo");
//            Field f = c.getField("name");
//            System.out.format("Type: %s%n", f.getType());
//            // 若不是泛型，返回值与getType()一样
//            System.out.format("GenericType: %s%n", f.getGenericType());
//
//            // production code should handle these exceptions more gracefully
//        } catch (ClassNotFoundException x) {
//            x.printStackTrace();
//        } catch (NoSuchFieldException x) {
//            x.printStackTrace();
//        }

//        ------获取和解析域的修饰符

//         * modifiers:
//         * Access modifiers: public, protected, and private
//         * Field-specific modifiers governing runtime behavior: transient and volatile
//         * Modifier restricting to one instance: static
//         * Modifier prohibiting value modification: final
//         * Annotations
//        c.getField().getModifiers();
//        Class<?> c = Class.forName("com.ukyu.base.reflection.FieldDemo$Inner");
//        System.out.println(Arrays.toString(c.getDeclaredFields()));

//        get和set域的值
        Class<?> c = Class.forName("com.ukyu.base.reflection.FieldDemo");
        FieldDemo<String> demo = new FieldDemo<>();
//        Field field = c.getField("name");
//        System.out.println("before: " + demo.name);
//        // 有一定的性能开销，因为会有很多操作会执行，例如访问权限的验证
//        field.set(demo, "hello world");
//        System.out.println("after: " + demo.name);
//
//        ------------常见的问题
//        1.IllegalArgumentException due to Inconvertible Types
//        // set的值类型必须和定义的类型一样，
//        // 假如定义的是Integer, 就不能将int类型的值赋给它， 因为编译器没有机会执行装箱
//        Class.isAssignableFrom() 验证是否特定的转化是有可能的
//        field = c.getField("num");
//        field.setInt(demo, 12);
//        2. NoSuchFieldException for Non-Public Fields
//        使用Class.getDeclaredFields()获取所有声明在类中(不包含继承类的)的域
//        System.out.println(Arrays.toString(c.getDeclaredFields()));

//          3. IllegalAccessException when Modifying Final Fields
//        重新写一个博客,探究修改final的值
//        内联优化、未内联优化？
//        谨慎使用: 可能会产生出人意料的bug;例如,代码的其他地方使用了原始值，即使该值被修改
//        Field field = c.getField("finalNum");
//        field.setAccessible(true);
//        field.setInt(demo, 20);
//        System.out.println(demo.finalNum);






    }
}
