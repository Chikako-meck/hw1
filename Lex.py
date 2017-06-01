#!/usr/bin/env python
# -*- coding: utf-8 -*-

import itertools
import numpy as np
import re
from collections import OrderedDict

matchWord = [""]
wordA = ['j','k','q','x','z']
wordB = ['c','f','h','l','m','p','v','w','y']

def toList(string):
    wordList = [""] * (len(string))
    for i in range(len(string)):
        wordList[i] = string[i]
    return wordList

def makeDictionary(filename):
    file = open(filename)
    dictionary = OrderedDict()
    line = file.readline()
    for i in range(72412):
        text = (line.rstrip('\n')).lower()
        dictionary[i] = text
        line = file.readline()
    file.close()
    return dictionary
        
def makeSortedDictionary(filename):
    file = open(filename)
    sortedDictionary = OrderedDict()
    line = file.readline()
    for i in range(72412):
        text = (line.rstrip('\n')).lower()
        listedLine = toList(text)
        listedLine.sort()
        sortedDictionary[toString(listedLine)] = i
        line = file.readline()
    file.close()
    return sortedDictionary

def toString(lst):
    maped_list = map(str, lst)
    result = "".join(maped_list)
    return result
    
def matchWord(input, dictionary, sortedDictionary):
    global matchWord
    if ((input in sortedDictionary) == True):
        index = sortedDictionary[input]
        counter = 1
        word = dictionary[index]
        for i in range(len(word)):
            if((word[i] in wordA) == True):
               counter += 3
            elif((word[i] in wordB) == True ):
                counter += 2
            else:
                counter += 1
        return (counter*counter, word)
    else:
        pass
    
if __name__ == '__main__':
    dictionary = makeDictionary('dictionary.txt')
    sortedDictionary = makeSortedDictionary('dictionary.txt')
    input = raw_input()
    wordList = toList(input)
    if (("q" in wordList) == True):
        index = wordList.index("q")
        wordList[index] = "qu"
    wordList.sort() # 入力文字列を昇順にソート
    resultList = []
    # 組み合わせ (1)
    # 繰り返しを許さない: 1,1 はない
    # 順序が違っても同じと見なす: 1,2 と 2,1 は同じ
    for i in range(3, len(wordList)+1):
        for element in itertools.combinations(wordList, i):
            result = matchWord(toString(element), dictionary, sortedDictionary)
            if((result in resultList) == False):
                resultList.append(result)
    resultList.sort()
    for list in resultList:
        print(list)
