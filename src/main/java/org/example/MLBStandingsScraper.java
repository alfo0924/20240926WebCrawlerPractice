package org.example;

import java.util.*;

public class MLBStandingsScraper {

    private static final Map<String, String> teamNameMap = new HashMap<>();
    private static final Map<String, Integer> teamSeedMap = new HashMap<>();
    private static final List<String> alTeams = new ArrayList<>();
    private static final List<String> nlTeams = new ArrayList<>();

    static {
        // 初始化球隊名稱映射
        teamNameMap.put("NYY", "紐約洋基");
        teamNameMap.put("TOR", "多倫多藍鳥");
        teamNameMap.put("TB", "坦帕灣光芒");
        teamNameMap.put("CLE", "克里夫蘭守護者");
        teamNameMap.put("SEA", "西雅圖水手");
        teamNameMap.put("HOU", "休斯頓太空人");
        teamNameMap.put("PHI", "費城費城人");
        teamNameMap.put("STL", "聖路易紅雀");
        teamNameMap.put("ATL", "亞特蘭大勇士");
        teamNameMap.put("SD", "聖地亞哥教士");
        teamNameMap.put("NYM", "紐約大都會");
        teamNameMap.put("LAD", "洛杉磯道奇");

        // 初始化 2022 年 MLB 常規賽排名數據
        alTeams.addAll(Arrays.asList("HOU", "NYY", "CLE", "TOR", "SEA", "TB"));
        nlTeams.addAll(Arrays.asList("LAD", "ATL", "STL", "NYM", "SD", "PHI"));

        // 設置種子
        for (int i = 0; i < alTeams.size(); i++) {
            teamSeedMap.put(alTeams.get(i), i + 1);
        }
        for (int i = 0; i < nlTeams.size(); i++) {
            teamSeedMap.put(nlTeams.get(i), i + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("(AMERICAN LEAGUE) 美國聯盟");
        printBracket(alTeams);
        System.out.println("(NATIONAL LEAGUE) 國家聯盟");
        printBracket(nlTeams);
    }

    private static void printBracket(List<String> teams) {
        String[] bracket = {
                "{0}  {1} ----- {2}（{1}號種子）",
                "{3} {4} ----- {3} ----- {5}（{4}號種子）晉級",
                "        {3} {4} ----- {6} {7}vs{8}",
                "{9}  {10} ----- {11}（{10}號種子）",
                "{12} {13} ----- {9} ----- {14}晉級",
                "        {15} {16} ----- {15} ----- {15} {17}（{16}號種子）連勝晉級",
                "                               ---- {15} {17}獲得{18}冠軍"
        };

        for (String line : bracket) {
            System.out.println(formatLine(line, teams));
        }
    }

    private static String formatLine(String line, List<String> teams) {
        for (int i = 0; i < teams.size(); i++) {
            String team = teams.get(i);
            int seed = teamSeedMap.get(team);
            String fullName = teamNameMap.get(team);

            line = line.replace("{" + i * 3 + "}", team);
            line = line.replace("{" + (i * 3 + 1) + "}", String.valueOf(seed));
            line = line.replace("{" + (i * 3 + 2) + "}", fullName);
        }

        // 特殊替換
        line = line.replace("{7}", teams.get(2));
        line = line.replace("{8}", teams.get(1));
        line = line.replace("{14}", teams.get(4).equals("SEA") ? "西雅圖" : teams.get(4));
        line = line.replace("{18}", teams == alTeams ? "美聯" : "國聯");

        return line;
    }
}