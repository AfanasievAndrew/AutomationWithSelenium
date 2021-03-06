#language: ru
  Функционал: Страхование
    Сценарий: Страхование путешественников

      Когда выбран пункт меню "Страхование"
        И выбран пункт под меню "Путешествия и покупки"
      Тогда проверен label на новой странице

      Когда выполнено нажатие на кнопку "Оформить онлайн"
      Тогда выполнено ожидание загрузки страницы страхования

      Когда выбрана сумму страховой защиты "Минимальная"
      Когда выполнено нажатие на конпку "Оформить"

      Когда заполняются поля Застрахованные:
        |Name|Name|
        |Surname|Surname|
        |BirthDate|01.01.2000|

      Когда заполняются поля Страхователь:
        |Surname|Фамилия|
        |Name|Имя|
        |Middlename|Отчество|
        |BirthDate|01.01.2000|
        |PassportSeries|1111|
        |PassportNumber|111111|
        |PassportIssueDate|01.01.2014|
        |PassportIssuePlace|Кем выдан|

      Когда выбран пол "Male"

      Тогда выполнена проверка заполненых полей

      Когда выполнено нажатие на кнопку "Продолжить"
      Тогда выполнена проверка на предупреждающее сообщение "Заполнены не все обязательные поля"

      Тогда выполнена проверка заполненых полей