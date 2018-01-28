import urllib.request


def read_text():
    file = open(r"C:\Users\asad\Desktop\OOM_Tärkeät_asiat.txt")
    read = file.read()
    #print(read)
    file.close()
    check_curse_word(read)


def check_curse_word(check_word):
    #link = "http://www.wdylike.appspot.com/?q= " +check_words
    #print (link)
    
    url = urllib.request.urlopen("http://www.wdylike.appspot.com/?q=shit"+ check_word)
    output = str(url.readline())
    print(output)
    url.close()
    if "true" in output:
        print("Alert!!! \n there is curse word in this document")
    elif("false" in output):
        print("this document has no curse words!")
    else:
        print("Could not scan properly.")

#check_curse_word()
read_text()
