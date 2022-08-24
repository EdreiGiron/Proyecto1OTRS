//7690-21-21 EDREI GIRON

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Random;

public class Prueba {

    public static void main(String[] args) {

        Prueba prueba = new Prueba();
        ArrayList<Ticket> listadoTicketsGeneral = new ArrayList<Ticket>();
        ArrayList<Ticket> listadoTicketsMesa = new ArrayList<Ticket>();
        ArrayList<Ticket> listadoTicketsSoporte = new ArrayList<Ticket>();
        ArrayList<Ticket> listadoTicketsDesarrollo = new ArrayList<Ticket>();
        ArrayList<Ticket> listadoTicketsAtendidos = new ArrayList<Ticket>();

        ArrayList<ArrayList<Bitacora>> listadoListadoBitacoras = new ArrayList<>();
        ColaMesa colaMesa = new ColaMesa(listadoTicketsMesa, TipoCola.MESADEAYUDA);
        ColaSoporte colaSoporte = new ColaSoporte(listadoTicketsSoporte, TipoCola.SOPORTETECNICO);
        ColaDesarrollo colaDesarrollo = new ColaDesarrollo(listadoTicketsDesarrollo, TipoCola.DESARROLLADOR);
        ColaAtendidos colaAtendidos = new ColaAtendidos(listadoTicketsAtendidos, TipoCola.ATENDIDOS);
        Random random = new Random();
        int finalizarPrograma = 0;
        int opcion = 0;
        int contadorBitacoras = 0;
        int numeroTicketAleatorio = 0;

        DateTimeFormatter fechaActual = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
       //System.out.println("yyyy/MM/dd HH:mm-> "+fechaActual.format(LocalDateTime.now()));

        Scanner entrada = new Scanner(System.in);
        Scanner lecturaCadena = new Scanner(System.in);

        while (finalizarPrograma != 1) {
            prueba.menuPrincipal();
            try {
                opcion = entrada.nextInt();
            } catch (Exception e) {
                System.out.println("Opcion no valida.");
                entrada = new Scanner(System.in);
            }

            switch (opcion) {
                case 1://CLIENTES
                    prueba.menuClientes();
                    opcion = entrada.nextInt();
                    switch(opcion){

                        case 1://REPORTAR PROBLEMA EN EL PROGRAMA

                            String nitCliente = "";
                            ArrayList<Bitacora> listadoBitacoras = new ArrayList<Bitacora>();

                            while((nitCliente.length()!=8)&&(nitCliente.length()!=9)){
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("--------------REPORTAR DE PROBLEMA---------------");
                                System.out.println("Por favor proporcione los siguientes datos.\n");
                                System.out.println("Ingrese su NIT: ");
                                nitCliente = lecturaCadena.nextLine();
                                if((nitCliente.length()!=8)&&(nitCliente.length()!=9)){
                                    System.out.println("El NIT no contiene entre 8-9 digitos!");
                                    System.out.println("\nPresiona la tecla Enter para continuar...");
                                    new java.util.Scanner(System.in).nextLine();
                                }//FIN IF NIT
                            }//FIN WHILE NIT

                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("Por favor detalle el problema presentado: ");
                            String problema = lecturaCadena.nextLine();

                            listadoListadoBitacoras.add(listadoBitacoras); //AGREGAMOS EL LISTADO DE LA BITACORA DEL TICKET AL LISTADO DE LISTADO DE BITACORAS

                            Ticket ticket = new Ticket(contadorBitacoras+1,nitCliente,problema,"CREADO", listadoListadoBitacoras.get(contadorBitacoras)); //SE CREA EL TICKET CON LOS DATOS ANTERIORMENTE PROPORCIONADOS
                            listadoTicketsGeneral.add(contadorBitacoras, ticket); //SE INGRESA EL TICKET A LA LISTA

                            Formatter correlativoConFormato = new Formatter();
                            correlativoConFormato.format("%06d",ticket.getId());//CREANDO EL FORMATO QUE TENDRA EL TICKET

                            Bitacora bitacora = new Bitacora("", fechaActual.format(LocalDateTime.now()),"El ticket "+correlativoConFormato +" a sido creado",TipoEvento.CREARTICKET);
                            listadoTicketsGeneral.get(contadorBitacoras).BitacoraTicket(bitacora); //CREANDO EL EVENTO DE CREACION DEL NUEVO TICKET
                            colaMesa.agregar(listadoTicketsGeneral.get(contadorBitacoras)); //AGREGANDO EL TICKET A LA COLA DE MESA DE AYUDA

                            contadorBitacoras++;//CONTAREMOS LAS BITACORAS PARA ASIGNARLA ESPECIFICAMENTE A UN TICKET

                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("El ticket " +correlativoConFormato+" a sido creado exitosamente!" );
                            System.out.println("\nPresiona la tecla Enter para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 10://REGRESAR MENU ANTERIOR
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            break;

                        default:
                            System.out.println("Opcion invalida!");
                            System.out.println("\nPresiona la tecla Enter para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;
                    }//FIN MENU CLIENTES
                    break;

                case 2://EMPLEADOS
                    prueba.menuEmpleados();
                    opcion = entrada.nextInt();

                    switch(opcion){ //EMPLEADOS

                        case 1://ATENDER TICKET MESA AYUDA
                            String nitEmpleado = "";
                            while((nitEmpleado.length()!=8)&&(nitEmpleado.length()!=9)){
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("--------------REGISTRAR EMPLEADO---------------");
                                System.out.println("Por favor proporcione los siguientes datos.\n");
                                System.out.println("Ingrese su NIT: ");
                                nitEmpleado = lecturaCadena.nextLine();
                                if((nitEmpleado.length()!=8)&&(nitEmpleado.length()!=9)){
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("El NIT no contiene entre 8-9 digitos!");
                                    System.out.println("\nPresiona la tecla Enter para continuar...");
                                    new java.util.Scanner(System.in).nextLine();
                                }//FIN IF NIT
                            }//FIN WHILE NIT
                            int opcionRol = 0;
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("-----------------SELECCION DE ROL-----------------");
                            System.out.println(" 1. Mesa de ayuda. ");
                            System.out.println(" 2. Soporte Tecnico. ");
                            System.out.println(" 3. Desarrollo. ");
                            opcionRol = entrada.nextInt();

                            int ticketAsignado = 0;//CUANDO UN TICKET ES ASIGNADO YA NO PUEDE VOLVER A ASIGNARSE
                            int ticketAtendido=0; //SI EL TICKET NO ES ATENDIDO NO SE PODRA SALIR DEL MENU

                        do{
                            switch(opcionRol) { //SELECCION DE ROL DEL EMPLEADO
                                case 1://MESA DE AYUDA
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("--------------MESA DE AYUDA---------------");
                                    System.out.println(" 1. Atender Ticket. ");
                                    System.out.println(" 2. Resolver Ticket. ");
                                    System.out.println(" 3. Escalar Ticket. ");
                                    System.out.println("Seleccione una opcion:");
                                    opcion = entrada.nextInt();

                                    switch (opcion) {

                                        case 1: //ATENDER TICKET
                                            if(ticketAsignado==0) { //SI EL TICKET NO SE A ASIGNADO A NINGUN EMPLEADO
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                //CREANDO LA BITACORA DE ASIGNACION
                                                colaMesa.getCola().get(0).BitacoraTicket(new Bitacora(nitEmpleado, fechaActual.format(LocalDateTime.now()), "El ticket a sido asignado a mesa de ayuda", TipoEvento.ASIGNAR));
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                Formatter correlativoConFormato = new Formatter();
                                                correlativoConFormato.format("%06d", colaMesa.getCola().get(0).getId());//CREANDO EL FORMATO QUE TENDRA EL TICKET
                                                System.out.println("El ticket " + correlativoConFormato + " a sido asignado a " + nitEmpleado + ". El problema reportado es: " + colaMesa.getCola().get(0).getProblema());
                                                System.out.println("\nPresiona la tecla Enter para continuar...");
                                                new java.util.Scanner(System.in).nextLine();
                                                ticketAsignado = 1;
                                            }else{ //SI EL TICKET YA FUE ASIGNADO
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                Formatter correlativoConFormato = new Formatter();
                                                correlativoConFormato.format("%06d", colaMesa.getCola().get(0).getId());//CREANDO EL FORMATO QUE TENDRA EL TICKET
                                                System.out.println("El ticket " + correlativoConFormato + " ya fue asignado a  " + nitEmpleado);
                                                System.out.println("\nPresiona la tecla Enter para continuar...");
                                                new java.util.Scanner(System.in).nextLine();
                                                break;
                                            }break;


                                        case 2: //RESOLVER TICKET
                                            if (ticketAsignado==1) {
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                System.out.println("Problema reportado: " + colaMesa.getCola().get(0).getProblema());
                                                System.out.println("A continuacion ingrese cual fue la solucion del problema");
                                                String solucionProblema = lecturaCadena.nextLine();
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                System.out.println("El ticket se a solucionado exitosamente!");
                                                System.out.println("\nPresiona la tecla Enter para continuar...");
                                                new java.util.Scanner(System.in).nextLine();
                                                //CREANDO LA BITACORA DE RESOLUCION
                                                colaMesa.getCola().get(0).BitacoraTicket(new Bitacora(nitEmpleado, fechaActual.format(LocalDateTime.now()), "El ticket a sido resulto en la mesa de ayuda. Solucion: " + solucionProblema, TipoEvento.SOLUCION));
                                                colaMesa.getCola().get(0).setEstado("RESULETO"); //CAMBIAMOS EL ESTADO DEL TICKET
                                                colaAtendidos.agregar(colaMesa.getCola().get(0)); //AGREGAR TICKET A COLA ATENDIDOS
                                                colaMesa.quitar(colaMesa.getCola().get(0)); //ELIMINAMOS EL TICKET DE LA COLA MESA
                                                ticketAtendido = 1;

                                            }else{
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                System.out.println("No se a asignado ningun ticket!");
                                                System.out.println("\nPresiona la tecla Enter para continuar...");
                                                new java.util.Scanner(System.in).nextLine();
                                                break;
                                            }break;

                                        case 3: //ESCALAR TICKET
                                            if (ticketAsignado==1){
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                            System.out.println("Problema reportado: "+colaMesa.getCola().get(0).getProblema());
                                            System.out.println("\nPresiona la tecla Enter para continuar...\n");
                                            new java.util.Scanner(System.in).nextLine();
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                            System.out.println("El ticket se a escalado exitosamente!");
                                            System.out.println("\nPresiona la tecla Enter para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            //CREANDO LA BITACORA DE EL ESCALADO A OTRA COLA
                                            colaMesa.getCola().get(0).BitacoraTicket(new Bitacora(nitEmpleado, fechaActual.format(LocalDateTime.now()), "El ticket a sido escalado a la cola de Soporte Tecnico", TipoEvento.MOVER));
                                            colaSoporte.agregar(colaMesa.getCola().get(0)); //AGREGAR TICKET A COLA SOPORTE TECNICO
                                            colaMesa.quitar(colaMesa.getCola().get(0)); //ELIMINAMOS EL TICKET DE LA COLA MESA
                                            ticketAtendido=1;
                                        }else{
                                             System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                             System.out.println("No se a asignado ningun ticket!");
                                             System.out.println("\nPresiona la tecla Enter para continuar...");
                                             new java.util.Scanner(System.in).nextLine();
                                             break;
                                            }break;

                                        default:
                                            System.out.println("Opcion invalida!");
                                            System.out.println("\nPresiona la tecla Enter para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            break;
                                    }//FIN OPCIONES MESA AYUDA
                                    break;//FIN MESA AYUDA

                                case 2://SOPORTE TECNICO
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("--------------SOPORTE TECNICO---------------");
                                    System.out.println(" 1. Atender Ticket. ");
                                    System.out.println(" 2. Resolver Ticket. ");
                                    System.out.println(" 3. Escalar Ticket. ");
                                    System.out.println("Seleccione una opcion:");
                                    opcion = entrada.nextInt();

                                    switch (opcion) {

                                        case 1: //ATENDER TICKET
                                            if(ticketAsignado==0) { //SI EL TICKET NO SE A ASIGNADO A NINGUN TECNICO
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                //CREANDO LA BITACORA DE ASIGNACION
                                                colaSoporte.getCola().get(colaSoporte.getCola().size()-1).BitacoraTicket(new Bitacora(nitEmpleado, fechaActual.format(LocalDateTime.now()), "El ticket a sido asignado a Soporte Tecnico", TipoEvento.ASIGNAR));
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                Formatter correlativoConFormato = new Formatter();
                                                correlativoConFormato.format("%06d", colaSoporte.getCola().get(colaSoporte.getCola().size()-1).getId());//CREANDO EL FORMATO QUE TENDRA EL TICKET
                                                System.out.println("El ticket " + correlativoConFormato + " a sido asignado a " + nitEmpleado + ". El problema reportado es: " + colaSoporte.getCola().get(colaSoporte.getCola().size()-1).getProblema());
                                                System.out.println("\nPresiona la tecla Enter para continuar...");
                                                new java.util.Scanner(System.in).nextLine();
                                                ticketAsignado = 1;

                                            }else{ //SI EL TICKET YA FUE ASIGNADO
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                Formatter correlativoConFormato = new Formatter();
                                                correlativoConFormato.format("%06d", colaSoporte.getCola().get(colaSoporte.getCola().size()-1).getId());//CREANDO EL FORMATO QUE TENDRA EL TICKET
                                                System.out.println("El ticket " + correlativoConFormato + " ya fue asignado a " + nitEmpleado);
                                                System.out.println("\nPresiona la tecla Enter para continuar...");
                                                new java.util.Scanner(System.in).nextLine();
                                                break;
                                            }break;


                                        case 2: //RESOLVER TICKET
                                            if (ticketAsignado==1){
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                            System.out.println("Problema reportado: "+colaSoporte.getCola().get(colaSoporte.getCola().size()-1).getProblema());
                                            System.out.println("A continuacion ingrese cual fue la solucion del problema");
                                            String solucionProblema = lecturaCadena.nextLine();
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                            System.out.println("El ticket se a solucionado exitosamente!");
                                            System.out.println("\nPresiona la tecla Enter para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            //CREANDO LA BITACORA DE RESOLUCION
                                            colaSoporte.getCola().get(colaSoporte.getCola().size()-1).BitacoraTicket(new Bitacora(nitEmpleado, fechaActual.format(LocalDateTime.now()), "El ticket a sido resulto en soporte tecnico. Solucion: "+solucionProblema, TipoEvento.SOLUCION));
                                            colaSoporte.getCola().get(colaSoporte.getCola().size()-1).setEstado("RESULETO"); //CAMBIAMOS EL ESTADO DEL TICKET
                                            colaAtendidos.agregar(colaSoporte.getCola().get(colaSoporte.getCola().size()-1)); //AGREGAR TICKET A COLA ATENDIDOS
                                            colaSoporte.quitar(colaSoporte.getCola().get(colaSoporte.getCola().size()-1)); //ELIMINAMOS EL TICKET DE LA COLA SOPORTE
                                            ticketAtendido=1;

                                        }else{
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                            System.out.println("No se a asignado ningun ticket!");
                                            System.out.println("\nPresiona la tecla Enter para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            break;
                                        }break;

                                        case 3: //ESCALAR TICKET
                                            if (ticketAsignado==1){
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                            System.out.println("Problema reportado: "+colaSoporte.getCola().get(colaSoporte.getCola().size()-1).getProblema());
                                            System.out.println("\nPresiona la tecla Enter para continuar...\n");
                                            new java.util.Scanner(System.in).nextLine();
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                            System.out.println("El ticket se a escalado exitosamente!");
                                            System.out.println("\nPresiona la tecla Enter para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            //CREANDO LA BITACORA DE EL ESCALADO A OTRA COLA
                                            colaSoporte.getCola().get(colaSoporte.getCola().size()-1).BitacoraTicket(new Bitacora(nitEmpleado, fechaActual.format(LocalDateTime.now()), "El ticket a sido escalado a la cola de Desarrollo", TipoEvento.MOVER));
                                            colaDesarrollo.agregar(colaSoporte.getCola().get(colaSoporte.getCola().size()-1)); //AGREGAR TICKET A COLA DE DESARROLLO
                                            colaSoporte.quitar(colaSoporte.getCola().get(colaSoporte.getCola().size()-1)); //ELIMINAMOS EL TICKET DE LA COLA SOPORTE
                                            ticketAtendido=1;

                                            }else{
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                System.out.println("No se a asignado ningun ticket!");
                                                System.out.println("\nPresiona la tecla Enter para continuar...");
                                                new java.util.Scanner(System.in).nextLine();
                                                break;
                                            }break;

                                        default:
                                            System.out.println("Opcion invalida!");
                                            System.out.println("\nPresiona la tecla Enter para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            break;
                                    }//FIN OPCIONES SOPORTE TECNICO
                                    break;//FIN SOPORTE TECNICO

                                case 3://DESARROLLO
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("--------------DESARROLLO---------------");
                                    System.out.println(" 1. Atender Ticket. ");
                                    System.out.println(" 2. Resolver Ticket. ");
                                    System.out.println("Seleccione una opcion:");
                                    opcion = entrada.nextInt();

                                    switch (opcion) {

                                        case 1: //ATENDER TICKET
                                            if(ticketAsignado==0) { //SI EL TICKET NO SE A ASIGNADO A NINGUN TECNICO
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                //CREANDO LA BITACORA DE ASIGNACION
                                                numeroTicketAleatorio = random.nextInt(colaDesarrollo.getCola().size());
                                                colaDesarrollo.getCola().get(numeroTicketAleatorio).BitacoraTicket(new Bitacora(nitEmpleado, fechaActual.format(LocalDateTime.now()), "El ticket a sido asignado a Desarrollo", TipoEvento.ASIGNAR));
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                Formatter correlativoConFormato = new Formatter();
                                                correlativoConFormato.format("%06d", colaDesarrollo.getCola().get(numeroTicketAleatorio).getId());//CREANDO EL FORMATO QUE TENDRA EL TICKET
                                                System.out.println("El ticket " + correlativoConFormato + " a sido asignado a " + nitEmpleado + ". El problema reportado es: " + colaDesarrollo.getCola().get(numeroTicketAleatorio).getProblema());
                                                System.out.println("\nPresiona la tecla Enter para continuar...");
                                                new java.util.Scanner(System.in).nextLine();
                                                ticketAsignado = 1;

                                            }else{ //SI EL TICKET YA FUE ASIGNADO
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                Formatter correlativoConFormato = new Formatter();
                                                correlativoConFormato.format("%06d", colaSoporte.getCola().get(numeroTicketAleatorio).getId());//CREANDO EL FORMATO QUE TENDRA EL TICKET
                                                System.out.println("El ticket " + correlativoConFormato + " ya fue asignado a " + nitEmpleado);
                                                System.out.println("\nPresiona la tecla Enter para continuar...");
                                                new java.util.Scanner(System.in).nextLine();

                                            }break;


                                        case 2: //RESOLVER TICKET
                                            if (ticketAsignado==1){
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                System.out.println("Problema reportado: "+colaDesarrollo.getCola().get(numeroTicketAleatorio).getProblema());
                                                System.out.println("A continuacion ingrese cual fue la solucion del problema");
                                                String solucionProblema = lecturaCadena.nextLine();
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                System.out.println("El ticket se a solucionado exitosamente!");
                                                System.out.println("\nPresiona la tecla Enter para continuar...");
                                                new java.util.Scanner(System.in).nextLine();
                                                //CREANDO LA BITACORA DE RESOLUCION
                                                colaDesarrollo.getCola().get(numeroTicketAleatorio).BitacoraTicket(new Bitacora(nitEmpleado, fechaActual.format(LocalDateTime.now()), "El ticket a sido resulto en desarrollo. Solucion: "+solucionProblema, TipoEvento.SOLUCION));
                                                colaDesarrollo.getCola().get(numeroTicketAleatorio).setEstado("RESULETO"); //CAMBIAMOS EL ESTADO DEL TICKET
                                                colaAtendidos.agregar(colaDesarrollo.getCola().get(numeroTicketAleatorio)); //AGREGAR TICKET A COLA ATENDIDOS
                                                colaDesarrollo.quitar(colaDesarrollo.getCola().get(numeroTicketAleatorio)); //ELIMINAMOS EL TICKET DE LA COLA DESARROLLO
                                                ticketAtendido=1;

                                            }else{
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                System.out.println("No se a asignado ningun ticket!");
                                                System.out.println("\nPresiona la tecla Enter para continuar...");
                                                new java.util.Scanner(System.in).nextLine();

                                            }break;

                                        default:
                                            System.out.println("Opcion invalida!");
                                            System.out.println("\nPresiona la tecla Enter para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            break;
                                    }//FIN OPCIONES SOPORTE TECNICO
                            }//FIN SELECCION DE ROL
                        }while(ticketAtendido==0); //FIN DO MESA AYUDA
                        break; //FIN MESA AYUDA

                        case 10://REGRESAR MENU ANTERIOR
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            break;

                        default:
                            System.out.println("Opcion invalida!");
                            System.out.println("\nPresiona la tecla Enter para continuar...");
                            new java.util.Scanner(System.in).nextLine();

                    }//FIN MENU EMPLEADOS
                    break;

                case 3: //MENU TICKETS
                    prueba.menuTickets();
                    opcion = entrada.nextInt();
                    switch(opcion){


                        case 1://MOSTRAR LISTADO GENERAL DE TICKETS
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            for(int i=0;i<listadoTicketsGeneral.size();i++){
                                System.out.println(listadoTicketsGeneral.get(i).toString()+"\n");
                        }
                            System.out.println("\nPresiona la tecla Enter para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 2://MOSTRAR TICKETS POR COLA
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("---------------MESA DE AYUDA-------------");
                            for(int i=0;i<colaMesa.getCola().size();i++){
                                System.out.println(colaMesa.getCola().get(i).toString()+"\n");
                            }
                            System.out.println("\nPresiona la tecla Enter para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("---------------SOPORTE TECNICO-------------");
                            for(int i=0;i<colaSoporte.getCola().size();i++){
                                System.out.println(colaSoporte.getCola().get(i).toString()+"\n");
                            }
                            System.out.println("\nPresiona la tecla Enter para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("---------------DESARROLLO-------------");
                            for(int i=0;i<colaDesarrollo.getCola().size();i++){
                                System.out.println(colaDesarrollo.getCola().get(i).toString()+"\n");
                            }
                            System.out.println("\nPresiona la tecla Enter para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("---------------TICKES ATENDIDOS-------------");
                            for(int i=0;i<colaAtendidos.getCola().size();i++){
                                System.out.println(colaAtendidos.getCola().get(i).toString()+"\n");
                            }
                            System.out.println("\nPresiona la tecla Enter para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 3://MOSTRAR LISTADO DE TICKETS POR CLIENTE
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("Ingrese el nit del usuario para mostrar sus tickets: ");
                            String nitUsuario= lecturaCadena.nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("------- "+nitUsuario+" -------");
                            for(int i=0;i<listadoTicketsGeneral.size();i++){
                                if (nitUsuario.equals(listadoTicketsGeneral.get(i).getNitUsuario())) {
                                    System.out.println(listadoTicketsGeneral.get(i).toString() + "\n");
                                }
                            }
                            System.out.println("\nPresiona la tecla Enter para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 10://REGRESAR MENU ANTERIOR
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            break;

                        default:
                            System.out.println("Opcion invalida!");
                            System.out.println("\nPresiona la tecla Enter para continuar...");
                            new java.util.Scanner(System.in).nextLine();

                    }//FIN MENU TICKETS
                    break;

                case 10://SALIR DEL PROGRAMA
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Hasta Pronto!");
                    finalizarPrograma = 1;
                    break;
                default:
                    System.out.println("");
            }//FIN MENU PRINCIPAL
        }//FIN WHILE
    }//FIN MAIN

    public void menuPrincipal(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------------------MENU PRINCIPAL-------------------");
        System.out.println(" 1. Cliente. ");
        System.out.println(" 2. Empleado. ");
        System.out.println(" 3. Reporte de Tickets. ");
        System.out.println("10. Salir.");
        System.out.println("Seleccione una opcion:");
    }//FIN MENU PRINCIPAL

    public void menuClientes(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------------------CLIENTES-------------------");
        System.out.println(" 1. Reportar Problema. ");
        System.out.println("10. Salir.");
        System.out.println("Seleccione una opcion:");
    }//FIN MENU

    public void menuEmpleados(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------------------EMPLEADOS-------------------");
        System.out.println(" 1. Registrar. ");
        System.out.println("10. Salir.");
        System.out.println("Seleccione una opcion:");
    }//FIN MENU

    public void menuTickets(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------------------REPORTE DE TICKETS-------------------");
        System.out.println(" 1. Mostrar listado general de tickets. ");
        System.out.println(" 2. Mostrar tickets por cola. ");
        System.out.println(" 3. Mostrar listado de tickets por usuario. ");
        System.out.println("10. Salir.");
        System.out.println("Seleccione una opcion:");
    }//FIN MENU

}//FIN CLASE PRUEBA
