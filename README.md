📌 Descripción del ProyectoEste proyecto es una plataforma distribuida desarrollada en Java para la simulación concurrente de una red eléctrica inteligente (Smart Grid) y la monitorización remota de métricas y precios energéticos en tiempo real mediante gRPC. Combina la gestión de concurrencia multihilo con microservicios RPC basados en Protocol Buffers para la comunicación entre el control de la red y los clientes de supervisión.   

🛠️ Estructura y Módulos
  1. Módulo mysmartttttgridddd (Motor de Simulación Concurrente)Se encarga de la simulación del flujo de energía y el procesamiento multihilo de las solicitudes energéticas:
      Modelado de Red Eléctrica: Gestiona la distribución entre zonas energéticas (ZonaEnergetica), operadores de red (OperadorDeRed) y peticiones de consumo (CanalConsumo, Demanda, TicketEnergetico).
      Sistemas de Almacenamiento: Modela acumuladores convencionales (Bateria) y sistemas de baterías de fuente renovable (BateriaRenovable).
      Procesamiento Paralelo: Asigna tareas de cómputo en segundo plano mediante ConsumoThread y evaluaciones asíncronas con ConsumoMaxCallable.
      Centro de Control: Supervisa y distribuye la carga mediante CentroControl y OperadorCarga.
      Persistencia de Consumos: Lee y procesa datos binarios de simulación (consumos2.bin, consumos3.bin, consumos5.bin).
  2. Módulo monitorizacion (Microservicios gRPC)Aloja la infraestructura cliente-servidor distribuida para el envío de métricas y actualización de precios:
    Gestión Dinámica de Precios: Proporciona servicios para consultar y actualizar tarifas energéticas (PrecioService, ActualizarPrecios).
    Telemetría de Red: Transmite datos de consumo, niveles de demanda y sentido del flujo energético en tiempo real (Monitorizacion).
    Contratos Protocol Buffers: Define los esquemas de mensajería gRPC a través de archivos .proto (actualizarPrecios.proto, monitorizacion.proto, precios.proto).
    Infraestructura RPC: Implementa el servidor gRPC (HelloServer) y stubs auto-generados para clientes de supervisión.


💻 Tecnologías UtilizadasLenguaje: Java 8+.   

Gestión del Proyecto: Apache Maven (pom.xml).   
Comunicación Distribuida: gRPC y Protocol Buffers (protobuf).   
Programación Concurrente: java.util.concurrent (ExecutorService, Callable, Threads, Mutexes).   
Interfaz Gráfica / Utilidades: Java Swing / AWT (Ventana).   
