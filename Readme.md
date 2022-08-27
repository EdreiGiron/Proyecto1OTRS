PROYECTO 1 PROGRAMACION II
7690-21-218 E. A. Girón Leonardo
Universidad Mariano Gálvez
egironl12@miumg.edu.gt
https://youtu.be/5kieffP841U

Descripcion Proyecto:
El programa es una solución para poder reportar bus y errores que pueden presentarse en un sistema que se utiliza para la venta de productos en lineal. El programa permite crear tickets con información del error y el cliente que lo reporto, luego de esto el ticket generado se mueve a una cola de mesa de ayuda, la cual contara con la opción de asignar el ticket a un técnico, resolver el ticket o bien escalarlo si el problema no se puede solucionar. El ticket escalara de mesa de ayuda a soporte técnico y de ultimo a desarrollo, el cual solo podrá asignar el ticket y resolverlo. El programa cuenta con la característica de mostrar 3 tipos de reportes, el primero es un listado general de todos los tickets, el segundo es un listado de tickets por cada cola y el tercero es el listado de tickets por usuario.


Diagrama de clases:
classDiagram
direction BT
class Bitacora {
  ~ String fechaHora
  ~ String mensaje
  ~ TipoEvento evento
  ~ String nitSoporte
  + setFechaHora(String) void
  + setMensaje(String) void
  + getFechaHora() String
  + getMensaje() String
  + setEvento(TipoEvento) void
  + getEvento() TipoEvento
  + setNitSoporte(String) void
  + getNitSoporte() String
  + toString() String
}
class ColaAtendidos {
  + escalar(Ticket) void
}
class ColaDesarrollo {
  + escalar(Ticket) void
}
class ColaMesa {
  + escalar(Ticket) void
}
class ColaServicio {
  ~ ArrayList~Ticket~ cola
  ~ TipoCola tipo
  + setTipo(TipoCola) void
  + quitar(Ticket) void
  + setCola(ArrayList~Ticket~) void
  + getTipo() TipoCola
  + agregar(Ticket) void
  + getCola() ArrayList~Ticket~
}
class ColaSoporte
class Prueba {
  + menuPrincipal() void
  + main(String[]) void
  + menuClientes() void
  + menuEmpleados() void
  + menuTickets() void
}
class Ticket {
  ~ String nitUsuario
  ~ int id
  ~ String estado
  ~ ArrayList~Bitacora~ bitacora
  ~ String problema
  + getNitUsuario() String
  + setNitUsuario(String) void
  + toString() String
  + setEstado(String) void
  + getProblema() String
  + getBitacora() ArrayList~Bitacora~
  + BitacoraTicket(Bitacora) void
  + getEstado() String
  + setBitacora(ArrayList~Bitacora~) void
  + getId() int
  + setProblema(String) void
}
class TipoCola {
<<enumeration>>
  - String tipoCola
  +  SOPORTETECNICO
  +  DESARROLLADOR
  +  ATENDIDOS
  +  MESADEAYUDA
  + values() TipoCola[]
  + valueOf(String) TipoCola
  + getTipoCola() String
}
class TipoEvento {
<<enumeration>>
  +  MOVER
  +  CREARTICKET
  +  ASIGNAR
  +  SOLUCION
  - String tipoEvento
  + values() TipoEvento[]
  + valueOf(String) TipoEvento
  + getTipoEvento() String
}

Bitacora "1" *--> "evento 1" TipoEvento 
ColaAtendidos  -->  ColaServicio 
ColaDesarrollo  -->  ColaServicio 
ColaMesa  -->  ColaServicio 
ColaServicio "1" *--> "cola *" Ticket 
ColaServicio "1" *--> "tipo 1" TipoCola 
ColaSoporte  -->  ColaServicio 
Prueba  ..>  Bitacora : «create»
Prueba  ..>  ColaAtendidos : «create»
Prueba  ..>  ColaDesarrollo : «create»
Prueba  ..>  ColaMesa : «create»
Prueba  ..>  ColaSoporte : «create»
Prueba  ..>  Ticket : «create»
Ticket "1" *--> "bitacora *" Bitacora 


Manual de usuario:

El programa comenzara lanzando el siguiente menu:

------------------MENU PRINCIPAL-------------------
 1. Cliente. 
 2. Empleado. 
 3. Reporte de Tickets. 
10. Salir.
Seleccione una opcion:

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

La opcion numero 1 es Cliente, al seleccionar la opcion se mostrara el siguiente menu:

------------------CLIENTES-------------------
 1. Reportar Problema. 
10. Salir.
Seleccione una opcion:

Este menu dara la opcion al cliente de poder reportar un problema o bug encontrado en el programa:

--------------REPORTAR DE PROBLEMA---------------
Por favor proporcione los siguientes datos.

Ingrese su NIT:
Por favor, detalle el problema presentado:

Al ingresar los datos se habra generado el ticket del cliente.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------MENU PRINCIPAL-------------------
 1. Cliente. 
 2. Empleado. 
 3. Reporte de Tickets. 
10. Salir.
Seleccione una opcion:

La opcion numero 2 es Empleado, al seleccionar la opcion se despliega el siguiente menu:

------------------EMPLEADOS-------------------
 1. Registrar. 
10. Salir.
Seleccione una opcion:

Este menu nos data la opcion de regristrarse solicitando su nit, luego de esto se solicitara su rol para atender una de las siguientes colas:

-----------------SELECCION DE ROL-----------------
 1. Mesa de ayuda. 
 2. Soporte Tecnico. 
 3. Desarrollo. 

Cada cola tendra 3 opciones, menos la cola de Desarollo que solo tendra opcion de asignar un ticket y resolverlo, a continuacion el menu de la mesa de ayuda:


--------------MESA DE AYUDA---------------
 1. Atender Ticket. 
 2. Resolver Ticket. 
 3. Escalar Ticket. 
Seleccione una opcion:

En este menu no se puede salir hasta que se solucione el ticket o bien este se escale.
La opcion 1 es Atender Ticket, esta opcion le pertine asignar un ticket para poder resolverlo o escalarlo, en dado caso no tuviera resolucion el problema.
Al resolver el ticket el programa le solicitara la solucion del problema, automaticamente este ticket saldra de la cola.
Al escalar el ticket el programa lo pasara a la siguiente cola y lo eliminara de la cola actual.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------MENU PRINCIPAL-------------------
 1. Cliente. 
 2. Empleado. 
 3. Reporte de Tickets. 
10. Salir.
Seleccione una opcion:

La opcion 3 es Reporte de Tickets, esta opcion le mostrara el siguiente menu:

------------------REPORTE DE TICKETS-------------------
 1. Mostrar listado general de tickets. 
 2. Mostrar tickets por cola. 
 3. Mostrar listado de tickets por usuario. 
10. Salir.
Seleccione una opcion:

Cada opcion mostrara un listado de los tickets y sus bitacoras para poder darle seguimiento a cada caso.
La opcion 1 mostrara todo los tickets que se hayan generado en el sistema.
La opcion 2 mostrara los tickets que estan en cada cola, incluidos los tickets ya resuletos.
La opcion 3 permitara buscar los tickets de un usuario ingresando su nit.

Abajo un ejemplo del listado de tickets general:

---------------LISTADO GENERAL DE TICKETS-------------
Ticket 000001 Ticket{nitUsuario='103990909', problema='PROBLEMA 1', estado='CREADO', bitacora=[Bitacora{nitSoporte=, fechaHora='2022/08/26 21:03', mensaje='El ticket 000001 a sido creado', evento=Ticket creado}, Bitacora{nitSoporte=11111111, fechaHora='2022/08/26 21:15', mensaje='El ticket a sido asignado a mesa de ayuda', evento=Ticket asignado}, Bitacora{nitSoporte=11111111, fechaHora='2022/08/26 21:15', mensaje='El ticket a sido escalado a la cola de Soporte Tecnico', evento=Ticket escalado}]}

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------MENU PRINCIPAL-------------------
 1. Cliente. 
 2. Empleado. 
 3. Reporte de Tickets. 
10. Salir.
Seleccione una opcion:

La opcion 10 le da la opcion de salir de cada menu, al seleccionar esta opcion en el menu principal finalizara el programa.
