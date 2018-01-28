import json
from difflib import get_close_matches

data = json.load(open("data.json"))

def translate(word):
    if word in data:
        return data[word]
    elif word.title() in data:
        return data[word.title()]
    elif word.upper() in data:
        return data[word.upper()]
    elif len(get_close_matches(word, data.keys())) > 0:
        yn = input("Did you mean %s instead? Y/N. \n" %get_close_matches(word, data.keys())[0])
        #yn = yesOrNO
        if yn == "Y":
            return data[get_close_matches(word, data.keys())[0]]
        elif yn == "N":
            return "The word doesn't exist. Please double check it."
        else:
            return "We didn't understand your entry."
    else:
        return "The word doesn't exist. Please double check it."

word = input("Enter word:\n").lower()
output = translate(word)
#Tapa 1
"""
if word in data:
    mean = translate(word)
    for i in mean:
       print (i)
  
else:
    print(translate(word))
"""
#Tapa 2

if type(output) == list:
    for item in output:
        print(item)
else:
    print (output)
