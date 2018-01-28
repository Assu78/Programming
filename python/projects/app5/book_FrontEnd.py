"""
A program that store thsi book information
Title, Author, Year, ISBN

User can:

View all record
Search an entry
Add entry
Update entr
Delete
Close
"""

from tkinter import *
import backEnd

def get_selected_row(event):
    global selected_tuple
    # index = id
    index = list.curselection()[0]
    selected_tuple = list.get(index)
    e1.delete(0,END)
    e1.insert(END,selected_tuple[1])

    e2.delete(0,END)
    e2.insert(END,selected_tuple[2])

    e3.delete(0,END)
    e3.insert(END,selected_tuple[3])

    e4.delete(0,END)
    e4.insert(END,selected_tuple[4])


def view_command():
    list.delete(0,END)  #need to know about this line
    for row in backEnd.view():
        list.insert(END,row)

def search_command():
    list.delete(0,END)
    for row in backEnd.search(title_text.get(), author_text.get(),year_text.get(),isbn_text.get()):
        list.insert(END,row)
def add_command():
    backEnd.insert(title_text.get(), author_text.get(),year_text.get(),isbn_text.get())
    list.delete(0,END)
    list.insert(END,(title_text.get(), author_text.get(),year_text.get(),isbn_text.get()))


def delete_command():
    backEnd.delete(selected_tuple)[0]

def update_command():
    backEnd.update(selected_tuple[0],title_text.get(), author_text.get(), year_text.get(), isbn_text.get())

window = Tk()

l1 = Label(window, text="Title")
l1.grid(row = 0, column = 0)

l2 = Label(window, text="Author")
l2.grid(row = 0, column = 2)

l3 = Label(window, text="Year")
l3.grid(row = 1, column = 0)

l4 = Label(window, text="ISBN")
l4.grid(row = 1, column = 2)

#datatype
title_text = StringVar()
e1=Entry(window, textvariable = title_text)
e1.grid(row=0, column=1)

author_text = StringVar()
e2=Entry(window, textvariable = author_text)
e2.grid(row=0, column=3)

year_text = StringVar()
e3=Entry(window, textvariable = year_text)
e3.grid(row=1, column=1)

get_selected_row
isbn_text = StringVar()
e4=Entry(window, textvariable = isbn_text)
e4.grid(row=1, column=3)

list = Listbox(window, height= 6, width=35)
list.grid(row=2, column = 0, rowspan = 6, columnspan=2)

sb = Scrollbar(window)
sb.grid(row=2, column=2, rowspan=6)

list.configure(yscrollcommand=sb.set)
sb.configure(command=list.yview)

list.bind('<<ListboxSelect>>', get_selected_row)




# view_command is a functon
b1 = Button(window, text="View all",width=12, command = view_command)
b1.grid(row=2, column=3)

b2 = Button(window, text="Search entry",width=12, command=search_command)
b2.grid(row=3, column=3) 

b3 = Button(window, text="Add entry",width=12, command=add_command)
b3.grid(row=4, column=3)

b4 = Button(window, text="Update",width=12, command = update_command)
b4.grid(row=5, column=3)

b5 = Button(window, text="Delete",width=12, command = delete_command)
b5.grid(row=6, column=3)

b6 = Button(window, text="Close",width=12, command = window.destroy)
b6.grid(row=7, column=3)

window.mainloop()

