#import psycopg2
import psycopg2


def create_table():
    conn = psycopg2.connect("dbname='database1' user='postgres' password='postgressql135' host='localhost' port=5432'")
    #method of connection object
    cur = conn.cursor()
    
    cur.execute("CREATE TABLE store (item TEXT, quantity INTEGER, price REAL)")
   # cur.execute("INSERT INTO store VALUE ('Wine Glass', 8, 10.5)")
    
    
    conn.commit()
    conn.close()

#create_table()

def insert(item,quantity,price):
    conn=psycopg2.connect("dbname='database1' user='postgres' password='postgressql135' host='localhost' port='5432'")

    cur = conn.cursor()
    # it's too risky to use str %s
    cur.execute("INSERT INTO store VALUES(%s,%s,%s)", (item,quantity,price))

    conn.commit()
    conn.close()
    
#insert("Coffee Glass", 107, 50.05)



def view():
    conn = psycopg2.connect("dbname='database1' user='postgres' password='postgressql135' host='localhost' port='5432'")
    cur = conn.cursor()
    cur.execute("SELECT * FROM store")
    rows = cur.fetchall()
    # we are collecting data that is why we don't need commit command
    #conn.commit()
    conn.close()
    return rows


print(view())

def delete(item):
    conn = psycopg2.connect("dbname='database1' user='postgres' password='postgressql135' host='localhost' port='5432'")
    cur = conn.cursor()
    cur.execute("DELETE FROM store WHERE item = %s", (item,))

    conn.commit()
    conn.close()

#delete("Golden Glass")


def update(quantity,price,item):
    conn = psycopg2.connect("dbname='database1' user='postgres' password='postgressql135' host='localhost' port='5432'")
    cur = conn.cursor()
    cur.execute("UPDATE store SET quantity = %s, price = %s WHERE item = %s", (quantity, price, item))
    conn.commit()
    conn.close()


#update(100, 25.5, "Red Vine Glass")

