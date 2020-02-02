#include <iostream>
#include <fstream>
#include <string>
#include <unordered_map> // Estructura equivalente a HashTable
#include <iterator>
#include <utility>

using namespace std;

int calcularPuntos(unordered_map<int, int> aux);
void guardarEnArchivo(unordered_map<int, int> aux);

const string inputFileName = "file.in";
const string outputFileName = "solution.out";

int main()
{
    int m, n, i;
    int *types;

    /* PARTE 1: Lectura de fichero */
    ifstream inputFile;
    inputFile.open(inputFileName);
    inputFile >> m >> n; // m <- numero trozos; n <- número tipos
    types = new int[n];

    for (i = 0; i < n; i++)
    {
        inputFile >> types[i];
    }

    inputFile.close();

    /* PARTE 2: Tratamiento de datos */
    /* ALGORITMO All-random by Mario */
    int randomSize, randomNumber, max = 0, pTemp;
    while (true)
    {
        unordered_map<int, int> temp;
        randomSize = rand() % n + 1; // Tamaño aleatorio de numero de pizzas
        while (temp.size() < randomSize)
        {
            randomNumber = rand() % n; // Acceso aleatorio a la pizza
            temp.insert({randomNumber, types[randomNumber]});
        }
        pTemp = calcularPuntos(temp);
        if (pTemp <= m && pTemp > max)
        {
            max = pTemp;
            guardarEnArchivo(temp);
            /* cout << "Nueva versión con " << pTemp << " puntos";  // No va, preguntar a Asier el porqué */
        }
    }
}

int calcularPuntos(unordered_map<int, int> aux)
{
    int cont = 0;
    unordered_map<int, int>::iterator it = aux.begin();
    while (it != aux.end())
    {
        cont += (it->second);
        it++;
    }
    return cont;
}

void guardarEnArchivo(unordered_map<int, int> aux)
{
    ofstream outputFile;
    outputFile.open(outputFileName);

    outputFile << aux.size() << endl;
    unordered_map<int, int>::iterator it = aux.begin();
    while (it != aux.end())
    {
        outputFile << it->first << " ";
        it++;
    }
    outputFile << endl;

    outputFile.close();
}