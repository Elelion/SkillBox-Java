• ORDER BY - сортируют значения по одному или нескольких столбцам,
где ASC (ascending - восходящий) - сортировка по возрастанию,
а DESC (descending - нисходящий) по убыванию.

Пример 1:
SELECT * FROM `good` ORDER BY `name` ASC;

Пример 2 (те будет сортировка по category_id, и
паралельно name в обратном порядке):
SELECT * FROM SkillBox_Shop.good ORDER BY `category_id`, `name` DESC;

• LIMIT - устанавливает лимит на вывод.

Пример 1 (выведет 10 товаров):
SELECT * FROM SkillBox_Shop.good LIMIT 10;

Пример 2 (выведет запросы с 10 по 20):
SELECT * FROM SkillBox_Shop.good LIMIT 10, 20;
