# 6-1_Programacion_sobre_Redes
# Programación Sobre Redes 2025
## Galeano Martin
- Mail: martin.galeanoet32@gmail.com
- 6to1ra Computación
- ET32 de14

## Gonzalo Nicolás Consorti
Profesor de la materia


## 

# Ramas/Branches

-   Las clases estan en ramas que se llaman como el tema visto en clase
-   Las guias estan en ramas separadas llamadas igual
-   Dentro de las ramas de guias estan las carpetas con los ejercicios

##

Consigna

Ingresar datos numéricos (por diferentes orígenes, sin usar la clase Scanner para leer o escribir e ingresando, por lo menos, 2 veces el numero ‘0’ por cada uno de los orígenes de datos entrantes e enviarlos a un algoritmo que los almacene en 2 sectores de memoria distintos:
volátil (en memoria) – “vectores”, para guardar la información en tiempo real (ingresar por lo menos 5 valores). Vector de 5 espacios.
no-volátil (disco) – “archivos de texto”, para guardar y leer los datos del proceso (guardar por lo menos 5 valores). Uno por cada renglón. //no crear el archivo de texto a mano.
Leer los datos numéricos del vector cargado en el punto 1 y generar 2 archivos de salida: -Por un lado, los resultados de dividir entre cada dato leído y el número que quede de la siguiente operación (siguiente número del vector - 3) en un archivo “resultados.txt”. Con el formato en un renglón por cuenta: numero1 / numero2 = resultado -Y por el otro lado, cada vez que la división tire un error matemático o de falta de algún número de entrada, guardar el error correspondiente en un archivo “error.txt” ubicado en la carpeta del proyecto. ”. Con el formato en un renglón por cuenta: numero1 / numero2 = error

Leer los datos numéricos de los 2 orígenes guardados en el punto 1 y generar 2 archivos de salida: -Por un lado, los resultados de la división entre cada dato leído y el numero 3 en un archivo “resultados.txt”. Con el formato en un renglón por cuenta: numero1 / numero2 = resultado -Y por el otro lado, cada vez que la división tire un error matemático o de falta de algún número de entrada, guardar el error correspondiente en un archivo “error.txt” ubicado en la carpeta del proyecto.

La divicion por el numero 0 o por un valor vacio sabemos que no es posible (ya que da infinito, osea error), asi que sabiendo que esto puede pasar (que lo sabemos) y el tipo de excepcion que nos va a devolver (ArithmeticException -> en caso de dividir por '0' y NullPointerException -> en caso de faltarle alguno de los 2 numero a dividir) podemos atrapar el error para que el programa siga funcionando hasta terminar su rutina y cada vez que suceda, dar un error de aviso.

