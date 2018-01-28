import sqlite3
def create_table():
    conn = sqlite3.connect("lite.db")
    #method of connection object
    cur = conn.cursor()
    
    cur.execute("CREATE TABLE store (item TEXT, quantity INTEGER, price REAL)")
   # cur.execute("INSERT INTO store VALUE ('Wine Glass', 8, 10.5)")
    
    
    conn.commit()
    conn.close()

def insert(item,quantity,price):
    conn=sqlite3.connect("lite.db")
    cur = conn.cursor()
    cur.execute("INSERT INTO store VALUES(?,?,?)", (item,quantity,price))

    conn.commit()
    conn.close()
    
#insert("Coffee Glass", 15, 5.9)



def view():
    conn = sqlite3.connect("lite.db")
    cur = conn.cursor()
    cur.execute("SELECT * FROM store")
    rows = cur.fetchall()
    # we are collecting data that is why we don't need commit command
    #conn.commit()
    conn.close()
    return rows


print(view())

def delete(item):
    conn = sqlite3.connect("lite.db")
    cur = conn.cursor()
    cur.execute("DELETE FROM store WHERE item = ?", (item,))

    conn.commit()
    conn.close()

#delete("Golden Glass")


def update(quantity,price,item):
    conn = sqlite3.connect("lite.db")
    cur = conn.cursor()
    cur.execute("UPDATE store SET quantity = ?, price = ? WHERE item = ?", (quantity, price, item))
    conn.commit()
    conn.close()


#update(100, 25.5, "Wine Glass")
