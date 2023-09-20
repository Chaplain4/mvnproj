package homework.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class StackAndQueue {
    public static void taskA() {
//В игре в пьяницу карточная колода раздается поровну двум игрокам. Далее они вскрывают по одной верхней карте, и тот,
// чья карта старше, забирает себе обе вскрытые карты, которые кладутся под низ его колоды.
// Тот, кто остается без карт – проигрывает.
//Для простоты будем считать, что все карты различны по номиналу, а также, что самая младшая карта побеждает самую
// старшую карту ("шестерка берет туза").
//Игрок, который забирает себе карты, сначала кладет под низ своей колоды карту первого игрока, затем карту второго
// игрока (то есть карта второго игрока оказывается внизу колоды).
//Напишите программу, которая моделирует игру в пьяницу и определяет, кто выигрывает. В игре участвует 10 карт,
// имеющих значения от 0 до 9, большая карта побеждает меньшую, карта со значением 0 побеждает карту 9.
        ArrayList<Card> deck = new ArrayList<Card>(36);
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 14; j++) {
                if (Pips.getPipsByNum(j) != null) {
                    deck.add(new Card(Suits.getSuitSByNum(i), Pips.getPipsByNum(j)));
                }
            }
        }
        Collections.shuffle(deck);
        Deque<Card> playerOne = new ArrayDeque<>(36);
        Deque<Card> playerTwo = new ArrayDeque<>(36);
        Deque<Card> exchange = new ArrayDeque<>(36);
        for (int i = 0; i < deck.size(); i++) {
            if (i % 2 == 0) {
                playerOne.addFirst(deck.get(i));
            } else playerTwo.addFirst(deck.get(i));
        }
        int exchangeCounter = 0;
        while (!(playerTwo.isEmpty() || playerOne.isEmpty())) {
            exchange.addLast(playerTwo.pollFirst());
            exchange.addFirst(playerOne.pollFirst());
            if (exchange.peekFirst().getPip() == Pips.ACE && exchange.peekLast().getPip() == Pips.SIX) {
                do {
                    playerTwo.addLast(exchange.pollLast());
                } while (!exchange.isEmpty());
                exchangeCounter++;
            } else if (exchange.peekFirst().getPip() == Pips.SIX && exchange.peekLast().getPip() == Pips.ACE) {
                do {
                    playerOne.addLast(exchange.pollLast());
                } while (!exchange.isEmpty());
                exchangeCounter++;
            } else if (Pips.getNumByPips(exchange.peekFirst().getPip()) > Pips.getNumByPips(exchange.peekLast().getPip())) {
                do {
                    playerOne.addLast(exchange.pollLast());
                } while (!exchange.isEmpty());
                exchangeCounter++;
            } else if (Pips.getNumByPips(exchange.peekFirst().getPip()) < Pips.getNumByPips(exchange.peekLast().getPip())) {
                do {
                    playerTwo.addLast(exchange.pollLast());
                } while (!exchange.isEmpty());
                exchangeCounter++;
            }
            if (exchangeCounter > 1000000) {
                System.out.println("botva!");
                break;
            }
        }
        if (playerTwo.isEmpty()) {
            System.out.println("Player 1 wins!");
        }
        if (playerOne.isEmpty()) {
            System.out.println("Player 2 wins!");
        }
        System.out.println(exchangeCounter);
    }

    public static void taskD(Deque<Integer> wayA) {
        //Задача D. Сортировка вагонов
        //К тупику со стороны пути 1 (см. рисунок) подъехал поезд. Разрешается отцепить от поезда один или сразу несколько первых
        //вагонов и завезти их в тупик (при желании, можно даже завезти в тупик сразу весь поезд). После этого часть из этих вагонов
        //вывезти в сторону пути 2. После этого можно завезти в тупик еще несколько вагонов и снова часть оказавшихся вагонов вывезти
        //в сторону пути 2. И так далее (так, что каждый вагон может лишь один раз заехать с пути 1 в тупик, а затем один раз
        //выехать из тупика на путь 2). Заезжать в тупик с пути 2 или выезжать из тупика на путь 1 запрещается. Нельзя с пути 1
        //попасть на путь 2, не заезжая в тупик.
        //Известно, в каком порядке изначально идут вагоны поезда. Требуется с помощью указанных операций сделать так, чтобы
        //вагоны поезда шли по порядку (сначала первый, потом второй и т.д., считая от головы поезда, едущего по пути 2 в сторону от тупика).
        int a = 0;
        int b = 0;
        Stack<Integer> deadEnd = new Stack<>();
        Deque<Integer> wayB = new ArrayDeque<>();
        while (!(wayA.isEmpty())) {
            if (wayB.isEmpty()) {
                do {
                    deadEnd.add(wayA.pollFirst());
                } while (!(deadEnd.peek() == 1));
                a = deadEnd.size();
                System.out.println("1 " + a);
                do {
                    wayB.addLast(deadEnd.pop());
                } while (!(deadEnd.isEmpty()) && wayB.peekLast() + 1 == deadEnd.peek());
                b = a - deadEnd.size();
                System.out.println("2 " + b);
            } else {
                do {
                    deadEnd.add(wayA.pollFirst());
                } while (!(deadEnd.peek() - 1 == wayB.peek()));
                a = deadEnd.size();
                System.out.println("1 " + a);
                do {
                    wayB.addLast(deadEnd.pop());
                } while (!(deadEnd.isEmpty()) && wayB.peekLast() + 1 == deadEnd.peek());
                b = a - deadEnd.size();
                System.out.println("2 " + b);
            }
            if (wayA.isEmpty() && (!deadEnd.isEmpty())) {
                System.out.println("0");
            }
        }
    }

    public static void taskE(Deque<Character> brackets) {
        Stack<Character> characterStack = new Stack<>();
        while (!brackets.isEmpty()) {
            if (brackets.peekFirst() == '(' || brackets.peekFirst() == '[' || brackets.peekFirst() == '{') {
                characterStack.push(brackets.pollFirst());
            } else if (characterStack.isEmpty()) {
                System.out.println("No");
                break;
            } else if (brackets.peekFirst() == ')' || brackets.peekFirst() == ']' || brackets.peekFirst() == '}') {
                if ((brackets.peekFirst() == ')' && characterStack.peek() != '(') || (brackets.peekFirst() == ']' && characterStack.peek() != '[') || (brackets.peekFirst() == '}' && characterStack.peek() != '{')) {
                    System.out.println("No");
                    break;
                } else {
                    characterStack.pop();
                    brackets.pollFirst();
                }
            }
            if (characterStack.isEmpty() && brackets.isEmpty()) {
                System.out.println("Yes");
            }
        }
    }

    public static void taskF(String students) {
//В каждой строке сначала записан номер класса (число, равное 9, 10 или 11), затем (через пробел) – фамилия ученика.
//Необходимо вывести список школьников по классам: сначала всех учеников 9 класса, затем – 10, затем – 11. Внутри одного
// класса порядок вывода фамилий должен быть таким же, как на входе.
        String[] strings = students.split("\n");
        Deque<String> grade9 = new ArrayDeque<>();
        Deque<String> grade10 = new ArrayDeque<>();
        Deque<String> grade11 = new ArrayDeque<>();
        for (String s : strings) {
            if (s.startsWith("9")) {
                grade9.addLast(s);
            } else if (s.startsWith("10")) {
                grade10.addLast(s);
            } else grade11.addLast(s);
        }
        grade9.forEach(System.out::println);
        grade10.forEach(System.out::println);
        grade11.forEach(System.out::println);
    }

    public static void taskG(String calculation) {
//В постфиксной записи (или обратной польской записи) операция записывается после двух операндов.
// Например, сумма двух чисел A и B записывается как A B +. Запись B C + D * обозначает привычное нам (B + C) * D,
// а запись A B C + D * + означает A + (B + C) * D.
        Deque<String> operands = new ArrayDeque<>(Arrays.asList(calculation.split(" ")));
        Deque<String> values = new ArrayDeque<>();
        while (!operands.isEmpty()) {
            if (operands.peekFirst().matches("\\d")) {
                values.addFirst(operands.pollFirst());
            } else if (values.size() < 2) {
                System.out.println("Error!");
                break;
            } else if (operands.peekFirst().equals("+")) {
                operands.pollFirst();
                String newNum = String.valueOf(Integer.parseInt(Objects.requireNonNull(values.pollFirst())) + Integer.parseInt(Objects.requireNonNull(values.pollFirst())));
                values.addFirst(newNum);
            } else if (operands.peekFirst().equals("-")) {
                operands.pollFirst();
                Integer a = Integer.valueOf(Objects.requireNonNull(values.pollFirst()));
                Integer b = Integer.valueOf(Objects.requireNonNull(values.pollFirst()));
                String newNum = String.valueOf(b - a);
                values.addFirst(newNum);
            } else if (operands.peekFirst().equals("*")) {
                operands.pollFirst();
                Integer a = Integer.valueOf(Objects.requireNonNull(values.pollFirst()));
                Integer b = Integer.valueOf(Objects.requireNonNull(values.pollFirst()));
                String newNum = String.valueOf(b * a);
                values.addFirst(newNum);
            } else if (operands.peekFirst().equals("/")) {
                operands.pollFirst();
                Integer a = Integer.valueOf(Objects.requireNonNull(values.pollFirst()));
                Integer b = Integer.valueOf(Objects.requireNonNull(values.pollFirst()));
                String newNum = String.valueOf(b / a);
                values.addFirst(newNum);
            }
        }
        if (values.size() != 1) {
            System.out.println("Error!");
        } else System.out.println(values.getLast());
    }

    public static void taskH(int docks, int cargoHolds, int maxBarrels) {
//На барже располагается K грузовых отсеков. В каждый отсек можно поместить некоторое количество бочек с одним из 10 000
// видов топлива. Причём извлечь бочку из отсека можно лишь в случае, если все бочки, помещённые в этот отсек после неё,
// уже были извлечены. Таким образом, в каждый момент времени в каждом непустом отсеке имеется ровно одна бочка, которую
// можно извлечь не трогая остальных. Будем называть такие бочки крайними.
//Изначально баржа пуста. Затем она последовательно проплывает через N доков, причём в каждом доке на баржу либо
// погружается бочка с некоторым видом топлива в некоторый отсек, либо выгружается крайняя бочка из некоторого отсека.
// Однако, если указанный отсек пуст, либо если выгруженная бочка содержит не тот вид топлива, который ожидалось,
// следует зафиксировать ошибку. Если на баржу оказывается погружено более P бочек или если после прохождения всех доков
// она не стала пуста, следует также зафиксировать ошибку. От вас требуется либо указать максимальное количество бочек,
// которые одновременно пребывали на барже либо зафиксировать ошибку.
        int barrelCounter = 0;
        int maxBarrelCounter = 0;
        boolean isOK = true;
        Map<Integer, Stack<Integer>> cargoShip = new HashMap<Integer, Stack<Integer>>();
        for (int i = 0; i < cargoHolds; i++) {
            cargoShip.put(i + 1, new Stack<>());
        }
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < docks; i++) {
            String nextOp = sc.nextLine();
            String[] opDetail = nextOp.substring(2).split(" ");
            Stack<Integer> newCargohold = cargoShip.get(Integer.valueOf(opDetail[0]));
//Если в нём происходит погрузка, то строка имеет вид «+ A B», где A — номер отсека, в который помещается бочка, а
// B — номер вида топлива в ней.
            if (nextOp.startsWith("+")) {
//Если на баржу оказывается погружено более P бочек или если после прохождения всех доков
//она не стала пуста, следует также зафиксировать ошибку.
                if (maxBarrels == barrelCounter) {
                    System.out.println("Error");
                    isOK = false;
                    break;
                }
                newCargohold.push(Integer.valueOf(opDetail[1]));
                cargoShip.put(Integer.valueOf(opDetail[0]), newCargohold);
                barrelCounter++;
                if (barrelCounter > maxBarrelCounter) {
                    maxBarrelCounter = barrelCounter;
                }
            } else {
//если указанный отсек пуст, либо если выгруженная бочка содержит не тот вид топлива, который ожидалось,
// следует зафиксировать ошибку.
                if (newCargohold.isEmpty() || !newCargohold.peek().equals(Integer.valueOf(opDetail[1]))) {
                    System.out.println("Error");
                    isOK = false;
                    break;
                } else {
                    newCargohold.pop();
                    cargoShip.put(Integer.valueOf(opDetail[0]), newCargohold);
                    barrelCounter--;
                }
            }
        }
        if (barrelCounter != 0) {
            System.out.println("Error");
            isOK = false;
        }
        if (isOK) {
            System.out.println(maxBarrelCounter);
        }
    }

    public static void taskI(String balloons) {
//В одной компьютерной игре игрок выставляет в линию шарики разных цветов. Их может быть очень много...
//Когда образуется непрерывная цепочка из трех и более шариков одного цвета, она удаляется из линии.
//Все шарики при этом сдвигаются друг к другу, и ситуация может повториться.
//Напишите программу, которая по данной ситуации определяет, сколько шариков будет сейчас уничтожено.
//Естественно, непрерывных цепочек из трех и более одноцветных шаров в начальный момент может быть не более одной.
        String[] arr = balloons.split(" ");
        Stack<Integer> line = new Stack<>();
        Stack<Integer> popLine = new Stack<>();
        int popCounter = 0;
        for (String s : arr) {
            line.push(Integer.valueOf(s));
        }
        while (line.size() > 2) {
            popLine.push(line.pop());
            if (line.peek().equals(popLine.peek())) {
                popLine.push(line.pop());
                if (line.peek().equals(popLine.peek())) {
                    popCounter = 3;
                    popLine.push(line.pop());
                    while (line.peek().equals(popLine.peek())) {
                        popCounter++;
                        popLine.push(line.pop());
                    }
                }
            }
        }
        System.out.println(popCounter);
    }

    public static void taskJ(Map<Integer, Stack<Integer>> depot) {
//На складе хранятся контейнеры с товарами N различных видов. Все контейнеры составлены в N стопок.
//В каждой стопке могут находиться контейнеры с товарами любых видов (стопка может быть изначально пустой).
//Автопогрузчик может взять верхний контейнер из любой стопки и поставить его сверху в любую стопку.
//Необходимо расставить все контейнеры с товаром первого вида в первую стопку, второго вида — во вторую стопку и т.д.
//Программа должна вывести последовательность действий автопогрузчика или сообщение о том, что задача решения не имеет.
        if (depot.size() < 2) {
            System.out.println("No actions needed");
        } else if (depot.size() == 2) {
            while (!depot.get(1).isEmpty()) {
                depot.get(0).push(depot.get(1).pop());
                System.out.println("1 0");
            }
            while (depot.get(0).peek() != 0) {
                depot.get(1).push(depot.get(0).pop());
                System.out.println("0 1");
            }
            if (depot.get(0).contains(1)) {
                System.out.println("Unable");
            }
        } else {
            for (int i = 1; i < depot.size(); i++) {
                while (!depot.get(i).isEmpty()) {
                    System.out.println(i + " 0");
                    depot.get(0).push(depot.get(i).pop());
                }
            }
            while (!depot.get(0).isEmpty()) {
                if (depot.get(0).peek() == 0) {
                    depot.get(1).push(depot.get(0).pop());
                    System.out.println("0 1");
                } else {
                    Integer val = depot.get(0).peek();
                    depot.get(val).push(depot.get(0).pop());
                    System.out.println("0 " + val);
                }
            }
            while (!depot.get(1).isEmpty()) {
                if (depot.get(1).peek() == 1) {
                    depot.get(2).push(depot.get(1).pop());
                    System.out.println("1 2");
                } else {
                    depot.get(0).push(depot.get(1).pop());
                    System.out.println("1 0");
                }
            }
            while (depot.get(2).peek() != 2) {
                depot.get(1).push(depot.get(2).pop());
                System.out.println("2 1");
            }

        }
    }

    public static void main(String[] args) {
        taskA();
        taskD(new ArrayDeque<>(Arrays.asList(2, 3, 1)));
        taskE(new ArrayDeque<>(Arrays.asList('[', '(', '(', ')', ')', ']', ']')));
        taskE(new ArrayDeque<>(Arrays.asList('{', '[', '(', ')', '(', '[', ']', '{', '}', ')', '[', ']', ']', '(', '{', '}', '{', '{', '}', '}', ')', '}', '[', ']')));
        taskF("9 Ivanov\n" +
                "10 Petrov\n" +
                "11 Sidorov\n" +
                "9 Grigoryev\n" +
                "9 Sergeev\n" +
                "10 Yakovlev");
        taskG("8 9 + 1 7 - *");
        //  taskH(10, 5, 4);
        taskI("1 0 3 2 4 5 3 1 8 2 6 5 5 5 5 5 5 5 5 7 1 3 0 3 5 4");
        Map<Integer, Stack<Integer>> depot = new HashMap<>();
        Stack<Integer> stack0 = new Stack<>();
        stack0.push(0);
        stack0.push(0);
        stack0.push(1);
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(1);
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(0);
        stack2.push(1);
        stack2.push(2);
        depot.put(0, stack0);
        depot.put(1, stack1);
        depot.put(2, stack2);
        taskJ(depot);
    }
}

class MyStack<T> {

    private int maxSize; // Размер массива
    private T[] stackArray;
    private int top; // Вершина стека

    public MyStack(int maxSize, T[] stackArray) {
        this.maxSize = maxSize;
        this.stackArray = stackArray;
        top = -1;
    }

    public void push(T v) // Размещение элемента на вершине стека
    {
        top++;
        stackArray[top] = v; // Увеличение top, вставка элемента
    }

    public T pop() // Извлечение элемента с вершины стека
    {
        top--;
        return stackArray[top + 1]; // Извлечение элемента
    }

    public T peek() // Чтение элемента с вершины стека
    {
        T t = stackArray[top];
        return t;
    }

    public boolean empty() // true, если стек пуст
    {
        if (top == -1) return true;
        return false;
    }

    public boolean full() // true, если стек полон
    {
        if (top == maxSize - 1) return true;
        return false;
    }

    public void clear() {
        top = -1;
    }
}

class MyQueue<T> {
    private int maxSize;
    private T[] queArray;
    private int front;
    private int rear;
    private int nItems; // Для простоты кода будем хранить и изменять количество элементов

    public MyQueue(int maxSize, T[] queArray) {
        this.maxSize = maxSize;
        this.queArray = queArray;
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void clear() {
        front = -1;
    }

    public void offer(T v) // Добавить элемент в очередь
    {
        if (rear == maxSize - 1) // проверка на конец массива
        {
            rear = -1;
        }
        rear++;
        queArray[rear] = v;
        nItems++; // увеличить счетчик
    }

    public T poll() // Извлечение первого элемента очереди
    {
        T temp = queArray[front]; // взять элемент
        front++;
        if (front == maxSize) // проверка на конец массива
        {
            front = 0;
        }
        nItems--; // уменьшить количество элементов
        return temp;
    }

    public T peek() // Чтение первого элемента очереди
    {
        return queArray[front];
    }

    public boolean empty() // true если очередь пуста
    {
        if (nItems == 0) return true;
        return false;
    }

    public boolean isFull() // true если очередь полна
    {
        if (nItems == maxSize) return true;
        return false;
    }
}

@Data
@AllArgsConstructor
class Card {
    private Suits suit;
    private Pips pip;
}

enum Suits {
    DIAMONDS, CLUBS, HEARTS, SPADES;

    public static Suits getSuitSByNum(int num) {
        switch (num) {
            case 1:
                return DIAMONDS;
            case 2:
                return CLUBS;
            case 3:
                return HEARTS;
            case 4:
                return SPADES;
            default:
                return null;
        }
    }
}

enum Pips {
    ACE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    public static Pips getPipsByNum(int num) {
        switch (num) {
            case 1:
                return ACE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            case 8:
                return EIGHT;
            case 9:
                return NINE;
            case 10:
                return TEN;
            case 11:
                return JACK;
            case 12:
                return QUEEN;
            case 13:
                return KING;
            default:
                return null;
        }
    }

    public static int getNumByPips(Pips pips) {
        switch (pips) {
            case ACE:
                return 14;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case JACK:
                return 11;
            case QUEEN:
                return 12;
            default:
                return 13;
        }
    }
}
