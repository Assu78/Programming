from tkinter import *

# code will right between this 
window = Tk()


def from_Kg():
    gram = float(e1_value.get())*1000
    pounds= float(e1_value.get())*2.20462
    ounces = float(e1_value.get())*35.274

    t1.insert(END,gram)
    t2.insert(END,pounds)
    t3.insert(END,ounces)


label = Label(window, text="kg")
label.grid(row = 0, column = 0)

e1_value = StringVar()
e1 = Entry(window, textvariable = e1_value)
e1.grid(row= 0, column= 1)

b1 = Button(window, text = "Convert", command= from_Kg)
b1.grid(row=0, column=2)

t1=Text(window, height=1, width = 20)
t1.grid(row=1, column=0)

t2=Text(window, height=1, width = 20)
t2.grid(row=1, column=1)

t3=Text(window, height=1, width = 20)
t3.grid(row=1, column=2)

# and this
window.mainloop()
