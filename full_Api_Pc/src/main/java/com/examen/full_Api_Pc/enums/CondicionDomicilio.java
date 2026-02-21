package com.examen.full_Api_Pc.enums;

public enum CondicionDomicilio {
    HABIDO,
    NO_HABIDO,
    PENDIENTE,
    DESCONOCIDO;
    public static CondicionDomicilio fromProvider(String s){
        if(s == null) return DESCONOCIDO;
        String x = s.trim().toUpperCase().replace(' ','_');
        return switch (x){
            case "HABIDO" -> HABIDO;
            case "NO_HABIDO" -> NO_HABIDO;
            case "PENDIENTE" -> PENDIENTE;
            default -> DESCONOCIDO;
        };
    }
}
