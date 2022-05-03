package com.doromv;

import com.doromv.pojo.Author;
import com.doromv.pojo.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Doromv
 * @create 2022-05-03-21:16
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Author> authorOptional = getAuthorOptional();
        Optional<Author> authorOptionalIsNull = getAuthorOptionalIsNull();
//        Optional<Author> authorOptional = Optional.ofNullable(author);
//        authorOptional.ifPresent(author1 -> System.out.println(author1.getName()));
//        Optional<Author> authorOptionalIsNull = getAuthorOptionalIsNull();
//        Author author = authorOptionalIsNull.orElseGet(() -> new Author());
//        System.out.println(author);
//        ==========================================================================
//        Author author = authorOptional.orElseThrow(() -> new RuntimeException("数据为空"));
//        System.out.println(author);
//        Author authorIsNull = authorOptionalIsNull.orElseThrow(() -> new RuntimeException("数据为空"));
//        System.out.println(authorIsNull);
//        ==========================================================================
//        testFilter();
//        testIsPresent();
        testMap();
    }

    public static void testMap(){
        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional
                .map(author -> author.getBooks())
                .ifPresent(books -> System.out.println(books));
    }

    public static void testIsPresent(){
        Optional<Author> authorOptional = getAuthorOptional();
        if (authorOptional.isPresent()) {
            System.out.println(authorOptional.get().getName());
        }
    }

    public static void testFilter(){
        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.filter(author -> author.getAge()>18).ifPresent(author -> System.out.println(author.getName()));
    }

    public static Optional<Author> getAuthorOptional(){
        List<Book> books3 = new ArrayList<>();
        books3.add(new Book(5L,"你的剑就是我的剑","爱情",56,"无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        Author author=new Author(1L,"梦多",33,"一个菜刀中明悟理智的祖安人",books3);
        return Optional.ofNullable(author);
    }

    public static Optional<Author> getAuthorOptionalIsNull(){
        Author author=new Author(1L,"梦多",33,"一个菜刀中明悟理智的祖安人",null);
        return Optional.ofNullable(null);
    }

    public static Author getAuthor(){
        Author author=new Author(1L,"梦多",33,"一个菜刀中明悟理智的祖安人",null);
        return null;
    }
}
