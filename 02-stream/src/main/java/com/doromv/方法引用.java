package com.doromv;

import com.doromv.pojo.Author;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import static com.doromv.StreamDemo.getAuthors;

/**
 * @author Doromv
 * @create 2022-05-04-21:55
 */
public class 方法引用 {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();

        Stream<Author> authorStream = authors.stream();
//        类名::静态方法名
//        authorStream.map(author -> author.getAge())
//                .map(String::valueOf);
//=========================================================================================
//        对象::成员方法
//        StringBuilder sb = new StringBuilder();
//        authorStream.map(author -> author.getName())
//                .forEach(sb::append);
//        类名::第一个参数的成员方法
//        subAuthorName("Doromv", new UseString() {
//            @Override
//            public String use(String str, int start, int length) {
//                return str.substring(start,length);
//            }
//        });
//        subAuthorName("Doromv", (str, start, length) -> str.substring(start,length));
//===========================================================================================
//        类名:new
//        authors.stream()
//                .map(Author::getName)
//                .map(StringBuffer::new)
//                .map(sb->sb.append("-三更").toString())
//                .forEach(System.out::println);
    }



    interface UseString{
        String use(String str,int start,int length);
    }

    public static String subAuthorName(String str, UseString useString){
        int start = 0;
        int length = 1;
        return useString.use(str,start,length);
    }
}
