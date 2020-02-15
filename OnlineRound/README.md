# Orden de ejecución de las clases
Main -> 
    InputParser: Genera una lista de String donde cada elemento es a su vez una lista de String es un "parametro" de cada linea del input.
    ->
    ObjectGenerator: Genera una lista de HashCodeObject (Clase que representa un objeto para almacenar la información de cada linea de input).
    ->
    Algorithms: Genera una solución (se entiende como solución como cualquier estructura Iterable). ->
        PointsCalculator: Calcula los puntos dada una solución.
    ->
    OutputGenerator: Escribe un fichero con la solución en el formato necesario.