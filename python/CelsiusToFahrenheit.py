temperature = [10,-20,-200,100,50]

"""
This function convert celsius to fahrenheitpy

"""
def celsiusToFahrenheit(c):
  with open("TextFile.txt","w") as file:
          for i in c:
              if i > -273.15:
                  f = i*9/5+32
                  file.write(str(f)+"\n")

celsiusToFahrenheit(temperature)
