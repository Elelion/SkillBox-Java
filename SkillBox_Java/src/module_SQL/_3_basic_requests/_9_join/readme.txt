• JOIN (inner) - объединять, то есть собирать из нескольких кусочков
единое целое. В базе данных MySQL такими "кусочками" служат столбцы таблиц,
которые можно объединять при выборке. Нижний пример читается, как:
- SELECT - Выбрать из таблицы 1 и таблицы 2 указанные поля, которые нужно
выводить. categoryName и goodName - являются псевдонимами имен, тут можно
написать любое название.
- FROM - Выводим из таблицы good наши записи которые найдем
- JOIN - указываем таблицу good_category, с которой нужно связать нашу
таблицу good
- ON - подразумевается как ПО, те мы связываем таблицы по определенному
условию, в нашем примере написано, что таблицу good_category нужно
присоединять к таблице good таким образом, что бы значения id 1ой таблицы
и значения category_id 2ой таблицы были равны

Пример 1:
SELECT `good_category`.`name` categoryName, `good`.`name` goodName
FROM `good`
JOIN `good_category`
ON `good_category`.`id` = `good`.`category_id`;

Пример 2 (более сложный):
SELECT
	c.name,
    g.name,
    o.creation_date orderDate,
    u.name
FROM `good` g
JOIN `good_category` c ON c.id = g.category_id
JOIN `order2good` o2g ON o2g.good_id = g.id
JOIN `order` o ON o.id = o2g.order_id
	AND o.creation_date BETWEEN '2017-08-01' AND '2017-08-31'
JOIN `user` u ON u.id = o.user_id;

• JOIN (left) - объединить со смешением в лево, те к первой таблице. В
примере ниже, строка типа: `good` g означает создание псевдонима, что
бы не писать каждый раз все имя таблицы.

Пример:
SELECT
	g.id,
    g.name,
    o2g.order_id,
    o2g.good_id
FROM `good` g
LEFT JOIN order2good o2g
ON o2g.good_id = g.id;

Что это значит ? - MySQL LEFT JOIN возвратит все записи из table1(g) и
только те записи из table2(o2g), которые пересекаются с table1.