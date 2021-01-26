<strong>ArrayList и LinkedList</strong>

Добавление в конец: связный список быстрее, т.к. в ArrayList иногда происходит переполнение памяти и копирование в новый участок.

Вставка в произвольное место: LinkedList на порядок быстрее, т.к. опять же, в ArrayList нужно сдвигать элементы

Удаление случайного элемента: аналогично

Получение элемента по индексу: ArrayList быстрее раз в 100. Ему не нужно сдвигаться от элемента к элементу, он сразу получает адрес в памяти нужного элемента.

<strong>HashSet, LinkedHashSet, TreeSet </strong>

Добавление: HashSet самый быстрый. На втором месте LinkedHashSet, которому нужно ещё дополнительно создавать связи между элементами. Самый медленный TreeSet, которому нужно упорядочивать элементы при каждой вставке.

Поиск: На малых размерах самым быстрым оказывается LinkedHashSet. При больших размерах самым быстрым является TreeSet, т.к. элементы в нём отсортированы и поиск выполняться за логарифмическое время. Самым медленным почти во всех случаях является HashSet

Удаление: Почти всегда самым быстрым оказывается LinkedHashList.

<strong> HashMap, LinkedHashMap, TreeMap </strong>

Резульаты такие же, как и у множеств, т.к. в большинстве своём устроены они одинакого.

<strong> LinkedList, MyLinkedList </strong>

Вставка в конец в MyLinkedList быстрее, т.к. отсутствуют дополнительные проверки. Все остальные операции медленнее, т.к. MyLinkedList представляет собой односвязный список.