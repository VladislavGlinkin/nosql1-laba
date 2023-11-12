// Written by Vladislav Glinkin

import scala.io.Source
import scala.io.StdIn.readChar

def countCharacter(name: String) = name.count(_ == character)

// Считываем файл в переменную в виде строки
val fileContents = Source.fromFile("text.txt").getLines.mkString

print("Character is: ")
val character = readChar()

// Из строки делаем лист, элементами которого являются слова
var splitList: List[String] = fileContents.toLowerCase().split(" ").toList

// Сортируем по алфавиту и оставляем только уникальные слова
var uniqList = splitList.sorted.distinct

// Сортируем по частоте появления символа
var sortedUniqList = uniqList.sortBy(countCharacter)

for(i <- sortedUniqList)
	println(i + " " + i.count(_ == character))
