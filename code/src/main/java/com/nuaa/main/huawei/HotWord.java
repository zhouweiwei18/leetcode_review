package com.nuaa.main.huawei;

import java.util.*;

/*  测试用例
    3 2
    xinguan feiyan xinzeng bendi quezhen anli
    ju baodao chengdu xinzeng xinguan feiyan bendi quezhen anli yili shenzhen xinzeng bendi quezhen anli liangli yiqing zhengti kongzhi lianghao
    xinguan yimiao linchuang shiyan
    wuzhong xinguan yimiao tongguo sanqi linchaung shiyan xiaoguo lianghao

    测试输出：xinguan xinzeng bendi
* */
public class HotWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().trim().split(" ");
        int topN = Integer.parseInt(nums[0]);
        int lines = Integer.parseInt(nums[1]);

        // 创建总的Map,记录每个次出现的频率
        Map<String, Article> total_map = new HashMap<>();
        int index = 0;
        while (lines > 0) {
            // 文章数加1
            index++;
            String title = sc.nextLine().trim();
            String text = sc.nextLine().trim();
            lines--;
            String[] str_title = title.split(" ");
            String[] str_text = text.split(" ");
            // 遍历该篇文章标题
            for (int i = 0; i < str_title.length; i++) {
                if (!total_map.containsKey(str_title[i])) {
                    total_map.put(str_title[i], new Article(str_title[i], index, 1, i, 0, 0, 1));
                } else {
                    Article article = total_map.get(str_title[i]);
                    // 更新标题出现频次 和 总频次
                    int title_count = article.getTitle_count();
                    int total_count = article.getTotal_count();
                    article.setTitle_count(title_count + 1);
                    article.setTotal_count(total_count + 1);
                    total_map.put(str_title[i], article);
                }
            }
            for (int i = 0; i < str_text.length; i++) {
                if (!total_map.containsKey(str_text[i])) {
                    total_map.put(str_text[i], new Article(str_text[i], index, 0, 0, 1, i, 1));
                } else {
                    Article article = total_map.get(str_text[i]);
                    // 更新正文出现频次 和 总频次
                    int text_count = article.getText_count();
                    int total_count = article.getTotal_count();
                    article.setText_count(text_count + 1);
                    article.setTotal_count(total_count + 1);
                    total_map.put(str_text[i], article);
                }
            }
        }

        // 创建List
        List<Article> ans = new ArrayList<>();
        for (Map.Entry<String, Article> entry : total_map.entrySet()) {
            ans.add(entry.getValue());
        }

        Collections.sort(ans, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                if (o1.getTotal_count() != o2.getTotal_count()) {
                    return o2.getTotal_count() - o1.getTotal_count();
                } else {
                    if (o1.getTitle_count() != o2.getTitle_count()) {
                        return o2.getTitle_count() - o1.getTitle_count();
                    } else {
                        if (o1.getTitle_position() != o2.getTitle_position()) {
                            if (o1.getNumber() != o2.getNumber()) {
                                return o1.getNumber() - o2.getNumber();
                            } else {
                                return o1.getTitle_position() - o2.getTitle_position();
                            }
                        } else {
                            if (o1.getNumber() != o2.getNumber()) {
                                return o1.getNumber() - o2.getNumber();
                            } else {
                                return o1.getText_position() - o2.getText_position();
                            }
                        }
                    }
                }
            }
        });

        for (int i = 0; i < topN-1; i++) {
            System.out.print(ans.get(i).getWord() + " ");
        }
        System.out.print(ans.get(topN-1).getWord());
    }

    static class Article {

        // word
        String word;

        // 文章编号
        int number;

        // 标题里出现的频次
        int title_count;

        // 标题出现的顺序
        int title_position;

        // 正文出现的频次
        int text_count;

        // 正文出现的顺序
        int text_position;

        // 出现的总频次
        int total_count;


        public Article() {
        }

        public Article(String word, int number, int title_count, int title_position, int text_count, int text_position, int total_count) {
            this.word = word;
            this.number = number;
            this.title_count = title_count;
            this.title_position = title_position;
            this.text_count = text_count;
            this.text_position = text_position;
            this.total_count = total_count;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getTitle_count() {
            return title_count;
        }

        public void setTitle_count(int title_count) {
            this.title_count = title_count;
        }

        public int getTitle_position() {
            return title_position;
        }

        public void setTitle_position(int title_position) {
            this.title_position = title_position;
        }

        public int getText_count() {
            return text_count;
        }

        public void setText_count(int text_count) {
            this.text_count = text_count;
        }

        public int getText_position() {
            return text_position;
        }

        public void setText_position(int text_position) {
            this.text_position = text_position;
        }

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        @Override
        public String toString() {
            return "Article{" +
                    "word='" + word + '\'' +
                    ", number=" + number +
                    ", title_count=" + title_count +
                    ", title_position=" + title_position +
                    ", text_count=" + text_count +
                    ", text_position=" + text_position +
                    ", total_count=" + total_count +
                    '}';
        }
    }
}
