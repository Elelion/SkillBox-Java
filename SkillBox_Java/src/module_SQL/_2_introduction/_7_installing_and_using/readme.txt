- Ставим MySQL на ПК
- Создаем БД
- Импортируем дамп БД shop.sql
- поля которые имеют значение NULL - являюся родительскими полями (ВАЖНО!)

- далее идем в SQL WorkBranch и создаем еще одну БД
- нажимаем на Create a new schema (бочка с плюсом)
    и называем ее show / utf8 / utf8_general_ci -> Apply -> Apply

- когда БД создалась, переходим во вкладу Administration -> Management ->
    Data import / Restore

    выбираем пункт - Import from Self-Contained File -> указываем путь до дампа
    и выбираем БД в какюу его надо залить - Default Target Schema

