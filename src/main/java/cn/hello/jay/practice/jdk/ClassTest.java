/**
 *
 */
package cn.hello.jay.practice.jdk;

/**
 * @author 周健以
 * @Date 2019年01月14日
 */
public class ClassTest {

//    public static void main(String[] args) {
//        try {
//            // 使用forName方法与newInstance方法生成实例
//            Car tiguanCar = (Car) Class.forName("cn.hello.jay.practice.jdk.Tiguan").newInstance();
//            // 输出"tiguan"
//            System.out.println(tiguanCar.getName());
//            // 从上面的输出可以看出，tiguanCar是一个Tiguan实例，将其转换为SUV的类
//            // 注意，此处只能窄化tiguanCar的范围，本质上仍然是Tiguan.class
//            Class<? extends SUV> tiguanClass = tiguanCar.getClass().asSubclass(SUV.class);
//            // 输出"class Tiguan"
//            System.out.println(tiguanClass);
//            // 将tiguanCar转换为SUV实例,tiguanCar是一个Tiguan类的实例，作用与(SUV) tiguanCar一样。
//            SUV suv = SUV.class.cast(tiguanCar);
//            // 输出"tiguan"
//            System.out.println(suv.getName());
//            // 获取Tiguan类声明的字段
//            Field[] tiguanFields = tiguanClass.getDeclaredFields();
//            // 输出"name"
//            for (Field field : tiguanFields) {
//                System.out.println(field.getName());
//            }
//        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }

}
