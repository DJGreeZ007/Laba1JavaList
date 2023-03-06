public class List {
    /*
    * Поле head - элемент списка, обозначающий начало.
    * Сам элемент не виден пользователю, зарезервирован для простоты удаления и добавления элементов
     */
    private Node head;
    /*
     * Поле tail - элемент списка, обозначающий конец.
     * Сам элемент не виден пользователю, зарезервирован для простоты удаления и добавления элементов
     */
    private Node tail;
    /*
     * Поле count - обозначает количество элементов, которое хранится в listE.
     * За исключением начального и конечного.
     */
    private int count;
    /*
     * Конструктор класса.
     */
    public List() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        count = 0;
    }
    /*
     * Необязательный метод класса, требуемый для отладки и нахождения ошибок
     */
    public void ErrorMess () {
        System.out.println("Error");
    }
    /*
     * <p>Добавляет элемент в начало списка.</p>
     * @param value Значение, которое нужно вставить в список (целочисленное)
     */
    public void AddToHead(int value) {
        Node newNode = new Node(value, head, head.next);
        head.next = newNode;
        newNode.next.prev = newNode;
        count++;
    }
    /*
     * <p>Добавляет элемент в конец списка.</p>
     * @param value Значение, которое нужно вставить в список (целочисленное)
     */
    public void AddToTail(int value) {
        Node newNode = new Node(value, tail.prev ,tail);
        tail.prev = newNode;
        newNode.prev.next = newNode;
        count++;
    }
    /*
     * <p>Добавляет элемент в список на заданное положение.</p>
     * @param value Значение, которое нужно вставить в список (целочисленное)
     * @param pos Позиция элемента.
     * Если позиция выходит за пределы списка слева или справа, то добавляется
     * элемент соответственно в начало или конец списка.
     */
    public void AddWithPos (int value, int pos) { //если позиция за пределами контейнера, добавляется в конец
        if(pos >= count) {
            AddToTail(value);
        }
        else if(pos <= 0) {
            AddToHead(value);
        }
        else {
            Node curNode = head;
            for (int i = 0 ; i < pos && i < count; ++i) {
                curNode = curNode.next;
            }
            Node newNode = new Node(value, curNode, curNode.next);
            curNode.next = newNode;
            newNode.next.prev = newNode;
            count++;
        }
    }
    /*
     * <p>Возвращает количество элементов в списке</p>
     * @return количество элементов.
     */
    public int GetCount () {
        return count;
    }


    /*
     * <p>Возвращает значение элемента на текущей позиции</p>
     * <p>Если такого элемента не существует возвращает минимальное допустимое значение Integer</p>
     * @param pos Позиция элемента в списке.
     * @return value Значение элемента
     */
    public int GetElement(int pos) { //с позицией
        int result;
        if(pos < 0 || pos >= count) {
            ErrorMess();
            result =  Integer.MIN_VALUE;
        }
        else {
            Node curNode = head.next;
            for (int i = 0; i < pos; ++i) {
                curNode = curNode.next;
            }
            result =  curNode.value;
        }
        return result;
    }


    /*
     * <p>Возвращает значение первого элемента(аналогично GetElement(0))</p>
     * <p>Если такого элемента не существует возвращает минимальное допустимое значение Integer</p>
     * @return value Значение элемента
     */
    public int GetElement() {
        return GetElement(0);
    }
    /*
     * <p>Удаляет первый элемент списка</p>
     * @return true если удаление прошло успешно, и false - если нет (В списке нет элементов).
     */
    public boolean DeleteFromHead() {
        boolean result = false;
        if(count > 0) {
            Node delNode = head.next;
            head.next = head.next.next;
            head.next.prev = head;
            delNode = null;
            count--;
            result = true;
        }
        return result;
    }
    /*
     * <p>Удаляет последний элемент списка</p>
     * @return true если удаление прошло успешно, и false - если нет (В списке нет элементов).
     */
    public boolean DeleteFromTail() {
        boolean result = false;
        if(count > 0) {
            Node delNode = tail.prev;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            delNode = null;
            count--;
            result = true;
        }
        return result;
    }
    /*
     * <p>Удаляет элемент списка на заданной позиции</p>
     * @param pos Позиция элемента в списке.
     * @return true если удаление прошло успешно, и false - если нет
     * (В списке нет элементов или нет элемента на выбранной позиции).
     */
    public boolean DeleteWithPos (int pos) {
        boolean result = false;
        if (pos == 0 ) {
            result = DeleteFromHead();
        }
        else if (pos == count - 1) {
            result = DeleteFromTail();
        }
        else if (pos > 0 && pos < count - 1) {
            Node nodeBeforeDel = head;
            for (int i = 0; i < pos; ++i) {
                nodeBeforeDel = nodeBeforeDel.next;
            }
            Node delNode = nodeBeforeDel.next;
            nodeBeforeDel.next = nodeBeforeDel.next.next;
            nodeBeforeDel.next.prev = nodeBeforeDel;
            delNode = null;
            count--;
            result = true;
        }
        return result;
    }


    /*
     * <p>Возвращает первый элемент списка.</p>
     * <p>Аналогичен последовательному возврату и удалению элемента из списка</p>
     * @return value. Если список пуст, возвращает минимальное допустимое значение Integer.
     */
    public int ExtractionFromHead () {
        int result;
        if (count < 1) {
            ErrorMess();
            result = Integer.MIN_VALUE;
        }
        else {
            result = GetElement();
            if(!DeleteFromHead()) {
                ErrorMess();
                result = Integer.MIN_VALUE;
            }
        }
        return result;
    }
    /*
     * <p>Возвращает последний элемент списка.</p>
     * <p>Аналогичен последовательному возврату и удалению элемента из списка</p>
     * @return value. Если список пуст, возвращает минимальное допустимое значение Integer.
     */
    public int ExtractionFromTail () {
        int result;
        if (count < 1) {
            ErrorMess();
            result = Integer.MIN_VALUE;
        }
        else {
            result = GetElement(count-1);
            if(!DeleteFromTail()) {
                ErrorMess();
                result = Integer.MIN_VALUE;
            }
        }
        return result;
    }
    /*
     * <p>Возвращает элемент списка с заданной позицией.</p>
     * <p>Аналогичен последовательному возврату и удалению элемента из списка</p>
     * @param pos Позиция элемента в списке.
     * @return value. Если список пуст, возвращает минимальное допустимое значение Integer.
     */
    public int ExtractionWithPos (int pos) {
        int result;
        if (pos == 0 ) {
            result = ExtractionFromHead();
        }
        else if (pos == count - 1) {
            result = ExtractionFromTail();
        }
        else if (pos > 0 && pos < count - 1) {
            result = GetElement(pos);
            if(!DeleteWithPos(pos)) {
                ErrorMess();
                result = Integer.MIN_VALUE;
            }
        }
        else {
            ErrorMess();
            result = Integer.MIN_VALUE;
        }
        return result;
    }
    /*
     * Необязательный метод класса, требуемый для отладки и нахождения ошибок
     */
    public void PrintAllElements() {
        System.out.println("====================");
        Node curNode = head.next;
        for (int i = 0; i < count; ++i) {
            System.out.println(curNode.value);
            curNode = curNode.next;
        }
        System.out.println("====================");
    }

}
