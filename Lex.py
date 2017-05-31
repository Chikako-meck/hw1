#!/usr/bin/env python
# -*- coding: utf-8 -*-

import itertools
import numpy as np

def toList(string):
    wordList = [""] * (len(string))
    for i in range(len(string)):
        wordList[i] = string[i]
    return wordList

def makeDictionary(filename):
    file = open(filename)
    dictionary = [""] * 72421
    line = file.readline()
    for i in range(72412):
        text = line.rstrip('\n')
        dictionary[i] = text
        line = file.readline()
    file.close()
    return dictionary
        
def makeSortedDictionary(filename):
    file = open(filename)
    sortedDictionary = [""] * 72421
    line = file.readline()
    for i in range(72412):
        text = line.rstrip('\n')
        listedLine = toList(text)
        listedLine.sort()
        sortedDictionary[i] = toString(listedLine)
        line = file.readline()
    file.close()
    return sortedDictionary

def toString(lst):
    maped_list = map(str, lst)
    result = "".join(maped_list)
    return result
    
def matchWord(input, dictionary, sortedDictionary):    
    if ((input in sortedDictionary) == True):
        index = sortedDictionary.index(input)
        print(dictionary[index])
    else:
        pass
    
if __name__ == '__main__':
    dictionary = makeDictionary('dictionary.txt')
    sortedDictionary = makeSortedDictionary('dictionary.txt')
    input = raw_input()
    wordList = toList(input)
    wordList.sort() # 入力文字列を昇順にソート
    # 組み合わせ (1)
    # 繰り返しを許さない: 1,1 はない
    # 順序が違っても同じと見なす: 1,2 と 2,1 は同じ
    for i in range(3, len(wordList)+1):
        for element in itertools.combinations(wordList, i):
            matchWord(toString(element), dictionary, sortedDictionary)
      
