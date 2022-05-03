package com.doromv;

import com.doromv.pojo.Author;
import com.doromv.pojo.Book;
import com.sun.org.apache.regexp.internal.RE;
import lombok.val;

import javax.xml.bind.Element;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Doromv
 * @create 2022-04-30-21:13
 */
public class StreamDemo {
    public static void main(String[] args) {
//        List<Author> authors = getAuthors();
//        System.out.println(authors);
        //打印年龄小于十八的作家的名字
//        authors.stream()//把集合转换成流
//                .distinct()
//                .filter(author -> author.getAge()<18)
//                .forEach(author -> System.out.println(author.getName()));
//        getArrStream();
//        getMapStream();
//        getAuthorsStream1();
//        getAuthorsStream2();
//        getAuthorsStream3();
//        getAuthorsStream4();
//        getAuthorsStream5();
//        getAuthorsStream6();
//        getAuthorsStream7();
//        getAuthorsStream8();
//        getAuthorsStream9();
//        getAuthorsStream10();
//        getAuthorsStream11();
//        getAuthorsStream12();
//        getAuthorsStream13();
//        getAuthorsStream14();
//        getAuthorsStream15();
//        getAuthorsStream16();
//        getAuthorsStream17();
//        getAuthorsStream18();
//        getAuthorsStream19();
//        getAuthorsStream20();
//        getAuthorsStream21();
        getAuthorsStream22();
    }

    private static void getAuthorsStream22() {
        Stream<Author> stream = getAuthors().stream();
        Optional<Integer> x = stream
                .map(author -> author.getAge())
                .reduce((result, element) -> result = result > element ? element : result);
        x.ifPresent(age-> System.out.println(age));
    }

    private static void getAuthorsStream21() {
        Stream<Author> stream = getAuthors().stream();
        System.out.println(stream
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, (result, element) -> result = element < result ? element : result));
    }

    private static void getAuthorsStream20() {
        Stream<Author> stream = getAuthors().stream();
        System.out.println(stream
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, element) -> result = element > result ? element : result));
    }

    private static void getAuthorsStream19() {
        Stream<Author> stream = getAuthors().stream();
        System.out.println(stream
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, (result, element) -> result + element));
    }

    private static void getAuthorsStream18() {
        Stream<Author> stream = getAuthors().stream();
        Optional<Author> first = stream
                .sorted((author1, author2) -> author1.getAge() - author2.getAge())
                .findFirst();
        first.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void getAuthorsStream17() {
        Stream<Author> stream = getAuthors().stream();
        Optional<Author> any = stream
                .filter(author -> author.getAge()>18)
                .findAny();
        any.ifPresent(author -> System.out.println(author));
    }

    private static void getAuthorsStream16() {
        Stream<Author> stream = getAuthors().stream();
        System.out.println(stream
                .noneMatch(author -> author.getAge() > 100));
    }

    private static void getAuthorsStream15() {
        Stream<Author> stream = getAuthors().stream();
        System.out.println(stream
                .allMatch(author -> author.getAge() >= 18));
    }

    private static void getAuthorsStream14() {
        Stream<Author> stream = getAuthors().stream();
        System.out.println(stream
                .anyMatch(author -> author.getAge() > 29));
    }

    private static void getAuthorsStream13() {
        Stream<Author> stream = getAuthors().stream();
        Map<String, List<Book>> map = stream
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        for (String s : map.keySet()) {
            System.out.println(s+"==="+map.get(s)+"\n");
        }
    }

    private static void getAuthorsStream12() {
        Stream<Author> stream = getAuthors().stream();
        Set<Book> set = stream
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .collect(Collectors.toSet());
        for (Book book : set) {
            System.out.println(book);
        }
    }

    private static void getAuthorsStream11() {
        Stream<Author> stream = getAuthors().stream();
        List<String> list = stream
                .map(author -> author.getName())
                .distinct()
                .collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void getAuthorsStream10() {
        Stream<Author> stream = getAuthors().stream();
//        Optional<Book> min = stream
//                .flatMap(author -> author.getBooks().stream())
//                .min((book1, book2) -> book1.getScore() - book2.getScore());
        Optional<Integer> min = stream
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .min((score1, score2) -> score1 - score2);
        Stream<Author> stream1 = getAuthors().stream();
        Optional<Integer> max = stream1
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((score1, score2) -> score1 - score2);
        System.out.println(max.get());
        System.out.println(min.get());
    }

    private static void getAuthorsStream9() {
        Stream<Author> stream = getAuthors().stream();
        System.out.println(stream
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count());
    }

    private static void getAuthorsStream8() {
        Stream<Author> stream = getAuthors().stream();
        stream
                .map(author -> author.getName())
                .distinct()
                .forEach(name-> System.out.println(name));
    }

    private static void getAuthorsStream7() {
        Stream<Author> stream = getAuthors().stream();
        stream
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book-> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(category-> System.out.println(category));


    }

    private static void getAuthorsStream6() {
        Stream<Author> stream = getAuthors().stream();
        stream
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book-> System.out.println(book.getName()));
    }

    private static void getAuthorsStream5() {
        Stream<Author> stream = getAuthors().stream();
        stream
                .distinct()
                .sorted((t1,t2)->t2.getAge()-t1.getAge())
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void getAuthorsStream4() {
        Stream<Author> stream = getAuthors().stream();
        stream
                .distinct()
                .sorted((t1,t2)->t2.getAge()-t1.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author));
    }

    private static void getAuthorsStream3() {
        Stream<Author> stream = getAuthors().stream();
        stream
                .distinct()
                .sorted((t1, t2) -> t2.getAge()-t1.getAge())
                .forEach(author -> System.out.println(author));
    }

    private static void getAuthorsStream2(){
        Stream<Author> stream = getAuthors().stream();
        stream
                .map(author -> author.getName())
                .distinct()
                .forEach(name-> System.out.println(name));
    }

    private static void getAuthorsStream1() {
        Stream<Author> stream = getAuthors().stream();
//        stream
//                .filter(author -> author.getName().length()>1)
//                .forEach(author -> System.out.println(author.getName()));
        stream
                .map(author -> author.getAge())
                .map(age->age+10)
                .forEach(age-> System.out.println(age));
    }

    private static void getMapStream() {
        Map<String,Integer> map = new HashMap<>();
        map.put("蜡笔小新",19);
        map.put("黑子",17);
        map.put("日向翔阳",16);
        Stream<Map.Entry<String, Integer>> stream = map.entrySet().stream();
        stream
                .filter(entry -> entry.getValue()>16)
                .forEach(entry -> System.out.println(entry.getKey()+"==="+entry.getValue()));
    }

    private static void getArrStream() {
        Integer[] arr = {1,2,3,4,5};
//        Stream<Integer> stream = Arrays.stream(arr);
        Stream<Integer> stream = Stream.of(arr);
        stream
                .distinct()
                .filter(integer -> integer>2)
                .forEach(integer -> System.out.println(integer));
    }

    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L,"蒙多",33,"一个从菜刀中明悟哲理的祖安人",null);
        Author author2 = new Author(2L,"亚拉索",15,"狂风也追逐不上他的思考速度",null);
        Author author3 = new Author(3L,"易",14,"是这个世界在限制他的思维",null);
        Author author4 = new Author(3L,"易",14,"是这个世界在限制他的思维",null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L,"刀的两侧是光明与黑暗","哲学,爱情",88,"用一把刀划分了爱恨"));
        books1.add(new Book(2L,"一个人不能死在同一把刀下","个人成长,爱情",99,"讲述如何从失败中明悟真理"));

        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        books2.add(new Book(4L,"吹或不吹","爱情,个人传记",56,"一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L,"你的剑就是我的剑","爱情",56,"无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author,author2,author3,author4));
        return authorList;
    }
}
