package homework.collections;

import homework.list.task2.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.*;

@Data
@AllArgsConstructor
@ToString
class Human implements Comparable<Human> {
    //Создайте класс Human c полями name, age, iq.
    private String name;
    private int age;
    private int iq;

    //Реализуйте Comparable (сортировать по имени)
    @Override
    public int compareTo(Human o) {
        return this.getName().compareTo(o.getName());
    }
}

class HumanByAgeComparator implements Comparator<Human> {
    //Реализуйте Comparator (сортировать по возрасту)
    @Override
    public int compare(Human h1, Human h2) {
        return Integer.compare(h1.getAge(), h2.getAge());
    }
}

public class ListAndSetAndMap {
    public static void task1() {
        List<Integer> integerList = new ArrayList<>(20);
        //Заполните список случайными числами типа Integer (1-10).
        for (int i = 0; i < 20; i++) {
            integerList.add((int) (1 + (Math.random() * 9)));
        }
        //Выведите список начиная с первого элемента, затем выведите список начиная с последнее элемента.
        integerList.forEach(System.out::print);
        System.out.println();
        for (int i = 19; i > -1; i--) {
            System.out.print(integerList.get(i));
        }
        System.out.println();
        //Напечатайте максимум и минимум в списке.
        Collections.sort(integerList);
        System.out.println(integerList.get(0));
        System.out.println(integerList.get(integerList.size() - 1));
        //Удалите повторяющиеся элементы в списке(если есть) и распечатайте его.
        Set<Integer> noRepeats = new HashSet<>(integerList);
        integerList.clear();
        integerList.addAll(noRepeats);
        integerList.forEach(System.out::print);
        System.out.println();
        //Создайте списки людей. Проверьте сортировки. Печать с пом. Iterator, for(), forEach(obj ->)
        String[] names = {"Anton", "Boris", "Constantin", "Dmitri", "Egor", "Fyodor", "Georgy", "Homa", "Ivan", "Jacob"};
        List<Human> humansList = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            humansList.add(new Human((names[(int) (Math.random() * names.length)]), (int) ((Math.random() * 25) + 25), (int) ((Math.random() * 50) + 75)));
        }
        humansList.forEach(System.out::println);
        System.out.println();
        Collections.sort(humansList);
        Iterator<Human> humanIterator = humansList.listIterator();
        while (humanIterator.hasNext()) {
            System.out.println(humanIterator.next().toString());
        }
        System.out.println();
        humansList.sort(new HumanByAgeComparator());
        humansList.forEach(human -> {
            System.out.println(human.toString());
        });
        System.out.println();
    }

    public static void task2() {
        String[] names = {"Anton", "Boris", "Constantin", "Dmitri", "Egor", "Fyodor", "Georgy", "Homa", "Ivan", "Jacob"};
        Set<Human> humansSet = new HashSet<Human>(20);
        ////Заполните множество объектами типа Human.
        for (int i = 0; i < 20; i++) {
            humansSet.add(new Human((names[(int) (Math.random() * names.length)]), (int) ((Math.random() * 25) + 25), (int) ((Math.random() * 50) + 75)));
        }
        //Намеренно добавьте объекты с одинаковыми полями:
        //.add(new Human(“John”, 35));
        //.add(new Human(“John”, 35));
        humansSet.add(new Human("John", 35, 100));
        System.out.println("Can I add another John? : " + humansSet.add(new Human("John", 35, 100)));
        //Используя Iterator напечатайте список персон, например, в виде – <NAME> : <AGE>
        for (Human human : humansSet) {
            System.out.println(String.format("<%s> : <%d>", human.getName().toUpperCase(), human.getAge()));
        }
        System.out.println();
        //Обеспечьте хранение уникальных объектов в множестве. Повторите пред. пункт.
        /**
         * HashSet и так обеспечивает хранение только уникальных объектов?
         */
        for (Human human : humansSet) {
            System.out.println(String.format("<%s> : <%d>", human.getName().toUpperCase(), human.getAge()));
        }
        System.out.println();
        //Выведите список используя FOREACH.
        humansSet.forEach(System.out::println);
        System.out.println();
        //Напечатайте максимум и минимум в списке.
        /**
         * отсортируем по возрасту
         */
        List<Human> humansList = new ArrayList<>(humansSet);
        humansList.sort(new HumanByAgeComparator());
        System.out.println(humansList.get(0));
        System.out.println(humansList.get(humansList.size() - 1));
        System.out.println();
        //Удалите персон чей IQ ниже среднего.
        double avg = 0.0;
        for (Human human : humansSet) {
            avg += human.getIq();
        }
        avg = avg / humansSet.size();
        System.out.println("average IQ = " + avg);
        System.out.println();
        Set<Human> retardsSet = new HashSet<Human>(humansSet.size() / 2);
        for (Human human : humansSet) {
            if (human.getIq() < avg) {
                retardsSet.add(human);
            }
        }
        humansSet.removeAll(retardsSet);
        humansSet.forEach(System.out::println);
        System.out.println();
        //Отсортируйте по IQ, Напечатайте result.
        humansList.clear();
        humansList.addAll(humansSet);
        humansList.sort(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getIq(), h2.getIq());
            }
        });
        humansList.forEach(System.out::println);
        System.out.println();
    }

    public static void task3(String foreignText) {
        //Получив на входе текст (на каком-нибудь языке) построить частотный словарь.
        //Map<Integer, String>, where Integer - frequency , String – any word
        //Знаки препинания, скобки, кавычки и числа должны быть удалены. Слова, содержащие в себе не буквенные символы, игнорируются целиком.
        String result = foreignText.toString().replaceAll("\n", " ").replaceAll("\\w+[^A-Za-zА-Яа-я0-9 ]\\w+", "")
                .replaceAll("[^A-Za-zА-Яа-я0-9 ]", "").toLowerCase();
        String[] strings = result.split(" +");
        HashMap<String, Integer> frequencyWordbook = new HashMap<>(strings.length);
        for (String s : strings) {
            int counter = 0;
            for (String string : strings) {
                if (s.equals(string)) {
                    counter++;
                }
            }
            frequencyWordbook.put(s, counter);
        }
        frequencyWordbook.forEach((s, integer) -> System.out.println(s + " : " + integer));
        //Создайте словарик (не большой) рус-англ. , Map<String, List<String>>
        //Например –
        //“speak” : [“говорить, “разговаривать”]
        //“each” : [“каждый“,“всякий“]
        Map<String, List<String>> ruEnVocabulary = new HashMap<>();
        ruEnVocabulary.put("boy", new ArrayList<>(Arrays.asList("мальчик")));
        ruEnVocabulary.put("point", new ArrayList<>(Arrays.asList("точка", "рубеж")));
        ruEnVocabulary.put("who", new ArrayList<>(Arrays.asList("кто")));
        ruEnVocabulary.put("it", new ArrayList<>(Arrays.asList("это")));
        ruEnVocabulary.put("you", new ArrayList<>(Arrays.asList("ты")));
        ruEnVocabulary.put("world", new ArrayList<>(Arrays.asList("мир")));
        ruEnVocabulary.put("oh", new ArrayList<>(Arrays.asList("ох")));
        ruEnVocabulary.put("will", new ArrayList<>(Arrays.asList("будет", "станет")));
        ruEnVocabulary.put("to", new ArrayList<>(Arrays.asList("чтобы")));
        ruEnVocabulary.put("save", new ArrayList<>(Arrays.asList("спасать")));
        //Создайте список предложений которые хотите перевести с англ. на русский и наоборот:
        //“Everyone must first be able to listen and only then speak” , “……” : List<String> en
        //“Каждый должен сперва уметь слушать а лишь потом говорить” , “……”: List<String> rus
        List<String> en = new ArrayList<>(Arrays.asList(foreignText.split("\n")));
        List<String> rus = new ArrayList<>(en);
        //В начале перевода – печать всего словаря с сортировкой по ключу в консоль.
        ruEnVocabulary.forEach((s, strings1) -> System.out.println(s + " : " + strings1));
        System.out.println();
        //Попробуйте найти перевод в существующем словаре.
        //Если его нет, то добавьте в словарь ключ (слово перевод которого не найдено в словаре),
        // в переводимом предложении оставляем его на англ. языке:
        for (String s : rus) {
            String[] words = s.toLowerCase().split(" ");
            for (String w : words) {
                if (ruEnVocabulary.containsKey(w) && !ruEnVocabulary.get(w).contains("")) {
                    w = ruEnVocabulary.get(w).toString();
                }
                else {
                    if (!w.replaceAll("[^A-Za-zА-Яа-я0-9 ]", "").equals("")){
                        ruEnVocabulary.put(w,new ArrayList<>(Arrays.asList("")));
                    }
                }
                //Печатаем каждый шаг в консоль.
                System.out.print(w + " ");
            }
            System.out.println();
        }
        //В конце перевода - печать новых слов которые были добавлены в словарь.
        ruEnVocabulary.forEach((s, strings1) -> {
            if (ruEnVocabulary.get(s).contains("")) {
                System.out.println(s);
            }
        });
    }

    public static void main(String[] args) {
        task1();
        task2();
        task3("Modern Talking - Who Will Save The World \n" +
                "Father they have written \n" +
                "On the point of no return \n" +
                "Soldiers they will come and \n" +
                "Oh they're coming to burn \n" +
                "I said : Oh boy, we need your hope to live \n" +
                "Oh boy, you have so much to give \n" +
                "Oh boy, don't let it get you down \n" +
                "Who, baby, who will save the world ? \n" +
                "( it's not too late ) \n" +
                "Who, baby, who will save the world ? \n" +
                "( all heroes hesitate ) \n" +
                "I'm too young to die \n" +
                "I'm too young to die \n" +
                "Father, I've been looking \n" +
                "Through a rainbow of tears \n" +
                "Found yourself so lonely \n" +
                "Oh they're drowning in my fear \n" +
                "I said : Oh boy, I'm old enough to know \n" +
                "Oh boy, that it hurts to grow \n" +
                "Oh boy, don't let it get you down");
    }
}
