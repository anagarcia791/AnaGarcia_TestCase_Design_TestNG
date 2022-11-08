# Taller testNG

Crear Un proyecto en Java utilizando maven:

- El pom.xml debe contener la dependencia de TestNG.
- .gitignore adaptado a sus necesidades.
- Cree los tests para la página de ESPN (https://www.espn.com.co/) de:
    * Iniciar sesión.
    * Cerrar sesión.
    * Desactivar usuario.
- Debe imprimir en la consola cada paso realizado para la ejecución de las pruebas.
- Idealmente usar loggers.
- Una suite de pruebas (archivo xml) con la ejecución de las clases.
- Incorporar el print en consola simulando los pasos que abren y cierran el browser para cada test.

Nota:
1. Este proyecto NO DEBE INCLUIR nada relacionado con selenium, cada test debe estar conformado por sentencias que impriman en consola lo que haría un test real.
2. La precondición sería tener una cuenta válida de ESPN para los tres tests.