package com.ukyu.base.collections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Collections
 * @author ukyu
 * @date 2021/2/22
 **/
//@Log4j
public class CollectionsDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++)
        {
            list.add(i);
        }
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < 5; i++)
        {
            list1.add(i);
        }
//        log.info("变化前 " + list);
//        1. sort(), 默认是升序，也可以自定义Comparator

//        2. binarySearch(),二分法，必须将集合进行升序排序后，否则其结果不能确定;
//        也可以自定义Comparator

//        3. reverse(),倒转list

//        4. shuffle()，打乱顺序
//        Collections.shuffle(list);

//        5. swap() 交换数组或列表

//        6. fill()填充数据
//        Collections.fill(list, 1);

//        7. copy(dest, src); 复制;

//        8. rotate(list, distance)
//        distance > 0 元素依次往右循序移动distance;反之
//        List<String> rl = Arrays.asList("a", "b", "c", "d", "e");
//        用途: 当需要调整某个子列表的顺序，并且保持其余整个列表的顺序时
//        Collections.rotate(rl.subList(1, 4), -1);
//        log.info("变化后 " + rl.subList(1, 4));


//        9. Collections.unmodifiableCollection(list) 返回一个不可修改的Collection
//        Collection<Integer> col = Collections.unmodifiableCollection(list);
//        还有几个不可修改的方法，根据所需使用

//        10. 将非线程安全的集合转化成线程安全的集合
//        Collections.synchronizedCollection(Collection<T> c)
//        用synchronized封装这些操作， 引入一些代码
//        通过Iterator、Spliterator、Stream，必须手动同步，不是的话，可能导致不能确定的问题，列出代码

//        11. 动态类型安全的集合视图 先加入一个错误的类型，然后迭代它
//        更好的找到错误，在debug的时候;
//        List l2 = list;
//        l2.add("abc");
//        利用反射添加元素
//        l2.getClass().getMethod("add", Object.class).
//                invoke(l2, "3");

//        for(Integer x : list)
//        {
//            System.out.println(x);
//        }
//        报的错不详细
//
//        Collection c = Collections.checkedCollection(
//                new HashSet<>(), String.class);
//        c.add(1);
//        不能使用反射进行插入
//        c.getClass().getMethod("add", Object.class).
//                invoke(c, "3");

//        还有其他的checkedXX,按需使用

//        12. emptyIterator()、emptyListIterator()、emptyEnumeration()
//        不太清楚什么时候可能会用到它们

//        13. emptySet()、emptyList等，返回一个空的集合
//        当没有数据时，若要返回空的集合，可以考虑使用这些方法，不用new一个出来,浪费资源

//        14.singleton(); singletonList();singletonMap() 返回对应的单例

//        15. nCopies(int n, T o) 返回一个有n个元素(每个元素都是o)的list
//        与List.addAll()结合使用，来增长list
//        Collections.nCopies(10, "hi!").forEach(System.out::println);

//        16. 反转排序，默认是升序，反转后就是降序；也可以传入自定义Comparator;
//        Comparator<Integer> com = Collections.reverseOrder();
//        Collections.sort(list, com);

//        17. 枚举与List可以互换

//        18. Collections.frequency 某个元素，在集合中出现的频率
        list.add(0);
//        log.info(Collections.frequency(list, 0));

//        19. Collections.disjoint() 查看元素是否有交集

//        20. newSetFromMap 返回一个set来支持指定的map；该方法提供一个set的实现来对应map的任何实现；
//        具有相同的顺序(map.keySet)、并发性，性能特点；
//        TreeMap -> TreeSet; HashMap -> HashSet 以上两个map不需要使用这个工厂方法
//        log.info(Collections.newSetFromMap(new HashMap<>(4)));

//        21. asLifoQueue，当你需要你一个队列并且是’Lifo(先进后出)‘的顺序可以使用


//        log.info("变化后 " + list);

    }

}
