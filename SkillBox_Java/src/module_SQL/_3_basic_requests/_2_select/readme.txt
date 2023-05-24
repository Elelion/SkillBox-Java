• COUNT - Посчитать количество значений по полю согласно условию
Пример:
SELECT COUNT(*) FROM `order`WHERE `status_id` = 7;

• SELECT - позволяет выбрать данные из таблицы
Пример:
SELECT * FROM tableName;
SELECT `name`, `price` FROM `good`;

• Указываем имена столбцов для вывода данных
Пример:
SELECT
	`category_id` productCategory,
    `price` productname
FROM `good` WHERE 1;

И при выводе наши столбци будут называться не как они есть в БД: category_id, price а теми именами что мы им дали.

• Мат операции над полями и вывод результата
Пример:
SELECT  `name`, (`count` * `price`) `totalCost` FROM `good`;
