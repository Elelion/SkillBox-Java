• WHERE - используется для фильтрации результатов в операторах
SELECT, INSERT, UPDATE или DELETE.
Например:
SELECT `id`, `name` FROM `good` WHERE `count` <= 50;
Или
SELECT * FROM `order_status` WHERE `code` != 'NEW';

• AND - позволяет объединять условия
Например:
SELECT * FROM `order_status` WHERE `code` != 'NEW' AND id > 4;

• BETWEEN - упрощает условия содержащие диапазон (между). Ниже приведенный
пример выведет данные где id >= 4 && id <= 6.
Например:
SELECT * FROM `order_status` WHERE `id` BETWEEN 4 AND 6;