# Инструкция по запуску
## Команда для запуска программы:
`java -jar *.jar ...`\
"/*" - название собранного jar-файла;\
"..." - любая последовательность, состоящая из txt-файлов и следующих ключей:\
"-p" - флаг, означающий, что следующий аргумент командной строки будет рассматриваться в качестве префикса в названии выходных файлов;\
"-o" - флаг, означающий, что следующий аргумент командной строки будет рассматриваться как путь, где будут находиться выходные файлы;\
"-a" - флаг, включающий опцию дописывания уже в существующие выходные файлы, если таких нет, то они будут созданы;\
"-f" - флаг, включающий опцию вывода краткой сводки о том сколько элементов каждого типа было записано в файлы;\
"-s" - флаг, включающий опцию вывода полной сводки о том сколько элементов каждого типа было записано в файлы, среднее значени, сумма, максимальное и минимальное значения для чисел, наименьшая и наибольшая длина строки;\
Если же флаг "-f", "-s" отсутствуют, то никакой статистики не будет выведено;
## Версия Java
Java SE 21 (LTS)
