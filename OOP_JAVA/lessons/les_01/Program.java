/**
 * Объектно-ориентированное программирование (лекции).
 * ..........................................................................................
 * Урок 1. Введение в ООП. Свои типы и концепты.
 * ===========================================================================================
 * План занятия:
 * 1. Введение
 * 2. Класс и объект: детали
 * 3. Наполнение
 * 4. Концепты ООП
 * 5. Примеры использования
 * 6. Итоги
 * ---------------------------------------------------------------------------------------------
 * Введение:
 * Способ управления сложными системами: «Разделяй и властвуй».
 * Это значит, что программную систему нужно разбить на подсистемы так, чтобы работу каждой
 * из них можно было рассматривать и совершенствовать независимо от других.
 * 
 * Правильное план – реализация только после абстракций
 * Абстракция – что делает, та или иная сущность?
 * Поведение – как делает?
 * Спецификация – набор правил, описывающих API
 * ????????????????????????????????????????????????????????????????????????????????????????????????????
 * Класс и его экземпляру:
 * 
 * Класс – это «чертеж» (описание) сущности предметной области, позволяющий выделить
 * некоторые общие характеристики, состояние и поведение, зависящее от состояния.
 * 
 * Предметная область — множество всех предметов (явлений) решаемой проблемы.
 * ----------------------------------------------------------------------------------------------------
 * Экземпляр класса.
 * 
 * Экземпляр класса – отдельный представитель класса, имеющий КОНКРЕТНОЕ состояние
 * и поведение, которое полностью определяется описанием класса.
 * 
 * Состояние – набор данных (полей, атрибутов, членов класса).
 * 
 * Поведение – функции для работы с данными и выполнения полезной работы.
 * 
 * (Состояние)   (Поведение)
 * ● Поля        ● Конструкторы
 * ● Константы   ● Методы
 * ● События
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * ООП – объектно-ориентированное программирование.
 * Парадигма (стиль, шаблон) разработки ПО, основными понятиями которой являются классы и объекты.
 * Говорят, что разработка в стиле ООП ведется с использованием классов объектов, которые
 * обладают состоянием и поведением, зависящим от этого состояния.
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Пример стихийный подход: Ex001
 * Пример ООП: 
 * Ex002
 * Описал сущность ТОЧКА, инкапсулировал (передал) туда значения x и y.
 * Ex003
 * Наполнил класс дополнительным поведением.
 * Конструкторы и методы.
 * ======================================================================================================
 * ООП: Инкапсуляция.
 * Инкапсуляция – это свойство системы, позволяющее объединить данные и методы, работающие
 * с ними в классе, скрыв детали реализации и защитив от пользователя этого класса объектов. 
 */
// public class Point2D {
//     int x;
//     int y;
//    } 
/**
 * ООП: Инкапсуляция. Задача
 * Описать робота, который…
 * Пример: Ex004
 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * ООП: Наследование
 * Наследование – это свойство системы, позволяющее описать новый класс на основе уже существующего,
 * с частично или полностью заимствующейся функциональностью.
 * Класс, от которого производится наследование, называется базовым или родительским.
 * Новый класс – потомком, наследником или производным классом.
 */
// public class Point2D {
//     int x;
//     int y;
//    }
//    public class Point3D extends Point2D {
//     int z;
//    }
/**
 * ООП: Наследование
 * Описать игру, которая…
 * Пример: Ex005
 * Допустим, нужно описать игру в рамках которой будет два класса описывающих игровых персонажей.
 * Дальше в рамках каждого персонажа опешу функционал.
 * -----------------------------------------------------------------------------------------------
 * Что не так с этим кодом?
 * ------------------------------------------------------------------------------------------------
 * Нарушает принцип "Don't repeat yourself!".
 * Тут одинаковая реализация персонажей и методов с разницей в одну строку elixir или mana.
 * Это плохо, т.к. персонаже может быть много и каждому выделять по 58 строк кода не нужно.
 * Как это решить?
 * Принцип наследования! 
 * Описываю общее состояние и поведение. 
 * Дальше при необходимости дополняю новый класс используя частично или быть может полностью
 * описанный ранее функционал.
 * ------------------------------------------------------------------------------------------------
 * Пример: Ex006
 * В первую очередь описываю всю логику, которая справедлива, для любого из персонажей
 * BaseHero.java
 * Далее описываю класс Magician который extends (наследует) класс BaseHero.
 * Теперь я могу использовать все методы, которые были описаны в родительском классе BaseHero.
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Модефикатор доступа (protected) - зачит то, что помечено им, будет доступно в рамках текущего класса
 * и в рамках всех классов наследников.
 * Все что помечено модефикаторами (public и protected) будет доступно в рамках дочерних классов.
 * Но, если раньше обращаясь к членам текущего класса я писал (this.), то для более легкого ориентирования
 * в коде, когда я общаюсь к членам базового класса нужно писать слово (super.).
 * Priest.java 
 * Тоже самое, что и Magician, с разницей в пару строк.
 * Далее попробую создать из этих персонажей комманду.
 * Teams.java
 * Отдельно его запускаю работает, как пример создания комманды.
 * --------------------------------------------------------------------------------------------------
 * Что не так с этим кодом?
 * Если у меня будет не два персонажа, а 20?
 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * ООП: Полиморфизм
 * Полиморфизм – это свойство системы, использовать объекты с одинаковым интерфейсом без информации о
 * типе и внутренней структуре объекта.
 * Полиморфизм - способность использовать объект вне зависимости от его реализации, благодаря,
 * полиморфной переменной – это переменная, которая может принимать значения разных типов.
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
// Point2D av = new Point3D();
/**
 * ООП: Полиморфизм
 * Переделать игру, которая…
 */

/**
 * Пример: Ex007
 * Добавил функционал.
 * Когда речь идет о полиморфизме, я могу создавать переменную базового класса и положить в неё экземпляр 
 * производного класса (BaseHero hero3 = new Magician()).
 * Далее переделаю логику атак (Attack). Этот метод я вынес в базрвый класс (BaseHero)
 * 
 * Priest
 * Создам комманду персонажей и попробую с ней работать.
 */



package OOP_JAVA.lessons.les_01;

public class Program {
    
}
