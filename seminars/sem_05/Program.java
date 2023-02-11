// Урок 5. Хранение и обработка данных ч2: множество коллекций Map
// =========================================================================================================
/**
 * Map - это структура хранения данных. 
 * Хранит ключ: значение.
 * --------------------------------------------------------------------------------------------------------
 * Предисловие: 
 * Списки - есть массив, в котором храняться ссылки на объекты, поэтому мне не важно какие типы объектов я 
 * храню в списках, потому, что массив это просто ссылки, ссылки всегда одного и того же размера и 
 * это причина по которой я не могу хранить приметивные данные, потому что он ссылки хранит и не бывает 
 * ссылок на приметивные данные.
 * 
 * А как тогда хранит Map??????????????????????????????????????????????????????????????????????????????????
 * Не бывает же одной ссылки на два объекта, на ключ и на значение?????????????????????????????????????????
 * Значит как-то по другому храниться или структура больше.
 * Да в Map структура гораздо серьездней.
 * 
 * В основе Map HashMap, LinkedHashMap - лежит массив, в котором лежат hash и в этом массиве их по 
 * умолчанию 16, можно сделать больше.
 * Когда я добавляю что-то в HashMap, создается большой объект (УЗЕЛ), в котором храняться четыре значения:
 * --------------------------------------------------------------------------------------------------------
 * ключ (key);                        |
 * значение (vol);                    |              Узел, в HashMap есть LinkedList
 * hash;                              |
 * ссылка на следующий объект (next). |
 * ---------------------------------------------------------------------------------------------------------
 * Когда я добавляю ключ значения, для ключа расчитывается hash, потому что, взависимости от того, какой ключ
 * получился определяется в какой ячейке массива будет храниться ссылка на него.
 * ---------------------------------------------------------------------------------------------------------
 * hash - Это уникальный номер (внутреннее имя) любого элемента в Java. Это десяти значное число.
 * ---------------------------------------------------------------------------------------------------------
 * т.к. hash генерируется системой автоматически по формуле!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Крайне редко есть вероятность повторения hash, для разных объектов!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Если это объект в памяти, то не страшно, т.к. адрес в памяти будет у них разный.
 * Когда есть повторения hash в HashMap, то элементу с hash первого вхождения говорят, что у него есть
 * ещё один наследник. Если я вставлю ещё один и у ного тот же самый hash, то он крепиться к наследнику первого 
 * и становиться наследником-наследника.
 * В теории их может быть бесконечно много. 
 * Такие последовательности (Узелы) по умолчанию идут друг за другом и вообще-то это LinkedList-ы.
 * Такие взоимосвязи наз. КОРЗИНА (два и более узлов, для одного hash).
 * Удалив в середине узел связь не потеряется.
 * --------------------------------------------------------------------------------------------------------
 * HashMap не предполагает упорядоченность данных.
 */

package seminars.sem_05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(); // Создание Map.
        
        map.put("One", "1"); // Добавление ключ: значение.
        map.put("Two", "2");
        map.put("Three", "3");
        map.put("Four", "4");
        map.put(null, null);
        // System.out.println(map); // {null=null, One=1, Four=4, Two=2, Three=3}
        // HashMap не гарантирует последовательность хранения.
        // Сохраняет в той ячейке, в которую попадает hash значения.
        map.put("One", "52");
        // .put() - добавит и заменит 
        // Если такой ключ был, то он заменит значение по ключу, если такого ключа не было, то он
        // добавит пару ключ: значение.
        System.out.println(map); // {null=null, One=52, Four=4, Two=2, Three=3}
        map.putIfAbsent("Five", "5");
        // .putIfAbsent() - Добавит ключ значение, если такого не было и вернёт строку (null).
        // Если такой ключ уже есть, то вернет значение, которое записано по ключу.
        // System.out.println(map.putIfAbsent("Five", "5")); // null
        // System.out.println(map.putIfAbsent("Five", "6")); // 5

        System.out.println(map); // {null=null, Five=5, One=52, Four=4, Two=2, Three=3}

        // System.out.println(map.get("One")); // 52
// Чтобы вытащить значение по ключу.

        System.out.println(map.values()); // [null, 5, 52, 4, 2, 3]
// Чтобы вытащить все значения.

        // КАК пробежаться по массиву map, если там нет индексов??????????????????????????????????????????
        // map.forEach((k,v) -> System.out.println(k + " " + v));
        // k, v - это внутренние переменные, можно по другому назвать. 

// Простой способ:
// Удалять, добавлять ключ или значение нельзя!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // Set <String> keySet = map.keySet(); // В keySet будут храниться все ключи.
        // Collection<String> vol = map.values(); // Покажет все значения.
        // System.out.println(vol); // [null, 5, 52, 4, 2, 3]
        // System.out.println(keySet); // [null, Five, One, Four, Two, Three]

// Сложный способ:+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// В нем можно добавлять, удалять, менять и т.д.+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // for (int i = 0; i < keySet.size(); i++) {
        //     System.out.println("" + keySet.toArray()[i] + " " + map.get(keySet.toArray()[i]));
        // }  
// keySet.toArray()[i] - сам по себе keySet это не массив, а Set.
// Чтобы из него выбрать значения, которые я могу выбрать ключём, я его преобразую 
// просто в массив (.toArray()) и дальше уже из этого массива выбираю нужный ключ ([i]).
// map.get(keySet.toArray()[i]) - что бы выбрать значение.   

// Третий способ (простой):
// Удалять, добавлять ключ или значение нельзя!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            // for (String tmp : keySet) { 
            //     System.out.println(tmp); // Выведит ключи.
            // }
            // for (String tmp : keySet) {
            //     System.out.println(map.get(tmp)); // Выведит значения.
            // }

// Iterator - это ещё одни способ:

        // Iterator<String> iterator = map.values().iterator();
        // while (iterator.hasNext()) {
        //     String tmp = iterator.next();
        //     System.out.println(tmp); // Выведит значения. 
        // }

        // Чтобы удалить ключи из исходной таблицы 

        // Iterator<String> iterator = map.keySet().iterator();
        // while (iterator.hasNext()) {
        //     String tmp = iterator.next();
        //     System.out.println(tmp); // Выведит ключи. 
        //     iterator.remove(); // Удалит ключи из исходного массива (map) и из своего массива (tmp).
        // }
        // System.out.println(map); // {} // Исходный массив пуст.
           
        
        // map.compute("One", (k,v) -> v=k);
// .compute() - это метод, который позволяет простым образом изменять данные в Map.
// Он сначала выбирает данные, для указанного ключа ("One"), если нет такого ключа, то добавит.
// Если такой ключ есть, то выбирает данные и называет их локально (k, v). 
// Дальше можно делать с этими переменными (k, v), всё что угодно.
        map.compute("One!", (k,v) -> v="12"); 

        // System.out.println(map); // {null=null, Five=5, One=52, Four=4, Two=2, One!=12, Three=3}
        
        map.computeIfPresent("!", (k,v) -> v="001"); 
// .computeIfpresent() - Добавит изменения, только если такой ключ существует.
        // System.out.println(map); // {null=null, Five=5, One=52, Four=4, Two=2, One!=001, Three=3}
        
        map.computeIfAbsent("Eight", v -> v="333");
// .computeIfAbsent() - Добавит ключ: значение, только если этого ключа не существут.
// Формула проще, т.к. если этого ключа нет, то он и подставиться.
        // System.out.println(map);
// --------------------------------------------------------------------------------------------------------
/**
 * В чем разница между HashMap и Map? 
 * Map - это интерфейс, в котором описаны какие методы должны быть в классе.
 * List - то же интерфейс, а ArrayList - это его реализация.
 * Map <String, String> map1 = new HashMap<>(); // Инициализация объекта типа HashMap.
 */
        // System.out.println(map.containsKey("2334"));
// .containsKey() - Проверит если такой ключ в map и вернёт false или true.
        // map.clear(); // Все удалит.
        // System.out.println(map.size()); // 8 
// .size() - покажет сколько пар ключ: значение записано.
        // System.out.println(map.getOrDefault("123", "defVol"));
// .getOrDefault() - возвращает значение по ключу, если ключ присутствует.
        System.out.println(map);
// =====================================================================================================

        // LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
// LinkedHashMap<> - Это расширение, для HashMap.
// Отличается только тем, что в LinkedHashMap есть последовательность хранения.
        // linkedHashMap.put("One", "1"); // Добавление ключ: значение.
        // linkedHashMap.put("Two", "2");
        // linkedHashMap.put("Three", "3");
        // linkedHashMap.put("Four", "4");
        // System.out.println(linkedHashMap); // {One=1, Two=2, Three=3, Four=4}
// =======================================================================================================

        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("One", "1"); // Добавление ключ: значение.
        treeMap.put("Two", "2");
        treeMap.put("Three", "3");
        treeMap.put("Four", "4");
        treeMap.put("five", "5");
        System.out.println(treeMap); // {Four=4, One=1, Three=3, Two=2, five=5}
/**
 * Отличия TreeMap от HashMap:
 * Он вообще другой, он сложнее.
 * 
 *                  (5)
 *                 /   \
 *               (3)   (17)
 *              /  |    |  \
 *            (1) (4)  (12) (703)
 * 
 * Эта последовательность может идти в любой последовательности, но ключи не повторяются и ключи 
 * уже отсортированы (1, 3, 4, 5, 12, 17, 703).
 */ 
        System.out.println(treeMap.headMap("Tree", true));
        System.out.println(treeMap.tailMap("Tree", false));
// .headMap() - вернёт map-у начиная с головы и заканчивая указанным ключом в параметрах.
// .tailMap() - вернёт map-у начиная с казанного ключа в параметрах и до конца.

    }
}
