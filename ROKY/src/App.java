import java.util.ArrayList;
import java.util.Scanner;

import plantas.Higrofitas;
import plantas.Mesofitas;
import plantas.Planta;
import plantas.Xerofitas;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Huerto> huertos = crearHuertos();
        Gestion gestion = new Gestion(huertos);
        ArrayList<String> registroFinal = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();

            int opcion = leerEntero(sc);
            switch (opcion) {
                case 1:
                    registrarSeleccion(sc, huertos, gestion, registroFinal);
                    break;
                case 2:
                    anadirHuerto(sc, huertos, registroFinal);
                    break;
                case 3:
                    quitarHuerto(sc, huertos, gestion, registroFinal);
                    break;
                case 4:
                    anadirPlantaAHuerto(sc, huertos, gestion, registroFinal);
                    break;
                case 5:
                    quitarPlantaDeHuerto(sc, huertos, gestion, registroFinal);
                    break;
                case 6:
                    mostrarDetalleRiego(sc, huertos, gestion, registroFinal);
                    break;
                case 7:
                    mostrarRegistroFinal(registroFinal);
                    break;
                case 8:
                    gestion.mostrarHuertos();
                    break;
                case 9:
                    continuar = false;
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== Gestion de huertos =====");
        System.out.println("1. Seleccionar huerto y planta");
        System.out.println("2. Anadir huerto");
        System.out.println("3. Quitar huerto");
        System.out.println("4. Anadir planta a un huerto");
        System.out.println("5. Quitar planta de un huerto");
        System.out.println("6. Mostrar detalle y riego");
        System.out.println("7. Mostrar registro final");
        System.out.println("8. Mostrar huertos disponibles");
        System.out.println("9. Salir");
        System.out.print("Elige una opcion: ");
    }

    private static ArrayList<Huerto> crearHuertos() {
        ArrayList<Huerto> huertos = new ArrayList<>();

        Huerto huertoSeco = new Huerto("Huerto seco", 30, 80);
        huertoSeco.añadirPlanta(new Xerofitas("Cactus", 15, 1.2, 4, true, true));
        huertoSeco.añadirPlanta(new Xerofitas("Aloe vera", 10, 1.5, 3, true, false));

        Huerto huertoTemplado = new Huerto("Huerto templado", 40, 120);
        huertoTemplado.añadirPlanta(new Mesofitas("Tomate", 3, 4.0, 5, true));
        huertoTemplado.añadirPlanta(new Mesofitas("Lechuga", 2, 2.5, 4, false));

        Huerto huertoHumedo = new Huerto("Huerto humedo", 35, 150);
        huertoHumedo.añadirPlanta(new Higrofitas("Arroz", 1, 3.0, 6, true));
        huertoHumedo.añadirPlanta(new Higrofitas("Helecho", 2, 2.0, 5, true));

        huertos.add(huertoSeco);
        huertos.add(huertoTemplado);
        huertos.add(huertoHumedo);

        return huertos;
    }

    private static void registrarSeleccion(Scanner sc, ArrayList<Huerto> huertos, Gestion gestion,
            ArrayList<String> registroFinal) {
        Huerto huertoSeleccionado = seleccionarHuerto(sc, huertos, gestion);

        if (huertoSeleccionado == null) {
            System.out.println("No se encontro el huerto solicitado.");
        } else {
            gestion.setHuertoTrabajado(huertoSeleccionado);
            Planta plantaSeleccionada = seleccionarPlanta(sc, gestion.getHuertoTrabajado());

            if (plantaSeleccionada == null) {
                System.out.println("No se encontro la planta solicitada.");
            } else {
                gestion.setPlantaTrabajada(plantaSeleccionada);
                registroFinal.add(crearRegistroSeleccion(gestion));
                System.out.println("Registro agregado correctamente.");
            }
        }
    }
    private static Huerto seleccionarHuerto(Scanner sc, ArrayList<Huerto> huertos, Gestion gestion) {
        Huerto huertoSeleccionado = null;

        System.out.println("\nHuertos disponibles:");
        gestion.mostrarHuertos();
        System.out.print("Escribe el nombre del huerto: ");
        String seleccion = sc.nextLine().trim();

        for (Huerto huerto : huertos) {
            if (huerto.getNombre().equalsIgnoreCase(seleccion)) {
                huertoSeleccionado = huerto;
            }
        }

        return huertoSeleccionado;
    }
    private static Planta seleccionarPlanta(Scanner sc, Huerto huerto) {
        Planta plantaSeleccionada = null;

        System.out.println("\nPlantas disponibles en " + huerto.getNombre() + ":");
        huerto.mostrarPlantas();
        System.out.print("Escribe el nombre de la planta: ");
        String seleccion = sc.nextLine().trim();

        for (Planta planta : huerto.getPlantas()) {
            if (planta.getNombre().equalsIgnoreCase(seleccion)) {
                plantaSeleccionada = planta;
            }
        }

        return plantaSeleccionada;
    }

    private static void anadirHuerto(Scanner sc, ArrayList<Huerto> huertos, ArrayList<String> registroFinal) {
        System.out.print("Nombre del nuevo huerto: ");
        String nombre = sc.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacio.");
        } else if (buscarHuertoPorNombre(huertos, nombre) != null) {
            System.out.println("Ya existe un huerto con ese nombre.");
        } else {
            double area = leerDouble(sc, "Area del huerto en m^2: ");
            double litrosAgua = leerDouble(sc, "Litros de agua disponibles: ");
            Huerto nuevoHuerto = new Huerto(nombre, area, litrosAgua);

            nuevoHuerto.setNombre(nombre);
            nuevoHuerto.setAreaHuerto(area);
            nuevoHuerto.setLitrosAgua(litrosAgua);
            nuevoHuerto.actualizarAguaAConsumir();

            huertos.add(nuevoHuerto);
            registroFinal.add("Huerto anadido: " + nuevoHuerto.getNombre() + " | Area: "
                    + nuevoHuerto.getAreaHuerto() + "m^2 | Agua disponible: " + nuevoHuerto.getLitrosAgua()
                    + "L");
            System.out.println("Huerto anadido correctamente.");
        }
    }
    private static void quitarHuerto(Scanner sc, ArrayList<Huerto> huertos, Gestion gestion,
            ArrayList<String> registroFinal) {
        Huerto huerto = seleccionarHuerto(sc, huertos, gestion);

        if (huerto == null) {
            System.out.println("No se encontro el huerto solicitado.");
        } else {
            gestion.setHuertoTrabajado(huerto);
            huertos.remove(gestion.getHuertoTrabajado());
            registroFinal.add("Huerto quitado: " + gestion.getHuertoTrabajado().getNombre());
            System.out.println("Huerto quitado correctamente.");
        }
    }
    private static void anadirPlantaAHuerto(Scanner sc, ArrayList<Huerto> huertos, Gestion gestion,
            ArrayList<String> registroFinal) {
        Huerto huerto = seleccionarHuerto(sc, huertos, gestion);

        if (huerto == null) {
            System.out.println("No se encontro el huerto solicitado.");
        } else {
            gestion.setHuertoTrabajado(huerto);
            Planta planta = crearPlanta(sc);

            if (planta == null) {
                System.out.println("No se pudo crear la planta.");
            } else {
                gestion.setPlantaTrabajada(planta);
                int cantidadAntes = gestion.getHuertoTrabajado().getPlantas().size();

                gestion.getHuertoTrabajado().añadirPlanta(gestion.getPlantaTrabajada());

                if (gestion.getHuertoTrabajado().getPlantas().size() > cantidadAntes) {
                    registroFinal.add("Planta anadida: " + gestion.getPlantaTrabajada().getNombre()
                            + " | Huerto: " + gestion.getHuertoTrabajado().getNombre());
                    System.out.println("Planta anadida correctamente.");
                }
            }
        }
    }
    private static void quitarPlantaDeHuerto(Scanner sc, ArrayList<Huerto> huertos, Gestion gestion,
            ArrayList<String> registroFinal) {
        Huerto huerto = seleccionarHuerto(sc, huertos, gestion);

        if (huerto == null) {
            System.out.println("No se encontro el huerto solicitado.");
        } else if (huerto.getPlantas().isEmpty()) {
            System.out.println("Ese huerto no tiene plantas para quitar.");
        } else {
            gestion.setHuertoTrabajado(huerto);
            Planta planta = seleccionarPlanta(sc, gestion.getHuertoTrabajado());

            if (planta == null) {
                System.out.println("No se encontro la planta solicitada.");
            } else {
                gestion.setPlantaTrabajada(planta);
                gestion.getHuertoTrabajado().getPlantas().remove(gestion.getPlantaTrabajada());
                registroFinal.add("Planta quitada: " + gestion.getPlantaTrabajada().getNombre()
                        + " | Huerto: " + gestion.getHuertoTrabajado().getNombre());
                System.out.println("Planta quitada correctamente.");
            }
        }
    }
    private static Planta crearPlanta(Scanner sc) {

        Planta planta = null;

        System.out.println("\nTipo de planta:");
        System.out.println("1. Xerofita");
        System.out.println("2. Mesofita");
        System.out.println("3. Higrofita");
        System.out.print("Elige una opcion: ");
        int tipo = leerEntero(sc);

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de planta no valido.");
        } else {
            System.out.print("Nombre de la planta: ");
            String nombre = sc.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacio.");
            } else {
                double tiempoSinAgua = leerDouble(sc, "Dias que tolera sin agua: ");
                double crecimientoSemanal = leerDouble(sc, "Crecimiento semanal en cm: ");
                double areaSolicitada = leerDouble(sc, "Area solicitada en m^2: ");

                switch (tipo) {
                    case 1:
                        boolean talloGrueso = leerBoolean(sc, "Tiene tallo grueso? (s/n): ");
                        boolean espinas = leerBoolean(sc, "Tiene espinas? (s/n): ");
                        Xerofitas xerofita = new Xerofitas(nombre, tiempoSinAgua, crecimientoSemanal,
                                areaSolicitada, talloGrueso, espinas);
                        xerofita.setTallo_grueso(talloGrueso);
                        xerofita.setEspinas(espinas);
                        planta = xerofita;
                        break;
                    case 2:
                        boolean raicesLargas = leerBoolean(sc, "Tiene raices largas? (s/n): ");
                        Mesofitas mesofita = new Mesofitas(nombre, tiempoSinAgua, crecimientoSemanal,
                                areaSolicitada, raicesLargas);
                        mesofita.setRaices_largas(raicesLargas);
                        planta = mesofita;
                        break;
                    case 3:
                        boolean hojasGrandes = leerBoolean(sc, "Tiene hojas grandes? (s/n): ");
                        Higrofitas higrofita = new Higrofitas(nombre, tiempoSinAgua, crecimientoSemanal,
                                areaSolicitada, hojasGrandes);
                        higrofita.setHojas_grandes(hojasGrandes);
                        planta = higrofita;
                        break;
                    default:
                        break;
                }

                if (planta != null) {
                    planta.setNombre(nombre);
                    planta.setTiempoSinAgua(tiempoSinAgua);
                    planta.setCrecimiento_semanal(crecimientoSemanal);
                }
            }
        }

        return planta;
    }
    
    private static void mostrarDetalleRiego(Scanner sc, ArrayList<Huerto> huertos, Gestion gestion,
            ArrayList<String> registroFinal) {
        Huerto huerto = seleccionarHuerto(sc, huertos, gestion);

        if (huerto == null) {
            System.out.println("No se encontro el huerto solicitado.");
        } else if (huerto.getPlantas().isEmpty()) {
            System.out.println("Ese huerto no tiene plantas registradas.");
        } else {
            gestion.setHuertoTrabajado(huerto);
            Planta planta = seleccionarPlanta(sc, gestion.getHuertoTrabajado());

            if (planta == null) {
                System.out.println("No se encontro la planta solicitada.");
            } else {
                gestion.setPlantaTrabajada(planta);
                double diasSinRiego = leerDouble(sc, "Dias desde el ultimo riego: ");
                int semanas = leerEnteroConMensaje(sc, "Semanas para estimar crecimiento: ");

                System.out.println("\nDetalle de la planta:");
                gestion.getPlantaTrabajada().darInfoFinal();
                System.out.println();
                System.out.println("Crecimiento estimado: "
                        + gestion.getPlantaTrabajada().crecimientoEstimado(semanas) + " cm");
                System.out.println("Necesita riego: "
                        + gestion.getPlantaTrabajada().cumple(
                                gestion.getPlantaTrabajada().necesitaRiego(diasSinRiego)));
                System.out.println("\nRevision del huerto:");
                gestion.getHuertoTrabajado().mostrarNecesidadRiego(diasSinRiego);

                registroFinal.add("Revision de riego | Huerto: " + gestion.getHuertoTrabajado().getNombre()
                        + " | Planta: " + gestion.getPlantaTrabajada().getNombre()
                        + " | Necesita riego: "
                        + gestion.getPlantaTrabajada().cumple(
                                gestion.getPlantaTrabajada().necesitaRiego(diasSinRiego)));
            }
        }
    }
    private static Huerto buscarHuertoPorNombre(ArrayList<Huerto> huertos, String nombre) {
        Huerto huertoEncontrado = null;

        for (Huerto huerto : huertos) {
            if (huerto.getNombre().equalsIgnoreCase(nombre)) {
                huertoEncontrado = huerto;
            }
        }

        return huertoEncontrado;
    }
    private static String crearRegistroSeleccion(Gestion gestion) {
        Planta planta = gestion.getPlantaTrabajada();

        return "Seleccion realizada | Huerto: " + gestion.getHuertoTrabajado().getNombre()
                + " | Planta: " + planta.getNombre()
                + "\n" + planta.infoBasica()
                + "\nTiempo sin agua: " + planta.getTiempoSinAgua()
                + " | Crecimiento semanal: " + planta.getCrecimiento_semanal()
                + " | Area: " + planta.getAreaSolicitada()
                + " | Litros: " + planta.getLitrosAguaNecesitados();
    }
    private static void mostrarRegistroFinal(ArrayList<String> registroFinal) {
        System.out.println("\n===== Registro final =====");

        if (registroFinal.isEmpty()) {
            System.out.println("Aun no hay selecciones registradas.");
        } else {
            for (int i = 0; i < registroFinal.size(); i++) {
                System.out.println((i + 1) + ". " + registroFinal.get(i));
            }
        }
    }

    //Esto es para no romperme la cabeza
    private static int leerEntero(Scanner sc) {
        int numero = -1;

        try {
            numero = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Ingresa un numero valido.");
        }

        return numero;
    }
    private static int leerEnteroConMensaje(Scanner sc, String mensaje) {
        int numero = -1;

        while (numero < 0) {
            System.out.print(mensaje);
            numero = leerEntero(sc);

            if (numero < 0) {
                System.out.println("Ingresa un numero valido.");
            }
        }

        return numero;
    }
    private static double leerDouble(Scanner sc, String mensaje) {
        boolean numeroValido = false;
        double numero = 0;

        while (!numeroValido) {
            System.out.print(mensaje);

            try {
                numero = Double.parseDouble(sc.nextLine().trim());
                numeroValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero valido.");
            }
        }

        return numero;
    }
    private static boolean leerBoolean(Scanner sc, String mensaje) {
        boolean respuestaValida = false;
        boolean valor = false;

        while (!respuestaValida) {
            System.out.print(mensaje);
            String respuesta = sc.nextLine().trim();

            if (respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("si")) {
                valor = true;
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("n") || respuesta.equalsIgnoreCase("no")) {
                valor = false;
                respuestaValida = true;
            } else {
                System.out.println("Responde con s o n.");
            }
        }

        return valor;
    }
}
