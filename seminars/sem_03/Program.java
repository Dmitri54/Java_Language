// Урок 3 (семинар).Коллекции JAVA: Введение
// =================================================================================================
/**
 * List. Коллекция.
 */

package seminars.sem_03;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;

// public class Program {
//     public static void main(String[] args) {
//         int a; // Объявление переменной
//         int b = 0; // Инициализация переменной приметивного типа.

//         // List list; // Объявление переменной ссылочного типа.
//         // Если не инициализировать (List list;), то в Steck будет написано, что list не сами данные, а
//         // указатель на место в памяти где лежит структура данных в классе List. Если попробовать к ней 
//         // обратиться, то будет ошибка (адреса нет).
//         // list.add(1); - ошибка, list не инициализирован.
//         List list = new ArrayList<>();// Инициализация переменной ссылочного типа.
//         // new - ключевое слово. Проверяе сколько памяти нужно, для того чтобы описать класс List, 
//         // считае сколько занимаю места переменные, constants (константы), ссылочки, сколько есть 
//         // свободного места. После этого вызывает специальный метод, который наз. КОНСТРУКТОР (ArrayList<>()).
//         // Конструктор - это метод, который приводит мой объект (list) в начальное состояние.
//         // --------------------------------------------------------------------------------------------
//         // Какого типа данные храняться сейчас в list?
//         // Object и в него можно сохранить все типы данных.
//         // ---------------------------------------------------------------------------------------------
//         list.add(12); // Передаю в list символ,
//         list.add("gh"); // строку,
//         list.add(new Random()); // и можно даже ссылку на объект типа Random()
//         // Не удобно будет даставать их, т.к. нужно будет проверять какого типа объект.

//         if (list.get(0) instanceof Integer) {
//             a = (int) list.get(0);
//         }
//         // Чтобы выдернуть элемент пишу если нулевой элемент списка list экземпляр класса Integer, то
//         // его нужно привести к типу int и результат сохраняю в (a).

//         // .get() - это метод, который обращается к элементу списка, но ему нужно указать индекс элемента.
//         // instanceof - instance - это экземпляр класса и дальше я указываю класс.
//         // (int) - это динамическое приведение к типу int в процессе работы программы.

//         if (list.get(2) instanceof String) {
//             System.out.println((String) list.get(0)); // И так можно привести к типу String, 
//             // но работает медленно.
//         }
//         // Вывод: 
//         // 1 - низкая производительность, т.к. мне нужно перед тем как данными воспользоваться 
//         // нужно проверить какие это данные, соответствуют они типу или нет;
//         // 2 - объем; 
//         // 3 - не удобство программирования, очень много лишнего кода.
//         // Поэтому появилось обобщение <> (второе наз. БРИЛИАНТ).
//         List <String> list_1 = new ArrayList();

//     }    
// }
// ------------------------------------------------------------------------------------------------

/**
 * Program
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

public class Program {

    public static void main(String[] args) {
        int a = 0;
        // List <String> list = new ArrayList(); // List - это вообщето не класс, а интерфейс.
        // ArrayList - это класс. Разница в том, что у ArrayList больше методов.
        // Поэтому лучше писать сразу нужный класс.
        ArrayList <String> list = new ArrayList<>();
        list.add("Hello world!"); 
        list.add("Hello");
        list.add("World!");
        list.add("HW!"); // Добавляет в конец.
        // System.out.println(list); // [Hello world!, Hello, World!, HW!]

        list.add(2, "World of Java!"); // Второй метод add (указываются два параметра индекс и что записать)
        // Произойдет сдвиг влево, список делает это за меня.
        // System.out.println(list); // [Hello world!, Hello, World of Java!, World!, HW!]

        list.set(2, "Java!"); // Если я хочу ОБНОВИТЬ элемент.
        // System.out.println(list); // [Hello world!, Hello, Java!, World!, HW!]

        a = list.size(); // Возвращает количество элементов уже записанных в список. Записал в (a).
        list.remove(a - 1); // удалит значение по индексу.
        // (a - 1) т.к. в a хранится количество элементов, а не длинна списка.
        // System.out.println(list); // [Hello world!, Hello, Java!, World!]

        list.add(list.size()/2, "World is beautiful!"); // Вставит в середину списка.
        // System.out.println(list); // [Hello world!, Hello, World is beautiful!, Java!, World!]

        // System.out.println(list.remove("Java!")); // true
        // А так можно удалить элемент списка по значению. Если такого значения нет выдаст false.
        // System.out.println(list); // [Hello world!, Hello, World!]

        // Важно понимать, что в ArrayList храниться указатель на данные и его размер увеличивается с 
        // увиличением количества объектов на величину len/2+1 автоматически.
        // list.size(); - покажет сколько элементв в списке, не длину списка.

        // list.get(0); // Чтобы достать данные.

        // Если нужно вывести все данные.
        for (int i = 0; i < list.size(); i++) { // for - цикл. Можно данные добавлять, изменять, удалять и т.д.
        //     System.out.println(list.get(i));
        }
        // System.out.println();

        for (String str : list) { // foreach - этот цикл явно короче и писать проще, но я не могу его изменить,
        //     // т.к. str - это локальная переменная. 
        //     System.out.println(str);
        }
        
        Iterator<String> iterator = list.iterator(); 
        // Iterator - это набор ссылок на данные которые я ему передаю.
        // Поэтому это набор ссылок (Iterator) на String = далее я говорю чтобы list сгенерировал мне 
        // этот итератор (list.iterator()).
        // .iterator() - генеригует набор этих ссылок.
        while (iterator.hasNext()) { // Может удалять, добавлять, элементы в список. 
            String str = iterator.next();
            // System.out.println(str);
            // iterator.remove(); // Удалит текущий элемент, т.к. итератор всегда указывает на него.
        }

        // .hasNext() - это метод, итератора, который говорит мне о том, есть или ещё в инераторе ссылки, 
        // которые я не использовал. Возвращает boolean если есть следующий элемент.
        // .next() - возвращает следующий элемент.

    
        ListIterator<String> listIterator = list.listIterator(list.size()/2);
        while (listIterator.hasPrevious()) { // 
            String str = listIterator.previous();
            // System.out.println(str);
            // listIterator.remove();
        }
        // .hasPrevious() - если есть предыдущий элемент. Возвращает boolean.
        // .hasNext() - если следующий элемент
        // Если поставить параметр list.size(), то я пробегу итератором от конца к началу.
        // Поэтому пишу .previous() - вернёт мне данные.
        // ListIterator - позволяет двигаться в разные стороны по элементам.

        // Итого: если нужен полный контроль пиши обычный цикл for.
        // foraech, если нужно скачать или где-то ещё их использовать, пробужаться по ним.
        // Iterator, если нужно удалять элементы.
        // ListIterator - позволяет в разные стороны идти по элементам.

        // list.forEach((k) -> System.out.println(k)); // Можно пробежаться по списку. Код в одну строку.
        // У списков есть метод .forEach() - в нем передается специальная запись (лямбда вырожание).
        // (k) - это любое название, обычно пишут (n).
        // Дальше я пишу, что нужно сделать с данными (System.out.println(k)).
        // list.forEach() - обычно используют, чтобы не менять данны, а доставать и спользовать где-то снаружи.

        System.out.println(list); // [Hello world!, Hello, World is beautiful!, Java!, World!]
        // У list переопределен toString, поэтому он выводит корректно содержимое списка.

        System.out.println(list.indexOf("Java!")); // 3
        // .indexOf() - Вернет индекс этого объекта.

        // list.lastIndexOf("Java!"); // Если нужно найти первое вхождение с конца списка.
        
        ArrayList<Integer> lis1 = new ArrayList<>(); // Создал список с целыми числами.
        ArrayList<Integer> lis2 = new ArrayList<>();
        Random rnd = new Random(); // Создал генератор случайных чисел.
        for (int i = 0; i < 8; i++) { // В цикле в оба списка добавил случайные числа от 0 до 8.
            lis1.add(rnd.nextInt(i, 8));
            lis2.add(rnd.nextInt(i, 8));
            
        }
        System.out.println(lis1);
        lis1.sort(new Comparator<Integer>() {
            public int compare(Integer t0, Integer t1) {
                return (t1%3 == 0 && t0%3 == 0)?0:(t1%3 != 0 && t0%3 == 0)?1:- 1; // пишу (t0 - t1), а не 0, чтобы отсортировал, от меньшего к большему.
            };
        }); 
        // СОРТИРОВКА. Ей в параметре нужно передавать некий Comparator - это класс.
        // Он занимается сравнением. Comparator нужно прописывать в ручную, в нем один метод compare,
        // который сравнивает. Принимает два параметра: (t0) число, которое было в списке и (t1) число, 
        // которое нужно добавить в список.
        // Чтобы он его правильно сравнил, нужно выполнить правило, которое заключается в том, что:
        // Если compare возвращает 0, то это означает. что эти значения равны;
        // Если compare возвращает отцательное число, то это значит, что я добавляю больше, чем то, что было;
        // Если compare возвращает положительное число, то я добавляю меньше чем то, что было.
        // т.е. логика проста (t0 - t1) - от меньшего к большему будет сортировка.
        // (t1 - t0) - сортировка будет от большего к меньшему.
        // Заместо этого можно написать всё, что угодно. 
        // Пример: (t1%3 == 0 && t0%3 == 0)?0:(t1%3 != 0 && t0%3 == 0)?1:- 1;
        // Если t1 кратен 3 и t0 кратен 3, то они равны (0), если t1 не кратен 3, а t0 кратен 3, 
        // то считаем t1 больше t0 (1), во всех остальных случаях считаем, что t0 больше t1 (-1).


        // Collections.sort(lis1);
        System.out.println(lis1);
        // Для списков есть класс помощник Collections  и у него есть .sort()
    

        System.out.println(lis2);

        // lis1.removeAll(lis2);
        // .removeAll() - удаляет все элементы из списка, для которого он вызван, 
        // которые встречаются в списке переданным в параметре. Это как фильтр.

        // lis1.retainAll(lis2);
        // .retainAll() - оставляет элементы в списке, для которого он вызван, которые встречаются в 
        // списке переданным в параметре.

        // System.out.println(lis1);

        String[] sArray = new String[list.size()];
        // list.toArray(sArray)[4].; 
        // .toArray() - преобразует список в массив. Он создает массив объектов (Objects), а не сам массив.
        // После точки могу выбрать метод, который нужет.
        // .toArray(T[] a) - Возвращает массив указанного типа в [].

        // list.sort(null) - СОРТИРОВКА.

    }   

}
