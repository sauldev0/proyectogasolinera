package com.gasolineria.gasolinerasaul;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/proyectogasolinera")
public class StationsController {

    // Listas para almacenar las estaciones de servicio
    private final List<GasStation> stations = new ArrayList<>();

    // Constructor para inicializar la lista con datos de ejemplo
    public StationsController() {
        stations.add(new GasStation("Barinas", "Alto Barinas", "123-456-7890"));
        stations.add(new GasStation("Chevron", "5678 Elm St", "234-567-8901"));
        stations.add(new GasStation("Exxon", "9101 Oak St", "345-678-9012"));
    }

    // Endpoint para obtener todas las estaciones de servicio
    @GetMapping
    public List<GasStation> getStations() {
        return stations;
    }

    // Endpoint para obtener una estación específica por índice
    @GetMapping("/{index}")
    public GasStation getStation(@PathVariable int index) {
        if (index >= 0 && index < stations.size()) {
            return stations.get(index);
        } else {
            throw new IllegalArgumentException("Índice fuera de rango");
        }
    }

    // Endpoint para añadir una nueva estación de servicio
    @PostMapping
    public void addStation(@RequestBody GasStation station) {
        stations.add(station);
    }

    // Clase interna para representar las estaciones de servicio
    static class GasStation {
        private String name;
        private String address;
        private String phoneNumber;

        // Constructor vacío para Spring
        public GasStation() {}

        // Constructor con parámetros
        public GasStation(String name, String address, String phoneNumber) {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        // Getters y setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}
