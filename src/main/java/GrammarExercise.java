import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        Scanner scan = new Scanner(System.in);
        String firstWordList = scan.next();
        String secondWordList = scan.next();
        scan.close();
        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行
        result.forEach(System.out::println);
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        if(firstWordList.contains(",,") || firstWordList.contains("&")){
            throw new RuntimeException("input not valid");
        }
        List<String> first = Arrays.asList(firstWordList.toUpperCase().split(","));
        List<String> second = Arrays.asList(secondWordList.toUpperCase().split(","));
        //https://blog.csdn.net/weixin_43135846/article/details/91800268
        //插入空格 str.replace("", " ").trim();
        return first.stream()
                .distinct()
                .filter(str -> second.contains(str))
                .map(str -> str.replace("", " ").trim())
                .sorted()
                .collect(Collectors.toList());
        
    }
}
