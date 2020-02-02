import random

def AllRandom():
  file = open("input.in", "r")
  data = file.readline().split(" ")
  types = file.readline().split(" ")

  max = 0;
  while True:
    dict = {}
    randomSize = random.randint(1, int(data[1]))
    while len(dict) < randomSize:
      randomNumber = random.randint(0, int(data[1]) - 1)
      dict[randomNumber] = int(types[randomNumber])
    
    pTemp = CalcularPuntos(dict)
    if pTemp < int(data[0]) and pTemp > max:
      max = pTemp
      print("Nueva solución con {0} puntos", pTemp)
      GuardarArchivo(dict)

def CalcularPuntos(map):
  cont = 0;
  for data in map:
    cont += data
  return cont;

def GuardarArchivo(map):
  file = open("output.out", "w")
  file.write(str(len(map)) + "\n")
  for data in map:
    file.write(str(data) + " ")
  file.close()

if __name__ == "__main__":
  AllRandom()