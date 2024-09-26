

# MLB Standings Scraper 程式碼解析

## 程式結構

這個 Java 程式主要用於生成 2022 年 MLB 季後賽的對陣圖。

### 主要組件

1. **類別定義**：
   ```java
   public class MLBStandingsScraper
   ```
   定義了主要的類別，包含所有相關方法和數據結構。

2. **靜態變數**：
   ```java
   private static final Map<String, String> teamNameMap = new HashMap<>();
   private static final Map<String, Integer> teamSeedMap = new HashMap<>();
   private static final List<String> alTeams = new ArrayList<>();
   private static final List<String> nlTeams = new ArrayList<>();
   ```
   這些變數用於存儲球隊名稱映射、種子排名和聯盟球隊列表。

3. **靜態初始化塊**：
   ```java
   static {
       // 初始化代碼
   }
   ```
   用於初始化球隊名稱映射、聯盟球隊列表和種子排名。

4. **主方法**：
   ```java
   public static void main(String[] args)
   ```
   程式的入口點，負責調用方法生成對陣圖。

5. **輔助方法**：
   - `printBracket(List<String> teams)`：打印對陣圖。
   - `formatLine(String line, List<String> teams)`：格式化每一行輸出。

## 關鍵功能解析

### 1. 數據初始化
- 在靜態初始化塊中，程式設置了球隊名稱映射、2022 年 MLB 常規賽排名數據和種子排名。

### 2. 生成對陣圖
- `printBracket` 方法使用預定義的模板字符串數組來生成對陣圖結構。
- `formatLine` 方法負責將模板中的佔位符替換為實際的球隊信息。

### 3. 特殊處理
- 程式對某些特定情況進行了特殊處理，例如：
  ```java
  line = line.replace("{14}", teams.get(4).equals("SEA") ? "西雅圖" : teams.get(4));
  ```
  這行代碼特別處理了西雅圖水手隊的顯示名稱。

## 程式特點

1. **硬編碼數據**：程式使用硬編碼的方式存儲 2022 年的 MLB 排名數據，而不是從外部源獲取。
2. **靈活的格式化**：使用模板和替換方法來生成對陣圖，使得格式調整相對容易。
3. **分離的數據結構**：使用不同的數據結構來存儲球隊名稱、種子排名和聯盟分組，提高了代碼的組織性。

