# Дипломный проект курса "Автоматизация тестирования на Java" от Яндекс.Практикум. Часть 3.
Проект по автоматизации UI-тестирования учебного приложения Stellar Burger.

Используемые технологии:
<li> Maven 3.9.1
<li> Selenium 4.8.1
<li> Rest-Assured 5.3.0
<li> JUnit 4.13.2
<li> Allure 2.21.0
<li> Gson 2.8.9
<li> ChromeDriver 110.0.5481.77
<li> Yandexdriver 23.3.0

Тесты актуальны для следующих версий браузеров:
<li> Chrome Browser 110.0.5481.78
<li> Yandex Browser 110.0.5481.719

Для корректной работы необходимо скачать и установить версии драйверов и браузеров, указанных выше.

Как запускать тесты на разных браузерах:
1. В файле ```conf.properties``` прописать пути для ```chromedriver``` и ```yandexdriver```, включая сам файл (для ос Windows - с расширением)
2. В терминале выполнить команду ```mvn clean test -Dbrowser="your browser"```, где вместо ```your browser``` указать ```chrome```, если нужно запустить тесты в хроме, или ```yandex```, если нужно запустить тесты в яндекс.браузере

Для просмотра отчета Allure необходимо из корневой папки проекта в терминале выполнить команду ```mvn allure:serve```.

Если у вас не открывается страница отчета (долгая загрузка и последующая ошибка соединения), попробуйте отключить на время антивирус.
