import time
from datetime import datetime as dt

# same directry
#copy path
host = "hosts"
# real path
hosts_path = r"C:\Windows\System32\drivers\etc\hosts"
redirect = "127.0.0.1"

website_list = ["www.facebook.com", "facebook.com", ]


while True:
    if dt(dt.now().year, dt.now().month, dt.now().day, 8) < dt.now() < dt(dt.now().year, dt.now().month, dt.now().day, 16):
        print("Working hours...")
        with open(hosts_path, "r+") as file:
            content = file.read()
            for website in website_list:
                if website in content:
                    pass
                else:
                    file.write( redirect + " " + website + "\n")
        
    else:
        with open(hosts_path, "r+") as file:
            content = file.readlines()
            file.seek(0)
            for line in content:
                if not any(website in line for website in website_list):
                    file.write(line)
               # for website in website_list:
                #    if line != website_list:
                 #       pass
                #file.write(line)
# delet from current lne to downward
            file.truncate()
            
        print("Fun hours...")

    time.sleep(5)
