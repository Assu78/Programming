import os
def rename_files():
    file_list = os.listdir(r"C:\Users\asad\Pictures\Screenshots")
  #  print(file_list)
    saved_path = os.getcwd()
    print(saved_path)
    #chage the path
    os.chdir(r"C:\Users\asad\Pictures\Screenshots")
    for file_name in file_list:
        print("Old name: " + file_name)
            
        table = str.maketrans("","","0123456789")
        print("New name: " +file_name.translate(table))
        
        os.rename(file_name, file_name.translate(table))
    os.chdir(saved_path)


rename_files()
