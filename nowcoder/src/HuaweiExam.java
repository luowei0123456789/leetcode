package src;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: luow
 * @date: 2022/6/19 16:05
 * @describe 华为机试
 */
public class HuaweiExam {
    public static void main(String[] args) {

    }

    /**
     * @Author luow
     * @Date 16:16 2022/6/19
     * @describe 字符串最后一个单词的长度
     * <p>
     * 输入：hello nowcoder
     * 输出：8
     */
    public static void test1() {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        String[] a = string.split(" ");
        String length = a[a.length - 1];
        System.out.print(length.length());
    }

    /**
     * @Author luow
     * @Date 16:19 2022/6/19
     * @describe 计算某字符出现次数
     * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
     * <p>
     * 输入：ABCabc
     * A
     * 输出：2
     */
    public static void test2() {
        Scanner scan = new Scanner(System.in);
        String string1 = scan.nextLine();
        String string2 = scan.nextLine();

        String string3 = string1.toLowerCase();
        String string4 = string2.toLowerCase();

        char[] arr = string3.toCharArray();
        char a = string4.charAt(0);
        int sum = 0;
        for (int i = 0; i < string3.length(); i++) {
            if (a == arr[i]) {
                sum += 1;
            }
        }
        System.out.print(sum);
    }

    /**
     * @Author luow
     * @Date 16:22 2022/6/19
     * @describe 明明的随机数
     * <p>
     * 输入描述：
     * 第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。 具体格式可以参考下面的"示例"。
     * 输出描述：
     * 输出多行，表示输入数据处理后的结果
     * <p>
     * 输入：
     * 3
     * 2
     * 2
     * 1
     * 输出：
     * 1
     * 2
     */
    public static void test3() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i = 0; i < N; i++) {

            set.add(scan.nextInt());
        }

        for (Integer a : set) {
            System.out.println(a);
        }
    }

    /**
     * @Author luow
     * @Date 16:26 2022/6/19
     * @describe 字符串分隔
     * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
     * <p>
     * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     * <p>
     * 输入：
     * abc
     * 输出：
     * abc00000
     */
    public static void test4() {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();//牢记字符串缓冲区的建立语法
        sb.append(str);//字符串缓冲区的加入
        int size = str.length();
        int addZero = 8 - size % 8;//addzero的可能值包括8
        while ((addZero > 0) && (addZero < 8)) {//注意边界调节，避免addzero=8
            sb.append("0");//使用‘’或“”都可
            addZero--;
        }
        String str1 = sb.toString();
        while (str1.length() > 0) {
            System.out.println(str1.substring(0, 8));
            str1 = str1.substring(8);
        }
    }

    /**
     * @Author luow
     * @Date 16:30 2022/6/19
     * @describe 进制转换
     * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
     * 输入：
     * 0xAA
     * 输出：
     * 170
     */
    public static void test5() {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(Integer.parseInt(s.substring(2, s.length()), 16));
    }

    /**
     * @Author luow
     * @Date 16:33 2022/6/19
     * @describe 质数因子
     * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
     * 输入：
     * 180
     * 输出：
     * 2 2 3 3 5
     */
    public static void test10() {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 获取需要求解的值
            int target = sc.nextInt();
            int y = 2;// 因子从2开始算
            while (target != 1) { // 短除法，除到目标值为1为止
                if (target % y == 0) // 能能够整除2
                {
                    System.out.print(y + " ");
                    target /= y;
                } else {// 更新y的值
                    if (y > target / y) y = target;//如果剩余值为质数
                    else y++;  //y值增加1
                }
            }
        }
    }

    /**
     * @Author luow
     * @Date 16:33 2022/6/19
     * @describe 取近似值
     * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
     * 输入：
     * 5.5
     * 输出：
     * 6
     * 说明：
     * 0.5>=0.5，所以5.5需要向上取整为6
     */
    public static void test6() {
        Scanner scan = new Scanner(System.in);
        Float num = scan.nextFloat();
        int a = num.intValue();
        if (num - a < 0.5) {
            System.out.print(a);
        } else {
            System.out.print(a + 1);
        }
    }

    /**
     * @Author luow
     * @Date 16:33 2022/6/19
     * @describe 合并表记录
     * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
     * 输入：
     * 4
     * 0 1
     * 0 2
     * 1 2
     * 3 4
     * 输出：
     * 0 3
     * 1 2
     * 3 4
     */
    public static void test7() {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, Integer> integerIntegerTreeMap = new TreeMap<Integer, Integer>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            while (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                integerIntegerTreeMap.put(a, integerIntegerTreeMap.getOrDefault(a, 0) + b);
            }
        }
        for (Integer i : integerIntegerTreeMap.keySet()) {
            System.out.println(i + " " + integerIntegerTreeMap.get(i));
        }
    }

    /**
     * @Author luow
     * @Date 16:33 2022/6/19
     * @describe 提取不重复的整数
     * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
     * 保证输入的整数最后一位不是 0 。
     * 输入：
     * 9876673
     * 输出：
     * 37689
     */
    public static void test8() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String result = "";
        for (int i = s.length(); i > 0; i--) {
            if (!result.contains(s.substring(i - 1, i))) {
                System.out.print(s.substring(i - 1, i));
                result += s.substring(i - 1, i);
            }
        }
    }

    /**
     * @Author luow
     * @Date 16:33 2022/6/19
     * @describe 字符个数统计
     * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
     * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
     * 输入：
     * abc
     * 输出：
     * 3
     */
    public static void test9() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int a = (int) (s.charAt(i));
            if (0 <= a && a <= 127) {
                characters.add(s.charAt(i));
            }
        }
        System.out.println(characters.size());
    }

    /**
     * @Author luow
     * @Date 16:41 2022/6/19
     * @describe 数字颠倒
     * 输入一个整数，将这个整数以字符串的形式逆序输出
     * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
     * 输入：
     * 1516000
     * 输出：
     * 0006151
     */
    public static void test11() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[chars.length - 1 - i]);
        }
    }

    /**
     * @Author luow
     * @Date 16:41 2022/6/19
     * @describe 字符串反转
     * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
     * 输入：
     * abcd
     * 输出：
     * dcba
     */
    public static void test12() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[chars.length - 1 - i]);
        }
    }

    /**
     * @Author luow
     * @Date 16:42 2022/6/19
     * @describe 句子逆序
     * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
     * <p>
     * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
     * 输入：
     * I am a boy
     * 输出：
     * boy a am I
     */
    public static void test13() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            System.out.print(s1[s1.length - 1 - i] + " ");
        }
    }

    /**
     * @Author luow
     * @Date 16:42 2022/6/19
     * @describe 字符串排序
     * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
     * 输入：
     * 9
     * cap
     * to
     * cat
     * card
     * two
     * too
     * up
     * boat
     * boot
     * 输出：
     * boat
     * boot
     * cap
     * card
     * cat
     * to
     * too
     * two
     * up
     */
    public static void test14() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
        Arrays.sort(strings);
        for (String str : strings) {
            System.out.println(str);
        }
    }

    /**
     * @Author luow
     * @Date 16:42 2022/6/19
     * @describe 求int型正整数在内存中存储时1的个数
     * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
     * 输入：
     * 5
     * 输出：
     * 2
     */
    public static void test15() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        while (i / 2 != 1) {
            int a = i % 2;
            integers.add(a);
            i = i / 2;
        }
        integers.add(i % 2);
        integers.add(1);

        int temp = 0;
        for (int j = 0; j < integers.size(); j++) {
            if (integers.get(j) == 1) {
                temp += 1;
            }
        }
        System.out.println(temp);
    }


    /**
     * @Author luow
     * @Date 16:42 2022/6/19
     * @describe 删除字符串中出现次数最少的字符
     * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
     * 输入：
     * aabcddd
     * 输出：
     * aaddd
     */
    public static void test16() {
        Scanner scan = new Scanner(System.in);
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        char[] chars = scan.nextLine().toCharArray();
        for (char ch : chars) {
            characterIntegerHashMap.put(ch, characterIntegerHashMap.getOrDefault(ch, 0) + 1);
        }
        //删除map中最少的key
        Integer min = Collections.min(characterIntegerHashMap.values());
        StringBuffer stringBuffer = new StringBuffer();
        for (char ch : chars) {
            if (characterIntegerHashMap.get(ch) != min) {
                stringBuffer.append(ch);
            }
        }
        System.out.println(stringBuffer);
    }

    /**
     * @Author luow
     * @Date 16:42 2022/6/19
     * @describe 坐标移动
     * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
     * 输入：
     * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
     * 坐标之间以;分隔。
     * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
     * 下面是一个简单的例子 如：
     * A10;S20;W10;D30;X;A1A;B10A11;;A10;
     * 处理过程：
     * 起点（0,0）
     * +   A10   =  （-10,0）
     * +   S20   =  (-10,-20)
     * +   W10  =  (-10,-10)
     * +   D30  =  (20,-10)
     * +   x    =  无效
     * +   A1A   =  无效
     * +   B10A11   =  无效
     * +  一个空 不影响
     * +   A10  =  (10,-10)
     * 结果 （10， -10）
     * <p>
     * 输入：
     * A10;S20;W10;D30;X;A1A;B10A11;;A10;
     * 输出：
     * 10,-10
     */
    public static void test17() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(";");
        ArrayList<String> strings = new ArrayList<>();
        for (String str : split) {
            Pattern p = Pattern.compile("^A\\d{1,2}$|^D\\d{1,2}$|^W\\d{1,2}$|^S\\d{1,2}$");
            Matcher matcher = p.matcher(str);
            if (matcher.find()) {
                strings.add(str);
            }
        }
        int a = 0;
        int b = 0;
        for (String sss : strings) {
            char c = sss.charAt(0);
            int i = Integer.parseInt(sss.substring(1, sss.length()));
            if (c == 'A') {
                a -= i;
            }
            if (c == 'D') {
                a += i;
            }
            if (c == 'W') {
                b += i;
            }
            if (c == 'S') {
                b -= i;
            }
        }
        System.out.println(a + "," + b);
    }

    /**
     * @Author luow
     * @Date 16:42 2022/6/19
     * @describe 图片整理
     * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过代码解决。
     * Lily使用的图片使用字符"A"到"Z"、"a"到"z"、"0"到"9"表示。
     * <p>
     * 输入：
     * Ihave1nose2hands10fingers
     * 输出：
     * 0112Iaadeeefghhinnnorsssv
     */
    public static void test18() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (char ch : chars) {
            System.out.print(ch);
        }
    }

    /**
     * @Author luow
     * @Date 16:42 2022/6/19
     * @describe 统计每个月兔子的总数
     * 有一种兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子。
     * 例子：假设一只兔子第3个月出生，那么它第5个月开始会每个月生一只兔子。
     * 一月的时候有一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
     * <p>
     * 输入：
     * 3
     * 输出：
     * 2
     */
    public static void test19() {
        /**
         * 1 2 3 4 5 6 7 8 9
         * 1 1 1 2 1     4
         *     1 1 1            4   5
         * 这个月生产有多少只兔子   1
         * 处于生产第二个月的兔子   1
         * 这个月可以生产的兔子
         * 已经开始生产的兔子      1
         */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int yue1 = 1;
        int yue2 = 0;
        int ke = 0;
        int cun = 0;
        int sum = 0;

        if (N == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i < N; i++) {
            cun = cun + ke;
            ke = yue2;
            yue2 = yue1;
            yue1 = cun + ke;
            sum = cun + ke + yue2 + yue1;
        }
        System.out.println(sum);
    }

    /**
     * @Author luow
     * @Date 16:42 2022/6/19
     * @describe 统计字符
     * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
     * <p>
     * 输入：
     * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
     * 输出：
     * 26
     * 3
     * 10
     * 12
     */
    public static void test20() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int shu = 0;
        int kong = 0;
        int zifu = 0;
        int qita = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') | (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                zifu += 1;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                shu += 1;
            } else if (s.charAt(i) == ' ') {
                kong += 1;
            } else {
                qita += 1;
            }
        }
        System.out.println(zifu);
        System.out.println(kong);
        System.out.println(shu);
        System.out.println(qita);
    }

}
