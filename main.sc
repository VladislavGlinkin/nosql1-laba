// Written by Vladislav Glinkin

import scala.io.Source
import scala.collection.immutable.ListMap
import scala.io.StdIn.readChar

def fromFileToMapWithCharFrequency(file_name:String, char:Char):Unit = {
	val wordList:List[String] = Source.fromFile(file_name).getLines.mkString.toLowerCase().split(" ").toList.sorted.distinct
	val character:Char = char
	var characterFrequency:List[Int] = Nil
	for (word <- wordList) {
		characterFrequency = characterFrequency :+ word.count(_ == character)	
	}
	val result_map = (wordList zip characterFrequency).toMap
	val map_by_alphabet = ListMap(result_map.toSeq.sortWith(_._1 < _._1):_*)
	val map_by_value = ListMap(map_by_alphabet.toSeq.sortWith(_._2 < _._2):_*)
	println(map_by_value)
}

def main():Unit = {
	print("Character is: ")
	val char:Char = readChar()
	fromFileToMapWithCharFrequency("text.txt", char)
}

main()
